package com.company.project.testcase.certification;

import com.company.project.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteCertifications extends BootStrap {

    String strBody = "{\n" +
            "  \"name\": \"Certification 1\",\n" +
            "  \"organization\": \"ISTQB\",\n" +
            "  \"description\": \"Added description for certification 1\",\n" +
            "  \"issueDate\": \"2018-12-05T11:38:43.133Z\",\n" +
            "  \"doesNotExpire\": true,\n" +
            "  \"expireDate\": \"2029-12-05T11:38:43.133Z\"\n" +
            "}";
    String certificationsIdforTc;
    String apiUrl = baseURI + "api/dossier/certifications/";

    @BeforeTest
    public void getCertificationsDossierId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id","GET");
        for(int i=0;i<=Ids.size()-1;i++) {
            String Id = Ids.get(i);
            setResponse(baseURI + "api/dossier/certifications/" + Id, "DELETE", "");
        }
        setResponse(baseURI + "api/dossier/certifications","POST",strBody);
        certificationsIdforTc=  getValueFromResponse(baseURI + "api/dossier/4452647f-1356-406d-ab02-7ecf12ccb671/certifications","","id[0]","GET");
    }
    @Test(priority = 1)
    public void deleteCertificationsDossier_InValidEducationId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"122", "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteCertificationsDossier_InValidEducationId_Response() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrl+"111", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteCertificationsDossier_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+certificationsIdforTc, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteCertificationsDossier_DeletedEducation_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+certificationsIdforTc, "", 404, "DELETE");
    }
    @Test(priority = 5)
    public void deleteCertificationsDossier_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), baseURI + "api/dossier/certifications/"+certificationsIdforTc, "", BENCHMARK_RESPONSE_TIME, "DELETE");
    }


}