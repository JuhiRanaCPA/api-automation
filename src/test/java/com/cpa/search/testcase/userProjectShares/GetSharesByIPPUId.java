package com.cpa.search.testcase.userProjectShares;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/*** Request Type : POST
 * Get Users project shares by IPPU id
 */
public class GetSharesByIPPUId extends BootStrap {
    String apiUrl = baseURI + "/api/sharing-rules/shares";
    String ippuId= "13e6ed8b-4d0e-410f-80b7-8b8e46c7a257";
    String stmId ="4162820c-19e5-4982-ad59-520bb505d629";
    String stlId ="e40d748f-fc7a-4b05-b689-e3f2f6a25481";
    String staId="4452647f-1356-406d-ab02-7ecf12ccb671";
    String ippuEmail = "wilmer.yates@nomail.example.com";

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
    public void getSharesByIPPUId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
     @Test(priority =2)
    public void getSharesBySTM_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+stmId+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =3)
    public void getSharesBySTL_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+stlId+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =4)
    public void getSharesBySTA_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \""+staId+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority =5)
    public void getSharesByIPPUId_ValidateUsers(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String expectedResult ="pass";
        String actualResult ="fail";
        String strBody ="{\n" +
                "  \"ippuId\": \""+ippuId+"\"\n" +
                "}";
       List<String> userIdlist = getAllValuesFromResponse(apiUrl,strBody,"users.id","POST");
       if(userIdlist.size()>0){
           actualResult="pass";
       }
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority =6)
    public void getSharesBySTM_ValidateUsers(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String expectedResult ="pass";
        String actualResult ="fail";
        String strBody ="{\n" +
                "  \"ippuId\": \""+stmId+"\"\n" +
                "}";
        List<String> userIdlist = getAllValuesFromResponse(apiUrl,strBody,"users.id","POST");
        if(userIdlist.size()==0){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority =7)
    public void getSharesBySTL_ValidateUsers(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String expectedResult ="pass";
        String actualResult ="fail";
        String strBody ="{\n" +
                "  \"ippuId\": \""+stlId+"\"\n" +
                "}";
        List<String> userIdlist = getAllValuesFromResponse(apiUrl,strBody,"users.id","POST");
        if(userIdlist.size()==0){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority =8)
    public void getSharesBySTA_ValidateUsers(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String expectedResult ="pass";
        String actualResult ="fail";
        String strBody ="{\n" +
                "  \"ippuId\": \""+staId+"\"\n" +
                "}";
        List<String> userIdlist = getAllValuesFromResponse(apiUrl,strBody,"users.id","POST");
        if(userIdlist.size()==0){
            actualResult="pass";
        }
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority =9)
    public void getSharesBySTA_Incorrect_Id_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ippuId\": \"13e6ed8b-4d0e-410f-80b7-8b8e46c7a257sdsds\"\n" +
                "}";
        validateStatusCode(apiUrl,strBody , 400, "POST");
    }
    @Test(priority =10)
    public void getSharesByIPPUId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"ippuId\": \"" + ippuId + "\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteaddedUser(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "/api/sharing-rules/shares/delete/"+ippuId+"/"+ippuId,"DELETE","");
    }
}
