package com.cpa.search.testcase.project;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteProject extends BootStrap{
    String projectId = "";
    String apiUrl = baseURI + "api/projects/";
    List<String> projectIds= new ArrayList<>();
    String projectCaseNo = "AddProject" + generateRandom(5);
    String date = getCurrentDate("yyyy-MM-dd");

  @BeforeTest
  public void addProjectId() {
      log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");

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
      apiUrl=apiUrl+projectId+"/delete";
  }
    @Test(priority = 1)
    public void deleteProject_InvalidCase_404() {
        String apiUrlwithKeyValue = apiUrl + "q12";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrlwithKeyValue, "", 404, "DELETE");
    }
    @Test(priority = 2)
    public void deleteProject_InvalidCase_ResponseMessage() {
        String apiUrlwithKeyValue = apiUrl + "q12";
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseMessage(apiUrlwithKeyValue, "", "The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.", "DELETE");
    }
    @Test(priority = 3)
    public void deleteProject_DeleteValidGroup_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl, "", 200, "DELETE");
    }
    @Test(priority = 4)
    public void deleteProject_ResponseTime() {
            log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//            for(int i=0; i<=2;i++) {
//                String strBody = "{\n" +
//                        "  \"caseOrMatterNumber\": \"" + projectCaseNo + "\",\n" +
//                        "  \"technicalField\": \"Chemistry\",\n" +
//                        "  \"projectType\": \"freedomToOperate\",\n" +
//                        "  \"clientName\": \"\",\n" +
//                        "  \"projectTitle\": \"" + projectCaseNo + " Title\",\n" +
//                        "  \"deliveryOption\": \"standard\",\n" +
//                        "  \"descriptionOfInvention\": \"\",\n" +
//                        "  \"knownPriorArt\": \"\",\n" +
//                        "  \"budget\": \"\",\n" +
//                        "  \"otherOrderInformationOrComments\": \"\",\n" +
//                        "  \"attachments\": [],\n" +
//                        "  \"rate\": 0,\n" +
//                        "  \"hours\": 0,\n" +
//                        "  \"contactCode\": \"\",\n" +
//                        "  \"currency\": \"EUR\",\n" +
//                        "  \"noDocumentCopyrightFees\": false,\n" +
//                        "  \"noDocumentServiceFees\": false,\n" +
//                        "  \"ccEmails\": \"\",\n" +
//                        "  \"usersSharesIds\": null,\n" +
//                        "  \"startDate\": \"" + date + "\"\n" +
//                        "}";
//                projectIds.add(i,getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST"));
//            }
        validateResponseTime(this.getClass().getSimpleName(),apiUrl,"",BENCHMARK_RESPONSE_TIME,"DELETE");
//            for (int i=0;i<=2;i++){
//                setResponse(baseURI + "api/projects/" + projectIds.get(i),"DELETE", "");
//            }
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/" + projectId,"DELETE", "");
    }
}
