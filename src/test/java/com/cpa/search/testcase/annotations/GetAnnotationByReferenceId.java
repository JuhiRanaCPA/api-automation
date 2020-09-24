package com.cpa.search.testcase.annotations;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAnnotationByReferenceId extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api//projects/" ;
    String referenceId = "";

    @BeforeTest
    public void ImportPatent() {
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
         strBody = "[\n" +
                " {\n" +
                "    \"innographyId\": \"I-000101303241\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"20110290232\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        setResponse(baseURI + "api/projects/" + projectId + "/patents/import", "POST", strBody);
        referenceId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", "", "id[0]", "GET");
        strBody = "{\n" +
                "  \"target\": \"/abstract\",\n" +
                "  \"preview\": \"warming device contains chemical reaction\",\n" +
                "  \"definition\": [\n" +
                "    {\n" +
                "      \"start\": [\n" +
                "        \"/#text[1]\",\n" +
                "        22\n" +
                "      ],\n" +
                "      \"end\": [\n" +
                "        \"/#text[1]\",\n" +
                "        64\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"citation\": {\n" +
                "    \"type\": \"lineColumn\",\n" +
                "    \"line\": \"Line23\",\n" +
                "    \"column\": \"Cloumn 39\"\n" +
                "  },\n" +
                "  \"featureId\": [],\n" +
                "  \"comment\": null\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "/annotations", "POST", strBody);
    }

    @Test(priority = 0)
    public void getAnnotationByReferenceId_GetValidResponse_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + referenceId + "/annotations", "", 200, "GET");
    }

    @Test(priority = 1)
    public void getAnnotationByReferenceId_ValidateRefId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "referenceId[0]", referenceId, "GET", "");
    }

    @Test(priority = 2)
    public void getAnnotationByReferenceId_Validate_Preview() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "preview[0]", "warming device contains chemical reaction", "GET", "");
    }

    @Test(priority = 3)
    public void getAnnotationByReferenceId_Validate_AnnotationType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "annotationType[0]", "internal", "GET", "");
    }

    @Test(priority = 4)
    public void getAnnotationByReferenceId_Validate_Citation_Column() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.column[0]", "Cloumn 39", "GET", "");
    }

    @Test(priority = 5)
    public void getAnnotationByReferenceId_Validate_Citation_line() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.line[0]", "Line23", "GET", "");
    }

    @Test(priority = 6)
    public void getAnnotationByReferenceId_Validate_Citation_Type() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.type[0]", "lineColumn", "GET", "");
    }

    @Test(priority = 7)
    public void getAnnotationByReferenceId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + referenceId + "/annotations", "", BENCHMARK_RESPONSE_TIME, "GET");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
