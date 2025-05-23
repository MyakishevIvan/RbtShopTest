package com.ivanmyakishev.rbt.pages.web.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectTownComponent {
    private final SelenideElement townInputField  = $(".SearchInput_input__iZM2o");
    private final ElementsCollection townsList = $$(".CitiesModal_cityName__kTZd2");

    @Step("Input town: {townName}")
    public SelectTownComponent inputTown(String townName) {
        townInputField.setValue(townName);
        return this;
    }

    @Step("Select existing town")
    public SelectTownComponent selectTown() {
        townsList.get(0).click();
        return this;
    }

    @Step("Check that town '{cityName}' does not exist in the list")
    public void checkTownNotExist(String cityName) {
        townsList
                .filterBy(text(cityName))
                .shouldBe(empty);
    }
}
