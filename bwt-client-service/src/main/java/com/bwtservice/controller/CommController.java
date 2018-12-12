package com.bwtservice.controller;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.bwtservice.entity.Category;
import com.bwtservice.entity.GoodsGroup;
import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.enums.CommEnum;
import com.bwtservice.mapper.CategoryMapper;
import com.bwtservice.mapper.GoodsGroupMapper;
import com.bwtservice.mapper.GoodsPhoneMapper;
import com.bwtservice.util.ApiUtil;
import com.bwtservice.util.BaseResult;
import com.bwtservice.util.MD5Util;
import com.bwtservice.util.RSAUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公用类查询（仅限查询 需要输入当前表名称全称）
 */

@Api(value = "公用类查询controller", description = "公用类查询（仅限查询，需要输入当前表名称全称，如果需要新增，需要后台支持）", tags = "公用类查询")
@RequestMapping("/v1/comm/")
@RestController
@Component
public class CommController {

    private static final Logger logger = LoggerFactory.getLogger(CommController.class);
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private GoodsGroupMapper goodsGroupMapper;
    @Resource
    private GoodsPhoneMapper goodsPhoneMapper;

    private Category category;
    private GoodsPhone goodsPhone;
    private GoodsGroup goodsGroup;

    @Value("${appid.priKey}")
    private String priKey;

    @Value("${appid.pubKey}")
    private String pubKey;

    @ApiOperation(value = "根据表名查询所有")
    @GetMapping("/getAll")
    public BaseResult getListByDateBase(String dateBaseName) {
        try {
            if (CommEnum.CATEGORY.name().equalsIgnoreCase(dateBaseName)) {
                List<Category> list = categoryMapper.getAll();
                return BaseResult.success(list);
            } else if (CommEnum.GOODS_GROUP.name().equalsIgnoreCase(dateBaseName)) {
                List<GoodsGroup> list = goodsGroupMapper.getAll();
                return BaseResult.success(list);
            } else {
                return BaseResult.error("未知数据库");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }


    @ApiOperation(value = "sign签名生成器")
    @GetMapping("/sign")
    public BaseResult getSign(String data, String pubKey) {
        try {
            String signature = MD5Util.encode(data);
            byte[] jiemi = RSAUtils.encryptByPublicKey(signature.getBytes(), pubKey);
            return BaseResult.success(new String(jiemi));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error("加密失败，请检查公钥");
        }
    }

    @ApiOperation(value = "秘钥查询")
    @GetMapping("/getRsaKey")
    public BaseResult getPublicKey() {
        try {
            String publicKey;
            String privateKey;
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            privateKey = RSAUtils.getPrivateKey(keyMap);
            Map<String, String> map = new HashMap<>();
            map.put("pubKey", publicKey);
            map.put("priKey", privateKey);
            return BaseResult.success(map);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "公钥加密")
    @GetMapping("/encryptByPublicKey")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reqData", value = "需要加密的内容", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pubKey", value = "公钥", dataType = "string", paramType = "query")})
    public BaseResult getpubEncode(String reqData, String pubKey) {
        try {
            byte[] encodedData = RSAUtils.encryptByPublicKey(reqData.getBytes(), pubKey);
            return BaseResult.success(Base64.encodeBase64String(encodedData));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "公钥加密兼容北头")
    @GetMapping("/encryptByPublicKeyNew")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reqData", value = "需要加密的内容", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pubKey", value = "公钥", dataType = "string", paramType = "query")})
    public BaseResult getpubEncodeNew(String reqData, String pubKey) {
        try {
            RSA rsa = SecureUtil.rsa(null, pubKey);
            String encrypt = rsa.encryptStr(reqData, KeyType.PublicKey, CharsetUtil.CHARSET_UTF_8);
            System.out.println("加密后的内容:" + encrypt);
            return BaseResult.success(encrypt);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "私钥解密")
    @GetMapping("/decryptByPrivateKey")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reqData", value = "需要解密的内容", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "priKey", value = "私钥", dataType = "string", paramType = "query")})
    public BaseResult getPriDecrypt(String reqData, String priKey) {
        try {
            byte[] encodedData = RSAUtils.decryptByPrivateKey(Base64.decodeBase64(reqData), priKey);
            return BaseResult.success(new String(encodedData));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

}
