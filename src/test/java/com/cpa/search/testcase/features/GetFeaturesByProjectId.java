package com.cpa.search.testcase.features;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetFeaturesByProjectId extends BootStrap{
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
        apiUrl = apiUrl+projectId+"/features";
    }
    @Test(priority = 1)
    public void getFeaturesByProjectId200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"feature 0\",\n" +
                "      \"order\": 1,\n" +
                "      \"published\": \"2000-06-23T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"text\": \"feature 1\",\n" +
                "      \"order\": 4,\n" +
                "      \"published\": \"2019-05-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"400\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        setResponse(apiUrl,"POST",strBody);
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getFeaturesByProjectId_Validate_text_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"text[0]","feature 0","GET","");
    }
    @Test(priority = 3)
    public void getFeaturesByProjectId_Validate_order_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"order[0]","1","GET","");
    }
    @Test(priority = 4)
    public void getFeaturesByProjectId_Validate_published_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"published[0]","2000-06-23T15:40:44.135+00:00","GET","");
    }
    @Test(priority = 5)
    public void getFeaturesByProjectId_Validate_relatedClaims_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"relatedClaims[0]","001","GET","");
    }
    @Test(priority = 6)
    public void getFeaturesByProjectId_Validate_text_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"text[1]","feature 1","GET","");
    }
    @Test(priority = 7)
    public void getFeaturesByProjectId_Validate_order_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"order[1]","4","GET","");
    }
    @Test(priority = 8)
    public void getFeaturesByProjectId_Validate_published_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"published[1]","2019-05-03T15:40:44.135+00:00","GET","");
    }
    @Test(priority = 9)
    public void getFeaturesByProjectId_Validate_relatedClaims_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"relatedClaims[1]","400","GET","");
    }
    @Test(priority = 10)
    public void getFeaturesByProjectId_ChangeOrder() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"feature order 400\",\n" +
                "      \"order\": 3,\n" +
                "      \"published\": \"2019-01-13T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"4007\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"text\": \"feature order 000\",\n" +
                "      \"order\": 0,\n" +
                "      \"published\": \"2019-07-23T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"001\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 11)
    public void getFeaturesByProjectId_Reorder_Validate_text_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"text[0]","feature order 000","GET","");
    }
    @Test(priority = 12)
    public void getFeaturesByProjectId_Reorder_Validate_order_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"order[0]","0","GET","");
    }
    @Test(priority = 13)
    public void getFeaturesByProjectId_Reorder_Validate_published_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"published[0]","2019-07-23T15:40:44.135+00:00","GET","");
    }
    @Test(priority = 14)
    public void getFeaturesByProjectId_Reorder_Validate_relatedClaims_0() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"relatedClaims[0]","001","GET","");
    }
    @Test(priority = 15)
    public void getFeaturesByProjectId_Reorder_Validate_text_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"text[1]","feature order 400","GET","");
    }
    @Test(priority = 16)
    public void getFeaturesByProjectId_Reorder_Validate_order_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"order[1]","3","GET","");
    }
    @Test(priority = 17)
    public void getFeaturesByProjectId_Reorder_Validate_published_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"published[1]","2019-01-13T15:40:44.135+00:00","GET","");
    }
    @Test(priority = 18)
    public void getFeaturesByProjectId_Reorder_Validate_relatedClaims_1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"relatedClaims[1]","4007","GET","");
    }
    @Test(priority = 19)
    public void getFeaturesByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }

    @AfterTest
    public void deleteProjectAfter_getFeatureByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
