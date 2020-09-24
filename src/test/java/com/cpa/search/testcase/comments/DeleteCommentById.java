package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteCommentById extends BootStrap {
    String projectId,commentId = "";
    String apiUrl = baseURI + "api/projects/";

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
        apiUrl=apiUrl + projectId;
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
    public void deleteCommentById_InValidProjectID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"sdsds/comments/"+commentId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteCommentById_InValidProjectID_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( apiUrl+"sdsds/comments/"+commentId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteCommentById_InValidCommentId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"/comments/adads"+commentId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteCommentById_InValidCommentId__Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( apiUrl+"/comments/adads"+commentId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 9)
    public void deleteCommentById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"/comments/"+commentId, "", 200, "DELETE");
    }
    @Test(priority = 10)
    public void deleteCommentById_DeletedComment_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"/comments/"+commentId, "", 404, "DELETE");
    }
    @Test(priority = 11)
    public void deleteCommentById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+"/comments/"+commentId, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
