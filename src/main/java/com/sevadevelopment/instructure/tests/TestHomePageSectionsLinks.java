package com.sevadevelopment.instructure.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sevadevelopment.instructure.pageobjects.HomePageSections;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

public class TestHomePageSectionsLinks {

	HomePageSections homePageSections;
	WebDriver driver;
	ConfigUtility configUtility;
	String homePage = ("https://www.getbridge.com");

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() throws Exception {

		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		this.homePageSections = new HomePageSections(driver);
		// driver.manage().window().setSize(new Dimension(860, 669));
		driver.manage().window().maximize();
		driver.get(homePage);
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(description = "Test links in heading gradients section", priority = 1)
	public void verify1stSectionLinks() {
		homePageSections.clickOnSection1stLearnMoreBtn();
		String redirectedUrlOnBtnClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnBtnClick);
		Assert.assertEquals(redirectedUrlOnBtnClick, "https://www.getbridge.com/products/bridge-suite");

		// verify redirected page contents
		String redirectedPage1stContent = driver
				.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/div[1]/h1")).getText();
		Assert.assertTrue(redirectedPage1stContent.contains("The Bridge Suite"));
	}

	@Test(description = "Test links in logo carousel section", priority = 2)
	public void verify3rdSectionLinks() {
		homePageSections.clickOnSection3rdCustomerStoriesBtn();
		String redirectedUrlOnCustomerStoriesClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnCustomerStoriesClick);
		Assert.assertEquals(redirectedUrlOnCustomerStoriesClick, "https://www.getbridge.com/customer-stories");

		// verify redirected page contents
		String redirectedPage3rdContent = driver
				.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div[1]/section[1]/h1"))
				.getText();
		Assert.assertTrue(redirectedPage3rdContent.contains("Bridge Customer Success Stories"));
	}

	@Test(description = "Test links in feature section", priority = 3)
	public void verify4thSectionLinks() {
		homePageSections.clickOnSection4thSeeFeaturesBtn();
		String redirectedUrlOnSeeFeaturesClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnSeeFeaturesClick);
		Assert.assertEquals(redirectedUrlOnSeeFeaturesClick, "https://www.getbridge.com/features");

		// verify redirected page contents
		String redirectedPage4thContent = driver
				.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/div[2]/h1"))
				.getText();
		Assert.assertTrue(redirectedPage4thContent.contains("Bridge Features"));
	}

	@Test(description = "Test links in 3-col section", priority = 4)
	public void verify6thSectionLinks() {
		homePageSections.clickOnViewInfographic1stColBtn();
		String redirectedUrlOnViewInfographic1stColClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnViewInfographic1stColClick);
		Assert.assertEquals(redirectedUrlOnViewInfographic1stColClick,
				"https://www.getbridge.com/pdf/2017_9_Bridge_Infographic_PerformanceTrends.pdf");

		driver.navigate().back();
		homePageSections.clickOnViewInfographic2ndColBtn();
		String redirectedUrlOnViewInfographic2ndColClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnViewInfographic2ndColClick);
		Assert.assertEquals(redirectedUrlOnViewInfographic2ndColClick,
				"https://www.getbridge.com/pdf/2017_9_Bridge_Infographic_1tool3ways.pdf");

		driver.navigate().back();
		homePageSections.clickOnViewEbook3rdColBtn();
		String redirectedUrlOnViewEbookClick = driver.getCurrentUrl();
		System.out.println(redirectedUrlOnViewEbookClick);
		Assert.assertEquals(redirectedUrlOnViewEbookClick, "https://www.getbridge.com/lc/insights/workforce-evolution");
		String redirectedPageViewEbookContent = driver
				.findElement(By.xpath("//*[@id=\"workforce-evolution\"]/section[1]/div/h1")).getText();
		Assert.assertTrue(redirectedPageViewEbookContent.contains("Thriving In The Workplace Of 2020"));
	}
}
