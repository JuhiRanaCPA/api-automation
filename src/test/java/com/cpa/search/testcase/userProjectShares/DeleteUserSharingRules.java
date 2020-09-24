package com.cpa.search.testcase.userProjectShares;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteUserSharingRules  extends BootStrap {
    String ippuEmail = "wilmer.yates@nomail.example.com";
    String ippuId = "13e6ed8b-4d0e-410f-80b7-8b8e46c7a257";
    String apiUrl = baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"/"+ippuId;

    @BeforeTest
    public void addUserInSharingRules(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\",\n" +
                "  \"userEmails\": \""+ippuEmail+"\"\n" +
                "}";
        setResponse(baseURI + "/api/sharing-rules/shares/add","POST",strBody);    }

    @Test(priority = 1)
    public void deleteUserSharingRules_Incorrect_Id_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"asas/"+ippuId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteUserSharingRules_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"XXx/"+ippuId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteUserSharingRules_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteUserSharingRules_AlreadyDeleted_Id_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 500, "DELETE");
    }
    @Test(priority = 5)
    public void deleteUserSharingRules_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
}
