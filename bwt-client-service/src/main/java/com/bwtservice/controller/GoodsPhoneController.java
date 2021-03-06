package com.bwtservice.controller;


import com.bwtservice.config.Excel.ExcelUtil;
import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.mapper.GoodsPhoneMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    @ApiOperation("根据assetside_id查询商品手机")
    @GetMapping("/getPhoneByAssetSideId")
    public BaseResult getPhoneById(Integer assetside_id, String unique_code, int pageNum, int pageSize) {
        if (assetside_id == null) {
            return BaseResult.error("assetside_id不能为空");
        }
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<GoodsPhone> list = goodsPhoneMapper.getGoodsPhoneByAssetsideId(assetside_id, unique_code);
            PageInfo pageInfo = new PageInfo(list);
            return BaseResult.success(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "excelDownloads")
    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, IOException {
        Integer assetside_id = Integer.valueOf(request.getParameter("assetside_id"));
        String unique_code = request.getParameter("unique_code");
        String headerList = request.getParameter("headerList");
        String parameterList = request.getParameter("dataList");
        List<String> headers = Arrays.asList(headerList.split(","));
        List<String> parameters = Arrays.asList(parameterList.split(","));
//        这个list使数据库生成的
        List<GoodsPhone> list = goodsPhoneMapper.getGoodsPhoneByAssetsideId(assetside_id, unique_code);
        ExcelUtil.fileDowm2(request,response,list, headers, parameters);
    }

}
