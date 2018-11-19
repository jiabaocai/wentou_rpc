package com.bwtservice.service.impl;

import com.bwtservice.entity.Client;
import com.bwtservice.mapper.ClientMapper;
import com.bwtservice.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    ClientMapper clientMapper;

    @Override
    public int addClient(Client client) {
        return clientMapper.insertSelective(client);
    }

    @Override
    public Client getClientByIdNumber(String idnumber) {
        return clientMapper.selectByPrimaryByIdNumber(idnumber);
    }

    @Override
    public int editClient(Client client) {
        return clientMapper.updateByPrimaryKeySelective(client);
    }
}
