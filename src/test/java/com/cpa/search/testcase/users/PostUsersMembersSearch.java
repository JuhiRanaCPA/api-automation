package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersMembersSearch extends BootStrap{
    String apiUrl = baseURI + "api/members/search";
    String strBody ="{\n" +
            "  \"name\": \"test-search\"\n" +
            "}";

    @Test(priority = 1)
    public void postUsersMembersSearch_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postUsersMembersSearch_Validate_resultCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        String strBody = "{\n" +
                "}";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount >=100) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(priority = 3)
    public void postUsersMembersSearch_Validate_resultCountEquals3() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount == 3) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
//    @Test(priority = 4)
//    public void postUsersMembersSearch_InvalidRequest_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\"testingname\":\"testing data\"}";
//        validateStatusCode(apiUrl, strBody, 400, "POST");
//    }
    @Test(priority = 5)
    public void ostUsersMembersSearch_Id() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "88990a57-e3a3-4a4a-8d11-0905b342f384", "POST", strBody);
    }
    @Test(priority = 6)
    public void ostUsersMembersSearch_FirstName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "test-search", "POST", strBody);
    }
    @Test(priority = 7)
    public void ostUsersMembersSearch_LastName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "admin", "POST", strBody);
    }
    @Test(priority = 8)
    public void ostUsersMembersSearch_Email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "test-search.admin@nomail.example.com", "POST", strBody);
    }
    @Test(priority = 9)
    public void postUsersMembersSearch_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
