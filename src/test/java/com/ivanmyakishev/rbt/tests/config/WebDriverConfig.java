package com.ivanmyakishev.rbt.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/local.properties"
})
public interface WebDriverConfig extends Config {
    @Config.Key("browser.name")
    @Config.DefaultValue("chrome")
    String getBrowserName();

    @Config.Key("browser.baseUrl")
    String getBaseUrl();
    
    @Config.Key("browser.size")
    @Config.DefaultValue("1920x1080")
    String getBrowserSize();   
    
    @Config.Key("browser.timeout")
    @Config.DefaultValue("10000")
    int getBrowserTimeout();

    @Config.Key("browser.holdBrowserOpen")
    @Config.DefaultValue("true")
    boolean isBrowserHoldOpen();
    
    @Config.Key("browser.headless")
    @Config.DefaultValue("false")
    boolean isBrowserHeadless();

    @Config.Key("browser.pageLoadStrategy")
    @Config.DefaultValue("eager")
    String pageLoadStrategy();
}
