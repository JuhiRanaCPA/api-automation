package com.cpa.search.testcase.language;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetLanguagesDossier extends BootStrap{
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
    public void getLanguagesDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getLanguagesDossier_Validate_name() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"name[0]","German","GET","");
    }
    @Test(priority = 3)
    public void getLanguagesDossier_Validate_proficiency() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"proficiency[0]","professional","GET","");
    }
    @Test(priority = 4)
    public void getLanguagesDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
        setResponse(baseURI + "api/dossier/languages/" + languageId, "DELETE", "");
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
