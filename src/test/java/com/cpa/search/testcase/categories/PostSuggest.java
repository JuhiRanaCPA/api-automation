package com.cpa.search.testcase.categories;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PostSuggest extends BootStrap {
    String apiUrl = baseURI + "api/categories/suggest";
    LocalDateTime currentDateTime = LocalDateTime.now();
    String filingDate1 = currentDateTime.minusDays(500).toString();
    String projectId, referenceId = "";

    @BeforeTest
    public void addReferences() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = "AddProject" + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
                "  \"deliveryOption\": \"standard\",\n" +
                "  \"descriptionOfInvention\": \"\",\n" +
                "  \"knownPriorArt\": \"\",\n" +
                "  \"budget\": \"\",\n" +
                "  \"otherOrderInformationOrComments\": \"\",\n" +
                "  \"attachments\": [],\n" +
                "  \"rate\": 0,\n" +
                "  \"hours\": 0,\n" +
                "  \"contactCode\": \"\",\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"noDocumentCopyrightFees\": false,\n" +
                "  \"noDocumentServiceFees\": false,\n" +
                "  \"ccEmails\": \"\",\n" +
                "  \"usersSharesIds\": null,\n" +
                "  \"startDate\": \"" + date + "\"\n" +
                "}";
        projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        String strBody1 = "{\n" +
                "  \"title\": \"Add NPL Reference 1\",\n" +
                "  \"searchTeamComment\": \"Adding general comments for Add NPL Reference 1\",\n" +
                "  \"inventors\": [\n" +
                "    \"Jesse Pinkman\"\n" +
                "  ],\n" +
                "  \"publishDate\": \"" + filingDate1 + "\",\n" +
                "  \"abstract\": \"Adding abstract\",\n" +
                "  \"link\": \"https://www.abc.com\",\n" +
                "  \"citations\": \"Page 1 Paragraph 8\",\n" +
                "  \"source\": \"CPA publication\",\n" +
                "  \"databaseSource\": \"Adding dataBase source\",\n" +
                "  \"doi\": \"10.111/1.2222\"\n" +
                "}";

        referenceId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/references", strBody1, "id", "POST");
        strBody = "{\n" +
                "  \"name\": \"new category added for addCategoriesByReferenceId\"\n" +
                "}";
        setResponse(baseURI + "api/projects/" + projectId + "/references/" + referenceId + "/categories","POST",strBody);
    }

    @Test(priority = 1)
    public void postSuggest_ValidateResponse_Before_Adding_Categories_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"searchString\": \"\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 2)
    public void postSuggest_ValidateResponse_Before_Adding_Categories_Response_Message() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"searchString\": \"\"\n" +
                "}";
       List<String> datalist=  getAllValuesFromResponse(apiUrl,strBody,"names","POST");
    }
}

