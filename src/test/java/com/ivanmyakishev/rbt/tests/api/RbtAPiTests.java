package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.api.RbtShopApi;
import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.RemoveProductFromCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.SearchProductRequestModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToCartResponseModel;
import com.ivanmyakishev.rbt.api.responsesModels.SearchProductResultResponseModel;
import com.ivanmyakishev.rbt.tests.testData.TestDataStorage;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RbtAPiTests  extends ApiTestBase{
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

    @DisplayName("Should remove existing product from cart")
    @Test
    public void removeExistingProductToCartTest() {
        AddProductToCartRequestModel addProductToCartRequestModel = testDataStorage.getAddProductToCartRequestModel();
        ValidatableResponse removeProductResponse = rbtShopApi.removeProductFromCart(new RemoveProductFromCartRequestModel(addProductToCartRequestModel.getItemId()));
        removeProductResponse
                .assertThat()
                .statusCode(200);
    }

    @DisplayName("Should not remove product from cart with incorrect id")
    @Test
    public void removeNonExistentProductFromCartTest() {
        ValidatableResponse removeProductResponse = rbtShopApi.removeProductFromCart(new RemoveProductFromCartRequestModel(99999));
        removeProductResponse
                .assertThat()
                .statusCode(400);
    }

    @DisplayName("Should find elements by query")
    @Test
    public void findElementByQuery() {
        SearchProductRequestModel searchProductRequestModel = testDataStorage.getSearchProductRequestModel();
        SearchProductResultResponseModel searchProductResultResponseModel = rbtShopApi.searchProductsByQuery(searchProductRequestModel);
        Assertions.assertEquals(searchProductRequestModel.getQuery(), searchProductResultResponseModel.getQuery());
        int actualSearchElementSize = searchProductResultResponseModel.getItems().size();
        Assertions.assertTrue(actualSearchElementSize > 0);
    }
}
