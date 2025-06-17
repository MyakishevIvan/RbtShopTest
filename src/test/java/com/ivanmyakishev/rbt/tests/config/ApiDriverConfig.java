package com.ivanmyakishev.rbt.tests.config;

import org.aeonbits.owner.Config;
@Config.Sources({
        "classpath:properties/local.properties"
})
public interface ApiDriverConfig extends Config {
    @Config.Key("api.saveCookie")
    @Config.DefaultValue("false")
    boolean isSaveCookie();

    @Config.Key("api.baseUrl")
    String getBaseUrl();
}
