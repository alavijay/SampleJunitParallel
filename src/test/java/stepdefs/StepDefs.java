package stepdefs;

import org.openqa.selenium.WebDriver;


import cucumber.api.Scenario;

import cucumber.api.java.en.Given;
import hooks.DriverFactory;
import hooks.hooks;

public class StepDefs {

	//Scenario scenario;
	WebDriver driver;
	

	
	@Given("I open the Browser and Navigate to the URL {string}")
	public void i_open_the_Browser_and_Navigate_to_the_URL(String string) {
	
		this.driver = DriverFactory.getInstance().getDriver();
		this.driver.get(string);
		
	}


	
}
