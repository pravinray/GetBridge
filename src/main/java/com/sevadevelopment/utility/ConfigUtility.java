package com.sevadevelopment.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {

    Properties properties = new Properties();
    FileInputStream fileInputStream = null;

    public ConfigUtility() {
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getConfig(String configItem) {
        return properties.getProperty(configItem);
    }

}
