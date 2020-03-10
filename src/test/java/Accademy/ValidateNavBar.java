package Accademy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;
import pageObjects.LandingPage;
import resources.Baseclass;

public class ValidateNavBar extends Baseclass {
	public static Logger  Log = LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test()
	public void baseAppNavbar() throws IOException {
	
		
		LandingPage l = new LandingPage(driver);
		AssertJUnit.assertTrue(l.getNavBar().isDisplayed());
		Log.info("Navbar is displayed by RavenCoder");
		Log.info("New log in develop branch by RavenCoder");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
}
