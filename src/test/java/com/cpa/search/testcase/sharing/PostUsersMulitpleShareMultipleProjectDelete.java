package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PostUsersMulitpleShareMultipleProjectDelete extends BootStrap{

    String apiUrl = baseURI + "api/projects/shares/remove";
    ArrayList<String> projectList = new ArrayList<>();

//    @BeforeTest
//    public void getProjectList() {
//        for (int i = 1; i <= 2; i++) {
//            String projectCaseNo = "AddProject PostSharesOwner " + i;
//            String date = getCurrentDate("yyyy-MM-dd");
//            String strBody = "{\n" +
//                    "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
//                    "  \"technicalField\": \"Chemistry\",\n" +
//                    "  \"projectType\": \"freedomToOperate\",\n" +
//                    "  \"clientName\": \"\",\n" +
//                    "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
//                    "  \"deliveryOption\": \"standard\",\n" +
//                    "  \"descriptionOfInvention\": \"\",\n" +
//                    "  \"knownPriorArt\": \"\",\n" +
//                    "  \"budget\": \"\",\n" +
//                    "  \"otherOrderInformationOrComments\": \"\",\n" +
//                    "  \"attachments\": [],\n" +
//                    "  \"rate\": 0,\n" +
//                    "  \"hours\": 0,\n" +
//                    "  \"contactCode\": \"\",\n" +
//                    "  \"currency\": \"EUR\",\n" +
//                    "  \"noDocumentCopyrightFees\": false,\n" +
//                    "  \"noDocumentServiceFees\": false,\n" +
//                    "  \"ccEmails\": \"\",\n" +
//                    "  \"usersSharesIds\": null,\n" +
//                    "  \"startDate\": \"" + date + "\"\n" +
//                    "}";
//            projectList.add(getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST"));
//        }
//    }
//
//    @Test(priority = 1)
//    public void postUsersMultipleShareMultipleProjectsDelete_InvalidProjectIds_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"4452647f-1356-406d-ab0sdd2-7ecf12ccb671\",\n" +
//                "    \"165a6594-d079-47bf-sd-405d603899c0\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//                "    \"79758b5f-25a0-4390-fdd-7297d88aa298\",\n" +
//                "    \"26d2d2fe-c827-4fcb-fd-b74a431715af\",\n" +
//                "    \"eb73a17b-4cb8-482d-fd-81f1e2100594\",\n" +
//                "    \"f31e0ade-9c0c-4e56-dfdf-116b4710b70a\"\n" +
//                "  ]\n" +
//                "}";
//        validateStatusCode(apiUrl, strBody, 400, "POST");
//    }
//
//    @Test(priority = 2)
//    public void postUsersMultipleShareMultipleProjectsDelete_DeleteAllUSers_400() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
//                "    \"165a6594-d079-47bf-9193-405d603899c0\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//                "    \"" + projectList.get(0) + "\",\n" +
//                "    \"" + projectList.get(1) + "\",\n" +
//                "  ]\n" +
//                "}";
//        setResponse(baseURI + "api/projects/shares/multiples","POST",strBody);
//        validateStatusCode(apiUrl, strBody, 400, "POST");
//    }
//    @Test(priority = 3)
//    public void postUsersMultipleShareMultipleProjectsDelete_ResponseMessage_Message(){
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
//                "    \"165a6594-d079-47bf-9193-405d603899c0\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//                "    \"" + projectList.get(0) + "\",\n" +
//                "    \"" + projectList.get(1) + "\",\n" +
//                "  ]\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message","Sequence contains no elements","POST",strBody);
//    }
//    @Test(priority = 4)
//    public void postUsersMultipleShareMultipleProjectsDelete_200() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"165a6594-d079-47bf-9193-405d603899c0\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//            "    \"" + projectList.get(0) + "\",\n" +
//                "    \"" + projectList.get(1) + "\",\n" +
//
//                "  ]\n" +
//                "}";
//        validateStatusCode(apiUrl, strBody, 200, "POST");
//    }
//    @Test(priority = 5)
//    public void postUsersMultipleShareMultipleProjectsDelete_Alreadydeleted_user_200() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"165a6594-d079-47bf-9193-405d603899c0\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//             "    \"" + projectList.get(0) + "\",\n" +
//                "    \"" + projectList.get(1) + "\",\n" +
//
//                "  ]\n" +
//                "}";
//        validateStatusCode(apiUrl, strBody, 200, "POST");
//    }
//
//    @Test(priority = 6)
//    public void postUsersMultipleShareMultipleProjectsDelete_ResponseTime() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"userIds\": [\n" +
//                "    \"4452647f-1356-406d-ab02-7ecf12ccb671\"]\n" +
//                ",\n" +
//                "\n" +
//                "  \"projectIds\": [\n" +
//                "    \"" + projectList.get(0) + "\",\n" +
//                "    \"" + projectList.get(1) + "\",\n" +
//                "  ]\n" +
//                "}";
//        setResponse(baseURI + "api/projects/shares/multiples","POST",strBody);
//        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
//    }
//
//    @AfterTest
//    public void deleteProject() {
//        for (int i = 1; i >= 0; i--) {
//            setResponse(baseURI + "api/projects/" + projectList.get(i), "DELETE", "");
//        }
//
//    }

}
