package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private final ElementsCollection cartItemsInfo = $$(".Product_info__7d7WP");
    private final ElementsCollection cartItems = $$(".Product_wrapper__2FfMR");

    @Step("Check product by name: {expectedName}")
    public CartPage checkProductByName(String expectedName) {
        cartItemsInfo.shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(40));
        cartItemsInfo.findBy(text(expectedName))
                .shouldBe(visible);
        return this;
    }

    @Step("Check product by id: {expectedId}")
    public CartPage checkProductById(String expectedId) {
        cartItems.shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(40));
        cartItems.findBy(attribute("data-item-id", expectedId))
                .shouldBe(visible);
        return this;
    }
}
