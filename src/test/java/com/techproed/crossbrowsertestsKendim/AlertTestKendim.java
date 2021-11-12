package com.techproed.crossbrowsertestsKendim;

import com.techproed.utilities.TestBaseCross;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTestKendim extends TestBaseCross {

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
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
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement secondAlertButton = driver.findElement(By.xpath("(//button)[2]"));
        secondAlertButton.click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(result.getText(),"You clicked: Cancel");
    }

    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
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
