package com.cpa.search.testcase.proposals;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class PostAcceptsProposalsByProposalId extends BootStrap{
    LocalDateTime currentDateTime = LocalDateTime.now();
    String currentDate = currentDateTime.minusDays(0).toString();
    String projectId, proposalId = "";
    String apiUrl = baseURI + "api/projects/";
    @BeforeTest
    public void addProjectAndProposal() {
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
                "  \"title\": \"P2\",\n" +
                "  \"summary\": \"P2Sum\",\n" +
                "  \"pricingOptions\": [],\n" +
                "  \"currency\": \"USD\",\n" +
                "  \"deliverables\": null,\n" +
                "  \"attachments\": [],\n" +
                "  \"phases\": [\n" +
                "    {\n" +
                "      \"id\": null,\n" +
                "      \"proposalId\": null,\n" +
                "      \"description\": \"P1P1Desc\",\n" +
                "      \"sequence\": 1,\n" +
                "      \"effectiveDate\": \"2030-01-03\",\n" +
                "      \"options\": [\n" +
                "        {\n" +
                "          \"id\": null,\n" +
                "          \"description\": \"P1P1O1\",\n" +
                "          \"sequence\": 1,\n" +
                "          \"price\": 1000,\n" +
                "          \"deliveredBy\": \"2023-01-03\",\n" +
                "          \"exclusive\": false,\n" +
                "          \"isAccepted\": false,\n" +
                "          \"elements\": [\n" +
                "            {\n" +
                "              \"id\": null,\n" +
                "              \"description\": \"English Language Global Electronic Patent and Technical Literature Search P1P1O1\",\n" +
                "              \"sequence\": 1,\n" +
                "              \"price\": 500\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": null,\n" +
                "              \"description\": \"Document Retrieval Budget P1P1O1\",\n" +
                "              \"sequence\": 2,\n" +
                "              \"price\": 500\n" +
                "            }\n" +
                "          ],\n" +
                "          \"check\": false,\n" +
                "          \"disabled\": false\n" +
                "        },\n" +
                "       ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"expired\": \"2040-01-03\",\n" +
                "  \"specification\": {\n" +
                "    \"customerNeed\": \"A\",\n" +
                "    \"productFeatures\": \"B\",\n" +
                "    \"keyInventiveConcept\": \"H\",\n" +
                "    \"technicalVariants\": \"P\",\n" +
                "    \"embodiments\": \"I\",\n" +
                "    \"targetClaimLimitations\": \"K\",\n" +
                "    \"uncoveredPriorArt\": \"L\",\n" +
                "    \"patentJurisdictions\": \"Q\",\n" +
                "    \"familyMembers\": \"R\",\n" +
                "    \"fileHistory\": \"M\",\n" +
                "    \"oppositionProceedings\": \"N\",\n" +
                "    \"previousLitigation\": \"O\",\n" +
                "    \"dateRange\": \"J\",\n" +
                "    \"searchingEfforts\": \"C\",\n" +
                "    \"relatedLiterature\": \"\",\n" +
                "    \"knownLiterature\": \"D\",\n" +
                "    \"knownInventors\": \"E\",\n" +
                "    \"geographicRequirement\": \"S\",\n" +
                "    \"languageRequirement\": \"F\",\n" +
                "    \"specialRequirement\": \"G\",\n" +
                "    \"includeKnownLiterature\": \"No\",\n" +
                "    \"documentLegalStatus\": \"Live and expired patents and application\"\n" +
                "  },\n" +
                "  \"coverage\": {\n" +
                "    \"englishLanguageGlobalPatent\": true,\n" +
                "    \"englishLanguageElectronicTechnical\": false,\n" +
                "    \"techAutomotive\": false,\n" +
                "    \"techBiotechnology\": true,\n" +
                "    \"techBiotechnologySequences\": true,\n" +
                "    \"techChemistry\": false,\n" +
                "    \"techChemistryStructures\": false,\n" +
                "    \"techComputing\": false,\n" +
                "    \"techElectricalComputingStandards\": false,\n" +
                "    \"techElectricalWhitePapers\": false,\n" +
                "    \"techPhysicsOptics\": false,\n" +
                "    \"techReferenceDesk\": false,\n" +
                "    \"englishLanguageManualLibrary\": false,\n" +
                "    \"germanLanguageGlobalPatent\": false,\n" +
                "    \"germanLanguageElectronicTechnical\": true,\n" +
                "    \"germanTechComputer\": true,\n" +
                "    \"frenchLanguageGlobalPatent\": false,\n" +
                "    \"frenchLanguageElectronicTechnical\": false,\n" +
                "    \"frenchTechBioSciences\": false,\n" +
                "    \"frenchTechChemistry\": false,\n" +
                "    \"japaneseLanguageGlobalPatent\": false,\n" +
                "    \"japaneseLanguageElectronicTechnical\": false,\n" +
                "    \"japaneseLanguageManual\": false,\n" +
                "    \"chineseLanguageElectronicPatent\": false,\n" +
                "    \"chineseLanguageElectronicTechnical\": false,\n" +
                "    \"chineseLanguageManual\": false,\n" +
                "    \"koreanLanguageElectronicPatent\": false,\n" +
                "    \"koreanLanguageElectronicTechnical\": false,\n" +
                "    \"koreanLanguageManual\": false\n" +
                "  },\n" +
                "  \"invalidity\": [\n" +
                "    {\n" +
                "      \"id\": null,\n" +
                "      \"proposalId\": null,\n" +
                "      \"sequence\": 1,\n" +
                "      \"firstInventor\": \"iNV 1\",\n" +
                "      \"claims\": \"Claims 1\",\n" +
                "      \"patentNumber\": \"pATENT1\",\n" +
                "      \"criticalDate\": \"29 Nov 2020\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        proposalId = getValueFromResponse(baseURI + "api/projects/" + projectId + "/proposals", strBody1, "id", "POST");
        apiUrl = apiUrl +projectId+"/proposals/"+proposalId+"/accept";
    }
    @Test(priority = 1)
    public void postAcceptsProposalsByProposalId_UnpublishedProject_500() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"content\": \"Un publishing proposal as needs some changes in pricing\"\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 500, "POST");
    }
    //    @Test(priority = 2)
