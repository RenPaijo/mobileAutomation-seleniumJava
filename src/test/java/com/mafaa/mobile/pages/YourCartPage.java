package com.mafaa.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {

    AndroidDriver driver;

    public YourCartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this);
    }

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutBtn;

    private void scrollToCheckoutButton() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().descriptionContains(\"test-CHECKOUT\"))"));
    }

    public boolean isCheckoutButtonVisible() {
        scrollToCheckoutButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(checkoutBtn));

        return checkoutBtn.isDisplayed();
    }

    public boolean isItemVisible(String productName) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"" + productName + "\"))"));

        WebElement itemList = driver.findElement(By.xpath("//android.widget.TextView[@text='" + productName + "']"));
        return itemList.isDisplayed();
    }

    public void proceedToCheckout() {
        scrollToCheckoutButton();

        checkoutBtn.click();
    }
}
