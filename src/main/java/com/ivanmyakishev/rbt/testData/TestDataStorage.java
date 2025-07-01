package com.ivanmyakishev.rbt.testData;

import com.github.javafaker.Faker;
import com.ivanmyakishev.rbt.api.requestsModels.AddProductToCartRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.FavoriteProductRequestModel;
import com.ivanmyakishev.rbt.api.requestsModels.SearchProductRequestModel;
import com.ivanmyakishev.rbt.enums.TestDataType;
import com.ivanmyakishev.rbt.testData.models.AppDataModel;
import com.ivanmyakishev.rbt.testData.models.ShopDataModel;
import com.ivanmyakishev.rbt.testData.models.UserDataModel;

import java.util.Random;

public class TestDataStorage {

    private final UserDataModel userDataModel;
    private final ShopDataModel shopDataModel;
    private final AppDataModel appDataModel;
    private final TestDataLoader testDataLoader;
    private final AddProductToCartRequestModel addProductToCartRequestModel;
    private final SearchProductRequestModel searchProductRequestModel;
    private final FavoriteProductRequestModel addProductToFavoriteRequestModel;
    private final Faker faker;


    public TestDataStorage() {
        testDataLoader = new TestDataLoader();
        this.userDataModel = testDataLoader.loadJsonAsObject("userData.json", TestDataType.UT_TEST_DATA, UserDataModel.class);
        this.shopDataModel = testDataLoader.loadJsonAsObject("shopData.json",TestDataType.UT_TEST_DATA, ShopDataModel.class);
        this.appDataModel = testDataLoader.loadJsonAsObject("appData.json",TestDataType.MOBILE_TEST_DATA, AppDataModel.class);
        this.addProductToCartRequestModel = testDataLoader.loadJsonAsObject("addProductToCartData.json",TestDataType.API_TEST_DATA, AddProductToCartRequestModel.class);
        this.searchProductRequestModel = testDataLoader.loadJsonAsObject("searchValues.json",TestDataType.API_TEST_DATA, SearchProductRequestModel.class);
        this.addProductToFavoriteRequestModel = testDataLoader.loadJsonAsObject("addProductToFavoriteData.json",TestDataType.API_TEST_DATA, FavoriteProductRequestModel.class);
        faker = new Faker();
    }

    public UserDataModel getUserDataModel() {
        return userDataModel;
    }

    public ShopDataModel getShopDataModel() {
        return shopDataModel;
    }
    public AppDataModel getAppDataModel() {
        return appDataModel;
    }
    public AddProductToCartRequestModel getAddProductToCartRequestModel() {return addProductToCartRequestModel;}
    public SearchProductRequestModel getSearchProductRequestModel() {return searchProductRequestModel;}
    public FavoriteProductRequestModel getFavoriteProductRequestModel() {return addProductToFavoriteRequestModel;}
   

    public String getRussianFakePhoneNumber() {
        return faker.numerify("+7 (999) ###-##-##");
    }

    public int getIncorrectProductId() {
       return Integer.parseInt(faker.numerify("00###"));
    }

    public String getRandomLine(int length) {
        String pattern = "?".repeat(length);
        return faker.letterify(pattern);
    }
    
    public FavoriteProductRequestModel getIncorrectDataForAddingToFavorite() {
        return new FavoriteProductRequestModel(getIncorrectProductId(), getRandomLine(4));
    }

    public AddProductToCartRequestModel getIncorrectDataForAddingToCart() {
        
        return new AddProductToCartRequestModel(getIncorrectProductId(), getAddProductToCartRequestModel().getQty());
    }
    
    public String generateInvalidRussianPhoneNumber() {
        Random random = new Random();

        StringBuilder phoneNumber = new StringBuilder("+7");

        int secondDigit;
        do {
            secondDigit = random.nextInt(10);
        } while (secondDigit == 9);

        phoneNumber.append(secondDigit);
        
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

}
