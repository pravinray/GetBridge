

import org.openqa.selenium.By;
import org.openqa.selenium.Webdriver;
import org.openqa.selenium.WebElement;

public class readLoginPwd {

	private static WebElement element = null;
	
	public static WebElement EmailAddress(WebDriver driver) {
		// TODO Auto-generated method stub
			element email = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
			
			return element;
	}
	
	public static WebElement Password(WebDriver driver) {
			element password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
			
			return element;
	}
	
	public static WebElement Login(WebDriver driver) {
		
			element login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/input"));
			
			return element;
	}
	
}
 