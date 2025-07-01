package com.ivanmyakishev.rbt.configs;

import com.codeborne.selenide.Configuration;

public class WebDriverConfigProvider extends BaseConfigProvider<WebDriverConfig> {

    public WebDriverConfigProvider() {
        super(WebDriverConfig.class);
    }

    @Override
    public void readConfiguration(){
        Configuration.browser = config.getBrowserName();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.timeout = config.getBrowserTimeout();
        Configuration.holdBrowserOpen = config.isBrowserHoldOpen();
        Configuration.headless = config.isBrowserHeadless();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();
    }
}
