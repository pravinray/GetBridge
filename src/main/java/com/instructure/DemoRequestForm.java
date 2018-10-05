package com.instructure;


import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoRequestForm {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver"); // Use .exe driver file for windows os
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		File file = new File("ExcelFile/names.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet2 = wb.getSheetAt(1);
		int rCount = sheet2.getPhysicalNumberOfRows();
		for (int r = 0; r < rCount; r++) {
			driver.get("https://www.getbridge.com/");

			// First and Last Name
			WebElement nameFirstLastField = driver.findElement(By.className("nameFirstLast"));
			String nameFirstLastValue = sheet2.getRow(r).getCell(0).getStringCellValue();
			nameFirstLastField.sendKeys(nameFirstLastValue);
			System.out.println(nameFirstLastValue);

			// Email
			WebElement emailField = driver.findElement(By.className("Email"));
			String emailValue = sheet2.getRow(r).getCell(1).getStringCellValue();
			emailField.sendKeys(emailValue);
			System.out.println(emailValue);

			// Phone Number
			WebElement phoneField = driver.findElement(By.className("Phone_Number_2__c"));
			XSSFCell phoneNumberCell = sheet2.getRow(r).getCell(2);
			DataFormatter formatter = new DataFormatter();
			String phoneValue = formatter.formatCellValue(phoneNumberCell);
			phoneField.sendKeys(phoneValue);
			System.out.println(phoneValue);

			// Country
			String countryValue = sheet2.getRow(r).getCell(3).getStringCellValue();
			Select dropdown = new Select(driver.findElement(By.name("Country")));
			dropdown.selectByValue(countryValue);
			Thread.sleep(1000);
			System.out.println(countryValue);

			// Organization Name
			WebElement organizationField = driver.findElement(By.className("Company"));
			String organizationValue = sheet2.getRow(r).getCell(4).getStringCellValue();
			organizationField.sendKeys(organizationValue);
			System.out.println(organizationValue);

			// Job Title
			WebElement jobField = driver.findElement(By.className("Title"));
			String jobValue = sheet2.getRow(r).getCell(5).getStringCellValue();
			jobField.sendKeys(jobValue);
			System.out.println(jobValue);

			// Estimated Users
			String usersValue = sheet2.getRow(r).getCell(6).getStringCellValue();
			Select dropdownUsers = new Select(driver.findElement(By.className("Estimated_User_Licenses__c")));
			dropdownUsers.selectByValue(usersValue);
			System.out.println(usersValue);
			Thread.sleep(1000);

			// Submit Button
			// WebElement submitButton =
			// driver.findElement(By.xpath("//*[@id=\"block-mainpagecontent-2\"]/article/div/div/div/div[3]/form/button"));
			// submitButton.click();

			// Verify redirected url after submitting form
			// String currentUrl = driver.getCurrentUrl();
			// Assert.assertTrue(currentUrl.contains("/thank-you?ref=home-page"));

		}
	}
}
