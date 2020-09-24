package com.company.project.base;

import com.company.utility.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.Matchers.hasItem;

public class BootStrap {

    public static Logger log = Logger.getLogger("IDSLogger");
    protected final long BENCHMARK_RESPONSE_TIME = 2000L;
    private Response response;
    public static String version = System.getProperty("version");


    /* Staging env links*/
    public static String baseURI = "https://ipclouddynamiccontentpwb6o2md5o7os.azurewebsites.net/search/";
//    public static String appURL = "https://staging.ipplatform.com/search/";
//    public static String UserName = "jesse.pinkman@nomail.example.com";
//    public static String Password = "Commodore64@";
//    public static String accessToken = "";


    /**
     * Static Block
     * Objective: To initiate Excel workbook before execution of the whole suite
     **/

    static {
//        RestAssured.baseURI = baseURI;
//        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
//
//        driver.get(appURL);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.findElement(By.id("inputEmailAddress")).sendKeys(UserName);
//        driver.findElement(By.id("btnSubmit")).click();
//        if (driver.findElements(By.xpath(".//*[@id='password']")).size() > 0) {
//            driver.findElement(By.xpath(".//*[@id='password']")).clear();
//            driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);
//            driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
//        }
//
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.navigate().to(appURL + "#/groups");
//
//        for (Cookie ck : driver.manage().getCookies()) {
//            if (ck.getName().contains("sso-access_token")) {
//                Log.info("SSO TOKEN IS:" + ck.getValue());
//                accessToken = ck.getValue().trim().toString();
////                accessToken = accessToken.substring(3, accessToken.length() - 3);
//                log.debug("Access Token: " + accessToken);
//            } else {
//                Log.info("Access Token Not Found:" + ck.getValue());
//            }
//        }
//
//        Log.info("Session Access Token : found ");

    }


    /**
     * This method is used to authenticate using user authentication process
     * @throws Exception
     */
//
    /**
     * Method Name: getResponse
     * Parameters: None
     * Return Type: Response
     * Exceptions: None
     * Objective: To return Response
     **/

    public Response getResponse() {
        return response;
    }

    /**
     * Method Name: generateRandom
     * Parameters: digits as integer
     * Return Type: long
     * Exceptions: None
     * Objective: To generate random number on the basis of required digits
     **/

    public long generateRandom(int digits) {
        Random random = new Random();
        return (int) Math.pow(10, digits - 1) + random.nextInt((int) (Math.pow(10, digits) - 1));
    }



    /**
     * Method Name: validateStatusCode
     * Parameters: apiUrl as String, body as String, statusCode as int & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To validate the expected status code coming from api response
     **/

    public void validateStatusCode(String apiUrl, String body, int statusCode, String methodType) {
        setResponse(apiUrl, methodType, body);
        log.info("Actual Status Code : " + response.statusCode() + ", Expected Status Code : " + statusCode);
        response.then().statusCode(statusCode);
    }

    /**
     * Method Name: validateResponseMessage
     * Parameters: apiUrl as String, body as String, expectedMessage as String & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To validate the expected response message coming from api response
     **/

    public void validateResponseMessage(String apiUrl, String body, String expectedMessage, String methodType) {
        setResponse(apiUrl, methodType, body);
        log.info("Actual Message : " + response.asString() + ", Expected Message : " + expectedMessage);
        Assert.assertEquals(response.asString(), expectedMessage);
    }

    /**
     * Method Name: validateKeyValueFromResponse
     * Parameters: apiUrl as String, keyName as String, keyValue as String, methodType as String & body as String
     * Return Type: None
     * Exceptions: None
     * Objective: To validate any String value of a parameter coming in the response
     **/

    public void validateKeyValueFromResponse(String apiUrl, String keyName, String keyValue, String methodType, String body) {
        setResponse(apiUrl, methodType, body);
        JsonPath jsonPath = getJsonPath();
        log.info("Response found successfully");
        log.info("Actual Parameter Value: " + jsonPath.get(keyName) + ", Expected Key Value: " + keyValue);
        Assert.assertEquals(jsonPath.get(keyName).toString(), keyValue);
        // Assert.assertEquals(jsonPath.get(keyName), keyValue);
    }


    /**
     * Method Name: getJsonPath
     * Parameters: None
     * Return Type: JsonPath
     * Exceptions: None
     * Objective: To get JSON body of the response payload
     **/

    public JsonPath getJsonPath() {
        return response.jsonPath();
    }

    /**
     * Method Name: validateKeyValueFromResponse
     * Parameters: apiUrl as String, keyName as String, keyValue as int, methodType as String & body as JSONObject
     * Return Type: None
     * Exceptions: None
     * Objective: To validate any int value of a parameter coming in the response
     **/

