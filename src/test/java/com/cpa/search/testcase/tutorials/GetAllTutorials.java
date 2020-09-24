package com.cpa.search.testcase.tutorials;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetAllTutorials  extends BootStrap{
    String apiUrl = baseURI + "/api/tutorials";
    @Test
    public void getAllTutorials_IncorrectUID_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test
    public void getAllTutorials_IncorrectUID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "/api/tutorial", "", 404, "GET");
    }
    @Test
    public void getAllTutorials_IncorrectUID_404_ReponseMessage(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/tutorial", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test
    public void getAllTutorials_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[1]","automation Tutorials","GET","");
    }
    @Test
    public void getAllTutorials_complete_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"complete[1]","false","GET","");
    }
    @Test(priority = 8)
    public void getAllTutorials_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}
