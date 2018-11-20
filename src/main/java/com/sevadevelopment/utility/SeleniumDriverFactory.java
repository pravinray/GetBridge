package com.sevadevelopment.utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class SeleniumDriverFactory  {

    public WebDriver getDriver(String browser) throws Exception {
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(browser);
            cap.setPlatform(Platform.LINUX);


            ChromeOptions options = new ChromeOptions();
            options.merge(cap);
            options.addArguments("--start-maximized");
            System.out.println("flow came till here 0000");

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            System.out.println("Flow came till here ::1111");
            return driver;
        }else if (browser.equalsIgnoreCase("firefox")){

                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(browser);
                cap.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                System.out.println("Flow came till here ::1111");
                return driver;
            }
            else {
                throw new Exception("Browser is not corrrect");
        }
    }
}
