package com.sevadevelopment.instructure.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BridgePage extends BasePageObject{
	
	public BridgePage(WebDriver driver) {
	
			super(driver);
			PageFactory.initElements(driver, this);
		
	
	}

}
