package com.cpa.search.testcase.patents;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddPatentsByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
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
    @Test(priority = 1)
    public void addPatentsByProjectId_CreateProject_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl = apiUrl + projectId + "/patents/import";
        String strBody = "[\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182706523\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525361\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182724397\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525362\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182738592\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525363\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        validateStatusCode(apiUrl, strBody, 200, "POST");

    }

    @Test(priority = 2)
    public void addPatentsByProjectId_Validate_nullRequest_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "[\n" +
                "]";
        validateStatusCode(apiUrl, strBody, 500, "POST");
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }

    @Test(priority = 3)
    public void addPatentsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectId1 = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl = baseURI + "api/projects/" + projectId1 + "/patents/import";
        String strBody = "[\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182706523\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525361\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182724397\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525362\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182738592\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525363\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
        setResponse(baseURI + "api/projects/" + projectId1, "DELETE", "");
    }
}

