package com.ivanmyakishev.rbt.api.responsesModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProductToFavoriteResponseModel {
    private int itemId;
    private String name;
    private String typename;
    private int statusId;
    private int delivery;
    private int pickup;
    private int price;
    private int finalPrice;
}
