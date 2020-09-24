package com.cpa.search.testcase.searchHistory;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateSearchHistoryEntryByEntryId extends BootStrap{
    String projectId,searchHistoryId,entryId, query = "";
      String apiUrl = baseURI + "api/projects/";
    String ref = "15";
    String results ="187222";
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
        String strBody3 = "{\n" +
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
        setResponse(baseURI + "api/projects/" + projectId + "/searchhistories"+"/"+searchHistoryId,"POST",strBody3);
        entryId= getValueFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "entries[0].id[0]", "GET");
        apiUrl = apiUrl + projectId + "/searchhistories"+"/"+searchHistoryId+"/entries/"+entryId;
        query ="Updated Values: "+entryId;
    }
    @Test(priority = 1)
    public void updateSearchHistoryEntryBySearchHistoryId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"definitionId\": \"d637d825-d134-4fda-9e5f-0413e4d2a0e7\",\n" +
                "  \"queries\": [\n" +
                "    {\n" +
                "      \"ref\": "+ref+",\n" +
                "      \"query\": \""+query+"\",\n" +
                "      \"results\": \""+results+"\",\n" +
                "      \"reviewed\": null\n" +
                "    }\n" +
                "  ],\n" +
                "  \"entryName\": \"Google Search\",\n" +
                "  \"order\": 1\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }
    @Test(priority = 2)
    public void updateSearchHistoryEntryBySearchHistoryId_Validate_queries_Ref() {
        String actualResult = "Fail";
        String expectedResult = "Pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
         List<String> actualValue = getAllValuesFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "entries[0].queries[0]", "GET");
        log.info("<====================actualValue : " + actualValue + "====================>");
        if (actualValue.get(0).contains(ref)) {
            actualResult = "Pass";
        }
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test(priority =3)
    public void updateSearchHistoryEntryBySearchHistoryId_Validate_queries_query() {
        String actualResult = "Fail";
        String expectedResult = "Pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> actualValue = getAllValuesFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "entries[0].queries[0]", "GET");
        log.info("<====================actualValue : " + actualValue + "====================>");
        if (actualValue.get(0).contains(query)) {
            actualResult = "Pass";
        }
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test(priority = 4)
    public void updateSearchHistoryEntryBySearchHistoryId_Validate_queries_Results() {
        String actualResult = "Fail";
        String expectedResult = "Pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> actualValue = getAllValuesFromResponse(baseURI + "api/projects/" + projectId + "/searchhistories", "", "entries[0].queries[0]", "GET");
        log.info("<====================actualValue : " + actualValue + "====================>");
        if (actualValue.get(0).contains(results)) {
            actualResult = "Pass";
        }
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test(priority = 5)
    public void updateSearchHistoryEntryBySearchHistoryId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"definitionId\": \"d637d825-d134-4fda-9e5f-0413e4d2a0e7\",\n" +
                "  \"queries\": [\n" +
                "    {\n" +
                "      \"ref\": "+ref+",\n" +
                "      \"query\": \""+query+"\",\n" +
                "      \"results\": \""+results+"\",\n" +
                "      \"reviewed\": null\n" +
                "    }\n" +
                "  ],\n" +
                "  \"entryName\": \"Google Search\",\n" +
                "  \"order\": 1\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
