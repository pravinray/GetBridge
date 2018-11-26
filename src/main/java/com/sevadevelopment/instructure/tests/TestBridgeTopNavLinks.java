
package com.sevadevelopment.instructure.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.sevadevelopment.instructure.pageobjects.BridgePageTopNav;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestBridgeTopNavLinks {
	WebDriver driver;
	BridgePageTopNav bridgePageTopNav;
	ConfigUtility configUtility;
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	String homePage = "https://www.getbridge.com";

	public Map<Long, WebDriver> driverMap = new ConcurrentHashMap();

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid) throws Exception {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser, isGrid);

		/*driverMap.put(Thread.currentThread().getId(),SeleniumDriverFactory.getDriver());
		driver = driverMap.get(Long.valueOf(Thread.currentThread().getId()));*/

		driver = SeleniumDriverFactory.getDriver();

		driver.manage().window().maximize();
		driver.get("https://www.getbridge.com");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		System.out.println("After Method started");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test
	public void checkAlllinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println(url);
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println(url);
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();

				Assert.assertEquals(respCode, 200);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void verifyProductTabInTopNav() {

		// hover on tab and verify its contents
		bridgePageTopNav.hoverOnProductTab();
		String popUpTitle = bridgePageTopNav.getTextProductPopUpTitle();
		Assert.assertTrue(popUpTitle.contains("Explore the Bridge Suite"));
		String popUpOptions =bridgePageTopNav.getTextProductPopUpOptions();
		System.out.println(popUpOptions);
		Assert.assertTrue(popUpOptions.contains("LEARN"));
		Assert.assertTrue(popUpOptions.contains("PERFORM"));
		Assert.assertTrue(popUpOptions.contains("PRACTICE"));

		// click on tab and verify the redirected page URL and contents
		bridgePageTopNav.clickOnProductTab();
		String productUrl = driver.getCurrentUrl();
		System.out.println(productUrl);
		Assert.assertEquals(productUrl, "https://www.getbridge.com/products");
		String productPageTitle = bridgePageTopNav.getTextProductPageTitle();
		Assert.assertEquals(productPageTitle, "The Bridge Suite");
	}

	
	@Test
	public void verifySolutionsUrl() {
		bridgePageTopNav.hoverOnSolutionsTab();
		String popUpOptions1 =driver.findElement(By.xpath("//*[@id=\"solutions-page\"]/div/div[1]/h3")).getText();
		System.out.println(popUpOptions1);
		String popUpOptions2 =driver.findElement(By.xpath("//*[@id=\"solutions-page\"]/div/div[2]/h3")).getText();
		System.out.println(popUpOptions2);
		Assert.assertTrue(popUpOptions1.contains("BRIDGE FOR"));
		Assert.assertTrue(popUpOptions2.contains("USE CASES"));
		bridgePageTopNav.clickOnSolutionsLink();
		String solutionsUrl = driver.getCurrentUrl();
		System.out.println(solutionsUrl);
		Assert.assertEquals(solutionsUrl, "https://www.getbridge.com/solutions");
	}

	@Test
	public void verifyCustomerStoriesUrl() {
		bridgePageTopNav.hoverOnCustomerStoriesTab();
		String popUpOptions1 =driver.findElement(By.xpath("//*[@id=\"customer-stories-page\"]/div[1]/div[1]/p")).getText();
		System.out.println(popUpOptions1);
		String popUpOptions2 =driver.findElement(By.xpath("//*[@id=\"customer-stories-page\"]/div[1]/div[2]/p")).getText();
		System.out.println(popUpOptions2);
		String popUpOptions3 =driver.findElement(By.xpath("//*[@id=\"customer-stories-page\"]/div[1]/div[3]/p")).getText();
		System.out.println(popUpOptions3);
		Assert.assertTrue(popUpOptions1.contains("Movement Mortgage surmounts"));
		Assert.assertTrue(popUpOptions2.contains("With Bridge, SafetyNow"));
		Assert.assertTrue(popUpOptions3.contains("Clemson University set"));
		bridgePageTopNav.clickOnCustomerStoriesLink();
		String customerStoriesUrl = driver.getCurrentUrl();
		System.out.println(customerStoriesUrl);
		Assert.assertEquals(customerStoriesUrl, "https://www.getbridge.com/customer-stories");
	}


	@Test
	public void verifyResourcesUrl() {
		System.out.println("This Test is being Executed 1");
		bridgePageTopNav.hoverOnResourcesTab();
		String popUpOptions1 =driver.findElement(By.xpath("//*[@id=\"resources-page\"]/div/div[1]/a[1]/h3")).getText();
		System.out.println(popUpOptions1);
		String popUpOptions2 =driver.findElement(By.xpath("//*[@id=\"resources-page\"]/div/div[2]/a[1]/h3")).getText();
		System.out.println(popUpOptions2);
		String popUpOptions3 =driver.findElement(By.xpath("//*[@id=\"resources-page\"]/div/div[3]/h3")).getText();
		System.out.println(popUpOptions3);
		Assert.assertTrue(popUpOptions1.contains("LEARNING CENTER"));
		Assert.assertTrue(popUpOptions2.contains("EVENTS"));
		Assert.assertTrue(popUpOptions3.contains("ADDITIONAL RESOURCES"));
		bridgePageTopNav.clickOnResourcesLink();
		String resourcesUrl = driver.getCurrentUrl();
		System.out.println(resourcesUrl);
		Assert.assertEquals(resourcesUrl, "https://www.getbridge.com/resources");
		System.out.println("This Test is being completed 1");
	}

	@Test
	public void verifyAboutUrl() {
		System.out.println("This Test is being Executed 2");
		bridgePageTopNav.hoverOnAboutTab();
		String popUpOptions1 =driver.findElement(By.xpath("//*[@id=\"about-page\"]/div/div[1]/div/a/h3")).getText();
		System.out.println(popUpOptions1);
		String popUpOptions2 =driver.findElement(By.xpath("//*[@id=\"about-page\"]/div/div[2]/div/a/h3")).getText();
		System.out.println(popUpOptions2);
		String popUpOptions3 =driver.findElement(By.xpath("//*[@id=\"about-page\"]/div/div[3]/div/a/h3")).getText();
		System.out.println(popUpOptions3);
		String popUpOptions4 =driver.findElement(By.xpath("//*[@id=\"about-page\"]/div/div[4]/div/a/h3")).getText();
		System.out.println(popUpOptions4);
		Assert.assertTrue(popUpOptions1.contains("WHO WE ARE"));
		Assert.assertTrue(popUpOptions2.contains("WORK WITH US"));
		Assert.assertTrue(popUpOptions3.contains("LEADERSHIP"));
		Assert.assertTrue(popUpOptions4.contains("NEWS & PRESS RELEASES"));
		bridgePageTopNav.clickOnAboutLink();
		String aboutUrl = driver.getCurrentUrl();
		System.out.println(aboutUrl);
		Assert.assertEquals(aboutUrl, "https://www.getbridge.com/about");
		System.out.println("This Test is being Completed 2");
	}

	@Test
	public void verifyBlogUrl() {
		System.out.println("This Test is being Executed 3");
		bridgePageTopNav.clickOnBlogLink();
		String blogUrl = driver.getCurrentUrl();
		System.out.println(blogUrl);
		Assert.assertEquals(blogUrl, "https://www.getbridge.com/blog");
		System.out.println("This Test is being completed 3");
	}

	@Test
	public void verifyBookADemoUrl() {
		System.out.println("This Test is being Executed 4");
		bridgePageTopNav.clickOnBookADemoLink();
		String bookADemoUrl = driver.getCurrentUrl();
		System.out.println(bookADemoUrl);
		Assert.assertEquals(bookADemoUrl, "https://www.getbridge.com/demo");
		System.out.println("This Test is being completed 4");
	}
}
