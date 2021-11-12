package com.techproed.exelautomation;

import com.techproed.pages.DataTablesPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import com.techproed.utilities.ReusableMethods;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {
    DataTablesPage dtPage = new DataTablesPage();

    ExcelUtil excelUtil;
    List<Map<String,String>> testData;
    @Test
    public void excelAutomation(){

        excelUtil = new ExcelUtil("C:\\Users\\lenovo\\IdeaProjects\\kendiProjemTestNg\\src\\test\\java\\resources\\exceldata.xlsx","datatablessheet");
        testData = excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String,String> w : testData){
            System.out.println(w);
        }
        for (Map<String,String> w : testData){
            System.out.println(w.get("firstname"));
        }
        for (Map<String,String> w : testData){
            Driver.getDriver().get(ConfigReader.getProperty("data_table_url"));
            dtPage.newButton.click();
            dtPage.firstName.sendKeys(w.get("firstname"));
            dtPage.lastName.sendKeys(w.get("lastname"));
            dtPage.position.sendKeys(w.get("position"));
            dtPage.office.sendKeys(w.get("office"));
            dtPage.extension.sendKeys(w.get("extension"));
            dtPage.startDate.sendKeys(w.get("startdate"));
            dtPage.day.click();
            dtPage.salary.sendKeys(w.get("salary"));
            dtPage.createButton.click();
            dtPage.searchBox.sendKeys(w.get("firstname"));
            ReusableMethods.waitFor(1);
        }
    }
}
