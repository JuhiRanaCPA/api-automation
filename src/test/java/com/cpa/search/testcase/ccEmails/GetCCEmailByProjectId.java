package com.cpa.search.testcase.ccEmails;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCCEmailByProjectId extends BootStrap {
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
        apiUrl = apiUrl +projectId+"/ccEmails";
    }
    @Test(priority = 1)
    public void getCCEmailsByProjectId_Validate_ccEmails_BeforeUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"ccEmails","","GET","");
    }
    @Test(priority = 2)
    public void getCCEmailsByProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/"+projectId+"sdsd/ccEmails", "", 404, "GET");
    }
    @Test(priority = 3)
    public void getCCEmailsByProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/"+projectId+"sdsd/ccEmails", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");

    }
    @Test(priority = 4)
    public void getCCEmailsByProjectId_Validate_ccEmails_AfterUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"ccEmails\": \"jesse.pinkman@nomail.example.com\"\n" +
                "}";
        setResponse(apiUrl,"PUT",strBody);
        validateKeyValueFromResponse(apiUrl,"ccEmails","jesse.pinkman@nomail.example.com","GET","");
    }
    @Test(priority = 5)
    public void getCCEmailsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}