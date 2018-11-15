
package com.sevadevelopment.instructure.tests;

import org.openqa.selenium.By;
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

		driver.manage().window().setSize(new Dimension(860, 669));
//		driver.manage().window().maximize();
		driver.get(homePage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 50000)", "");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyAccessibilityUrl() throws Exception {
		bridgePageFooter.clickOnAccessibilityLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://community.bridgeapp.com/docs/DOC-1629");
		
		//verify accessibility redirected page contents
		String accessibilityRedirectedPage = driver.findElement(By.xpath("//*[@id=\"jive-body-main\"]/div[2]")).getText();
		Assert.assertTrue(accessibilityRedirectedPage.contains("Bridge Voluntary Product Accessibility Template"));
		Assert.assertTrue(accessibilityRedirectedPage.contains("Web Content Accessibility Guidelines 2.0"));
	}
	
	@Test(priority = 2)
	public void verifyPrivacyPolicyUrl() {
		bridgePageFooter.clickOnPrivacyPolicyLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://www.instructure.com/policies/privacy/");
		
		//verify Privacy Policy redirected page contents
		String privacyPolicyRedirectedPage = driver.findElement(By.id("spotMtext")).getText();
		Assert.assertTrue(privacyPolicyRedirectedPage.contains("Instructure Privacy Policy"));
	}
	
	@Test(priority = 3)
	public void verifyTermsOfUseUrl() {
		bridgePageFooter.clickOnTermsOfUse();
		String termsOfUseUrl = driver.getCurrentUrl();
		System.out.println(termsOfUseUrl);
		Assert.assertEquals(termsOfUseUrl, "https://www.getbridge.com/policies/terms-of-use");
		
		//verify Privacy Policy redirected page contents
		Assert.assertTrue(driver.findElement(By.className("PRtitle2")).getText().contains("Terms of Use"));
		Assert.assertTrue(driver.findElement(By.className("PRbody")).getText().contains("Agreement between You and Instructure"));
	}
	
	@Test(priority = 4)
	public void verifyContactSalesUrl() throws Exception {
		String contactSalesNumber = driver.findElement(By.xpath("//*[@id=\"footer-top-links\"]/div/a[4]")).getAttribute("href");
		System.out.println(contactSalesNumber);
		Assert.assertEquals(contactSalesNumber, "tel:+1-877-576-5364");
	}
	
	@Test(priority = 5)
	public void verifyManagementUrl() {
		bridgePageFooter.clickOnManagement();
		String managementUrl = driver.getCurrentUrl();
		System.out.println(managementUrl);
		Assert.assertEquals(managementUrl, "https://www.getbridge.com/features/continuous-1%3A1-management");
		
		//verify management redirected page contents
		String managementRedirectedPage = driver.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/section/section[1]/div/div[1]")).getText();
		Assert.assertTrue(managementRedirectedPage.contains("Continuous 1:1 Management"));
	}
}
