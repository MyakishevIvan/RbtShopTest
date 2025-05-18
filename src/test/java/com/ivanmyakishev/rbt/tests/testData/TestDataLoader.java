package com.ivanmyakishev.rbt.tests.testData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestDataLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode loadJson(String fileName) {
        try (InputStream is = TestDataLoader.class.getClassLoader().getResourceAsStream("testdata/" + fileName)) {
            return mapper.readTree(is);
        } catch (Exception e) {
            throw new RuntimeException("Can't read test data file: " + fileName, e);
        }
    }

    public static <T> T loadJsonAsObject(String fileName, Class<T> targetClass) {
        try (InputStream is = TestDataLoader.class.getClassLoader().getResourceAsStream("testdata/" + fileName)) {
            if (is == null) {
                throw new RuntimeException("Test data file not found: " + fileName);
            }
            return mapper.readValue(is, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Can't read test data file: " + fileName, e);
        }
    }
}
