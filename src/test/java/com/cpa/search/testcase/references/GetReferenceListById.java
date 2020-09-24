package com.cpa.search.testcase.references;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class GetReferenceListById extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    String filingDate2 = currentDateTime.minusDays(900).toString();
    String referenceId1, referenceId2 = "";

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
        apiUrl = apiUrl   + projectId + "/references/ids";
        String strBody1 = "{\n" +
                "  \"title\": \"Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\",\"John Collen\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate1 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \" Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";
        referenceId1 = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody1, "id", "POST");
        String strBody2 = "{\n" +
                "  \"title\": \"Add NPL Reference 2\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 2\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\",\"John Collen\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate2 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \" Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";
        referenceId2 = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody2, "id", "POST");
    }

    @Test(priority = 1)
    public void getReferenceListById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 2)
    public void getReferenceListById_ValidateReferenceId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String actualStatus = "fail";
        String expectedResult = "pass";
        String referenceIdList = getResponse().asString();
        if (referenceIdList.contains(referenceId1)) {
            if (referenceIdList.contains(referenceId2)) {
                actualStatus = "pass";
            }
        }
        Assert.assertEquals(actualStatus, expectedResult);
    }

    @Test(priority = 3)
    public void getReferenceListById_ValidateFor_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/projects/" + projectId + "23as/references/ids", "", 404, "GET");
    }

    @Test(priority = 4)
    public void getReferenceListById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
