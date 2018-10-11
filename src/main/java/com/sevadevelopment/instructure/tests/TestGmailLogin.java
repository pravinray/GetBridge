package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.utility.Browser;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevadevelopment.instructure.pageobjects.DashboardPage;
import com.sevadevelopment.instructure.pageobjects.LoginPage;
import com.sevadevelopment.utility.ExcelUtility;

public class TestGmailLogin{
	WebDriver driver;
	int rCount;
	XSSFSheet sheet1;
	XSSFCell userName;
	XSSFCell password;
	ExcelUtility eat = null;
	String xlFilePath = "src/main/resources/testData/names.xlsx";
	String sheetName = "Sheet1";
	LoginPage loginPage;
	

	@BeforeClass
	public void setupTestClass() throws InterruptedException {
		driver = new SeleniumDriverFactory().getDriver(Browser.chrome);
		this.loginPage = new LoginPage(driver);
		
		driver.manage().window().maximize();
		driver.get("https://www.qfxcinemas.com/Account/Login");

	}

	@BeforeMethod
	public void setupTestMethod() {
//		driver.get("https://www.qfxcinemas.com/Account/Login");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void tearDownTestClass() {
		driver.quit();
	}

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		return (new ExcelUtility(xlFilePath,sheetName)).getAllDataAsArrayOfObject();
	}

	@Test(description = "To verify that invalid password doesn't gets access to system", dataProvider = "userData")
	public void verifyThatInvalidPasswordDoesnotGetsAccess(String user, String pwd) throws Exception {
		try {
			this.loginPage.doLogin(user, pwd);
		} catch(Exception e) {
			e.getMessage();
		}
		//Assert.assertEquals(dashboardPage.getTitle(), "This is Dashboard");
	}
}
