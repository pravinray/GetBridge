package com.instructure;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class GmailLogin {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");// Use .exe driver file for windows os
		Thread.sleep(2000);
		File file = new File("ExcelFile/names.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rCount = sheet1.getPhysicalNumberOfRows();
		for (int e = 0; e < rCount + 1; e++) {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(
					"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&hl=en");

			// Username
			WebElement emailField = driver.findElement(By.name("identifier"));
			XSSFCell emailCell = sheet1.getRow(e).getCell(0);

			if (emailCell == null || emailCell.getCellType() == CellType.BLANK) {
				WebElement errorMessageEmail = driver.findElement(By.xpath(
						"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]"));
				Assert.assertEquals(errorMessageEmail.getText(), "Enter an email or phone number");
				System.out.println("Email field is empty in excel sheet.");
			} else {
				String emailValue = emailCell.getStringCellValue();
				emailField.sendKeys(emailValue);
				System.out.println(emailValue);
				WebElement nxtBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
				nxtBtn.click();
				Thread.sleep(4000);
			}

			// Password
			WebElement pwdField = driver.findElement(By.name("password"));
			XSSFCell pwdCell = sheet1.getRow(e).getCell(1);

			if (pwdCell == null || pwdCell.getCellType() == CellType.BLANK) {
				WebElement errorMessagePwd = driver.findElement(By.xpath(
						"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]"));
				Assert.assertEquals(errorMessagePwd.getText(), "Enter a password");
				System.out.println("Password field is empty in excel sheet.");
			} else {
				String pwdValue = pwdCell.getStringCellValue();
				pwdField.sendKeys(pwdValue);
				System.out.println(pwdValue);
				Thread.sleep(2000);
				WebElement nxtBtn1 = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]"));
				nxtBtn1.click();
				Thread.sleep(2000);
				WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"password\"]/div[2]/div[2]"));
				Assert.assertEquals(errorMessage.getText(),
						"Wrong password. Try again or click Forgot password to reset it.");
			}

			driver.quit();
		}
	}
}
