package com.bwtservice.controller;


import com.bwtservice.entity.Category;
import com.bwtservice.mapper.CategoryMapper;
import com.bwtservice.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
        Category category = new Category();
        try {
            category = categoryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(category);
    }

}
