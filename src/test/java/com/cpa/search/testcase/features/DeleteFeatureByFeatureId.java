package com.cpa.search.testcase.features;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteFeatureByFeatureId extends BootStrap{
    String projectId,featureId = "";
    String apiUrl = baseURI + "api/projects/" ;
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
                "  \"features\": [\n" +
                "    {\n" +
                "      \"text\": \"Add Feature 1\",\n" +
                "      \"order\": 2,\n" +
                "      \"relatedClaims\": \"100000\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        setResponse( baseURI + "api/projects/"+projectId+"/features",  "POST",strBody1);
        featureId= getValueFromResponse(baseURI + "api/projects/"+projectId+"/features","","id[0]","GET");
        apiUrl = apiUrl + projectId + "/features/" + featureId ;
    }
    @Test(priority = 1)
    public void deleteFeatureByFeatureId_InValidFeatureId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"122", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteFeatureByFeatureId_InValidFeatureId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteFeatureByFeatureId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteFeatureByFeatureId_DeletedFeatureId_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 500, "DELETE");
    }
    @Test(priority = 5)
    public void deleteFeatureByFeatureId_ResponseTime() {
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
    @Test(priority = 6)
    public void deleteProjectAfter_getFeatureByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
