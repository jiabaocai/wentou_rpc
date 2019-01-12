//package com.bwtservice.config.Excel;
//
//import cn.hutool.json.JSONArray;
//import com.bwtservice.entity.GoodsPhone;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import sun.misc.BASE64Encoder;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//
//public class FileUtils {
//    /**
//     * 下载文件时，针对不同浏览器，进行附件名的编码
//     *
//     * @param filename
//     *            下载文件名
//     * @param agent
//     *            客户端浏览器
//     * @return 编码后的下载附件名
//     * @throws IOException
//     */
//    public static String encodeDownloadFilename(String filename, String agent)
//            throws IOException {
//        if (agent.contains("Firefox")) { // 火狐浏览器
//            filename = "=?UTF-8?B?"
//                    + new BASE64Encoder().encode(filename.getBytes("utf-8"))
//                    + "?=";
//            filename = filename.replaceAll("\r\n", "");
//        } else { // IE及其他浏览器
//            filename = URLEncoder.encode(filename, "utf-8");
//            filename = filename.replace("+"," ");
//        }
//        return filename;
//    }
//
//    public static void excelExport(HttpServletResponse response, HttpServletRequest request, HSSFWorkbook hssfWorkbook, String filename){
//
//        // 通过浏览器下载导出
//        // 设置表头信息
//        ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            response.setContentType("application/vnd.ms-excel,charset=utf-8");
//            String agent = request.getHeader("user-agent");
//            filename = encodeDownloadFilename(filename, agent);
//            response.setHeader("Content-Disposition", new String(("attachment;filename=" + filename).getBytes(), "iso-8859-1"));
//            hssfWorkbook.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            // 关闭
//            try {
//                hssfWorkbook.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static HashMap<String, Object> convertToMap(Object obj) throws IllegalAccessException {
//
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        Field[] fields = obj.getClass().getDeclaredFields();
//        for (int i = 0, len = fields.length; i < len; i++) {
//            String varName = fields[i].getName();
//            boolean accessFlag = fields[i].isAccessible();
//            fields[i].setAccessible(true);
//
//            Object o = fields[i].get(obj);
//            if (o != null)
//                map.put(varName, o.toString());
//
//            fields[i].setAccessible(accessFlag);
//        }
//
//        return map;
//    }
//
//    public static void byExcelExport(HttpServletResponse response, HttpServletRequest request, List<String> list12, List<String> list22, List<GoodsPhone> list) throws IllegalAccessException {
//
//    }
//
//
//
//    public static void byExcelExport1(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<ContractDto> list) throws IllegalAccessException {
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
//        // 用于格式化单元格的数据
//        // 设置字体
//        HSSFFont font = hssfWorkbook.createFont();
//        font.setFontHeightInPoints((short) 20); //字体高度
//        font.setColor(HSSFFont.COLOR_RED); //字体颜色
//        font.setFontName("黑体"); //字体
//        font.setItalic(true); //是否使用斜体
//        // 设置单元格类型
//        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
//        cellStyle.setWrapText(true);
//        // 添加单元格注释
//        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
//        HSSFPatriarch patr = sheet.createDrawingPatriarch();
//        // 定义注释的大小和位置,详见文档
//        // 生成表头
//        HSSFRow headRow = sheet.createRow(0);
//        for (int i = 0; i < list1.size(); i++) {
//            headRow.createCell(i).setCellValue(list1.get(i));
//        }
//        headRow.setRowStyle(cellStyle);
//        // 将数据插入表中
//        for (ContractDto customer : list) {
//            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
//            Map<String, Object> map = convertToMap(customer);
//            for (int i = 0; i < list2.size(); i++) {
//                if(map.get(list2.get(i))!=null){
//                    dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
//                }else {
//                    dataRow.createCell(i).setCellValue("");
//                }
//                sheet.autoSizeColumn((short)i); //调整第n列宽度
//            }
//            dataRow.setRowStyle(cellStyle);
//        }
//        String filename = UUID.randomUUID()+".xls";
//        FileUtils.excelExport(response,request,hssfWorkbook,filename);
//    }
//
//    public static void byExcelExport2(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<Client> list) throws IllegalAccessException {
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
//        // 用于格式化单元格的数据
//        // 设置字体
//        HSSFFont font = hssfWorkbook.createFont();
//        font.setFontHeightInPoints((short) 20); //字体高度
//        font.setColor(HSSFFont.COLOR_RED); //字体颜色
//        font.setFontName("黑体"); //字体
//        font.setItalic(true); //是否使用斜体
//        // 设置单元格类型
//        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
//        cellStyle.setWrapText(true);
//        // 添加单元格注释
//        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
//        HSSFPatriarch patr = sheet.createDrawingPatriarch();
//        // 定义注释的大小和位置,详见文档
//        // 生成表头
//        HSSFRow headRow = sheet.createRow(0);
//        for (int i = 0; i < list1.size(); i++) {
//            headRow.createCell(i).setCellValue(list1.get(i));
//        }
//        headRow.setRowStyle(cellStyle);
//        // 将数据插入表中
//        for (Client customer : list) {
//            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
//            Map<String, Object> map = convertToMap(customer);
//            for (int i = 0; i < list2.size(); i++) {
//                if(map.get(list2.get(i))!=null){
//                    dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
//                }else {
//                    dataRow.createCell(i).setCellValue("");
//                }
//                sheet.autoSizeColumn((short)i); //调整第n列宽度
//            }
//            dataRow.setRowStyle(cellStyle);
//        }
//        String filename = UUID.randomUUID()+".xls";
//        FileUtils.excelExport(response,request,hssfWorkbook,filename);
//    }
//
//    public static void byExcelExport3(HttpServletResponse response, HttpServletRequest request, List<String> list1, List<String> list2, List<ReportDto> list) throws IllegalAccessException {
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//        HSSFSheet sheet = hssfWorkbook.createSheet("统计表");
//        // 用于格式化单元格的数据
//        // 设置字体
//        HSSFFont font = hssfWorkbook.createFont();
//        font.setFontHeightInPoints((short) 20); //字体高度
//        font.setColor(HSSFFont.COLOR_RED); //字体颜色
//        font.setFontName("黑体"); //字体
//        font.setItalic(true); //是否使用斜体
//        // 设置单元格类型
//        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
//        cellStyle.setWrapText(true);
//        // 添加单元格注释ZA
//        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
//        HSSFPatriarch patr = sheet.createDrawingPatriarch();
//        // 定义注释的大小和位置,详见文档
//        // 生成表头
//        HSSFRow headRow = sheet.createRow(0);
//        for (int i = 0; i < list1.size(); i++) {
//            headRow.createCell(i).setCellValue(list1.get(i));
//        }
//        headRow.setRowStyle(cellStyle);
//        // 将数据插入表中
//        for (ReportDto customer : list) {
//            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
//            Map<String, Object> map = convertToMap(customer);
//            for (int i = 0; i < list2.size(); i++) {
//                if(map.get(list2.get(i))!=null){
//                    dataRow.createCell(i).setCellValue(map.get(list2.get(i)).toString());
//                }else {
//                    dataRow.createCell(i).setCellValue("");
//                }
//                sheet.autoSizeColumn((short)i); //调整第n列宽度
//            }
//            dataRow.setRowStyle(cellStyle);
//        }
//
//        String filename = UUID.randomUUID()+".xls";
//        FileUtils.excelExport(response,request,hssfWorkbook,filename);
//    }
//
//
//
//
//
//
//    public static void main(String[] args) throws IOException {
//        /**
//         * 模拟100W条数据,存入JsonArray,此处使用fastJson(号称第一快json解析)快速解析大数据量数据
//         * 至于容量问题,Java数组的length必须是非负的int，所以它的理论最大值就是java.lang.Integer.MAX_VALUE = 2^31-1 = 2147483647。
//         * 由于xlsx最大支持行数为1048576行,此处模拟了1048573调数据,剩下的3条占用留给自定义的excel的头信息和列项.
//         */
//        // int count = 100000;
//        // int count = 1000000;
//        int count = 10000;
//        JSONArray studentArray = new JSONArray();
////        这个list使数据库生成的
//        for(int i=0;i<count;i++){
//            GoodsPhone goodsPhone=new GoodsPhone();
//            goodsPhone.setId(i);
//            goodsPhone.setColor("2323");
//            goodsPhone.setCategory_id(11);
//            goodsPhone.setModel("2323");
//            studentArray.add(goodsPhone);
//        }
//        /*
//         * titleList存放了2个元素,分别为titleMap和headMap
//         */
//        ArrayList<LinkedHashMap> titleList = new ArrayList<LinkedHashMap>();
//        // 1.titleMap存放了该excel的头信息
//        LinkedHashMap<String, String> titleMap = new LinkedHashMap<String, String>();
//        titleMap.put("title1", "POI导出大数据量Excel");
//        titleMap.put("title2", "本内容只限内部使用，禁止传阅");
//        LinkedHashMap<String, String> headMap = new LinkedHashMap<String, String>();
//        headMap.put("id", "ID");
//        headMap.put("color", "颜色");
//        headMap.put("category_id", "生日");
//        headMap.put("model", "身高");
//
//        titleList.add(titleMap);
//        titleList.add(headMap);
//
//
//        File file = new File("/");
//        if (!file.exists()) file.mkdirs();// 创建该文件夹目录
//        OutputStream os = null;
//        try {
//            System.out.println("正在导出xlsx...");
//            long start = System.currentTimeMillis();
//            // .xlsx格式
//            os = new FileOutputStream(file.getAbsolutePath() + File.separator + start + ".xlsx");
//            ExcelUtil.exportExcel(titleList, studentArray, os);
//            System.out.println("导出完成...共" + count + "条数据,用时" + (System.currentTimeMillis() - start) + "毫秒");
//            System.out.println("文件路径：" + file.getAbsolutePath() + File.separator + start + ".xlsx");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            os.close();
//        }
//
//}
//
//
//}
