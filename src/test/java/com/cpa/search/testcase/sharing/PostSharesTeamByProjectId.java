package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PostSharesTeamByProjectId extends BootStrap{
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
    String apiUrl = baseURI + "api/projects/"+projectId+"/shares/users/team";

    @Test(priority = 1)
    public void postSharesTeamInvalidEmail_ResponseCode(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"ssampleemailfortestingabc@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postSharesTeamInvalidEmail_ResponseMessage_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"ssampleemailfortestingabc@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"message","User with email ssampleemailfortestingabc@nomail.example.com not found.","POST",strBody);
    }
    @Test(priority = 3)
    public void postSharesTeamInvalidEmail_ResponseMessage_Type(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"ssampleemailfortestingabc@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"type","warning","POST",strBody);
    }
    @Test(priority = 4)
    public void postSharesTeam200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"perry.coleman@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void postSharesTeam_IPPU_500(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"walter.white@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }
    @Test(priority = 5)
    public void postSharesTeam_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"perry.coleman@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
