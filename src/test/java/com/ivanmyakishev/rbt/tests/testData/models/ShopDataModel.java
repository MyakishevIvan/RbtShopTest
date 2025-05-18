package com.ivanmyakishev.rbt.tests.testData.models;

import com.ivanmyakishev.rbt.enums.MenuCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShopDataModel {
    private List<String> digitalContent;
    private MenuCategory testingCategory;
    private String productSearchValue;
}
