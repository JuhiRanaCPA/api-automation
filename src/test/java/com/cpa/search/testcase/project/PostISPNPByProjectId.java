package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostISPNPByProjectId extends BootStrap{

    String apiUrl = baseURI + "api/projects/search";
    @Test(priority = 1)
    public void postISPNPByProjectId_ValidRequest_Status_Code(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"IPC\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"2017-08-08T18:30:00.000Z\",\n" +
                "      \"end\": \"2034-08-09T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"2018-11-02T18:30:00.000Z\",\n" +
                "      \"end\": \"2019-11-03T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postISPNPByProjectId_ValidRequest_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"IPC\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"2017-08-08T18:30:00.000Z\",\n" +
                "      \"end\": \"2034-08-09T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"2018-11-02T18:30:00.000Z\",\n" +
                "      \"end\": \"2019-11-03T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";

        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 3)
    public void postISPNPByProjectId_CaseOrMatterNumber_Status_Code(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"777\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void postISPNPByProjectId_CaseOrMatterNumber_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String caseMatterNumber = "777";
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \""+caseMatterNumber+"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";

        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }

    @Test(priority = 5)
    public void postISPNPByProjectId_ClientName_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"IPC Dev - Goodman & Co.\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void postISPNPByProjectId_ClientName_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String clientName = "IPC Dev - Goodman & Co.";
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \""+clientName+"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";

        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.clientName","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).equalsIgnoreCase(clientName))
            { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 7)
    public void postISPNPByProjectId_NullClientName_Status_Code(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": 11,\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 8)
    public void postISPNPByProjectId_Null_ClientName_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": 22,\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }

    @Test(priority = 9)
    public void postISPNPByProjectId_ProjectType_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"prenegotiatedProject\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 10)
    public void postISPNPByProjectId_ProjectType_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String projectType = "acceleratedExamination";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \""+projectType+"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.type","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).equalsIgnoreCase(projectType))
            { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);//
//        List<HashMap<String,String>> resultValues = getAllValuesInListFromResponse(apiUrl,strBody,"result", "POST");
//        for(int i =0; i< resultValues.size();i++){
//            HashMap<String,String> key = resultValues.get(i);
//            if(key.get("type").equalsIgnoreCase(projectType))
//            { finalStatus = "Pass";  }
//            else {finalStatus ="Fail"; break;}
//        }
//        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 11)
    public void postISPNPByProjectId_Invalid_ProjectType_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"acceleratedExamination_Sample\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 12)
//    public void postISPNPByProjectId_InValid_ProjectType_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"acceleratedExamination_Sample\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 15,\n" +
//                "  \"orderBy\": null,\n" +
//                "  \"orderDirection\": null,\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 13)
    public void postISPNPByProjectId_Invalid_PrenegotiatedProject_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"Testing\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": null,\n" +
                "  \"orderDirection\": null,\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 14)
//    public void postISPNPByProjectId_InValid_PrenegotiatedProject_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"Testing\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": null,\n" +
//                "      \"end\": null\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 15,\n" +
//                "  \"orderBy\": null,\n" +
//                "  \"orderDirection\": null,\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 15)
    public void postISPNPByProjectId_StartDate_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 16)
    public void postISPNPByProjectId_StartDate_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 17)
    public void postISPNPByProjectId_Invalid_StartDate_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.00gf23Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.993d29Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 18)
//    public void postISPNPByProjectId_InValid_StartDate_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \""+date+"T18:30:00.0002x3Z\",\n" +
//                "      \"end\": \"2023-11-08T18:29:59.993x29Z\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
//                "  \"orderDirection\": \"ascending\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 19)
    public void postISPNPByProjectId_DeliveryDate_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 20)
    public void postISPNPByProjectId_DeliveryDate_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 21)
    public void postISPNPByProjectId_Invalid_DeliveryDate_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \""+date+"T18:30:00.0s030Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.99c39Z\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 22)
//    public void postISPNPByProjectId_InValid_DeliveryDate_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//      String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \""+date+"T18:30:00.0003sZ\",\n" +
//                "      \"end\": \"2023-11-08T18:29:59.99s39Z\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
//                "  \"orderDirection\": \"ascending\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 23)
    public void postISPNPByProjectId_LastUpdated_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 24)
    public void postISPNPByProjectId_LastUpdated_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \""+date+"T18:30:00.000Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 25)
    public void postISPNPByProjectId_Invalid_LastUpdated_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \""+date+"T18:30:00.0d030Z\",\n" +
                "      \"end\": \"2023-11-08T18:29:59.99d39Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 26)
