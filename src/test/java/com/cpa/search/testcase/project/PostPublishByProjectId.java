package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class PostPublishByProjectId extends BootStrap{
    String apiUrl = baseURI + "api/projects/";


    public String publishProjectAndGetProjectId(String valueOf_SectionToPublish, String projectStatus){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId(projectStatus);
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \""+valueOf_SectionToPublish+"\"\n" +
                "  ]\n" +
                "}";
        setResponse(apiUrl+projectId+"/publish", "POST", strBody);
        return projectId;
    }

    @Test(priority = 1)
    public void postPublishByProjectId_ValidRequest_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("requestReceived");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }

    @Test(priority = 2)
    public void postPublishByProjectId_requestReceived_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("requestReceived");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }

    @Test(priority = 3)
    public void postPublishByProjectId_processingRequest_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("processingRequest");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }

    @Test(priority = 4)
    public void postPublishByProjectId_approvalNeeded_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("approvalNeeded");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 5)
    public void postPublishByProjectId_expired_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("expired");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void postPublishByProjectId_revisingProposal_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("revisingProposal");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 7)
    public void postPublishByProjectId_searchInProgress_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("searchInProgress");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 8)
    public void postPublishByProjectId_reportAvailable_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("reportAvailable");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 9)
    public void postPublishByProjectId_cancelled_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("cancelled");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 10)
    public void postPublishByProjectId_deleted_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("deleted");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"/publish", strBody, 200, "POST");
    }
    @Test(priority = 11)
    public void postPublishByProjectId_InValidValidRequest_404(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("requestReceived");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl+projectId+"sample/publish", strBody, 404, "POST");
    }
    @Test(priority = 12)
    public void postPublishByProjectId_InValidValidRequest_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("requestReceived");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateResponseMessage(apiUrl+projectId+"sample/publish",strBody,"The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.","POST");
        validateStatusCode(apiUrl+projectId+"sample/publish", strBody, 404, "POST");
    }

    @Test(priority = 20)
    public void postPublishByProjectId_ResponseTime(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        GetISPNPByProjectId getProjectId = new GetISPNPByProjectId();
        String projectId = getProjectId.getProjectId("requestReceived");
        String strBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"team\"\n" +
                "  ]\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(),apiUrl+projectId+"/publish","",BENCHMARK_RESPONSE_TIME,"GET");
    }
}
