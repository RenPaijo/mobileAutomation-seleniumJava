package com.mafaa.mobile.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.mafaa.mobile.drivers.DriverManager;
import com.mafaa.mobile.pages.CheckoutPage;
import com.mafaa.mobile.pages.YourCartPage;

public class YourCartSteps {

    YourCartPage cartPage = new YourCartPage(DriverManager.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @Then("User spots {string} and {string} inside the basket")
    public void userSpotsBothItems(String itemList1, String itemList2) {
        cartPage.isItemVisible(itemList1);
        cartPage.isItemVisible(itemList2);
    }

    @When("User heads to the checkout form")
    public void userHeadsToCheckoutForm() {
        cartPage.proceedToCheckout();
        checkoutPage.isContinueButtonVisible();
    }
}
