package com.cpa.search.testcase.dossier;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UpdateDossierOfLoggedInUser extends BootStrap{
    String apiUrl = baseURI + "api/dossier";

    @Test(priority = 1)
    public void updateDossierOfLoggedInUser_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"about\": \"Updating about of Jesse Pinkman\",\n" +
                "  \"currentPosition\": \"Quality Analyst\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"city\": \"Sydney\",\n" +
                "  \"country\": \"Australia\",\n" +
                "  \"zipCode\": \"12390\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
    @Test(priority = 2)
    public void updateDossierOfLoggedInUser_Validate_Updated_currentPosition() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "currentPosition", "Quality Analyst", "GET", "");
    }
    @Test(priority = 3)
    public void updateDossierOfLoggedInUser_Validate_Updated_Gender() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "gender", "Female", "GET", "");
    }
    @Test(priority = 4)
    public void updateDossierOfLoggedInUser_Validate_Updated_city() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "city", "Sydney", "GET", "");
    }
    @Test(priority = 5)
    public void updateDossierOfLoggedInUser_Validate_Updated_country() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "country", "Australia", "GET", "");
    }
    @Test(priority = 6)
    public void updateDossierOfLoggedInUser_Validate_Updated_zipCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "zipCode", "12390", "GET", "");
    }
    @Test(priority = 7)
    public void updateDossierOfLoggedInUser_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"about\": \"Updating about of Jesse Pinkman\",\n" +
                "  \"currentPosition\": \"Quality Analyst\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"city\": \"Sydney\",\n" +
                "  \"country\": \"Australia\",\n" +
                "  \"zipCode\": \"12390\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void updateDossierOfLoggedInUser_Update_To_original_Values() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"about\": null,\n" +
                "  \"currentPosition\": null,\n" +
                "  \"gender\": null,\n" +
                "  \"city\": null,\n" +
                "  \"country\": null,\n" +
                "  \"zipCode\": null\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
}
