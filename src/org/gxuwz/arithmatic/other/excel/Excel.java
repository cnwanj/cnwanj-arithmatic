package org.gxuwz.arithmatic.other.excel;

import org.apache.poi.hssf.usermodel.*;

import java.io.IOException;

public class Excel {
    public void excel() throws IOException {
        // 1.创建一个workbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
        HSSFSheet sheet = wb.createSheet("XXX表");
        // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 4.创建单元格，设置值表头，设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 居中格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 设置表头
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("表头1");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("表头2");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("表头3");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("表头4");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("表头5");
        cell.setCellStyle(style);

    }

}
