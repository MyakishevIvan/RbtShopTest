package com.ivanmyakishev.rbt.pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileScreen {
    public final SelenideElement profileLoginTitle = $x("//android.view.View[@content-desc='Войдите в профиль']");
    public final SelenideElement profileLoginDescription = $x("//android.view.View[@content-desc='Получайте Бонусные рубли за покупки и персональные предложения']");
    public final SelenideElement loginOrRegisterButton = $x("//android.widget.Button[@content-desc='Войти или зарегистрироваться']");

    public final SelenideElement storesMenuButton = $x("//android.view.View[@content-desc='Магазины']");
    public final SelenideElement helpMenuButton= $x("//android.view.View[@content-desc='Помощь']");
    public final SelenideElement settingsMenuButton= $x("//android.view.View[@content-desc='Настройки']");
    public final SelenideElement appealsMenuButton = $x("//android.view.View[@content-desc='Обращения']");
    public final SelenideElement aboutAppMenuButton = $x("//android.view.View[@content-desc='О приложении']");
    public final SelenideElement versionText = $x("//android.view.View[contains(@content-desc, 'Версия')]";);

    @Step("Tap on aboutAppMenu Button")
    public ProfileScreen tapOnAboutAppMenuButton() {
        appealsMenuButton.click();
        return this;
    }

    @Step("Check correct app version {expectedVersion}")
    public void checkAppVersion(String expectedVersion) {
        String actualVersion = versionText.getAttribute("content-desc").replace("Версия", "").trim();
        assertEquals(expectedVersion, actualVersion, "Неверная версия приложения");
    }
}
