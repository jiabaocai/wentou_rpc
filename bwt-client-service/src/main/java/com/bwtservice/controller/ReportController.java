package com.bwtservice.controller;

import cn.hutool.json.JSONArray;
import com.bwtservice.config.Excel.ExcelUtil;
import com.bwtservice.entity.ReportDto;
import com.bwtservice.mapper.ReportMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
 * @program: ReportController
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @return
 * @create: 2018/12/11
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/

@RestController
@Api(tags = "报表相关接口")
@RequestMapping("/v1/report/")
public class ReportController {
    @Resource
    private ReportMapper reportMapper;


    @GetMapping("/loanStateMentList")
    @ApiOperation(value = "放款/汇款/统计报表接口")
    public BaseResult loanStatementList(Integer assetside_id,
                                        Integer status,
                                        String startDate,
                                        String endDate,
                                        Integer loan_status,
                                        Integer rp_status,
                                        String contract_start,
                                        String contract_end,
                                        int pageSize,
                                        int pageNum) {
        Integer type = 0;
        if (startDate != null && startDate != "") {
            if (endDate != null && endDate != "") {
                type = 1;
            } else {
                type = 2;
            }
        } else {
            if (endDate != null && endDate != "") {
                type = 3;
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ReportDto> list = reportMapper.getReportListByExample(assetside_id, status, startDate, endDate, loan_status, rp_status, contract_start, contract_end, type);
        PageInfo<ReportDto> pageInfo = new PageInfo<>(list);
        return BaseResult.success(pageInfo);
    }

    @ApiOperation(value = "excelDownloads")
    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, IOException {
        String assetside_id1 = request.getParameter("assetside_id");
        Integer assetside_id = null;
        Integer status = null;
        Integer loan_status = null;
        Integer rp_status = null;
        if (assetside_id1 == null) {
            assetside_id = null;
        }
        String status1 = request.getParameter("status");
        if (status1 == null) {
            status = null;
        }
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String loan_status1 = request.getParameter("loan_status");
        if (loan_status1 == null) {
            loan_status = null;
        }
        String rp_status1 = request.getParameter("rp_status");
        if (rp_status1 == null) {
            rp_status = null;
        }
        String current_interest_start = request.getParameter("current_interest_start");
        String current_interest_end = request.getParameter("current_interest_end");
        String contract_start = request.getParameter("contract_start");
        String contract_end = request.getParameter("contract_end");
        Integer type = 0;
        if (startDate != null && startDate != "") {
            if (endDate != null && endDate != "") {
                type = 1;
            } else {
                type = 2;
            }
        } else {
            if (endDate != null && endDate != "") {
                type = 3;
            }
        }
        String headerList = request.getParameter("headerList");
        String parameterList = request.getParameter("dataList");
        List<String> headers = Arrays.asList(headerList.split(","));
        List<String> parameters = Arrays.asList(parameterList.split(","));
//        这个list使数据库生成的
        List<ReportDto> list = reportMapper.getReportListByExample(assetside_id, status, startDate, endDate,
                loan_status, rp_status, contract_start, contract_end, type);
        ExcelUtil.fileDowm1(request, response, list, headers, parameters);
    }

}

 
