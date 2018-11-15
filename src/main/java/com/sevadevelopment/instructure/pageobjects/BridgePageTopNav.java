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
//	public  void clickOnTimelineFooterLink() {
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(timelineFooterLink));
		//timelineFooterLink.click();	
	//}
}
