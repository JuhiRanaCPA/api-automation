package com.cpa.search.testcase.sharing;

import com.cpa.search.base.BootStrap;
import org.testng.annotations.Test;

public class DeleteShareIdNonAgmShare  extends BootStrap{
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
        String projectId = getValueFromResponse(baseURI + "api/projects", strBody, "id", "POST");
        String apiUrl = baseURI + "api/projects/"+projectId+"/shares/users/owner";


}
