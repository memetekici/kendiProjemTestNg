package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class uploadFileTest extends TestBase {
    @Test
    public void upload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String pathFile = "C:\\Users\\lenovo\\Desktop\\20180720_145325.jpg";
        chooseFile.sendKeys(pathFile);

        //Click on upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(3000);

        //Verify "File Uploaded!" message
        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        String actualText = fileUploadedText.getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText,expectedText);
    }
}
