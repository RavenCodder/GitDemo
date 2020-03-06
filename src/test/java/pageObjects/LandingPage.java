package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By textCourses = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	private By textTittle = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(textCourses);
	}
	
	public WebElement getSecondTittle() {
		return driver.findElement(textTittle);
	}
	
	public WebElement getNavBar() {
		System.out.println("Trying to identife navigation bar");
		return driver.findElement(navBar);
	}
	
	public int getPopupSize() {
		
		return driver.findElements(popup).size();
	}
	
	
public WebElement getPopup() {
		
		return driver.findElement(popup);
	}
}
