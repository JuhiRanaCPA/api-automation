package com.cpa.search.testcase.references;

import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class GetReferencesById extends BootStrap{
    String projectId ="";
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
        apiUrl = apiUrl + projectId + "/references/";
        strBody = "{\n" +
                "  \"title\": \"Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\",\"John Collen\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate1 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \"Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";
        referenceId1 = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody, "id", "POST");
        strBody = "{\n" +
                "  \"title\": \"Add NPL Reference 2\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 2\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\",\"John Collen\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate2 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \"Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";
        referenceId2 = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody, "id", "POST");
    }

    @Test
    public void getReferencesById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + referenceId1, "", 200, "GET");
    }

    @Test
    public void getReferencesById_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "title", "Add NPL Reference 1", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_searchTeamComment() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "searchTeamComment", "Adding general comments for Add NPL Reference 1", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_source() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "source", "CPA publication", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_link() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "link", "https://www.abc.com", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_citations() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "citations", "Page 1 Paragraph 8", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_doi() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "doi", "10.111/1.2222", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_databaseSource() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "databaseSource", "Adding dataBase source", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_abstract() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "abstract", "Adding abstract", "GET", "");
    }

    @Test
    public void getReferencesById_Validate_referenceType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "referenceType", "nonPatent", "GET", "");
    }

    @Test
    public void reorderPostReferences_Validate_TitleR2() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId2, "title", "Add NPL Reference 2", "GET", "");
    }

    @Test
    public void reorderPostReferences_Validate_IdR2() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId2, "id", referenceId2, "GET", "");
    }

    @Test(priority = 4)
    public void getReferencesById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + referenceId1, "", BENCHMARK_RESPONSE_TIME, "GET");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
