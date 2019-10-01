package com.example.unittesting;

public class StringUtils {
    URLUtils urlUtils;

    public  StringUtils(){

    }

    public StringUtils(URLUtils urlUtils) {
        this.urlUtils = urlUtils;
    }

    public String concatTwoStrings(String s1, String s2){
        return String.format("%s %s", s1, s2);
    }

    public boolean isStringProperLength(String s1){
        return s1.length() > 4;
    }

    public String getQueryUrl(String queryParam, String schema, String baseURL, String path){
        return String.format("%s/?%s", urlUtils.makeURL(schema, baseURL, path),
                queryParam);
    }

    public void printURLToConsole(String url, int timesToRun) {
        for(int i = 0; i < timesToRun ; i++){
            urlUtils.displayURL(url);
        }
    }
}
