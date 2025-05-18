package com.ivanmyakishev.rbt.pages.web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ivanmyakishev.rbt.enums.MenuCategory;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$;

public class TopNavigationComponent {
    private final ElementsCollection mainMenuButtons = $$(".NavMenu_listItem__PbMwU");
    private HashMap<MenuCategory, SelenideElement> mainMenuButtonMap;
    
    public TopNavigationComponent() {
        createMenuButtonMap(mainMenuButtons);
    }

    private void createMenuButtonMap(ElementsCollection mainMenuButtons) {
        MenuCategory[] enumValues = MenuCategory.values();

        if (mainMenuButtons.size() != enumValues.length) {
            throw new IllegalStateException("Mismatch between buttons and enum values");
        }

        mainMenuButtonMap = IntStream.range(0, enumValues.length)
                .boxed()
                .collect(Collectors.toMap(
                        i -> enumValues[i],
                        i -> mainMenuButtons.get(i),
                        (a, b) -> b,
                        HashMap::new
                ));
    }

    @Step("Click on Top navigation button {category}")
    public ProductsResultPage clickOnNavigationButton(MenuCategory category) {
        SelenideElement categoryButton = mainMenuButtonMap.get(category);
        categoryButton.click();
        return new ProductsResultPage();
    }
}
