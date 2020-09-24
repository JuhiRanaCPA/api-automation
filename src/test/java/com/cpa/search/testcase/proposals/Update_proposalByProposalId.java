package com.cpa.search.testcase.proposals;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class Update_proposalByProposalId extends BootStrap{
    String projectId, proposalId = "";
     String apiUrl = baseURI + "api/projects/";
    @BeforeTest
    public void addProjectAndProposal(){
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
        String strBody1 ="{\n" +
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
        proposalId= getValueFromResponse(baseURI + "api/projects/"+projectId+"/proposals",strBody1,"id","POST");
        apiUrl =apiUrl+projectId+"/proposals";
    }
    @Test(priority = 1)
    public void update_proposalByProposalId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"P2_Updated\",\n" +
                "  \"summary\": \"P2Sum _updated\",\n" +
                "  \"pricingOptions\": [],\n" +
                "  \"currency\": \"BBD\",\n" +
                "  \"deliverables\": null,\n" +
                "  \"attachments\": [],\n" +
                "  \"phases\": [],\n" +
                "  \"expired\": \"2023-11-17T18:30:00.000Z\",\n" +
                "  \"specification\": {\n" +
                "    \"customerNeed\": \"A_updated\",\n" +
                "    \"productFeatures\": \"B_updated\",\n" +
                "    \"keyInventiveConcept\": \"H_updated\",\n" +
                "    \"technicalVariants\": \"P_updated\",\n" +
                "    \"embodiments\": \"I_updated\",\n" +
                "    \"targetClaimLimitations\": \"K_updated\",\n" +
                "    \"uncoveredPriorArt\": \"L_updated\",\n" +
                "    \"patentJurisdictions\": \"Q_updated\",\n" +
                "    \"familyMembers\": \"R_updated\",\n" +
                "    \"fileHistory\": \"M_updated\",\n" +
                "    \"oppositionProceedings\": \"N_updated\",\n" +
                "    \"previousLitigation\": \"O_updated\",\n" +
                "    \"dateRange\": \"J_updated\",\n" +
                "    \"searchingEfforts\": \"C_updated\",\n" +
                "    \"relatedLiterature\": \"\",\n" +
                "    \"knownLiterature\": \"D_updated\",\n" +
                "    \"knownInventors\": \"E_updated\",\n" +
                "    \"geographicRequirement\": \"S_updated\",\n" +
                "    \"languageRequirement\": \"F_updated\",\n" +
                "    \"specialRequirement\": \"G_updated\",\n" +
                "    \"includeKnownLiterature\": \"N/A\",\n" +
                "    \"documentLegalStatus\": \"Only live patents\"\n" +
                "  },\n" +
                "  \"coverage\": {\n" +
                "    \"englishLanguageGlobalPatent\": false,\n" +
                "    \"englishLanguageElectronicTechnical\": true,\n" +
                "    \"techAutomotive\": false,\n" +
                "    \"techBiotechnology\": false,\n" +
                "    \"techBiotechnologySequences\": false,\n" +
                "    \"techChemistry\": false,\n" +
                "    \"techChemistryStructures\": false,\n" +
                "    \"techComputing\": false,\n" +
                "    \"techElectricalComputingStandards\": true,\n" +
                "    \"techElectricalWhitePapers\": false,\n" +
                "    \"techPhysicsOptics\": false,\n" +
                "    \"techReferenceDesk\": false,\n" +
                "    \"englishLanguageManualLibrary\": true,\n" +
                "    \"germanLanguageGlobalPatent\": false,\n" +
                "    \"germanLanguageElectronicTechnical\": false,\n" +
                "    \"germanTechComputer\": false,\n" +
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
                "  }\n" +
                "}";
        validateStatusCode(apiUrl+"/"+proposalId, strBody, 200, "PUT");
    }
    @Test(priority = 2)
    public void update_proposalByProposalId_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"proposalTitle[0]","P2_Updated","GET","");
    }
    @Test(priority = 3)
    public void update_proposalByProposalId_Validate_Summary() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"summary[0]","P2Sum _updated","GET","");
    }
    @Test(priority = 4)
    public void update_proposalByProposalId_Validate_proposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"id[0]",proposalId,"GET","");
    }
    @Test(priority = 5)
    public void update_proposalByProposalId_Validate_currency() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"currency[0]","BBD","GET","");
    }
    @Test(priority = 6)
    public void update_proposalByProposalId_Validate_expired() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"expired[0]","2023-11-17T18:30:00+00:00","GET","");
    }
    @Test(priority = 7)
    public void update_proposalByProposalId_Validate_ProposalState() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"proposalState[0]","notAnswered","GET","");
    }
   @Test(priority = 8)
    public void update_proposalByProposalId_Validate_Proposal_Specification_ProposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].proposalId",proposalId,"GET","");
    }
    @Test(priority = 9)
    public void update_proposalByProposalId_Validate_Proposal_Specification_customerNeed() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].customerNeed","A_updated","GET","");
    }
    @Test(priority = 10)
    public void update_proposalByProposalId_Validate_Proposal_Specification_productFeatures() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].productFeatures","B_updated","GET","");
    }
    @Test(priority = 11)
    public void update_proposalByProposalId_Validate_Proposal_Specification_uncoveredPriorArt() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].uncoveredPriorArt","L_updated","GET","");
    }
    @Test(priority = 12)
    public void update_proposalByProposalId_Validate_Proposal_Specification_keyInventiveConcept() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].keyInventiveConcept","H_updated","GET","");
    }
    @Test(priority = 13)
    public void update_proposalByProposalId_Validate_Proposal_Specification_technicalVariants() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].technicalVariants","P_updated","GET","");
    }
    @Test(priority = 14)
    public void update_proposalByProposalId_Validate_Proposal_Specification_embodiments() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].embodiments","I_updated","GET","");
    }
    @Test(priority = 15)
    public void update_proposalByProposalId_Validate_Proposal_Specification_targetClaimLimitations() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].targetClaimLimitations","K_updated","GET","");
    }

    @Test(priority = 17)
    public void update_proposalByProposalId_Validate_Proposal_Specification_familyMembers() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].familyMembers","R_updated","GET","");
    }
    @Test(priority = 18)
    public void update_proposalByProposalId_Validate_Proposal_Specification_oppositionProceedings() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].fileHistory","M_updated","GET","");
    }
    @Test(priority = 19)
    public void update_proposalByProposalId_Validate_Proposal_Specification_dateRange() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].dateRange","J_updated","GET","");
    }
    @Test(priority = 20)
    public void update_proposalByProposalId_Validate_Proposal_Specification_searchingEfforts() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].searchingEfforts","C_updated","GET","");
    }
    @Test(priority = 21)
    public void update_proposalByProposalId_Validate_Proposal_Specification_relatedLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].relatedLiterature","","GET","");
    }
    @Test(priority = 22)
    public void update_proposalByProposalId_Validate_Proposal_Specification_knownLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].knownLiterature","D_updated","GET","");
    }
    @Test(priority = 23)
    public void update_proposalByProposalId_Validate_Proposal_Specification_knownInventors() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].knownInventors","E_updated","GET","");
    }
    @Test(priority = 24)
    public void update_proposalByProposalId_Validate_Proposal_Specification_geographicRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].geographicRequirement","S_updated","GET","");
    }
    @Test(priority = 25)
    public void update_proposalByProposalId_Validate_Proposal_Specification_languageRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].languageRequirement","F_updated","GET","");
    }
    @Test(priority = 26)
    public void update_proposalByProposalId_Validate_Proposal_Specification_specialRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].specialRequirement","G_updated","GET","");
    }
    @Test(priority = 27)
    public void update_proposalByProposalId_Validate_Proposal_Specification_includeKnownLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].includeKnownLiterature","N/A","GET","");
    }
    @Test(priority = 28)
    public void update_proposalByProposalId_Validate_Proposal_Specification_documentLegalStatus() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"specification[0].documentLegalStatus","Only live patents","GET","");
    }
    @Test(priority = 29)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_ProposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].proposalId",proposalId,"GET","");
    }
    @Test(priority = 30)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_englishLanguageGlobalPatent() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].englishLanguageGlobalPatent","false","GET","");
    }
    @Test(priority = 31)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_englishLanguageElectronicTechnical() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].englishLanguageElectronicTechnical","true","GET","");
    }
    @Test(priority = 32)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_techAutomotive() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].techAutomotive","false","GET","");
    }
    @Test(priority = 33)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_techBiotechnology() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].techBiotechnology","false","GET","");
    }
    @Test(priority = 34)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_techBiotechnologySequences() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].techBiotechnologySequences","false","GET","");
    }
    @Test(priority = 35)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_techChemistry() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].techChemistry","false","GET","");
    }
    @Test(priority = 36)
    public void update_proposalByProposalId_Validate_Proposal_Coverage_techChemistryStructures() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl,"coverage[0].techChemistryStructures","false","GET","");
    }

    @Test(priority = 37)
    public void update_proposalByProposalId_NullProposalId_405() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"P2_Updated\",\n" +
                "  \"summary\": \"P2Sum _updated\",\n" +
                "  \"pricingOptions\": [],\n" +
                "  \"currency\": \"BBD\",\n" +
                "  \"deliverables\": null,\n" +
                "  \"attachments\": [],\n" +
                "}";
        validateStatusCode(apiUrl, strBody,405, "PUT");
    }
    @Test(priority = 38)
    public void update_proposalByProposalId_IncorrectProposalId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"P2_Updated\",\n" +
                "  \"summary\": \"P2Sum _updated\",\n" +
                "  \"pricingOptions\": [],\n" +
                "  \"currency\": \"BBD\",\n" +
                "  \"deliverables\": null,\n" +
                "  \"attachments\": [],\n" +
                "}";
        validateStatusCode(apiUrl+"/188631-8371873"+proposalId, strBody, 404, "PUT");
    }
    @Test(priority = 39)
    public void update_proposalByProposalId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String strBody ="{\n" +
                "  \"title\": \"P2_Updated\",\n" +
                "  \"summary\": \"P2Sum _updated\",\n" +
                "  \"pricingOptions\": [],\n" +
                "  \"currency\": \"BBD\",\n" +
                "  \"deliverables\": null,\n" +
                "  \"attachments\": [],\n" +
                "  \"phases\": [],\n" +
                "  \"expired\": \"2023-11-17T18:30:00.000Z\",\n" +
                "  \"specification\": {\n" +
                "    \"customerNeed\": \"A_updated\",\n" +
                "    \"productFeatures\": \"B_updated\",\n" +
                "    \"keyInventiveConcept\": \"H_updated\",\n" +
                "    \"technicalVariants\": \"P_updated\",\n" +
                "    \"embodiments\": \"I_updated\",\n" +
                "    \"targetClaimLimitations\": \"K_updated\",\n" +
                "    \"uncoveredPriorArt\": \"L_updated\",\n" +
                "    \"patentJurisdictions\": \"Q_updated\",\n" +
                "    \"familyMembers\": \"R_updated\",\n" +
                "    \"fileHistory\": \"M_updated\",\n" +
                "    \"oppositionProceedings\": \"N_updated\",\n" +
                "    \"previousLitigation\": \"O_updated\",\n" +
                "    \"dateRange\": \"J_updated\",\n" +
                "    \"searchingEfforts\": \"C_updated\",\n" +
                "    \"relatedLiterature\": \"\",\n" +
                "    \"knownLiterature\": \"D_updated\",\n" +
                "    \"knownInventors\": \"E_updated\",\n" +
                "    \"geographicRequirement\": \"S_updated\",\n" +
                "    \"languageRequirement\": \"F_updated\",\n" +
                "    \"specialRequirement\": \"G_updated\",\n" +
                "    \"includeKnownLiterature\": \"N/A\",\n" +
                "    \"documentLegalStatus\": \"Only live patents\"\n" +
                "  },\n" +
                "  \"coverage\": {\n" +
                "    \"englishLanguageGlobalPatent\": false,\n" +
                "    \"englishLanguageElectronicTechnical\": true,\n" +
                "    \"techAutomotive\": false,\n" +
                "    \"techBiotechnology\": false,\n" +
                "    \"techBiotechnologySequences\": false,\n" +
                "    \"techChemistry\": false,\n" +
                "    \"techChemistryStructures\": false,\n" +
                "    \"techComputing\": false,\n" +
                "    \"techElectricalComputingStandards\": true,\n" +
                "    \"techElectricalWhitePapers\": false,\n" +
                "    \"techPhysicsOptics\": false,\n" +
                "    \"techReferenceDesk\": false,\n" +
                "    \"englishLanguageManualLibrary\": true,\n" +
                "    \"germanLanguageGlobalPatent\": false,\n" +
                "    \"germanLanguageElectronicTechnical\": false,\n" +
                "    \"germanTechComputer\": false,\n" +
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
                "  }\n" +
                "}";
        validateResponseTime(this.getClass().getSimpleName(), apiUrl+"/"+proposalId, strBody, BENCHMARK_RESPONSE_TIME, "PUT");
    }
    @AfterTest
    public void deleteProject(){
        setResponse(baseURI + "api/projects/"+projectId,"DELETE", "");
    }
}
