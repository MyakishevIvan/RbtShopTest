package com.ivanmyakishev.rbt.api.requestsModels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddProductToCartRequestModel {
    private long itemId;
    private int qty;
}
