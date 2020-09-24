package com.cpa.search.testcase.language;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateLanguagesDossier extends BootStrap{
    String languageId;
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages";

    @BeforeTest
    public void getLanguageDossier(){
        String strBody = "{\n" +
                "  \"name\": \"German\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/languages", "POST",strBody);
        languageId = getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages","","id[0]","GET");
    }
    @Test(priority = 1)
    public void updateLanguageDossier_Blank_name500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        languageId = getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages","","id[0]","GET");
        String strBody = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        validateStatusCode("api/dossier/languages/"+languageId, strBody, 500, "PUT");
    }

    @Test(priority = 2)
    public void updateLanguageDossier_Blank_proficiency_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"English\",\n" +
                "  \"proficiency\": \"\"\n" +
                "}";
        validateStatusCode("api/dossier/languages/"+languageId, strBody, 400, "PUT");
    }

    @Test(priority = 3)
    public void updateLanguageDossier_Invalid_proficiency_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"English\",\n" +
                "  \"proficiency\": \"sample\"\n" +
                "}";
        validateStatusCode("api/dossier/languages/"+languageId, strBody, 400, "PUT");
    }

    @Test(priority = 4)
    public void updateLanguageDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"French\",\n" +
                "  \"proficiency\": \"elementary\"\n" +
                "}";
        validateStatusCode("api/dossier/languages/"+languageId, strBody, 200, "PUT");
    }
    @Test(priority = 5)
    public void updateLanguageDossier_Validate_Name() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[0]","French","GET","");
    }
    @Test(priority = 6)
    public void updateLanguageDossier_Validate_proficiency() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"proficiency[0]","elementary","GET","");
    }
    @Test(priority =7)
    public void updateLanguageDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"German\",\n" +
                "  \"proficiency\": \"professional\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), "api/dossier/languages/"+languageId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
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
