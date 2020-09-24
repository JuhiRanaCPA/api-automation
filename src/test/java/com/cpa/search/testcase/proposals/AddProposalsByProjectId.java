package com.cpa.search.testcase.proposals;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddProposalsByProjectId extends BootStrap{
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
        apiUrl = apiUrl +projectId+"/proposals";
    }
    @Test(priority = 1)
    public void addProposalsByProjectId_CreateProject_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"newProposaladdProposalsByProjectId_CreateProject_201\",\n" +
                "  \"summary\": \"adad\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");

    }
    @Test(priority = 2)
    public void addProposalsByProjectId_Validate_titleBlank_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"\",\n" +
                "  \"summary\": \"adad\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }
    @Test(priority = 3)
    public void addProposalsByProjectId_SummaryBlank_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"newProposaladdProposalsByProjectId_CreateProject_201\",\n" +
                "  \"summary\": \"adad\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }
    @Test(priority =4)
    public void addProposalsByProjectId_Validate_WithoutTitleField_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"summary\": \"adad\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }
    @Test(priority =5)
    public void addProposalsByProjectId_Validate_WithoutSummaryField_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"newProposaladdProposalsByProjectId_CreateProject_201\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }
    @Test(priority =6)
    public void addProposalsByProjectId_Validate_WithoutAttachmentsField_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"newProposaladdProposalsByProjectId_CreateProject_201\",\n" +
                "  \"summary\": \"adad\",\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }
    @Test(priority = 7)
    public void addProposal_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"newProposaladdProposalsByProjectId_CreateProject_201\",\n" +
                "  \"summary\": \"adad\",\n" +
                "  \"attachments\": []\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");

    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
