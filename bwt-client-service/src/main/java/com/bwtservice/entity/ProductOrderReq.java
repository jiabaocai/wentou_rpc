package com.bwtservice.entity;

import lombok.Data;

@Data
public class ProductOrderReq extends  ProductOrder {
    Double startLoanSum;
    Double endLoanSum;
}
