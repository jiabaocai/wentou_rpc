package com.bwtservice.controller;


import com.bwtservice.config.Excel.FileUtils;
import com.bwtservice.entity.Client;
import com.bwtservice.entity.ClientDto;
import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.mapper.ClientMapper;
import com.bwtservice.mapper.ProductOrderMapper;
import com.bwtservice.service.ClientService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户接口
 */
@Api(value = "用户controller", description = "用户接口", tags = "用户接口")
@RestController
@RequestMapping("/v1/client/")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ClientService clientService;
    @Resource
    private ClientMapper clientMapper;
    @Resource
    private ProductOrderMapper productOrderMapper;

    @ApiOperation(value = "新增用户")
    @PostMapping("/addClient")
    public BaseResult addClient(@RequestBody Client client) {
        try {
            Client client1 = clientMapper.selectByPrimaryByIdNumber(client.getIdnumber());
            if (client1 != null) {
                client1.setId(client1.getId());
                clientService.editClient(client);
            } else {
                clientService.addClient(client);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(client.getId());
    }


    @ApiOperation(value = "更新用户")
    @PostMapping("/updateClient")
    public BaseResult editClient(@RequestBody Client client) {
        try {
            Client client1 = clientMapper.selectByPrimaryByIdNumber(client.getIdnumber());
            if (client1 != null) {
                client1.setId(client1.getId());
                clientService.editClient(client);
            } else {
                return BaseResult.error("用户不存在");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.successNull();
    }


    @ApiOperation("根据身份证查询用户")
    @GetMapping("/getClientByIdNumber")
    public BaseResult getClient(String idnumber) {
        Client client = new Client();
        try {
            client = clientService.getClientByIdNumber(idnumber);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
        return BaseResult.success(client);
    }


    @ApiOperation("根据条件查询用户")
    @GetMapping("/getClientByExample")
    public BaseResult getClient(String idnumber, String name, String mobile, int pageNum, int pageSize) {
        Client client = new Client();
        try {
            if (idnumber != null) {
                client.setIdnumber(idnumber);
            }
            if (name != null) {
                client.setName(name);
            }
            if (mobile != null) {
                client.setMobile(mobile);
            }
            PageHelper.startPage(pageNum, pageSize);
            List<ClientDto> list = clientMapper.getClientByExample(client);
            List<ClientDto> clientDtos = new ArrayList<>();
            for (ClientDto clientDto : list) {
                clientDto.setApply_sum(productOrderMapper.getapplySum(clientDto.getId()));
                clientDto.setLoan_sum(productOrderMapper.getLoanSum(clientDto.getId()));
                clientDtos.add(clientDto);
            }
            PageInfo<ClientDto> pageInfo = new PageInfo<>(clientDtos);
            return BaseResult.success(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "excelDownloads")
    @RequestMapping(value = "/excelDownloads", method = RequestMethod.GET)
    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException {
        String idnumber = request.getParameter("idnumber");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String headerList = request.getParameter("headerList");
        String parameterList = request.getParameter("dataList");
//
        Client client = new Client();
        if (idnumber != null) {
            client.setIdnumber(idnumber);
        }
        if (name != null) {
            client.setName(name);
        }
        if (mobile != null) {
            client.setMobile(mobile);
        }
        List<ClientDto> list = clientMapper.getClientByExample(client);
        List<String> headers = Arrays.asList(headerList.split(","));
        List<String> parameters = Arrays.asList(parameterList.split(","));
        FileUtils.byExcelExport2(response, request, headers, parameters, list);
    }


}
