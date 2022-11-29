package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage{

    @FindBy(xpath = "//h6")
    WebElement dashboardText;

    public void verifyUserIsOnDashboard(){

        Assert.assertTrue("Not on dashboard", dashboardText.isDisplayed());
    }
}
