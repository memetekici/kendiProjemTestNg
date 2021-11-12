package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass extends TestBase {
    //Create a class: ActionsClass1
    //Create a test method : contextClickMethod() and test the following scenario:
    //Given user is on the https://the-internet.herokuapp.com/context_menu
    //When use Right clicks on the box
    //Then verify the alert message is “You selected a context menu”
    //Then accept the alert
    @Test
    public void action(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertText,"You selected a context menu","Yanlış oldu");
        driver.switchTo().alert().accept();
    }
}
