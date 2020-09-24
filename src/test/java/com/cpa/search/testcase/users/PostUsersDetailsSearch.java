package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersDetailsSearch extends BootStrap{
    String apiUrl = baseURI + "api/users/details/search";
    String strBody1 ="{\n" +
            "  \"filter\": {\n" +
            "    \"firstname\": \"Joella\",\n" +
            "    \"lastname\": \"Bennett\",\n" +
            "    \"email\": \"joella.bennett@nomail.example.com\",\n" +
            "    \"name\": \"Joella Bennett\"\n" +
            "  }\n" +
            "}";
    @Test(priority = 1)
    public void postUsersDetailsSearch_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postUsersDetailsSearch_Validate_resultCount(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult ="pass";
        String strBody ="{\n" +
                "}";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=1){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(priority = 3)
    public void postUsersDetailsSearch_Validate_resultCountEquals1(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl,strBody1,"resultCount","POST");
        if(resultCount==1){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
//    @Test(priority = 4)
//    public void postUsersDetailsSearch_InvalidRequest_400(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ncxzxccxzame\": \"string\"\n" +
//                "}";
//        validateStatusCode( apiUrl, strBody, 400, "POST");
//    }
    @Test(priority = 5)
    public void postUsersDetailsSearch_Validate_Id_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "99e206d1-309d-41f5-a40d-6e7a38cf04c2", "POST", strBody1);
    }
    @Test(priority = 6)
    public void postUsersDetailsSearch_Validate_FirstName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Joella", "POST", strBody1);
    }
    @Test(priority = 7)
    public void postUsersDetailsSearch_Validate_LastName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Bennett", "POST", strBody1);
    }
    @Test(priority = 8)
    public void postUsersDetailsSearch_Validate_Email_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "joella.bennett@nomail.example.com", "POST", strBody1);
    }
    @Test(priority = 9)
    public void postUsersDetailsSearch_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody1, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
