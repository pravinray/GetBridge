package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.LoginPage;
import com.sevadevelopment.utility.ExcelUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("================");
		System.out.println(properties.getProperty("browser"));
		System.out.println("================");


		driver = new SeleniumDriverFactory().getDriver(properties.getProperty("browser"));
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
