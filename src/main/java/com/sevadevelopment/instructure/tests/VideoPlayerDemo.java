package com.sevadevelopment.instructure.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayerDemo {
	WebDriver driver;
	ConfigUtility configUtility;

	public Map<Long, WebDriver> driverMap = new ConcurrentHashMap();
	public WebDriverWait wait;
	public SeleniumDriverFactory tlDriverFactory = new SeleniumDriverFactory();

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid) throws Exception {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser, isGrid);

		driverMap.put(Thread.currentThread().getId(),SeleniumDriverFactory.getDriver());
		driver = driverMap.get(Long.valueOf(Thread.currentThread().getId()));

		driver.manage().window().maximize();
		driver.get("https://www.getbridge.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400)", "");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(description = "To verify video source is available")
	public void verifyPlayerPlayPause() throws Exception {
		
		String elementval = driver.findElement(By.className("paragraph-play-button")).getAttribute("data-wistiaid");
		System.out.println("WISTIA-VIDEO-ID: " + elementval);
		
		RestAssured.baseURI = "https://fast.wistia.net/embed/iframe/" + elementval;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		String contentType = response.header("Content-Type");
		System.out.println("Header body response type: " + contentType);
		
		assertTrue(contentType.contains("text/html"));
		
		

	}
}
