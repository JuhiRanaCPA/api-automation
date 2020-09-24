package com.cpa.search.testcase.userProjectShares;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/*** Request Type : POST
 * Add users to UserProjectShares related to IPPU users
 */
public class AddUserSharingRules  extends BootStrap {
    String apiUrl = baseURI + "/api/sharing-rules/shares/add";
    String ippuEmail= "wilmer.yates@nomail.example.com";
    String stmEmail ="perry.coleman@nomail.example.com";
    String stlEmail ="skyler.white@nomail.example.com";
    String staEmail="jesse.pinkman@nomail.example.com";
    String contractorEmail ="joe.millionaire@nomail.example.com";
    String ippuId= "13e6ed8b-4d0e-410f-80b7-8b8e46c7a257";
    String stmId ="4162820c-19e5-4982-ad59-520bb505d629";
    String stlId ="e40d748f-fc7a-4b05-b689-e3f2f6a25481";
    String staId="4452647f-1356-406d-ab02-7ecf12ccb671";
    String contractorId ="88545c0e-5da1-4b37-b9ea-e391ed380e05";

    @Test(priority =1)
    public void addUserSharingRules_500(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }
    @Test(priority =2)
    public void addUserSharingRules_IPPU_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\",\n" +
                "  \"userEmails\": \""+ippuEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =3)
    public void addUserSharingRules_STM_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+stmId+"\",\n" +
                "  \"userEmails\": \""+stmEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =4)
    public void addUserSharingRules_STL_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+stlId+"\",\n" +
                "  \"userEmails\": \""+stlEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =5)
    public void addUserSharingRules_STA_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+staId+"\",\n" +
                "  \"userEmails\": \""+staEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =6)
    public void addUserSharingRules_Contractor_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+contractorId+"\",\n" +
                "  \"userEmails\": \""+contractorEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
//    @Test(priority =2)
//    public void addUserSharingRules_IPPU_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ippuId\": \""+ippuId+"\",\n" +
//                "  \"userEmails\": \""+ippuEmail+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message",null,"POST",strBody);
//    }
//    @Test(priority =3)
//    public void addUserSharingRules_STM_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ippuId\": \""+stmId+"\",\n" +
//                "  \"userEmails\": \""+stmEmail+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message","Owners may only share with users, verify the privileges of: "+stmEmail,"POST",strBody);
//    }
//    @Test(priority =4)
//    public void addUserSharingRules_STL_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ippuId\": \""+stlId+"\",\n" +
//                "  \"userEmails\": \""+stlEmail+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message[0]","Owners may only share with users, verify the privileges of: "+stlEmail,"POST",strBody);
//    }
//    @Test(priority =5)
//    public void addUserSharingRules_STA_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ippuId\": \""+staId+"\",\n" +
//                "  \"userEmails\": \""+staEmail+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message[0]","Owners may only share with users, verify the privileges of: "+staEmail,"POST",strBody);
//    }
//    @Test(priority =6)
//    public void addUserSharingRules_Contractor_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"ippuId\": \""+contractorId+"\",\n" +
//                "  \"userEmails\": \""+contractorEmail+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message[0]","Owners may only share with users, verify the privileges of: "+contractorEmail,"POST",strBody);
//    }
    @Test(priority =7)
    public void addUserSharingRules__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\",\n" +
                "  \"userEmails\": \""+ippuEmail+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteaddedUser(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"/"+ippuId,"DELETE","");
    }
}
