package com.cpa.search.testcase.patents;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class UpdatePatentById extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    List<String> patentIdsList = new ArrayList<>();
    @BeforeTest
    public void addProjectId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String projectCaseNo = "AddProject" + generateRandom(5);
        String date = getCurrentDate("yyyy-MM-dd");
        String strBody = "{\n" +
                "  \"caseOrMatterNumber\": \""+ projectCaseNo+ "\",\n" +
                "  \"technicalField\": \"Chemistry\",\n" +
                "  \"projectType\": \"freedomToOperate\",\n" +
                "  \"clientName\": \"\",\n" +
                "  \"projectTitle\": \""+projectCaseNo+" Title\",\n" +
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
                "  \"startDate\": \""+date+"\"\n" +
                "}";
        projectId=  getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        apiUrl=apiUrl+  projectId + "/patents/import";
    }
    @Test
    public void ImportPatent() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "[\n" +
                " {\n" +
                "    \"innographyId\": \"I-000101303241\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"20110290232\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182706523\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525361\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182724397\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525362\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  },\n" +
                "  {\n" +
                "    \"innographyId\": \"I-000182738592\",\n" +
                "    \"countryCode\": \"US\",\n" +
                "    \"number\": \"3525363\",\n" +
                "    \"kindCode\": \"\",\n" +
                "    \"searchByKindCode\": false,\n" +
                "    \"keywords\": []\n" +
                "  }\n" +
                "]";
        setResponse(baseURI + "api/projects/" + projectId + "/patents/import","POST",strBody);
        patentIdsList = getAllValuesFromResponse(baseURI + "api/projects/" + projectId + "/references", "", "id", "GET");
        log.info("<====================" + patentIdsList + "====================>");
    }

}
