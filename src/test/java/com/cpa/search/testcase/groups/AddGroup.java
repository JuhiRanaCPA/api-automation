package com.cpa.search.testcase.groups;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddGroup extends BootStrap{
    String apiUrl = baseURI + "api/groups/";

    @Test(priority = 1)
    public void addGroup_CreateValidRecordWithUsers_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"" + this.getClass().getSimpleName() + generateRandom(5) + "\",\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "      \"firstname\": \"Jesse\",\n" +
                "      \"lastname\": \"Pinkman\",\n" +
                "      \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
                "      \"isDirector\": true,\n" +
                "      \"userStatusView\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }

    @Test(priority = 2)
    public void addGroup_CreateValidRecordWithoutUsers_201() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"title\": \"" + this.getClass().getSimpleName() + generateRandom(5) + "\"}";
        validateStatusCode(apiUrl, strBody, 201, "POST");
    }

    @Test(priority = 3)
    public void addGroup_MissingMandatoryFieldTitle_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
//                "  \"title\": \"" + this.getClass().getSimpleName() + generateRandom(5) + "\",\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "      \"firstname\": \"Jesse\",\n" +
                "      \"lastname\": \"Pinkman\",\n" +
                "      \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
                "      \"isDirector\": true,\n" +
                "      \"userStatusView\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }


    @Test(priority = 4)
    public void addGroup_MandatoryFieldTitle_With_NullValue_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{ \"title\": \"\",\n" +
                "  \"users\": [\n" +
                "  {\n" +
                "    \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "    \"firstname\": \"Jesse\",\n" +
                "    \"lastname\": \"Pinkman\",\n" +
                "    \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
                "    \"isDirector\": true,\n" +
                "    \"userStatusView\": null\n" +
                "  }\n" +
                "]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }

    @Test(priority = 4)
    public void addGroup_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"title\": \"" + this.getClass().getSimpleName() + generateRandom(5) + "\",\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"id\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "      \"firstname\": \"Jesse\",\n" +
                "      \"lastname\": \"Pinkman\",\n" +
                "      \"email\": \"jesse.pinkman@nomail.example.com\",\n" +
                "      \"isDirector\": true,\n" +
                "      \"userStatusView\": null\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

@AfterTest
public void deleteGroups(){
    List<String> groupList = getAllValuesFromResponse(baseURI + "api/groups","","title","GET");
    for(int i =groupList.size()-1;i>0;i--){
   // for(int i=0; i<=groupList.size()-1;i++){
        if(groupList.get(i).contains("AddGroup")){
            String id = getValueFromResponse(baseURI + "api/groups","","id["+i+"]","GET");
            setResponse(baseURI + "api/groups/"+id,"DELETE","");
        }
    }

}
}
