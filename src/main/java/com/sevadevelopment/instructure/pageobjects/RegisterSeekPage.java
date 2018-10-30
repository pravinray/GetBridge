package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSeekPage extends BasePageObject{
	@FindBy(id="firstName")
	WebElement firstnameTextBox;
	
	@FindBy(id="lastName")
	WebElement lastnameTextBox;

	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(id="password")
	WebElement passwordTextBox;
	
	//@FindBy(xpath="//*[@id=\"loginForm\"]/div[3]/input")
	//WebElement loginButton;
	
	
	
	public RegisterSeekPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	public void setFirstNameTextBox(String firstname) {

		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.firstnameTextBox));
		//System.out.println("firstnameTextBox");
		element.clear();
		element.sendKeys(firstname);
	}
	public void setLastNameTextBox(String lastname) {

		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.lastnameTextBox));
		
		element.clear();
		element.sendKeys(lastname);
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
	
	public DashboardPage doLogin (String firstname, String lastname, String emailText, String passwordText) {
		setFirstNameTextBox(firstname);
		setLastNameTextBox(lastname);
		setEmailTextBox(emailText);
		setPasswordTextBox(passwordText);
		//loginButton.click();
		
		return new DashboardPage(driver);
		
	}
	
}
