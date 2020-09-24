package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PostProjectAdmin extends BootStrap{
   String apiUrl = baseURI + "api/projects/admin";

    @Test(priority = 1)
    public void postProjectAdmin_ValidRequest_Status_Code(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postProjectSearch_ValidRequest_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 3)
    public void postProjectSearch_CaseOrMatterNumber_Status_Code(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = this.getClass().getSimpleName() + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String CaseMatterNumber = "777";
        String strBody = "{\"filter\": {\n" +
                "    \"caseOrMatterNumber\": \""+CaseMatterNumber+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void postProjectSearch_CaseOrMatterNumber_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "Fail";
        String CaseMatterNumber = "777";
        String strBody = "{\"filter\": {\n" +
                "    \"caseOrMatterNumber\": \""+CaseMatterNumber+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";

        int resultCount = getIntValueFromResponse(apiUrl,strBody,"resultCount","POST");
        if(resultCount>=0){
            finalStatus ="Pass";
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }

        @Test(priority = 5)
    public void postProjectSearch_ProjectType_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectType = "acceleratedExamination";
        String strBody = "{\"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"type\": \""+projectType+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 6)
    public void postProjectSearch_ProjectType_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String projectType = "acceleratedExamination";
        String strBody = "{\"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"type\": \""+projectType+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.type","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).equalsIgnoreCase(projectType))
            { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 7)
    public void postProjectSearch_Invalid_ProjectType_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectType = "acceleratedExamination";
        String strBody = "{\"filter\": {\n" +
                "    \"caseOrMatterNumber\": \"\",\n" +
                "    \"type\": \""+projectType+" Sample\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 8)
//    public void postProjectSearch_InValid_ProjectType_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//             String projectType = "acceleratedExamination";
//        String strBody = "{\"filter\": {\n" +
//                "    \"caseOrMatterNumber\": \"\",\n" +
//                "    \"type\": \""+projectType+" Sample\",\n" +
//                "    \"searchGroups\": \"\"\n" +
//                "  }\n" +
//                "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 9)
    public void postProjectSearch_projectTitle_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectTitle = "Test";
        String strBody = "{\"filter\": {\n" +
                "    \"projectTitle\": \""+projectTitle+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 10)
    public void postProjectSearch_projectTitle_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String projectTitle = "123";
        String strBody = "{\"filter\": {\n" +
                "    \"projectTitle\": \""+projectTitle+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.projectTitle","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).contains(projectTitle)) { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;}
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }

/*******************************************************/
@Test(priority = 12)
public void postProjectSearch_Status_200(){
    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    String status = "processingRequest";
    String strBody = "{\"filter\": {\n" +
            "    \"status\": \""+status+"\",\n" +
            "    \"searchGroups\": \"\"\n" +
            "  }\n" +
            "}";
    validateStatusCode(apiUrl, strBody, 200, "POST");
}
    @Test(priority = 13)
    public void postProjectSearch_Status_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String status = "processingRequest";
        String strBody = "{\"filter\": {\n" +
                "    \"status\": \""+status+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        List<String> actualValuelist = getAllValuesFromResponse(apiUrl,strBody,"result.status","POST");
        for(int i =0; i< actualValuelist.size();i++){
            if(actualValuelist.get(i).contains(status)) { finalStatus = "Pass";  }
            else {finalStatus ="Fail"; break;} }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 14)
    public void postProjectSearch_InValid_Status_400(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status = "processingRequestsds";
        String strBody = "{\"filter\": {\n" +
                "    \"status\": \""+status+"\",\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 15)
//    public void postProjectSearch_InValid_Status_Response_Message() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//               String status = "processingRequest";
//    String strBody = "{\"filter\": {\n" +
//            "    \"status\": \""+status+"\",\n" +
//            "    \"searchGroups\": \"\"\n" +
//            "  }\n" +
//            "}";
//        validateResponseMessage(apiUrl,strBody,"","POST");
//    }

    @Test(priority = 16)
    public void postProjectSearch_searchGroups_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String searchGroups = "Chemistry";
        String strBody = "{\"filter\": {\n" +
                "    \"searchGroups\": \""+searchGroups+"\"\n" +
                "  }\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 17)
    public void postProjectSearch_searchGroups_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String extepectedstatus ="Pass";
        String finalStatus = "";
        String searchGroups = "TL - CN - Chemistry";
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"searchGroups\": \""+searchGroups+"\"\n" +
                "  },\n" +
                "  \"limit\": 15\n" +
                "}\n";
        List<HashMap<String,List<String>>> resultValues = getAllValuesInListNestedListFromResponse(apiUrl,strBody,"result", "POST");
        for(int i =0; i< resultValues.size();i++){
            HashMap<String,List<String>> key = resultValues.get(i);
            List<String> searchGroupsItems=  key.get("searchGroups");
            for(int j=0;j<searchGroupsItems.size(); j++){
                if(searchGroupsItems.contains(searchGroups))
                { finalStatus = "Pass";  }
                else {finalStatus ="Fail"; break;}
            }
        }
        Assert.assertEquals(finalStatus,extepectedstatus);
    }
    @Test(priority = 18)
    public void postProjectAdmin_Response_Time(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"filter\": {\n" +
                "    \"searchGroups\": \"\"\n" +
                "  }\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

}
