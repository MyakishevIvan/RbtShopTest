package com.ivanmyakishev.rbt.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/browserstack.properties"
})
public interface BrowserStackConfig extends Config {
    @Key("app")
    String getApp();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOs_version();

    @Key("platformName")
    String getPlatformName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
