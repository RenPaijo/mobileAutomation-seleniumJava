package com.mafaa.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    AndroidDriver driver;

    public ProductPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this);
    }

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartBtn;

    public boolean isCartButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cartBtn));

        return cartBtn.isDisplayed();
    }

    public void addItemToBasket(String productName) {
        WebElement addToCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName
                + "']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']"));

        addToCartBtn.click();
    }

    public void openBasket() {
        cartBtn.click();
    }
}
