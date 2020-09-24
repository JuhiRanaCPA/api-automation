package com.cpa.search.testcase.publications;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddPublicationsDossier extends BootStrap{
      String apiUrl1 = baseURI + "api/dossier/publications";
      String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications";

    @Test(priority = 1)
    public void addPublicationsDossier_Blank_title_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 500, "POST");
    }
    @Test(priority = 2)
    public void addPublicationsDossier_InValid_Date_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"20183-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 400, "POST");
    }
    @Test(priority = 3)
    public void addPublicationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void addPublicationsDossier_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[0]", "Api Testing publications", "GET", "");
    }
    @Test(priority = 5)
    public void addPublicationsDossier_Validate_publisher() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "publisher[0]", "Api automation framework", "GET", "");
    }
    @Test(priority = 6)
    public void addPublicationsDossier_Validate_authors() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "authors[0]", "Jesse", "GET", "");
    }
    @Test(priority = 7)
    public void addPublicationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "added new description of Api Testing publication", "GET", "");
    }
    @Test(priority = 8)
    public void addPublicationsDossier_Validate_date() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "date[0]", "2018-12-24T05:13:06.58", "GET", "");
    }
    @Test(priority = 9)
    public void addPublicationsDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }

    @Test(priority = 10)
    public void addPublicationsDossier_Blank_publisher_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }
    @Test(priority = 11)
    public void addPublicationsDossier_Blank_Author_20() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }
    @Test(priority = 12)
    public void addPublicationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Api Testing publication\",\n" +
                "  \"date\": \"2018-12-24T05:13:06.580Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl1, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
    @AfterTest
    public void DeleteAddedPublications() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/publications/" + Id, "DELETE", "");
        }
    }
}

