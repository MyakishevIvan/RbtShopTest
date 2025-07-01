package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.api.RbtShopApi;
import com.ivanmyakishev.rbt.configs.ApiConfigProvider;
import com.ivanmyakishev.rbt.testData.TestDataStorage;
import com.ivanmyakishev.rbt.utils.CookieUtils;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    protected final TestDataStorage testDataStorage = new TestDataStorage();
    protected final RbtShopApi rbtShopApi = new RbtShopApi();
    protected static ApiConfigProvider apiConfigProvider;

    @BeforeAll
    static void setUp() {
        apiConfigProvider = new ApiConfigProvider();
        CookieUtils.fetchCookiesOnce(RestAssured.baseURI);
    }
}
