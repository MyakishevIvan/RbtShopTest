package com.ivanmyakishev.rbt.utils;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import java.util.Set;
import java.util.stream.Collectors;

public class CookieUtils {
    private static String cookieText;

    public static void fetchCookiesOnce(String url) {
        if (cookieText == null) {
            Configuration.headless = true; 
            Configuration.browser = "chrome";
            open(url);
            Selenide.sleep(2000); 
            Set<org.openqa.selenium.Cookie> cookies = WebDriverRunner.getWebDriver().manage().getCookies();
            cookieText = cookies.stream()
                    .map(c -> c.getName() + "=" + c.getValue())
                    .collect(Collectors.joining("; "));
            WebDriverRunner.closeWebDriver();
        }
    }

    public static String getCookieText() {
        if (cookieText == null) {
            throw new IllegalStateException("Cookies not initialized. Call fetchCookiesOnce() first.");
        }
        return cookieText;
    }
}
