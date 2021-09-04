package com.automation.client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {

    //1. Get method
    public void getResponse(String url) throws IOException {
        CloseableHttpClient httpClient =   HttpClients.createDefault(); //Creating http connection
        HttpGet httpGet = new HttpGet(url); //http get request
        CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpGet); //hit the request as similar to Postman Send button
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code: " +statusCode);

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API" +responseJson);

        Header[] headersArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header: headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array: "+allHeaders);
    }






}
