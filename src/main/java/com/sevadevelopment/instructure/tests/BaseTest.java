package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.utility.Browser;

public class BaseTest {

	public BaseTest(Browser browser) {
		
		switch(browser) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
			break;
			
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckoDriver/geckodriver-v0.20.1-win64/geckodriver");
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/geckoDriver/geckodriver-v0.20.1-win64/geckodriver.exe");
			break;
			
		case edge:
			
			break;
		
		case opera:
			
			break;
		}
				
	}

}
