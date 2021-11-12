package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {
    //Create a class:ExplicitWaitTest1. Create a method: isEnabled
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click enable Button
    //And verify the message is equal to “It's enabled!”
    //And verify the textbox is enabled (I can type in the box)
    //And click on Disable button
    //And verify the message is equal to “It's disabled!”
    //And verify the textbox is disabled (I cannot type in the box)

    @Test
    public void isEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);

        //WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's enabled!");

        WebElement textBoxEnable = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBoxEnable.isEnabled());



    }
}
