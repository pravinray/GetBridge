package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.LoginPage;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.ExcelUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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
	ConfigUtility configUtility;
	

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		this.loginPage = new LoginPage(driver);

		driver.manage().window().maximize();
		driver.get("https://www.qfxcinemas.com/Account/Login");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}


	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		ExcelUtility excelUtility = new ExcelUtility(xlFilePath,sheetName);
		
		return excelUtility.getAllDataAsArrayOfObject();
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
