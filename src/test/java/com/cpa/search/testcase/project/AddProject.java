package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddProject extends BootStrap {

    String apiUrl = baseURI + "api/projects";

    @Test(priority = 1)
    public void addProjectId_CreateProject_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
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
        String searchStrBody = "{\n" +
                "  \"filter\": {\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
        String projectId = getValueFromResponse(baseURI + "api/projects/search", searchStrBody, "result.id[0]", "POST");
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }

    @Test(priority = 2)
    public void addProjectId_CreateProject_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
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
        String projectId = getValueFromResponse(apiUrl, strBody, "id", "POST");
        String apiUrlwithProjectId = apiUrl + "/" + projectId;
        validateKeyValueFromResponse(apiUrlwithProjectId, "caseOrMatterNumber", projectCaseNo, "GET", "");
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");

    }


    @Test(priority = 3)
    public void addProjectId_CreateProject_With_CaseMatterNUll_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"\",\n" +
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
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    @Test(priority = 4)
    public void addProjectId_CreateProject_With_CaseMatterNUll_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"\",\n" +
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
        validateKeyValueFromResponse(apiUrl, "message", "Case/Matter#  is invalid\r\nParameter name: caseOrMatterNumber", "POST", strBody);
    }

    @Test(priority = 5)
    public void addProjectId_CreateProject_With_TechnicalField_NUll_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"\",\n" +
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
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 6)
//    public void addProjectId_CreateProject_With_TechnicalField_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
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
//                "  \"startDate\": \""+date+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message", "A technical field is required","POST",strBody);
//    }

    @Test(priority = 7)
    public void addProjectId_CreateProject_With_ProjectType_NUll_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"\",\n" +
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
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    //    @Test(priority = 8)
//    public void addProjectId_CreateProject_With_ProjectType_NULL_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
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
//                "  \"startDate\": \""+date+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"Message", "Must specify valid information for parsing in the string.\\","POST",strBody);
//    }
    @Test(priority = 9)
    public void addProjectId_CreateProject_With_deliveryOption_NUll_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
                "  \"deliveryOption\": \"\",\n" +
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
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 10)
//    public void addProjectId_CreateProject_With_deliveryOption_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
//                "  \"technicalField\": \"Chemistry\",\n" +
//                "  \"projectType\": \"freedomToOperate\",\n" +
//                "  \"clientName\": \"\",\n" +
//                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
//                "  \"deliveryOption\": \"\",\n" +
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
//                "  \"startDate\": \""+date+"\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"Message", "Error converting value \"\" to type 'CPA.Cloud.Search.Domains.Contracts.Models.DeliveryOption'. Path 'deliveryOption', line 7, position 22.","POST",strBody);
//    }

    @Test(priority = 11)
    public void addProject_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
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
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
        String searchStrBody = "{\n" +
                "  \"filter\": {\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  }\n" +
                "}";
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/projects/search", searchStrBody, "result.id", "POST");
        for (int i = 0; i <= Ids.size() - 1; i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/projects/" + Id, "DELETE", "");
        }
    }

}

