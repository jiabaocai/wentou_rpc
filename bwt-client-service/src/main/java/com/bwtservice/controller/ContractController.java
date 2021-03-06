package com.bwtservice.controller;

import cn.hutool.json.JSONArray;
import com.bwtservice.config.Excel.ExcelUtil;
import com.bwtservice.entity.Contract;
import com.bwtservice.entity.ContractDto;
import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.mapper.ContractMapper;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 合同接口
 */
@Api(tags = "合同接口")
@RequestMapping("/v1/contract")
@RestController
public class ContractController {
    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Resource
    private ContractMapper contractMapper;

    @ApiOperation(value = "模糊查询")
    @GetMapping("/getContractByExample")
    public BaseResult getContractByExample(String client_address, String client_idno, String client_mobile, String phone_band, String phone_model, String phone_color, String phone_memory, String phone_size, String phone_storage, String contract_no, String contract_start, String contract_end, Integer assetside_id, String client_name, Integer order_no, int pageNum, int pageSize) {
        Contract contract = new Contract();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ContractDto> list = contractMapper.list(contract_no, contract_start, contract_end, assetside_id, client_name, order_no, null, client_address, client_idno, client_mobile, phone_band, phone_model, phone_color, phone_memory, phone_size, phone_storage);
            PageInfo<ContractDto> pageInfo = new PageInfo<>(list);
            return BaseResult.success(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }

    }


    @ApiOperation(value = "excelDownloads")
    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, IOException {
        String contract_no = request.getParameter("contract_no");
        String contract_start = request.getParameter("contract_start");
        String contract_end = request.getParameter("contract_end");
        Integer assetside_id = null;
        Integer order_no = null;
        if (request.getParameter("assetside_id") != null) {
            assetside_id = Integer.valueOf(request.getParameter("assetside_id"));
        }
        String client_name = request.getParameter("client_name");
        if (request.getParameter("order_no") != null) {
            order_no = Integer.valueOf(request.getParameter("order_no"));
        }
        String headerList = request.getParameter("headerList");
        String parameterList = request.getParameter("dataList");
        List<String> headers = Arrays.asList(headerList.split(","));
        List<String> parameters = Arrays.asList(parameterList.split(","));
        List<ContractDto> list = contractMapper.list(contract_no, contract_start, contract_end, assetside_id, client_name, order_no, null, null, null, null, null, null, null, null, null, null);
        ExcelUtil.fileDowm(request,response,list, headers, parameters);
    }


    @ApiOperation(value = "新增合同")
    @PostMapping("/addContract")
    public BaseResult addContract(@RequestBody Contract contract) {
        try {
            Integer id = contractMapper.insertSelective(contract);
            return BaseResult.success(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID进行查询")
    @PostMapping("/getContractById")
    public BaseResult getContractById(int id) {
        try {
            List<ContractDto> list = contractMapper.list(null, null, null, null, null, null, id, null, null, null, null, null, null, null, null, null);
            if (list.size() > 0) {
                return BaseResult.success(list.get(0));
            }
            return BaseResult.successNull();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

}
