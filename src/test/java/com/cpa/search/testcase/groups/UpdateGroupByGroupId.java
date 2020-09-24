package com.cpa.search.testcase.groups;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class UpdateGroupByGroupId extends BootStrap{
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
    String apiUrl = baseURI + "api/groups/" + groupId;

    @Test(priority = 1)
    public void updateGroup_Update_Record_With_Valid_GroupId_Validate_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedTitle = "Updated Group Title " + getValueFromResponse(apiUrl,"","title","GET");
        String strBody = "{\n" +
                "  \"title\": \"" + updatedTitle + "\",\n" +
                "  \"users\": []\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"PUT");
        validateKeyValueFromResponse(apiUrl,"title",updatedTitle,"GET", "");
    }

    @Test(priority = 2)
    public void updateGroup_Update_Record_With_Valid_GroupId_Validate_ResponseCode_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedTitle = "Updated Group Title " + groupId;
        String strBody = "{\n" +
                "  \"title\": \"" + updatedTitle + "\",\n" +
                "  \"users\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 3)
    public void updateGroup_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void deleteGroup(){
        setResponse(baseURI + "api/groups/"+groupId,"DELETE","");
    }
}
