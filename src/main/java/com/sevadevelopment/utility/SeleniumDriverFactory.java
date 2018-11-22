package com.sevadevelopment.utility;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class SeleniumDriverFactory  {

	private static OptionsManager optionsManager = new OptionsManager();
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized void setDriver(String browser, boolean isGrid) throws Exception {
		if (browser.equals("firefox")) {
			try {
				if(isGrid) {
					tlDriver.set(new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), optionsManager.getFirefoxOptions()));
					System.out.println("Test  running in FIREFOX container");
				}
				else {
					if (SystemUtils.IS_OS_LINUX)
						System.setProperty("webdriver.gecko.driver",
								"src/main/resources/drivers/geckoDriver/geckodriver_linux_64");
					else if (SystemUtils.IS_OS_WINDOWS)
						System.setProperty("webdriver.gecko.driver",
								"src/main/resources/drivers/geckoDriver/geckodriver.exe");

					tlDriver.set(new FirefoxDriver());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} else if (browser.equals("chrome")) {
			try {
				if(isGrid) {
					tlDriver.set(new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), optionsManager.getChromeOptions()));
					System.out.println("Test  running in CHROME container");
				}
				else {
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					options.addArguments("disable-infobars");
					options.addArguments("-disable-extensions");

					if (SystemUtils.IS_OS_LINUX)
						System.setProperty("webdriver.chrome.driver",
								"src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
					else if (SystemUtils.IS_OS_WINDOWS)
						System.setProperty("webdriver.chrome.driver",
								"src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");

					tlDriver.set(new ChromeDriver(options));
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	public static synchronized WebDriverWait getWait (WebDriver driver) {
		return new WebDriverWait(driver,20);
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