//    public void postISPNPByProjectId_InValid_LastUpdated_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String date = getCurrentDate("yyyy-MM-dd");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \""+date+"T18:30:00.00hg03Z\",\n" +
//                "      \"end\": \"2023-11-08T18:29:59.9939Z\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
//                "  \"orderDirection\": \"ascending\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 27)
    public void postISPNPByProjectId_Status_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"processingRequest\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 28)
    public void postISPNPByProjectId_Status_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String status ="approvalNeeded";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \""+status+"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.status","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).equalsIgnoreCase(status))
            { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 29)
    public void postISPNPByProjectId_InValid_Status_LastUpdated_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"searchInProgresss\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
    //    @Test(priority = 30)
//    public void postISPNPByProjectId_InValid_Status_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//            String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"searchInProgressd\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
//                "  \"orderDirection\": \"ascending\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }
    @Test(priority = 31)
    public void postISPNPByProjectId_LatestDocument_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String lastDocument ="proposal";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \""+lastDocument+"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 32)
    public void postISPNPByProjectId_LatestDocument_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String lastDocument ="proposal";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \""+lastDocument+"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";

        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.latestDocument","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).equalsIgnoreCase(lastDocument))
            { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 33)
    public void postISPNPByProjectId_InValid_LatestDocument_LastUpdated_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"finalReporti\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 34)
//    public void postISPNPByProjectId_InValid_LatestDocument_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"finalReportd\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
//                "  \"orderDirection\": \"ascending\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 35)
    public void postISPNPByProjectId_OrderBy_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 36)
    public void postISPNPByProjectId_OrderBy_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"clientName\",\n" +
                "  \"orderDirection\": \"\",\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 37)
    public void postISPNPByProjectId_InValid_OrderBy_LastUpdated_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumberadas\",\n" +
                "  \"orderDirection\": \"\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 38)
//    public void postISPNPByProjectId_InValid_OrderBy_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"caseOrMatterNumberkk\",\n" +
//                "  \"orderDirection\": \"\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 39)
    public void postISPNPByProjectId_OrderDirection_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 40)
    public void postISPNPByProjectId_OrderDirection_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"patentLegalStatus\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 15,\n" +
                "  \"orderBy\": \"\",\n" +
                "  \"orderDirection\": \"descending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 41)
    public void postISPNPByProjectId_InValid_OrderDirection_LastUpdated_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"\",\n" +
                "      \"end\": \"\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"\",\n" +
                "  \"orderDirection\": \"descendingc\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 42)
//    public void postISPNPByProjectId_InValid_OrderDirection_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"clientName\": \"\",\n" +
//                "    \"type\": \"\",\n" +
//                "    \"prenegotiatedProject\": \"\",\n" +
//                "    \"startDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"deliveryDate\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"lastUpdated\": {\n" +
//                "      \"start\": \"\",\n" +
//                "      \"end\": \"\"\n" +
//                "    },\n" +
//                "    \"status\": \"\",\n" +
//                "    \"latestDocument\": \"\"\n" +
//                "  },\n" +
//                "  \"limit\": 1500,\n" +
//                "  \"orderBy\": \"\",\n" +
//                "  \"orderDirection\": \"descendingc\",\n" +
//                "  \"offset\": 0\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 43)
    public void postISPNPByProjectId_ResponseTime(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"clientName\": \"IPC\",\n" +
                "    \"type\": \"\",\n" +
                "    \"prenegotiatedProject\": \"\",\n" +
                "    \"startDate\": {\n" +
                "      \"start\": \"2017-08-08T18:30:00.000Z\",\n" +
                "      \"end\": \"2034-08-09T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"deliveryDate\": {\n" +
                "      \"start\": null,\n" +
                "      \"end\": null\n" +
                "    },\n" +
                "    \"lastUpdated\": {\n" +
                "      \"start\": \"2018-11-02T18:30:00.000Z\",\n" +
                "      \"end\": \"2019-11-03T18:29:59.999Z\"\n" +
                "    },\n" +
                "    \"status\": \"\",\n" +
                "    \"latestDocument\": \"\"\n" +
                "  },\n" +
                "  \"limit\": 1500,\n" +
                "  \"orderBy\": \"caseOrMatterNumber\",\n" +
                "  \"orderDirection\": \"ascending\",\n" +
                "  \"offset\": 0\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
