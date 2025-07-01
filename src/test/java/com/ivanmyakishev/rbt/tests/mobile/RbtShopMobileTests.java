package com.ivanmyakishev.rbt.tests.mobile;

import com.ivanmyakishev.rbt.configs.LocalMobileDriverProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RbtShopMobileTests extends LocalMobileDriverProvider {
    @Test
    @DisplayName("Selected city should displayed on main screen")
    public void selectedCityShouldDisplayed() {
        String city = testDataStorage.getAppDataModel().getCity();
        
        mainScreen.selectCity(city)
                        .checkCurrentCity(city);
    }

    @Test
    @DisplayName("Content list should be actual")
    public void contentListShouldBeActual() {
        List<String> expectedCategories = testDataStorage.getAppDataModel().getCategories();
        
        mainScreen.tapOnCatalogButton()
                .checkCatalogContainsAllExpectedItems(expectedCategories);
    }

    @Test
    @DisplayName("App version should be actual")
    public void appVersionShouldBeActual() {
        String expectedVersion = testDataStorage.getAppDataModel().getVersion();
        mainScreen.tapOnProfileButton()
                .tapOnAboutAppMenuButton()
                .checkAppVersion(expectedVersion);
    }

    @Test
    @DisplayName("Product should add to cart")
    public void addProductToCart() {
        String firstItemName = mainScreen.getFirstItemName();
        mainScreen.tapOnFirstSellItem()
                .tapOnItemCartButton()
                .tapOnItemGoToCartButton()
                .checkProductAddedToCart(firstItemName);
    }

    @Test
    @DisplayName("Company product should be greater than expected cound")
    public void verifyProductCountGreaterThan() {
        String productName = testDataStorage.getAppDataModel().getProductName();
        int minExpectedCount = testDataStorage.getAppDataModel().getProductMinExpectedCount();
        mainScreen.verifyProductCountGreaterThan(minExpectedCount, productName);
    }
}
