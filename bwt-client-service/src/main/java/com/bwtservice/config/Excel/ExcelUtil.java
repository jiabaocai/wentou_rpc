package com.bwtservice.config.Excel;

import cn.hutool.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwtservice.entity.Client;
import com.bwtservice.entity.ContractDto;
import com.bwtservice.entity.GoodsPhone;
import com.bwtservice.entity.ReportDto;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Cheung on 2017/12/19.
 * <p>
 * Apache POI操作Excel对象
 * HSSF：操作Excel 2007之前版本(.xls)格式,生成的EXCEL不经过压缩直接导出
 * XSSF：操作Excel 2007及之后版本(.xlsx)格式,内存占用高于HSSF
 * SXSSF:从POI3.8 beta3开始支持,基于XSSF,低内存占用,专门处理大数据量(建议)。
 * <p>
 * 注意:
 * 值得注意的是SXSSFWorkbook只能写(导出)不能读(导入)
 * <p>
 * 说明:
 * .xls格式的excel(最大行数65536行,最大列数256列)
 * .xlsx格式的excel(最大行数1048576行,最大列数16384列)
 */
public class ExcelUtil {

    public static final String DEFAULT_DATE_PATTERN = "yyyy年MM月dd日";// 默认日期格式
    public static final int DEFAULT_COLUMN_WIDTH = 17;// 默认列宽


    /**
     * 导出Excel(.xlsx)格式
     *
     * @param titleList 表格头信息集合
     * @param dataArray 数据数组
     * @param os        文件输出流
     */
    public static void exportExcel(ArrayList<LinkedHashMap> titleList, JSONArray dataArray, OutputStream os, HttpServletResponse response, HttpServletRequest request, String filename) {
        String datePattern = DEFAULT_DATE_PATTERN;
        int minBytes = DEFAULT_COLUMN_WIDTH;

        /**
         * 声明一个工作薄
         */
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);// 大于1000行时会把之前的行写入硬盘
        workbook.setCompressTempFiles(true);

        // 表头1样式
        CellStyle title1Style = workbook.createCellStyle();
        title1Style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
        title1Style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        Font titleFont = workbook.createFont();// 字体
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        title1Style.setFont(titleFont);

        // 表头2样式
        CellStyle title2Style = workbook.createCellStyle();
        title2Style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        title2Style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        title2Style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
        title2Style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右
        title2Style.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 下
        title2Style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左
        Font title2Font = workbook.createFont();
        title2Font.setUnderline((byte) 1);
        title2Font.setColor(HSSFColor.BLUE.index);
        title2Style.setFont(title2Font);

