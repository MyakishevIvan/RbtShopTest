package com.ivanmyakishev.rbt.pages.mobile;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogScreen {
    private final SelenideElement kitchenTechButton = $x("//android.view.View[@content-desc='Кухонная техника']");
    private final SelenideElement digitalDevicesButton = $x("//android.view.View[@content-desc='Цифровые устройства']");
    private final SelenideElement builtInTechButton = $x("//android.view.View[@content-desc='Встраиваемая техника']");
    private final SelenideElement tvAudioVideoButton = $x("//android.view.View[@content-desc='Теле-видео-аудио']");
    private final SelenideElement homeAppliancesButton = $x("//android.view.View[@content-desc='Техника для дома']");
    private final SelenideElement computersAndOfficeButton = $x("//android.view.View[@content-desc='Компьютеры и оргтехника']");
    private final SelenideElement gadgetsButton = $x("//android.view.View[@content-desc='Гаджеты']");
    private final SelenideElement smartHomeButton = $x("//android.view.View[@content-desc='Умный дом']");
    private final SelenideElement climateTechButton = $x("//android.view.View[@content-desc='Климатическая техника']");
    private final SelenideElement beautyAndHealthButton = $x("//android.view.View[@content-desc='Красота и здоровье']");
    ElementsCollection catalogItems = $$x("//android.view.View[@content-desc]");
    
    public void checkCatalogContainsAllExpectedItems(List<String> expectedNames) {
        for (String expected : expectedNames) {
            catalogItems.findBy(attribute("content-desc", expected))
                    .shouldBe(visible);
    }
    }
}
