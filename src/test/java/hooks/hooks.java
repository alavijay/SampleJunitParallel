package hooks;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import hooks.DriverFactory;
public class hooks {
   
   @Before
	public void SetUp(Scenario s) {
        WebDriver driver = DriverFactory.getInstance().getDriver();
	}
	@After
	public void tearDown() {
        DriverFactory.getInstance().removeDriver();
    }
   
}