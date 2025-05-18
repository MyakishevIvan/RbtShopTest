package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.ivanmyakishev.rbt.enums.MenuCategory;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/*
1. Выбор города +
2. Отображение товара по категории +
3. Ввод телефона для логина +
4. Поиск товара по названию
5. Добавление товара в корзину
6. Удаление товара из корзины
7. Добавление в избранное
8. Удаление из избранного
 */
public class MainPage {
    private final TopNavigationComponent topNavigationComponent;
    //Product input 
    private final SelenideElement inputField = $(".SearchInput_input__pTUko");

    //login with number
    private final SelenideElement loginButton = $(".CabinetAction_actionTitle__g_b05");
    private final SelenideElement phoneNumberInput = $(".MaskInput_input__OqrYF");
    private final SelenideElement loginPopup = $(".AuthCodeModal_wrapper__toi92");
    //popup select town
    private final SelenideElement acceptTownPopupButton = $(".SelectCityPopup_buttonYes__6TCBw");
    private final SelenideElement anotherTownPopupButton = $(".SelectCityPopup_buttonAnother__BUHd_");
    //Selecting and find town from main menu
    private final SelenideElement selectTownFromMenuButton = $(".FirstLevelMenu_button__Csux1");//town from menu
    private final SelenideElement findTownInput = $(".SearchInput_input__iZM2o");
    private final SelenideElement selectTownFromInputButton = $(".CitiesModal_cityName__kTZd2");

    public MainPage() {
        topNavigationComponent = new TopNavigationComponent();
    }

    @Step("Search for product: {productName}")
    public ProductsResultPage searchForProduct(String productName) {
        acceptTownPopupButton.click();
        inputField.click();
        inputField.setValue(productName);
        inputField.pressEnter();
        return new ProductsResultPage();
    }

    @Step("Open page")
    public MainPage open() {
        Selenide.open();
        return this;
    }

    @Step("Open login popup")
    public MainPage openLoginPopup() {
        loginButton.click();
        return this;
    }

    @Step("Input phone number")
    public MainPage inputPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }


    @Step("Open town table")
    public MainPage openTownTable() {
        selectTownFromMenuButton.click();
        return this;
    }

    @Step("Select existing town")
    public MainPage selectExistingTown(String town) {
        findTownInput.setValue(town);
        selectTownFromInputButton.click();
        return this;
    }

    @Step("Open category")
    public ProductsResultPage openCategory(MenuCategory category) {
        return topNavigationComponent.clickOnNavigationButton(category);
    }

    @Step("Check successful sending code")
    public void checkSuccessfulSendingCode() {
        loginPopup.shouldHave(text("Код подтверждения"));
    }

    @Step("Check selected town")
    public void checkSelectedTown(String town) {
        selectTownFromMenuButton.shouldHave(text(town));
    }
}
