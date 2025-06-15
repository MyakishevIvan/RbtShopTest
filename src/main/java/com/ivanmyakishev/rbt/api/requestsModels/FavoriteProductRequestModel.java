package com.ivanmyakishev.rbt.api.requestsModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteProductRequestModel {
    private int itemId;
    private String appName;
}
