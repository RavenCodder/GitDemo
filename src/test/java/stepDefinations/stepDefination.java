package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Baseclass;

public class stepDefination extends Baseclass {
	
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initDriver();
	}

	@Given("^Navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on Secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		if(l.getPopupSize()>0) {
			l.getPopup().click();
		}
		l.getLogin().click();
	}

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
		lp.GetEmail().sendKeys(arg1);
		lp.GetPassword().sendKeys(arg2);
		lp.GetLogin().click();
    }



	@Then("^Verife that user is succesfuly login$")
	public void verife_that_user_is_succesfuly_login() throws Throwable {
		driver.get("http://qaclickacademy.com/");
	   PortalHomePage p = new PortalHomePage(driver);
	   Assert.assertTrue(p.GetSearchBox().isDisplayed());
	}
	
    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }
}
