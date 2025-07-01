package com.ivanmyakishev.rbt.tests.web;

import com.ivanmyakishev.rbt.enums.MenuCategory;
import com.ivanmyakishev.rbt.pages.web.ProductPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.List;

/*
TODO:
 Удаление товара из корзины
 Проверка логотипа
 */

public class RbtShopUITests extends UITestBase{

    @DisplayName("Should select town from main page")
    @Test
    public void shouldSelectTownSuccessfully() {
        String checkingTown = testDataStorage.getUserDataModel().getExistingTown();

        mainPage.open()
                .openSelectingTownsPopup()
                .inputTown(checkingTown)
                .selectTown();
        
        mainPage.checkSelectedTown(checkingTown);
    }

    @DisplayName("City is not displayed when entering an invalid name")
    @Test
    public void shouldNotDisplayTownForInvalidInput() {
        String notExistingTown = testDataStorage.getUserDataModel().getNotExistingTown();

        mainPage.open()
                .openSelectingTownsPopup()
                .inputTown(notExistingTown)
                .checkTownNotExist(notExistingTown);
    }

    @DisplayName("Should display correct content for selected category ")
    @Test
    public void shouldDisplayCorrectContentForSelectedCategory() {
        List<String> testingContent = testDataStorage.getShopDataModel().getDigitalContent();
        MenuCategory selectedCategory = testDataStorage.getShopDataModel().getTestingCategory();
        
        mainPage.open()
                .openProductCategory(selectedCategory)
                .checkCategoryContent(testingContent);
    }

    @DisplayName("Verification code is sent successfully for login")
    @Test
    public void shouldSendLoginCodeSuccessfully() {
        String fakePhoneNumber = testDataStorage.getRussianFakePhoneNumber();
        mainPage.open()
                .openLoginPopup()
                .inputPhoneNumber(fakePhoneNumber)
                .clickLoginButton()
                .checkSuccessfulSendingCode();
    }

    @DisplayName("Should not send login code for invalid phone number")
    @Test
    public void shouldNotSendLoginCodeForInvalidPhone() {
        String invalidPhoneNumber = testDataStorage.generateInvalidRussianPhoneNumber();
        mainPage.open()
                .openLoginPopup()
                .inputPhoneNumber(invalidPhoneNumber)
                .clickLoginButton()
                .checkErrorMessageForInvalidPhoneNumber();
    }

    @DisplayName("Should find product by name")
    @Test
    public void shouldFindProductByName() {
        String searchingProduct = testDataStorage.getShopDataModel().getValidProductName();

        mainPage.open()
                .searchForProduct(searchingProduct)
                .checkProductSearchResult(searchingProduct);
    }

    @DisplayName("Should not display Product by invalid name")
    @Test
    public void shouldNotDisplayProductByInvalidSearchName() {
        String invalidProductName = testDataStorage.getShopDataModel().getInvalidProductName();

        mainPage.open()
                .searchForProduct(invalidProductName)
                .checkCountOfSearchingElement(0);
    }
    
    @DisplayName("should add product to cart")
    @Test
    public void shouldAddProductToCartSuccessfully() {
        String productName = testDataStorage.getShopDataModel().getValidProductName();

        ProductPage productPage = mainPage
                .open()
                .searchForProduct(productName)
                .clickOnSearchResultElement(0);

        String productId = productPage.getProductId();

        productPage
                .clickOnCartButton()
                .clickToCart()
                .checkProductByName(productName)
                .checkProductById(productId);
    }
    
}
