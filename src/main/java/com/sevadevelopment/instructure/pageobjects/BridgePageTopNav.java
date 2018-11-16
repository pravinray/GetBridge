package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BridgePageTopNav extends BasePageObject{
	@FindBy(id="products-tab")
	WebElement productTab;
	
	@FindBy(id="solutions-tab")
	WebElement solutionsTab;
	
	@FindBy(id="customer-stories-tab")
	WebElement customerStoriesTab;
	
	@FindBy(id="resources-tab")
	WebElement resourcesTab;
	
	@FindBy(xpath="//*[@id=\"nav-links\"]/a[5]")
	WebElement aboutTab;

	@FindBy(xpath="//*[@id=\"nav-links\"]/a[6]")
	WebElement blogTab;
	
	@FindBy(id="ga-mobile-nav-demo")
	WebElement bookADemoTab;
	//@FindBy(xpath="//*[@id=\"features\"]/div/a[2]")
	//WebElement timelineFooterLink;
	
	public BridgePageTopNav(WebDriver driver) {
	
			super(driver);
			PageFactory.initElements(driver, this);
		
	
	}
	public  void clickOnProductTab() {
		productTab.click();	
	}
	
	public void hoverOnProductTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(productTab).build().perform();;
	}
	
	public  void clickOnSolutionsLink() {
		solutionsTab.click();	
	}
	public void hoverOnSolutionsTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(solutionsTab).build().perform();;
	}
	public  void clickOnCustomerStoriesLink() {
		customerStoriesTab.click();	
	}
	public void hoverOnResourcesTab1() {
		Actions actions = new Actions(driver);
		actions.moveToElement(resourcesTab).build().perform();;
	}
	public  void clickOnResourcesLink() {
		customerStoriesTab.click();	
	}
	public void hoverOnResourcesTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(resourcesTab).build().perform();;
	}
	public  void clickOnAboutLink() {
		aboutTab.click();	
	}
	public void hoverOnAboutTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(aboutTab).build().perform();;
	}
	public  void clickOnBlogLink() {
		blogTab.click();	
	}
	public void hoverOnBlogTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(blogTab).build().perform();;
	}
	public  void clickOnBookADemoLink() {
		bookADemoTab.click();	
	}
	public void hoverOnBookADemoTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(bookADemoTab).build().perform();;
	}
}
