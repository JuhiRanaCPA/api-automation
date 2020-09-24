package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CancelProjectByProjectId extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    List<String> projectIds = new ArrayList<>();
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
    @BeforeTest
    public void addProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl = apiUrl + projectId + "/cancel";
    }
    @Test(priority = 1)
    public void CancelProjectByProjectId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "POST");
    }

    @Test(priority = 2)
    public void CancelProjectByProjectId_ResponseMessage() {
        String projectId2 = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        String apiUrlcancel = baseURI + "api/projects/" + projectId2 + "/cancel";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrlcancel, "", "", "POST");
        setResponse(baseURI + "api/projects/" + projectId2, "DELETE", "");
    }

    @Test(priority = 3)
    public void Cancel_PyProjectId_ValidateProjectStatus() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/projects/" + projectId, "status", "cancelled", "GET", "");
    }

    @Test(priority = 4)
    public void Cancel_Project_With_Cancelled_Status_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 500, "POST");
    }

    @Test(priority = 5)
    public void Cancel_Project_With_Cancelled_Status_ResponseMessage() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "type", "UNEXPECTED_ERROR", "POST", "");
        //  validateResponseMessage(apiUrl,"","{\"type\":\"UNEXPECTED_ERROR\",\"logReference\":\"8000a304-0003-f400-b63f-84710c7967bb\",\"server\":\"https://ipclouddynamiccontentpwb6o2md5o7os.azurewebsites.net/search/api/projects/"+projectId+"/cancel\"}","POST");
    }

    @Test(priority = 6)
    public void Cancel_Project_With_Deleted_Status_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectId2 = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        String apiUrldelete = baseURI + "api/projects/" + projectId2;
        String apiUrlcancel = baseURI + "api/projects/" + projectId2 + "/cancel";
        validateStatusCode(apiUrldelete, "", 200, "DELETE");
        validateStatusCode(baseURI + "api/projects/" + projectId2, "", 404, "GET");
        validateStatusCode(apiUrlcancel, "", 404, "POST");
    }

    @Test(priority = 7)
    public void Cancel_Project_With_Deleted_Status_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectId2 = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        String apiUrldelete = baseURI + "api/projects/" + projectId2;
        String apiUrlcancel = baseURI + "api/projects/" + projectId2 + "/cancel";
        validateStatusCode(apiUrldelete, "", 200, "DELETE");
        validateStatusCode(baseURI + "api/projects/" + projectId2, "", 404, "GET");
        validateKeyValueFromResponse(apiUrl, "type", "UNEXPECTED_ERROR", "POST", "");
       }

    @Test(priority = 8)
    public void Cancel_Project_With_Invalid_ProjectId_404() {
        String apiUrlInvalidcancel = baseURI + "api/projects/874823n/cancel";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrlInvalidcancel, "", 404, "POST");
    }

    @Test(priority = 9)
    public void Cancel_Project_With_Invalid_ProjectId_ResponseMessage() {
        String apiUrlInvalidcancel = baseURI + "api/projects/874823dsn/cancel";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrlInvalidcancel, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "POST");
    }

    @Test(priority = 10)
    public void CancelProjectByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        for (int i = 0; i < 3; i++) {
//            String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
//            projectIds.add(i, projectId);
//        }
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "POST");
//        for (int i = 0; i < projectIds.size(); i++) {
//            String projId = projectIds.get(i);
//            setResponse(baseURI + "api/projects/" + projId, "DELETE", "");
//        }
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }

}
