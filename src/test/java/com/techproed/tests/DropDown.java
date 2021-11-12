package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void dropDownTest() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select option = new Select(dropDown);
        Thread.sleep(3000);
        option.selectByIndex(1);
    }
    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select option = new Select(dropDown);
        Thread.sleep(3000);
        option.selectByValue("2");
    }
    @Test(groups = "regression1")//runcertaingroups.xml için bu tagı koyduk
    public void selectByVisibleText() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select option = new Select(dropDown);
        Thread.sleep(3000);
        option.selectByVisibleText("Option 1");
    }
    @Test
    public void printAllValues() throws InterruptedException {
        List<WebElement> dropDown = driver.findElements(By.id("dropdown"));
        for(WebElement w : dropDown){
            System.out.println(w.getText());
        }
    }
    @Test
    public void dropDownSize(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown);
        List<WebElement> dropDownList = options.getOptions();
        System.out.println(dropDownList.size());
        Assert.assertEquals(dropDownList.size(),3,"expected is 3");


    }
    @Test
    public void getFirstSelectedOptionTest() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown);
        Thread.sleep(3000);
        System.out.println(options.getFirstSelectedOption().getText());
    }



    @AfterMethod
    public void teatDown(){
        driver.close();
    }
}
