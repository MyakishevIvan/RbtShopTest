package com.ivanmyakishev.rbt.pages.mobile;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CartScreen {
    private final SelenideElement cartTitle = $x("//android.view.View[@content-desc='Корзина']");
    private final SelenideElement cityButton = $x("//android.widget.Button[@content-desc='Абакан']");

    SelenideElement productCard = $x("(//android.view.View[@content-desc])[1]");
    private final SelenideElement expressServiceButton = $x("//android.widget.ImageView[@content-desc='Экспресс-сервис']");
    private final SelenideElement totalItemsInfo = $x("//android.view.View[@content-desc='Товары: 1 шт. ']");
    private final SelenideElement totalPriceLabel = $x("//android.view.View[@content-desc='Итого: ']");
    private final SelenideElement checkoutButton = $x("//android.widget.Button[@content-desc='Войти и оформить']");



    public void checkProductAddedToCart(String itemName) {
        SelenideElement cartItem = $x("//android.view.View[contains(@content-desc, '" + itemName + "')]");
        cartItem.shouldBe(visible);
    }
}
