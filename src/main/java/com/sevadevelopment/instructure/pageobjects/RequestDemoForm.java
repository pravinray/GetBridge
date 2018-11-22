package com.sevadevelopment.instructure.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestDemoForm extends BasePageObject {
	@FindBy(className = "nameFirstLast")
	WebElement firstLastNameField;

	@FindBy(className = "Email")
	WebElement emailField;

	@FindBy(className = "Phone_Number_2__c")
	WebElement phoneField;

	@FindBy(id = "Country373000453")
	WebElement countryField;

	@FindBy(className = "Company")
	WebElement organizationField;

	@FindBy(className = "Title")
	WebElement jobField;

	@FindBy(id = "estimatedUsers373000453")
	WebElement estimatedUsers;

	@FindBy(xpath = "//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/div[3]/form/fieldset[2]/button")
	WebElement submitBtn;

	public RequestDemoForm(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setFirstLastNameField(String firstLastNameText) {
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.firstLastNameField));
		element.clear();
		element.sendKeys(firstLastNameText);
	}

	public void setEmailField(String emailText) {
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.emailField));
		element.clear();
		element.sendKeys(emailText);
	}

	public void setPhoneNumberField(String phoneNumber) {
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.phoneField));
		element.clear();
		element.sendKeys(phoneNumber);
	}

	public void setCountry(String countryListIndex) {
		int i = Integer.parseInt(countryListIndex);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.countryField));
		Select countryDropDown = new Select(this.countryField);
		List<WebElement> e = countryDropDown.getOptions();
		System.out.println(e.get(i).getText());
		countryDropDown.selectByIndex(i);
	}

	public void setOrganization(String organization) {
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.organizationField));
		element.clear();
		element.sendKeys(organization);
	}

	public void setJobTitle(String jobText) {
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.jobField));
		element.clear();
		element.sendKeys(jobText);
	}

	public void setEstimatedUsers(String estimatedUsersIndex) {
		int i = Integer.parseInt(estimatedUsersIndex);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(this.estimatedUsers));
		Select usersDropDown = new Select(element);
		List<WebElement> el = usersDropDown.getOptions();
		System.out.println(el.get(i).getText());
		usersDropDown.selectByIndex(i);

	}

	public void fillForm(String firstLastName, String emailText, String phoneNumber, String countryListIndex,
			String organization, String jobText, String estimatedUsersIndex) {
		setFirstLastNameField(firstLastName);
		setEmailField(emailText);
		setPhoneNumberField(phoneNumber);
		setCountry(countryListIndex);
		setOrganization(organization);
		setJobTitle(jobText);
		setEstimatedUsers(estimatedUsersIndex);
//		submitBtn.click();
	}
}