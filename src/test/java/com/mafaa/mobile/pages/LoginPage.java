package com.mafaa.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this);
    }

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginBtn;

    public void tapAutofillUserAndLogin(String username) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().text(\"" + username + "\"))"));

        driver.findElement(By.xpath("//android.widget.TextView[@text='" + username + "']")).click();
        loginBtn.click();
    }
}
