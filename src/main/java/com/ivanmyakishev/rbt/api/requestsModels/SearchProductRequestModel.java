package com.ivanmyakishev.rbt.api.requestsModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchProductRequestModel {
    private String query;
    private String app;
}
