package com.cpa.search.testcase.links;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddLinksByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    String linkedProject = "d6a0756b-522b-46e4-b12f-965df2a43820";

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
        apiUrl = apiUrl +projectId+"/links";
    }
    @Test(priority = 1)
    public void addLinksByProjectId_Blank_LinkedProjectId_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"linkedProjectId\": \"\"\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 400, "POST");
    }
    @Test(priority = 2)
    public void addLinksByProjectId_InValid_LinkedProjectId_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"linkedProjectId\": \"sdsddsd\"\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 400, "POST");
    }
    @Test(priority = 3)
    public void addLinksByProjectId_Valid_LinkedProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"linkedProjectId\": \""+linkedProject+"\"\n" +
                "}";
        validateStatusCode( apiUrl, strBody, 200, "POST");
    }
//    @Test(priority = 4)
//    public void addLinksByProjectId_AlreadyLink_LinkedProjectId_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"linkedProjectId\": \""+linkedProject+"\"\n" +
//                "}";
//        validateStatusCode( apiUrl, strBody, 400, "POST");
//    }
    @Test(priority = 5)
    public void addLinksByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"linkedProjectId\": \""+linkedProject+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @Test(priority = 6)
    public void deleteProjectAfter_addLinksByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
