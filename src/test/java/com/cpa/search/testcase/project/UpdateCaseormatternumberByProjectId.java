package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateCaseormatternumberByProjectId extends BootStrap{
    String projectId = "";
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
        apiUrl = apiUrl+ projectId+"/caseormatternumber";;
    }
    @Test(priority = 1)
    public void updateCaseormatternumberByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_200 "+projectId;
        String strBody = "{  \"value\": \""+updatedValue+"\"}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 2)
    public void updateCaseormatternumberByProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_ResponseMessage "+projectId;
        String strBody = "{\"value\":\""+updatedValue+"\"}";
        validateResponseMessage(apiUrl,strBody, "\""+updatedValue+"\"","PUT");
    }

    @Test(priority = 3)
    public void updateCaseormatternumberByInValid_ProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_200 "+projectId+"/caseormatternumber";
        String strBody = "{\"value\":\""+updatedValue+"\"}";
        validateStatusCode(apiUrl+"invalidPeojectId", strBody, 404, "PUT");
    }

    @Test(priority = 4)
    public void updateCaseormatternumberByInValid_ProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_ResponseMessage "+projectId+"/caseormatternumber";
        String strBody = "{\"value\":\""+updatedValue+"\"}";
        validateResponseMessage(apiUrl+"invalidPeojectId",strBody, "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","PUT");
    }

    @Test(priority = 5)
    public void updateCaseormatternumberByProjectId_Validate_CaseMatterValue() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_Validate_CaseMatterValue "+projectId;
        String strBody = "{\"value\":\""+updatedValue+"\"}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId,"caseOrMatterNumber",updatedValue,"GET","");

        //validateResponseMessage(apiUrl,strBody, updatedValue,"PUT");
    }

    @Test(priority = 6)
    public void updateCaseormatternumberByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String updatedValue = "UpdateCaseormatternumberByProjectId_ResponseTime "+projectId;
        String strBody = "{\"value\":\""+updatedValue+"\"}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");

    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }

}


