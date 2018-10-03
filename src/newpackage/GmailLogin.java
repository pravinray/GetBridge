package newpackage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver"); // Use .exe driver file for windows os
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		File file = new File("ExcelFile/names.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rCount = sheet1.getPhysicalNumberOfRows();
		for (int e = 0; e < rCount; e++) {
			driver.get(
					"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&hl=en");

			// Username
			WebElement emailField = driver.findElement(By.name("identifier"));
			String emailValue = sheet1.getRow(e).getCell(0).getStringCellValue();
			emailField.sendKeys(emailValue);
			System.out.println(emailValue);
			WebElement nxtBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
			nxtBtn.click();
			Thread.sleep(4000);

			// Password
			WebElement pwdField = driver.findElement(By.name("password"));
			String pwdValue = sheet1.getRow(e).getCell(1).getStringCellValue();
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
