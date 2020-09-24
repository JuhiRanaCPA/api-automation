package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PostSharesOwner extends BootStrap{
    String apiUrl = baseURI + "api/projects/shares/owners";
    ArrayList<String> projectList = new ArrayList<>();

    @BeforeTest
    public void getProjectList() {
        for (int i = 1; i <= 4; i++) {
            String projectCaseNo = "AddProject PostSharesOwner " + i;
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
            projectList.add(getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST"));
        }
    }

    @Test(priority = 1)
    public void postSharesOwner_InvalidProjectIds_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"projectIds\": [\n" +
                "    \"e9918fcb-ed08-438c\",\n" +
                "    \"a4cb21b1-20e9-4f5\",\n" +
                "    \"4366b72a-e00e-44fd\",\n" +
                "    \"41385122-1ea73\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

    @Test(priority = 2)
    public void postSharesOwner_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"projectIds\": [\n" +
                "    \"" + projectList.get(0) + "\",\n" +
                "    \"" + projectList.get(1) + "\",\n" +
                "    \"" + projectList.get(2) + "\",\n" +
                "    \"" + projectList.get(3) + "\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 3)
    public void postSharesOwner_Alreadyadded_user_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"projectIds\": [\n" +
                "    \"" + projectList.get(0) + "\",\n" +
                "    \"" + projectList.get(1) + "\",\n" +
                "    \"" + projectList.get(2) + "\",\n" +
                "    \"" + projectList.get(3) + "\"\n" +
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }

    @Test(priority = 4)
    public void postSharesOwner_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"projectIds\": [\n" +
                "    \"" + projectList.get(0) + "\",\n" +
                "    \"" + projectList.get(1) + "\",\n" +
                "    \"" + projectList.get(2) + "\",\n" +
                "    \"" + projectList.get(3) + "\"\n" +
                "  ]\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProject() {
        for (int i = 3; i >= 0; i--) {
            setResponse(baseURI + "api/projects/" + projectList.get(i), "DELETE", "");
        }

    }
}
