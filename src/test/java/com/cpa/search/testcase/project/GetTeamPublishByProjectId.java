package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetTeamPublishByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";

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
        apiUrl = apiUrl + projectId + "/teampublished";
    }

    @Test(priority = 1)
    public void getTeamPublishByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 2)
    public void getTeamPublishByProjectId_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl, "", "false", "GET");
    }

    @Test(priority = 3)
    public void getTeamPublishByProjectId_After_TeamPublished_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/publish", "POST", strBody);
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 4)
    public void getTeamPublishByProjectId_After_TeamPublished_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl, "", "true", "GET");
    }

    @Test(priority = 5)
    public void getTeamPublishByProjectId_After_Team_UnPublished_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "  ]\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/publish", "POST", strBody);
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 6)
    public void getTeamPublishByProjectId_After_Team_UnPublished_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl, "", "false", "GET");
    }

    @Test(priority = 7)
    public void getTeamPublishByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");

    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
