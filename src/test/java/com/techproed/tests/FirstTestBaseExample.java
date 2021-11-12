package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstTestBaseExample extends TestBase {

    @Test
    public void test1(){
        driver.get("https://www.google.com/");
        WebElement mesaj = driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]"));
        mesaj.click();
    }
}
