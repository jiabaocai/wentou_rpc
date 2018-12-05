//package com.bwtservice.controller;
//
//import com.bwtservice.config.Excel.FileUtils;
//import com.bwtservice.entity.GoodsGroup;
//import com.bwtservice.entity.GoodsPhone;
//import com.bwtservice.mapper.GoodsPhoneMapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.apache.poi.ss.formula.functions.T;
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
// * Excel导出
// */
//
//@Api(tags = "Excel导出")
//@RequestMapping("/v1/excel")
//@RestController
//public class ExcelController {
//    @Resource
//    private GoodsPhoneMapper goodsPhoneMapper;
//
//    @ApiOperation(value = "ExcelDownloads")
//    @ApiImplicitParam(value = "name",name = "name")
//    @RequestMapping(value = "ExcelDownloads", method = RequestMethod.GET)
//    public void downloadAllClassmate(HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException {
//        String name=request.getParameter("name");
////        List<String> headers = Arrays.asList(headerList);
////        List<String> parameters = Arrays.asList(parameterList);
//                List<String> list1 = new ArrayList<>();
//        list1.add("编号");
//        list1.add("品牌");
//        list1.add("机型");
//        list1.add("颜色");
//        list1.add("容量");
//        list1.add("唯一识别码（IMEI）");
//        List<String> list2 = new ArrayList<>();
//        list2.add("id");
//        list2.add("band");
//        list2.add("model");
//        list2.add("color");
//        list2.add("storage");
//        list2.add("unique_code");
////        这个list使数据库生成的
//        List<GoodsPhone> list = goodsPhoneMapper.selectAll();
//        FileUtils.byExcelExport(response, request, list1, list2, list);
//    }
//}
