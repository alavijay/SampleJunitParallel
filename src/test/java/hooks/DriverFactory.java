package hooks;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory
{

   private Object WebDriver;

   private DriverFactory()
   {
      //Do-nothing..Do not allow to initialize this class from outside
   }
   private static DriverFactory instance = new DriverFactory();

   public static DriverFactory getInstance()
   {
      return instance;
   }

   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
   {
      @Override
      protected WebDriver initialValue()
      {

         WebDriver d;
         if (System.getProperty("os.name").startsWith("Linux")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

         }
         if (System.getProperty("os.name").startsWith("Mac")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
         }
         if (System.getProperty("os.name").startsWith("Windows")) {
            String firefoxDriverPath = System.getProperty("user.dir")
                    + "//src//test//resources//drivers//windows//geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir")
                    + "//src//test//resources//drivers//windows//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
         }

         return new ChromeDriver(); // can be replaced with other browser drivers
      }
   };

   public WebDriver getDriver() // call this method to get the driver object and launch the browser
   {
      return driver.get();
   }

   public void removeDriver() // Quits the driver and closes the browser
   {
      driver.get().quit();
      driver.remove();
   }
}