package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.utils.CookieUtils;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {
    @BeforeAll
    static void setUp() {
        CookieUtils.fetchCookiesOnce("https://www.rbt.ru/");
    }
}
