package com.ivanmyakishev.rbt.api.requestsModels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddProductToCartRequestModel {
    public long itemId;
    public int qty;
}
