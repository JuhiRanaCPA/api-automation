package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostSharesGroupTeamByProjectId extends BootStrap{
    String groupId ;
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
    String apiUrl = baseURI + "api/projects/"+projectId+"/shares/group/team";
    @BeforeTest
    public void addGroupId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"AddGroup for TC\",\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "      \"firstname\": \"Jesse\",\n" +
                "      \"lastname\": \"Pinkman\",\n" +
                "      \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
                "      \"isDirector\": true,\n" +
                "      \"userStatusView\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        groupId = getValueFromResponse(baseURI + "api/groups", strBody, "id", "POST");
    }
    @Test(priority = 1)
    public void postSharesGroupTeam_InvalidGroupId_ResponseCode(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"groupId\": \""+groupId+"abcjhhs\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
      @Test(priority = 2)
    public void postSharesGroupTeam_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"groupId\": \""+groupId+"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 3)
    public void postSharesGroupTeam_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"groupId\": \""+groupId+"\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void deleteProjectAndGroupId(){
        setResponse(baseURI + "api/groups/"+groupId,"DELETE","");
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");

    }



}
