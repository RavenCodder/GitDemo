package Accademy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.testng.AssertJUnit;
import java.io.IOException;
import pageObjects.LandingPage;
import resources.Baseclass;

public class ValidateTittle extends Baseclass {
	LandingPage l;
	public static Logger  Log = LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigeted to homepage");
		
	}

	@Test()
	public void baseValidateTittle() throws IOException {
		
		
		
		l = new LandingPage(driver);
		AssertJUnit.assertEquals("FEATURED COURSES", l.getTitle().getText());
		Log.info("Succesfuly validated text messege");
	}
	
	@Test()
	public void baseValidateSecondTittle() {
		l = new LandingPage(driver);
		AssertJUnit.assertEquals("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING", l.getSecondTittle().getText());
		Log.info("Succesfuly validated text messege");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
}
