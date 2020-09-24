package com.cpa.search.testcase.communication;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCommunicationByProjectId extends BootStrap{
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
        apiUrl = apiUrl +projectId+"/communication" ;
    }
    @Test
    public void getCommunicationByProjectId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test
    public void getCommunicationByProjectId_ValidateResponse() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValuesFromResponse(apiUrl, "projectId", projectId, "GET", "");
    }

    @Test
    public void getCommunicationByInvalid_ProjectId_404(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String urlWithprojectId= apiUrl+"2323";
        validateStatusCode(urlWithprojectId, "", 404, "GET");
    }
    @Test
    public void getCommunicationByInvalid_ProjectId_Validate_ResponseMessage(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String urlWithprojectId= apiUrl+"323";
        validateResponseMessage(urlWithprojectId,"","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","GET");
    }
    @Test
    public void getCommunicationByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");

    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
