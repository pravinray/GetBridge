package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BridgePageTopNav extends BasePageObject{
	@FindBy(id="products-tab")
	WebElement productTab;
	
	@FindBy(id="solutions-tab")
	WebElement solutionsTab;
	
	@FindBy(id="customer-stories-tab")
	WebElement customerStoriesTab;
	
	@FindBy(id="resources-tab")
	WebElement resourcesTab;
	
	@FindBy(id="about-tab")
	WebElement aboutTab;

	@FindBy(xpath="//*[@id=\"nav-links\"]/a[6]")
	WebElement blogTab;
	
	@FindBy(id="ga-standard-nav-demo")
	WebElement bookADemoTab;
	
	public BridgePageTopNav(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
	}
	public  void clickOnProductTab() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(productTab)).click();
	}
	public void hoverOnProductTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(productTab))).build().perform();
	}
	public  void clickOnSolutionsLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(solutionsTab)).click();
	}
	public void hoverOnSolutionsTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(solutionsTab))).build().perform();
	}
	public  void clickOnCustomerStoriesLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(customerStoriesTab)).click();
	}
	public void hoverOnCustomerStoriesTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(customerStoriesTab))).build().perform();
	}
	public  void clickOnResourcesLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(resourcesTab)).click();
	}
	public void hoverOnResourcesTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(resourcesTab))).build().perform();
	}
	public  void clickOnAboutLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(aboutTab)).click();
	}
	public void hoverOnAboutTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(aboutTab))).build().perform();
	}
	public  void clickOnBlogLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(blogTab)).click();
	}
	public void hoverOnBlogTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(blogTab))).build().perform();
	}
	public  void clickOnBookADemoLink() {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(bookADemoTab)).click();
	}
	public void hoverOnBookADemoTab() {
		(new Actions(driver)).moveToElement((new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(bookADemoTab))).build().perform();
	}
}
