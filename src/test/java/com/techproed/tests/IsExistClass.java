package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsExistClass extends TestBase {
    @Test
    public void exist(){
        String path = "C:\\Users\\lenovo\\Desktop\\20180720_145325.jpg";

        boolean fileExist = Files.exists(Paths.get(path));
        Assert.assertTrue(fileExist);
    }
}
