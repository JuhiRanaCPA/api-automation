package com.cpa.search.testcase.links;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostSearchProjectsForLinks  extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String strBody = "{\n" +
            "  \"text\": \"testAPI_109999\",\n" +
            "  \"limit\": 10,\n" +
            "  \"offset\": 0\n" +
            "}";
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
        apiUrl = apiUrl +projectId+"/links/search";
    }
    @Test(priority = 1)
    public void postSearchProjectsForLinks_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postSearchProjectsForLinks_Validate_ResultCount_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"resultCount","1", "POST",strBody);
    }
    @Test(priority = 3)
    public void postSearchProjectsForLinks_Validate_caseOrMatterNumber_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"result[0].caseOrMatterNumber","DO_NOT_DELETE", "POST",strBody);
    }
    @Test(priority = 4)
    public void postSearchProjectsForLinks_Validate_cpaReferenceNumber_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"result[0].cpaReferenceNumber","testAPI_109999", "POST",strBody);
    }
    @Test(priority = 5)
    public void postSearchProjectsForLinks_Blank_Text_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void postSearchProjectsForLinks_Invalid_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        strBody = "{\n" +
                "  \"limit\": 20\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 500, "POST");
    }
    @Test(priority = 7)
    public void postSearchProjectsForLinks_O_Limit_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        strBody = "{\n" +
                "  \"text\": \"1000\",\n" +
                "  \"limit\": 0\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 8)
    public void postSearchProjectsForLinks_O_Limit_ResultCount_Response() {
        String actualresult = "fail";
        String expectedResult ="pass";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        strBody = "{\n" +
                "  \"text\": \"\",\n" +
                "  \"limit\": 0\n" +
                "}";
      int resultcount=  getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
       if(resultcount>=1){
           actualresult="pass";
                  }
        Assert.assertEquals(actualresult, expectedResult);
    }
    @Test(priority = 9)
    public void postSearchProjectsForLinks_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @Test(priority = 10)
    public void deleteProjectAfter_postSearchProjectsForLinks(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }

}
