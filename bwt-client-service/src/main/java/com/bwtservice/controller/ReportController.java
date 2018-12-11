package com.bwtservice.controller;

import com.bwtservice.entity.ReportDto;
import com.bwtservice.mapper.ReportMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}

 
