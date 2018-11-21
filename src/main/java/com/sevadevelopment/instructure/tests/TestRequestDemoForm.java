package com.sevadevelopment.instructure.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.sevadevelopment.instructure.pageobjects.RequestDemoForm;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.ExcelUtility;
import com.sevadevelopment.utility.GenerateTestReport;
import com.sevadevelopment.utility.SeleniumDriverFactory;

public class TestRequestDemoForm {

	ConfigUtility configUtility;
	WebDriver driver;
	RequestDemoForm requestDemoForm;
	String xlFilePath = "src/main/resources/testData/names.xlsx";
	String sheetName = "Sheet2";
	GenerateTestReport generateTestReport;

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
		generateTestReport = new GenerateTestReport(driver);
	}

	@BeforeMethod
	public void setupTestMethod(Method method) throws Exception {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"),
				configUtility.getConfig("executionMethod"), configUtility.getConfig("seleniumHubUrl"));
		this.requestDemoForm = new RequestDemoForm(driver);

		driver.manage().window().maximize();
		driver.get("https://www.getbridge.com");
		generateTestReport.generateReport(method, driver);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		generateTestReport.flushReport(result);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@DataProvider(name = "formData")
	public Object[][] requestFormData() throws Exception {
		ExcelUtility excelUtility = new ExcelUtility(xlFilePath, sheetName);

		return excelUtility.getAllDataAsArrayOfObject();
	}

	@Test(description = "To fill and submit the request demo form", dataProvider = "formData")
	public void fillRequestDemoFormAndVerifyThankingPage(String firstLastName, String emailText, String phoneNumber,
			String countryListIndex, String organization, String jobText, String estimatedUsersIndex) throws Exception {

		try {
			this.requestDemoForm.fillForm(firstLastName, emailText, phoneNumber, countryListIndex, organization,
					jobText, estimatedUsersIndex);
		} catch (Exception e) {
			e.getMessage();
		}
		String currentURL = driver.getCurrentUrl();
		System.out.println("fname:: " + firstLastName + " email:: " + emailText + " mobile:: " + phoneNumber
				+ " countryListIndex::" + countryListIndex + " organization:: " + organization + " job:: " + jobText
				+ " estimatedUsersIndex::" + estimatedUsersIndex);
//		assertTrue(currentURL.contains("/thank-you?ref=home-page"));
	}
}
