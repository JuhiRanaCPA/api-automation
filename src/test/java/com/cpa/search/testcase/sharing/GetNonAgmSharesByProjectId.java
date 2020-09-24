package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetNonAgmSharesByProjectId extends BootStrap{
//    String projectCaseNo = "AddProject" + generateRandom(5);
//    String date = getCurrentDate("yyyy-MM-dd");
//    String username ="newUser_"+generateRandom(5)+"@cbdd.com";
//    String strBody = "{\n" +
//            "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
//            "  \"technicalField\": \"Chemistry\",\n" +
//            "  \"projectType\": \"freedomToOperate\",\n" +
//            "  \"clientName\": \"\",\n" +
//            "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
//            "  \"deliveryOption\": \"standard\",\n" +
//            "  \"descriptionOfInvention\": \"\",\n" +
//            "  \"knownPriorArt\": \"\",\n" +
//            "  \"budget\": \"\",\n" +
//            "  \"otherOrderInformationOrComments\": \"\",\n" +
//            "  \"attachments\": [],\n" +
//            "  \"rate\": 0,\n" +
//            "  \"hours\": 0,\n" +
//            "  \"contactCode\": \"\",\n" +
//            "  \"currency\": \"EUR\",\n" +
//            "  \"noDocumentCopyrightFees\": false,\n" +
//            "  \"noDocumentServiceFees\": false,\n" +
//            "  \"ccEmails\": \"\",\n" +
//            "  \"usersSharesIds\": null,\n" +
//            "  \"startDate\": \""+date+"\"\n" +
//            "}";
//    String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
//    String apiUrl = baseURI + "api/projects/"+projectId+"/nonagmshares";
//
//    @BeforeTest
//    public void addUsersProject() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userEmail\": \""+username+"\",\n" +
//                "  \"message\": \"\",\n" +
//                "  \"sendInvitation\": true\n" +
//                "}";
//        setResponse(baseURI + "api/projects/"+projectId+"/shares/users/owner","POST",strBody);
//    }
//    @Test
//    public void getNonAgmSharesByProjectId_200(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateStatusCode(apiUrl, "", 200, "GET");
//    }
//
//    @Test
//    public void getNonAgmSharesByProjectId_ValidateEmail(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(apiUrl,"emailAddress[0]",username,"GET","");
//     }
//    @Test
//    public void getNonAgmSharesByProjectId_Validate_status(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(apiUrl,"status[0]",0,"GET","");
//    }
//    @Test
//    public void getNonAgmSharesByProjectId_Validate_projectId(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(apiUrl,"projectId[0]",projectId,"GET","");
//    }
//
//    @Test
//    public void getNonAgmSharesByProjectId_InvalidProjectId_404(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateStatusCode(baseURI + "api/projects/"+projectId+"zCzxccz/nonagmshares", "", 404, "GET");
//    }
//
//    @Test
//    public void getNonAgmSharesByProjectId_InvalidProjectId_ResponseMessage(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateResponseMessage(baseURI + "api/projects/"+projectId+"zCzxccz/nonagmshares","","The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","GET");
//    }
//    @Test
//    public void getNonAgmSharesByProjectId_ResponseTime() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
//    }
//    @AfterTest
//    public void deleteProject(){
//        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
//    }
}
