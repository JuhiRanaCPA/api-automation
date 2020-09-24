package com.cpa.search.testcase.education;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteEducationDossier extends  BootStrap {
    String strBody = "{\n" +
            "  \"school\": \"Testing Api Data School\",\n" +
            "  \"degree\": \"Testing Api Data Degree\",\n" +
            "  \"description\": \"Testing Api Data  Description\",\n" +
            "  \"startYear\": \"2018-11-28T14:56:48.891Z\",\n" +
            "  \"endYear\": \"2019-11-28T14:56:48.891Z\"\n" +
            "}";
    List<String> educationIdList= new ArrayList<>();
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
        setResponse(baseURI + "api/dossier/education","POST",strBody);
        educationIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education","","id[0]","GET");
    }
    @Test(priority = 1)
    public void deleteEducationDossier_InValidEducationId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"122", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteEducationDossier_InValidEducationId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteEducationDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+educationIdforTc, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteEducationDossier_DeletedEducation_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+educationIdforTc, "", 404, "DELETE");
    }
    @Test(priority = 5)
    public void deleteEducationDossier_ResponseTime() {
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+educationIdforTc, "", BENCHMARK_RESPONSE_TIME, "DELETE");

    }
    @AfterTest
    public void DeleteAddedEducation() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/education", "", "id", "GET");
        for (int i = 0; i <= Ids.size() - 1; i++) {
            String Id = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/education/" + Id, "DELETE", "");
        }
    }

}
