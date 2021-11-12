package com.techproed.exelautomation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {
        String pathOfFile = "C:\\Users\\lenovo\\IdeaProjects\\kendiProjemTestNg\\src\\test\\java\\resources\\Capitals (2).xlsx";
        FileInputStream fileInputStream = new FileInputStream(pathOfFile);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println("ilk celldeki data " + cell);
        Cell cell1 = row.getCell(1);
        System.out.println("İkinci celldeki data " + cell1);
        String secondRowFirstCell = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println("ikinci satırın ilk celli : " + secondRowFirstCell);

        String üçüncüRowunİkinciCell = workbook.getSheetAt(0).getRow(2).getCell(1).toString();
        System.out.println(üçüncüRowunİkinciCell);
        int lastRowNumber = workbook.getSheetAt(0).getLastRowNum();
        System.out.println(++lastRowNumber);//Çünkü index 0 dan başlıyor

        int gerçekteKullanılanSatırSaysısı = sheet.getPhysicalNumberOfRows();
        System.out.println(gerçekteKullanılanSatırSaysısı);

        Map<String,String> map = new HashMap<>();
        int cellNumber = 0;
        for(int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber ++){
            map.put(sheet.getRow(rowNumber).getCell(cellNumber).toString(),sheet.getRow(rowNumber).getCell(cellNumber + 1).toString());
        }
        System.out.println(map);

    }
}
