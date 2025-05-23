package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement addProductToCartButton = $(".PrimaryButton_button__TkLTD.Right_button__uZZCF");
    private final SelenideElement goToCartButton = $(".BasketAction_action___uYAO");
    private final SelenideElement productSection = $("section.ProductContent_wrapper__ovIdy");

    @Step("Add product to cart")
    public ProductPage clickOnCartButton() {
        addProductToCartButton.click();
        return this;
    }

    @Step("Go to cart")
    public CartPage clickToCart() {
        goToCartButton.click();
        return new CartPage();
    }
    @Step("Get product id")
    public String getProductId() {
        return productSection.getAttribute("data-item-id");
    }
}
