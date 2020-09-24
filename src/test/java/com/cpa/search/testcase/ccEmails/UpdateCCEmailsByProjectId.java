package com.cpa.search.testcase.ccEmails;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateCCEmailsByProjectId  extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";

    @BeforeTest
    public void addProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = "AddProject" + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
                "  \"deliveryOption\": \"standard\",\n" +
                "  \"descriptionOfInvention\": \"\",\n" +
                "  \"knownPriorArt\": \"\",\n" +
                "  \"budget\": \"\",\n" +
                "  \"otherOrderInformationOrComments\": \"\",\n" +
                "  \"attachments\": [],\n" +
                "  \"rate\": 0,\n" +
                "  \"hours\": 0,\n" +
                "  \"contactCode\": \"\",\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"noDocumentCopyrightFees\": false,\n" +
                "  \"noDocumentServiceFees\": false,\n" +
                "  \"ccEmails\": \"\",\n" +
                "  \"usersSharesIds\": null,\n" +
                "  \"startDate\": \"" + date + "\"\n" +
                "}";
        projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl = apiUrl+ projectId + "/ccEmails";
    }
    @Test(priority = 1)
    public void updateCCEmailsByProjectId_Validate_ccEmails_BeforeUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"ccEmails","","GET","");
    }
    @Test(priority = 2)
    public void updateCCEmailsByProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ccEmails\": \"jesse.pinkman@nomail.example.com\"\n" +
                "}";
        validateStatusCode( baseURI + "api/projects/"+projectId+"sdsd/ccEmails", strBody, 404, "PUT");
    }
    @Test(priority = 3)
    public void updateCCEmailsByProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ccEmails\": \"jesse.pinkman@nomail.example.com\"\n" +
                "}";
        validateResponseMessage( baseURI + "api/projects/"+projectId+"sdsd/ccEmails", strBody, "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "PUT");
    }

    @Test(priority = 4)
    public void updateCCEmailsByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ccEmails\": \"jesse.pinkman@nomail.example.com\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
    @Test(priority = 5)
    public void updateCCEmailsByProjectId_Validate_ccEmails_AfterUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"ccEmails","jesse.pinkman@nomail.example.com","GET","");
    }
    @Test(priority = 6)
    public void updateCCEmailsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ccEmails\": \"jesse.pinkman@nomail.example.com\"\n" +
                "}";
    validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
}
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
