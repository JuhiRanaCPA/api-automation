package com.cpa.search.testcase.experience;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateExperienceDossier extends BootStrap{
    String experienceId;
    String apiUrl = baseURI + "api/dossier/experience/";
    String valuidateapiurl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience";

    @BeforeTest
    public void getExperienceId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience","","id","GET");
        if(Ids.size()>=1){
            for(int i=0;i<=Ids.size()-1;i++) {
                String Id = Ids.get(i);
                setResponse(baseURI + "api/dossier/experience/" + Id, "DELETE", "");
            }}
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Company\",\n" +
                "  \"company\": \"Testing Api Data compan\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        setResponse(baseURI + "api/dossier/experience","POST",strBody);
      experienceId =getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience","","id[0]","GET");
    }
    @Test(priority = 1)
    public void updateExperienceDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"Updating Testing Api Data Company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 200, "PUT");
    }
    @Test(priority = 2)
    public void updateExperienceDossier_Validate_title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"title[0]","Updating Testing Api Data Title","GET","");
    }
    @Test(priority = 3)
    public void updateExperienceDossier_Validate_location() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"location[0]","Updating Testing Api Data Location","GET","");
    }
    @Test(priority = 4)
    public void updateExperienceDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"description[0]","Updating Testing Api Data  Description","GET","");
    }
    @Test(priority = 5)
    public void updateExperienceDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"startDate[0]","2019-12-03T15:40:44.13","GET","");
    }
    @Test(priority = 6)
    public void updateExperienceDossier_Validate_company() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"company[0]","Updating Testing Api Data Company","GET","");
    }
    @Test(priority = 7)
    public void updateExperienceDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"endDate[0]","2019-12-03T15:40:44.13","GET","");
    }
    @Test(priority = 8)
    public void updateExperienceDossier_Validate_current_True() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(valuidateapiurl,"current[0]","true","GET","");
    }
    @Test(priority = 9)
    public void updateExperienceDossier_Blank_title_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"\",\n" +
                "  \"company\": \"Updating Testing Api Data Company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 500, "PUT");
    }
    @Test(priority = 10)
    public void updateExperienceDossier_Blank_Company_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 500, "PUT");
    }
    @Test(priority = 11)
    public void updateExperienceDossier_Blank_Current_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Company\",\n" +
                "  \"company\": \"Updating Testing Api Data company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 200, "PUT");
    }
    //    @Test(priority = 12)
//    public void updateExperienceDossier_Validate_current() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        validateKeyValueFromResponse(apiUrl,"current[0]","false","GET","");
//    }
    @Test(priority = 13)
    public void updateExperienceDossier_Blank_location_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"Updating Testing Api Data company\",\n" +
                "  \"location\": \"\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 200, "PUT");
    }
    @Test(priority = 14)
    public void updateExperienceDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"Updating Testing Api Data Company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 200, "PUT");
    }
    @Test(priority = 15)
    public void updateExperienceDossier_InValid_startdate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"Updating Testing Api Data Company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-32-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 400, "PUT");
    }
    @Test(priority = 16)
    public void updateExperienceDossier_InValid_endDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Updating Testing Api Data Title\",\n" +
                "  \"company\": \"Updating Testing Api Data Company\",\n" +
                "  \"location\": \"Updating Testing Api Data Location\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-42-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( apiUrl+experienceId, strBody, 400, "PUT");
    }
    @Test(priority = 17)
    public void updateExperienceDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Updating Testing Api Data School addGroup_ResponseTime\",\n" +
                "  \"degree\": \"Updating Testing Api Data DegreeaddGroup_ResponseTime\",\n" +
                "  \"description\": \"Updating Testing Api Data  Description addGroup_ResponseTime\",\n" +
                "  \"startYear\": \"2034-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2043-11-28T14:56:48.891Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+experienceId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @Test(priority = 18)
    public void DeleteAddedExperienceDossier(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(apiUrl+experienceId, "DELETE", "");
    }
}