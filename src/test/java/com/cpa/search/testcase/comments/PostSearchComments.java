package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostSearchComments extends BootStrap{
    String apiUrl = baseURI + "/api/comments/search";

    @Test
    public void postSearchComments_IncorrectUID_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"4452647f-1356-406d-ab02-7ecf12ccb671aasa\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    @Test
    public void postSearchComments_SearchForSTM_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"4452647f-1356-406d-ab02-7ecf12ccb671\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test
    public void postSearchComments_IPPU_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"13e6ed8b-4d0e-410f-80b7-8b8e46c7a257\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test
    public void postSearchComments_SearchForSTM_ValidateResultCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"4452647f-1356-406d-ab02-7ecf12ccb671\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount > 0) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void postSearchComments_IPPU_ValidateResultCount() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualResult = "fail";
        String expectedResult = "pass";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"13e6ed8b-4d0e-410f-80b7-8b8e46c7a257\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl, strBody, "resultCount", "POST");
        if (resultCount > 0) {
            actualResult = "pass";
        }
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test()
    public void postSearchComments__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"user\": \"13e6ed8b-4d0e-410f-80b7-8b8e46c7a257\"\n" +
                "  },\n" +
                "  \"orderBy\": \"timestamp\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0,\n" +
                "  \"limit\": 10\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "POST");
    }
}
