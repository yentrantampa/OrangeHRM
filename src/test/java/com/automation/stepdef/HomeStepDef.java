package com.automation.stepdef;

import com.automation.pages.AdminPage;
import com.automation.utils.logs.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomeStepDef {
    AdminPage adminPage = new AdminPage();

    @When("user clicks on user badge")
    public void userClicksOnUserBadge() {
        adminPage.clickOnUserBadge();
        Log.info("user clicks on user badge");
    }

    @And("click on logout link")
    public void clickOnLogoutLink() {
        adminPage.clickOnLogoutLink();
        Log.info("click on logout link");
    }
}
