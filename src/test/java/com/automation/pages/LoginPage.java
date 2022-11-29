package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.logs.Log;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passWord;

    @FindBy(xpath = "//button")
    WebElement loginButton;

    @FindBy(xpath = "//h6[text()='PIM']")
    WebElement headerPim;

    @FindBy(xpath = "//span[contains(@class,'error')]")
    WebElement requiredErrorMessage;

    @FindBy(css = ".oxd-text.oxd-text--p.oxd-alert-content-text")
    WebElement invalidCredentialErrorMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
    }

    public void verifyPage() {
        //Username & password text is displayed in login page username & password text boxes
        Assert.assertTrue("User is not on login page", userName.isDisplayed());
        Assert.assertTrue("User is not on login page", passWord.isDisplayed());
    }


    public void openWebsite() {
        driver.get(ConfigReader.getProperty("app.baseurl"));
    }

    public void verifyInvalidCredentialErrorMessage(String invalidCredentialError) {
        Assert.assertEquals("Error message is not displayed invalidCredentialError ", invalidCredentialErrorMessage.getText(), invalidCredentialError);
        System.out.println(invalidCredentialErrorMessage.getText());
        Log.info("Invalid credential error message is displayed " + invalidCredentialErrorMessage.getText());
    }

    public void verifyRequiredError(String requiredError) {
        Assert.assertEquals("Error message is not displayed requiredError ", requiredErrorMessage.getText(), requiredError);
        System.out.println(requiredErrorMessage.getText());
        Log.info("Required error message is not displayed requiredError " + requiredError);
    }

    public void failedTestCaseExample() {
        Assert.assertEquals("Error message is not displayed invalidCredentialError ", invalidCredentialErrorMessage.getText(), "123");
        System.out.println(invalidCredentialErrorMessage.getText());
        Log.info("Invalid credential error message is displayed " + invalidCredentialErrorMessage.getText());
    }
}


