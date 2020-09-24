package com.cpa.search.testcase.links;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteLinksByLinkId extends BootStrap{
    String projectId = "";
    String linkedProject = "d6a0756b-522b-46e4-b12f-965df2a43820";
    String linkId = "";
    String apiUrl = baseURI + "api/projects/";
    @BeforeTest
    public void addComment() {
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
                "  \"linkedProjectId\": \""+linkedProject+"\"\n" +
                "}";
        validateStatusCode( baseURI + "api/projects/"+projectId+"/links", strBody1, 200, "POST");
        linkId= getValueFromResponse(baseURI + "api/projects/"+projectId+"/links","","id[0]","GET");
        apiUrl = apiUrl +projectId+"/links/"+linkId;
    }
    @Test(priority = 1)
    public void deleteLinksByLinkId_InValidProject_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"sdsd", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteLinksByLinkId_InValidProject_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteLinksByLinkId__200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteLinksByLinkId__DeletedlinkedFeatureId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 5)
    public void deleteLinksByLinkId__ResponseTime() {
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");

    }
    @Test(priority = 6)
    public void deleteProjectAfter_deleteLinksByLinkId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
