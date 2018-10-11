package com.sevadevelopment.instructure.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGmailLogin {
	WebDriver driver;
	int rCount;
	XSSFSheet sheet1;
	XSSFCell userName;
	XSSFCell password;
	ExcelApiTest eat = null;
	String xlFilePath = "src/main/resources/testData/names.xlsx";
	String sheetName = "Sheet1";

	@BeforeClass
	public void setupTestClass() throws InterruptedException {
		// Use .exe driver file for windows os
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(xlFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet1 = wb.getSheetAt(0);
		rCount = sheet1.getPhysicalNumberOfRows();
		System.out.println(rCount + " PhysicalNumberOfRows");
	}

	@BeforeMethod
	public void setupTestMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.qfxcinemas.com/Account/Login");
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.quit();
	}

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		Object[][] excelData = null;
		eat = new ExcelApiTest(xlFilePath);
		int rows = eat.getRowCount(sheetName);
		int columns = eat.getColumnCount(sheetName);
		excelData = new Object[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 2; j++) {
				excelData[i][j] = eat.getCellData(sheetName, j, i);
				System.out.print(excelData[i][j] + " ");
			}
		}
		return excelData;
	}

	@Test(dataProvider = "userData")
	public void verifyThatInvalidPasswordDoesnotGetsAccess(String user, String pwd) {
		System.out.println("user " + user);
		System.out.println("password " + pwd);

	}
}
