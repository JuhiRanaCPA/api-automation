package com.cpa.search.testcase.certification;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateCertificationsDossier extends BootStrap{
    String certificationId;
    String apiUrl  = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications";

@BeforeTest
public void getCertificationDossier(){
    log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
    String strBody = "{\n" +
            "  \"name\": \"Certification 1\",\n" +
            "  \"organization\": \"ISTQB\",\n" +
            "  \"description\": \"Added description for certification 1\",\n" +
            "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
            "  \"doesNotExpire\": true,\n" +
            "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
            "}";
    setResponse(baseURI + "api/dossier/certifications","POST",strBody);
    certificationId=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id[0]","GET");
}
    @Test(priority = 1)
    public void updateCertificationsDossier_Blank_name_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 500, "PUT");
    }

    @Test(priority = 2)
    public void updateCertificationsDossier_Blank_organization_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 500, "PUT");
    }

       @Test(priority = 4)
    public void updateCertificationsDossier_InValid_issueDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"202dd9-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 400, "PUT");
    }

    @Test(priority = 5)
    public void updateCertificationsDossier_InValid_endYear_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"201dd8-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 400, "PUT");
    }

    @Test(priority = 6)
    public void updateCertificationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Updated Certification 1\",\n" +
                "  \"organization\": \"Updated ISTQB\",\n" +
                "  \"description\": \"Updated Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-02-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-02-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 200, "PUT");
    }

    @Test(priority = 7)
    public void updateCertificationsDossier_Validate_name() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "name[0]", "Updated Certification 1", "GET", "");
    }

    @Test(priority = 8)
    public void updateCertificationsDossier_Validate_Organization() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organization[0]", "Updated ISTQB", "GET", "");
    }

    @Test(priority = 9)
    public void updateCertificationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "Updated Added description for certification 1", "GET", "");
    }

    @Test(priority = 10)
    public void updateCertificationsDossier_Validate_expireDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "expireDate[0]", "2029-02-05T11:38:43.133", "GET", "");
    }

    @Test(priority = 12)
    public void updateCertificationsDossier_Validate_issueDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "issueDate[0]", "2018-02-05T11:38:43.133", "GET", "");
    }

    @Test(priority = 13)
    public void updateCertificationsDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(baseURI + "api/dossier/certifications/"+certificationId, strBody, 200, "PUT");
    }

    @Test(priority = 14)
    public void updateCertificationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/certifications/"+certificationId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void DeleteAddedCertifications() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/certifications/" + Id, "DELETE", "");
        }
    }
}