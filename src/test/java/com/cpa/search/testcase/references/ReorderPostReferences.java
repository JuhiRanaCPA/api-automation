package com.cpa.search.testcase.references;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class ReorderPostReferences extends BootStrap{
    String apiUrl = baseURI + "api/projects/";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    String filingDate2 = currentDateTime.minusDays(900).toString();
    String projectId, referenceId1, referenceId2 = "";

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
        apiUrl=apiUrl + projectId + "/references";
    }

    @Test(priority = 1)
    public void reorderPostReferences_Validate_TitleR1_BeforeReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[0]", "Add NPL Reference 1", "GET", "");
    }

    @Test(priority = 2)
    public void reorderPostReferences_Validate__IdR1_BeforeReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[0]", referenceId1, "GET", "");
    }

    @Test(priority = 3)
    public void reorderPostReferences_Validate_TitleR2_BeforeReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[1]", "Add NPL Reference 2", "GET", "");
    }

    @Test(priority = 4)
    public void reorderPostReferences_Validate_IdR2_BeforeReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[1]", referenceId2, "GET", "");
    }

    @Test(priority = 5)
    public void reorderPostReferences_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "[\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId2 + "\",\n" +
                "    \"order\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId1 + "\",\n" +
                "    \"order\": 1\n" +
                "  }\n" +
                "]";
        validateStatusCode(apiUrl+"/reorder", strBody, 200, "POST");
    }

    @Test(priority = 6)
    public void reorderPostReferences_Validate_TitleR1_AfterReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[0]", "Add NPL Reference 2", "GET", "");
    }

    @Test(priority = 7)
    public void reorderPostReferences_Validate__IdR1_AfterReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[0]", referenceId2, "GET", "");
    }

    @Test(priority = 8)
    public void reorderPostReferences_Validate_TitleR2_AfterReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[1]", "Add NPL Reference 1", "GET", "");
    }

    @Test(priority = 9)
    public void reorderPostReferences_Validate_IdR2_AfterReorder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[1]", referenceId1, "GET", "");
    }


    @Test(priority = 10)
    public void reorderPostReferences_ValidateFor_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "[\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId2 + "\",\n" +
                "    \"order\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId1 + "\",\n" +
                "    \"order\": 1\n" +
                "  }\n" +
                "]";
        validateStatusCode(baseURI + "api/projects/" + projectId + "23as/references/reorder", strBody, 404, "POST");
    }

    @Test(priority = 11)
    public void reorderPostReferences_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "[\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId2 + "\",\n" +
                "    \"order\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"" + referenceId1 + "\",\n" +
                "    \"order\": 1\n" +
                "  }\n" +
                "]";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+"/reorder", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
