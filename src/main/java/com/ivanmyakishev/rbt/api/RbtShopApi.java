package com.ivanmyakishev.rbt.api;

import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.RemoveProductFromCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.SearchProductRequestModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToCartResponseModel;
import com.ivanmyakishev.rbt.api.responsesModels.SearchProductResultResponseModel;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RbtShopApi {
    
    @Step("Add product to cart")
    public AddProductToCartResponseModel addProductToCart(AddProductToCartRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .body(data)
                .post(Endpoints.ADD_PRODUCT_TO_CART)
                .then()
                .spec(RbtShopSpec.successfulResponse200Spec)
                .extract()
                .as(AddProductToCartResponseModel.class);
    }

    @Step("Remove product from cart")
    public ValidatableResponse removeProductFromCart(RemoveProductFromCartRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .body(data)
                .post(Endpoints.REMOVE_PRODUCT_FROM_CART)
                .then();
    }

    @Step("search Products By Query")
    public SearchProductResultResponseModel searchProductsByQuery(SearchProductRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .queryParam("app", data.getApp())
                .queryParam("query", data.getQuery())
                .post(Endpoints.SEARCH_BY_QUERY)
                .then()
                .spec(RbtShopSpec.successfulResponse200Spec)
                .extract()
                .as(SearchProductResultResponseModel.class);
    }
}
