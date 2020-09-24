package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetValidateByProjectId extends BootStrap {
    String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
    String date = getCurrentDate("yyyy-MM-dd");
    String apiUrl = baseURI + "api/projects/";
    String projectId = "";

    @BeforeTest
    public void addProjectId() {
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
        projectId = getValueFromResponse(apiUrl, strBody, "id", "POST");
        apiUrl = apiUrl + projectId + "/validate";
    }

    @Test
    public void getValidateByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }

    @Test
    public void getValidateByProjectId_Validate_ReferenceId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "referenceId", projectCaseNo, "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_Severity1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[0].severity", "error", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_Severity2() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[1].severity", "warning", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_validationMessage1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[0].validationMessage", "No published proposals exist", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_validationMessage2() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[1].validationMessage", "Proposal has no attachments", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_validationCode1() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[0].validationCode", "IPS-2", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_proposal_ResultList_validationCode2() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposal.resultList[1].validationCode", "IPS-5", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_introduction_ResultList_validationCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "introduction.resultList[0].validationCode", "IPS-2", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_reports_ResultList_validationCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "reports.resultList[0].validationCode", "IPS-2", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_searchHistory_ResultList_validationCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "searchHistory.resultList[0].validationCode", "IPS-2", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_features_ResultList_validationCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "features.resultList[0].validationCode", "IPS-2", "GET", "");
    }

    @Test
    public void getValidateByProjectId_Validate_references_ResultList_validationCode() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "references.resultList[0].validationCode", "IPS-2", "GET", "");
    }
    @Test(priority = 7)
    public void getValidateByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");

    }
    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
