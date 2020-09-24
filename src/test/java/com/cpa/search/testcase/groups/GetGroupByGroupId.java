package com.cpa.search.testcase.groups;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GetGroupByGroupId extends BootStrap{
    String strBody = "{\n" +
            "  \"title\": \"AddGroup for TC\",\n" +
            "  \"users\": [\n" +
            "    {\n" +
            "      \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
            "      \"firstname\": \"Jesse\",\n" +
            "      \"lastname\": \"Pinkman\",\n" +
            "      \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
            "      \"isDirector\": true,\n" +
            "      \"userStatusView\": null\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    String groupId = getValueFromResponse(baseURI + "api/groups", strBody, "id", "POST");
    String apiUrl = baseURI + "api/groups/";

    @Test(priority = 1)
    public void getGroupByGroupId_GetValidData_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + groupId, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getGroupByGroupId_ValidateResponse_MandatoryField_Id() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + groupId, "id", groupId, "GET", "");
    }
    @Test(priority = 4)
    public void getGroupByGroupId_MissingHeaderCase_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newApiUrl = apiUrl + "/group/" + groupId;
        validateStatusCode(newApiUrl, "", 404, "GET");
    }
    @Test(priority = 5)
    public void getGroupByGroupId_MissingHeaderCase_404_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newApiUrl = apiUrl + "/group/" + groupId;
        validateResponseMessage(newApiUrl, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }

    @Test(priority = 6)
    public void getGroupByGroupId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + groupId, "", BENCHMARK_RESPONSE_TIME, "GET");
        setResponse(baseURI + "api/groups/"+groupId,"DELETE","");
    }
}
