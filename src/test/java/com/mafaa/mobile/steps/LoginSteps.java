package com.mafaa.mobile.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.mafaa.mobile.drivers.DriverManager;
import com.mafaa.mobile.pages.LoginPage;
import com.mafaa.mobile.pages.ProductPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    ProductPage productPage = new ProductPage(DriverManager.getDriver());

    @Given("User clicks the {string} autofill entry and logs in")
    public void userClicksAutofillAndLogsIn(String username) {
        loginPage.tapAutofillUserAndLogin(username);
    }

    @Then("User lands on the products catalog page")
    public void productsCatalogDisplayed() {
        productPage.isCartButtonVisible();
    }
}
