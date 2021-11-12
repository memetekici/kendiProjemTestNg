package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowhandleExample extends TestBase {
    //Create a new Class Tests package: WindowHandleExample
    //Given user is on the https://the-internet.herokuapp.com/windows
    //Then user verifies the text : “Opening a new window”
    //Then user verifies the title of the page is “The Internet”
    //When user clicks on the “Click Here” button
    //Then user verifies the new window title is “New Window”
    //Then user verifies the text:  “New Window”

    @Test
    public void windowHandle(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(text.getText(),"Opening a new window");
        Assert.assertEquals(driver.getTitle(),"The Internet","Title is incorrect");

        WebElement clickButton = driver.findElement(By.xpath("(//a)[2]"));
        clickButton.click();
        String defaultWindow= driver.getWindowHandle();
        System.out.println(defaultWindow);
        driver.switchTo().window(defaultWindow);//İlk sayfayı handle yapmış olduk
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for(String w : allWindowHandles){
            if (!w.equals(defaultWindow)){
                driver.switchTo().window(w);
            }
        }

        Assert.assertEquals(driver.getTitle(),"New Window");
        WebElement newWindow = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(newWindow.getText(),"New Window");

        driver.switchTo().window(defaultWindow);
    }
}
