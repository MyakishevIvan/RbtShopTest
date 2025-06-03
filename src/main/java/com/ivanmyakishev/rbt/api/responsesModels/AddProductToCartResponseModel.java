package com.ivanmyakishev.rbt.api.responsesModels;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddProductToCartResponseModel {
    private boolean isCompleted;
    private List<Item> items;
    private String basketId;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        private long itemId;
        private int count;
    }
}
