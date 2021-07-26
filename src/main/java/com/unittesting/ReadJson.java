package com.unittesting;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class ReadJson {
    private String fileName;
    private Object fileObject;

    public Object getFileObject() {
        return fileObject;
    }

    public void setFileObject(Object fileObject) {
        this.fileObject = fileObject;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String name) {
        this.fileName = name;
    }

    public void readFile() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(getFileName());
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        setFileObject(new JSONObject(resultStringBuilder.toString()));
    }

    public JSONObject parse(String jsonString) {
        JSONObject json;

        try {
            json = new JSONObject(jsonString);
        } catch (Exception e) {
            json = null;
        }

        return json;
    }

    public static void main(String[] args) {
        ReadJson fichero = new ReadJson();
        fichero.setFileName("data.json");
        System.out.println(fichero.getFileName());
    }
}
