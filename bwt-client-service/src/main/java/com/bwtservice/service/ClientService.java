package com.bwtservice.service;

import com.bwtservice.entity.Client;

public interface ClientService {
    int addClient(Client client);
    Client getClientByIdNumber(String idnumber);
    int editClient(Client client);

}
