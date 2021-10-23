package com.example.SuccessCadets.readExcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel   {


    public  String getData() throws IOException {
        var fs = new FileInputStream("D:/Test.xlsx");
        var wb = new XSSFWorkbook(fs);
        String get =  wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        fs.close();
        return get;
//https://docs.google.com/spreadsheets/d/1CToQIqKrJkWVbkcxKTUk_uPgojOfQHn6516uiHe4MsE/edit?usp=sharing
    }

}
