package com.cpa.search.testcase.comments;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddAcknowledgeOnCommentId extends BootStrap {
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String commentId ="";

    @BeforeTest
    public void addComment() {
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
        String strBody1 = "{\n" +
                "  \"comment\": {\n" +
                "    \"content\": \"Creating new thread for communication\"\n" +
                "  },\n" +
                "  \"type\": \"comment\",\n" +
                "  \"communicationType\": \"phone\",\n" +
                "  \"communicationDate\": \"" + date + "\"\n" +
                "}";
        commentId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/comments/threads",strBody1,"comment.threadId","POST");
        apiUrl =apiUrl + projectId + "/comments/";
    }
    @Test(priority = 1)
    public void addAcknowledgeOnCommentId_Validate_canCurrentUserAcknowledge_BeforeAcknowledge(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String value = getValueFromResponse(apiUrl+"threads","","comment.content[0]","GET");
        validateKeyValueFromResponse(apiUrl+"threads","comment.canCurrentUserAcknowledge[0]","false","GET","");
    }
    @Test(priority = 2)
    public void addAcknowledgeOnCommentId_InvalidCommentId_404(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+commentId+"xcscs/acknowledge","",404,"POST");
    }
    @Test(priority = 3)
    public void addAcknowledgeOnCommentId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+commentId+"/acknowledge","",200,"POST");
    }
    @Test(priority = 4)
    public void addAcknowledgeOnCommentId_Validate_canCurrentUserAcknowledge_AlreadyAcknowledged(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl+"threads","comment.canCurrentUserAcknowledge[0]","true","GET","");
    }
    @Test(priority = 5)
    public void addAcknowledgeOnCommentId_AlreadyAcknowledged_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+commentId+"/acknowledge","",200,"POST");
    }
    @Test(priority = 6)
    public void addAcknowledgeOnCommentId_Validate_canCurrentUserAcknowledge_AfterAcknowledge(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl+"threads","comment.canCurrentUserAcknowledge[0]","true","GET","");
    }
    @Test(priority = 7)
    public void addAcknowledgeOnCommentId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+commentId+"/acknowledge", "", BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
