package com.cpa.search.testcase.prenegotiatedProjects;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class POSTPrenegotiatedProjectsSearch extends BootStrap{
    String apiUrl = baseURI + "/api/prenegotiatedprojects/search";

    @Test(priority = 1)
    public void pOSTPrenegotiatedProjectsSearch_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"filter\": {\n" +
                "    \"organizationName\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void pOSTPrenegotiatedProjectsSearch_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"filter\": {\n" +
                "    \"organizationName\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode( baseURI + "/api/systems/status", strBody, 404, "POST");
    }
    @Test(priority = 3)
    public void pOSTPrenegotiatedProjectsSearch_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"filter\": {\n" +
                "    \"organizationName\": \"\"\n" +
                "  }\n" +
                "}";
        validateResponseMessage( baseURI + "/api/systems/status", strBody, "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }
    @Test(priority = 4)
    public void pOSTPrenegotiatedProjectsSearch_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"filter\": {\n" +
                "    \"organizationName\": \"\"\n" +
                "  }\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}