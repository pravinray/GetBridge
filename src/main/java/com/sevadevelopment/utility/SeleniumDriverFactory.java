package com.sevadevelopment.utility;

import java.util.Collections;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriverFactory  {

    public WebDriver getDriver(String browser) {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("disable-infobars");
		options.addArguments("-disable-extensions");
        if(browser.equals("chrome")) {
            if (SystemUtils.IS_OS_LINUX)
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
            else if (SystemUtils.IS_OS_WINDOWS)
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
            driver = new ChromeDriver(options);
        }
        else if (browser.equals("firefox")) {
            if (SystemUtils.IS_OS_LINUX)
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckoDriver/geckodriver");
            else if (SystemUtils.IS_OS_WINDOWS)
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckoDriver/geckodriver.exe");
            driver =  new FirefoxDriver(options);
        }
        else {
            if (SystemUtils.IS_OS_LINUX)
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
            else if (SystemUtils.IS_OS_WINDOWS)
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
            driver = new ChromeDriver(options);
        }
        
        return driver;
    }
}
