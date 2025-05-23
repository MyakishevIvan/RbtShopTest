package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsResultPage {
    private final ElementsCollection categoryContentElements = $$(".CategoryCard_card__HV2to");
    private final ElementsCollection searchResultElements = $$(".ProductInfo_wrapper__1Mg2D");
    private final SelenideElement searchingResultCountElement = $(".Title_count__Kwhrp");


    @Step("Check category content information")
    public void checkCategoryContent(List<String> checkingContent) {
        categoryContentElements.shouldHave(CollectionCondition.sizeGreaterThan(0));
        List<String> contentElementsText = categoryContentElements.texts();
        Collections.sort(contentElementsText);
        Collections.sort(checkingContent);
        boolean matches = checkingContent.equals(contentElementsText);
        Assertions.assertTrue(matches);
    }

    @Step("Check product search result")
    public void checkProductSearchResult(String value) {
        searchResultElements.shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(40));
        for (SelenideElement searchResultTextElement : searchResultElements) {
            searchResultTextElement.shouldHave(text(value));
        }
    }

    @Step("click on {index} search result element")
    public ProductPage clickOnSearchResultElement(int index) {
        searchResultElements.shouldHave(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(40));
        searchResultElements.get(index).click();
        return new ProductPage();
    }

    @Step("Check count of search results: expected = {expectedCount}")
    public void checkCountOfSearchingElement(int expectedCount) {
        String textCount = searchingResultCountElement.getText();
        int actualCount = Integer.parseInt(textCount);
        Assertions.assertEquals(actualCount, expectedCount, "Search result count does not match expected value");
    }
}
