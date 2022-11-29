package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PimPage extends BasePage {


    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
    public WebElement pimButton;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
    public WebElement configurationButton;

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    public WebElement employeeListButton;

    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    public WebElement addEmployeeButton;

    @FindBy(xpath = "//a[normalize-space()='Reports']")
    public WebElement reportsButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement employeeStatusDropDownArrow;

    @FindBy(xpath = "//h6")
    public WebElement pimHeader;

    public void getList() {

        List<WebElement> option = driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]"));

        for (WebElement element : option) {


            Assert.assertEquals("List not showing up", element.getText(), "-- Select --");

        }
    }

    public void clickOnPimButton() {
        pimButton.click();
    }

    public void employeeStatusDropDown() {
        employeeStatusDropDownArrow.click();
    }

    public void verifyUserIsOnPimPage() {
        Assert.assertEquals("Not on pim page", pimHeader.getText(), "PIM");
    }

    public void verifyPositionList() {

    }
}
