package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSearchHistoryEntryBySearchHistoryId extends BootStrap{
    String projectId ="";
    String searchHistoryId = "";
      String apiUrl = baseURI + "api/projects/";
     String entryId = "";
    @BeforeTest
    public void getProject() {
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
        apiUrl = apiUrl  + projectId + "/searchhistories"+"/"+searchHistoryId;
    }
    @Test(priority = 1)
    public void addSearchHistoryEntryBySearchHistoryId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
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
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void addSearchHistoryEntryBySearchHistoryId_InvalidDefinationId_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"definitionId\": \"d637d825-d134-4fda-9e5f-0413e4d2a0e7ds\",\n" +
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
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
    @Test(priority = 3)
    public void addSearchHistoryEntryBySearchHistoryId_InvalidDefinationId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"definitionId\": \"d637d825-d134-4fda-9e5f-0413e4d2a0e7ds\",\n" +
                "  \"entryName\": \"Google Search\"\n" +
                "}";
        validateStatusCode(apiUrl+"/"+searchHistoryId, strBody, 404, "POST");
    }
    @Test(priority = 4)
    public void addSearchHistoryEntryBySearchHistoryId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
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
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
