package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	WebDriver driver;
	WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
