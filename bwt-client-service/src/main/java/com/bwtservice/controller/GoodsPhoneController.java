package com.bwtservice.controller;


import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.mapper.GoodsPhoneMapper;
import com.bwtservice.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "商品手机controller", description = "商品手机接口", tags = {"商品手机接口"})
@RestController()
@RequestMapping("/v1/goodsphone/")
public class GoodsPhoneController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsPhoneController.class);
    @Resource
    private GoodsPhoneMapper goodsPhoneMapper;

    @ApiOperation(value = "新增商品手机")
    @PostMapping("/addPhone")
    public BaseResult addPhone(@RequestBody GoodsPhone goodsPhone) {
        try {
            goodsPhoneMapper.insertSelective(goodsPhone);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(goodsPhone.getId());
    }


    @ApiOperation(value = "更新商品手机")
    @PostMapping("/updatePhone")
    public BaseResult updatePhone(@RequestBody GoodsPhone goodsPhone) {
        try {
            goodsPhoneMapper.updateByPrimaryKeySelective(goodsPhone);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation("根据ID查询商品手机")
    @GetMapping("/getPhoneById")
    public BaseResult getPhoneById(int id) {
        GoodsPhone goodsPhone = new GoodsPhone();
        try {
            goodsPhone = goodsPhoneMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(goodsPhone);
    }

}
