
package com.sevadevelopment.instructure.tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.*;
import com.sevadevelopment.instructure.pageobjects.BridgePageFooter;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBridgeFooterLinks {
	WebDriver driver;
	BridgePageFooter bridgePageFooter;
	ConfigUtility configUtility;
	String url = "";
	String homePage = ("https://www.getbridge.com");
	ExtentReports extent;
	ExtentTest logger;

	public Map<Long, WebDriver> driverMap = new ConcurrentHashMap();
	public WebDriverWait wait;
	public SeleniumDriverFactory tlDriverFactory = new SeleniumDriverFactory();

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid, Method method) throws Exception {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser,isGrid);

		driver = SeleniumDriverFactory.getDriver();
		driverMap.put(Thread.currentThread().getId(),SeleniumDriverFactory.getDriver());
		driver = driverMap.get(Long.valueOf(Thread.currentThread().getId()));

		driver.manage().window().maximize();
		driver.get("https://www.getbridge.com");

		this.bridgePageFooter = new BridgePageFooter(driver);
		driver.manage().window().setSize(new Dimension(860, 669));
		// driver.manage().window().maximize();
		driver.get(homePage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 50000)", "");

		extent = new ExtentReports("src/main/resources/extentReport.html", true);
		extent.addSystemInfo("Host Name", "Bridge Testing").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Pravin Ray")
				.addSystemInfo("OS Architecture", System.getProperty("os.arch"));
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName();
		String browserVersion = cap.getVersion().toString();
		extent.addSystemInfo("Browser Name", browserName).addSystemInfo("Browser Version", browserVersion);
		extent.loadConfig(new File("src/main/resources/extent-config.xml"));

		// start logging for report generation
		logger = extent.startTest(method.getName());
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed error is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}
		extent.endTest(logger);
		extent.flush();
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test
	public void verifyAccessibilityUrl() {
		bridgePageFooter.clickOnAccessibilityLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://community.bridgeapp.com/docs/DOC-1629");

		// verify accessibility redirected page contents
		String accessibilityRedirectedPage = driver.findElement(By.xpath("//*[@id=\"jive-body-main\"]/div[2]"))
				.getText();
		Assert.assertTrue(accessibilityRedirectedPage.contains("Bridge Voluntary Product Accessibility Template"));
		Assert.assertTrue(accessibilityRedirectedPage.contains("Web Content Accessibility Guidelines 2.0"));
	}

	@Test
	public void verifyPrivacyPolicyUrl() {
		bridgePageFooter.clickOnPrivacyPolicyLink();
		String accessibilityUrl = driver.getCurrentUrl();
		System.out.println(accessibilityUrl);
		Assert.assertEquals(accessibilityUrl, "https://www.instructure.com/policies/privacy/");

		// verify Privacy Policy redirected page contents
		String privacyPolicyRedirectedPage = driver.findElement(By.id("spotMtext")).getText();
		Assert.assertTrue(privacyPolicyRedirectedPage.contains("Instructure Privacy Policy"));
	}

	@Test
	public void verifyTermsOfUseUrl() {
		bridgePageFooter.clickOnTermsOfUse();
		String termsOfUseUrl = driver.getCurrentUrl();
		System.out.println(termsOfUseUrl);
		Assert.assertEquals(termsOfUseUrl, "https://www.getbridge.com/policies/terms-of-use");

		// verify Privacy Policy redirected page contents
		Assert.assertTrue(driver.findElement(By.className("PRtitle2")).getText().contains("Terms of Use"));
		Assert.assertTrue(
				driver.findElement(By.className("PRbody")).getText().contains("Agreement between You and Instructure"));
	}

	@Test
	public void verifyContactSalesUrl() throws Exception {
		String contactSalesNumber = driver.findElement(By.xpath("//*[@id=\"footer-top-links\"]/div/a[4]"))
				.getAttribute("href");
		System.out.println(contactSalesNumber);
		Assert.assertEquals(contactSalesNumber, "tel:+1-877-576-5364");
	}

	@Test
	public void verifyManagementUrl() {
		bridgePageFooter.clickOnManagement();
		String managementUrl = driver.getCurrentUrl();
		System.out.println(managementUrl);
		Assert.assertEquals(managementUrl, "https://www.getbridge.com/features/continuous-1%3A1-management");

		// verify management redirected page contents
		String managementRedirectedPage = driver
				.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/section/section[1]/div/div[1]")).getText();
		Assert.assertTrue(managementRedirectedPage.contains("Continuous 1:1 Management"));
	}

	@Test
	public void verifyTimelineModuleUrl() {
		bridgePageFooter.clickOnTimelineModule();
		String timelineModuleUrl = driver.getCurrentUrl();
		System.out.println(timelineModuleUrl);
		Assert.assertEquals(timelineModuleUrl, "https://www.getbridge.com/features/employee-timeline");

		// verify timeline module redirected page contents
		String timelineModuleRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(timelineModuleRedirectedPage.contains("Employee Timeline"));
	}

	@Test
	public void verifySkillsAsseessmentUrl() {
		bridgePageFooter.clickOnSkillsAssessment();
		String skillsAsseessmentUrl = driver.getCurrentUrl();
		System.out.println(skillsAsseessmentUrl);
		Assert.assertEquals(skillsAsseessmentUrl, "https://www.getbridge.com/features/skills-assessment");

		// verify skills management redirected page contents
		String skillsAssessmentRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(skillsAssessmentRedirectedPage.contains("Skills Assessment"));
	}

	@Test
	public void verifyGoalsAndTasksUrl() {
		bridgePageFooter.clickOnGoalsAndTasks();
		String goalsAndTasksUrl = driver.getCurrentUrl();
		System.out.println(goalsAndTasksUrl);
		Assert.assertEquals(goalsAndTasksUrl, "https://www.getbridge.com/features/goals-and-tasks");

		// verify goals and tasks redirected page contents
		String goalsAndTasksRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(goalsAndTasksRedirectedPage.contains("Goals and Tasks"));
	}

	@Test
	public void verifyRobustReportingUrl() {
		bridgePageFooter.clickOnRobustReporting();
		String robustReportingUrl = driver.getCurrentUrl();
		System.out.println(robustReportingUrl);
		Assert.assertEquals(robustReportingUrl, "https://www.getbridge.com/features/robust-reporting");

		// verify robust reporting redirected page contents
		String robustReportingRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(robustReportingRedirectedPage.contains("Robust Reporting"));
	}

	@Test
	public void verifyRetainUrl() {
		bridgePageFooter.clickOnRetain();
		String retainUrl = driver.getCurrentUrl();
		System.out.println(retainUrl);
		Assert.assertEquals(retainUrl, "https://www.getbridge.com/features/retain");

		// verify retain redirected page contents
		String retainRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(retainRedirectedPage.contains("Retain"));
	}

	@Test
	public void verifyContentServicesUrl() {
		bridgePageFooter.clickOnContentServices();
		String contentServicesUrl = driver.getCurrentUrl();
		System.out.println(contentServicesUrl);
		Assert.assertEquals(contentServicesUrl, "https://www.getbridge.com/features/content-services");

		// verify content services redirected page contents
		String contentServicesRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(contentServicesRedirectedPage.contains("Content Services"));
	}

	@Test
	public void verifyOffTheShelfCoursesUrl() {
		bridgePageFooter.clickOnOffTheShelfCourses();
		String offTheShelfCoursesUrl = driver.getCurrentUrl();
		System.out.println(offTheShelfCoursesUrl);
		Assert.assertEquals(offTheShelfCoursesUrl, "https://www.getbridge.com/features/lms-content");

		// verify off the shelf courses redirected page contents
		String offTheShelfCoursesRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(offTheShelfCoursesRedirectedPage.contains("Off-the-Shelf-Courses"));
	}

	@Test
	public void verifyArcVideoUrl() {
		bridgePageFooter.clickOnArcVideo();
		String arcVideoUrl = driver.getCurrentUrl();
		System.out.println(arcVideoUrl);
		Assert.assertEquals(arcVideoUrl, "https://www.getbridge.com/features/arc-video-for-bridge");

		// verify arc video redirected page contents
		String arcVideoRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(arcVideoRedirectedPage.contains("Arc Video"));
	}

	@Test
	public void verifyLearnFromYourLearningUrl() {
		bridgePageFooter.clickOnLearnFromYourLearning();
		String learnFromYourLearningUrl = driver.getCurrentUrl();
		System.out.println(learnFromYourLearningUrl);
		Assert.assertEquals(learnFromYourLearningUrl, "https://www.getbridge.com/features/learn-more");

		// verify learn more redirected page contents
		String learnMoreRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(learnMoreRedirectedPage.contains("Learn from your Learning"));
	}

	@Test
	public void verifyManagerDashboardUrl() {
		bridgePageFooter.clickOnManagerDashboard();
		String managerDashboardUrl = driver.getCurrentUrl();
		System.out.println(managerDashboardUrl);
		Assert.assertEquals(managerDashboardUrl, "https://www.getbridge.com/features/manager-dashboard");

		// verify manager dashboard redirected page contents
		String managerDashboardRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(managerDashboardRedirectedPage.contains("Manager Dashboard"));
	}

	@Test
	public void verifyAdminUrl() {
		bridgePageFooter.clickOnAdmin();
		String adminUrl = driver.getCurrentUrl();
		System.out.println(adminUrl);
		Assert.assertEquals(adminUrl, "https://www.getbridge.com/features/admin-features");

		// verify admin redirected page contents
		String adminRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(adminRedirectedPage.contains("Admin"));
	}

	@Test
	public void verifyEasyToUseUrl() {
		bridgePageFooter.clickOnEasyToUse();
		String easyToUseUrl = driver.getCurrentUrl();
		System.out.println(easyToUseUrl);
		Assert.assertEquals(easyToUseUrl, "https://www.getbridge.com/features/ease-of-use");

		// verify easy to use redirected page contents
		String easyToUseRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(easyToUseRedirectedPage.contains("Easy to Use, Easy to Love"));
	}

	@Test
	public void verifyAnytimeAnywhereUrl() {
		bridgePageFooter.clickOnAnytimeAnywhere();
		String anytimeAnywhereUrl = driver.getCurrentUrl();
		System.out.println(anytimeAnywhereUrl);
		Assert.assertEquals(anytimeAnywhereUrl, "https://www.getbridge.com/features/learn-anywhere");

		// verify anytime anywhere redirected page contents
		String anytimeAnywhereRedirectedPage = driver.findElement(By.className("feature-title")).getText();
		Assert.assertTrue(anytimeAnywhereRedirectedPage.contains("Anytime, Anywhere Learning"));
	}

	@Test
	public void verifyContactTelephoneEmailAndLocation() {
		String contactTelNo = driver.findElement(By.xpath("//*[@id=\"footer-phone\"]/a")).getAttribute("href");
		Assert.assertEquals(contactTelNo, "tel:+1877.576.5364");

		String contactEmail = driver.findElement(By.xpath("//*[@id=\"footer-email\"]/a")).getAttribute("href");
		Assert.assertEquals(contactEmail, "mailto:info@getbridge.com");

		String contactLocationUrl = driver.findElement(By.xpath("//*[@id=\"footer-address\"]/a")).getAttribute("href");
		Assert.assertEquals(contactLocationUrl, "https://goo.gl/maps/zrKJGEnDyhu");

		String contactLocationText1 = driver.findElement(By.xpath("//*[@id=\"footer-address\"]/a/text()[1]")).getText();
		Assert.assertEquals(contactLocationText1, "6630 South 3000 east, Suite 700");

		String contactLocationText2 = driver.findElement(By.xpath("//*[@id=\"footer-address\"]/a/text()[2]")).getText();
		Assert.assertEquals(contactLocationText2, "Salt Lake City, UT 84121");
	}

	@Test
	public void verifySocialNetworkPagesUrl() {
		String fbUrl = driver.findElement(By.xpath("//*[@id=\"footer-social-icons\"]/a[1]")).getAttribute("href");
		Assert.assertEquals(fbUrl, "https://www.facebook.com/GetBridge/");

		String twitterUrl = driver.findElement(By.xpath("//*[@id=\"footer-social-icons\"]/a[2]")).getAttribute("href");
		Assert.assertEquals(twitterUrl, "https://twitter.com/getbridge");

		String youtubeUrl = driver.findElement(By.xpath("//*[@id=\"footer-social-icons\"]/a[3]")).getAttribute("href");
		Assert.assertEquals(youtubeUrl, "https://www.youtube.com/user/bridgelms");

		String linkedinUrl = driver.findElement(By.xpath("//*[@id=\"footer-social-icons\"]/a[4]")).getAttribute("href");
		Assert.assertEquals(linkedinUrl, "https://www.linkedin.com/showcase/get-bridge/");
	}

	@Test
	public void verifyBottomSupportTermsUrl() {
		bridgePageFooter.clickOnSupportTerms();
		String supportTermsUrl = driver.getCurrentUrl();
		System.out.println(supportTermsUrl);
		Assert.assertEquals(supportTermsUrl, "https://www.getbridge.com/support-terms");

		// verify support terms redirected page contents
		String supportTermsRedirectedPage = driver.findElement(By.xpath("//*[@id=\"support-body-text\"]/div/div[1]/h3"))
				.getText();
		Assert.assertTrue(supportTermsRedirectedPage.contains("Support Terms"));
	}

	@Test
	public void verifyBottomPrivacyPolicyUrl() {
		bridgePageFooter.clickOnBottomPrivacyPolicy();
		String bottomPrivacyPolicyUrl = driver.getCurrentUrl();
		Assert.assertEquals(bottomPrivacyPolicyUrl, "https://www.instructure.com/policies/privacy/");

		// verify bottom privacy policy redirected page contents
		String privacyPolicyRedirectedPage = driver.findElement(By.id("spotMtext")).getText();
		Assert.assertTrue(privacyPolicyRedirectedPage.contains("Instructure Privacy Policy"));
	}

	@Test
	public void verifyBottomTermsOfUseUrl() {
		bridgePageFooter.clickOnBottomTermsOfUse();
		String bottomTermsOfUseUrl = driver.getCurrentUrl();
		System.out.println(bottomTermsOfUseUrl);
		Assert.assertEquals(bottomTermsOfUseUrl, "https://www.getbridge.com/policies/terms-of-use");

		// verify bottom terms of use redirected page contents
		String supportTermsRedirectedPage = driver.findElement(By.className("PRtitle2")).getText();
		Assert.assertTrue(supportTermsRedirectedPage.contains("Terms of Use"));
	}

	@Test
	public void verifyBottomAccessibilityUrl() {
		bridgePageFooter.clickOnBottomAccessibility();
		String bottomAccessibilityUrl = driver.getCurrentUrl();
		System.out.println(bottomAccessibilityUrl);
		Assert.assertEquals(bottomAccessibilityUrl, "https://community.bridgeapp.com/docs/DOC-1629");

		// verify bottom accessibility redirected page contents
		String bottomAccessibilityRedirectedPage = driver
				.findElement(By.xpath("//*[@id=\\\"jive-body-main\\\"]/div[2]")).getText();
		Assert.assertTrue(
				bottomAccessibilityRedirectedPage.contains("Bridge Voluntary Product Accessibility Template"));
		Assert.assertTrue(bottomAccessibilityRedirectedPage.contains("Web Content Accessibility Guidelines 2.0"));
	}

	@Test
	public void verifyBottomGDPRUrl() {
		bridgePageFooter.clickOnBottomGDPR();
		String bottomGDPRUrl = driver.getCurrentUrl();
		System.out.println(bottomGDPRUrl);
		Assert.assertEquals(bottomGDPRUrl, "https://www.getbridge.com/policies/gdpr");

		// verify bottom GDPR redirected page contents
		String bottomGDPRRedirectedPage = driver.findElement(By.xpath("//*[@id=\"main\"]/h2[1]")).getText();
		Assert.assertTrue(bottomGDPRRedirectedPage.contains("THE GENERAL DATA PROTECTION REGULATION (GDPR)"));
	}

	@Test
	public void verifyBottomNewsUrl() {
		bridgePageFooter.clickOnBottomNews();
		String bottomNewsUrl = driver.getCurrentUrl();
		System.out.println(bottomNewsUrl);
		Assert.assertEquals(bottomNewsUrl, "https://www.getbridge.com/news");

		// verify bottom news redirected page contents
		String bottomNewsRedirectedPage = driver.findElement(By.xpath("//*[@id=\"news-hero\"]/h1")).getText();
		Assert.assertTrue(bottomNewsRedirectedPage.contains("Bridge News"));
	}

}
