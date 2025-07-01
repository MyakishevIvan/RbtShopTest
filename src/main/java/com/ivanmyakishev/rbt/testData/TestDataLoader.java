package com.ivanmyakishev.rbt.testData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivanmyakishev.rbt.enums.TestDataType;

import java.io.InputStream;

public class TestDataLoader {
    private static final ObjectMapper mapper = new ObjectMapper();
    

    public static <T> T loadJsonAsObject(String fileName,TestDataType testDataType, Class<T> targetClass) {
        String path = "testdata/" + getDataFolderName(testDataType) + fileName;
        try (InputStream is = TestDataLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new RuntimeException("Test data file not found: " + fileName);
            }
            return mapper.readValue(is, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Can't read test data file: " + fileName, e);
        }
    }

    private static String getDataFolderName(TestDataType testDataType) {
        String result = switch (testDataType) {
            case UT_TEST_DATA -> "webTestData";
            case API_TEST_DATA -> "apiTestData";
            case MOBILE_TEST_DATA -> "mobileTestData";
            default -> throw new IllegalStateException("Unexpected value: " + testDataType);
        };

        return result + "/";
    }
}
