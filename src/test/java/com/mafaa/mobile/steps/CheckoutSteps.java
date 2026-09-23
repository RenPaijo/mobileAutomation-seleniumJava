package com.mafaa.mobile.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import com.mafaa.mobile.drivers.DriverManager;
import com.mafaa.mobile.pages.CheckoutPage;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @And("User types {string} as first name, {string} as last name and {string} as zip code")
    public void userTypesCheckoutDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.fillDetailsAndContinue(firstName, lastName, zipCode);
    }

    @And("User hits continue and reaches the order summary page")
    public void userHitsContinueToSummary() {
        checkoutPage.confirmSummaryScreenShown();
    }

    @Then("User confirms the item and grand totals are accurate")
    public void userConfirmsTotalsAccurate() {
        checkoutPage.checkItemsSubtotal();
        checkoutPage.checkGrandTotal();
    }

    @And("User places the order and gets the thank-you note")
    public void userPlacesOrderAndGetsNote() {
        checkoutPage.placeOrder();
    }
}
