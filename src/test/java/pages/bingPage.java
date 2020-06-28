package pages;

import hooks.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class bingPage {

    WebDriver driver;

    public void SearchFieldDisplayed(){
        this.driver = DriverFactory.getInstance().getDriver();
        Assert.assertTrue(this.driver.findElement(By.name("q")).isDisplayed());
    }
    public void navToPage(String url){
        this.driver =DriverFactory.getInstance().getDriver();
        this.driver.get(url);
    }
}
