package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	private	By email = By.xpath("//input[@id='user_email']");
	private By password = By.id("user_password");
	private By loginBtn = By.cssSelector("input[value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement GetEmail() {
		return driver.findElement(email);
		
	}
	
	public WebElement GetPassword() {
		return driver.findElement(password);
		
	}
	
	public WebElement GetLogin() {
	return driver.findElement(loginBtn);
	}
}
