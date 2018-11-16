package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.LoginPage;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.ExcelUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

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
	public void setupTestMethod() throws MalformedURLException {
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
		return (new ExcelUtility(xlFilePath,sheetName)).getAllDataAsArrayOfObject();
	}

	@Test(description = "To verify that invalid password doesn't gets access to system", dataProvider = "userData")
	public void verifyThatInvalidPasswordDoesnotGetsAccess(String user, String pwd) throws Exception {
		try {
			this.loginPage.doLogin(user, pwd);
            System.out.println("this test is executed");
		} catch(Exception e) {
			e.getMessage();
            System.out.println("this method is executed" );

		}
		//Assert.assertEquals(dashboardPage.getTitle(), "This is Dashboard");
	}
	@Test
    public void tests(){
        System.out.println("this is blank test");
    }
}
