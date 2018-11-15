package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePageObject {
	WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