        // head样式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        headerStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);// 设置颜色
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);// 前景色纯色填充
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);

        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);


        String title1 = (String) titleList.get(0).get("title1");
        String title2 = (String) titleList.get(0).get("title2");
        LinkedHashMap<String, String> headMap = titleList.get(1);

        /**
         * 生成一个(带名称)表格
         */
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(title1);
        sheet.createFreezePane(0, 3, 0, 3);// (单独)冻结前三行

        /**
         * 生成head相关信息+设置每列宽度
         */
        int[] colWidthArr = new int[headMap.size()];// 列宽数组
        String[] headKeyArr = new String[headMap.size()];// headKey数组
        String[] headValArr = new String[headMap.size()];// headVal数组
        int i = 0;
        for (Map.Entry<String, String> entry : headMap.entrySet()) {
            headKeyArr[i] = entry.getKey();
            headValArr[i] = entry.getValue();

            int bytes = headKeyArr[i].getBytes().length;
            colWidthArr[i] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(i, colWidthArr[i] * 256);// 设置列宽
            i++;
        }


        /**
         * 遍历数据集合，产生Excel行数据
         */
        int rowIndex = 0;
        for (Object obj : dataArray) {
            // 生成title+head信息
            if (rowIndex == 0) {
                SXSSFRow title1Row = (SXSSFRow) sheet.createRow(0);// title1行
                title1Row.createCell(0).setCellValue(title1);
                title1Row.getCell(0).setCellStyle(title1Style);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));// 合并单元格

                SXSSFRow title2Row = (SXSSFRow) sheet.createRow(1);// title2行
                title2Row.createCell(0).setCellValue(title2);

                CreationHelper createHelper = workbook.getCreationHelper();
                XSSFHyperlink hyperLink = (XSSFHyperlink) createHelper.createHyperlink(Hyperlink.LINK_URL);
                hyperLink.setAddress(title2);
                title2Row.getCell(0).setHyperlink(hyperLink);// 添加超链接

                title2Row.getCell(0).setCellStyle(title2Style);
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, headMap.size() - 1));// 合并单元格

                SXSSFRow headerRow = (SXSSFRow) sheet.createRow(2);// head行
                for (int j = 0; j < headValArr.length; j++) {
                    headerRow.createCell(j).setCellValue(headValArr[j]);
                    headerRow.getCell(j).setCellStyle(headerStyle);
                }
                rowIndex = 3;
            }

            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            // 生成数据
            SXSSFRow dataRow = (SXSSFRow) sheet.createRow(rowIndex);// 创建行
            for (int k = 0; k < headKeyArr.length; k++) {
                SXSSFCell cell = (SXSSFCell) dataRow.createCell(k);// 创建单元格
                Object o = jo.get(headKeyArr[k]);
                String cellValue = "";

                if (o == null) {
                    cellValue = "";
                } else if (o instanceof Date) {
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                } else if (o instanceof Float || o instanceof Double) {
                    cellValue = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                } else {
                    cellValue = o.toString();
                }

                if (cellValue.equals("true")) {
                    cellValue = "男";
                } else if (cellValue.equals("false")) {
                    cellValue = "女";
                }

                cell.setCellValue(cellValue);
                cell.setCellStyle(cellStyle);
            }
            rowIndex++;
        }
        try {
            // 通过浏览器下载导出
            // 设置表头信息
            os = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel,charset=utf-8");
            String agent = request.getHeader("user-agent");
            filename = encodeDownloadFilename(filename, agent);
            response.setHeader("Content-Disposition", new String(("attachment;filename=" + filename).getBytes(), "iso-8859-1"));
            workbook.write(os);
            os.flush();// 刷新此输出流并强制将所有缓冲的输出字节写出
            os.close();// 关闭流
            workbook.dispose();// 释放workbook所占用的所有windows资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     *
     * @param filename 下载文件名
     * @param agent    客户端浏览器
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
            filename = filename.replace("+", " ");
        }
        return filename;
    }


    public static void fileDowm(HttpServletRequest request, HttpServletResponse response, List<ContractDto> list, List<String> headers, List<String> parameters) throws IOException {
        JSONArray studentArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            studentArray.add(list.get(i));
        }
        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
        // 1.titleMap存放了该excel的头信息
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
        titleMap.put("title1", "合同订单报表");
        titleMap.put("title2", "本内容只限内部使用，禁止传阅");
        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("id", "ID");
        for (int i = 0; i < headers.size(); i++) {
            headMap.put(parameters.get(i), headers.get(i));
        }
        titleList.add(titleMap);
        titleList.add(headMap);

        File file = new File("");
        if (!file.exists()) file.mkdirs();// 创建该文件夹目录
        OutputStream os = null;
        try {
            System.out.println("正在导出xlsx...");
            long start = System.currentTimeMillis();
            // .xlsx格式
            String filename = File.separator + start + ".xlsx";
            os = new FileOutputStream(file.getAbsolutePath() + File.separator + start + ".xlsx");
            ExcelUtil.exportExcel(titleList, studentArray, os, response, request, filename);
            System.out.println("导出完成...共" + list.size() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
            System.out.println("文件路径：" + file.getAbsolutePath() + File.separator + start + ".xlsx");
            del(file.getAbsolutePath() + File.separator + start + ".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

    public static void del(String path) {
        File file1 = new File(path);
        if (file1.delete()) {
            System.out.println(file1.getName() + " 文件已被删除！");
        } else {
            System.out.println("文件删除失败！");
        }
    }


    public static void fileDowm1(HttpServletRequest request, HttpServletResponse response, List<ReportDto> list, List<String> headers, List<String> parameters) throws IOException {
        JSONArray studentArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            studentArray.add(list.get(i));
        }
        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
        // 1.titleMap存放了该excel的头信息
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
        titleMap.put("title1", "统计报表");
        titleMap.put("title2", "本内容只限内部使用，禁止传阅");
        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("id", "ID");
        for (int i = 0; i < headers.size(); i++) {
            headMap.put(parameters.get(i), headers.get(i));
        }
        titleList.add(titleMap);
        titleList.add(headMap);

        File file = new File("");
        if (!file.exists()) file.mkdirs();// 创建该文件夹目录
        OutputStream os = null;
        try {
            System.out.println("正在导出xlsx...");
            long start = System.currentTimeMillis();
            // .xlsx格式
            String filename = File.separator + start + ".xlsx";
            os = new FileOutputStream(file.getAbsolutePath() + File.separator + start + ".xlsx");
            ExcelUtil.exportExcel(titleList, studentArray, os, response, request, filename);
            System.out.println("导出完成...共" + list.size() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
            System.out.println("文件路径：" + file.getAbsolutePath() + File.separator + start + ".xlsx");
            del(file.getAbsolutePath() + File.separator + start + ".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

    public static void fileDowm2(HttpServletRequest request, HttpServletResponse response, List<GoodsPhone> list, List<String> headers, List<String> parameters) throws IOException {
        JSONArray studentArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            studentArray.add(list.get(i));
        }
        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
        // 1.titleMap存放了该excel的头信息
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
        titleMap.put("title1", "商品报表");
        titleMap.put("title2", "本内容只限内部使用，禁止传阅");
        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("id", "ID");
        for (int i = 0; i < headers.size(); i++) {
            headMap.put(parameters.get(i), headers.get(i));
        }
        titleList.add(titleMap);
        titleList.add(headMap);

        File file = new File("");
        if (!file.exists()) file.mkdirs();// 创建该文件夹目录
        OutputStream os = null;
        try {
            System.out.println("正在导出xlsx...");
            long start = System.currentTimeMillis();
            // .xlsx格式
            String filename = File.separator + start + ".xlsx";
            os = new FileOutputStream(file.getAbsolutePath() + File.separator + start + ".xlsx");
            ExcelUtil.exportExcel(titleList, studentArray, os, response, request, filename);
            System.out.println("导出完成...共" + list.size() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
            System.out.println("文件路径：" + file.getAbsolutePath() + File.separator + start + ".xlsx");
            del(file.getAbsolutePath() + File.separator + start + ".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }


    public static void fileDowm3(HttpServletRequest request, HttpServletResponse response, List<Client> list, List<String> headers, List<String> parameters) throws IOException {
        JSONArray studentArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            studentArray.add(list.get(i));
        }
        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
        // 1.titleMap存放了该excel的头信息
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
        titleMap.put("title1", "用户报表");
        titleMap.put("title2", "本内容只限内部使用，禁止传阅");
        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("id", "ID");
        for (int i = 0; i < headers.size(); i++) {
            headMap.put(parameters.get(i), headers.get(i));
        }
        titleList.add(titleMap);
        titleList.add(headMap);

        File file = new File("");
        if (!file.exists()) file.mkdirs();// 创建该文件夹目录
        OutputStream os = null;
        try {
            System.out.println("正在导出xlsx...");
            long start = System.currentTimeMillis();
            // .xlsx格式
            String filename = File.separator + start + ".xlsx";
            os = new FileOutputStream(file.getAbsolutePath() + File.separator + start + ".xlsx");
            ExcelUtil.exportExcel(titleList, studentArray, os, response, request, filename);
            System.out.println("导出完成...共" + list.size() + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
            System.out.println("文件路径：" + file.getAbsolutePath() + File.separator + start + ".xlsx");
            del(file.getAbsolutePath() + File.separator + start + ".xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }
}
