package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteSearchHistoryEntryByEntryId extends BootStrap{
    String projectId,searchHistoryId, entryId= "";
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
                "  \"description\": \"Search History added (getSearchHistoryId)\"\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/searchhistories","POST",strBody1);
        searchHistoryId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "id[0]", "GET");
        String strBody2 = "{\n" +
                "  \"definitionId\": \"d637d825-d134-4fda-9e5f-0413e4d2a0e7\",\n" +
                "  \"queries\": [\n" +
                "    {\n" +
                "      \"ref\": 4,\n" +
                "      \"query\": \"Query for Google Search\",\n" +
                "      \"results\": 1666,\n" +
                "      \"reviewed\": null\n" +
                "    }\n" +
                "  ],\n" +
                "  \"entryName\": \"Google Search\",\n" +
                "  \"order\": 1\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/searchhistories"+"/"+searchHistoryId,"POST",strBody2);
        entryId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "entries[0].id[0]", "GET");
        apiUrl = apiUrl  + projectId + "/searchhistories"+"/"+searchHistoryId+"/entries/"+entryId;
    }
    @Test(priority = 1)
    public void deleteSearchHistoryEntryByEntryId_InValidProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/projects/dsd" + projectId + "/searchhistories"+"/"+searchHistoryId+"/entries/"+entryId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteSearchHistoryEntryByEntryId_InValidProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(baseURI + "api/projects/dsd" +projectId + "/searchhistories"+"/"+searchHistoryId+"/entries/"+entryId,"","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","DELETE");
    }
    @Test(priority = 3)
    public void deleteSearchHistoryEntryByEntryId_InValidSearchHistoryId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(baseURI + "api/projects/" + projectId + "/searchhistories"+"/dfd"+searchHistoryId+"/entries/"+entryId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteSearchHistoryEntryByEntryId_InValidSearchHistoryId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(baseURI + "api/projects/" + projectId + "/searchhistories"+"/dfd"+searchHistoryId, "","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","DELETE");
    }
    @Test(priority = 5)
    public void deleteSearchHistoryEntryByEntryId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 5)
    public void deleteSearchHistoryEntryByEntryId_DeletedSearchHistoryId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 6)
    public void deleteSearchHistoryEntryByEntryId_DeletedSearchHistoryId_ResponseMessage() {
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
