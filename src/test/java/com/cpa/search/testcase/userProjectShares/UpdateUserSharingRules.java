package com.cpa.search.testcase.userProjectShares;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateUserSharingRules extends BootStrap {
    String apiUrl = baseURI + "/api/sharing-rules/shares/update";

    String ippuEmail = "wilmer.yates@nomail.example.com";
    String ippuId = "13e6ed8b-4d0e-410f-80b7-8b8e46c7a257";

@BeforeTest
public void addUserInSharingRules(){
    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    String strBody ="{\n" +
            "  \"ippuId\": \""+ippuId+"\",\n" +
            "  \"userEmails\": \""+ippuEmail+"\"\n" +
            "}";
    setResponse(baseURI + "/api/sharing-rules/shares/add","POST",strBody);
}

    @Test(priority =1)
    public void updateUserSharingRules_InValidUserId_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"iPPUId\": \""+ippuId+"\",\n" +
                "  \"userId\": \""+ippuId+"aasas\",\n" +
                "  \"enabled\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "PUT");
    }
    @Test(priority =2)
    public void updateUserSharingRules_InValidIppiuId_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"iPPUId\": \""+ippuId+"sdsds\",\n" +
                "  \"userId\": \""+ippuId+"\",\n" +
                "  \"enabled\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "PUT");
    }
    @Test(priority =3)
    public void updateUserSharingRules_BlankRequest_500(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "PUT");
    }
    @Test(priority =4)
    public void updateUserSharingRules_IPPU_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"iPPUId\": \""+ippuId+"\",\n" +
                "  \"userId\": \""+ippuId+"\",\n" +
                "  \"enabled\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
    @Test(priority =4)
    public void updateUserSharingRules_Validate_EnabledValue_False(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\"\n" +
                "}";
        validateKeyValueFromResponse(baseURI + "/api/sharing-rules/shares","users.enabled[0]","false","POST",strBody);
    }
    @Test(priority =4)
    public void updateUserSharingRules_Validate_EnabledValue_true(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"iPPUId\": \""+ippuId+"\",\n" +
                "  \"userId\": \""+ippuId+"\",\n" +
                "  \"enabled\": true\n" +
                "}";
        setResponse(apiUrl,"PUT",strBody);
         strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\"\n" +
                "}";
        validateKeyValueFromResponse(baseURI + "/api/sharing-rules/shares","users.enabled[0]","true","POST",strBody);
    }
    @Test(priority =7)
    public void updateUserSharingRules__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"iPPUId\": \""+ippuId+"\",\n" +
                "  \"userId\": \""+ippuId+"\",\n" +
                "  \"enabled\": true\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteAddedUser(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"/"+ippuId,"DELETE","");
    }

}




