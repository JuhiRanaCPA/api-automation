package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class GetISPNPByProjectId extends BootStrap{

    String apiUrlSearch = baseURI + "api/projects/search";
    String apiUrl = baseURI + "api/projects/";


    public String getProjectId(String status) {
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"status\": \"" + status + "\",\n" +
                "  },\n" +
                "  \"offset\": 1,\n" +
                "  \"limit\": 1\n" +
                "}";
        return getValueFromResponse(apiUrlSearch, strBody, "result.id[0]", "POST");
    }

    @Test(priority = 1)
    public void getISPNPByProjectId_requestReceived_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "requestReceived";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 2)
    public void getISPNPByProjectId_requestReceived_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "requestReceived";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 3)
    public void getISPNPByProjectId_processingRequest_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "processingRequest";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 4)
    public void getISPNPByProjectId_processingRequest_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "processingRequest";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 5)
    public void getISPNPByProjectId_approvalNeeded_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "approvalNeeded";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 6)
    public void getISPNPByProjectId_approvalNeeded_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "approvalNeeded";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 7)
    public void getISPNPByProjectId_revisingProposal_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "revisingProposal";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 8)
    public void getISPNPByProjectId_revisingProposal_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "revisingProposal";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    //////////////////////////////////////////////

    @Test(priority = 9)
    public void getISPNPByProjectId_expired_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "expired";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 10)
    public void getISPNPByProjectId_expired_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "expired";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 11)
    public void getISPNPByProjectId_cancelled_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "cancelled";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 12)
    public void getISPNPByProjectId_cancelled_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "cancelled";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 13)
    public void getISPNPByProjectId_deleted_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "deleted";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 14)
    public void getISPNPByProjectId_deleted_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "deleted";
        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 15)
    public void getISPNPByProjectId_searchInProgress_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "searchInProgress";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 16)
    public void getISPNPByProjectId_searchInProgress_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String status = "searchInProgress";
//        String projectId = getProjectId(status);
        validateResponseMessage(apiUrl +"d79852f2-99ef-4386-8364-e33b9f8e555d/ispnp", "", "false", "GET");
    }


    @Test(priority = 17)
    public void getISPNPByProjectId_reportAvailable_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "reportAvailable";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "/ispnp", "", 200, "GET");
    }

    @Test(priority = 18)
    public void getISPNPByProjectId_reportAvailable_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "reportAvailable";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"status\": \"" + status + "\",\n" +
                "  },\n" +
                "  \"offset\": 1,\n" +
                "  \"limit\": 1\n" +
                "}";
        String projectId = getValueFromResponse(apiUrlSearch, strBody, "result.id[0]", "POST");
        validateResponseMessage(apiUrl + projectId + "/ispnp", "", "false", "GET");
    }

    @Test(priority = 19)
    public void getISPNPByProjectId_InValid_ProjectId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "requestReceived";
        String projectId = getProjectId(status);
        validateStatusCode(apiUrl + projectId + "sample/ispnp", "", 404, "GET");
    }

    @Test(priority = 20)
    public void getISPNPByProjectId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "requestReceived";
        String projectId = getProjectId(status);
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + projectId + "/ispnp", "", BENCHMARK_RESPONSE_TIME, "GET");
    }

}
