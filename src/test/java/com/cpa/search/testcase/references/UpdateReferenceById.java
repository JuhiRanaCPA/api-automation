package com.cpa.search.testcase.references;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class UpdateReferenceById  extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    String referenceId1 = "";

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
        apiUrl = apiUrl  + projectId + "/references/";
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
    }

    @Test(priority = 1)
    public void updateReferenceById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "   \"title\": \"Updated Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Updated Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + currentDateTime.minusDays(100).toString() + "\",\n" +
                "  \"abstract\": \"Updated Adding abstract\",\n" +
                "  \"link\": \"https://www.abcUpdated.com\",\n" +
                "  \"citations\": \"Page 8 Paragraph 199\",\n" +
                "  \"source\": \"New CPA publications\",\n" +
                "  \"databaseSource\": \"Updated Adding dataBase source\",\n" +
                "  \"doi\": \"899.33/1.122\",\n" +
                "  \"fullText\": \"Adding full Text\",\n" +
                "  \"files\": [],\n" +
                "  \"drawings\": [],\n" +
                "  \"keywords\": []\n" +
                "}";
        validateStatusCode(apiUrl + referenceId1, strBody, 200, "PUT");
    }

    @Test(priority = 2)
    public void updateReferenceById_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "title", "Updated Add NPL Reference 1", "GET", "");
    }

    @Test(priority = 3)
    public void updateReferenceById_Validate_searchTeamComment() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "searchTeamComment", "Updated Adding general comments for Add NPL Reference 1", "GET", "");
    }

    @Test(priority = 4)
    public void updateReferenceById_Validate_source() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "source", "New CPA publications", "GET", "");
    }

    @Test(priority = 5)
    public void updateReferenceById_Validate_link() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "link", "https://www.abcUpdated.com", "GET", "");
    }

    @Test(priority = 6)
    public void updateReferenceById_Validate_citations() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "citations", "Page 8 Paragraph 199", "GET", "");
    }

    @Test(priority = 7)
    public void updateReferenceById_Validate_doi() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "doi", "899.33/1.122", "GET", "");
    }

    @Test(priority = 8)
    public void updateReferenceById_Validate_databaseSource() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "databaseSource", "Updated Adding dataBase source", "GET", "");
    }

    @Test(priority =9)
    public void updateReferenceById_Validate_abstract() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "abstract", "Updated Adding abstract", "GET", "");
    }

    @Test(priority = 10)
    public void updateReferenceById_Validate_referenceType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId1, "referenceType", "nonPatent", "GET", "");
    }

    @Test(priority = 11)
    public void updateReferenceById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "   \"title\": \"Updated Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Updated Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + currentDateTime.minusDays(100).toString() + "\",\n" +
                "  \"abstract\": \"Updated Adding abstract\",\n" +
                "  \"link\": \"https://www.abcUpdated.com\",\n" +
                "  \"citations\": \"Page 8 Paragraph 199\",\n" +
                "  \"source\": \"New CPA publications\",\n" +
                "  \"databaseSource\": \"Updated Adding dataBase source\",\n" +
                "  \"doi\": \"899.33/1.122\",\n" +
                "  \"fullText\": \"Adding full Text\",\n" +
                "  \"files\": [],\n" +
                "  \"drawings\": [],\n" +
                "  \"keywords\": []\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + referenceId1, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
