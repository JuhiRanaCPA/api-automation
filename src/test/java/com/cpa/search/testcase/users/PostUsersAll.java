package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersAll extends BootStrap{
    String apiUrl = baseURI + "api/users/search";
    String strBody = "{\n" +
            "  \"name\": \"Jesse\",\n" +
            "  \"email\": \"\",\n" +
            "  \"offset\": 0,\n" +
            "  \"limit\": 0\n" +
            "}";
    @Test(priority = 1)
    public void postUsersAll_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postUsersAll_Validate_resultCount(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"email\": \"\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 0\n" +
                "}";
        String actualResult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=8){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(priority = 3)
    public void postUsersAll_Validate_Id_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "POST", strBody);
    }
    @Test(priority = 4)
    public void postUsersAll_Validate_FirstName_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Jesse", "POST", strBody);
    }
    @Test(priority = 5)
    public void postUsersAll_Validate_LastName_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Pinkman", "POST", strBody);
    }
    @Test(priority = 6)
    public void postUsersAll_Validate_Email_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "jesse.pinkman@nomail.example.com", "POST", strBody);
    }
    @Test(priority = 7)
    public void postUsersAll_Validate_BlankBody_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        String actualResult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=8){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(priority = 8)
    public void postUsersAll_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
