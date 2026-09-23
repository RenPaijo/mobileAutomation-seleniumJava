package com.mafaa.mobile.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URI;
import java.time.Duration;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName(System.getProperty("deviceName", "emulator-5554"))
                    .setAppPackage("com.swaglabsmobileapp")
                    .setAppActivity("com.swaglabsmobileapp.MainActivity")
                    .setApp(System.getProperty("user.dir")
                            + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                    .setNoReset(false);

            String udid = System.getProperty("udid", "");
            if (!udid.isBlank()) {
                options.setUdid(udid);
            }

            String serverUrl = System.getProperty("appiumServerUrl", "http://127.0.0.1:4723/");

            driver = new AndroidDriver(new URI(serverUrl).toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            throw new RuntimeException("Failed initialize driver: " + e.getMessage(), e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
