package com.cpa.search.testcase.keywords;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class AddKeywordByReferenceId extends BootStrap {
    String apiUrl = baseURI + "api/projects/";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    String projectId, referenceId = "";

    @BeforeTest
    public void addReferences() {
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
        String strBody1 = "{\n" +
                "  \"title\": \"Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate1 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \"Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";
        referenceId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody1, "id", "POST");
        apiUrl = apiUrl + projectId + "/references/" + referenceId + "/keywords";
    }

    @Test(priority = 1)
    public void addKeywordByReferenceId_InvalidRefId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"new keyword added for addKeywordByReferenceId\"\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "sdsd/keywords", strBody, 404, "POST");
    }

    @Test(priority = 2)
    public void addKeywordByReferenceId_InvalidRefId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"new keyword added for addKeywordByReferenceId\"\n" +
                "}";
        validateResponseMessage(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "sdsd/keywords", strBody, "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }

//    Defect raised on 09th Jan
    @Test(priority = 3)
    public void addKeywordByReferenceId_NullRequest_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }

    //    Defect raised on 09th Jan
    @Test(priority = 4)
    public void addKeywordByReferenceId_NullName_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }

    @Test(priority = 5)
    public void addKeywordByReferenceId_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"new keyword added for addKeywordByReferenceId\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }

    @Test(priority = 6)
    public void addKeywordByReferenceId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"new keyword added for addKeywordByReferenceId\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}