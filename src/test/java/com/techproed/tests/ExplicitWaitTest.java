package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExplicitWaitTest extends TestBase {

    @Test
    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("(//button)[1]"));
        removeButton.click();

        WebElement goneMessage = driver.findElement(By.id("message"));
        //WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(goneMessage.getText(),"It's gone!");

    }
}
