
package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.BridgePageTopNav;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class TestBridgeTopNavLinks extends BaseTest{

	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	//GenerateTestReport generateTestReport = new GenerateTestReport(driver);

	@AfterSuite
	public void doAfterSuite() {
		///generateTestReport.flushReport(driver);
	}

	@BeforeMethod
	@Parameters({ "browser", "isGrid" })
	public void setupTestMethod(String browser, boolean isGrid) {
		System.out.println("Before Method started ::" + Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser, isGrid);
		driver = SeleniumDriverFactory.getDriver();



		driver.manage().window().maximize();
		driver.get(homePage);
		//generateTestReport.startReport(method);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		System.out.println("After Method started");
		//generateTestReport.getReport(result);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test
	public void checkAlllinks() {
		System.out.println("starting test checkAllLinks =====");
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
		System.out.println("=== before pageobject initialization ===="+driver);
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);
		System.out.println("=== after pageobject initialization ====");

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
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		bridgePageTopNav.hoverOnSolutionsTab();
		String popUpOptions1 = bridgePageTopNav.getTextSolutionsPopUpOptions1();
		System.out.println(popUpOptions1);
		String popUpOptions2 = bridgePageTopNav.getTextSolutionsPopUpOptions2();
		System.out.println(popUpOptions2);
		Assert.assertTrue(popUpOptions1.contains("BRIDGE FOR"));
		Assert.assertTrue(popUpOptions2.contains("USE CASES"));
		bridgePageTopNav.clickOnSolutionsLink();
		String solutionsUrl = driver.getCurrentUrl();
		System.out.println(solutionsUrl);
		Assert.assertEquals(solutionsUrl, "https://www.getbridge.com/solutions");
		String solutionPageTitle =bridgePageTopNav.getTextSolutionsPageTitle();
		Assert.assertEquals(solutionPageTitle, "Bridge Software Solutions");
	}

	@Test
	public void verifyCustomerStoriesUrl() {
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		bridgePageTopNav.hoverOnCustomerStoriesTab();
		String popUpOptions1 = bridgePageTopNav.getTextCustomerStoriesPopUpOptions1();
		System.out.println(popUpOptions1);
		String popUpOptions2 = bridgePageTopNav.getTextCustomerStoriesPopUpOptions2();
		System.out.println(popUpOptions2);
		String popUpOptions3 = bridgePageTopNav.getTextCustomerStoriesPopUpOptions3();
		System.out.println(popUpOptions3);
		Assert.assertTrue(popUpOptions1.contains("Movement Mortgage surmounts"));
		Assert.assertTrue(popUpOptions2.contains("With Bridge, SafetyNow"));
		Assert.assertTrue(popUpOptions3.contains("Clemson University set"));
		bridgePageTopNav.clickOnCustomerStoriesLink();
		String customerStoriesUrl = driver.getCurrentUrl();
		System.out.println(customerStoriesUrl);
		Assert.assertEquals(customerStoriesUrl, "https://www.getbridge.com/customer-stories");
		String customerStoriesPageTitle = bridgePageTopNav.getTextCustomerStoriesPageTitle();
		Assert.assertEquals(customerStoriesPageTitle, "Bridge Customer Success Stories");
	}

	@Test
	public void verifyResourcesUrl() {
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		System.out.println("This Test is being Executed 1");
		bridgePageTopNav.hoverOnResourcesTab();
		String popUpOptions1 = bridgePageTopNav.getTextResourcesPopUpOptions1();
		System.out.println(popUpOptions1);
		String popUpOptions2 = bridgePageTopNav.getTextResourcesPopUpOptions2();
		System.out.println(popUpOptions2);
		String popUpOptions3 = bridgePageTopNav.getTextResourcesPopUpOptions3();
		System.out.println(popUpOptions3);
		Assert.assertTrue(popUpOptions1.contains("LEARNING CENTER"));
		Assert.assertTrue(popUpOptions2.contains("EVENTS"));
		Assert.assertTrue(popUpOptions3.contains("ADDITIONAL RESOURCES"));
		bridgePageTopNav.clickOnResourcesLink();
		String resourcesUrl = driver.getCurrentUrl();
		System.out.println(resourcesUrl);
		Assert.assertEquals(resourcesUrl, "https://www.getbridge.com/resources");
		String resourcesPageTitle = bridgePageTopNav.getTextResourcesPageTitle();
		Assert.assertEquals(resourcesPageTitle, "Bridge Resources");
		System.out.println("This Test is being completed 1");
	}

	@Test
	public void verifyAboutUrl() {
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		System.out.println("This Test is being Executed 2");
		bridgePageTopNav.hoverOnAboutTab();
		String popUpOptions1 = bridgePageTopNav.getTextAboutPopUpOptions1();
		System.out.println(popUpOptions1);
		String popUpOptions2 = bridgePageTopNav.getTextAboutPopUpOptions2();
		System.out.println(popUpOptions2);
		String popUpOptions3 = bridgePageTopNav.getTextAboutPopUpOptions3();
		System.out.println(popUpOptions3);
		String popUpOptions4 = driver.findElement(By.xpath("//*[@id=\"about-page\"]/div/div[4]/div/a/h3")).getText();
		System.out.println(popUpOptions4);
		Assert.assertTrue(popUpOptions1.contains("WHO WE ARE"));
		Assert.assertTrue(popUpOptions2.contains("WORK WITH US"));
		Assert.assertTrue(popUpOptions3.contains("LEADERSHIP"));
		Assert.assertTrue(popUpOptions4.contains("NEWS & PRESS RELEASES"));
		bridgePageTopNav.clickOnAboutLink();
		String aboutUrl = driver.getCurrentUrl();
		System.out.println(aboutUrl);
		Assert.assertEquals(aboutUrl, "https://www.getbridge.com/about");
		String aboutPageTitle = bridgePageTopNav.getTextAboutPageTitle();
		Assert.assertEquals(aboutPageTitle, "About Bridge");
		System.out.println("This Test is being Completed 2");
	}

	@Test
	public void verifyBlogUrl() {
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		System.out.println("This Test is being Executed 3");
		bridgePageTopNav.clickOnBlogLink();
		String blogUrl = driver.getCurrentUrl();
		System.out.println(blogUrl);
		Assert.assertEquals(blogUrl, "https://www.getbridge.com/blog");
		System.out.println("This Test is being completed 3");
	}

	@Test
	public void verifyBookADemoUrl() {
		BridgePageTopNav bridgePageTopNav = new BridgePageTopNav(driver);

		System.out.println("This Test is being Executed 4");
		bridgePageTopNav.clickOnBookADemoLink();
		String bookADemoUrl = driver.getCurrentUrl();
		System.out.println(bookADemoUrl);
		Assert.assertEquals(bookADemoUrl, "https://www.getbridge.com/demo");
		String bookADemoPageTitle = bridgePageTopNav.getTextBookADemoPageTitle();
		Assert.assertEquals(bookADemoPageTitle, "What’s your type?");
		System.out.println("This Test is being completed 4");
	}
}
