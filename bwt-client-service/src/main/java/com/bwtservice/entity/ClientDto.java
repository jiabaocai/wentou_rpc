package com.bwtservice.entity;

import lombok.Data;

@Data
public class ClientDto extends Client {
    private String apply_sum;
    private String loan_sum;
}
