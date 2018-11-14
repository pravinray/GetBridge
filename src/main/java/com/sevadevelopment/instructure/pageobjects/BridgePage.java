package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BridgePage extends BasePageObject{
	@FindBy(id="products-tab")
	WebElement productTab;
	
	@FindBy(id="solutions-tab")
	WebElement solutionsTab;
	
	//@FindBy(xpath="//*[@id=\"features\"]/div/a[2]")
	//WebElement timelineFooterLink;
	
	public BridgePage(WebDriver driver) {
	
			super(driver);
			PageFactory.initElements(driver, this);
		
	
	}
	public  void clickOnProductLink() {
		productTab.click();	
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
