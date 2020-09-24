package com.company.project.testcase.education;

import com.company.project.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class UpdateEducationDossier extends BootStrap{
    String educationIdforTc;
    String apiUrl = baseURI + "api/dossier/education/";

    @BeforeTest
    public void getEducationDossierId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String educationId = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/education/" + educationId, "DELETE", "");
        }
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2019-11-28T14:56:48.891Z\"\n" +
                "}";
        setResponse(baseURI + "api/dossier/education","POST",strBody);
        educationIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","","id[0]","GET");
    }

    @Test(priority = 1)
    public void updateEducationDossier_Blank_School_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 500, "PUT");
    }
    @Test(priority = 2)
    public void updateEducationDossier_Blank_Degree_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 500, "PUT");
    }
    @Test(priority = 3)
    public void updateEducationDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 200, "PUT");
    }
    @Test(priority = 4)
    public void updateEducationDossier_InValid_startdate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.89ssZ\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 400, "PUT");
    }
    @Test(priority = 5)
    public void updateEducationDossier_InValid_endDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School\",\n" +
                "  \"degree\": \"Testing Api Data Degree\",\n" +
                "  \"description\": \"Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2018-11-28T14:56:48.89Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.89fsfsZ\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 400, "PUT");
    }
    @Test(priority = 6)
    public void updateEducationDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Updating Value Testing Api Data School\",\n" +
                "  \"degree\": \"Updating Value Testing Api Data Degree\",\n" +
                "  \"description\": \"Updating Value Testing Api Data  Description\",\n" +
                "  \"startYear\": \"2016-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2018-11-28T14:56:48.891Z\"\n" +
                "}";
        validateStatusCode( apiUrl+educationIdforTc, strBody, 200, "PUT");
    }
    @Test(priority = 7)
    public void updateEducationDossier_Validate_School() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","school[0]","Updating Value Testing Api Data School","GET","");
    }
    @Test(priority = 8)
    public void updateEducationDossier_Validate_degree() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","degree[0]","Updating Value Testing Api Data Degree","GET","");
    }
    @Test(priority = 9)
    public void updateEducationDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","description[0]","Updating Value Testing Api Data  Description","GET","");
    }
    @Test(priority = 10)
    public void updateEducationDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","startYear[0]","2016-11-28T14:56:48.89","GET","");
    }
    @Test(priority = 11)
    public void updateEducationDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","endYear[0]","2018-11-28T14:56:48.89","GET","");
    }
    @Test(priority = 12)
    public void updateEducationDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"school\": \"Testing Api Data School addGroup_ResponseTime\",\n" +
                "  \"degree\": \"Testing Api Data DegreeaddGroup_ResponseTime\",\n" +
                "  \"description\": \"Testing Api Data  Description addGroup_ResponseTime\",\n" +
                "  \"startYear\": \"2034-11-28T14:56:48.891Z\",\n" +
                "  \"endYear\": \"2043-11-28T14:56:48.891Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+educationIdforTc, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @Test(priority = 13)
    public void DeleteAddedEducation(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            setResponse(apiUrl+educationIdforTc, "DELETE", "");
        }

}

