package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {

	public WebDriver driver;
	
	private	By searchBox = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	
	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement GetSearchBox() {
		return driver.findElement(searchBox);
		
	}
	

}
