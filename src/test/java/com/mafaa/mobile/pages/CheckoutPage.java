package com.mafaa.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutPage {

    AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this);
    }

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement continueBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private WebElement checkoutOverviewPageTitle;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[1]//android.widget.TextView")
    private WebElement priceItem1;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Price'])[2]//android.widget.TextView")
    private WebElement priceItem2;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Item total')]")
    private WebElement totalItemPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Tax')]")
    private WebElement tax;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Total')]")
    private WebElement totalPrice;

    @AndroidFindBy(accessibility = "test-FINISH")
    private WebElement finishBtn;

    @AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.ImageView")
    private WebElement mascotImg;

    public boolean isContinueButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(continueBtn));

        return continueBtn.isDisplayed();
    }

    public void fillDetailsAndContinue(String firstName, String lastName, String zipCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        continueBtn.click();
    }

    public boolean confirmSummaryScreenShown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(checkoutOverviewPageTitle));

        return checkoutOverviewPageTitle.isDisplayed();
    }

    public void checkItemsSubtotal() {
        String priceText1 = priceItem1.getText().replace("$", "");
        Double price1 = Double.parseDouble(priceText1);

        String priceText2 = priceItem2.getText().replace("$", "");
        Double price2 = Double.parseDouble(priceText2);

        Double price3 = price1 + price2;

        String priceItemTotal = String.valueOf(price3);

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().textContains(\"Total: $\"))"));

        String priceTotalItem = totalItemPrice.getText().replace("Item total: $", "");

        assertEquals(priceItemTotal, priceTotalItem);
    }

    public void checkGrandTotal() {
        String taxPrice = tax.getText().replace("Tax: $", "");
        Double priceTax = Double.parseDouble(taxPrice);

        String priceTotalItem = totalItemPrice.getText().replace("Item total: $", "");
        Double priceItemTotal = Double.parseDouble(priceTotalItem);

        Double totalWithTax = priceTax + priceItemTotal;
        String totalPriceWithTax = String.valueOf(totalWithTax);

        String priceWithTax = totalPrice.getText().replace("Total: $", "");

        assertEquals(totalPriceWithTax, priceWithTax);
    }

    public boolean placeOrder() {
        finishBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mascotImg));

        return mascotImg.isDisplayed();
    }
}
