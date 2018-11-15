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

	public BridgePageFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAccessibilityLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(accessibility));
		accessibility.click();
	}
	
	public void clickOnPrivacyPolicyLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(privacyPolicy));
		privacyPolicy.click();
	}
}
