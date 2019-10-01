package com.example.unittesting;

public class URLUtils {
    public String makeURL(String schema, String baseURL, String path){
        return String.format("%s://%s/%s", schema, baseURL, path);
    }

    public void displayURL(String url){
        System.out.println(url);
    }
}
