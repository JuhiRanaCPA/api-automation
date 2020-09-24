package com.cpa.search.testcase.links;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetLinksByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String linkedProject = "d6a0756b-522b-46e4-b12f-965df2a43820";
    @BeforeTest
    public void addProjectId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
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
        projectId=  getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl=apiUrl+ projectId+"/links";
    }
    @Test(priority = 1)
    public void getLinksByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 3)
    public void getLinksByProjectId_AfterLinkProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"linkedProjectId\": \""+linkedProject+"\"\n" +
                "}";
        setResponse(baseURI + "api/projects/"+projectId+"/links","POST",strBody);
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 4)
    public void getLinksByProjectId_ProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"project.id[0]",projectId, "GET","");
    }
    @Test(priority = 5)
    public void getLinksByProjectId_linkedProject_Id__ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"linkedProject.id[0]",linkedProject, "GET","");
    }
    @Test(priority = 6)
    public void getLinksByProjectId_Linked_Project_caseOrMatterNumber_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"linkedProject.caseOrMatterNumber[0]","DO_NOT_DELETE", "GET","");
    }
    @Test(priority = 7)
    public void getLinksByProjectId_Linked_Project_cpaReferenceNumber_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"linkedProject.cpaReferenceNumber[0]","1000", "GET","");
    }
    @Test(priority = 8)
    public void getLinksByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 10)
    public void deleteProjectAfter_getLinksByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
