package com.cpa.search.testcase.language;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddLanguageDossier extends BootStrap{
    String apiUrl = baseURI + "api/dossier/languages";
    String id = "";

    @Test(priority = 1)
    public void addLanguageDossier_Blank_name_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }

    @Test(priority = 2)
    public void addLanguageDossier_Blank_proficiency_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"English\",\n" +
                "  \"proficiency\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    @Test(priority = 3)
    public void addLanguageDossier_Invalid_proficiency_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"English\",\n" +
                "  \"proficiency\": \"sample\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    @Test(priority = 4)
    public void addLanguageDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"German\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addLanguageDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"German\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void DeleteAddedLanguages(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/languages/" + Id, "DELETE", "");
        }}
}
