package com.cpa.search.testcase.experience;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteExperienceDossier extends BootStrap{
    String experienceId;
    String apiUrl = baseURI + "api/dossier/experience/";
    String strBody ="{\n" +
            "  \"title\": \"Testing Api Data Company- Delete Experience\",\n" +
            "  \"company\": \"Testing Api Data compan\",\n" +
            "  \"location\": \"Testing Api Data Location\",\n" +
            "  \"description\": \"Testing Api Data  Description\",\n" +
            "  \"startDate\": \"2019-12-03T15:40:44.131Z\",\n" +
            "  \"endDate\": \"2019-12-03T15:40:44.131Z\"\n" +
            "}";
    @BeforeTest
    public void getExperienceId(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/experience","POST",strBody);
        experienceId =getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience","","id[0]","GET");
    }
    @Test(priority = 1)
    public void deleteExperienceDossier_InValidExperienceId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"122", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteExperienceDossier_InValidExperienceId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteExperienceDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+experienceId, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteExperienceDossier_DeletedExperience_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+experienceId, "", 404, "DELETE");
    }
    @Test(priority = 5)
    public void deleteExperience_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String addedExperiencenId =  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience", strBody, "id", "POST");
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/experience/"+addedExperiencenId, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }

    @AfterTest
    public void DeleteAddedExperience() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/experience", "", "id", "GET");
        for (int i = 0; i <= Ids.size() - 1; i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/experience/" + Id, "DELETE", "");
        }
    }

}