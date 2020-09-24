package com.cpa.search.testcase.publications;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeletePublicationsDossier extends BootStrap{

    String strBody = "{\n" +
            "  \"title\": \"Updated value of Api Testing publications\",\n" +
            "  \"publisher\": \"Api automation framework\",\n" +
            "  \"authors\": \"Jesse\",\n" +
            "  \"description\": \"added new description of Updated value of Api Testing publication\",\n" +
            "  \"date\": \"2004-10-14T05:13:06.580Z\"\n" +
            "}";
    List<String> IdList= new ArrayList<>();
    String publicationsIdforTc;
    String apiUrl = baseURI + "api/dossier/publications/";

    @BeforeTest
    public void getPublicationsDossierId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id","GET");
        if(Ids.size()>=1){
            for(int i=0;i<=Ids.size()-1;i++) {
                String Id = Ids.get(i);
                setResponse(baseURI + "api/dossier/publications/" + Id, "DELETE", "");
            }}

        setResponse(baseURI + "api/dossier/publications","POST",strBody);
        publicationsIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id[0]","GET");
    }
    @Test(priority = 1)
    public void deletePublicationsDossier_InValidEducationId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"122", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deletePublicationsDossier_InValidEducationId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deletePublicationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+publicationsIdforTc, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deletePublicationsDossier_DeletedEducation_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+publicationsIdforTc, "", 404, "DELETE");
    }
    @Test(priority = 5)
    public void deletePublicationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        for(int i=0;i<3;i++){
//            setResponse(baseURI + "api/dossier/publications","POST",strBody);
//            String Id =  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/publications","","id["+i+"]","GET");
//            IdList.add(i, Id);
//        }
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+publicationsIdforTc, "", BENCHMARK_RESPONSE_TIME, "DELETE");

    }


}