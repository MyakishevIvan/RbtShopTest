package com.ivanmyakishev.rbt.api.responsesModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchProductResultResponseModel {
    private String query;
    private List<SearchProductResultResponseModel.Item> items;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        private long itemId;
        private String name;
    }
}
