package com.cpa.search.testcase.experience;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

import java.util.List;

public class AddExperienceDossier extends BootStrap{
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience";

    @Test(priority = 0)
    public void DeleteAddedExperience_IfAvailable(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(apiUrl,"","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String educationId = Ids.get(i);
           // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
                setResponse(baseURI + "api/dossier/experience/" + educationId, "DELETE", "");
        }}

    @Test(priority = 1)
    public void addExperienceDossier_Blank_title_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addExperienceDossier_Blank_Company_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 500, "POST");
    }
    @Test(priority = 3)
    public void addExperienceDossier_Blank_Current_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Company\",\n" +
                "  \"company\": \"Testing Api Data compan\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addExperienceDossier_Validate_current_False() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"current[0]","false","GET","");
        setResponse(baseURI + "api/dossier/experience/" + getValueFromResponse(apiUrl, "", "id[0]", "GET"), "DELETE", "");
    }
    @Test(priority = 7)
    public void addExperienceDossier_InValid_startdate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-32-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 400, "POST");
    }
    @Test(priority = 8)
    public void addExperienceDossier_InValid_endDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-42-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 400, "POST");
    }
    @Test(priority = 9)
    public void addExperienceDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 200, "POST");
    }
    @Test(priority = 10)
    public void addExperienceDossier_Validate_title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"title[0]","Testing Api Data Title","GET","");
    }
    @Test(priority = 11)
    public void addExperienceDossier_Validate_location() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"location[0]","Testing Api Data Location","GET","");
    }
    @Test(priority = 12)
    public void addExperienceDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"description[0]","Testing Api Data  Description","GET","");
    }
    @Test(priority = 13)
    public void addExperienceDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"startDate[0]","2019-12-03T15:40:44.13","GET","");
    }
    @Test(priority = 14)
    public void addExperienceDossier_Validate_company() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"company[0]","Testing Api Data Company","GET","");
    }
    @Test(priority = 15)
    public void addExperienceDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"endDate[0]","2019-12-03T15:40:44.13","GET","");
        setResponse(baseURI + "api/dossier/experience/" + getValueFromResponse(apiUrl, "", "id[0]", "GET"), "DELETE", "");
    }

    @Test(priority = 16)
    public void addExperienceDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 200, "POST");

    }
    @Test(priority = 17)
    public void addExperienceDossier_Validate_current_True() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"current[0]","true","GET","");
        setResponse(baseURI + "api/dossier/experience/"+getValueFromResponse(apiUrl,"","id[0]","GET"),"DELETE","");
    }
    @Test(priority = 18)
    public void addExperienceDossier_Blank_location_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data company\",\n" +
                "  \"location\": \"\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/experience", strBody, 200, "POST");
        setResponse(baseURI + "api/dossier/experience/" + getValueFromResponse(apiUrl, "", "id[0]", "GET"), "DELETE", "");
    }
    @Test(priority = 19)
    public void addExperienceDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"Testing Api Data Title\",\n" +
                "  \"company\": \"Testing Api Data Company\",\n" +
                "  \"location\": \"Testing Api Data Location\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
                "  \"current\": true,\n" +
                "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/experience", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @Test(priority = 20)
    public void DeleteAddedExperience(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(apiUrl,"","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String educationId = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/experience/" + educationId, "DELETE", "");
        }}
}

