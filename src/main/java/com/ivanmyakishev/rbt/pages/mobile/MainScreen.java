package com.ivanmyakishev.rbt.pages.mobile;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainScreen {
    private static final String PRODUCT_ITEMS_XPATH = "//android.widget.ImageView[contains(@content-desc, '%s')]";
    private final SelenideElement cityLabel = $x("(//android.widget.ImageView[@content-desc])[1]");
    private final SelenideElement searchInput = $x("//android.widget.ImageView[@content-desc='Поиск по каталогу']");
    private final SelenideElement allPromotionsButton = $x("//android.widget.Button[@content-desc='Все акции']");
    private final  SelenideElement loginButton = $x("//android.widget.Button[@content-desc='Войти или зарегистрироваться']");
    private final  SelenideElement allCategoriesButton = $x("//android.widget.Button[@content-desc='Все категории']");
    private final SelenideElement catalogButton = $x("//android.widget.ImageView[@content-desc='Каталог']");
    private final SelenideElement cartButton = $x("//android.widget.ImageView[@content-desc='Корзина']");
    private final  SelenideElement profileButton = $x("//android.widget.ImageView[@content-desc='Профиль']");
    private final  SelenideElement itemCartButton = $x("//android.widget.ImageView[@content-desc='В корзину']");
    private final  SelenideElement itemGoToCartButton = $x("//android.widget.ImageView[@content-desc='→']");
    private final SelenideElement firstSellItem = $x("//android.widget.ImageView[contains(@content-desc, 'LERAN CEI')]");


    private final CartScreen cartScreen;
    private final CatalogScreen catalogScreen;
    private final ProfileScreen profileScreen;

    public MainScreen() {
        this.cartScreen = new CartScreen();
        this.profileScreen = new ProfileScreen();
        this.catalogScreen = new CatalogScreen();
    }
    @Step("Select city from list {cityName}")
    public MainScreen selectCity(String cityName) {
        String xpath = String.format("//android.view.View[@content-desc='%s']", cityName);
        SelenideElement cityElement = $x(xpath);
        cityElement.click();

        return this;
    }
    @Step("Check current city is displayed {city}")
    public void checkCurrentCity(String city) {
        cityLabel.shouldBe(visible)
                .shouldHave(attribute("content-desc", city));    }

    @Step("Tap on cart button")
    public CartScreen  tapOnCartButton() {
        cartButton.click();
        return cartScreen;
    }
    @Step("Tap on catalog button")
    public CatalogScreen  tapOnCatalogButton() {
        catalogButton.click();
        return catalogScreen;
    }
    @Step("Tap on profile button")
    public ProfileScreen  tapOnProfileButton() {
        profileButton.click();
        return profileScreen;
    }
    @Step("Tap on first sell item ")
    public MainScreen  tapOnFirstSellItem() {
        firstSellItem.click();
        return this;
    }

    @Step("Tap on item Cart Button")
    public MainScreen  tapOnItemCartButton() {
        itemCartButton.click();
        return this;
    }

    @Step("Tap on item GoToCart Button")
    public CartScreen  tapOnItemGoToCartButton() {
        itemGoToCartButton.click();
        return cartScreen;
    }

    @Step("Get item Name")
    public String  getFirstItemName() {
        String fullContent = firstSellItem.getAttribute("content-desc");
         return fullContent.split("\n")[1].trim();
    }

    @Step("Verify product count greater than {minExpectedCount} with label: {productName}")
    public void  verifyProductCountGreaterThan(int minExpectedCount, String productName) {
        String xpath = String.format(PRODUCT_ITEMS_XPATH, productName);
        ElementsCollection items = $$x(xpath);
        items.shouldHave(sizeGreaterThan(minExpectedCount));
    }
}
