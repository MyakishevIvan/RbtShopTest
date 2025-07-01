package com.ivanmyakishev.rbt.testData.models;

import com.ivanmyakishev.rbt.enums.MenuCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShopDataModel {
    private List<String> digitalContent;
    private MenuCategory testingCategory;
    private String validProductName;
    private String invalidProductName;
}
