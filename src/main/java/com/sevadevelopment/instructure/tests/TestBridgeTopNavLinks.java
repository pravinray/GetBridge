
package com.sevadevelopment.instructure.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevadevelopment.instructure.pageobjects.BridgePageTopNav;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class TestBridgeTopNavLinks {
	WebDriver driver;
	BridgePageTopNav bridgePageTopNav;
	ConfigUtility configUtility;
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	String homePage = ("https://www.getbridge.com");

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		this.bridgePageTopNav = new BridgePageTopNav(driver);

		driver.manage().window().maximize();
		driver.get(homePage);
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority = 1)
	@DataProvider()
	public void checkAlllinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			// System.out.println(url);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Test(priority = 2)
	public void verifyProductTabInTopNav() {

		// hover on tab and verify its contents
		bridgePageTopNav.hoverOnProductTab();
		String popUpTitle = driver.findElement(By.xpath("//*[@id=\"page-title\"]/h2")).getText();
		Assert.assertTrue(popUpTitle.contains("Explore the Bridge Suite"));
		String popUpOptions = driver.findElement(By.xpath("//*[@id=\"tabs\"]")).getText();
		System.out.println(popUpOptions);
		Assert.assertTrue(popUpOptions.contains("LEARN"));
		Assert.assertTrue(popUpOptions.contains("PERFORM"));
		Assert.assertTrue(popUpOptions.contains("PRACTICE"));

		// click on tab and verify the redirected page URL and contents
		bridgePageTopNav.clickOnProductTab();
		String productUrl = driver.getCurrentUrl();
		System.out.println(productUrl);
		Assert.assertEquals(productUrl, "https://www.getbridge.com/products");
		String productPageTitle = driver
				.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/h1"))
				.getText();
		Assert.assertEquals(productPageTitle, "The Bridge Suite");
	}

	// *[@id="solutions-page"]/div
	@Test(priority = 3)
	public void verifySolutionsUrl() {
		bridgePageTopNav.clickOnSolutionsLink();

		// String popUpOptions =
		// driver.findElement(By.cssSelector("div.content-item")).getText();
		// System.out.println(popUpOptions);
		// Assert.assertTrue(popUpOptions.contains("Bridge For"));
		// Assert.assertTrue(popUpOptions.contains("Use Cases"));
		String solutionsUrl = driver.getCurrentUrl();
		System.out.println(solutionsUrl);
		Assert.assertEquals(solutionsUrl, "https://www.getbridge.com/solutions");
	}

	@Test(priority = 4)
	public void verifyCustomerStoriesUrl() {
		bridgePageTopNav.clickOnCustomerStoriesLink();
		String customerStoriesUrl = driver.getCurrentUrl();
		System.out.println(customerStoriesUrl);
		Assert.assertEquals(customerStoriesUrl, "https://www.getbridge.com/customer-stories");
	}

	@Test(priority = 5)
	public void verifyResourcesUrl() {
		bridgePageTopNav.clickOnResourcesLink();
		String resourcesUrl = driver.getCurrentUrl();
		System.out.println(resourcesUrl);
		Assert.assertEquals(resourcesUrl, "https://www.getbridge.com/lc");
	}

	@Test(priority = 6)
	public void verifyAboutUrl() {
		bridgePageTopNav.clickOnAboutLink();
		String aboutUrl = driver.getCurrentUrl();
		System.out.println(aboutUrl);
		Assert.assertEquals(aboutUrl, "https://www.getbridge.com/about");
	}

	@Test(priority = 7)
	public void verifyBlogUrl() {
		bridgePageTopNav.clickOnBlogLink();
		String blogUrl = driver.getCurrentUrl();
		System.out.println(blogUrl);
		Assert.assertEquals(blogUrl, "https://www.getbridge.com/blog");
	}

	@Test(priority = 8)
	public void verifyBookADemoUrl() {
		bridgePageTopNav.clickOnBookADemoLink();
		String bookADemoUrl = driver.getCurrentUrl();
		System.out.println(bookADemoUrl);
		Assert.assertEquals(bookADemoUrl, "https://www.getbridge.com/demo");
	}
}
