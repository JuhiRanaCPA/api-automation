package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateNewDeliveryDateByProjectId extends BootStrap{
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
        apiUrl = apiUrl+projectId+"/newdeliveryDate";
    }
    @Test(priority = 1)
    public void updateProjectInfoByProjectId_AllValueUpdate_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:27:35.651Z";
        String strBody = "{\n" +
                "  \"deliveryDate\": \""+date+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 2)
    public void updateProjectInfoByProjectId_ValidateUpdatedDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:27:35.65";
        String strBody = "{\n" +
                "  \"deliveryDate\": \""+date+"1Z\"\n" +
                "}";
        setResponse(apiUrl,"PUT",strBody);
        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId+ "/initialrequest", "deliveryDate", date, "GET", "");
    }

    @Test(priority = 3)
    public void updateProjectInfoByProjectId_InValidRequestData_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:.651Z";
        String strBody = "{\n" +
                "  \"deliveryDate\": \""+date+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "PUT");
    }

    @Test(priority = 4)
    public void updateProjectInfoByProjectId_NUlldate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:.651Z";
        String strBody = "{\n" +
                "  \"deliveryDate\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "PUT");
    }

    @Test(priority = 5)
    public void updateProjectInfoByProjectId_BlanK_date_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:.651Z";
        String strBody = "{\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "PUT");
    }
    @Test(priority = 6)
    public void updateProjectInfoByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = "2020-11-08T11:27:35.651Z";
        String strBody = "{\n" +
                "  \"deliveryDate\": \""+date+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody , BENCHMARK_RESPONSE_TIME, "PUT");

    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }
}
