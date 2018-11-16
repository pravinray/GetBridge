package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BridgePageFooter extends BasePageObject {

	@FindBy(xpath = "//*[@id=\"footer-top-links\"]/div/a[1]")
	WebElement accessibility;

	@FindBy(xpath = "//*[@id=\"footer-top-links\"]/div/a[2]")
	WebElement privacyPolicy;

	@FindBy(xpath = "//*[@id=\"footer-top-links\"]/div/a[3]")
	WebElement termsOfUse;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[1]")
	WebElement management;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[2]")
	WebElement timelineModule;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[3]")
	WebElement skillsAssessment;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[4]")
	WebElement goalsAndTasks;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[5]")
	WebElement robustReporting;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[6]")
	WebElement retain;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[7]")
	WebElement contentServices;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[8]")
	WebElement offTheShelfCourses;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[9]")
	WebElement arcVideo;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[10]")
	WebElement learnFromYourLearning;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[11]")
	WebElement managerDashboard;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[12]")
	WebElement admin;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[13]")
	WebElement easyToUse;

	@FindBy(xpath = "//*[@id=\"features\"]/div/a[14]")
	WebElement anytimeAnywhere;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[1]")
	WebElement supportTerms;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[2]")
	WebElement bottomPrivacyPolicy;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[3]")
	WebElement bottomTermsOfUse;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[4]")
	WebElement bottomAccessibility;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[5]")
	WebElement bottomGDPR;

	@FindBy(xpath = "//*[@id=\"footer-legal-links\"]/div/a[6]")
	WebElement bottomNews;

	public BridgePageFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAccessibilityLink() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(accessibility));
		accessibility.click();
	}

	public void clickOnPrivacyPolicyLink() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(privacyPolicy));
		privacyPolicy.click();
	}

	public void clickOnTermsOfUse() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(termsOfUse));
		termsOfUse.click();
	}

	public void clickOnManagement() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(management));
		management.click();
	}

	public void clickOnTimelineModule() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(timelineModule));
		timelineModule.click();
	}

	public void clickOnSkillsAssessment() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(skillsAssessment));
		skillsAssessment.click();
	}

	public void clickOnGoalsAndTasks() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(goalsAndTasks));
		goalsAndTasks.click();
	}

	public void clickOnRobustReporting() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(robustReporting));
		robustReporting.click();
	}

	public void clickOnRetain() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(retain));
		retain.click();
	}

	public void clickOnContentServices() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(contentServices));
		contentServices.click();
	}

	public void clickOnOffTheShelfCourses() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(offTheShelfCourses));
		offTheShelfCourses.click();
	}

	public void clickOnArcVideo() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(arcVideo));
		arcVideo.click();
	}

	public void clickOnLearnFromYourLearning() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(learnFromYourLearning));
		learnFromYourLearning.click();
	}

	public void clickOnManagerDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(managerDashboard));
		managerDashboard.click();
	}

	public void clickOnAdmin() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(admin));
		admin.click();
	}

	public void clickOnEasyToUse() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(easyToUse));
		easyToUse.click();
	}

	public void clickOnAnytimeAnywhere() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(anytimeAnywhere));
		anytimeAnywhere.click();
	}

	public void clickOnSupportTerms() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(supportTerms));
		supportTerms.click();
	}

	public void clickOnBottomPrivacyPolicy() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(bottomPrivacyPolicy));
		bottomPrivacyPolicy.click();
	}

	public void clickOnBottomTermsOfUse() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(bottomTermsOfUse));
		bottomTermsOfUse.click();
	}

	public void clickOnBottomAccessibility() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(bottomAccessibility));
		bottomAccessibility.click();
	}

	public void clickOnBottomGDPR() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(bottomGDPR));
		bottomGDPR.click();
	}

	public void clickOnBottomNews() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(bottomNews));
		bottomNews.click();
	}
}
