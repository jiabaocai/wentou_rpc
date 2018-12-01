package com.bwtservice.controller;

import com.bwtservice.entity.ProductOrder;
import com.bwtservice.entity.ProductOrderReq;
import com.bwtservice.mapper.ProductOrderMapper;
import com.bwtservice.util.BaseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 产品订单接口
 */
@Api(tags = "产品订单接口")
@RequestMapping("/v1/productOrder/")
@RestController
public class ProductOrderController {
    @Resource
    private ProductOrderMapper productOrderMapper;
    private static final Logger logger = LoggerFactory.getLogger(ProductOrderController.class);

    @ApiOperation(value = "模糊查询（分页）")
    @GetMapping("getProductOrderByExample")
    public BaseResult getProductOrderByExample(Integer assetside_id, String order_no, Double start_loan_sum, Double end_loan_sum, Integer status, Integer received_status, int pageNum, int pageSize) {
        try {
            ProductOrderReq req = new ProductOrderReq();
            if (end_loan_sum != null) {
                req.setEndLoanSum(end_loan_sum);
            }
            if (start_loan_sum != null) {
                req.setStartLoanSum(start_loan_sum);
            }
            if (assetside_id != null) {
                req.setAssetside_id(assetside_id);
            }
            if (order_no != null) {
                req.setOrder_no(order_no);
            }
            if (status != null) {
                req.setStatus(status);
            }
            if (received_status != null) {
                req.setReceived_status(received_status);
            }
            PageHelper.startPage(pageNum, pageSize);
            List<ProductOrder> list = productOrderMapper.selectProductOrderByExampleOrLike(req);
            PageInfo<ProductOrder> productOrderPageInfo = new PageInfo<>(list);
            return BaseResult.success(productOrderPageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

    @ApiOperation(value = "模糊查询（不需要分页）只根据client_id查询")
    @GetMapping("getProductOrderByClientId")
    public BaseResult getProductOrderByExample(Integer client_id) {
        try {
            ProductOrderReq req = new ProductOrderReq();
            if (client_id != null) {
                req.setClient_id(client_id);
            }
            List<ProductOrder> list = productOrderMapper.selectProductOrderByExampleOrLike(req);
            return BaseResult.success(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getMessage());
        }
    }

}
