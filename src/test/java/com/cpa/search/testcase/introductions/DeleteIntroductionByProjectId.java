package com.cpa.search.testcase.introductions;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteIntroductionByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String introductionId ="";
    @BeforeTest
    public void addProjectId() {
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
        apiUrl = apiUrl + projectId + "/introductions";
    }
    @Test(priority = 1)
    public void deleteIntroductionByProejctId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");

        String comments = "Add Comments of TC 01";
        String strBody = "{\n" +
                "  \"introductionText\": \""+comments+"\"\n" +
                "}";
        introductionId = getValueFromResponse(apiUrl, strBody, "id", "POST");
        validateStatusCode(apiUrl+"/"+introductionId, "", 200, "DELETE");
    }
    @Test(priority = 2)
    public void deleteIntroductionByProejctId_ResponseMessage(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");

        String comments = "Add Comments of TC 02";
        String strBody = "{\n" +
                "  \"introductionText\": \""+comments+"\"\n" +
                "}";
        introductionId = getValueFromResponse(apiUrl, strBody, "id", "POST");
        validateResponseMessage(apiUrl+"/"+introductionId,"","","DELETE");
    }
    @Test(priority = 3)
    public void deleteIntroductionByProejctId_DeletedIntroduction_404(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+"/"+introductionId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteIntroductionByProjectId_ResponseTime() {
        String comments = "Add Comments of TC 03";
        String strBody = "{\n" +
                "  \"introductionText\": \""+comments+"\"\n" +
                "}";
        String introductionId = getValueFromResponse(apiUrl, strBody, "id", "POST");
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+"/"+introductionId, "", BENCHMARK_RESPONSE_TIME, "DELETE");

    }
    @AfterTest
    public void deleteProjectAfter_addIntroductionsByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}