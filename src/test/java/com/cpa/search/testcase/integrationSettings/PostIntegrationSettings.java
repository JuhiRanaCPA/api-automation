package com.cpa.search.testcase.integrationSettings;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class PostIntegrationSettings extends BootStrap{
    String apiUrl = baseURI + "/api/integrationsettings";

    @Test(priority = 1)
    public void postIntegrationSettings_Validate_enableCustomerForm_BeforeUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableCustomerForm","false","GET","");
    }
    @Test(priority = 2)
    public void postIntegrationSettings_Validate_enableSendToIntegrify_BeforeUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableSendToIntegrify","false","GET","");
    }
    @Test(priority = 3)
    public void postIntegrationSettings_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"enableCustomerForm\": true,\n" +
                "  \"enableSendToIntegrify\": true\n" +
                "}";
        validateStatusCode( baseURI + "/api/integrationsetting", strBody, 404, "POST");
    }
    @Test(priority = 4)
    public void postIntegrationSettings_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"enableCustomerForm\": true,\n" +
                "  \"enableSendToIntegrify\": true\n" +
                "}";
        validateResponseMessage( baseURI + "/api/integrationsetting",strBody , "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");

    }
    @Test(priority = 5)
    public void postIntegrationSettings_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"enableCustomerForm\": false,\n" +
                "  \"enableSendToIntegrify\": false\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void postIntegrationSettings_Validate_enableCustomerForm_AfterUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableCustomerForm","false","GET","");
    }
    @Test(priority = 7)
    public void postIntegrationSettings_Validate_enableSendToIntegrify_AfterUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"enableSendToIntegrify","false","GET","");
    }
    @Test(priority = 8)
    public void postIntegrationSettings_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"enableCustomerForm\": true,\n" +
                "  \"enableSendToIntegrify\": true\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    }
