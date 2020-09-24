package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersByCurrentOrgId extends BootStrap{
    String apiUrl = baseURI + "api/users/currentorg/search";
    String strBody = "{\n" +
            "  \"name\": \"\",\n" +
            "  \"email\": \"\",\n" +
            "  \"offset\": 0,\n" +
            "  \"limit\": 0\n" +
            "}";
    String strBody1 = "{\n" +
            "  \"name\": \"Joella Bennett\",\n" +
            "  \"email\": \"\",\n" +
            "  \"offset\": 0,\n" +
            "  \"limit\": 0\n" +
            "}";
    @Test(priority = 1)
    public void postUsersByCurrentOrgId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postUsersByCurrentOrgId_Validate_resultCount(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
      int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
      if(resultCount==8){
        actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(priority = 3)
    public void postUsersByCurrentOrgId_Validate_Id_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "3212f973-3933-4719-a325-ea6ecc1fd930", "POST", strBody);
    }
    @Test(priority = 4)
    public void postUsersByCurrentOrgId_Validate_FirstName_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Demo", "POST", strBody);
    }
    @Test(priority = 5)
    public void postUsersByCurrentOrgId_Validate_LastName_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Account 1", "POST", strBody);
    }
    @Test(priority = 6)
    public void postUsersByCurrentOrgId_Validate_Email_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "csm-demo@nomail.example.com", "POST", strBody);
    }

    @Test(priority = 7)
    public void postUsersByCurrentOrgId_Validate_resultCountEquals1(){
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
    @Test(priority = 8)
    public void postUsersByCurrentOrgId_Validate_Id_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "99e206d1-309d-41f5-a40d-6e7a38cf04c2", "POST", strBody1);
    }
    @Test(priority = 9)
    public void postUsersByCurrentOrgId_Validate_FirstName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Joella", "POST", strBody1);
    }
    @Test(priority = 10)
    public void postUsersByCurrentOrgId_Validate_LastName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Bennett", "POST", strBody1);
    }
    @Test(priority = 11)
    public void postUsersByCurrentOrgId_Validate_Email_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "joella.bennett@nomail.example.com", "POST", strBody1);
    }
    @Test(priority = 12)
    public void postUsersByCurrentOrgId_Validate_BlankBody_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody1 = "{\n" +
                "}";
        String actualResult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl,strBody1,"resultCount","POST");
        if(resultCount==8){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
  @Test(priority = 13)
    public void postUsersByCurrentOrgId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
