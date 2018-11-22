package com.sevadevelopment.utility;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Collections;

public class SeleniumDriverFactory {

	public WebDriver getDriver(String browser, String executionMethod, String seleniumHubUrl) throws Exception {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("disable-infobars");
		options.addArguments("-disable-extensions");
		//options.addArguments("--headless");
		URL hubUrl;
		DesiredCapabilities capability = new DesiredCapabilities();

		if (executionMethod.equals("fromGrid")) {

			capability.setPlatform(Platform.LINUX);
			hubUrl = new URL(seleniumHubUrl);
			if (browser.equals("firefox")) {
				capability = DesiredCapabilities.firefox();
			} else if (browser.equals("chrome")) {
				capability = DesiredCapabilities.chrome();
			} else {
				capability = DesiredCapabilities.chrome();
			}
			capability.setBrowserName(browser);
			driver = new RemoteWebDriver(hubUrl, capability);

		} else {

			if (browser.equals("chrome")) {
				if (SystemUtils.IS_OS_LINUX)
					System.setProperty("webdriver.chrome.driver",
							"src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
				else if (SystemUtils.IS_OS_WINDOWS)
					System.setProperty("webdriver.chrome.driver",
							"src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
				driver = new ChromeDriver(options);
			} else if (browser.equals("firefox")) {
				if (SystemUtils.IS_OS_LINUX)
					System.setProperty("webdriver.gecko.driver",
							"src/main/resources/drivers/geckoDriver/geckodriver_linux_64");
				else if (SystemUtils.IS_OS_WINDOWS)
					System.setProperty("webdriver.gecko.driver",
							"src/main/resources/drivers/geckoDriver/geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				if (SystemUtils.IS_OS_LINUX)
					System.setProperty("webdriver.chrome.driver",
							"src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
				else if (SystemUtils.IS_OS_WINDOWS)
					System.setProperty("webdriver.chrome.driver",
							"src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
				driver = new ChromeDriver(options);
			}
		}
		return driver;
	}
}
