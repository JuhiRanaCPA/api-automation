package com.cpa.search.testcase.features;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class UpdateFeaturesByProjectId extends BootStrap{
    /* commenting testcases as of now, because PUT is not being used in application, Dev will check and will look into it after some time */

//    String projectId = getProjectId();
//    String featureId = getFeatureId(projectId);
//    String apiUrl = baseURI + "api/projects/" + projectId + "/features/" + featureId;
//
//    @Test(priority = 1)
//    public void updateFeaturesByProjectId_InValid_Request_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"features\": [\n" +
//                "    {\n" +
//                "      \"text\": \"Feature 1\",\n" +
//                "      \"order\": ,\n" +
//                "      \"published\": \"2019-12-03T15:40:44.135Z\",\n" +
//                "      \"relatedClaims\": \"sample text relatedclaims\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//        validateStatusCode(apiUrl, strBody, 400, "PUT");
//    }
//    @Test(priority = 2)
//    public void updateFeaturesByProjectId_Blank_order_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"text\": \"Feature 1\",\n" +
//                "  \"order\": ,\n" +
//                "  \"relatedClaims\": \"sample text relatedclaims\"\n" +
//                "}";
//             validateStatusCode(apiUrl, strBody, 400, "PUT");
//    }
//    @Test(priority = 3)
//    public void updateFeaturesByProjectId_Blank_text_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"text\": \"\",\n" +
//                "  \"order\": 1,\n" +
//                "  \"relatedClaims\": \"sample text relatedclaims\"\n" +
//                "}";
//        validateStatusCode(apiUrl, strBody, 400, "PUT");
//    }
//     @Test(priority = 4)
//    public void updateFeaturesByProjectId_200() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//         String strBody ="{\n" +
//                 "  \"text\": \"Update Feature 1\",\n" +
//                 "  \"order\": 11,\n" +
//                 "  \"relatedClaims\": \"Updated sample text relatedclaims\"\n" +
//                 "}";
//        validateStatusCode(apiUrl, strBody, 200, "PUT");
//    }
//    @Test(priority = 5)
//    public void updateFeaturesByProjectId_Validate_text_0() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId + "/features","text[0]","Update Feature 1","GET","");
//    }
//    @Test(priority = 6)
//    public void updateFeaturesByProjectId_Validate_order_0() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId + "/features","order[0]","11","GET","");
//    }
//    @Test(priority = 8)
//    public void updateFeaturesByProjectId_Validate_relatedClaims_0() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId + "/features","relatedClaims[0]","sUpdated sample text relatedclaims","GET","");
//    }
//    @Test(priority = 9)
//    public void updateFeaturesByProjectId_ResponseTime() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"text\": \"Update Feature 1\",\n" +
//                "  \"order\": 11,\n" +
//                "  \"relatedClaims\": \"Updated sample text relatedclaims\"\n" +
//                "}";
//        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
//    }
//
//    @Test(priority = 20)
//    public void deleteFeaturesByProjectId(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
//    }
}


