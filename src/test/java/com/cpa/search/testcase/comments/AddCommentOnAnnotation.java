package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCommentOnAnnotation extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String referenceId, annotationId = "";

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
        String strBody2 ="{\n" +
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
        apiUrl=apiUrl + projectId + "/references/";
    }

    @Test(priority = 1)
    public void addCommentOnAnnotation_Null_Request_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId +"/references/"+referenceId+ "/annotations/" + annotationId + "/comments", strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addCommentOnAnnotation_InvalidProposalId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"type\": \"comment\",\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId +"/references/"+referenceId+ "/annotations/" + annotationId + "sdsd/comments", strBody, 404, "POST");
    }
    @Test(priority = 3)
    public void addCommentOnAnnotation_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"type\": \"comment\",\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId +"/references/"+referenceId+  "/annotations/" + annotationId + "/comments", strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addCommentOnAnnotation_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"type\": \"comment\",\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  }\n" +
                "}";
        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId +"/references/"+referenceId+  "/annotations/" + annotationId + "/comments", "comment.content", "Creating new thread for communication", "POST", strBody);
    }
    @Test(priority = 5)
    public void addCommentThreadToProposal_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"type\": \"comment\",\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  }\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/projects/" + projectId +"/references/"+referenceId+  "/annotations/" + annotationId + "/comments", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}

