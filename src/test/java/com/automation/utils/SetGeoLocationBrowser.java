package com.automation.utils;
import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.bs.global.GlobalVariable;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;

public class SetGeoLocationBrowser {

    static String USERNAME = "<USERNAME>";
    static String AUTOMATE_KEY = "<ACCESS_KEY>";
    static String HUB_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    /**
     * THIS PROGRAM ALLOWS USER TO SET CUSTOM GEO LOCATION ON A BROWSER
     */

    public static void main(String[] args) {

        // EXECUTE ON CHROME
        geoLocation_on_chrome();

        // EXECUTE ON FIREFOX
        // geoLocation_on_firefox();

    }

    public static void geoLocation_on_chrome() {

        JavascriptExecutor js = null;
        WebDriver webDriver = null;
        String AUT_URL = "https://www.w3schools.com/html/html5_geolocation.asp";
        URL URLObj = null;
        DesiredCapabilities caps = null;

        try {

            URLObj = new URL(HUB_URL);

            caps = new DesiredCapabilities();

            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "64.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("project", "Test Run");
            caps.setCapability("name", "Build :: GeoLocation Chrome");
            caps.setCapability("browserstack.local", "false");
            caps.setCapability("browserstack.debug", "true");
            caps.setCapability("browserstack.video", "true");
            caps.setCapability("browserstack.networkLogs", "true");
            caps.setCapability("browserstack.idleTimeout", "300");
            // caps.setCapability("browserstack.ie.driver", "2.53.1");
            // caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "false");
            // caps.setCapability("acceptSslCerts", "true");
            // caps.setCapability("browserstack.localIdentifier", "Test123");

            webDriver = new RemoteWebDriver(URLObj, caps);
            js = (JavascriptExecutor) webDriver;

            webDriver.get(AUT_URL);
            // webDriver.manage().window().maximize();

            js.executeScript("window.navigator.geolocation.getCurrentPosition = function(success){ var position = {\"coords\" : {  \"latitude\": \"18.975080\",   \"longitude\": \"72.825838\" }  };  success(position);}");

            System.out.println("TITLE :: " + webDriver.getTitle());

            take_screenshot(webDriver);

            System.out.println("====>> DATE :: " + (String) js.executeScript("return Date()"));

            Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
            String browserName = cap.getBrowserName().toLowerCase();
            System.out.println("browserName :: " + browserName);
            String os = cap.getPlatform().toString();
            System.out.println("os :: " + os);
            String v = cap.getVersion().toString();
            System.out.println("version :: " + v);

            webDriver.findElement(By.xpath("//*[@id='main']/p[2]/button")).click();

            Thread.sleep(60000);
            take_screenshot(webDriver);
            Thread.sleep(60000);
            take_screenshot(webDriver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                webDriver.quit();
            }
        } // FINALLY END
    } // CHROME END

    public static void geoLocation_on_firefox() {

        JavascriptExecutor js = null;
        WebDriver webDriver = null;
        WebDriverWait wait = null;
        Actions act = null;
        String AUT_URL = "https://www.whatsmybrowser.org/";
        AUT_URL = "https://mylocation.org/";
        AUT_URL = "https://www.w3schools.com/html/html5_geolocation.asp";
        //AUT_URL = "https://self-signed.badssl.com/";
        //AUT_URL = "https://futurism.com/images/the-most-remarkable-breakthroughs-from-2017/";
        URL URLObj = null;
        DesiredCapabilities caps = null;

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.enabled", true);
        profile.setPreference("geo.provider.use_corelocation", true);
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        profile.setPreference("geo.wifi.uri", "data:application/json , { \"status\": \"OK\", \"accuracy\": 100.0, \"location\": { \"lat\": 18.975080, \"lng\": 72.825838, \"latitude\": 18.975080, \"longitude\": 72.825838, \"accuracy\": 100.0 } }");

        try {

            URLObj = new URL(HUB_URL);

            caps = new DesiredCapabilities();

            caps.setCapability("browser", "Firefox");
            caps.setCapability("browser_version", "59.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("project", "Test Run");
            caps.setCapability("name", "Build :: GeoLocation Firefox");
            caps.setCapability("browserstack.local", "false");
            caps.setCapability("browserstack.debug", "true");
            caps.setCapability("browserstack.video", "true");
            caps.setCapability("browserstack.networkLogs", "true");
            caps.setCapability("browserstack.idleTimeout", "300");
            // caps.setCapability("browserstack.ie.driver", "2.53.1");
            // caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "false");
            // caps.setCapability("acceptSslCerts", "true");
            // caps.setCapability("browserstack.localIdentifier", "Test123");

            // caps.setCapability(FirefoxDriver.PROFILE, profile);

            webDriver = new RemoteWebDriver(URLObj, caps);
            wait = new WebDriverWait(webDriver, 10000);
            act = new Actions(webDriver);
            js = (JavascriptExecutor) webDriver;

            webDriver.get(AUT_URL);
            // webDriver.manage().window().maximize();

            System.out.println("TITLE :: " + webDriver.getTitle());

            take_screenshot(webDriver);

            System.out.println("====>> DATE :: " + (String) js.executeScript("return Date()"));

            Capabilities cap = ((RemoteWebDriver) webDriver).getCapabilities();
            String browserName = cap.getBrowserName().toLowerCase();
            System.out.println("browserName :: " + browserName);
            String os = cap.getPlatform().toString();
            System.out.println("os :: " + os);
            String v = cap.getVersion().toString();
            System.out.println("version :: " + v);

            webDriver.findElement(By.xpath("//*[@id='main']/p[2]/button")).click();

            Thread.sleep(60000);
            take_screenshot(webDriver);
            Thread.sleep(60000);
            take_screenshot(webDriver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (webDriver != null) {
                webDriver.quit();
            }
        } // FINALLY END
    } // FIREFOX END

    public static void take_screenshot(WebDriver webDriver) {
        try {

            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) webDriver);

            //Call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
            File DestFile = new File("/Users/test.png");

            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);

        } catch (Exception e) {
            System.out.println("take_screenshot :: ERROR STORING SCREENSHIOT :: " + e.getMessage());
            // e.printStackTrace();
        }
    } // take_screenshot END
}