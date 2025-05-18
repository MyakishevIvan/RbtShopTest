package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsResultPage {
    private final ElementsCollection categoryContentElements = $$(".FirstCategoryPage_subCatWrap__URXoN");
    private final ElementsCollection searchResultTextElements = $$(".CategoriesItem_text__t2d1Z");

    
    @Step("Check category content")
    public void checkCategoryContent(List<String> checkingContent) {
        List<String> contentElementsText = categoryContentElements.texts();
        Collections.sort(contentElementsText);
        Collections.sort(checkingContent);
        boolean matches = checkingContent.equals(contentElementsText);
        Assertions.assertTrue(matches);
    }

    @Step("Check product search result")
    public void checkProductSearchResult(String value) {
        for (SelenideElement searchResultTextElement : searchResultTextElements) {
            searchResultTextElement.shouldHave(text(value));
        }
    }
}
