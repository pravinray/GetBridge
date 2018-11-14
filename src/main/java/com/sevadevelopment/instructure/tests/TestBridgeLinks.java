

package com.sevadevelopment.instructure.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevadevelopment.instructure.pageobjects.BridgePage;
import com.sevadevelopment.utility.ConfigUtility;
import com.sevadevelopment.utility.SeleniumDriverFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;



public class TestBridgeLinks{
	WebDriver driver;
	BridgePage bridgePage;
	ConfigUtility configUtility;
	String url = "";
    HttpURLConnection huc = null;
    int respCode = 200;
   String homePage=("https://www.getbridge.com");


	@BeforeClass
	public void setupTestClass() {
		configUtility = new ConfigUtility();
	}

	@BeforeMethod
	public void setupTestMethod() {
		driver = new SeleniumDriverFactory().getDriver(configUtility.getConfig("browser"));
		this.bridgePage = new BridgePage(driver);

		driver.manage().window().maximize();
		driver.get(homePage);
	}

	@AfterMethod
	public void tearDownTestMethod() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	@Test(priority=1)
	@DataProvider()
	public void checkAlllinks() {
		 

        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
           // System.out.println(url);
        
            if(url == null || url.isEmpty()){
            	System.out.println(url);
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
                
            }
            
            if(!url.startsWith(homePage)){
            	System.out.println(url);
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();

                
                Assert.assertEquals(respCode,200);
                           
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
}
	@Test(priority=2)
    public void verifyProductUrl(){
	bridgePage.clickOnProductLink();
	String productUrl=driver.getCurrentUrl();
	System.out.println(productUrl);
	Assert.assertEquals(productUrl,"https://www.getbridge.com/products");
     }
	@Test(priority=3)
    public void verifySolutionsUrl(){
	bridgePage.clickOnSolutionsLink();
	String solutionsUrl=driver.getCurrentUrl();
	System.out.println(solutionsUrl);
	Assert.assertEquals(solutionsUrl,"https://www.getbridge.com/solutions");
     }
	//@Test(priority=4)
   // public void verifyTimelineFooterUrl(){
	//bridgePage.clickOnTimelineFooterLink();
	//String timelineUrl=driver.getCurrentUrl();
	//System.out.println(timelineUrl);
	//Assert.assertEquals(timelineUrl,"https://www.getbridge.com/features/employee-timeline");
     //}
}
