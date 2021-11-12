package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);
        faceLoginPage.username.sendKeys("memet");
        faceLoginPage.password.sendKeys("2222");
        Thread.sleep(3000);
        faceLoginPage.loginButton.click();

        Thread.sleep(3000);
        String errorMessage = faceLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,"Girdiğin e-posta bir hesaba bağlı değil. Hesabını bul ve giriş yap.");


    }
}
