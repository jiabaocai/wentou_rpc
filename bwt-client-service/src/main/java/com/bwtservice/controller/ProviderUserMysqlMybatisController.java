//package com.bwtservice.controller;
//
//import com.bwtservice.config.Excel.FileUtils;
//import com.bwtservice.entity.LoanOrder;
//import com.github.pagehelper.PageInfo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 用户微服务Controller。
// *
// * @author hmilyylimh
// * @version 0.0.1
// * @date 2017-10-19
// */
//@Api(tags = "测试接口")
//@RestController
//public class ProviderUserMysqlMybatisController {
//
//    private static final Logger logger = LoggerFactory.getLogger(ProviderUserMysqlMybatisController.class);
//    @Resource
//    private LoanOrderService loanOrderService;
//
//
//    @ApiOperation(value = "测试用的1", tags = "测试用的")
//    @GetMapping("get/All")
//    public PageInfo<LoanOrder> list() {
//
//        return loanOrderService.getAll();
//    }
//
//    @ApiOperation(value = "UserExcelDownloads", tags = "UserExcelDownloads")
//    @RequestMapping(value = "UserExcelDownloads", method = RequestMethod.GET)
//    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request)throws IllegalAccessException {
////            List<String> list1 = loanOrderService.getColumn();
//        List<String> list1 = new ArrayList<>();
//        list1.add("第一行");
//        list1.add("第二行");
//        list1.add("第三行");
//        list1.add("第四行");
//        List<String> list2 = new ArrayList<>();
//        list2.add("id");
//        list2.add("loan_id");
//        list2.add("phone");
//        list2.add("user_id");
//        List<LoanOrder> list = loanOrderService.getAlllist();
//        FileUtils.byExcelExport(response, request, list1, list2, list);
//    }
//}
