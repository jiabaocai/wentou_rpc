package com.bwtservice.controller;


import com.bwtservice.entity.GoodsGroup;
import com.bwtservice.mapper.GoodsGroupMapper;
import com.bwtservice.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(value = "商品组controller", description = "商品组接口", tags = {"商品组接口"})
@RestController()
@RequestMapping("/v1/goodsgroup/")
public class GoodsGroupController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsGroupController.class);
    @Resource
    private GoodsGroupMapper goodsGroupMapper;

    @ApiOperation(value = "新增商品组")
    @PostMapping("/addGroup")
    public BaseResult addGroup(@RequestBody GoodsGroup goodsGroup) {
        try {
            goodsGroupMapper.insertSelective(goodsGroup);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(goodsGroup.getId());
    }


    @ApiOperation(value = "更新商品组")
    @PostMapping("/updateGroup")
    public BaseResult updateGroup(@RequestBody GoodsGroup goodsGroup) {
        try {
            goodsGroupMapper.updateByPrimaryKeySelective(goodsGroup);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation("根据ID查询商品组")
    @GetMapping("/getGroupById")
    public BaseResult getGroupById(int id) {
        GoodsGroup goodsGroup = new GoodsGroup();
        try {
            goodsGroup = goodsGroupMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(goodsGroup);
    }

    @ApiOperation("根据商品组名称查询商品组")
    @GetMapping("/getGroupByName")
    public BaseResult getGroupByName(String name) {
        List<GoodsGroup> goodsGroup = new ArrayList<>();
        try {
            GoodsGroup goodsGroup1=new GoodsGroup();
            goodsGroup1.setName(name);
            goodsGroup = goodsGroupMapper.selectByexample(goodsGroup1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(goodsGroup);
    }


}
