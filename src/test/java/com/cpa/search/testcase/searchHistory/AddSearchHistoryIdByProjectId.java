package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSearchHistoryIdByProjectId extends BootStrap{
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
        apiUrl = apiUrl+ projectId + "/searchhistories";;
    }
    @Test(priority = 1)
    public void addSearchHistoryByProjectId_CreateProject_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"SearchHistory added in TC1\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void addSearchHistoryByProjectId_Validate_description_Added_SearchHistory() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "SearchHistory added in TC1", "GET", "");
    }
    @Test(priority = 3)
    public void addSearchHistoryByProjectId_Invalid_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"SearchHistory added in TC1\"\n" +
                "}";
        validateStatusCode(apiUrl + "1882", strBody, 404, "POST");
    }

    @Test(priority = 4)
    public void addSearchHistoryByProjectId_CreateProject_Invalid_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"SearchHistory added in TC1\"\n" +
                "}";
        validateResponseMessage(apiUrl + "1882", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }

    @Test(priority = 5)
    public void addSearchHistoryByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"description\": \"SearchHistory added in TC1\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
