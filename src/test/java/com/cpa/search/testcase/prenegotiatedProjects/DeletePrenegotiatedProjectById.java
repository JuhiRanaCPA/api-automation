package com.cpa.search.testcase.prenegotiatedProjects;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DeletePrenegotiatedProjectById extends BootStrap {
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
    public void deletePrenegotiatedProjectById_Incorrect_Id_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "/api/prenegotiatedprojects"+"/dsdsd"+prenegotiatedProjectId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deletePrenegotiatedProjectById_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/prenegotiatedprojects"+"/dsdsd"+prenegotiatedProjectId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deletePrenegotiatedProjectById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deletePrenegotiatedProjectById_AlreadyDeleted_Id_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 6)
    public void deletePrenegotiatedProjectById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }

}
