package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCommentOnCommentId  extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String commentId ="";

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
        apiUrl = apiUrl  + projectId + "/comments/";
        strBody = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        commentId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/comments/threads",strBody,"comment.id","POST");
    }

    @Test(priority = 1)
    public void addCommentOnCommentId_NulL_Request_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl+commentId+"/comments", strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addCommentOnCommentId_InvalidProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody ="{\n" +
                "  \"content\": \"Replied on Creating new thread for communication\"\n" +
                "}";
        validateStatusCode(apiUrl+commentId+"sdsd/comments", strBody, 404, "POST");
    }
    @Test(priority = 3)
    public void addCommentOnCommentId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody ="{\n" +
                "  \"content\": \"Replied on Creating new thread for communication\"\n" +
                "}";
        validateStatusCode(apiUrl+commentId+"/comments", strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addCommentThreadToProposal_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody ="{\n" +
                "  \"content\": \"Replied on Creating new thread for communication\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+commentId+"/comments", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}

