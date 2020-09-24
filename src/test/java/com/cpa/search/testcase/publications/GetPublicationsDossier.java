package com.cpa.search.testcase.publications;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetPublicationsDossier extends BootStrap{
    String publicationsIdforTc;
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications";

    @BeforeTest
    public void getPublicationsDossierId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/publications/" + Id, "DELETE", "");
        }
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        setResponse(baseURI + "api/dossier/publications","POST",strBody);
        publicationsIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id[0]","GET");
    }
    @Test(priority = 1)
    public void getPublicationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 4)
    public void getPublicationsDossier_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[0]", "Api Testing publications", "GET", "");
    }
    @Test(priority = 5)
    public void getPublicationsDossier_Validate_publisher() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "publisher[0]", "Api automation framework", "GET", "");
    }
    @Test(priority = 6)
    public void getPublicationsDossier_Validate_authors() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "authors[0]", "Jesse", "GET", "");
    }
    @Test(priority = 7)
    public void getPublicationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "added new description of Api Testing publication", "GET", "");
    }
    @Test(priority = 8)
    public void getPublicationsDossier_Validate_date() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "date[0]", "2018-12-24T05:13:06.58", "GET", "");
    }
    @Test(priority = 9)
    public void getPublicationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 10)
    public void DeleteAddedPublications(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/publications/"+publicationsIdforTc, "DELETE", "");
    }
}