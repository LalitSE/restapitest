package com.automation.test;

import com.automation.base.TestBase;
import com.automation.client.RestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

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
        restClient.getResponse(url);
    }







}
