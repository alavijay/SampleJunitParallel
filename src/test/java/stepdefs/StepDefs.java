package stepdefs;

import cucumber.api.java.en.Given;
import pages.bingPage;

public class StepDefs {

	bingPage bPage;
	
	@Given("I open the Browser and Navigate to the URL {string}")
	public void i_open_the_Browser_and_Navigate_to_the_URL(String string) throws InterruptedException {
		bPage = new bingPage();
		bPage.navToPage(string);
		bPage.SearchFieldDisplayed();
		Thread.sleep(2000);
	}
	
}
