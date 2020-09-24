package com.cpa.search.testcase.userProjectShares;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

/*** Request Type : POST
 * Get Users project shares by IPPU id
 */
public class GetUserByEmail extends BootStrap {
    String apiUrl = baseURI + "/api/sharing-rules/shares/get";

    String ippuEmail= "wilmer.yates@nomail.example.com";
    String stmEmail ="perry.coleman@nomail.example.com";
    String stlEmail ="skyler.white@nomail.example.com";
    String staEmail="jesse.pinkman@nomail.example.com";
    String contractorEmail ="joe.millionaire@nomail.example.com";

    @Test(priority =1)
    public void getSharesByIPPUEmail_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =2)
    public void getSharesBySTM_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+stmEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =3)
    public void getSharesBySTL_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+stlEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =4)
    public void getSharesBySTA_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+staEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =5)
    public void getSharesByContractor_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+contractorEmail+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority =6)
    public void getSharesByIPPUEmail_Validate_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"message","","POST",strBody);
    }
    @Test(priority =7)
    public void getSharesByIPPUEmail_Validate_UsersEmail(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"users.email[0]",ippuEmail,"POST",strBody);
    }
    @Test(priority =8)
    public void getSharesByIPPUEmail_Validate_FirstName(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"users.firstname[0]","Wilmer","POST",strBody);
    }
    @Test(priority =9)
    public void getSharesByIPPUEmail_Validate_LastName(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"users.lastname[0]","Yates","POST",strBody);
    }
    @Test(priority =10)
    public void getSharesByIPPUEmail_Validate_Is(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"users.id[0]","13e6ed8b-4d0e-410f-80b7-8b8e46c7a257","POST",strBody);
    }
    @Test(priority =11)
    public void getSharesByIPPUEmail_Validate_Enabled(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"users.enabled[0]","true","POST",strBody);
    }
    @Test(priority =12)
    public void getSharesByIPPUEmail__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"emails\": \""+ippuEmail+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
