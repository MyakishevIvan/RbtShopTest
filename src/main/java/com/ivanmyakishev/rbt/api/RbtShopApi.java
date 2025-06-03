package com.ivanmyakishev.rbt.api;

import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.responsesModels.AddProductToCartResponseModel;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class RbtShopApi {
    
    @Step("Add product to cart")
    public AddProductToCartResponseModel addProductToCart(AddProductToCartRequestModel data) {
        return given(RbtShopSpec.requestSpec)
                .body(data)
                .post(Endpoints.ADD_PRODUCT_TO_BASKET)
                .then()
                .spec(RbtShopSpec.successfulResponse200Spec)
                .extract()
                .as(AddProductToCartResponseModel.class);
    }
}
