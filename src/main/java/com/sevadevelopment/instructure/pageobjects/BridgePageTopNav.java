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
	

	@FindBy(xpath="//*[@id=\"page-title\"]/h2")
	WebElement productPopUpTitle;
	
	@FindBy(xpath="//*[@id=\"tabs\"]")
	WebElement productPopUpOptions;

	@FindBy(xpath="//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/h1")
	WebElement productPageTitle;

	@FindBy(xpath="//*[@id=\"solutions-page\"]/div/div[1]/h3")
	WebElement solutionsPopUpOptions1;
	
	@FindBy(xpath="//*[@id=\"solutions-page\"]/div/div[2]/h3")
	WebElement solutionsPopUpOptions2;
	
	@FindBy(xpath="//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/h1")
	WebElement solutionsPageTitle;
	
	@FindBy(xpath="//*[@id=\"customer-stories-page\"]/div[1]/div[1]/p")
	WebElement customerStoriesPopUpOptions1;
	
	@FindBy(xpath="//*[@id=\"customer-stories-page\"]/div[1]/div[2]/p")
	WebElement customerStoriesPopUpOptions2;
	
	@FindBy(xpath="//*[@id=\"customer-stories-page\"]/div[1]/div[3]/p")
	WebElement customerStoriesPopUpOptions3;
	
	@FindBy(xpath="//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div[1]/section[1]/h1")
	WebElement customerStoriesPageTitle;

	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[1]/a[1]/h3")
	WebElement resourcesPopUpOptions1;
	
	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[2]/a[1]/h3")
	WebElement resourcesPopUpOptions2;
	
	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[3]/h3")
	WebElement resourcesPopUpOptions3;
	
	@FindBy(xpath="//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/h1")
	WebElement resourcesPageTitle;
	
	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[1]/a[1]/h3")
	WebElement aboutPopUpOptions1;
	
	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[2]/a[1]/h3")
	WebElement aboutPopUpOptions2;
	
	@FindBy(xpath="//*[@id=\"resources-page\"]/div/div[3]/h3")
	WebElement aboutPopUpOptions3;
	
	@FindBy(xpath="//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/section[1]/h1")
	WebElement aboutPageTitle;
	
	@FindBy(xpath="/html/body/div[1]/div/main/section[1]/div/div[1]/h2[1]")
	WebElement bookADemoPageTitle;
	
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
	public String getTextProductPopUpTitle() {
		return productPopUpTitle.getText();
	}
	
	public String getTextProductPopUpOptions() {
		return productPopUpOptions.getText();
	}
	
	public String getTextProductPageTitle() {
		return productPageTitle.getText();
	}
	
	public String getTextSolutionsPopUpOptions1() {
		return solutionsPopUpOptions1.getText();
	}

	public String getTextSolutionsPopUpOptions2() {
		return solutionsPopUpOptions2.getText();
	}
	public String getTextSolutionsPageTitle() {
		return solutionsPageTitle.getText();
	}
	
	public String getTextCustomerStoriesPopUpOptions1() {
		return customerStoriesPopUpOptions1.getText();
	}

	public String getTextCustomerStoriesPopUpOptions2() {
		return customerStoriesPopUpOptions2.getText();
	}
	public String getTextCustomerStoriesPopUpOptions3() {
		return customerStoriesPopUpOptions3.getText();
	}
	public String getTextCustomerStoriesPageTitle() {
		return customerStoriesPageTitle.getText();
	}
	public String getTextResourcesPopUpOptions1() {
		return resourcesPopUpOptions1.getText();
	}

	public String getTextResourcesPopUpOptions2() {
		return resourcesPopUpOptions2.getText();
	}
	public String getTextResourcesPopUpOptions3() {
		return resourcesPopUpOptions3.getText();
	}
	public String getTextResourcesPageTitle() {
		return resourcesPageTitle.getText();
	}
	public String getTextAboutPopUpOptions1() {
		return aboutPopUpOptions1.getText();
	}

	public String getTextAboutPopUpOptions2() {
		return aboutPopUpOptions2.getText();
	}
	public String getTextAboutPopUpOptions3() {
		return aboutPopUpOptions3.getText();
	}
	public String getTextAboutPageTitle() {
		return aboutPageTitle.getText();
	}
	public String getTextBookADemoPageTitle() {
		return bookADemoPageTitle.getText();
	}
}
