package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UpdateProjectInfoByProjectId extends BootStrap{
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
        apiUrl = apiUrl +projectId+"/projectinfo";
    }
    @Test(priority = 1)
    public void updateProjectInfoByProjectId_AllValueUpdate_200() {

        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
                "  \"projectTitle\": \"Prj Title_TC_1\",\n" +
                "  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\",\n" +
                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
                "  \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\",\n" +
                "  \"contactCodeForeign\": null,\n" +
                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 2)
    public void updateProjectInfoByProjectId_AllValueUpdate_ResponseMessage() {
        String projectTitle = "Prj Title_TC_2";

        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
                "  \"projectTitle\": \""+projectTitle+"\",\n" +
                "  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\",\n" +
                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
                "  \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\",\n" +
                "  \"contactCodeForeign\": null,\n" +
                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
                "}";
        validateResponseMessage(apiUrl, strBody, "\""+projectTitle+"\"", "PUT");
    }
    @Test(priority = 3)
    public void updateProjectInfoByProjectId_Blank_Mandatory_organizationUid_400() {

        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
                "  \"projectTitle\": \"Prj Title_TC_1\",\n" +
                "  \"organizationUid\": \"\",\n" +
                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
                "  \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\",\n" +
                "  \"contactCodeForeign\": null,\n" +
                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "PUT");
    }

//    @Test(priority = 4)
//    public void updateProjectInfoByProjectId_Blank_Mandatory_organizationUid_ResponseMessage() {
//        String projectTitle = "Prj Title_TC_2";
//
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
//                "  \"projectTitle\": \""+projectTitle+"\",\n" +
//                "  \"organizationUid\": \"a\",\n" +
//                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
//                "  \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\",\n" +
//                "  \"contactCodeForeign\": null,\n" +
//                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
//                "}";
//        validateResponseMessage(apiUrl, strBody, "", "PUT");
//    }

@Test(priority = 5)
public void updateProjectInfoByProjectId_Blank_Mandatory_ProjectOwner_400() {

    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    String strBody = "{\n" +
            "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
            "  \"projectTitle\": \"Prj Title_TC_1\",\n" +
            "  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\",\n" +
            "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
            "  \"projectOwner\": \"\",\n" +
            "  \"contactCodeForeign\": null,\n" +
            "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
            "}";
    validateStatusCode(apiUrl, strBody, 400, "PUT");
}

//    @Test(priority = 6)
//    public void updateProjectInfoByProjectId_Blank_Mandatory_ProjectOwner_ResponseMessage() {
//        String projectTitle = "Prj Title_TC_2";
//
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
//                "  \"projectTitle\": \""+projectTitle+"\",\n" +
//                "  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\",\n" +
//                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
//                "  \"projectOwner\": \"\",\n" +
//                "  \"contactCodeForeign\": null,\n" +
//                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents\"\n" +
//                "}";
//        validateResponseMessage(apiUrl, strBody, "null", "PUT");
//    }
@Test(priority = 7)
public void updateProjectInfoByProjectId_CpaReferenceNumberOnly_200() {

    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    String strBody = "{\"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\"}";
    validateStatusCode(apiUrl, strBody, 200, "PUT");
}

    @Test(priority = 8)
    public void updateProjectInfoByProjectId_CpaReferenceNumberOnly_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\"}";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }
    @Test(priority = 9)
    public void updateProjectInfoByProjectId_ProjectTitleOnly_200() {
        String projectTitle = "Prj Title_TC_9";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\"projectTitle\": \""+projectTitle+"\"}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 10)
    public void updateProjectInfoByProjectId_ProjectTitleOnly_ResponseMessage() {
        String projectTitle = "Prj Title_TC_10";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\"projectTitle\": \""+projectTitle+"\"}";
        validateResponseMessage(apiUrl, strBody, "\""+projectTitle+"\"", "PUT");
    }

    @Test(priority = 11)
    public void updateProjectInfoByProjectId_OrganizationUidOnly_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\" }";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 12)
    public void updateProjectInfoByProjectId_OrganizationUidOnly_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\" }";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }
    @Test(priority = 13)
    public void updateProjectInfoByProjectId_CompanyNameOnly_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"companyName\": \"ABC Telecom AB (AutoGen)\"}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 14)
    public void updateProjectInfoByProjectId_CompanyNameOnly_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"companyName\": \"ABC Telecom AB (AutoGen)\"}";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }
    @Test(priority = 15)
    public void updateProjectInfoByProjectId_ProjectOwnerOnly_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\"}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 16)
    public void updateProjectInfoByProjectId_ProjectOwnerOnly_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\"}";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }
    @Test(priority = 17)
    public void updateProjectInfoByProjectId_ContactCodeForeign_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"contactCodeForeign\": null}";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 18)
    public void updateProjectInfoByProjectId_ContactCodeForeign_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"contactCodeForeign\": null}";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }
    @Test(priority = 19)
    public void updateProjectInfoByProjectId_TargetPatents_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"targetPatents\": \"Targgsd PAtent_ Tc 19\" }";
        validateStatusCode(apiUrl, strBody, 200, "PUT");
    }

    @Test(priority = 20)
    public void updateProjectInfoByProjectId_TargetPatents_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"targetPatents\": \"Targgsd PAtent_ Tc 20\" }";
        validateResponseMessage(apiUrl, strBody, "null", "PUT");
    }

    @Test(priority = 21)
    public void addProject_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"cpaReferenceNumber\": \""+generateRandom(3)+" Updated\",\n" +
                "  \"projectTitle\": \"Prj Title_TC_1\",\n" +
                "  \"organizationUid\": \"a9f8cc91-4d4b-4d92-b2ad-bd999eeab3b5\",\n" +
                "  \"companyName\": \"ABC Telecom AB (AutoGen)\",\n" +
                "  \"projectOwner\": \"d4e42a56-f36b-4fad-8742-580152e0b92d\",\n" +
                "  \"contactCodeForeign\": null,\n" +
                "  \"targetPatents\": \""+generateRandom(3)+" Updated Target patents_21\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "PUT");

    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
