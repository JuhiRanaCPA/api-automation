package com.cpa.search.testcase.groups;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetGroups extends BootStrap{
    String apiUrl = baseURI + "api/groups/";
    String title = this.getClass().getSimpleName() + generateRandom(5);

     @Test(priority = 1)
    public void getGroups_GetValidData_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
     @Test(priority = 3)
    public void getGroups_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");

    }

}
