package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
		webDriverWait.until(ExpectedConditions.elementToBeClickable(productTab)).click();
	}
	public void hoverOnProductTab() {
		System.out.println("Pageobject method started = hovering ");
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(productTab)
				)
		).build().perform();
		System.out.println("Pageobject method ended");
	}
	public  void clickOnSolutionsLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(solutionsTab)).click();
	}
	public void hoverOnSolutionsTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(solutionsTab)
				)
		).build().perform();
	}
	public  void clickOnCustomerStoriesLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(customerStoriesTab)).click();
	}
	public void hoverOnCustomerStoriesTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(customerStoriesTab)
				)
		).build().perform();
	}
	public  void clickOnResourcesLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(resourcesTab)).click();
	}
	public void hoverOnResourcesTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(resourcesTab)
				)
		).build().perform();
	}
	public  void clickOnAboutLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(aboutTab)).click();
	}
	public void hoverOnAboutTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(aboutTab)
				)
		).build().perform();
	}
	public  void clickOnBlogLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(blogTab)).click();
	}
	public void hoverOnBlogTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(ExpectedConditions.visibilityOf(blogTab)
				)
		).build().perform();
	}
	public  void clickOnBookADemoLink() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(bookADemoTab)).click();
	}
	public void hoverOnBookADemoTab() {
		(new Actions(driver)).moveToElement(
				webDriverWait.until(
						ExpectedConditions.visibilityOf(bookADemoTab)
				)
		).build().perform();
	}
}
