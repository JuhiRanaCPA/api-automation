package com.cpa.search.testcase.experience;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetExperienceDossier extends BootStrap{
    String experienceId = "";
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience";

    @BeforeTest
    public void getExperienceDossierw() {
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
        setResponse(baseURI + "api/dossier/experience","POST",strBody);
        experienceId= getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience","","id[0]","GET");
    }
    @Test(priority = 1)
    public void getExperienceDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getExperienceDossier_Validate_title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"title[0]","Testing Api Data Title","GET","");
    }
    @Test(priority = 3)
    public void getExperienceDossier_Validate_location() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"location[0]","Testing Api Data Location","GET","");
    }
    @Test(priority = 4)
    public void getExperienceDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"description[0]","Testing Api Data  Description","GET","");
    }
    @Test(priority = 5)
    public void getExperienceDossier_Validate_startYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"startDate[0]","2019-12-03T15:40:44.13","GET","");
    }
    @Test(priority = 6)
    public void getExperienceDossier_Validate_company() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"company[0]","Testing Api Data Company","GET","");
    }
    @Test(priority = 7)
    public void getExperienceDossier_Validate_endYear() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"endDate[0]","2019-12-03T15:40:44.13","GET","");
    }
    @Test(priority = 8)
    public void getExperienceDossier_Validate_current_True() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"current[0]","true","GET","");
    }
    @Test(priority = 9)
    public void getExperienceDossier_Validate_Id() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"id[0]",experienceId,"GET","");
    }
    @Test(priority = 9)
    public void getExperienceDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 10)
    public void DeleteAddedExperience(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/experience/"+experienceId, "DELETE", "");
    }
}
