package com.cpa.search.testcase.introductions;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddIntroductionsByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/" + projectId;

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
        apiUrl = apiUrl +projectId ;
    }
    @Test(priority = 1)
    public void AddIntroductionsByProjectId_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction TC - AddIntroductionsByProjectId_201\"\n" +
                "}";
        validateStatusCode(apiUrl + "/introductions", strBody, 201, "POST");
    }

    @Test(priority = 2)
    public void AddIntroductionsByProjectId_InValidProject_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction\"\n" +
                "}";
        validateStatusCode(apiUrl + "sample/introductions", strBody, 404, "POST");
    }

    @Test(priority = 3)
    public void AddIntroductionsByProjectId_InValidProject_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction\"\n" +
                "}";
        validateResponseMessage(apiUrl + "sample/introductions", strBody, "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }

    @Test(priority = 4)
    public void addIntroductionsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + "/introductions", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProjectAfter_addIntroductionsByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }

}
