package com.automation.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class RestClient {

    //1. Get method
    public CloseableHttpResponse getResponse(String url) throws IOException {
        CloseableHttpClient httpClient =   HttpClients.createDefault(); //Creating http connection
        HttpGet httpGet = new HttpGet(url); //http get request
        CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpGet); //hit the request as similar to Postman Send button

        return closeableHttpResponse;


    }






}
