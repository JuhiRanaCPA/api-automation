package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCommentsThreadOfProject extends BootStrap {
    String projectId,threadId = "";
    String apiUrl = baseURI + "api/projects/" ;

    @BeforeTest
    public void AddCommentInProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = "AddProject" + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
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
                "  \"startDate\": \""+date+"\"\n" +
                "}";
        projectId= getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl =apiUrl + projectId + "/comments/threads";
        String strBody1 = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
       threadId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/comments/threads",strBody1,"id","POST");
    }
    @Test(priority = 1)
    public void getCommentsThreadOfProject_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getCommentsThreadOfProject_Validate_content() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.content[0]", "Creating new thread for communication", "GET", "");
    }
    @Test(priority = 3)
    public void getCommentsThreadOfProject_Validate_CreatedByFirstName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.firstname[0]", "Jesse", "GET", "");
    }
    @Test(priority = 4)
    public void getCommentsThreadOfProject_Validate_CreatedByLastName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.lastname[0]", "Pinkman", "GET", "");
    }
    @Test(priority = 5)
    public void getCommentsThreadOfProject_Validate_CreatedBy_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.createdBy.email[0]", "jesse.pinkman@nomail.example.com", "GET", "");
    }
    @Test(priority = 6)
    public void getCommentsThreadOfProject_Validate_canCurrentUserAcknowledge() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "comment.canCurrentUserAcknowledge[0]", "false", "GET", "");
    }
    @Test(priority = 7)
    public void getCommentsThreadOfProject_ValidateId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[0]", threadId, "GET", "");
    }
    @Test(priority = 8)
    public void getCommentsThreadOfProject__ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
