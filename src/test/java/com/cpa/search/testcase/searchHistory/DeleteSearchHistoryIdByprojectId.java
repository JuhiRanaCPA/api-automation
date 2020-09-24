package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteSearchHistoryIdByprojectId extends BootStrap{
    String projectId = "";
    String searchHistoryId = "";
      String apiUrl = baseURI + "api/projects/";
     String entryId = "";

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
        String strBody1 = "{\n" +
                "  \"description\": \"Search History added (getSearchHistoryId)\"\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/searchhistories","POST",strBody1);
        searchHistoryId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "id[0]", "GET");
        apiUrl = apiUrl + projectId + "/searchhistories"+"/"+searchHistoryId;
    }
    @Test(priority = 1)
    public void deleteSearchHistoryIdByprojectId_InValidProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/projects/dsd" + projectId + "/searchhistories"+"/"+searchHistoryId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteSearchHistoryIdByprojectId_InValidProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(baseURI + "api/projects/dsd" + projectId + "/searchhistories"+"/"+searchHistoryId,"","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","DELETE");
    }
    @Test(priority = 3)
    public void deleteSearchHistoryIdByprojectId_InValidSearchHistoryId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/projects/" + projectId + "/searchhistories"+"/dfd"+searchHistoryId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteSearchHistoryIdByprojectId_InValidSearchHistoryId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(baseURI + "api/projects/" + projectId + "/searchhistories"+"/dfd"+searchHistoryId, "","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","DELETE");
    }
    @Test(priority = 5)
    public void deleteSearchHistoryIdByprojectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 5)
    public void deleteSearchHistoryIdByprojectId_DeletedSearchHistoryId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 6)
    public void deleteSearchHistoryIdByprojectId_DeletedSearchHistoryId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"type","RESOURCE_NOT_FOUND","DELETE","");
         }
    @Test(priority = 7)
    public void getSearchHistoriesByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
