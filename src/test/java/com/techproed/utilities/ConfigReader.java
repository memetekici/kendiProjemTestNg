package com.techproed.utilities;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //This class will read the Data From configurarion.properties file
    private static Properties properties;

    static {


        String path = "configuration.properties";

        //Opening the configuration.properties
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Create a method to READ
    public static String getProperty(String key){

        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("username"));
    }

}