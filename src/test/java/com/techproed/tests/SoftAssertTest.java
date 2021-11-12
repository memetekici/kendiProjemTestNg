package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        WebElement mesaj = driver.findElement(By.xpath("(//div[@class='jyfHyd'])[2]"));
        mesaj.click();

    }

    @Test
    public void hardAssertion(){

        WebElement gmailButton = driver.findElement(By.xpath("(//a[@class='gb_f'])[1]"));
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='gb_3 gb_4 gb_9d gb_3c']"));
        WebElement imagesButton = driver.findElement(By.xpath("(//a[@class='gb_f'])[2]"));
        //Assert.assertTrue(gmailButton.isDisplayed());

        Assert.assertTrue(signInButton.isDisplayed());
        System.out.println("ttttttttttttttttt");
        Assert.assertEquals(gmailButton.getText(),"Gmail");
        Assert.assertTrue(imagesButton.isDisplayed());

    }

    @Test
    public void softAssertion(){
        WebElement gmailButton = driver.findElement(By.xpath("(//a[@class='gb_f'])[1]"));
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='gb_3 gb_4 gb_9d gb_3c']"));
        WebElement imagesButton = driver.findElement(By.xpath("(//a[@class='gb_f'])[2]"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(gmailButton.getText(),"gmail");
        softAssert.assertEquals(imagesButton.getText(),"Images");
        softAssert.assertEquals(signInButton.getText(),"sign in");

        softAssert.assertAll();

    }
    @AfterMethod
    public  void tearDown(){
        driver.close();
    }
}
