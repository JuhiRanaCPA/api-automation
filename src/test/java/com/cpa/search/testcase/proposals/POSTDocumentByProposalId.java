package com.cpa.search.testcase.proposals;

import com.cpa.search.base.BootStrap;
import com.cpa.search.base.BootStrap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class POSTDocumentByProposalId extends BootStrap{
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
        apiUrl = apiUrl + projectId + "/proposals";
    }

    @Test(priority = 1)
    public void postDocumentByProposalId_200() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "/" + proposalId + "/document", "", 200, "POST");
    }

    @Test(priority = 2)
    public void postDocumentByProposalId_Validate_Document_Filename() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].filename[0]", "CPA Global Search Proposal - P2.docx", "GET", "");
    }

    @Test(priority = 3)
    public void postDocumentByProposalId_Validate_Document_mimeType() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].mimeType[0]", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "GET", "");
    }

    @Test(priority = 4)
    public void postDocumentByProposalId_Validate_Document_createdBy_Id() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].createdBy.id[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }

    @Test(priority = 5)
    public void postDocumentByProposalId_Validate_Document_createdBy_FirstName() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].createdBy.firstname[0]", "Jesse", "GET", "");
    }

    @Test(priority = 5)
    public void postDocumentByProposalId_Validate_Document_createdBy_lastname() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].createdBy.lastname[0]", "Pinkman", "GET", "");
    }

    @Test(priority = 6)
    public void postDocumentByProposalId_Validate_Document_createdBy_email() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "attachments[0].createdBy.email[0]", "jesse.pinkman@nomail.example.com", "GET", "");
    }

    @Test(priority = 7)
    public void postDocumentByProposalId_NullProposalId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "/document", "", 404, "POST");
    }

    @Test(priority = 8)
    public void postDocumentByProposalId_IncorrectProposalId_404() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateStatusCode(apiUrl + "/188631-8371873" + proposalId + "/document", "", 404, "POST");
    }

    @Test(priority = 9)
    public void postDocumentByProposalId_Validate_Phases_Options_Price() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].price[0]", "1000.0", "GET", "");
    }

    @Test(priority = 10)
    public void postDocumentByProposalId_Validate_Phases_deliveredBy() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].deliveredBy[0]", "2023-01-03T00:00:00", "GET", "");
    }

    @Test(priority = 11)
    public void postDocumentByProposalId_Validate_Phases_Proposal_CreatedBy() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].createdBy[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }

    @Test(priority = 12)
    public void postDocumentByProposalId_Validate_Phases_Proposal_ModifiedBy() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].modifiedBy[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }

    @Test(priority = 13)
    public void postDocumentByProposalId_Validate_Phases_Options_Elements_Price() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].elements[0].price[0]", "500.0", "GET", "");
    }

    @Test(priority = 14)
    public void postDocumentByProposalId_Validate_Phases_Options_Elements_description() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValuesFromResponse(apiUrl, "phases[0].options[0].elements[0].description", "Document Retrieval Budget P1P1O1", "GET", "");
    }

    @Test(priority = 15)
    public void postDocumentByProposalId_Validate_Phases_Options_Elements_CreatedBy() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].elements[0].createdBy[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }

    @Test(priority = 16)
    public void postDocumentByProposalId_Validate_Phases_Options_Elements_ModifiedBy() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "phases[0].options[0].elements[0].modifiedBy[0]", "4452647f-1356-406d-ab02-7ecf12ccb671", "GET", "");
    }

    @Test(priority = 17)
    public void postDocumentByProposalId_Validate_Proposal_Specification_ProposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].proposalId", proposalId, "GET", "");
    }

    @Test(priority = 18)
    public void postDocumentByProposalId_Validate_Proposal_Specification_customerNeed() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].customerNeed", "A", "GET", "");
    }

    @Test(priority = 19)
    public void postDocumentByProposalId_Validate_Proposal_Specification_productFeatures() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].productFeatures", "B", "GET", "");
    }

    @Test(priority = 20)
    public void postDocumentByProposalId_Validate_Proposal_Specification_uncoveredPriorArt() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].uncoveredPriorArt", "L", "GET", "");
    }

    @Test(priority = 21)
    public void postDocumentByProposalId_Validate_Proposal_Specification_keyInventiveConcept() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].keyInventiveConcept", "H", "GET", "");
    }

    @Test(priority = 22)
    public void postDocumentByProposalId_Validate_Proposal_Specification_technicalVariants() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].technicalVariants", "P", "GET", "");
    }

    @Test(priority = 23)
    public void postDocumentByProposalId_Validate_Proposal_Specification_embodiments() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].embodiments", "I", "GET", "");
    }

    @Test(priority = 24)
    public void postDocumentByProposalId_Validate_Proposal_Specification_targetClaimLimitations() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].targetClaimLimitations", "K", "GET", "");
    }


    @Test(priority = 26)
    public void postDocumentByProposalId_Validate_Proposal_Specification_familyMembers() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].familyMembers", "R", "GET", "");
    }

    @Test(priority = 27)
    public void postDocumentByProposalId_Validate_Proposal_Specification_oppositionProceedings() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].fileHistory", "M", "GET", "");
    }

    @Test(priority = 28)
    public void postDocumentByProposalId_Validate_Proposal_Specification_dateRange() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].dateRange", "J", "GET", "");
    }

    @Test(priority = 29)
    public void postDocumentByProposalId_Validate_Proposal_Specification_searchingEfforts() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].searchingEfforts", "C", "GET", "");
    }

    @Test(priority = 30)
    public void postDocumentByProposalId_Validate_Proposal_Specification_relatedLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].relatedLiterature", "", "GET", "");
    }

    @Test(priority = 31)
    public void postDocumentByProposalId_Validate_Proposal_Specification_knownLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].knownLiterature", "D", "GET", "");
    }

    @Test(priority = 32)
    public void postDocumentByProposalId_Validate_Proposal_Specification_knownInventors() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].knownInventors", "E", "GET", "");
    }

    @Test(priority = 32)
    public void postDocumentByProposalId_Validate_Proposal_Specification_geographicRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].geographicRequirement", "S", "GET", "");
    }

    @Test(priority = 33)

    public void postDocumentByProposalId_Validate_Proposal_Specification_languageRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].languageRequirement", "F", "GET", "");
    }

    @Test(priority = 34)
    public void postDocumentByProposalId_Validate_Proposal_Specification_specialRequirement() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].specialRequirement", "G", "GET", "");
    }

    @Test(priority = 35)
    public void postDocumentByProposalId_Validate_Proposal_Specification_includeKnownLiterature() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].includeKnownLiterature", "No", "GET", "");
    }

    @Test(priority = 36)
    public void postDocumentByProposalId_Validate_Proposal_Specification_documentLegalStatus() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "specification[0].documentLegalStatus", "Live and expired patents and application", "GET", "");
    }

    @Test(priority = 37)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_ProposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].proposalId", proposalId, "GET", "");
    }

    @Test(priority = 38)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_englishLanguageGlobalPatent() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].englishLanguageGlobalPatent", "true", "GET", "");
    }

    @Test(priority = 39)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_englishLanguageElectronicTechnical() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].englishLanguageElectronicTechnical", "false", "GET", "");
    }

    @Test(priority = 40)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_techAutomotive() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].techAutomotive", "false", "GET", "");
    }

    @Test(priority = 41)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_techBiotechnology() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].techBiotechnology", "true", "GET", "");
    }

    @Test(priority = 42)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_techBiotechnologySequences() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].techBiotechnologySequences", "true", "GET", "");
    }

    @Test(priority = 43)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_techChemistry() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].techChemistry", "false", "GET", "");
    }

    @Test(priority = 44)
    public void postDocumentByProposalId_Validate_Proposal_Coverage_techChemistryStructures() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "coverage[0].techChemistryStructures", "false", "GET", "");
    }

    @Test(priority = 45)
    public void postDocumentByProposalId_Validate_Proposal_Invalidity_ProposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "invalidity[0].proposalId[0]", proposalId, "GET", "");
    }

    @Test(priority = 46)
    public void postDocumentByProposalId_Validate_Proposal_Invalidity_patentNumber() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "invalidity[0].patentNumber[0]", "pATENT1", "GET", "");
    }

    @Test(priority = 47)
    public void postDocumentByProposalId_Validate_Proposal_Invalidity_firstInventor() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "invalidity[0].firstInventor[0]", "iNV 1", "GET", "");
    }

    @Test(priority = 48)
    public void postDocumentByProposalId_Validate_Proposal_Invalidity_claims() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "invalidity[0].claims[0]", "Claims 1", "GET", "");
    }

    @Test(priority = 49)
    public void postDocumentByProposalId_Validate_Proposal_Invalidity_criticalDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "invalidity[0].criticalDate[0]", "29 Nov 2020", "GET", "");
    }

    @Test(priority = 50)
    public void postDocumentByProposalId_Validate_expired() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "expired[0]", "2040-01-03T00:00:00+00:00", "GET", "");
    }

    @Test(priority = 51)
    public void postDocumentByProposalId_Validate_Title() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposalTitle[0]", "P2", "GET", "");
    }

    @Test(priority = 52)
    public void postDocumentByProposalId_Validate_Summary() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "summary[0]", "P2Sum", "GET", "");
    }

    @Test(priority = 53)
    public void postDocumentByProposalId_Validate_proposalId() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "id[0]", proposalId, "GET", "");
    }

    @Test(priority = 54)
    public void postDocumentByProposalId_Validate_currency() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "currency[0]", "USD", "GET", "");
    }

    @Test(priority = 55)
    public void postDocumentByProposalId_Validate_ProposalState() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValueFromResponse(apiUrl, "proposalState[0]", "notAnswered", "GET", "");
    }

    @Test(priority = 56)
    public void postDocumentByProposalId_Validate_Phases_effectiveDate() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateKeyValuesFromResponse(apiUrl, "phases[0].effectiveDate", "2030-01-03T00:00:00", "GET", "");
    }

    @Test(priority = 57)
    public void postDocumentByProposalId_ResponseTime() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        validateResponseTime(this.getClass().getSimpleName(), apiUrl + "/" + proposalId + "/document", "", BENCHMARK_RESPONSE_TIME, "POST");
    }

    @AfterTest
    public void deleteProject() {
        setResponse(baseURI + "api/projects/" + projectId, "DELETE", "");
    }
}
