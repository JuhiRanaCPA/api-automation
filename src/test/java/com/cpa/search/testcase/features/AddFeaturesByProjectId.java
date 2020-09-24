package com.cpa.search.testcase.features;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddFeaturesByProjectId extends BootStrap{
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
        apiUrl = apiUrl+projectId+"/features";
    }
    @Test(priority = 1)
    public void addFeaturesByProjectId_Blank_text_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"\",\n" +
                "      \"order\": 1,\n" +
                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void addFeaturesByProjectId_Blank_textResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"\",\n" +
                "      \"order\": 1,\n" +
                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 3)
    public void addFeaturesByProjectId_Blank_order_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"Feature 1\",\n" +
                "      \"order\": ,\n" +
                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 400, "POST");
    }
    @Test(priority = 4)
    public void addFeaturesByProjectId_InValid_published_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"Feature 1\",\n" +
                "      \"order\": 1,\n" +
                "      \"published\": \"2019-45-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 400, "POST");
    }
    @Test(priority = 5)
    public void addFeaturesByProjectId_Blank_published_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"Feature 1\",\n" +
                "      \"order\": 2,\n" +
                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void addFeaturesByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"Feature 1\",\n" +
                "      \"order\": 2,\n" +
                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 7)
    public void addFeaturesByProjectId_SameOrder_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"feature 0\",\n" +
                "      \"order\": 0,\n" +
                "      \"published\": \"\",\n" +
                "      \"relatedClaims\": \"001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"text\": \"feature 0\",\n" +
                "      \"order\": 0,\n" +
                "      \"published\": \"\",\n" +
                "      \"relatedClaims\": \"001\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 8)
    public void addFeaturesByProjectId_ResponseTime() {
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
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @Test(priority =9 )
    public void deleteProjectAfter_addFeatureByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
