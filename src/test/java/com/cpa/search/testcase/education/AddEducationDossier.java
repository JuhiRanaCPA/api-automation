package com.cpa.search.testcase.education;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

import java.util.List;

public class AddEducationDossier extends BootStrap{
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education";

    @Test(priority = 0)
    public void DeleteEducation_IfAvailable(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(apiUrl,"","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String educationId = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/education/" + educationId, "DELETE", "");
        }}

    @Test(priority = 1)
    public void addEducationDossier_Blank_School_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addEducationDossier_Blank_Degree_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 500, "POST");
    }
    @Test(priority = 3)
    public void addEducationDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 200, "POST");
        String educationId= getValueFromResponse(apiUrl,"","id[0]","GET");
        setResponse(baseURI + "api/dossier/education/"+educationId,"DELETE","");
    }
    @Test(priority = 4)
    public void addEducationDossier_InValid_startdate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.89ssZ\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 400, "POST");
    }
    @Test(priority = 5)
    public void addEducationDossier_InValid_endDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.89Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.89fsfsZ\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 400, "POST");
    }
    @Test(priority = 6)
    public void addEducationDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2019-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( baseURI + "api/dossier/education", strBody, 200, "POST");
    }
    @Test(priority = 7)
    public void addEducationDossier_Validate_School() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"school[0]","Testing Api Data School","GET","");
    }
    @Test(priority = 8)
    public void addEducationDossier_Validate_degree() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"degree[0]","Testing Api Data Degree","GET","");
    }
    @Test(priority = 9)
    public void addEducationDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"description[0]","Testing Api Data  Description","GET","");
    }
    @Test(priority = 10)
    public void addEducationDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"startYear[0]","2018-11-28T14:56:48.89","GET","");
    }
    @Test(priority = 11)
    public void addEducationDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"endYear[0]","2019-11-28T14:56:48.89","GET","");
    }
    @Test(priority = 12)
    public void addEducationDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/education", strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @Test(priority = 13)
    public void DeleteAddedEducation(){
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            List<String> Ids = getAllValuesFromResponse(apiUrl,"","id","GET");
            for(int i=0;i<=Ids.size()-1;i++) {
                String educationId = Ids.get(i);
                // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
                setResponse(baseURI + "api/dossier/education/" + educationId, "DELETE", "");
            }}
}
