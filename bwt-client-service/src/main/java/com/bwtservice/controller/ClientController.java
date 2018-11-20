package com.bwtservice.controller;


import com.bwtservice.entity.Client;
import com.bwtservice.mapper.ClientMapper;
import com.bwtservice.service.ClientService;
import com.bwtservice.util.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
              return  BaseResult.error("用户不存在");
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


}
