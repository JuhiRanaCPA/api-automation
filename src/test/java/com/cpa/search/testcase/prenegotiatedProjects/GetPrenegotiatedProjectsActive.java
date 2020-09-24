package com.cpa.search.testcase.prenegotiatedProjects;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetPrenegotiatedProjectsActive  extends BootStrap {
    String apiUrl = baseURI + "/api/prenegotiatedprojects/active";

    @Test(priority = 1)
    public void getPrenegotiatedProjectsActive_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getPrenegotiatedProjectsActive_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "/api/systems/status", "", 404, "GET");
    }
    @Test(priority = 3)
    public void getPrenegotiatedProjectsActive_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/systems/status", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 4)
    public void getPrenegotiatedProjectsActive_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}