package com.bwtservice.controller;

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
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation(value = "公钥查询")
    @GetMapping("/getpubKey")
    public BaseResult getPublicKey() {
        try {
            return BaseResult.success(pubKey);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

}
