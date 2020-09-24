package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GetProjectById extends BootStrap{
        String projectCaseNo = "AddProject" + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
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
                "  \"startDate\": \""+date+"\"\n" +
                "}";

    String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
     String apiUrl = baseURI + "api/projects/"+projectId;

    @Test(priority = 1)
    public void getProjectById_GetValidData_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 2)
    public void getProjectById_ValidateResponse_MandatoryField_Id() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id", projectId, "GET", "");
    }

    @Test(priority = 4)
    public void getProjectById_MissingHeaderCase_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newApiUrl = apiUrl + "/project/";
        validateStatusCode(newApiUrl, "", 404, "GET");
    }


    @Test(priority = 5)
    public void getProjectById_MissingHeaderCase_404_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newApiUrl = apiUrl + "/project/";
        validateResponseMessage(newApiUrl, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }

    @Test(priority = 6)
    public void getProjectById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }

}
