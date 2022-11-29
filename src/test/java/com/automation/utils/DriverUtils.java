package com.automation.utils;

import com.automation.utils.logs.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {
    public static final String USERNAME = ConfigReader.getProperty("bs.username");
    public static final String AUTOMATE_KEY = ConfigReader.getProperty("bs.key");
    public static final String URL = String.format(ConfigReader.getProperty("bs.url"),USERNAME,AUTOMATE_KEY);
    static WebDriver driver;


    public static void createDriver()  {
        // Desire capabilities is what type of session we want

        //Choose what browser & version to be ran on device type in browserstack
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");

        //Creates OS version & Device configurations (browser in configdata.properties must be set as remote)
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

        browserstackOptions.put("osVersion", "15.6");
        browserstackOptions.put("deviceName", "iPhone 13 Pro");
        browserstackOptions.put("realMobile", "true");
        browserstackOptions.put("buildName", "version_0.0.1");
        browserstackOptions.put("projectName", "OrangeHRM Demo");
        browserstackOptions.put("local", "false");
        capabilities.setCapability("bstack:options", browserstackOptions);

        //Switches what browser to be tested (change browser in configdata.properties)
        switch (ConfigReader.getProperty("browser")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                Log.info("Opening firefox");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                Log.info("Opening edge");
                break;
            case "remote"://browserstack
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                    Log.info("Opening browserStack");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                Log.info("Opening chrome");//default browser
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.get(ConfigReader.getProperty("app.baseurl"));
        Log.info("Opening url");
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
