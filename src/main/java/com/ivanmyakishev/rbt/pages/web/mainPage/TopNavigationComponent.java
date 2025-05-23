package com.ivanmyakishev.rbt.pages.web.mainPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ivanmyakishev.rbt.enums.MenuCategory;
import com.ivanmyakishev.rbt.pages.web.ProductsResultPage;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$;

public class TopNavigationComponent {
    private final ElementsCollection mainMenuButtons = $$(".NavMenu_listItem__PbMwU");
    private Map<MenuCategory, SelenideElement> mainMenuButtonMap;
    
    public TopNavigationComponent() {
    }
    
    @Step("Click on top navigation button: {category}")
    public ProductsResultPage clickOnNavigationButton(MenuCategory category) {
        SelenideElement categoryButton = getMainMenuButtonMap().get(category);
        categoryButton.click();
        return new ProductsResultPage();
    }
    private Map<MenuCategory, SelenideElement> getMainMenuButtonMap() {
        if (mainMenuButtonMap != null) {
            return mainMenuButtonMap;
        }
        
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

        return mainMenuButtonMap;
    }
}
