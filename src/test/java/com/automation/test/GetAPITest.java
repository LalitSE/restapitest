package com.automation.test;

import com.automation.base.TestBase;
import com.automation.client.RestClient;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class GetAPITest extends TestBase {
    String url;


    @BeforeMethod
    public void setUp() throws IOException {
        TestBase testBase = new TestBase();
        String serviceUrl = prop.getProperty("URL");
        String apiUrl = prop.getProperty("ServiceURL");
        url = serviceUrl + apiUrl;

    }

    @Test
    public void getTest() throws IOException {
        RestClient restClient = new RestClient();
        CloseableHttpResponse closeableHttpResponse = restClient.getResponse(url);

        // a. Status code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code: " +statusCode);
        Assert.assertEquals(statusCode, 200, "Status code isn't 200");

        // b. JSON String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response JSON from API" +responseJson);

        // c. All headers
        Header[] headersArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header: headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array: "+allHeaders);
    }







}
