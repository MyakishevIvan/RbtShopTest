package com.ivanmyakishev.rbt.api;

import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.FavoriteProductRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.RemoveProductFromCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.SearchProductRequestModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RbtShopApi {
    
    @Step("Add product with id={data.itemId} to cart")
    public Response addProductToCart(AddProductToCartRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .body(data)
                .post(Endpoints.ADD_PRODUCT_TO_CART);
    }

    @Step("Remove product with id={data.itemId} from cart")
    public Response removeProductFromCart(RemoveProductFromCartRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .body(data)
                .post(Endpoints.REMOVE_PRODUCT_FROM_CART);
    }

    @Step("Search Products By Query={data.query}")
    public Response searchProductsByQuery(SearchProductRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .queryParam("app", data.getApp())
                .queryParam("query", data.getQuery())
                .post(Endpoints.SEARCH_BY_QUERY);
    }

    @Step("Add product with id={data.itemId} to favorite")
    public Response addProductToFavorite(FavoriteProductRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .get(Endpoints.getAddToFavoritesURL(data.getItemId(), data.getAppName()));
    }

    @Step("Remove product with id={data.itemId} from favorite")
    public Response removeProductFromFavorite(FavoriteProductRequestModel data) {

        return given(RbtShopSpec.requestSpec)
                .get(Endpoints.getRemoveFromFavoritesURL(data.getItemId(), data.getAppName()));
    }
}
