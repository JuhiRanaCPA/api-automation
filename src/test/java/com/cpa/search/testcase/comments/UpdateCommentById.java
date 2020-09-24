package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateCommentById extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String commentId = "";

    @BeforeTest
    public void addComment() {
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
        apiUrl=apiUrl  + projectId + "/comments/threads";
        String strBody1 = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication for Tc UpdateCommentById\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        commentId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/comments/threads", strBody1, "comment.id", "POST");
    }

    @Test(priority = 1)
    public void updateCommentById_Validate_content_BeforeUpdate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.content[0]", "Creating new thread for communication for Tc UpdateCommentById", "GET", "");
    }

    @Test(priority = 2)
    public void updateCommentById_InValidCommentId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"content\": \"Updating value of Creating new thread for communication for Tc UpdateCommentById\"\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId + "/comments/sdsds" + commentId, strBody, 404, "PUT");
    }

    @Test(priority = 3)
    public void updateCommentById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"content\": \"Updating value of Creating new thread for communication for Tc UpdateCommentById\"\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId + "/comments/" + commentId, strBody, 200, "PUT");
    }

    @Test(priority = 4)
    public void updateCommentById_Validate_content() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.content[0]", "Updating value of Creating new thread for communication for Tc UpdateCommentById", "GET", "");
    }


    @Test(priority = 5)
    public void updateCommentById_Validate_CreatedBy_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.email[0]", "jesse.pinkman@nomail.example.com", "GET", "");
    }

    @Test(priority = 6)
    public void updateCommentById_Validate_canCurrentUserAcknowledge() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.canCurrentUserAcknowledge[0]", "false", "GET", "");
    }

    @Test(priority = 7)
    public void updateCommentById_ValidateCommentId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.id[0]", commentId, "GET", "");
    }

    @Test(priority = 8)
    public void updateCommentById_Validate_CreatedByLastName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.lastname[0]", "Pinkman", "GET", "");
    }

    @Test(priority = 9)
    public void updateCommentById_Validate_CreatedByFirstName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.firstname[0]", "Jesse", "GET", "");
    }

    @Test(priority = 10)
    public void updateCommentById__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"content\": \"Updating value of Creating new thread for communication for Tc UpdateCommentById\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/projects/" + projectId + "/comments/" + commentId, "", BENCHMARK_RESPONSE_TIME, "PUT");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
