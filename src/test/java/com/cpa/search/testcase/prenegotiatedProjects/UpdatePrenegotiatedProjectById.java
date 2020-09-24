package com.cpa.search.testcase.prenegotiatedProjects;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdatePrenegotiatedProjectById  extends BootStrap {
    String apiUrl = baseURI + "/api/prenegotiatedprojects";
    String prenegotiatedProjectId = "";

    @BeforeTest
    public void addPreNegotiatedProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"New preNegotiated Project Name\",\n" +
                "  \"rate\": 200,\n" +
                "  \"hours\": 100,\n" +
                "  \"budget\": 1000,\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"contactCode\": \"C103\",\n" +
                "  \"bwfProjectId\": \"\",\n" +
                "  \"noDocumentCopyrightFees\": false,\n" +
                "  \"noDocumentServiceFees\": false,\n" +
                "  \"active\": true,\n" +
                "  \"deliveryOption\": \"standard\",\n" +
                "  \"ownedBy\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "  \"organizationViews\": [\n" +
                "    {\n" +
                "      \"id\": \"3ded83a2-78b3-442b-afda-43b0a2c67544\",\n" +
                "      \"name\": \"CPA Global\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"14345168-e82e-4164-b654-e4b0845ea000\",\n" +
                "      \"name\": \"IPC Dev - Goodman & Co.\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"internalDescription\": \"New preNegotiated Project Description\",\n" +
                "  \"originatingOrderTrackCompanyCode\": \"\"\n" +
                "}";
        setResponse(apiUrl,"POST",strBody);
        String strBody1 = "{\n" +
                "  \"filter\": {\n" +
                "    \"organizationName\": \"CPA Global\",\n" +
                "    \"description\": \"New preNegotiated Project Name\"\n" +
                "  }\n" +
                "}";
        prenegotiatedProjectId = getValueFromResponse(apiUrl + "/search", strBody1, "result.id[0]", "POST");
        apiUrl=apiUrl+"/"+prenegotiatedProjectId;
    }

    @Test(priority = 1)
    public void updatePrenegotiatedProjectById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"Updated Value of New preNegotiated Project Name\",\n" +
                "  \"rate\": 900,\n" +
                "  \"hours\": 800,\n" +
                "  \"budget\": 1200,\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"contactCode\": \"UBRC103\",\n" +
                "  \"bwfProjectId\": \"\",\n" +
                "  \"noDocumentCopyrightFees\": false,\n" +
                "  \"noDocumentServiceFees\": false,\n" +
                "  \"active\": true,\n" +
                "  \"deliveryOption\": \"standard\",\n" +
                "  \"ownedBy\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "  \"organizationViews\": [\n" +
                "    {\n" +
                "      \"id\": \"14345168-e82e-4164-b654-e4b0845ea000\",\n" +
                "      \"name\": \"IPC Dev - Goodman & Co.\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"internalDescription\": \"New preNegotiated Project Description\",\n" +
                "  \"originatingOrderTrackCompanyCode\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
    @Test(priority = 2)
    public void updatePrenegotiatedProjectById_Incorrect_Id_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+"/dsdsd"+prenegotiatedProjectId, "", 404, "GET");
    }
    @Test(priority = 3)
    public void updatePrenegotiatedProjectById_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( apiUrl+"/dsdsd"+prenegotiatedProjectId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }

    @Test(priority = 4)
    public void updatePrenegotiatedProjectById_Validate_Description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description", "Updated Value of New preNegotiated Project Name", "GET", "");
    }

    @Test(priority = 5)
    public void updatePrenegotiatedProjectById_Validate_rate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "rate", "900.0", "GET", "");
    }

    @Test(priority = 6)
    public void updatePrenegotiatedProjectById_Validate_hours() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "hours", "800", "GET", "");
    }

    @Test(priority = 7)
    public void updatePrenegotiatedProjectById_Validate_budget() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "budget", "1200.0", "GET", "");
    }

    @Test(priority = 8)
    public void updatePrenegotiatedProjectById_Validate_currency() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "currency", "EUR", "GET", "");
    }

    @Test(priority = 9)
    public void updatePrenegotiatedProjectById_Validate_contactCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "contactCode", "UBRC103", "GET", "");
    }

    @Test(priority = 10)
    public void updatePrenegotiatedProjectById_Validate_organizationViewsName1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organizationViews.name[0]", "IPC Dev - Goodman & Co.", "GET", "");
    }

    @Test(priority = 11)
    public void updatePrenegotiatedProjectById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"Updated Value of New preNegotiated Project Name\",\n" +
                "  \"rate\": 200,\n" +
                "  \"hours\": 100,\n" +
                "  \"budget\": 1000,\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"contactCode\": \"UBRC103\",\n" +
                "  \"bwfProjectId\": \"\",\n" +
                "  \"noDocumentCopyrightFees\": false,\n" +
                "  \"noDocumentServiceFees\": false,\n" +
                "  \"active\": true,\n" +
                "  \"deliveryOption\": \"standard\",\n" +
                "  \"ownedBy\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "  \"organizationViews\": [\n" +
                "    {\n" +
                "      \"id\": \"14345168-e82e-4164-b654-e4b0845ea000\",\n" +
                "      \"name\": \"IPC Dev - Goodman & Co.\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"internalDescription\": \"New preNegotiated Project Description\",\n" +
                "  \"originatingOrderTrackCompanyCode\": \"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }

    @AfterTest
    public void DeletePrenegotiatedProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody1 = "{\n" +
                "  \"filter\": {\n" +
                "    \"description\": \"New preNegotiated Project Name\"\n" +
                "  }\n" +
                "}";
        List<String> projectNameList = getAllValuesFromResponse(baseURI + "/api/prenegotiatedprojects/search",strBody1, "result.id", "POST");
        for (int i = projectNameList.size() - 1; i >= 0; i--) {
            setResponse(baseURI + "/api/prenegotiatedprojects/" + projectNameList.get(i), "DELETE", "");
        }

    }

}