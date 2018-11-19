package com.bwtservice.interceptor;

import com.bwtservice.entity.WtIpFilter;
import com.bwtservice.mapper.WtIpFilterMapper;
import com.bwtservice.util.IPUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

/**
 * CREATE BY caijiabao ON 2018/11/19
 **/

public class IPInterceptor implements HandlerInterceptor {
    private static final Logger LOG = Logger.getLogger(IPInterceptor.class.getName());


    @Autowired
    private WtIpFilterMapper ipFilterMapper;

    private WtIpFilter ipFilter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //过滤ip,若用户在白名单内，则放行
        String ipAddress = IPUtils.getRealIP(request);
        if ("0:0:0:0:0:0:0:1".equals(ipAddress)) {
            return true;
        }
        LOG.info("USER IP ADDRESS IS =>" + ipAddress);
        if (!StringUtils.isNotBlank(ipAddress))
            return false;
        ipFilter = new WtIpFilter();
        ipFilter.setModule("cient-service");//模块
        ipFilter.setIp(ipAddress);//ip地址
        ipFilter.setMark(0);//白名单
        List<WtIpFilter> ips = ipFilterMapper.selectWtIpFilter(ipFilter);
        if (ips.isEmpty()) {
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}