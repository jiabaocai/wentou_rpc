package com.bwtservice.controller;


import com.bwtservice.entity.Category;
import com.bwtservice.entity.CategoryDto;
import com.bwtservice.mapper.CategoryMapper;
import com.bwtservice.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(value = "类目controller", description = "类目接口", tags = {"类目接口"})
@RestController()
@RequestMapping("/v1/category/")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Resource
    private CategoryMapper categoryMapper;


    @ApiOperation(value = "新增类目")
    @PostMapping("/addCategory")
    public BaseResult addCategory(@RequestBody Category category) {
        try {
            categoryMapper.insertSelective(category);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(category.getId());
    }


    @ApiOperation(value = "更新类目")
    @PostMapping("/updateCategory")
    public BaseResult updateCategory(@RequestBody Category category) {
        try {
            categoryMapper.updateByPrimaryKeySelective(category);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation("根据ID查询类目")
    @GetMapping("/getCategoryById")
    public BaseResult getCategoryById(int id) {
        CategoryDto category = new CategoryDto();
        try {
            category = categoryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(category);
    }

    @ApiOperation("根据GoodGroupID查询类目")
    @GetMapping("/getCategoryByGoodId")
    public BaseResult getCategoryByGoodId(int goodsGroupId) {
        List<Category> category = new ArrayList<>();
        try {
            category = categoryMapper.selectByPrimaryBygoodsGroupId(goodsGroupId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(category);
    }

    @ApiOperation("查询所有类目包含GoodGroupName")
    @GetMapping("/getCategoryAll")
    public BaseResult getCategoryAll(Integer goods_group_id, String name) {
        List<CategoryDto> category = new ArrayList<>();
        try {

            if (goods_group_id != null) {
                if (name != null) {
                    category = categoryMapper.selectByPrimaryAllByNameAndId(name, goods_group_id);
                } else {
                    category = categoryMapper.selectByPrimaryAllById(goods_group_id);
                }
            } else {
                if (name != null) {
                    category = categoryMapper.selectByPrimaryAllByName(name);
                } else {
                    category = categoryMapper.selectByPrimaryAll();
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(category);
    }

}
