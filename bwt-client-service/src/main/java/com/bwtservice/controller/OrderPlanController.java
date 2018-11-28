package com.bwtservice.controller;

import com.bwtservice.entity.Assetside;
import com.bwtservice.entity.OrderPlan;
import com.bwtservice.entity.Product;
import com.bwtservice.entity.ProductOrder;
import com.bwtservice.mapper.AssetsideMapper;
import com.bwtservice.mapper.OrderPlanMapper;
import com.bwtservice.mapper.ProductMapper;
import com.bwtservice.mapper.ProductOrderMapper;
import com.bwtservice.util.BaseResult;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "还款和汇款计划表接口")
@RequestMapping("/v1/orderPlan/")
public class OrderPlanController {
    private static final Logger logger = LoggerFactory.getLogger(OrderPlanController.class);

    @Resource
    private AssetsideMapper assetsideMapper;
    @Resource
    private OrderPlanMapper orderPlanMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductOrderMapper productOrderMapper;

    @ApiOperation(value = "新增还款计划")
    @PostMapping("/addOrderPlan")
    public BaseResult addOrderPlan(Integer product_no, Integer order_no, BigDecimal loan_amount, String listJson) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType1 = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, OrderPlan.class);
            List<OrderPlan> orderPlanList = (List<OrderPlan>) objectMapper.readValue(listJson, javaType1);
            Product product = productMapper.selectByPrimaryByProductNo(product_no);
            if (product == null) {
                return BaseResult.error("产品不存在");
            }
            if (product.getStatus().equals("2")) {
                return BaseResult.error("产品已经冻结");
            }
            ProductOrder productOrder = productOrderMapper.selectByPrimaryByOrderNoAndProductNo(order_no, product.getId());
            if (productOrder == null) {
                return BaseResult.error("产品订单不存在");
            }
            if (productOrder == null) {
                return BaseResult.error("未找到产品订单数据");
            }
            Assetside assetside = assetsideMapper.selectByPrimaryKey(productOrder.getAssetside_id());
            if (assetside == null) {
                return BaseResult.error("资产端不存在");
            }
            if (assetside.getStatus().equals("2")) {
                return BaseResult.error("资产端账户已经冻结");
            }
            //查询loan_sum总和
            double sum = productOrderMapper.selectSumByProductIdAndOrderNo(order_no, product.getId());
            BigDecimal bigDecimal = new BigDecimal(product.getTotal());
            BigDecimal result3 = bigDecimal.multiply(product.getWarning_line());
            double c = result3.doubleValue();
            if (sum <= c) {
                //冻结
                //业务处理方案不用关注都需要修改状态并且通知
                Product product1 = new Product();
                product1.setId(product.getId());
                product1.setStatus((byte) 2);
                productMapper.updateByPrimaryKeySelective(product1);
                return BaseResult.error(product.getContact_id());
            } else {
                Integer sum1 = orderPlanMapper.selectByPrimaryByOrderId(order_no);
                if (sum1 >= 12) {
                    return BaseResult.error("请勿重复插入");
                }
                for (OrderPlan orderPlan : orderPlanList) {
                    orderPlan.setAssetside_id(assetside.getAssetside_id());
                    orderPlan.setOrder_id(productOrder.getId());
                    orderPlan.setLoan_amount(loan_amount);
                    orderPlanMapper.insertSelective(orderPlan);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return BaseResult.error(e.getStackTrace());
        }
        return BaseResult.successNull();
    }

}
