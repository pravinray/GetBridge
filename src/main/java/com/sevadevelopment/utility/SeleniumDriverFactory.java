package com.sevadevelopment.utility;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriverFactory  {

    public WebDriver getDriver(Browser browser) {
        switch(browser) {
            case chrome:
                if(SystemUtils.IS_OS_LINUX)
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
                else if(SystemUtils.IS_OS_WINDOWS)
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
                return new ChromeDriver();
            case firefox:
            default:
                if(SystemUtils.IS_OS_LINUX)
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckoDriver/geckodriver");
                else if(SystemUtils.IS_OS_WINDOWS)
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/gechoDriver/geckodriver.exe");
                return new FirefoxDriver();

        }
    }
}
