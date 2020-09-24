package com.cpa.search.testcase.clients;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class PostClientsSearch extends BootStrap {
    String apiUrl = baseURI + "api/clients/search";
    String strBody ="{\n" +
            "  \"name\": \"CPA Global\",\n" +
            "  \"limit\": 10\n" +
            "}";
    @Test
    public void postClientSearch_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test
    public void postClientSearch_Blank_Request_500(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody1 ="{\n" +
                "}";
        validateStatusCode(apiUrl, strBody1, 500, "POST");
    }
    @Test
    public void postClientSearch_ValidateId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "clients.id[0]", "cd4e2c9f-9010-45a9-bd64-820e86f44c25", "POST", strBody);
    }
    @Test
    public void postClientSearch_ValidateName(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "clients.name[0]", "CPA Global", "POST", strBody);
    }
    @Test
    public void postClientSearch_ResponseTime(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
