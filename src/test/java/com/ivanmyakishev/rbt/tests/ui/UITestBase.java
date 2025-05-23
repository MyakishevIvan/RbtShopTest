package com.ivanmyakishev.rbt.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.ivanmyakishev.rbt.tests.config.ConfigProvider;
import com.ivanmyakishev.rbt.tests.helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class UITestBase {
    @BeforeAll
    static void beforeAll() throws IOException {
        Configuration.pageLoadStrategy = "eager";
        ConfigProvider configReader = new ConfigProvider();
    }

    @BeforeEach
    public void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.addVideo();
        Attach.pageSource();
        closeWebDriver();
    }
}
