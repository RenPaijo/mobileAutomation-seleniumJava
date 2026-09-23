package com.mafaa.mobile.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import com.mafaa.mobile.drivers.DriverManager;
import com.mafaa.mobile.pages.ProductPage;
import com.mafaa.mobile.pages.YourCartPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage(DriverManager.getDriver());
    YourCartPage cartPage = new YourCartPage(DriverManager.getDriver());

    @When("User drops {string} and {string} into the basket")
    public void userDropsItemsIntoBasket(String item1, String item2) {
        productPage.addItemToBasket(item1);
        productPage.addItemToBasket(item2);
    }

    @And("User opens the shopping basket page")
    public void userOpensBasketPage() {
        productPage.openBasket();
        cartPage.isCheckoutButtonVisible();
    }
}
