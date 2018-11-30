package com.bwtservice.controller;

import com.bwtservice.entity.Contract;
import com.bwtservice.entity.ContractDto;
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
    public BaseResult getContractByExample(String contract_no, String contract_start, String contract_end, Integer assetside_id, String client_name, Integer order_no, int pageNum, int pageSize) {
        Contract contract = new Contract();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ContractDto> list = contractMapper.list(contract_no, contract_start, contract_end, assetside_id, client_name, order_no);
            PageInfo<ContractDto> pageInfo = new PageInfo<>(list);
            return BaseResult.success(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }

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
}
