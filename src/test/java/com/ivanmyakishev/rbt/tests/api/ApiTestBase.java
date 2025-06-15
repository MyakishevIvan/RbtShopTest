package com.ivanmyakishev.rbt.tests.api;

import com.ivanmyakishev.rbt.api.RbtShopApi;
import com.ivanmyakishev.rbt.tests.testData.TestDataStorage;
import com.ivanmyakishev.rbt.utils.CookieUtils;
import org.junit.jupiter.api.BeforeAll;

//ToDO
//Добавить конфиг, в который будут генерировааться основные данные. 
// Как вариант создать общий базовый конфиг для всех типовк тестов и наследовааться от него
public class ApiTestBase {
    protected final   TestDataStorage testDataStorage = new TestDataStorage();
    protected  final RbtShopApi rbtShopApi = new RbtShopApi();
    
    @BeforeAll
    static void setUp() {
        CookieUtils.fetchCookiesOnce("https://www.rbt.ru/");
    }
}
