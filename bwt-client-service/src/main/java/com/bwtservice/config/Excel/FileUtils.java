package com.bwtservice.config.Excel;

import com.bwtservice.entity.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

public class FileUtils {
    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     *
     * @param filename
     *            下载文件名
     * @param agent
     *            客户端浏览器
     * @return 编码后的下载附件名
     * @throws IOException
     */
    public static String encodeDownloadFilename(String filename, String agent)
            throws IOException {
        if (agent.contains("Firefox")) { // 火狐浏览器
            filename = "=?UTF-8?B?"
                    + new BASE64Encoder().encode(filename.getBytes("utf-8"))
                    + "?=";
            filename = filename.replaceAll("\r\n", "");
        } else { // IE及其他浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+"," ");
        }
        return filename;
    }

    public static void excelExport(HttpServletResponse response, HttpServletRequest request, HSSFWorkbook hssfWorkbook, String filename){

        // 通过浏览器下载导出
        // 设置表头信息
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel,charset=utf-8");
            String agent = request.getHeader("user-agent");
            filename = encodeDownloadFilename(filename, agent);
            response.setHeader("Content-Disposition", new String(("attachment;filename=" + filename).getBytes(), "iso-8859-1"));
            hssfWorkbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭
            try {
                hssfWorkbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static HashMap<String, Object> convertToMap(Object obj) throws IllegalAccessException {

        HashMap<String, Object> map = new HashMap<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);

            Object o = fields[i].get(obj);
            if (o != null)
                map.put(varName, o.toString());

            fields[i].setAccessible(accessFlag);
        }

        return map;
    }

    public static void byExcelExport(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<GoodsPhone> list) throws IllegalAccessException {
////        List<String> list1 = new ArrayList<>();
//        list1.add("第一行");
//        list1.add("第二行");
//        list1.add("第三行");
//        list1.add("第四行");
//        List<String> list2 = new ArrayList<>();
//        list2.add("id");
//        list2.add("loan_id");
//        list2.add("phone");
//        list2.add("user_id");
        //这个list使数据库生成的
//        List<LoanOrder> list = loanOrderService.getAlllist();
        // 得到结果，生成Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
        // 用于格式化单元格的数据
        // 设置字体
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setItalic(true); //是否使用斜体
        // 设置单元格类型
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        // 生成表头
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < list1.size(); i++) {
            headRow.createCell(i).setCellValue(list1.get(i));
        }
        headRow.setRowStyle(cellStyle);
        // 将数据插入表中
        for (GoodsPhone customer : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            Map<String, Object> map = convertToMap(customer);
            for (int i = 0; i < list2.size(); i++) {
                dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
                sheet.autoSizeColumn((short)i); //调整第n列宽度
            }
            dataRow.setRowStyle(cellStyle);
        }
        String filename = UUID.randomUUID()+".xls";
        FileUtils.excelExport(response,request,hssfWorkbook,filename);
    }


    public static void byExcelExport1(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<ContractDto> list) throws IllegalAccessException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
        // 用于格式化单元格的数据
        // 设置字体
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setItalic(true); //是否使用斜体
        // 设置单元格类型
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        // 生成表头
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < list1.size(); i++) {
            headRow.createCell(i).setCellValue(list1.get(i));
        }
        headRow.setRowStyle(cellStyle);
        // 将数据插入表中
        for (ContractDto customer : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            Map<String, Object> map = convertToMap(customer);
            for (int i = 0; i < list2.size(); i++) {
                dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
                sheet.autoSizeColumn((short)i); //调整第n列宽度
            }
            dataRow.setRowStyle(cellStyle);
        }
        String filename = UUID.randomUUID()+".xls";
        FileUtils.excelExport(response,request,hssfWorkbook,filename);
    }

    public static void byExcelExport2(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<ClientDto> list) throws IllegalAccessException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
        // 用于格式化单元格的数据
        // 设置字体
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setItalic(true); //是否使用斜体
        // 设置单元格类型
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
        cellStyle.setWrapText(true);
        // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        // 生成表头
        HSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < list1.size(); i++) {
            headRow.createCell(i).setCellValue(list1.get(i));
        }
        headRow.setRowStyle(cellStyle);
        // 将数据插入表中
        for (ClientDto customer : list) {
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            Map<String, Object> map = convertToMap(customer);
            for (int i = 0; i < list2.size(); i++) {
                dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
                sheet.autoSizeColumn((short)i); //调整第n列宽度
            }
            dataRow.setRowStyle(cellStyle);
        }
        String filename = UUID.randomUUID()+".xls";
        FileUtils.excelExport(response,request,hssfWorkbook,filename);
    }
}
