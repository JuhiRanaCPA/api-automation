package com.cpa.search.testcase.attachments;

import com.cpa.search.base.BootStrap;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class AddAttachments extends BootStrap {

    @Test
    public void uploadAttachment() {
        String apiUrl = baseURI + "api/attachments/upload";
        RestAssured.baseURI = "https://ipclouddynamiccontentpwb6o2md5o7os.azurewebsites.net/search/";

        Response response = RestAssured.given()
                .multiPart(new File("C:\\GIT\\ip-search\\Sample_File_5.pdf"))
                .when()
                .post("api/attachments/upload");

        log.info(response.getStatusCode());
        log.info(response.asString());

    }

}
