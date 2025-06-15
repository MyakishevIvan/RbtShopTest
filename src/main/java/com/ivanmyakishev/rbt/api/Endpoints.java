package com.ivanmyakishev.rbt.api;

public class Endpoints {
    public static final String ADD_PRODUCT_TO_CART = "/rest/sessions/basket/add?app=EXTERNALWEB";
    public static final String REMOVE_PRODUCT_FROM_CART = "/rest/sessions/basket/add?app=EXTERNALWEB";
    public static final String SEARCH_BY_QUERY = "/rest/search/by/v3";
    private static final String ADD_TO_FAVORITES = "/rest/users/favorite/put?itemId=%d&app=%s";
    private static final String REMOVE_FROM_FAVORITES = "/rest/users/favorite/delete?itemId=%d&app=%s";

    public static String getAddToFavoritesURL(int itemId, String app) {
        return String.format(ADD_TO_FAVORITES, itemId, app);
    }

    public static String getRemoveFromFavoritesURL(int itemId, String app) {
        return String.format(REMOVE_FROM_FAVORITES, itemId, app);
    }
}
