
package com.sevadevelopment.instructure.tests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sevadevelopment.instructure.pageobjects.BridgePageFooter;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

public class TestBridgeFooterLinks {
	WebDriver driver;
	BridgePageFooter bridgePageFooter;
	ConfigUtility configUtility;
	String url = "";
	String homePage = ("https://www.getbridge.com");

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() throws Exception {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		this.bridgePageFooter = new BridgePageFooter(driver);

		driver.manage().window().setSize(new Dimension(1500, 1200));
		driver.get(homePage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 4000)", "");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyAccessibilityUrl() {
		bridgePageFooter.clickOnAccessibilityLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://community.bridgeapp.com/docs/DOC-1629");
	}
	
	@Test(priority = 2)
	public void verifyPrivacyPolicyUrl() {
		bridgePageFooter.clickOnPrivacyPolicyLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://www.instructure.com/policies/privacy/");
	}
}
