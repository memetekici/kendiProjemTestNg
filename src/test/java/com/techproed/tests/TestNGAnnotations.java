package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    @BeforeMethod
    public void setUp(){
        System.out.println("This is Before method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("This is After method");
    }
    @Test(priority = 3)
    public void test05(){
        System.out.println("Test01");
    }
    @Test(priority = 5)
    //@Ignore
    public void test02(){
        System.out.println("Test02");
    }
    @Test(priority = 1)
    public void test03(){
        System.out.println("Test03");
    }
    @Test
    public void test04(){
        System.out.println("Test04");
    }
}
