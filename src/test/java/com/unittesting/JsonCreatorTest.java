package com.unittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.junit.Test;

public class JsonCreatorTest {

    private JSONObject readJSON(String filename) {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (Exception e){
            return null;
        }
        return new JSONObject(resultStringBuilder.toString());
    }

    @Test
    public void shouldEmptyJson() {
        // Given
        JsonCreator json = new JsonCreator();
        String[] data = new String[]{};

        // When
        json.createJson(data);
        JSONObject actual = json.getJson();

        // Then
        JSONObject expected = this.readJSON("empty.json");
        assertTrue(expected.similar(actual));
    }

    @Test
    public void shouldHaveThreeElementsInJson() {
        // Given
        JsonCreator json = new JsonCreator();
        String[] data = new String[]{"element1", "value1", "element2", "value2", "element3", "value3"};

        // When
        json.createJson(data);
        JSONObject actual = json.getJson();

        // Then
        JSONObject expected = this.readJSON("three_elements.json");
        assertTrue(expected.similar(actual));
    }
    
    @Test
    public void shouldFail() {
        // Given
        JsonCreator json = new JsonCreator();
        String[] data = new String[]{"element1"};

        // When
        json.createJson(data);
        JSONObject actual = json.getJson();

        // Then
        JSONObject expected = new JSONObject("{}");
        assertTrue(actual.similar(expected));
    }
    
}