    public void validateKeyValueFromResponse(String apiUrl, String keyName, int keyValue, String methodType, String body) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("Actual Parameter Value: " + getJsonPath().get(keyName) + ", Expected Key Value: " + keyValue);
        Assert.assertEquals(getJsonPath().getInt(keyName), keyValue);
    }

    /**
     * Method Name: validateKeyValueFromResponse
     * Parameters: apiUrl as String, keyName as String, keyValue as double, methodType as String & body as JSONObject
     * Return Type: None
     * Exceptions: None
     * Objective: To validate any int value of a parameter coming in the response
     **/

    public void validateKeyValueFromResponse(String apiUrl, String keyName, double keyValue, String methodType, String body) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("Actual Parameter Value: " + getJsonPath().get(keyName) + ", Expected Key Value: " + keyValue);
        Assert.assertEquals(getJsonPath().getInt(keyName), keyValue);
    }

    /**
     * Method Name: validateKeyValueFromResponse
     * Parameters: apiUrl as String, keyName as String, keyValue as boolean, methodType as String & body as JSONObject
     * Return Type: None
     * Exceptions: None
     * Objective: To validate any int value of a parameter coming in the response
     **/

    public void validateKeyValueFromResponse(String apiUrl, String keyName, boolean keyValue, String methodType, String body) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("Actual Parameter Value: " + getJsonPath().get(keyName) + ", Expected Key Value: " + keyValue);
        Assert.assertEquals(getJsonPath().getInt(keyName), keyValue);
    }

      /**
     * Method Name: validateKeyValuesFromResponse
     * Parameters: apiUrl as String, keyName as String, keyValue as String, methodType as String & body as String
     * Return Type: None
     * Exceptions: None
     * Objective: To validate whether an String value is coming in a list of values corresponding to the parameter coming in the response
     **/

    public void validateKeyValuesFromResponse(String apiUrl, String keyName, String keyValue, String methodType, String body) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("Actual Parameter Value: " + getJsonPath().get(keyName) + ", Expected Key Value: " + keyValue);
        MatcherAssert.assertThat(getJsonPath().get(keyName), hasItem(keyValue));
    }

      /**
     * Method Name: getAllValuesFromResponse
     * Parameters: apiUrl as String, body as String, keyName as String & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To get list of String values of a parameter coming in the response
     **/

    public List<String> getAllValuesFromResponse(String apiUrl, String body, String keyName, String methodType) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("List of all the values from response: " + getJsonPath().get(keyName));
        return getJsonPath().getList(keyName);
    }


    /**
     * Method Name: getValueFromResponse
     * Parameters: apiUrl as String, body as String, keyName as String & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To get single String value of a parameter coming in the response
     **/

    public String getValueFromResponse(String apiUrl, String body, String keyName, String methodType) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        System.out.print(response.asString());
        log.info("The values from response: " + getJsonPath().get(keyName));
        Log.info(getResponse().asString());
        System.out.print(getResponse().toString());
        return getJsonPath().get(keyName);

    }

    /**
     * Method Name: getIntValueFromResponse
     * Parameters: apiUrl as String, body as String, keyName as String & methodType as String
     * Return Type: Integer
     * Exceptions: None
     * Objective: To get single String value of a parameter coming in the response
     **/

    public Integer getIntValueFromResponse(String apiUrl, String body, String keyName, String methodType) {
        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("The values from response: " + getJsonPath().get(keyName));
        return getJsonPath().get(keyName);
    }
    /**
     * Method Name: getAllValuesFromResponse
     * Parameters: apiUrl as String, body as String, keyName as String & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To get list of String values of a parameter coming in the response
     **/

    public List<HashMap<String, List<String>>> getAllValuesInListNestedListFromResponse(String apiUrl, String body, String keyName, String methodType) {

        setResponse(apiUrl, methodType, body);
        log.info("Response found successfully");
        log.info("List of all the values from response: " + getJsonPath().get(keyName));
        return getJsonPath().getList(keyName);
    }

    /**
     * Method Name: setResponse
     * Parameters: apiUrl as String, methodType as String & body as String
     * Return Type: None
     * Exceptions: None
     * Objective: To set response after providing the JSON payload to API
     **/

    public void setResponse(String apiUrl, String methodType, String body) {
        switch (methodType.toUpperCase()) {
            case "GET":
                response = RestAssured.given()
//                        .auth()
//                        .oauth2(BootStrap.accessToken)
                        .get(apiUrl);
                break;
            case "PUT":
                response = RestAssured.given()
//                        .auth()
//                        .oauth2(BootStrap.accessToken)
                        .body(body).with().contentType(ContentType.JSON).put(apiUrl);
                break;
            case "POST":
                response = RestAssured.given()
//                        .auth()
//                        .oauth2(BootStrap.accessToken)
                        .body(body).with().contentType(ContentType.JSON).post(apiUrl);
                break;
            case "DELETE":
                response = RestAssured.given()
//                        .auth()
//                        .oauth2(BootStrap.accessToken)
                        .body(body).with().contentType(ContentType.JSON).delete(apiUrl);
                break;
            default:
                log.info("Please enter valid method type. Entered Method Type: " + methodType);
                throw new IllegalArgumentException();
        }
    }

      /**
     * Method Name: validateResponseTime
     * Parameters: apiName as String, apiUrl as String, body as String, benchmarkResponseTime as long & methodType as String
     * Return Type: None
     * Exceptions: None
     * Objective: To validate the response time for the API on the basis on benchmark response time defined.
     **/

    public void validateResponseTime(String apiName, String apiUrl, String body, long benchmarkResponseTime, String methodType) {
        double[] iteration = new double[3];

        for (int i = 0; i < 3; i++) {
            setResponse(apiUrl, methodType, body);
            iteration[i] = response.time();
        }

        double avg = Math.round(((iteration[0] + iteration[1] + iteration[2]) / 3) * 100) / 100.0;
        String status = (avg < benchmarkResponseTime) ? "Pass" : "Fail";
        log.info("Response Time : " + iteration[0] + "ms, " + iteration[1] + "ms, " + iteration[2] + "ms");
        Assert.assertEquals(status, "Pass");
    }

    public String getCurrentDate(String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date dateobj = new Date();
        return df.format(dateobj);

    }


}