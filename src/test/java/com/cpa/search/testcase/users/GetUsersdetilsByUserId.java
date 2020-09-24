package com.cpa.search.testcase.users;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class GetUsersdetilsByUserId extends BootStrap{
    String apiUrl = baseURI + "api/users/details/99e206d1-309d-41f5-a40d-6e7a38cf04c2";

    @Test(priority = 1)
    public void getUsersdetilsByUserId_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
       validateStatusCode( apiUrl, "", 200, "GET");
    }
    @Test(priority = 2)
    public void getUsersdetilsByUserId_404(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode( apiUrl+"asda", "", 404, "GET");
    }
    @Test(priority = 3)
    public void getUsersdetilsByUserId_ReponseMessage(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage( apiUrl+"asda", "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "GET");
    }
    @Test(priority = 4)
    public void getUsersdetilsByUserId_Validate_OrgId_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organization.id", "14345168-e82e-4164-b654-e4b0845ea000", "GET", "");
    }
    @Test(priority = 5)
    public void getUsersdetilsByUserId_Validate_OrgName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "organization.name", "IPC Dev - Goodman & Co.", "GET", "");
    }
    @Test(priority = 5)
    public void getUsersdetilsByUserId_Validate_Id_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id", "99e206d1-309d-41f5-a40d-6e7a38cf04c2", "GET", "");
    }
    @Test(priority = 6)
    public void getUsersdetilsByUserId_Validate_FirstName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "firstname", "Joella", "GET", "");
    }
    @Test(priority = 7)
    public void getUsersdetilsByUserId_Validate_LastName__Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "lastname", "Bennett", "GET", "");
    }
    @Test(priority = 8)
    public void getUsersdetilsByUserId_Validate_Email_Joella_Bennett() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "email", "joella.bennett@nomail.example.com", "GET", "");
    }
    @Test(priority = 9)
    public void getUsersdetilsByUserId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, "", BENCHMARK_RESPONSE_TIME, "GET");
    }
}
