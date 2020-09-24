package com.cpa.search.testcase.dossier;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetDossierOfLoggedInUser extends BootStrap{
     String apiUrl = baseURI + "api/dossier";

    @Test(priority = 1)
    public void getDossierOfLoggedInUser_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "GET");
    }
    @Test(priority = 3)
    public void getProjectById_ValidateResponse_userId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "userId", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }
    @Test(priority = 4)
    public void getProjectById_ValidateResponse_firstname() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "firstname", "Jesse", "GET", "");
    }
    @Test(priority = 5)
    public void getProjectById_ValidateResponse_lastname() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "lastname", "Pinkman", "GET", "");
    }
    @Test(priority = 6)
    public void getProjectById_ValidateResponse_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "email", "jesse.pinkman@nomail.example.com", "GET", "");
    }
    @Test(priority = 7)
    public void getProjectById_ValidateResponse_avatar() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "avatar", "https://www.gravatar.com/avatar/7d9e252c1cf49663eccae772ba79581d?d=mp", "GET", "");
    }
      @Test(priority = 8)
    public void getProjectById_ValidateResponse_rating() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "rating", "0.0", "GET", "");
    }
    @Test(priority = 9)
    public void getProjectById_ValidateResponse_totalProjects() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "totalProjects", "0", "GET", "");
    }
    @Test(priority = 10)
    public void getProjectById_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");

    }

}
