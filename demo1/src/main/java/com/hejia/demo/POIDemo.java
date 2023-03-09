package com.hejia.demo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class POIDemo {
    @Test
    public void test1() {
        try {
            File file = new File("D:\\test\\collectiveTemplate.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFRow row = sheet.getRow(3);
            XSSFCell cell1 = row.getCell(3);
            cell1.setCellValue("测试一下");
            XSSFCell cell2 = row.getCell(14);
            cell2.setCellValue("测试一下");
            XSSFCell cell3 = row.getCell(19);
            cell3.setCellValue("测试一下");
            XSSFCell cell4 = row.getCell(23);
            cell4.setCellValue("测试一下");
            XSSFCell cell5 = row.getCell(26);
            cell5.setCellValue("测试一下");
            String fileName = System.currentTimeMillis() + ".xlsx";
            FileOutputStream outputStream = new FileOutputStream("D:\\test\\" + fileName);
            workbook.write(outputStream);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
