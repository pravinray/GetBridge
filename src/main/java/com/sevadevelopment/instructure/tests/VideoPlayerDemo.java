package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideoPlayerDemo {
	WebDriver driver;
	Screen s = new Screen();
	Pattern image = new Pattern("src/main/resources/sikuliImages/1540383765278.png");
	ConfigUtility configUtility;

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() throws Exception {
//		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		
		//remote server for test execution
		DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://172.19.0.1:17631/wd/hub"), dc);
		
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get("https://www.getbridge.com/?lead_source_description=instructure.com_");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(description = "To verify player play/pause button")
	public void verifyPlayerPlayPause() throws Exception {

		// click on play button
		s.click(image);

		// verify pause button is visible
		s.exists("src/main/resources/sikuliImages/1540380781770.png");

		// verify volume/setting/fullscreen button is visible
		s.exists("src/main/resources/sikuliImages/1540381250940.png");

	}
}
