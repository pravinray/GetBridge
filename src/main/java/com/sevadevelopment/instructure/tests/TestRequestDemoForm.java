package com.sevadevelopment.instructure.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	String homePage = ("https://www.getbridge.com");
	GenerateTestReport generateTestReport = new GenerateTestReport(driver);

	public Map<Long, WebDriver> driverMap = new ConcurrentHashMap();
	public WebDriverWait wait;
	public SeleniumDriverFactory tlDriverFactory = new SeleniumDriverFactory();

	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@AfterSuite
	public void doAfterSuite() {
		generateTestReport.flushReport(driver);
	}

	@BeforeMethod
	@Parameters({"browser","isGrid"})
	public void setupTestMethod(String browser, boolean isGrid, Method method) throws Exception {
		System.out.println("Before Method started ::"+Thread.currentThread().getId());
		SeleniumDriverFactory.setDriver(browser,isGrid);

		driverMap.put(Thread.currentThread().getId(),SeleniumDriverFactory.getDriver());
		driver = driverMap.get(Long.valueOf(Thread.currentThread().getId()));

		driver.manage().window().maximize();
		driver.get(homePage);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 50000)", "");
		
		generateTestReport.startReport(method);
	}

	@AfterMethod
	public void tearDownTestMethod(ITestResult result) {
		generateTestReport.getReport(result);
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
