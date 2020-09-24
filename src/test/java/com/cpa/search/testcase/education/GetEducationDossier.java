package com.cpa.search.testcase.education;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetEducationDossier extends BootStrap{
    String educationIdforTc;
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education";
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
    public void getEducationDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getEducationDossier_Validate_School() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"school[0]","Testing Api Data School","GET","");
    }
    @Test(priority = 3)
    public void getEducationDossier_Validate_degree() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"degree[0]","Testing Api Data Degree","GET","");
    }
    @Test(priority = 4)
    public void getEducationDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"description[0]","Testing Api Data  Description","GET","");
    }
    @Test(priority = 5)
    public void getEducationDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"startYear[0]","2018-11-28T14:56:48.89","GET","");
    }
    @Test(priority = 6)
    public void getEducationDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"endYear[0]","2019-11-28T14:56:48.89","GET","");
    }

    @Test(priority = 7)
    public void getEducationDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 8)
    public void DeleteAddedEducation(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(apiUrl+"/"+educationIdforTc, "DELETE", "");
    }
}
