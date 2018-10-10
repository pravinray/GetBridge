package utilitypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	public static WebElement EmailAddress(WebDriver driver) {
		// TODO Auto-generated method stub
		WebElement email = driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
			
			return email;
	}
	
	public static WebElement Password(WebDriver driver) {
			WebElement password = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
			
			return password;
	}
	
	public static WebElement Login(WebDriver driver) {
		
			WebElement login = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/input"));
			
			return login;
	}
}
