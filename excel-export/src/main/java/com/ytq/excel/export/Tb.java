package com.ytq.excel.export;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author yuantongqin
 * 2019/8/28
 */
public class Tb {
//    public String createExcel(HttpServletResponse response) throws IOException {
//        //获取查询结果的数据,reportlist为别的方法查询出来的数据，格式为List<Object[]>,其实这里不管reportlist是什么数据格式，这里只要对其进行封装就行了
//
//        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
//
//
//        //创建HSSFWorkbook对象(excel的文档对象)
//        HSSFWorkbook wb = new HSSFWorkbook();
//        //建立新的sheet对象（excel的表单）
//        HSSFSheet sheet = wb.createSheet("报表");
//        sheet.setDefaultColumnWidth(20);
//        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
//        HSSFRow row1 = sheet.createRow(0);
//        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
//        HSSFCell cell = row1.createCell(0);
//
//        // 1.生成字体对象
//        HSSFFont font = wb.createFont();
//        font.setFontHeightInPoints((short) 12);
//        font.setFontName("新宋体");
//
//        // 2.生成样式对象，这里的设置居中样式和版本有关，我用的poi用HSSFCellStyle.ALIGN_CENTER会报错，所以用下面的
//        HSSFCellStyle style = wb.createCellStyle();
////      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中样式
//        style.setFont(font); // 调用字体样式对象
//        style.setWrapText(true);
//        style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式
//
//        // 3.单元格应用样式
//        cell.setCellStyle(style);
//
//        //设置单元格内容
//        cell.setCellValue("报表");
//        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
//
//        //在sheet里创建第二行
//        HSSFRow row2 = sheet.createRow(1);
//        //创建单元格并设置单元格内容及样式
//        HSSFCell cell0 = row2.createCell(0);
//        cell0.setCellStyle(style);
//        cell0.setCellValue("码类型");
//
//        HSSFCell cell1 = row2.createCell(1);
//        cell1.setCellStyle(style);
//        cell1.setCellValue("码");
//
//        HSSFCell cell2 = row2.createCell(2);
//        cell2.setCellStyle(style);
//        cell2.setCellValue("姓名");
//
//        //单元格宽度自适应
////        sheet.autoSizeColumn((short) 3);
////        sheet.autoSizeColumn((short) 4);
////        sheet.autoSizeColumn((short) 5);
////        sheet.autoSizeColumn((short) 6);
////        sheet.autoSizeColumn((short) 7);
////        sheet.autoSizeColumn((short) 8);
////        sheet.autoSizeColumn((short) 9);
//        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
//        for (int i = 0; i < 10; i++) {
//            //单元格宽度自适应
//            sheet.autoSizeColumn((short) 0);
//            sheet.autoSizeColumn((short) 1);
////            sheet.autoSizeColumn((short) 2);
//            //从sheet第三行开始填充数据
//            HSSFRow rowx = sheet.createRow(i + 2);
//            //这里的hospitalid,idnumber等都是前面定义的全局变量
//            String hospitalid = "hospitalid"+i;
//            HSSFCell cell00 = rowx.createCell(0);
//            cell00.setCellStyle(style);
//            cell00.setCellValue(hospitalid);
//
//            String idnumber = "idnumber"+i;
//            HSSFCell cell01 = rowx.createCell(1);
//            cell01.setCellStyle(style);
//            cell01.setCellValue(idnumber);
//
//            String name = "name"+i;
//            HSSFCell cell02 = rowx.createCell(2);
//            cell02.setCellStyle(style);
//            cell02.setCellValue(name);
//
//
//        }
//        //输出Excel文件
//        OutputStream output = response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=report.xls");//文件名这里可以改
//        response.setContentType("application/msexcel");
//        wb.write(output);
//        output.close();
//        return null;
//    }

}
