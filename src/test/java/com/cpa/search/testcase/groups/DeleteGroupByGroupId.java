package com.cpa.search.testcase.groups;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import com.cpa.search.base.Delete_Utilities;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteGroupByGroupId extends BootStrap{
    String apiUrl = baseURI + "api/groups/";
    List<String> groupIds= new ArrayList<>();
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
    @Test(priority = 1)
    public void deleteGroupByGroupId_InvalidCase_MessageCode_DeleteCase() {
        String apiUrlWithKeyValue = apiUrl + "q12";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrlWithKeyValue, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteGroupByGroupId_InvalidCase_404_ResponseMessage_DeleteCase() {
        String apiUrlWithKeyValue = apiUrl + "q12";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrlWithKeyValue, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteGroupByGroupId_DeleteValidGroup_Validate_ResponseCode() {
        String groupId =  getValueFromResponse(baseURI + "api/groups", strBody, "id", "POST");
        String apiUrlWithKeyValue = apiUrl + groupId;
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrlWithKeyValue, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteGroupByGroupId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String groupId =  getValueFromResponse(baseURI + "api/groups", strBody, "id", "POST");
        String apiUrlWithKeyValue = apiUrl + groupId;
//        for(int i=0;i<3;i++){
//            String groupId =  getValueFromResponse(baseURI + "api/groups", strBody, "id", "POST");
//            groupIds.add(i, groupId);
//        }
    validateResponseTime(this.getClass().getSimpleName(), apiUrlWithKeyValue, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }

}
