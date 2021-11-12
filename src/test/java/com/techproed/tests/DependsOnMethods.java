package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    @Test
    public void logIn(){
        System.out.println("This is Log in Test");
    }

    @Test
    public void homePage(){
        System.out.println("This is home page");
        Assert.assertEquals(4,3);
    }

    @Test(dependsOnMethods = "homePage")
    public void searchTest(){
        System.out.println("This is search test");
    }

    @Test
    public void veriftTest(){
        System.out.println("This is verify Test");
    }
}
