package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void acceptAlert(){
        WebElement firstButton = driver.findElement(By.xpath("(//button)[1]"));
        firstButton.click();
        String firstAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(firstAlertText,"I am a JS Alert");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You successfully clicked an alert");

    }
    @Test
    public void dismissAlert(){
        WebElement secondAlertButton = driver.findElement(By.xpath("(//button)[2]"));
        secondAlertButton.click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You clicked: Cancel");
    }

    @Test
    public void sendKeysAlert(){
        WebElement thirdAlertButton = driver.findElement(By.xpath("(//button)[3]"));
        thirdAlertButton.click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"I am a JS prompt");
        driver.switchTo().alert().sendKeys("Hello Word");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You entered: Hello Word");

    }
}
