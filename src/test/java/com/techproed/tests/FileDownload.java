package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload extends TestBase {

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        String userFolder = System.getProperty("user.home");
        System.out.println(userFolder);

        WebElement homor = driver.findElement(By.linkText("homer.jpg"));
        homor.click();

        String filePath = "C:\\Users\\lenovo\\Download\\homer.jpg";

        boolean isDownload = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownload);

    }
}
