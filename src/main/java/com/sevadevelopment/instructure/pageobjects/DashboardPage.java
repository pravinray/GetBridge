package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePageObject{

	public DashboardPage(WebDriver driver) throws IllegalStateException {
		super(driver);
		
		PageFactory.initElements(driver, this);
		
		if(!driver.getTitle().equals("This is Dashboard")) {
            throw new IllegalStateException("This is not Dashboard page, current page is: "
                            + driver.getCurrentUrl());
		}
		
	}
	
	public void gotoUserMenu() {
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
