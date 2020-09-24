package com.cpa.search.testcase.introductions;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetIntroductionsByProjectId extends BootStrap{
    String projectId, introductionId= "";
    String apiUrl = baseURI + "api/projects/" ;
    String CommentsAdded = "Adding Introduction for "+introductionId+" Random no "+generateRandom(3);

    @BeforeTest
    public void getIntroductionAndProjectId() {
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
        apiUrl=apiUrl+ projectId + "/introductions";
        String strBody1 = "{\n" +
                "  \"introductionText\": \""+CommentsAdded+"\"\n" +
                "}";
        introductionId= getValueFromResponse(apiUrl , strBody1, "id", "POST");
    }

    @Test(priority = 1)
    public void getIntroductionsByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test(priority = 2)
    public void getIntroductionsByProjectId_Validate_Id_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValuesFromResponse(apiUrl,"id",introductionId,"GET","");
    }
    @Test(priority = 3)
    public void getIntroductionsByProjectId_Validate_IntroductionMessage_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"introductionText[0]",CommentsAdded,"GET","");
    }

    @Test(priority = 4)
    public void getIntroductionsByProjectId_InValidProject_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction\"\n" +
                "}";
        validateStatusCode(apiUrl + "sample/introductions", "", 404, "GET");
    }

    @Test(priority = 5)
    public void getIntroductionsByProjectId_InValidProject_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"introductionText\": \"Adding Introduction\"\n" +
                "}";
        validateResponseMessage(apiUrl + "sample/introductions", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 6)
    public void getIntroductionsByProjectId_Validate_Multiple_Ids_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newComments = "Adding some more Introduction for TC 6";
        String strBody = "{\n" +
                "  \"introductionText\": \""+newComments+"\"\n" +
                "}";
        String introductionId2 =getValueFromResponse(apiUrl , strBody, "id", "POST");
        validateKeyValuesFromResponse(apiUrl,"id",introductionId2,"GET","");
    }

    @Test(priority = 7)
    public void getIntroductionsByProjectId_Validate_Multiple_Introductions_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String newComments = "Adding some more Introduction for TC 6";
        String strBody = "{\n" +
                "  \"introductionText\": \""+newComments+"\"\n" +
                "}";
        validateKeyValueFromResponse(apiUrl,"introductionText[0]",newComments,"GET","");
    }

    @Test(priority = 8)
    public void getIntroductionsByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + "/introductions", "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @AfterTest
    public void deleteProjectAfter_getIntroductionsByProjectId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/projects/"+projectId, "DELETE", "");
    }
}
