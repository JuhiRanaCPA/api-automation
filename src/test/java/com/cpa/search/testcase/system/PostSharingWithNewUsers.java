package com.cpa.search.testcase.system;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class PostSharingWithNewUsers  extends BootStrap{
    String apiUrl = baseURI + "/api/system/sharingwithnewusers";

    @Test(priority = 1)
    public void postSharingWithNewUsers_204() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 204, "POST");
    }
    @Test(priority = 2)
    public void postSharingWithNewUsers_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "/api/systems/sharingwithnewusers", "", 404, "POST");
    }
    @Test(priority = 3)
    public void postSharingWithNewUsers_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/systems/sharingwithnewusers", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }
    @Test(priority = 4)
    public void postSharingWithNewUsers_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "POST");
    }
}

