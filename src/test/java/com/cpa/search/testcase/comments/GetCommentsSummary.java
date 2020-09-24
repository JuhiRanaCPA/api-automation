package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCommentsSummary extends BootStrap {
    String apiUrl = baseURI + "/api/comments/summary";
    int criticalCount,acknowledgedCount,unacknowledgedCount,allCount =0;

    @Test
    public void getCommentsSummary_IncorrectUID_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test
    public void getCommentsSummary_Validate_criticalCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        criticalCount = getIntValueFromResponse(apiUrl, "", "criticalCount", "GET");
        if (criticalCount > 0) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void getCommentsSummary_Validate_acknowledgedCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        acknowledgedCount = getIntValueFromResponse(apiUrl, "", "acknowledgedCount", "GET");
        if (acknowledgedCount > 0) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void getCommentsSummary_Validate_unacknowledgedCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        unacknowledgedCount = getIntValueFromResponse(apiUrl, "", "unacknowledgedCount", "GET");
        if (unacknowledgedCount > 0) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void getCommentsSummary_Validate_allCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        allCount = getIntValueFromResponse(apiUrl, "", "allCount", "GET");
        if (allCount >=criticalCount+acknowledgedCount+unacknowledgedCount) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 8)
    public void getCommentsSummary_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}
