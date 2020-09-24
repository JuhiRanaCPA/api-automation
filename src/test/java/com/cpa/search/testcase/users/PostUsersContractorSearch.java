package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostUsersContractorSearch extends BootStrap{
    String apiUrl = baseURI + "api/contractors/search";
    String strBody ="{\n" +
            "  \"name\": \"Joe\"\n" +
            "}";

    @Test(priority = 1)
    public void postUsersContractorSearch_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 2)
    public void postUsersContractorSearch_Validate_resultCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        String strBody = "{\n" +
                "}";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount ==3) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 3)
    public void postUsersContractorSearch_Validate_resultCountEquals1() {
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
//    public void postUsersContractorSearch_InvalidRequest_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\"testingname\":\"testing data\"}";
//        validateStatusCode(apiUrl, strBody, 400, "POST");
//    }

    @Test(priority = 5)
    public void postUsersContractorSearch_Validate_Id_Joella_Millionaire() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.id[0]", "88545c0e-5da1-4b37-b9ea-e391ed380e05", "POST", strBody);
    }

    @Test(priority = 6)
    public void postUsersContractorSearch_Validate_FirstName_Joe_Millionaire() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.firstname[0]", "Joe", "POST", strBody);
    }

    @Test(priority = 7)
    public void postUsersContractorSearch_Validate_LastName_Joe_Millionaire() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.lastname[0]", "Millionaire", "POST", strBody);
    }

    @Test(priority = 8)
    public void postUsersContractorSearch_Validate_Email_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "result.email[0]", "joe.millionaire@nomail.example.com", "POST", strBody);
    }

    @Test(priority = 9)
    public void postUsersContractorSearch_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}