package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteShareUserById extends BootStrap{
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

    String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
    String shareID ="";
    String shareMemberId ="";
    String userId = "";
    String apiUrl = baseURI + "api/projects/" + projectId;

    @BeforeTest
    public void addUsersProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"perry.coleman@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": true\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/shares/users/owner", "POST", strBody);
        strBody = "{\n" +
                "  \"userEmail\": \"walter.white@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": true\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/shares/users/owner", "POST", strBody);
    shareID = getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","shareId[0]","GET");
    shareMemberId=  getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","members[0].shareMemberId[0]","GET");
    userId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","members[0].user[0].id","GET");
    apiUrl= apiUrl + "/shares/"+shareID+"/members/"+shareMemberId+"/user/"+userId;
    }
    @Test(priority = 1)
    public void deleteShareUserById_InValidprojectID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "xcxxc/shares/"+shareID+"/members/"+shareMemberId+"/user/"+userId, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteShareUserById_InValidprojectID_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "xcxxc/shares/"+shareID+"/members/"+shareMemberId+"/user/"+userId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteShareUserById_InValidShareId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"hgh/members/"+shareMemberId+"/user/"+userId, "", 404, "DELETE");
    }
    @Test(priority = 4)
    public void deleteShareUserById_InValidShareId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"ghg/members/"+shareMemberId+"/user/"+userId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 5)
    public void deleteShareUserById_InValidShareMemberID_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"fggff/user/"+userId, "", 404, "DELETE");
    }
    @Test(priority = 6)
    public void deleteShareUserById_InValidShareMemberID_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"hggg/user/"+userId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 7)
    public void deleteShareUserById_InValidUserId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"/user/gfhfgh"+userId, "", 404, "DELETE");
    }
    @Test(priority = 8)
    public void deleteShareUserById_InValidUserId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( baseURI + "api/projects/" + projectId + "/shares/"+shareID+"/members/"+shareMemberId+"/user/fghfh"+userId, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 9)
    public void deleteShareUserById_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 10)
    public void deleteShareUserById_DeletedExperience_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 404, "DELETE");
    }
    @Test(priority = 11)
    public void deleteExperience_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        strBody = "{\n" +
                "  \"userEmail\": \"walter.white@nomail.example.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": true\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/shares/users/owner", "POST", strBody);
        shareID = getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","shareId[0]","GET");
        shareMemberId=  getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","members[0].shareMemberId[0]","GET");
        userId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/shares/owner","","members[0].user[0].id","GET");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
