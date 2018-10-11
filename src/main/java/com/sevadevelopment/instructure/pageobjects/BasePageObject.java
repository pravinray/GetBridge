package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BasePageObject {
	WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
}
