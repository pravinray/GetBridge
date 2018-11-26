package com.sevadevelopment.instructure.tests;

import com.sevadevelopment.instructure.pageobjects.RequestDemoForm;
import com.sevadevelopment.utility.ExcelUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class TestRequestDemoForm extends BaseTest{
	RequestDemoForm requestDemoForm;
	String xlFilePath = "src/main/resources/testData/names.xlsx";
	String sheetName = "Sheet2";
	//GenerateTestReport generateTestReport = new GenerateTestReport(driver);

	@AfterSuite
	public void doAfterSuite() {
		//generateTestReport.flushReport(driver);
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid) {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser,isGrid);


		driver.manage().window().maximize();
		driver.get(homePage);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 50000)", "");
		
		//generateTestReport.startReport(method);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		//generateTestReport.getReport(result);
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
		 assertTrue(currentURL.contains("/thank-you?ref=home-page"));
	}
}
