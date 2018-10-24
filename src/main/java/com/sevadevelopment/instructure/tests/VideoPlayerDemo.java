package com.sevadevelopment.instructure.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sevadevelopment.utility.SeleniumDriverFactory;

public class VideoPlayerDemo {
	WebDriver driver;
	Screen s = new Screen();
	Pattern image = new Pattern("src/main/resources/sikuliImages/1540350821759.png");

	@BeforeClass
	public void setupTestClass() throws InterruptedException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
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
		driver = new SeleniumDriverFactory().getDriver(properties.getProperty("browser"));
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	@BeforeMethod
	public void setupTestMethod() {
		driver.get("https://www.getbridge.com/?lead_source_description=instructure.com_");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void tearDownTestClass() {
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
