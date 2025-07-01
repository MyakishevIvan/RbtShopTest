package com.ivanmyakishev.rbt.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/localMobile.properties"
})
public interface LocalMobileConfig extends Config {
    @Key("appiumServerUrl")
    String getAppiumServerUrl();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
