package com.ivanmyakishev.rbt.tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.ivanmyakishev.rbt.pages.web.mainPage.MainPage;
import com.ivanmyakishev.rbt.configs.WebDriverConfigProvider;
import com.ivanmyakishev.rbt.utils.Attach;
import com.ivanmyakishev.rbt.testData.TestDataStorage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class UITestBase {
    protected final MainPage mainPage;
    protected final TestDataStorage testDataStorage;
    protected static WebDriverConfigProvider configReader;
    
    public UITestBase() {
        mainPage = new MainPage();
        testDataStorage = new TestDataStorage();
    }
    @BeforeAll
    static void beforeAll() {
         configReader = new WebDriverConfigProvider();
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
