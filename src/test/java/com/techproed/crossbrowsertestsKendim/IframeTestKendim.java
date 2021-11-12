package com.techproed.crossbrowsertestsKendim;

import com.techproed.utilities.TestBase;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTestKendim extends TestBaseCross {

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement text = driver.findElement(By.xpath("//h3"));
        System.out.println(text.getText());
        Assert.assertTrue(text.getText().contains("Editor"));


        driver.switchTo().frame(0);
        Thread.sleep(3000);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("This text box is inside the iframe");
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();

        WebElement elementelText = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementelText.isDisplayed());
    }
}
