package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Baseclass {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initDriver() throws IOException {
	
	
	prop = new Properties();	
	FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
	prop.load(fs);
	
	//mvn test Dbrowser=chrome
	String browserName = prop.getProperty("browser");
	//String browserName = prop.getProperty("browser");
	
	
	//chrome
	if(browserName.contains("chrome")) {	
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	ChromeOptions options = new ChromeOptions();
	
	
		if(browserName.contains("headless")) {
		options.addArguments("headless");
		}
	
	
		driver = new ChromeDriver(options);
	}
	//firefox
	else if(browserName.equals("firefox")) {	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
		driver = new FirefoxDriver();
	}
	//IE
	else if(browserName.equals("IE")) {
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/Screenshots/"+result+"screen.png"));
		
		
	}
	
}
