
package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
//	public  static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
//	

    public TestBase() throws IOException {

        prop = new Properties();

        try {
            FileInputStream ip = new FileInputStream(
                "C:/QA/Selenium_Workspace1/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties"
            );

            prop.load(ip);
            ip.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
    }

    public static void initialization() throws IOException {

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browserName);
        }
//
//    	e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(
            Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

        driver.manage().timeouts().pageLoadTimeout(
            Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));

        driver.get(prop.getProperty("url"));
    }
}
