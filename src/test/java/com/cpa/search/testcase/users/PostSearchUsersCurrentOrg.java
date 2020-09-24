package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostSearchUsersCurrentOrg  extends BootStrap{
    String apiUrl = baseURI + "api/members/currentorg/search";
    String strBody ="{\n" +
            "  \"name\": \"Jesse\"\n" +
            "}";

    @Test(priority = 1)
    public void postSearchUsersCurrentOrg_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 2)
    public void postSearchUsersCurrentOrg_Validate_resultCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        String strBody = "{\n" +
                "}";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount >= 1) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 3)
    public void postSearchUsersCurrentOrg_Validate_resultCountEquals1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount == 1) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

//    @Test(priority = 4)
//    public void postSearchUsersCurrentOrg_InvalidRequest_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\"testingname\":\"testing data\"}";
//        validateStatusCode(apiUrl, strBody, 400, "POST");
//    }
    @Test(priority = 5)
    public void postSearchUsersCurrentOrg_Validate_Id_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "POST", strBody);
    }

    @Test(priority = 6)
    public void postSearchUsersCurrentOrg_Validate_FirstName_Jesse_Pinkman() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Jesse", "POST", strBody);
    }

    @Test(priority = 7)
    public void postSearchUsersCurrentOrg_Validate_LastName_Jesse_Pinkman() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Pinkman", "POST", strBody);
    }

    @Test(priority = 8)
    public void postSearchUsersCurrentOrg_Validate_Email_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "jesse.pinkman@nomail.example.com", "POST", strBody);
    }

    @Test(priority = 9)
    public void postSearchUsersCurrentOrg_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
