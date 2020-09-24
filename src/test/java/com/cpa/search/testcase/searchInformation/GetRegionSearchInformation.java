package com.cpa.search.testcase.searchInformation;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetRegionSearchInformation extends BootStrap{
    String apiUrl = baseURI + "api/searchinformation/region";

    @Test
    public void getRegionSearchInformation_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test
    public void getRegionSearchInformation_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl,"","\"NA\"","GET");
    }
    @Test
    public void getRegionSearchInformation__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}
