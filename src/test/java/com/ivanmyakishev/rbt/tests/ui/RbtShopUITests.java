package com.ivanmyakishev.rbt.tests.ui;

/*
1. Выбор города +
2. Отображение товара по категории +
3. Ввод телефона для логина +
4. Поиск товара по названию +
5. Добавление товара в корзину
6. Удаление товара из корзины
 */

import com.ivanmyakishev.rbt.enums.MenuCategory;
import com.ivanmyakishev.rbt.pages.web.MainPage;
import com.ivanmyakishev.rbt.tests.testData.TestDataStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.List;

public class RbtShopUITests {
    private MainPage mainPage;
    private TestDataStorage testDataStorage;
    

    public RbtShopUITests() {
        mainPage = new MainPage();
        testDataStorage = new TestDataStorage();
    }

    @DisplayName("Успешный выбор города")
    @Test
    public void selectingTownCheck() {
        String checkingTown = testDataStorage.getUserData().getTown();
        
        mainPage.open()
                .openTownTable()
                .selectExistingTown(checkingTown)
                .checkSelectedTown(checkingTown);
    }

    @DisplayName("Успешный поиск по категории товара")
    @Test
    public void checkSuccessfulCategoryContentCheck() {
        List<String> testingContent = testDataStorage.getShopDataModel().getDigitalContent();
        MenuCategory selectedCategory = testDataStorage.getShopDataModel().getTestingCategory();
        
        mainPage.open()
                .openCategory(selectedCategory)
                .checkCategoryContent(testingContent);
    }

    @DisplayName("Успешная отправка кода для лгина")
    @Test
    public void checkSuccessfulSendingCodeForLogin() {
        String fakePhoneNumber = testDataStorage.getRussianFakePhoneNumber();
        mainPage.open()
                .openLoginPopup()
                .inputPhoneNumber(fakePhoneNumber)
                .checkSuccessfulSendingCode();
    }

    @DisplayName("Успешный поиск товара по названию")
    @Test
    public void checkSuccessfulSearchProductByName() {
        String searchingProduct = testDataStorage.getShopDataModel().getProductSearchValue();

        mainPage.open()
                .searchForProduct(searchingProduct)
                .checkProductSearchResult(searchingProduct);
    }
}
