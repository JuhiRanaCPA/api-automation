package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCommentsThreadToProject extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    @BeforeTest
    public void addProject() {
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
        apiUrl = apiUrl + projectId + "/comments/threads";
    }
    @Test(priority = 1)
    public void addCommentThreadToProject_NulL_Request_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addCommentThreadToProject_InvalidProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        validateStatusCode(baseURI + "api/projects/" + projectId +"sdsd/comments/threads", strBody, 404, "POST");
    }
    @Test(priority = 3)
    public void addCommentThreadToProject_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addCommentThreadToProject_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl, "comment.content", "Creating new thread for communication", "POST", strBody);
    }
    @Test(priority = 5)
    public void addCommentThreadToProject_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
