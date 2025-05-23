package com.ivanmyakishev.rbt.tests.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    private final WebDriverConfig config;

    public ConfigProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        readConfiguration();
    }

    public void readConfiguration(){
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.timeout = config.getBrowserTimeout();
        Configuration.holdBrowserOpen = config.isBrowserHoldOpen();
        Configuration.headless = config.isBrowserHeadless();
    }
}
