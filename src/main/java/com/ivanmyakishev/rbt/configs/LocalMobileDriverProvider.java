package com.ivanmyakishev.rbt.configs;

import com.codeborne.selenide.WebDriverProvider;
import com.ivanmyakishev.rbt.pages.mobile.MainScreen;
import com.ivanmyakishev.rbt.testData.TestDataStorage;
import com.ivanmyakishev.rbt.testData.models.AppDataModel;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalMobileDriverProvider extends BaseConfigProvider<LocalMobileConfig> implements WebDriverProvider {
    protected final MainScreen mainScreen;
    protected final TestDataStorage testDataStorage;
    
    public LocalMobileDriverProvider() {
        super(LocalMobileConfig.class);
        mainScreen = new MainScreen();
        testDataStorage = new TestDataStorage();
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.getPlatformVersion())
                .setDeviceName(config.getDeviceName())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        try {
            return new AndroidDriver(new URL(config.getAppiumServerUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
