package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSeek extends BasePageObject{

	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(id="password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[3]/input")
	WebElement loginButton;
	
	
	
	public LoginSeek(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	public void setEmailTextBox(String emailText) {

		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.emailTextBox));
		
		element.clear();
		element.sendKeys(emailText);
	}

	public void setPasswordTextBox(String passwordText) {
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.passwordTextBox));
		
		element.clear();
		element.sendKeys(passwordText);
	}
	
	public DashboardPage doLogin (String emailText, String passwordText) {
		setEmailTextBox(emailText);
		setPasswordTextBox(passwordText);
		loginButton.click();
		
		return new DashboardPage(driver);
		
	}
	
}
