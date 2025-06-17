package com.ivanmyakishev.rbt.api;

import com.ivanmyakishev.rbt.utils.CookieUtils;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class RbtShopSpec {
    
    public final static ResponseSpecification response200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public final static ResponseSpecification response400Spec  = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(ALL)
            .build();

    public final static RequestSpecification requestSpec = with()
            .header("Cookie", CookieUtils.getCookieText())
            .header("Host", "www.rbt.ru")
            .header("Origin", RestAssured.baseURI)
            .header("Referer", RestAssured.baseURI)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36")
            .header("Accept-Language", "ru")
            .header("Connection", "keep-alive")
            .header("Content-Type", "application/json")
            .header("Accept", "application/json, text/plain, */*")
            .header("Accept-Encoding", "gzip, deflate, br, zstd")
            .header("X-Requested-With", "XMLHttpRequest")
            .log().all();
}
