package com.automation.stepdef;

import com.automation.pages.AdminPage;
import com.automation.pages.DashBoardPage;
import com.automation.pages.LoginPage;
import com.automation.pages.PimPage;
import com.automation.utils.logs.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class PimStepDef {

    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();
    PimPage pimPage = new PimPage();
    AdminPage adminPage = new AdminPage();

    @Given("User is on dashboard")
    public void userIsOnDashboard() {
        loginPage.openWebsite();
        Log.info("User is on login page");
        loginPage.verifyPage();
        Log.info("verify user is on login page");
        loginPage.doLogin("Admin", "admin123");
        Log.info("user login with valid {string} and {string}");
        adminPage.verifyUserIsLoggedIn();
        Log.info("verify user in on homepage");
    }

    @Given("User clicks on PIM button navigation bar")
    public void userClicksOnPIMButtonNavigationBar() {
        pimPage.clickOnPimButton();
        Log.info("User clicks on PIM button navigation bar");
    }

    @When("User is on PIM page")
    public void userIsOnPIMPage() {
        pimPage.verifyUserIsOnPimPage();
        Log.info("User is on PIM page");
    }

    @And("User clicks on employment status drop down menu arrow")
    public void userClicksOnEmploymentStatusDropDownMenuArrow() {
        pimPage.employeeStatusDropDown();
        Log.info("User clicks on employment status drop down menu arrow");
    }

    @Then("User gets a list of employment positions")
    public void userGetsAListOfEmploymentPositions() {
        pimPage.getList();
        Log.info("User gets a list of employment positions");
    }
}
