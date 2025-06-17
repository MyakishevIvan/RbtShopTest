package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.api.RbtShopSpec;
import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.FavoriteProductRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.RemoveProductFromCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.SearchProductRequestModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToCartResponseModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToFavoriteResponseModel;
import com.ivanmyakishev.rbt.api.responsesModels.SearchProductResultResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//TODO
//Двойное удаление и добавление товараа из корзины

public class RbtShopApiTests extends ApiTestBase {
    
    @DisplayName("Should add product to cart")
    @Test
    public void addProductToCart() {
        AddProductToCartRequestModel requestModel = testDataStorage.getAddProductToCartRequestModel();

        AddProductToCartResponseModel responseModel = rbtShopApi.addProductToCart(requestModel)
                .then()
                .spec(RbtShopSpec.response200Spec)
                .extract()
                .as(AddProductToCartResponseModel.class);

        long actualItemId = responseModel.getItems().get(0).getItemId();
        long expectedItemId = requestModel.getItemId();
        Assertions.assertEquals(actualItemId, expectedItemId);
    }

    @DisplayName("Should not add product to cart with incorrect Id")
    @Test
    public void addProductToCartWithIncorrectId() {
        AddProductToCartRequestModel requestModel = testDataStorage.getIncorrectDataForAddingToCart();

        rbtShopApi.addProductToCart(requestModel)
                .then()
                .spec(RbtShopSpec.response400Spec);

    }
    
    @DisplayName("Should remove existing product from cart")
    @Test
    public void removeExistingProductFromCart() {
        AddProductToCartRequestModel requestModel = testDataStorage.getAddProductToCartRequestModel();
        rbtShopApi.addProductToCart(requestModel);

        rbtShopApi.removeProductFromCart(new RemoveProductFromCartRequestModel(requestModel.getItemId()))
                .then()
                .spec(RbtShopSpec.response200Spec);
    }

    @DisplayName("Should not remove product from cart with incorrect id")
    @Test
    public void removeNonExistentProductFromCart() {
        int incorrectProductId = testDataStorage.getIncorrectProductId();

        rbtShopApi.removeProductFromCart(new RemoveProductFromCartRequestModel(incorrectProductId))
                .then()
                .spec(RbtShopSpec.response400Spec);
    }

    @DisplayName("Should find elements by query")
    @Test
    public void findElementByQuery() {
        SearchProductRequestModel dataModel = testDataStorage.getSearchProductRequestModel();

        SearchProductResultResponseModel responseModel = rbtShopApi.searchProductsByQuery(dataModel)
                .then()
                .spec(RbtShopSpec.response200Spec)
                .extract()
                .as(SearchProductResultResponseModel.class);

        Assertions.assertEquals(dataModel.getQuery(), responseModel.getQuery());
        
        int actualSearchElementSize = responseModel.getItems().size();
        Assertions.assertTrue(actualSearchElementSize > 0);
    }

    @DisplayName("Should add product to favorite")
    @Test
    public void addProductToFavorite() {
        FavoriteProductRequestModel requestModel = testDataStorage.getFavoriteProductRequestModel();
        AddProductToFavoriteResponseModel responseModel = rbtShopApi.addProductToFavorite(requestModel)
                .then()
                .spec(RbtShopSpec.response200Spec)
                .extract()
                .as(AddProductToFavoriteResponseModel.class);

        long actualItemId = responseModel.getItemId();
        long expectedItemId = requestModel.getItemId();
        Assertions.assertEquals(actualItemId, expectedItemId);
    }

    @DisplayName("Should not add product to favorite with incorrectId")
    @Test
    public void addNotExistingProductToFavorite() {
        FavoriteProductRequestModel requestModel = testDataStorage.getIncorrectDataForAddingToFavorite();
        rbtShopApi.addProductToFavorite(requestModel)
                .then()
                .spec(RbtShopSpec.response400Spec);
    }

    @DisplayName("Should remove product from favorite")
    @Test
    public void removeExistingProductToFavorite() {
        FavoriteProductRequestModel requestModel = testDataStorage.getFavoriteProductRequestModel();
        rbtShopApi.removeProductFromFavorite(requestModel)
                .then()
                .spec(RbtShopSpec.response200Spec);
    }

    @DisplayName("Should not remove product from favorite with incorrectId")
    @Test
    public void removeNotExistingProductToFavorite() {
        FavoriteProductRequestModel requestModel = testDataStorage.getIncorrectDataForAddingToFavorite();
        rbtShopApi.removeProductFromFavorite(requestModel)
                .then()
                .spec(RbtShopSpec.response400Spec);
    }
}
