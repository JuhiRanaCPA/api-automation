package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteUsersByGroupId extends BootStrap{
    String projectCaseNo = "AddProject" + generateRandom(5);
    String date = getCurrentDate("yyyy-MM-dd");
    String shareID, shareMemberId,groupId, projectId="";
    String apiUrl = baseURI + "api/projects/";

    @BeforeTest
    public void CreateProjectAddGroup() throws InterruptedException {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
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
                "  \"title\": \"DeleteUsersByGroupId Add Group for TC\",\n" +
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
        groupId = getValueFromResponse(baseURI + "api/groups", strBody1, "id", "POST");
        strBody = "{\n" +
                "  \"groupId\": \""+groupId+"\"\n" +
                "}";
        setResponse(baseURI + "api/projects/"+projectId+"/shares/group/team", "POST", strBody);
        Thread.sleep(8000);
        shareID = getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/team","","shareId[0]","GET");
        shareMemberId=  getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/team","","members[0].shareMemberId[0]","GET");
        apiUrl= apiUrl + projectId+ "/shares/"+shareID+"/members/"+shareMemberId+"/group/"+groupId;
    }
    @Test(priority = 1)
    public void deleteUsersByGroupId_InValidProjectID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");

        validateStatusCode( baseURI + "api/projects/" + projectId + "xcxxc/shares/"+shareID+"/members/"+shareMemberId+"/group/"+groupId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteUsersByGroupId_InValidProjectID_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "xcxxc/shares/"+shareID+"/members/"+shareMemberId+"/group/"+groupId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteUsersByGroupId_InValidShareId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"hgh/members/"+shareMemberId+"/group/"+groupId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteUsersByGroupId_InValidShareId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"ghg/members/"+shareMemberId+"/group/"+groupId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 5)
    public void deleteUsersByGroupId_InValidShareMemberID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"fggff/group/"+groupId, "", 404, "DELETE");
    }
    @Test(priority = 6)
    public void deleteUsersByGroupId_InValidShareMemberID_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"hggg/group/"+groupId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 7)
    public void deleteUsersByGroupId_InValidUserId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"/group/gfhfgh"+groupId, "", 404, "DELETE");
    }
    @Test(priority = 8)
    public void deleteUsersByGroupId_InValidUserId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"/group/fghfh"+groupId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 9)
    public void deleteUsersByGroupId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 10)
    public void deleteUsersByGroupId_DeletedExperience_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 11)
    public void deleteUsersByGroupId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
        setResponse(baseURI + "api/groups/"+groupId,"DELETE","");
    }
}
