package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddProjectByCloning extends BootStrap{
    String projectId ="";
    String apiUrl = baseURI + "api/projects/clone";
    @BeforeTest
    public void addProject() {
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
    }
    @Test(priority = 1)
    public void AddProjectByCloning_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"originalProjectId\": \""+projectId+"\",\n" +
                "  \"projectAttributes\": [\n" +
                "    {\n" +
                "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
                "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
                "    }"+
                "  ]\n" +
                "}";

        validateStatusCode(apiUrl, strBody, 200, "POST");
//        String searchStrBody ="{\n" +
//                "  \"filter\": {\n" +
//                "  \"caseOrMatterNumber\": \"\",\n" +
//                "  }\n" +
//                "}";
//        String projectId= getValueFromResponse(baseURI + "api/projects/search",searchStrBody,"result.id[0]","POST");
//        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }

    @Test(priority = 2)
    public void AddProjectByCloning_With_Null_ProjectId_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"originalProjectId\": \"\",\n" +
                "  \"projectAttributes\": [\n" +
                "    {\n" +
                "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
                "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
                "    }"+
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }

//    @Test(priority = 3)
//    public void AddProjectByCloning_With_Null_ProjectId_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"originalProjectId\": \"\",\n" +
//                "  \"projectAttributes\": [\n" +
//                "    {\n" +
//                "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
//                "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
//                "    }"+
//                "  ]\n" +
//                "}";
//      validateKeyValueFromResponse(apiUrl,"Message", "Error converting value \\\"\\\" to type 'System.Guid'. Path 'originalProjectId', line 2, position 25.","POST",strBody);
//    }

    @Test(priority = 4)
    public void AddProjectByCloning_With_Invalid_ProjectId_400() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody = "{\n" +
                "  \"originalProjectId\": \"InvalidProjectId\",\n" +
                "  \"projectAttributes\": [\n" +
                "    {\n" +
                "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
                "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
                "    }"+
                "  ]\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 400, "POST");
    }
//    @Test(priority = 5)
//    public void AddProjectByCloning_With_Invalid_ProjectId_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody = "{\n" +
//                "  \"originalProjectId\": \"InvalidProjectId\",\n" +
//                "  \"projectAttributes\": [\n" +
//                "    {\n" +
//                "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
//                "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
//                "    }"+
//                "  ]\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"Message", "Error converting value \\\"InvalidProjectId\\\" to type 'System.Guid'. Path 'originalProjectId', line 2, position 28.","POST",strBody);
//    }
        @Test(priority = 6)
        public void AddProjectByCloning__ResponseTime() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
            String strBody = "{\n" +
                    "  \"originalProjectId\": \""+projectId+"\",\n" +
                    "  \"projectAttributes\": [\n" +
                    "    {\n" +
                    "      \"cpaReferenceNumber\": \""+projectId+"_CloneProj_1\",\n" +
                    "      \"patentNumbers\": \""+projectId+"_CloneProj_1_PatentNo\"\n" +
                    "    }"+
                    "  ]\n" +
                    "}";
            validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
//            String searchStrBody ="{\n" +
//                    "  \"filter\": {\n" +
//                    "  \"caseOrMatterNumber\": \"\",\n" +
//                    "  }\n" +
//                    "}";
//                      for(int i=0;i<=2;i++) {
//                String Id = getValueFromResponse(baseURI + "api/projects/search",searchStrBody,"result.id[0]","POST");
//                setResponse(baseURI + "api/projects/"+ Id, "DELETE", "");
//            }
        }

    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }
}