package com.ivanmyakishev.rbt.pages.web.mainPage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.ivanmyakishev.rbt.enums.MenuCategory;
import com.ivanmyakishev.rbt.pages.web.ProductsResultPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final TopNavigationComponent topNavigationComponent;
    private final LoginComponents loginComponents;
    private final SelectTownComponent selectTownComponent;
    private final SelenideElement productInputField = $(".SearchInput_input__pTUko");
    private final SelenideElement loginButton = $(".CabinetAction_actionTitle__g_b05");
    private final SelenideElement acceptTownPopupButton = $(".SelectCityPopup_buttonYes__6TCBw");
    private final SelenideElement anotherTownPopupButton = $(".SelectCityPopup_buttonAnother__BUHd_");
    private final SelenideElement selectTownFromMenuButton = $(".FirstLevelMenu_button__Csux1");


    public MainPage() {
        topNavigationComponent = new TopNavigationComponent();
        loginComponents = new LoginComponents();
        selectTownComponent = new SelectTownComponent();
    }

    @Step("Search for product: {productName}")
    public ProductsResultPage searchForProduct(String productName) {
        acceptTownPopupButton.click();
        productInputField.click();
        productInputField.setValue(productName);
        productInputField.pressEnter();
        return new ProductsResultPage();
    }

    @Step("Open main page")
    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    @Step("Open login popup")
    public LoginComponents openLoginPopup() {
        loginButton.click();
        return loginComponents;
    }

    @Step("Open selecting towns popup")
    public SelectTownComponent openSelectingTownsPopup() {
        selectTownFromMenuButton.click();
        return selectTownComponent;
    }

    @Step("Open product {categoryType} category")
    public ProductsResultPage openProductCategory(MenuCategory categoryType) {
        return topNavigationComponent.clickOnNavigationButton(categoryType);
    }

    @Step("Check selected town")
    public void checkSelectedTown(String town) {
        selectTownFromMenuButton.shouldHave(text(town));
    }
}
