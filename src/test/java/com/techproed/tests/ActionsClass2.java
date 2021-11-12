package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass2 extends TestBase {
    //Create a class: ActionClass2
    //Create test method : hoverOver() and test the following scenario:
    //Given user is on the https://www.amazon.com/
    //When use click on “Your Account” link
    //Then verify the page title contains “Your Account”
    //HOMEWORK
    //Create another method: imageTest()
    //Hover over the Try Prime
    //And Verify the image displays.
    @Test
    public  void hoverOver(){
        driver.get("https://www.amazon.com/");
        WebElement hoverOverElement = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverElement).perform();
        WebElement account = driver.findElement(By.linkText("Account"));
        account.click();
        Assert.assertEquals(driver.getTitle(),"Your Account");




    }
}
