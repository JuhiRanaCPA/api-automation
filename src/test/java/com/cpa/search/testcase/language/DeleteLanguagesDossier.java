package com.cpa.search.testcase.language;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteLanguagesDossier extends BootStrap{
    List<String> languageIds = new ArrayList<>();
    String languageId;
    String apiUrl = baseURI + "api/dossier/languages/";
    String strBody = "{\n" +
            "  \"name\": \"German\",\n" +
            "  \"proficiency\": \"professional\"\n" +
            "}";

    @BeforeTest
    public void getLanguageDossier() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/languages", "POST", strBody);
        languageId = getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages", "", "id[0]", "GET");
    }

    @Test(priority = 1)
    public void deleteLanguagesDossier_InValidExperienceId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "122", "", 404, "DELETE");
    }

    @Test(priority = 2)
    public void deleteLanguagesDossier_InValidExperienceId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl + "111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }

    @Test(priority = 3)
    public void deleteLanguagesDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + languageId, "", 200, "DELETE");
    }

    @Test(priority = 4)
    public void deleteLanguagesDossier_DeletedExperience_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + languageId, "", 404, "DELETE");
    }

    @Test(priority = 5)
    public void deleteLanguagesDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        for (int i = 0; i < 3; i++) {
//            String id = getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages", strBody, "id", "POST");
//            languageIds.add(i, id);
//        }
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + languageId, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }

    @AfterTest
    public void DeleteAddedLanguages() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/languages", "", "id", "GET");
        for (int i = 0; i <= Ids.size() - 1; i++) {
            String Id = Ids.get(i);
            // String educationId = getValueFromResponse(apiUrl, "", "id[0]", "GET");
            setResponse(baseURI + "api/dossier/languages/" + Id, "DELETE", "");
        }
    }
}
