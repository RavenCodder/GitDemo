package Accademy;

import org.testng.annotations.Test;

import jdk.internal.jline.internal.Log;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Baseclass;

public class HomePage extends Baseclass {
	public static Logger  Log = LogManager.getLogger(Baseclass.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initDriver();
		
	}

	@Test(dataProvider="getData")
	public void baseValidateHomePage(String Username, String Password, String text) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		l.getTitle().getText();

		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.GetEmail().sendKeys(Username);
		lp.GetPassword().sendKeys(Password);
		Log.info(text);
		
		lp.GetLogin().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		//0th row;
		data[0][0]="nonrestrictedUser@m.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		//1st row
		data[1][0]="Baneduser@gmail.com";
		data[1][1]="654321";
		data[1][2]="Non restricted user";
		
		return data;
		
		
		
	}
	
}
