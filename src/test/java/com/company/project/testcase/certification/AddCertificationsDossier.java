package com.company.project.testcase.certification;

import com.company.project.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddCertificationsDossier extends BootStrap {
      String apiUrl1 = baseURI + "api/dossier/certifications";
      String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications";

    @Test(priority = 1)
    public void addCertificationsDossier_Blank_name_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 500, "POST");
    }

    @Test(priority = 2)
    public void addCertificationsDossier_Blank_organization_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 500, "POST");
    }

    @Test(priority = 4)
    public void addCertificationsDossier_InValid_issueDate_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"202dd9-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 400, "POST");
    }

    @Test(priority = 5)
    public void addCertificationsDossier_InValid_endYear_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"201dd8-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 400, "POST");
    }

    @Test(priority = 6)
    public void addCertificationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }

    @Test(priority = 7)
    public void addCertificationsDossier_Validate_name() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "name[0]", "Certification 1", "GET", "");
    }

    @Test(priority = 8)
    public void addCertificationsDossier_Validate_Organization() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organization[0]", "ISTQB", "GET", "");
    }

    @Test(priority = 9)
    public void addCertificationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "Added description for certification 1", "GET", "");
    }

    @Test(priority = 10)
    public void addCertificationsDossier_Validate_expireDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "expireDate[0]", "2029-12-05T11:38:43.133", "GET", "");
    }


    @Test(priority = 12)
    public void addCertificationsDossier_Validate_issueDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "issueDate[0]", "2018-12-05T11:38:43.133", "GET", "");
    }

    @Test(priority = 13)
    public void addCertificationsDossier_Blank_Description_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateStatusCode(apiUrl1, strBody, 200, "POST");
    }

    @Test(priority = 14)
    public void addCertificationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl1, strBody, BENCHMARK_RESPONSE_TIME, "POST");
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

