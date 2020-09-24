package com.cpa.search.testcase.dossier;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetDossierByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/dossier/team/";

    @BeforeTest
    public void getProject() {
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
        apiUrl=apiUrl + projectId;
    }
    @Test(priority = 1)
    public void getDossierByProjectId_WithoutTeamMember_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getDossierByProjectId_WithoutTeamMember_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl,"","[]","GET");
    }
    @Test(priority = 3)
    public void getDossierByProjectId_WithTeamMember_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"userEmail\": \"jrana@cpaglobal.com\",\n" +
                "  \"message\": \"\",\n" +
                "  \"sendInvitation\": false\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId+"/shares/users/team","POST",strBody);
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test(priority = 4)
    public void getDossierByProjectId_Validate_UserID() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"userId[0]","d4e42a56-f36b-4fad-8742-580152e0b92d","GET","");
    }
    @Test(priority = 5)
    public void getDossierByProjectId_Validate_firstname() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"firstname[0]","Juhi","GET","");
    }
    @Test(priority = 6)
    public void getDossierByProjectId_Validate_lastname() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"lastname[0]","Rana","GET","");
    }
    @Test(priority = 7)
    public void getDossierByProjectId_Validate_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"email[0]","jrana@cpaglobal.com","GET","");
    }
    @Test(priority = 8)
    public void getDossierByProjectId_Validate_avatar() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"avatar[0]","https://www.gravatar.com/avatar/15ecd2d6db43264c9f13f2e719a22852?d=mp","GET","");
    }
    @Test(priority = 9)
    public void getDossierByProjectId_InValidProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl+"111", "", 404, "GET");
    }
    @Test(priority = 10)
    public void getDossierByProjectId_InValidProjectId_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111","","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","GET");
    }
    @Test(priority = 11)
    public void getDossierByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }
}
