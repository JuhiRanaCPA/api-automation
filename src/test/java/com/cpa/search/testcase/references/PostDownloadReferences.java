package com.cpa.search.testcase.references;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDownloadReferences extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    List<String> referenceIdList = new ArrayList<>();

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
        apiUrl=apiUrl + projectId + "/references/downloadReferences";
        for(int i=0; i<=2;i++) {
            String strBody1 = "{\n" +
                    "  \"title\": \"Add NPL Reference "+i+"\",\n" +
                    "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference "+i+"\",\n" +
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
            referenceIdList.add(getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody1, "id", "POST"));
        }
    }
    @Test
    public void getReferencesById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"referenceIds\": [\n" +
                "    \""+ referenceIdList.get(0)+"\",\n" +
                "    \""+ referenceIdList.get(1)+"\",\n" +
                "    \""+ referenceIdList.get(2)+"\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test
    public void getReferencesById_Null_ReferenceId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"referenceIds\": [\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 4)
    public void postDownloadReferences_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"referenceIds\": [\n" +
                "    \""+ referenceIdList.get(0)+"\",\n" +
                "    \""+ referenceIdList.get(1)+"\",\n" +
                "    \""+ referenceIdList.get(2)+"\"\n" +
                "  ]\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }

}
