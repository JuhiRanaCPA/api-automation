package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCommentOfAnnotation extends BootStrap {
    String apiUrl = baseURI + "api/projects/";
    String projectId,referenceId, annotationId, commentId = "";

    @BeforeTest
    public void addAnnotation() {
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
           String strBody1 = "[\n" +
                " {\n" +
                "    \"innographyId\": \"I-000101303241\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"20110290232\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        setResponse(baseURI + "api/projects/" + projectId + "/patents/import", "POST", strBody1);
        referenceId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", "", "id[0]", "GET");
        String strBody2 = "{\n" +
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
        setResponse(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "/annotations", "POST", strBody2);
        annotationId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/annotations", "", "id[0]", "GET");
        String strBody3 = "{\n" +
                "  \"type\": \"comment\",\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication for Tc GetCommentOfAnnotation\"\n" +
                "  }\n" +
                "}";
        apiUrl = apiUrl + projectId + "/references/"+ referenceId + "/annotations/" + annotationId + "/comments";
        commentId = getValueFromResponse(apiUrl, strBody3, "id", "POST");
    }

    @Test(priority = 1)
    public void getCommentOfAnnotation_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 2)
    public void getCommentOfAnnotation_Validate_content() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.content[0]", "Creating new thread for communication for Tc GetCommentOfAnnotation", "GET", "");
    }

    @Test(priority = 3)
    public void getCommentOfAnnotation_Validate_CreatedByFirstName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.firstname[0]", "Jesse", "GET", "");
    }

    @Test(priority = 4)
    public void getCommentOfAnnotation_Validate_CreatedByLastName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.lastname[0]", "Pinkman", "GET", "");
    }

    @Test(priority = 5)
    public void getCommentOfAnnotation_Validate_CreatedBy_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.email[0]", "jesse.pinkman@nomail.example.com", "GET", "");
    }

    @Test(priority = 6)
    public void getCommentOfAnnotation_Validate_canCurrentUserAcknowledge() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.canCurrentUserAcknowledge[0]", "false", "GET", "");
    }

    @Test(priority = 7)
    public void getCommentOfAnnotation_ValidateId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[0]", commentId, "GET", "");
    }

    @Test(priority = 8)
    public void getCommentOfAnnotation__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
