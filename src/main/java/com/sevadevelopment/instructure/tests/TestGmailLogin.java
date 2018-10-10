package com.sevadevelopment.instructure.tests;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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

import utilitypackage.LoginPage;


public class TestGmailLogin {
	WebDriver driver;
	ArrayList<String> dLoginData = new ArrayList();
	int rCount;
	XSSFSheet sheet1;
	XSSFCell userName;
	XSSFCell password;
	ExcelApiTest eat = null;
	String xlFilePath = "src/main/resources/testData/names.xlsx";
	String sheetName = "Sheet1";

	@BeforeClass
	public void setupTestClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_win32/chromedriver(2.42 v68-70).exe");
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromeDriver/chromedriver_linux_64"); //Use .exe driver file for windows os
		Thread.sleep(2000);
		

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
	 
   
	@DataProvider(name="userData") 
    public Object[][] userFormData() throws Exception
    {
        //Object[][] data = testData(xlFilePath, sheetName);
        //return data;
        
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
        
        System.out.println(rows + " row count");
        System.out.println(columns + " col count");
                 
        excelData = new Object[rows][columns];
       
        System.out.println(":::::::::::::::::::::::");
         
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<2; j++)
            {
                excelData[i][j] = eat.getCellData(sheetName, j, i);
                System.out.print(excelData[i][j] + " ");
                
            }
            System.out.println("-----------------------");
             
        }
        
        System.out.println(excelData.toString());
        return excelData;
    }

	@Test(dataProvider = "userData")
	public void verifyThatInvalidPasswordDoesnotGetsAccess(String user, String pwd) {
		
		utilitypackage.LoginPage.EmailAddress(driver).sendKeys(user);
		utilitypackage.LoginPage.Password(driver).sendKeys(pwd);
		utilitypackage.LoginPage.Login(driver).click();
//		WebElement emailField = driver.findElement(By.name("identifier"));
//		String emailValue = emailCell.getStringCellValue();
//		emailField.sendKeys(emailValue);
//		System.out.println(emailValue);
//		WebElement nxtBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span"));
//		nxtBtn.click();
		System.out.println("user " + user);
		System.out.println("password " + pwd);

	}
}
