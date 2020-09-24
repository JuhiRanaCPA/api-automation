package com.cpa.search.testcase.introductions;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateIntroductionsByProjectId extends BootStrap{
    String projectId,introductionId= "";
    String CommentsAdded = "Adding Introduction for "+introductionId+" Random no "+generateRandom(3);
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
        String strBody1 = "{\n" +
                "  \"introductionText\": \""+CommentsAdded+"\"\n" +
                "}";
        introductionId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/introductions/" , strBody1, "id", "POST");
        apiUrl = apiUrl + projectId + "/introductions/"+introductionId;
    }
    @Test(priority = 1)
    public void updateIntroductionsByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 01"+CommentsAdded;
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 2)
    public void updateIntroductionsByProjectId_Validate__Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 02"+CommentsAdded;
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        validateResponseMessage(apiUrl,strBody,"","PUT");
    }

    @Test(priority = 3)
    public void updateIntroductionsByProjectId_Validate_UpdatedIntroduction() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 03";
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        setResponse(apiUrl,"PUT",strBody);
        validateKeyValuesFromResponse(baseURI + "api/projects/" + projectId + "/introductions/","introductionText",updatedComments,"GET",strBody);
    }
    @Test(priority = 4)
    public void updateIntroductionsByProjectId_Null_Request_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 01"+CommentsAdded;
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 5)
    public void updateIntroductionsByProjectId_Null__Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 02"+CommentsAdded;
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        validateResponseMessage(apiUrl,strBody,"","PUT");
    }

    @Test(priority = 6)
    public void updateIntroductionsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedComments = "Updated Comments of TC 01"+CommentsAdded;
        String strBody = "{\n" +
                "  \"introductionText\": \""+updatedComments+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void deleteProjectAfter_updateIntroductionsByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
