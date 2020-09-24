package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class UpdateProjectTypeByProjectId extends BootStrap{
    String apiUrl = baseURI + "api/projects/";

//    @Test(priority = 1)
//    public void updateProjectTypeByProjectId_AllValueUpdate_200() {
//        String projectCaseNo = "AddProject" + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"freedomToOperate\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
//                "  \"deliveryOption\": \"standard\",\n" +
//                "  \"descriptionOfInvention\": \"\",\n" +
//                "  \"knownPriorArt\": \"\",\n" +
//                "  \"budget\": \"\",\n" +
//                "  \"otherOrderInformationOrComments\": \"\",\n" +
//                "  \"attachments\": [],\n" +
//                "  \"rate\": 0,\n" +
//                "  \"hours\": 0,\n" +
//                "  \"contactCode\": \"\",\n" +
//                "  \"currency\": \"EUR\",\n" +
//                "  \"noDocumentCopyrightFees\": false,\n" +
//                "  \"noDocumentServiceFees\": false,\n" +
//                "  \"ccEmails\": \"\",\n" +
//                "  \"usersSharesIds\": null,\n" +
//                "  \"startDate\": \"" + date + "\"\n" +
//                "}";
//        String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody1 = "{\n" +
//                "  \"type\": \"prenegotiatedProject\",\n" +
//                "  \"preNegotiatedProjectId\": \"a9d0839d-f0e0-4877-bf3a-6e4a18514b4d\"\n" +
//                "}";
//        validateStatusCode(apiUrl + projectId + "/projecttype", strBody1, 200, "PUT");
//        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
//    }
//
//    @Test(priority = 2)
//    public void updateProjectTypeByProjectId_AllValueUpdate_ResponseMessage() {
//        String projectCaseNo = "AddProject" + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"freedomToOperate\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
//                "  \"deliveryOption\": \"standard\",\n" +
//                "  \"descriptionOfInvention\": \"\",\n" +
//                "  \"knownPriorArt\": \"\",\n" +
//                "  \"budget\": \"\",\n" +
//                "  \"otherOrderInformationOrComments\": \"\",\n" +
//                "  \"attachments\": [],\n" +
//                "  \"rate\": 0,\n" +
//                "  \"hours\": 0,\n" +
//                "  \"contactCode\": \"\",\n" +
//                "  \"currency\": \"EUR\",\n" +
//                "  \"noDocumentCopyrightFees\": false,\n" +
//                "  \"noDocumentServiceFees\": false,\n" +
//                "  \"ccEmails\": \"\",\n" +
//                "  \"usersSharesIds\": null,\n" +
//                "  \"startDate\": \"" + date + "\"\n" +
//                "}";
//        String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody1 = "{\n" +
//                "  \"type\": \"prenegotiatedProject\",\n" +
//                "  \"preNegotiatedProjectId\": \"a9d0839d-f0e0-4877-bf3a-6e4a18514b4d\"\n" +
//                "}";
//        validateStatusCode(apiUrl + projectId + "/projecttype", strBody1, 200, "PUT");
//        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
//    }
//
//    @Test(priority = 3)
//    public void updateProjectTypeByProjectId_ResponseTime() {
//        String projectCaseNo = "AddProject" + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"freedomToOperate\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
//                "  \"deliveryOption\": \"standard\",\n" +
//                "  \"descriptionOfInvention\": \"\",\n" +
//                "  \"knownPriorArt\": \"\",\n" +
//                "  \"budget\": \"\",\n" +
//                "  \"otherOrderInformationOrComments\": \"\",\n" +
//                "  \"attachments\": [],\n" +
//                "  \"rate\": 0,\n" +
//                "  \"hours\": 0,\n" +
//                "  \"contactCode\": \"\",\n" +
//                "  \"currency\": \"EUR\",\n" +
//                "  \"noDocumentCopyrightFees\": false,\n" +
//                "  \"noDocumentServiceFees\": false,\n" +
//                "  \"ccEmails\": \"\",\n" +
//                "  \"usersSharesIds\": null,\n" +
//                "  \"startDate\": \"" + date + "\"\n" +
//                "}";
//        String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
//        String strBody1 = "{\n" +
//                "  \"type\": \"prenegotiatedProject\",\n" +
//                "  \"preNegotiatedProjectId\": \"a9d0839d-f0e0-4877-bf3a-6e4a18514b4d\"\n" +
//                "}";
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateResponseTime(this.getClass().getSimpleName(), apiUrl + projectId + "/projecttype", strBody1, BENCHMARK_RESPONSE_TIME, "PUT");
//        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
//    }

}