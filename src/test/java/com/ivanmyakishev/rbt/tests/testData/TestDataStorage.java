package com.ivanmyakishev.rbt.tests.testData;

import com.github.javafaker.Faker;
import com.ivanmyakishev.rbt.tests.testData.models.ShopDataModel;
import com.ivanmyakishev.rbt.tests.testData.models.UserDataModel;

import java.util.Random;

public class TestDataStorage {

    private final UserDataModel userData;
    private final ShopDataModel shopDataModel;
    private final TestDataLoader testDataLoader;
    private final Faker faker;
    
    public TestDataStorage() {
        testDataLoader = new TestDataLoader();
        this.userData = testDataLoader.loadJsonAsObject("user.json", UserDataModel.class);
        this.shopDataModel = testDataLoader.loadJsonAsObject("shopData.json", ShopDataModel.class);
        faker = new Faker();
    }

    public UserDataModel getUserData() {
        return userData;
    }

    public ShopDataModel getShopDataModel() {
        return shopDataModel;
    }
   

    public String getRussianFakePhoneNumber() {
        return faker.numerify("+7 (999) ###-##-##");
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