//    public void postAcceptsProposalsByProposalId_UnpublishedProject_ResponseMessage() {
//        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
//        String strBody ="{\n" +
//                "  \"content\": \"Un publishing proposal as needs some changes in pricing\"\n" +
//                "}";
//        validateKeyValueFromResponse(apiUrl,"message","Proposal cannot be unpublished in current project state.","POST",strBody);
//    }
    @Test(priority = 3)
    public void postAcceptsProposalsByProposalId_Accept_PublishedProject_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String publishstrBody = "{\n" +
                "  \"sectionsToPublish\": [\n" +
                "    \"proposal\",\n" +
                "    \"team\"\n" +
                "  ],\n" +
                "  \"projectId\": \""+projectId+"\",\n" +
                "  \"message\": \"\",\n" +
                "  \"changedBy\": \"4452647f-1356-406d-ab02-7ecf12ccb671\",\n" +
                "  \"generateReportZipFile\": false\n" +
                "}";
        setResponse(baseURI + "api/projects/"+projectId+"/publish","POST",publishstrBody);
        String strBody ="{\n" +
                "  \"comment\": {\n" +
                "    \"type\": \"communication\",\n" +
                "    \"communicationType\": \"phone\",\n" +
                "    \"communicationDate\": \""+currentDate+"Z\",\n" +
                "    \"comment\": {\n" +
                "      \"content\": \"<div>accepting with price</div>\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"SelectedOptions\": []\n" +
                "}";
        validateStatusCode(apiUrl, strBody, 200, "POST");
    }
    @Test(priority = 4)
    public void postAcceptsProposalsByProposalId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"content\": \"Un publishing proposal as needs some changes in pricing\"\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl, strBody, BENCHMARK_RESPONSE_TIME, "POST");
    }


    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}