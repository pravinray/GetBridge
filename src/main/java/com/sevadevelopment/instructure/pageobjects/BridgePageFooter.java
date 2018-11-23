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
		webDriverWait.until(ExpectedConditions.visibilityOf(accessibility)).click();
	}

	public void clickOnPrivacyPolicyLink() {
		webDriverWait.until(ExpectedConditions.visibilityOf(privacyPolicy)).click();
	}

	public void clickOnTermsOfUse() {
		webDriverWait.until(ExpectedConditions.visibilityOf(termsOfUse)).click();
	}

	public void clickOnManagement() {
		webDriverWait.until(ExpectedConditions.visibilityOf(management)).click();
	}

	public void clickOnTimelineModule() {
		webDriverWait.until(ExpectedConditions.visibilityOf(timelineModule)).click();
	}

	public void clickOnSkillsAssessment() {
		webDriverWait.until(ExpectedConditions.visibilityOf(skillsAssessment)).click();
	}

	public void clickOnGoalsAndTasks() {
		webDriverWait.until(ExpectedConditions.visibilityOf(goalsAndTasks)).click();
	}

	public void clickOnRobustReporting() {
		webDriverWait.until(ExpectedConditions.visibilityOf(robustReporting)).click();
	}

	public void clickOnRetain() {
		webDriverWait.until(ExpectedConditions.visibilityOf(retain)).click();
	}

	public void clickOnContentServices() {
		webDriverWait.until(ExpectedConditions.visibilityOf(contentServices)).click();
	}

	public void clickOnOffTheShelfCourses() {
		webDriverWait.until(ExpectedConditions.visibilityOf(offTheShelfCourses)).click();
	}

	public void clickOnArcVideo() {
		webDriverWait.until(ExpectedConditions.visibilityOf(arcVideo)).click();
	}

	public void clickOnLearnFromYourLearning() {
		webDriverWait.until(ExpectedConditions.visibilityOf(learnFromYourLearning)).click();
	}

	public void clickOnManagerDashboard() {
		webDriverWait.until(ExpectedConditions.visibilityOf(managerDashboard)).click();
	}

	public void clickOnAdmin() {
		webDriverWait.until(ExpectedConditions.visibilityOf(admin)).click();
	}

	public void clickOnEasyToUse() {
		webDriverWait.until(ExpectedConditions.visibilityOf(easyToUse)).click();
	}

	public void clickOnAnytimeAnywhere() {
		webDriverWait.until(ExpectedConditions.visibilityOf(anytimeAnywhere)).click();
	}

	public void clickOnSupportTerms() {
		webDriverWait.until(ExpectedConditions.visibilityOf(supportTerms)).click();
	}

	public void clickOnBottomPrivacyPolicy() {
		webDriverWait.until(ExpectedConditions.visibilityOf(bottomPrivacyPolicy)).click();
	}

	public void clickOnBottomTermsOfUse() {
		webDriverWait.until(ExpectedConditions.visibilityOf(bottomTermsOfUse)).click();
	}

	public void clickOnBottomAccessibility() {
		webDriverWait.until(ExpectedConditions.visibilityOf(bottomAccessibility)).click();
	}

	public void clickOnBottomGDPR() {
		webDriverWait.until(ExpectedConditions.visibilityOf(bottomGDPR)).click();
	}

	public void clickOnBottomNews() {
		webDriverWait.until(ExpectedConditions.visibilityOf(bottomNews)).click();
	}
}
