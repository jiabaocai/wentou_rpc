package com.bwtservice.controller;

import com.bwtservice.entity.*;
import com.bwtservice.mapper.ProductMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品接口
 */
@Api(tags = "产品接口", description = "产品controller")
@RestController
@RequestMapping("/v1/product/")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Resource
    private ProductMapper productMapper;

    @ApiOperation(value = "新增产品接口")
    @PostMapping("/addProduct")
    public BaseResult addProduct(@RequestBody Product product) {
        try {
            productMapper.insertSelective(product);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(product.getId());
    }

    @ApiOperation(value = "修改资产品接口")
    @PostMapping("/editProduct")
    public BaseResult<Object> editProduct(@RequestBody Product product) {
        try {
            Product a = productMapper.selectByPrimaryKey(product.getId());
            if (a != null) {
                productMapper.updateByPrimaryKeySelective(product);
            } else {
                BaseResult.error("产品信息不存在");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }

    @ApiOperation(value = "根据id查询产品详情")
    @PostMapping("/getProductById")
    public BaseResult getProductById(Integer id) {
        ProductDto productDto = new ProductDto();
        if (id == null) {
            BaseResult.error("请输入商品Id");
        }
        try {
            productDto = productMapper.selectProductById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            BaseResult.error(e.getMessage());
        }
        return BaseResult.success(productDto);
    }


    @ApiOperation(value = "根据条件查询产品详情")
    @PostMapping("/getProductByExample")
    public BaseResult getProductByExample(Integer product_no, Integer rdg_id, Integer status, String createtime, String endDate, String assetside_name, String goods_group_name, Integer pageNum, Integer pageSize) {
        PageInfo<ProductDto> pageInfo = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ProductDto> list = productMapper.selectProductByExample(product_no, rdg_id, status, createtime, endDate, assetside_name, goods_group_name);
            pageInfo = new PageInfo(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            BaseResult.error(e.getMessage());
        }
        return BaseResult.success(pageInfo);
    }
}
