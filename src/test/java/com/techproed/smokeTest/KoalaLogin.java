package com.techproed.smokeTest;

import com.techproed.pages.KoalaLoginPage;
import com.techproed.pages.KoalaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KoalaLogin extends TestBase {

    @Test
    public void koalaLogin() throws InterruptedException {
        //driver.get("http://www.kaolapalace-qa-environment2.com/");
        driver.get(ConfigReader.getProperty("url"));
        KoalaMainPage koalaMainPage = new KoalaMainPage(driver);
        koalaMainPage.kaolaMainLoginButton.click();
        KoalaLoginPage koalaLoginPage = new KoalaLoginPage(driver);
        koalaLoginPage.kaolaUsername.sendKeys(ConfigReader.getProperty("username"));
        koalaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));
        koalaLoginPage.kaolaLoginButton.click();
        Thread.sleep(3000);
    }
}
