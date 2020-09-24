package com.cpa.search.testcase.keywords;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostKeywordsSuggest extends BootStrap {
    String apiUrl = baseURI + "api/keywords/suggest";

    @Test
    public void postKeywordsSuggest_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"searchString\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test
    public void postKeywordsSuggest_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult ="fail";
        String strBody = "{\n" +
                "  \"searchString\": \"\"\n" +
                "}";
       List<String> namesList= getAllValuesFromResponse(apiUrl,strBody,"names","POST");
       if(namesList.size()>0){
           actualResult="pass";
       }
        Assert.assertEquals(actualResult, "pass");
    }
    @Test
    public void postKeywordsSuggest_NullRequest_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test
    public void postKeywordsSuggest_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String strBody = "{\n" +
                "  \"searchString\": \"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

}
