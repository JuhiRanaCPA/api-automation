package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GetProjectInfoByProjectId extends BootStrap{

    String descriptionOfInvention ="Desc Of the project 123";
    String knownPriorArt ="US109272";
    String prenegotiatedProjectName ="PNP-Testing Automatio 10000";
    String projectType ="prenegotiatedProject";
    String technicalField ="Chemistry";
    String otherOrderInformationOrComments ="other Info of the project";
    float budget = 200000;
    String currency ="USD";
    String deliveryOption ="standard";
    boolean canAuthorize =true;
    String authorized= null;
    String preNegotiatedProjectId="868933fc-ecb2-49f3-b30b-93534c3d5355";
    String preNegotiatedProjectInternalDescription="I Desc PNP-Testing Automatio 10000";
    int rate =1000;
    int hours =200;
    String contactCode ="C100";
    String projectTitle ="API automation Testing Title";
    String clientName ="CPA Global";
    String companyName = "IPC Dev - Goodman & Co.";
    String customerName= "Jesse Pinkman";
    String customerEmailAddress= "jesse.pinkman@nomail.example.com";
    String customerPhoneNumber= null;
    String contactCodeForeign= "za";
    String organizationUid= "14345168-e82e-4164-b654-e4b0845ea000";
    String projectOwner= "4452647f-1356-406d-ab02-7ecf12ccb671";
    String projectOwnerName= "Jesse Pinkman";
    String targetPatents= null;

    public String getProjectId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody ="{\n" +
                "  \"clientName\": \""+clientName+"\",\n" +
                "  \"prenegotiatedProjectId\": \""+preNegotiatedProjectId+"\",\n" +
                "  \"prenegotiatedProjectName\": \""+prenegotiatedProjectName+"\",\n" +
                "  \"prenegotiatedProjectInternalDescription\": \""+preNegotiatedProjectInternalDescription+"\",\n" +
                "  \"projectType\": \""+projectType+"\",\n" +
                "  \"technicalField\": \""+technicalField+"\",\n" +
                "  \"caseOrMatterNumber\": \"API automation Testing\",\n" +
                "  \"descriptionOfInvention\": \""+descriptionOfInvention+"\",\n" +
                "  \"knownPriorArt\": \"US109272\",\n" +
                "  \"deliveryOption\": \""+deliveryOption+"\",\n" +
                "  \"otherOrderInformationOrComments\": \""+otherOrderInformationOrComments+"\",\n" +
                "  \"rate\": "+rate+",\n" +
                "  \"hours\": "+hours+",\n" +
                "  \"budget\": "+budget+",\n" +
                "  \"currency\": \""+currency+"\",\n" +
                "  \"contactCode\": \""+contactCode+"\",\n" +
                "  \"noDocumentCopyrightFees\": true,\n" +
                "  \"noDocumentServiceFees\": true,\n" +
                "  \"projectTitle\": \""+projectTitle+"\"\n" +
                "}";
        return getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
    }
    String projectId = getProjectId();
    String apiUrl = baseURI + "api/projects/" + projectId+ "/projectinfo";

    @Test(priority = 1)
    public void getProjectInfoByProjectId_requestReceived_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl , "", 200, "GET");
    }
    @Test(priority = 2)
    public void getProjectInfoByProjectId_ProjectTitle_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "projectTitle", projectTitle, "GET", "");
    }
    @Test(priority = 3)
    public void getProjectInfoByProjectId_ClientName_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "clientName", clientName, "GET", "");
    }
    @Test(priority = 4)
    public void getProjectInfoByProjectId_companyName_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "companyName", companyName, "GET", "");
    }
    @Test(priority = 5)
    public void getProjectInfoByProjectId_customerName_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "customerName", customerName, "GET", "");
    }
    @Test(priority = 6)
    public void getProjectInfoByProjectId_customerEmailAddress_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "customerEmailAddress", customerEmailAddress, "GET", "");
    }
    @Test(priority = 7)
    public void getProjectInfoByProjectId_customerPhoneNumber_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "customerEmailAddress", customerEmailAddress, "GET", "");
    }
    @Test(priority = 8)
    public void getProjectInfoByProjectId_contactCodeForeign_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "contactCodeForeign", contactCodeForeign, "GET", "");
    }
    @Test(priority = 9)
    public void getProjectInfoByProjectId_organizationUid_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organizationUid", organizationUid, "GET", "");
    }
    @Test(priority = 10)
    public void getProjectInfoByProjectId_projectOwnerNamedeliveryOption_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "projectOwnerName", projectOwnerName, "GET", "");
    }

    @Test(priority = 11)
    public void getProjectInfoByProjectId_projectOwner_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "projectOwner", projectOwner, "GET", "");
    }
    @Test(priority = 13)
    public void getProjectInfoByProjectId_InvalidProject_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "asas/initialrequest", "", 404, "GET");
    }
    @Test(priority = 14)
    public void getProjectInfoByProjectId_InvalidProject_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl + "sdsd/initialrequest", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 15)
    public void getProjectInfoByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}