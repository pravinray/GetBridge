
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
	
	@Test(priority = 6)
	public void verifyTimelineModuleUrl() {
		bridgePageFooter.clickOnTimelineModule();
		String timelineModuleUrl = driver.getCurrentUrl();
		System.out.println(timelineModuleUrl);
		Assert.assertEquals(timelineModuleUrl, "https://www.getbridge.com/features/employee-timeline");
		
		//verify timeline module redirected page contents
		String timelineModuleRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(timelineModuleRedirectedPage.contains("Employee Timeline"));
	}
	
	@Test(priority = 7)
	public void verifySkillsAsseementUrl() {
		bridgePageFooter.clickOnSkillsAssessment();
		String skillsAsseessmentUrl = driver.getCurrentUrl();
		System.out.println(skillsAsseessmentUrl);
		Assert.assertEquals(skillsAsseessmentUrl, "https://www.getbridge.com/features/skills-assessment");
		
		//verify skills management redirected page contents
		String skillsAssessmentRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(skillsAssessmentRedirectedPage.contains("Skills Assessment"));
	}
	
	@Test(priority = 8)
	public void verifyGoalsAndTasksUrl() {
		bridgePageFooter.clickOnGoalsAndTasks();
		String goalsAndTasksUrl = driver.getCurrentUrl();
		System.out.println(goalsAndTasksUrl);
		Assert.assertEquals(goalsAndTasksUrl, "https://www.getbridge.com/features/goals-and-tasks");
		
		//verify goals and tasks redirected page contents
		String goalsAndTasksRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(goalsAndTasksRedirectedPage.contains("Goals and Tasks"));
	}
	
	@Test(priority = 9)
	public void verifyRobustReportingUrl() {
		bridgePageFooter.clickOnRobustReporting();
		String robustReportingUrl = driver.getCurrentUrl();
		System.out.println(robustReportingUrl);
		Assert.assertEquals(robustReportingUrl, "https://www.getbridge.com/features/robust-reporting");
		
		//verify robust reporting redirected page contents
		String robustReportingRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(robustReportingRedirectedPage.contains("Robust Reporting"));
	}
	
	@Test(priority = 10)
	public void verifyRetainUrl() {
		bridgePageFooter.clickOnRetain();
		String retainUrl = driver.getCurrentUrl();
		System.out.println(retainUrl);
		Assert.assertEquals(retainUrl, "https://www.getbridge.com/features/retain");
		
		//verify retain redirected page contents
		String retainRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(retainRedirectedPage.contains("Retain"));
	}
	
	@Test(priority = 11)
	public void verifyContentServicesUrl() {
		bridgePageFooter.clickOnContentServices();
		String contentServicesUrl = driver.getCurrentUrl();
		System.out.println(contentServicesUrl);
		Assert.assertEquals(contentServicesUrl, "https://www.getbridge.com/features/content-services");
		
		//verify content services redirected page contents
		String contentServicesRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(contentServicesRedirectedPage.contains("Content Services"));
	}
	
	@Test(priority = 12)
	public void verifyOffTheShelfCoursesUrl() {
		bridgePageFooter.clickOnOffTheShelfCourses();
		String offTheShelfCoursesUrl = driver.getCurrentUrl();
		System.out.println(offTheShelfCoursesUrl);
		Assert.assertEquals(offTheShelfCoursesUrl, "https://www.getbridge.com/features/lms-content");
		
		//verify off the shelf courses redirected page contents
		String offTheShelfCoursesRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(offTheShelfCoursesRedirectedPage.contains("Off-the-Shelf-Courses"));
	}
	
	@Test(priority = 13)
	public void verifyArcVideoUrl() {
		bridgePageFooter.clickOnArcVideo();
		String arcVideoUrl = driver.getCurrentUrl();
		System.out.println(arcVideoUrl);
		Assert.assertEquals(arcVideoUrl, "https://www.getbridge.com/features/arc-video-for-bridge");
		
		//verify arc video redirected page contents
		String arcVideoRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(arcVideoRedirectedPage.contains("Arc Video"));
	}
	
	@Test(priority = 14)
	public void verifyLearnFromYourLearningUrl() {
		bridgePageFooter.clickOnLearnFromYourLearning();
		String learnFromYourLearningUrl = driver.getCurrentUrl();
		System.out.println(learnFromYourLearningUrl);
		Assert.assertEquals(learnFromYourLearningUrl, "https://www.getbridge.com/features/learn-more");
		
		//verify learn more redirected page contents
		String learnMoreRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(learnMoreRedirectedPage.contains("Learn from your Learning"));
	}
	
	@Test(priority = 15)
	public void verifyManagerDashboardUrl() {
		bridgePageFooter.clickOnManagerDashboard();
		String managerDashboardUrl = driver.getCurrentUrl();
		System.out.println(managerDashboardUrl);
		Assert.assertEquals(managerDashboardUrl, "https://www.getbridge.com/features/manager-dashboard");
		
		//verify manager dashboard redirected page contents
		String managerDashboardRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(managerDashboardRedirectedPage.contains("Manager Dashboard"));
	}
	
	@Test(priority = 16)
	public void verifyAdminUrl() {
		bridgePageFooter.clickOnAdmin();
		String adminUrl = driver.getCurrentUrl();
		System.out.println(adminUrl);
		Assert.assertEquals(adminUrl, "https://www.getbridge.com/features/admin-features");
		
		//verify admin redirected page contents
		String adminRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(adminRedirectedPage.contains("Admin"));
	}
	
	@Test(priority = 17)
	public void verifyEasyToUseUrl() {
		bridgePageFooter.clickOnEasyToUse();
		String easyToUseUrl = driver.getCurrentUrl();
		System.out.println(easyToUseUrl);
		Assert.assertEquals(easyToUseUrl, "https://www.getbridge.com/features/ease-of-use");
		
		//verify easy to use redirected page contents
		String easyToUseRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(easyToUseRedirectedPage.contains("Easy to Use, Easy to Love"));
	}
	
	@Test(priority = 18)
	public void verifyAnytimeAnywhereUrl() {
		bridgePageFooter.clickOnAnytimeAnywhere();
		String anytimeAnywhereUrl = driver.getCurrentUrl();
		System.out.println(anytimeAnywhereUrl);
		Assert.assertEquals(anytimeAnywhereUrl, "https://www.getbridge.com/features/learn-anywhere");
		
		//verify anytime anywhere redirected page contents
		String anytimeAnywhereRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(anytimeAnywhereRedirectedPage.contains("Anytime, Anywhere Learning"));
	}
}
