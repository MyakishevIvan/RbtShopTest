package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.api.RbtShopApi;
import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToCartResponseModel;
import com.ivanmyakishev.rbt.tests.testData.TestDataStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RbtAPiTests extends ApiTestBase {
    private final TestDataStorage testDataStorage;
    private final RbtShopApi rbtShopApi;


    public RbtAPiTests() {
        testDataStorage = new TestDataStorage();
        rbtShopApi = new RbtShopApi();
    }

    @DisplayName("Should add product to cart")
    @Test
    public void addProductToCartTest() {
        AddProductToCartRequestModel addProductToCartRequestModel = testDataStorage.getAddProductToCartRequestModel();
        AddProductToCartResponseModel addProductToCartResponseModel = rbtShopApi.addProductToCart(addProductToCartRequestModel);
        long actualItemId = addProductToCartResponseModel.getItems().get(0).getItemId();
        long expectedItemId = addProductToCartRequestModel.getItemId();
        Assertions.assertEquals(actualItemId, expectedItemId);
    }
}
