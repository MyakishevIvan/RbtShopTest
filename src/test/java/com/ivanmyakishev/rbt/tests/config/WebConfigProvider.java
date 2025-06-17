package com.ivanmyakishev.rbt.tests.config;

import com.codeborne.selenide.Configuration;

public class WebConfigProvider extends BaseConfigProvider<WebDriverConfig> {

    public WebConfigProvider() {
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
