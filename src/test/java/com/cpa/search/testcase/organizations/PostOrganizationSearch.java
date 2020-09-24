package com.cpa.search.testcase.organizations;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostOrganizationSearch extends BootStrap{
    String apiUrl = baseURI + "api/organizations/search";


    @Test(priority = 1)
    public void postOrganizationSearch_Limit_1_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 20;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 2)
    public void postOrganizationSearch_Limit_1_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 20;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        Assert.assertEquals(idList.size(), limit);
    }

    @Test(priority = 3)
    public void postOrganizationSearch_Limit_0_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 4)
    public void postOrganizationSearch_Limit_0_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        Assert.assertEquals(idList.size(), limit);
    }

    @Test(priority = 5)
    public void postOrganizationSearch_Limit_null_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 6)
    public void postOrganizationSearch_Limit_null_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status ="Pass";
        String finalStatus = "Fail";
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": null\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        if(idList.size()>0){  finalStatus = "Pass"; }
        Assert.assertEquals(status, finalStatus);
    }

    @Test(priority = 7)
    public void GetOrganizationWithName_Limit_1_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        int limit = 20;
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 8)
    public void GetOrganizationWithName_Limit_1_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "A";
        int limit = 20;
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        Assert.assertEquals(idList.size(), limit);
    }

    @Test(priority = 9)
    public void GetOrganizationWithName_Limit_0_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 10)
    public void GetOrganizationWithName_Limit_0_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        Assert.assertEquals(idList.size(), limit);
    }

    @Test(priority = 11)
    public void GetOrganizationWithName_Limit_null_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        int limit = 0;
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority = 12)
    public void GetOrganizationWithName_Limit_null_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        String status ="Pass";
        String finalStatus = "Fail";
        String strBody ="{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"limit\": null\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        if(idList.size()>0){  finalStatus = "Pass"; }
        Assert.assertEquals(status, finalStatus);
    }

    @Test(priority =13)
    public void GetOrganizationWithName_NoName_Field__Request_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 10;
        String strBody ="{\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateStatusCode(apiUrl,strBody,200,"POST");

    }

    @Test(priority =14)
    public void GetOrganizationWithName__NoName_Validate_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status ="Pass";
        String finalStatus = "Fail";
        int limit = 10;
        String strBody ="{\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        if(idList.size()>0){  finalStatus = "Pass"; }
        Assert.assertEquals(status, finalStatus);
    }
    @Test(priority =15)
    public void GetOrganizationWithName__NoLimit_Request_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String name = "AAK";
        String strBody ="{\"name\": \""+name+"\"}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority =16)
    public void GetOrganizationWithName_NoLimit_Validate_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status ="Pass";
        String finalStatus = "Fail";
        String name = "AAK";
        String strBody ="{\"name\": \""+name+"\"}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        System.out.println("list size: "+ idList.size());
        if(idList.size()>0){  finalStatus = "Pass"; }
        Assert.assertEquals(status, finalStatus);
    }
    @Test(priority =15)
    public void GetOrganizationWithName__Null_Request_Request_200(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{}";
        validateStatusCode(apiUrl,strBody,200,"POST");
    }

    @Test(priority =16)
    public void GetOrganizationWithName_Null_Request_Validate_Response_Message(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String status ="Pass";
        String finalStatus = "Fail";
        String strBody ="{}";
        List<String> idList = getAllValuesFromResponse(apiUrl,strBody,"id","POST");
        if(idList.size()>0){  finalStatus = "Pass"; }
        Assert.assertEquals(status, finalStatus);
    }

    @Test(priority = 17)
    public void postOrganizationSearch_ResponseTime(){
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        int limit = 20;
        String strBody ="{\n" +
                "  \"name\": \"\",\n" +
                "  \"limit\": "+limit+"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }
}
