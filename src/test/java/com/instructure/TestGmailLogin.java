package com.instructure;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TestGmailLogin {
    WebDriver driver;
    ArrayList<String> dLoginData = new ArrayList();

    @BeforeClass
    public void setupTestClass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux_64");// Use .exe driver file for windows os
        Thread.sleep(2000);
        File file = new File("ExcelFile/names.xlsx");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet1 = wb.getSheetAt(0);
    }

    @BeforeMethod
    public void setupTestMethod() {
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void tearDownTestMethod() {
        driver.quit();
    }

//    @DataProvider(name = "LoginCredentialData")
//    public Object[][] loginData() {
//        return new Object[][] {{"user1","pass1"},{"user2","pass2"},{"user3","pass3"}} ;
//    }

    @Test //(dataProvider = "LoginCredentialData")
    public void verifyThatInvalidPasswordDoesnotGetsAccess() {
    	driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		AssertJUnit.assertTrue(title.contains("Demo Guru99 Page"));
        //To Do
        //Write Test Case Here
    }
}
