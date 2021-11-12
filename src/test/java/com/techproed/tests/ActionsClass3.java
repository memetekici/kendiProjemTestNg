package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass3 extends TestBase {
    //Create a class: ActionClass3
    //Create test method : keysUpDown()
    //Go to amazon
    //Send iPhone X prices => convert small letter capital vice versa.
    //Highlight the search box by double clicking
    @Test
    public void keysUpDown(){
        driver.get("https://www.amazon.com/");
        WebElement searchButton = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.keyDown(searchButton, Keys.SHIFT).
                sendKeys("iPhone X prices").
                keyDown(searchButton,Keys.SHIFT).perform();
    }
}
