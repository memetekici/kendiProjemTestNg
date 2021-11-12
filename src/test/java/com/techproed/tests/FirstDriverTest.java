package com.techproed.tests;

import com.techproed.pages.KoalaLoginPage;
import com.techproed.pages.KoalaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FirstDriverTest {

    @Test
    public void firstDriverTest(){
        Driver.getDriver().get(ConfigReader.getProperty("koala_url"));
        KoalaMainPage koalaMainPage = new KoalaMainPage(Driver.getDriver());
        koalaMainPage.kaolaMainLoginButton.click();
        KoalaLoginPage koalaLoginPage = new KoalaLoginPage(Driver.getDriver());
        koalaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        koalaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        koalaLoginPage.kaolaLoginButton.click();

        Driver.closeDriver();


    }
}
