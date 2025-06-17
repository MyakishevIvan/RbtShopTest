package com.ivanmyakishev.rbt.tests.config;

import io.restassured.RestAssured;

public class ApiConfigProvider extends BaseConfigProvider<ApiDriverConfig>{
    public ApiConfigProvider() {
        super(ApiDriverConfig.class);
    }

    @Override
    public void readConfiguration(){
        RestAssured.baseURI = config.getBaseUrl();
    }
}
