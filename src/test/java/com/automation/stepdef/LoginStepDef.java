package com.automation.stepdef;

import com.automation.pages.AdminPage;
import com.automation.pages.LoginPage;
import com.automation.utils.logs.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        loginPage.openWebsite();
        Log.info("User is on login page");
    }

    @Given("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        loginPage.verifyPage();
        Log.info("verify user is on login page");
    }

    @When("user login with valid {string} and {string}")
    public void userLoginWithValidAnd(String username, String password) {
        loginPage.doLogin(username, password);
        Log.info("user login with valid {string} and {string}");
    }


    @Then("verify user in on homepage")
    public void verifyUserInOnHomepage() {
        adminPage.verifyUserIsLoggedIn();
        Log.info("verify user in on homepage");
    }


    @When("user login with valid {string} and {string} and {string}")
    public void userLoginWithValidAndAnd(String username, String password, String requiredError) {
        loginPage.verifyPage();
        loginPage.doLogin(username, password);
        loginPage.verifyRequiredError(requiredError);
    }

    @When("user log in with invalid credentials")
    public void userLogInWithInvalidCredentials() {
        loginPage.doLogin(" ", " ");

    }

    @Then("user receives required error message")
    public void userReceivesRequiredErrorMessage() {
        loginPage.failedTestCaseExample();
    }
}
