package com.unittesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ReadJsonTest 
{
    private ReadJson app;

    @Before
    public void setup() {
        this.app = new ReadJson();
    }

    @Test
    public void shouldReadFailed(){
        // Given
        boolean found = false;
        app.setFileName("unexistent.json");

        // When
        try {
            app.readFile();
        } catch (Exception e) {
            found = true;
        }

        // Then
        assertTrue("File unexistent.json not found!",found);
    }

    @Test
    public void shouldReadEmpty(){
        // Given
        app.setFileName("empty_data.json");

        // When
        try {
            app.readFile();
        } catch (Exception e) {
            throw new AssertionError("Exception parsing file!!");
        }

        // Then
        JSONObject json = (JSONObject) app.getFileObject();
        assertNotEquals(app.getFileObject(), null);
        JSONArray elements = (JSONArray) json.get("elements");
        assertEquals(elements.length(), 0);
        Integer count = (Integer) json.get("count");
        assertEquals(count.intValue(), 0);
    }

    @Test
    public void shouldParseEmptyJsonOk() {
        ReadJson read = new ReadJson();
        String jsonString = "{}";
        assertTrue(new JSONObject().similar(read.parse(jsonString)));
    }

    @Test
    public void shouldParseOnpeElementJsonOk() {
        ReadJson read = new ReadJson();
        String jsonString = "{\"element1\":\"prueba\"}";
        assertTrue(new JSONObject().put("element1", "prueba").similar(read.parse(jsonString)));
    }
}
