package com.ivanmyakishev.rbt.testData.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AppDataModel {
    private String version;
    private String city;
    private String productName;
    private int productMinExpectedCount;
    private List<String> categories;
}
