package com.cpa.search.testcase.certification;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetCertificationsDossier  extends BootStrap{
    String certificationsIdforTc;
    String apiUrl = baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications";

    @BeforeTest
    public void getCertificationsDossierId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/certifications/" + Id, "DELETE", "");
        }
        String strBody = "{\n" +
                "  \"name\": \"Certification 1\",\n" +
                "  \"organization\": \"ISTQB\",\n" +
                "  \"description\": \"Added description for certification 1\",\n" +
                "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
                "  \"doesNotExpire\": true,\n" +
                "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
                "}";
        setResponse(baseURI + "api/dossier/certifications","POST",strBody);
        certificationsIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id[0]","GET");
    }
    @Test(priority = 1)
    public void getCertificationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void addCertificationsDossier_Validate_name() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "name[0]", "Certification 1", "GET", "");
    }

    @Test(priority = 3)
    public void addCertificationsDossier_Validate_Organization() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organization[0]", "ISTQB", "GET", "");
    }

    @Test(priority = 4)
    public void addCertificationsDossier_Validate_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "description[0]", "Added description for certification 1", "GET", "");
    }

    @Test(priority = 5)
    public void addCertificationsDossier_Validate_expireDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "expireDate[0]", "2029-12-05T11:38:43.133", "GET", "");
    }

    @Test(priority = 6)
    public void addCertificationsDossier_Validate_issueDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "issueDate[0]", "2018-12-05T11:38:43.133", "GET", "");
    }
    @Test(priority = 7)
    public void getCertificationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
    @Test(priority = 8)
    public void DeleteAddedCertifications(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        setResponse(baseURI + "api/dossier/certifications/"+certificationsIdforTc, "DELETE", "");
    }
}