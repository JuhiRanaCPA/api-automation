package com.cpa.search.testcase.system;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetSystemStatus  extends BootStrap{
    String apiUrl = baseURI + "/api/system/status";

    @Test(priority = 1)
    public void getSystemStatus_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getSystemStatus_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "/api/systems/status", "", 404, "GET");
    }
    @Test(priority = 3)
    public void getSystemStatus_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/systems/status", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 4)
    public void getSystemStatus_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}
