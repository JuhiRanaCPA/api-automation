package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GetInitialRequestByProjectId extends BootStrap{

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

    public String getProjectId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody ="{\n" +
                "  \"clientName\": \"CPA\",\n" +
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
                "  \"projectTitle\": \"API automation Testing Title\"\n" +
                "}";
        return getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
    }
    String projectId = getProjectId();
    String apiUrl = baseURI + "api/projects/" + projectId+ "/initialrequest";

    @Test(priority = 1)
    public void getInitialRequestByProjectId_requestReceived_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl , "", 200, "GET");
    }
    @Test(priority = 2)
    public void getInitialRequestByProjectId_descriptionOfInvention_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "descriptionOfInvention", descriptionOfInvention, "GET", "");
    }
    @Test(priority = 3)
    public void getInitialRequestByProjectId_knownPriorArt_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "knownPriorArt", knownPriorArt, "GET", "");
    }
    @Test(priority = 4)
    public void getInitialRequestByProjectId_prenegotiatedProjectName_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "prenegotiatedProjectName", prenegotiatedProjectName, "GET", "");
    }
    @Test(priority = 5)
    public void getInitialRequestByProjectId_otherOrderInformationOrComments_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "otherOrderInformationOrComments", otherOrderInformationOrComments, "GET", "");
    }
    @Test(priority = 6)
    public void getInitialRequestByProjectId_TechnicalField_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "technicalField", technicalField, "GET", "");
    }
    @Test(priority = 7)
    public void getInitialRequestByProjectId_ProjectType_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "projectType", projectType, "GET", "");
    }
    @Test(priority = 8)
    public void getInitialRequestByProjectId_Currency_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "currency", currency, "GET", "");
    }
    @Test(priority = 9)
    public void getInitialRequestByProjectId_DeliveryOption_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "deliveryOption", deliveryOption, "GET", "");
    }
    @Test(priority = 10)
    public void getInitialRequestByProjectId_deliveryOption_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "deliveryOption", deliveryOption, "GET", "");
    }
    @Test(priority = 11)
    public void getInitialRequestByProjectId_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 12)
    public void getInitialRequestByProjectId_preNegotiatedProjectId_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "preNegotiatedProjectId", preNegotiatedProjectId, "GET", "");
    }
    @Test(priority = 13)
    public void getInitialRequestByProjectId_preNegotiatedProjectInternalDescription_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "preNegotiatedProjectInternalDescription", preNegotiatedProjectInternalDescription, "GET", "");
    }
    @Test(priority = 14)
    public void getInitialRequestByProjectId_InvalidProject_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl + "sdsd/initialrequest", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 15)
    public void getInitialRequestByProjectId_InvalidProject_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "asas/initialrequest", "", 404, "GET");
    }
    @Test(priority = 1)
    public void getInitialRequestByProjectId_ResponseTime() {
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }

}
