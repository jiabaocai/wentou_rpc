package com.bwtservice.interceptor;

import com.bwtservice.entity.Config;
import com.bwtservice.entity.UserToken;
import com.bwtservice.entity.WtIpFilter;
import com.bwtservice.mapper.ConfigMapper;
import com.bwtservice.mapper.UserTokenMapper;
import com.bwtservice.mapper.WtIpFilterMapper;
import com.bwtservice.util.*;
import io.micrometer.core.instrument.util.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = Logger.getLogger(TokenInterceptor.class.getName());

    @Resource
    private UserTokenMapper userTokenMapper;

    @Resource
    private ConfigMapper configMapper;

    @Value("${appid.priKey}")
    private String priKey;

    @Value("${appid.pubKey}")
    private String pubKey;

    @Value("${environment.active}")
    private String active;

    @Autowired
    private WtIpFilterMapper ipFilterMapper;


    private WtIpFilter ipFilter;


    /**
     * @param request
     * @param response
     * @param handler  访问的目标方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Config> configList1 = configMapper.selectByPrimary("0", "IP_RESTRICT", active);
        if (configList1.size() > 0) {
            //当前环境下开启ip权限
            String ipAddress = IPUtils.getRealIP(request);
//        if (!"0:0:0:0:0:0:0:1".equals(ipAddress)) {
//            writeFailure(response, "没有权限", "500");
//            return false;
//        }
            LOG.info("USER IP ADDRESS IS =>" + ipAddress);
            if (!StringUtils.isNotBlank(ipAddress))
                return false;
            ipFilter = new WtIpFilter();
            ipFilter.setModule("cient-service");//模块
            ipFilter.setIp(ipAddress);//ip地址
            ipFilter.setMark(0);//白名单
            List<WtIpFilter> ips = ipFilterMapper.selectWtIpFilter(ipFilter);
            if (ips.size()<1) {
                writeFailure(response, "当前IP没有权限", "500");
                return false;
            }

            //签名权限
            List<Config> configList = configMapper.selectByPrimary("0", "RSA_ENERYPTION",active);
            if (configList.size() > 0) {
                //开启签名权限
                String url = request.getServletPath();
                if (Whitelist(url)) {
                    return true;
                }
                String token = request.getHeader("token");
                String timestamp = request.getHeader("timestamp");
                // 随机字符串
                String nonce = request.getHeader("nonce");
                String sign = request.getHeader("sign");
                boolean re = token != null && timestamp != null && nonce != null && sign != null;
                if (!re) {
                    writeFailure(response, "参数错误", "ERROR001");
                    return false;
                }
                //        Assert.isTrue(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(sign), "参数错误");
                // 获取超时时间
                NotRepeatSubmit notRepeatSubmit = ApiUtil.getNotRepeatSubmit(handler);
                long expireTime = notRepeatSubmit == null ? 60 * 5 * 1000 : notRepeatSubmit.value();

                // 2. 请求时间间隔
                long reqeustInterval = System.currentTimeMillis() - Long.valueOf(timestamp);
//        Assert.isTrue(reqeustInterval < expireTime, "请求超时，请重新请求");
                if (!(reqeustInterval < expireTime)) {
                    writeFailure(response, "请求超时，请重新请求", "ERROR002");
                    return false;
                }

                // 3. 校验Token是否存在
//        ValueOperations<String, TokenInfo> tokenRedis = redisTemplate.opsForValue();
//        TokenInfo tokenInfo = tokenRedis.get(token);

                UserToken userToken = userTokenMapper.selectByPrimaryToken(token);
                if (userToken == null) {
                    writeFailure(response, "token错误/过期", "ERROR003");
                    return false;
                }
//        TokenInfo tokenInfo = new TokenInfo();
//        if(tokenInfo==null){
//            writeFailure(response,"token错误/过期","ERROR003");
//            return false;
//        }
//        Assert.notNull(tokenInfo, "token错误");

                // 4. 校验签名(将所有的参数加进来，防止别人篡改参数) 所有参数看参数名升续排序拼接成url
                // 请求参数 + token + timestamp + nonce
                String signString = ApiUtil.concatSignString(request) + "token=" + token + "&timestamp=" + timestamp + "&nonce=" + nonce;
                String signature = MD5Util.encode(signString);
//        byte[] encrypted = AESUtils.aes128CBCEncrypt(signString.getBytes(), "123456", "123456");
                //签名解密成为md5
                byte[] jiemi = null;
                try {
                    jiemi = RSAUtils.decryptByPrivateKey(sign.getBytes(), priKey);
                } catch (Exception e) {
                    writeFailure(response, "签名解密异常", "ERROR005");
                    return false;
                }
                boolean flag = signature.equals(new String(jiemi));
                if (!flag) {
                    writeFailure(response, "签名错误", "ERROR004");
                    return false;
                }
//        Assert.isTrue(flag, "签名错误");

                // 5. 拒绝重复调用(第一次访问时存储，过期时间和请求超时时间保持一致), 只有标注不允许重复提交注解的才会校验
                if (notRepeatSubmit != null) {
////            ValueOperations<String, Integer> signRedis = redisTemplate.opsForValue();
//            boolean exists = redisTemplate.hasKey(sign);
//            Assert.isTzrue(!exists, "请勿重复提交");
//            signRedis.set(sign, 0, expireTime, TimeUnit.MILLISECONDS);
                }
                //签名权限



                ////////

                    writeFailure(response, "当前没有开启", "500");
                    return false;
                }else {
                return true;
            }



        } else {
            //ip权限没开启过滤所有限制
            return true;
        }
//        return super.preHandle(request, response, handler);
        //过滤ip,若用户在白名单内，则放行

    }


    private void writeFailure(HttpServletResponse response, String msg, String errorcode) throws IOException, JSONException {
        JSONObject result = new JSONObject();
        result.put("code", errorcode);
        result.put("msg", msg);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(result.toString());
        writer.flush();
        writer.close();

    }

    private boolean Whitelist(String url) {
        List<Config> list = configMapper.selectByPrimary("0", "API_URL",active);
        if (list.size() < 1) {
            return false;
        }
        for (Config str : list) {
            if (str.getUrl().contains(url)) {
                return true;
            }
        }
        return false;
    }
}
