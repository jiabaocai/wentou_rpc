package com.bwtservice.controller;

import com.bwtservice.entity.ContractTpl;
import com.bwtservice.entity.ContractTplDto;
import com.bwtservice.entity.ContractTplResp;
import com.bwtservice.mapper.ContractTplMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "合同模板接口")
@RequestMapping("/v1/contractTpl/")
@RestController
public class ContractTplController {
    private static final Logger logger = LoggerFactory.getLogger(ContractTplController.class);
    @Resource
    private ContractTplMapper contractTplMapper;


    @ApiOperation(value = "修改合同模板（合同使用次数 +1）")
    @PostMapping("/editContractTplTimes")
    public BaseResult addContract(int contractTplId) {
        ContractTpl contract = new ContractTpl();
        contract.setTpl_id(contractTplId);
        try {
            ContractTpl contract1 = contractTplMapper.selectByPrimaryKey(contractTplId);
            if (contract1 != null) {
                contract.setTimes(contract1.getTimes() + 1);
                contractTplMapper.updateByPrimaryKeySelective(contract);
            } else {
                return BaseResult.error("数据不存在");
            }
            return BaseResult.successNull();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "新增合同模板")
    @PostMapping("/addContractTpl")
    public BaseResult addContractTpl(@RequestBody ContractTpl contractTpl) {
        try {
            return BaseResult.success(contractTplMapper.insertSelective(contractTpl));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "修改合同模板")
    @PostMapping("/editContractTpl")
    public BaseResult editContractTpl(@RequestBody ContractTpl contractTpl) {
        try {
            ContractTpl contract1 = contractTplMapper.selectByPrimaryKey(contractTpl.getTpl_id());
            if (contract1 != null) {
                contractTplMapper.updateByPrimaryKeySelective(contractTpl);
            } else {
                return BaseResult.error("数据不存在");
            }
            return BaseResult.successNull();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据ID进行查询")
    @PostMapping("/getContractTplById")
    public BaseResult getContractTplById(int tpl_id) {
        try {
            return BaseResult.success(contractTplMapper.selectByPrimaryKey(tpl_id));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询合同模板")
    @PostMapping("/getContractTplByExample")
    public BaseResult getContractTplByExample(String startDate, String endDate, String tpl_name, int pageNum, int pageSize) {
        ContractTplDto contractTplDto = new ContractTplDto();
        if (startDate != null) {
            contractTplDto.setStartDate(startDate);
        }
        if (endDate != null) {
            contractTplDto.setEndDate(endDate);
        }
        if (tpl_name != null) {
            contractTplDto.setTpl_name(tpl_name);
        }
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ContractTplResp> list = contractTplMapper.getContractTplList(contractTplDto);
            PageInfo<ContractTplResp> pageInfo = new PageInfo<>(list);
            return BaseResult.success(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

}
