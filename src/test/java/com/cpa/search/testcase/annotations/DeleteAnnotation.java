package com.cpa.search.testcase.annotations;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAnnotation extends BootStrap {
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
        apiUrl = apiUrl  + projectId + "/references/";
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
    }

    @Test(priority = 1)
    public void deleteAnnotation_IncorrectReferenceId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + referenceId + "/annotations/aad" + annotationId, "", 404, "DELETE");
    }

    @Test(priority = 2)
    public void deleteAnnotation_IncorrectReferenceId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl + referenceId + "/annotations/aad" + annotationId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }

    @Test(priority = 3)
    public void deleteAnnotation_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + referenceId + "/annotations/" + annotationId, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteAnnotation_DeletedAnnotation_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + referenceId + "/annotations/" + annotationId, "", 404, "DELETE");
    }
//    @Test(priority = 5)
//    public void deleteAnnotation_DeletedAnnotation_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateResponseMessage(apiUrl + referenceId + "/annotations/" + annotationId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
//    }
    @Test(priority = 6)
    public void deleteProposal_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + referenceId + "/annotations/" + annotationId, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}

