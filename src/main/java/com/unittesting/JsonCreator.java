package com.unittesting;

import java.util.List;

import org.json.JSONObject;

public class JsonCreator {

    private JSONObject json;

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public JsonCreator(){
        this.json = new JSONObject();
    }

    public void createJson(String[] data){
        int counter = -1;
        String key = null;
        for (String item: data) {
            counter++;
            if (counter % 2 == 0){
                key = item;
                continue;
            }
            this.json.put(key, item);
        }
    }
}
