package com.cpa.search.base;

import org.testng.annotations.Test;

import java.util.List;

public class Delete_Utilities extends BootStrap {

    @Test
    public void deleteGroups() {
        List<String> groupList = getAllValuesFromResponse(baseURI + "api/groups", "", "title", "GET");
        for (int i = 0; i <= groupList.size(); i++) {
            String groupName = getValueFromResponse(baseURI + "api/groups", "", "title[" + i + "]", "GET");
            if (groupName.contains("AddGroup")) {
                String id = getValueFromResponse(baseURI + "api/groups", "", "id[" + i + "]", "GET");
                setResponse(baseURI + "api/groups/" + id, "DELETE", "");
            }
        }

    }

    @Test
    public void deletedExistingPrenegitiatedProject() {
        log.info("<====================" + Thread.currentThread().getStackTrace()[1].getMethodName() + "====================>");
        String id;
        List<String> projectNameList = getAllValuesFromResponse(baseURI + "/api/prenegotiatedprojects", "", "description", "GET");
        for (int i = projectNameList.size() - 1; i >= 0; i--) {
            if (getValueFromResponse(baseURI + "/api/prenegotiatedprojects", "", "description[" + i + "]", "GET").equals("New preNegotiated Project Name")) {
                id = getValueFromResponse(baseURI + "/api/prenegotiatedprojects", "", "id[" + i + "]", "GET");
                setResponse(baseURI + "/api/prenegotiatedprojects/" + id, "DELETE", "");
            }
        }
    }

    @Test
    public void deleteProject() {
        String searchStrBody = "{\n" +
                "  \"filter\": {\n" +
                "  \"caseOrMatterNumber\": \"Automation\",\n" +
                "  }\n" +
                "}";
        List<String> Ids = getAllValuesFromResponse(baseURI + "api/projects/search", searchStrBody, "result.id", "POST");
        for (int i = Ids.size() - 1; i > 0; i--) {
            String id = Ids.get(i);
            setResponse(baseURI + "api/projects/" + id, "DELETE", "");
        }

    }
}
