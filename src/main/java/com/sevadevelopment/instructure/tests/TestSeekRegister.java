package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.RegisterSeekPage;
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

public class TestSeekRegister{
	WebDriver driver;
	int rCount;
	XSSFSheet sheet1;
	XSSFCell firstname;
	XSSFCell lastname;
	XSSFCell userName;
	XSSFCell password;
	ExcelUtility eat = null;
	String xlFilePath = "src/main/resources/testData/register.xlsx";
	String sheetName = "Sheet1";
	RegisterSeekPage loginPage;
	
	

	@BeforeClass
	public void setupTestClass() {
		


	}

	@BeforeMethod
	public void setupTestMethod() {
//		driver.get("https://www.qfxcinemas.com/Account/Login");
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
		driver = new SeleniumDriverFactory().getDriver(properties.getProperty("browser"));
		this.loginPage = new RegisterSeekPage(driver);

		driver.manage().window().maximize();
		driver.get("https://www.seek.com.au/sign-up");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@AfterClass
	public void tearDownTestClass() {
		
	}

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		ExcelUtility excelUtility = new ExcelUtility(xlFilePath,sheetName);
		
		return excelUtility.getAllDataAsArrayOfObject();
	}

	@Test(description = "To verify that invalid password doesn't gets access to system", dataProvider = "userData")
	public void verifyThatInvalidPasswordDoesnotGetsAccess(String firstname, String lastname, String user, String pwd) throws Exception {
		try {
			this.loginPage.doLogin(firstname, lastname, user, pwd);
			System.out.println("firstname"+firstname+"lastname"+lastname+"Username = "+user+" Password = "+pwd);
		} catch(Exception e) {
			e.getMessage();
		}
		//Assert.assertEquals(dashboardPage.getTitle(), "This is Dashboard");
	}
}
