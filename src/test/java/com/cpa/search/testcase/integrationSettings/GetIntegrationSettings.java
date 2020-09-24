package com.cpa.search.testcase.integrationSettings;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetIntegrationSettings extends BootStrap{
    String apiUrl = baseURI + "/api/integrationsettings";

    @Test(priority = 1)
    public void getIntegrationSettings_Validate_enableCustomerForm() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableCustomerForm","false","GET","");
    }
    @Test(priority = 2)
    public void getIntegrationSettings_Validate_enableSendToIntegrify() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableSendToIntegrify","false","GET","");
    }
    @Test(priority = 3)
    public void getIntegrationSettings_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 4)
    public void getIntegrationSettings_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "/api/integrationsetting", "", 404, "GET");
    }
    @Test(priority = 5)
    public void getIntegrationSettings_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/integrationsetting", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");

    }
        @Test(priority = 6)
    public void getIntegrationSettings_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}