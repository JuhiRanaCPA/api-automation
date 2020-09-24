package com.cpa.search.testcase.annotations;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateAnnotationById extends BootStrap {
    String apiUrl = baseURI + "api/projects/";
    String referenceId, annotationId,projectId = "";

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
        apiUrl=apiUrl + projectId + "/references/";
        String strBody2 = "[\n" +
                " {\n" +
                "    \"innographyId\": \"I-000101303241\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"20110290232\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        setResponse(baseURI + "api/projects/" + projectId + "/patents/import", "POST", strBody2);
        referenceId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", "", "id[0]", "GET");
        String strBody1 ="{\n" +
                "  \"target\": \"/abstract\",\n" +
                "  \"preview\": \"warming device contains chemical react\",\n" +
                "  \"definition\": [\n" +
                "    {\n" +
                "      \"start\": [\n" +
                "        \"/#text[1]\",\n" +
                "        22\n" +
                "      ],\n" +
                "      \"end\": [\n" +
                "        \"/#text[1]\",\n" +
                "        60\n" +
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
        setResponse(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "/annotations", "POST", strBody1);
        annotationId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/annotations", "", "id[0]", "GET");
    }

    @Test(priority = 1)
    public void updateAnnotationById_BeforeUpdate_ValidateRefId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "referenceId[0]", referenceId, "GET", "");
    }

    @Test(priority = 2)
    public void updateAnnotationById_BeforeUpdate_Validate_Preview() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "preview[0]", "warming device contains chemical react", "GET", "");
    }

    @Test(priority = 3)
    public void updateAnnotationById_BeforeUpdate_Validate_AnnotationType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "annotationType[0]", "internal", "GET", "");
    }

    @Test(priority = 4)
    public void updateAnnotationById_BeforeUpdate_Validate_Citation_Column() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.column[0]", "Cloumn 39", "GET", "");
    }

    @Test(priority = 5)
    public void updateAnnotationById_BeforeUpdate_Validate_Citation_line() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.line[0]", "Line23", "GET", "");
    }

    @Test(priority = 6)
    public void updateAnnotationById_BeforeUpdate_Validate_Citation_Type() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.type[0]", "lineColumn", "GET", "");
    }

    @Test(priority = 7)
    public void updateAnnotationById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"featureId\": [],\n" +
                "  \"citation\": {\n" +
                "    \"type\": \"paragraph\",\n" +
                "    \"paragraph\": \"Adding paragraph now\"\n" +
                "  },\n" +
                "  \"definition\": [\n" +
                "    {\n" +
                "      \"start\": [\n" +
                "        \"/#text[1]\",\n" +
                "        22\n" +
                "      ],\n" +
                "      \"end\": [\n" +
                "        \"/#text[1]\",\n" +
                "        60\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"preview\": \"warming device contains chemical react\"\n" +
                "}";
        validateStatusCode(apiUrl + referenceId + "/annotations/"+annotationId, strBody, 200, "PUT");
    }
    @Test(priority = 8)
    public void updateAnnotationById_AfterUpdate_ValidateRefId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "referenceId[0]", referenceId, "GET", "");
    }

    @Test(priority = 9)
    public void updateAnnotationById_AfterUpdatee_Validate_Preview() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "preview[0]", "warming device contains chemical react", "GET", "");
    }

    @Test(priority = 10)
    public void updateAnnotationById_AfterUpdate_Validate_AnnotationType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "annotationType[0]", "internal", "GET", "");
    }

    @Test(priority = 11)
    public void updateAnnotationById_AfterUpdate_Validate_Citation_Paragraph() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.paragraph[0]", "Adding paragraph now", "GET", "");
    }

    @Test(priority = 12)
    public void updateAnnotationById_AfterUpdate_Validate_Citation_Type() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl + referenceId + "/annotations", "citation.type[0]", "paragraph", "GET", "");
    }

    @Test(priority = 13)
    public void updateAnnotationById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"featureId\": [],\n" +
                "  \"citation\": {\n" +
                "    \"type\": \"paragraph\",\n" +
                "    \"paragraph\": \"adding paragraph now\"\n" +
                "  },\n" +
                "  \"definition\": [\n" +
                "    {\n" +
                "      \"start\": [\n" +
                "        \"/#text[1]\",\n" +
                "        22\n" +
                "      ],\n" +
                "      \"end\": [\n" +
                "        \"/#text[1]\",\n" +
                "        60\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"preview\": \"warming device contains chemical react\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + referenceId + "/annotations/"+annotationId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
