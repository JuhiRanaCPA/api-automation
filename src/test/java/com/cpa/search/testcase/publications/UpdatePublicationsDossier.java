package com.cpa.search.testcase.publications;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdatePublicationsDossier extends BootStrap{
    String publicationsId;
    String apiUrl  = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications";

@BeforeTest
public void getPublicationsDossierId() {
    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id","GET");
    if(Ids.size()>=1){
    for(int i=0;i<=Ids.size()-1;i++) {
        String Id = Ids.get(i);
        setResponse(baseURI + "api/dossier/publications/" + Id, "DELETE", "");
    }}
    String strBody = "{\n" +
            "  \"title\": \"Updated value of Api Testing publications\",\n" +
            "  \"publisher\": \"Api automation framework\",\n" +
            "  \"authors\": \"Jesse\",\n" +
            "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
            "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
            "}";
    setResponse(baseURI + "api/dossier/publications","POST",strBody);
    publicationsId=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id[0]","GET");
}
    @Test(priority = 1)
    public void updatePublicationsDossier_Blank_title_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 500, "PUT");
    }
    @Test(priority = 2)
    public void updatePublicationsDossier_InValid_Date_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"20183-12-24T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 400, "PUT");
    }
    @Test(priority = 3)
    public void updatePublicationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 200, "PUT");
    }
    @Test(priority = 4)
    public void updatePublicationsDossier_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "title[0]", "Updated value of Api Testing publications", "GET", "");
    }
    @Test(priority = 5)
    public void updatePublicationsDossier_Validate_publisher() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "publisher[0]", "Api automation framework", "GET", "");
    }
    @Test(priority = 6)
    public void updatePublicationsDossier_Validate_authors() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "authors[0]", "Jesse", "GET", "");
    }
    @Test(priority = 7)
    public void updatePublicationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "added new description of Updated value of Api Testing publication", "GET", "");
    }
    @Test(priority = 8)
    public void updatePublicationsDossier_Validate_date() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "date[0]", "2004-10-14T05:13:06.58", "GET", "");
    }
    @Test(priority = 9)
    public void updatePublicationsDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 200, "PUT");
    }

    @Test(priority = 10)
    public void updatePublicationsDossier_Blank_publisher_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 200, "PUT");
    }
    @Test(priority = 11)
    public void updatePublicationsDossier_Blank_Author_20() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/publications/"+publicationsId, strBody, 200, "PUT");
    }
    @Test(priority = 12)
    public void updatePublicationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"Updated value of Api Testing publications\",\n" +
                "  \"publisher\": \"Api automation framework\",\n" +
                "  \"authors\": \"Jesse\",\n" +
                "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
                "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/publications/"+publicationsId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void DeleteAddedPublications() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            setResponse(baseURI + "api/dossier/publications/" + publicationsId, "DELETE", "");
    }
}