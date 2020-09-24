package com.cpa.search.testcase.system;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class PostSystemPing  extends BootStrap{
    String apiUrl = baseURI + "/api/system/ping";

    @Test(priority = 1)
    public void postSystemPing_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "POST");
    }
    @Test(priority = 2)
    public void postSystemPing_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "/api/systems/ping", "", 404, "POST");
    }
    @Test(priority = 3)
    public void postSystemPing_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/systems/ping", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }
    @Test(priority = 4)
    public void postSystemPing_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "POST");
    }
}
