package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utils.requests.PostMobileExecution;
import utils.requests.Auth0TokenRequest;
import utils.requests.BS_GetBuildID;
import utils.requests.BS_GetVideoSession;

public class Utils {

  /*
   * CREATION OF BROWSERSTACK ANDROID DRIVER
   */

  public static AppiumDriver getBrowserStackAndroidDriver(String testName) {
    AppiumDriver driver = null;

    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);
      System.out.println("BROWSER STACK ANDROID DRIVER");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("device", prop.getProperty("ANDROID_DEVICE"));
      capabilities.setCapability("os_version", prop.getProperty("ANDROID_VERSION"));
      capabilities.setCapability("project", "Consultingtest");
      capabilities.setCapability("appiumVersion", "1.22.0");
      capabilities.setCapability("name", prop.getProperty("CLIENT_NAME") + testName);
      capabilities.setCapability("interactiveDebugging", "true");
      capabilities.setCapability("build", "Consulting - " + (prop.getProperty("CLIENT_NAME")));
      capabilities.setCapability("app", prop.getProperty("ANDROID_APP_URL"));
      driver = new AndroidDriver<AndroidElement>(
          new URL("https://" + prop.getProperty("BS_USER_NAME") + ":" + prop.getProperty("BS_ACCESS_KEY")
              + "@hub-cloud.browserstack.com/wd/hub"),
          capabilities);
    } catch (Exception e) {
      e.printStackTrace();
      Actions.failedTest();
    }
    return driver;
  }

  /*
   * CREATION OF BROWSERSTACK IOS DRIVER
   */

  public static IOSDriver getBrowserStackIOSDriver(String testName) {
    IOSDriver driver = null;

    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);
      System.out.println("BROWSER STACK IOS TEST");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("device", prop.getProperty("IOS_DEVICE"));
      capabilities.setCapability("os_version", prop.getProperty("IOS_VERSION"));
      capabilities.setCapability("project", "Consultingtest");
      capabilities.setCapability("appiumVersion", "1.22.0");
      capabilities.setCapability("build", "Consulting - " + (prop.getProperty("CLIENT_NAME")));
      capabilities.setCapability("name", prop.getProperty("CLIENT_NAME") + " - " + testName);
      capabilities.setCapability("interactiveDebugging", "true");
      capabilities.setCapability("app", prop.getProperty("IOS_APP_URL"));
      driver = new IOSDriver<IOSElement>(
          new URL("https://" + prop.getProperty("BS_USER_NAME") + ":" + prop.getProperty("BS_ACCESS_KEY")
              + "@hub-cloud.browserstack.com/wd/hub"),
          capabilities);
    } catch (Exception e) {
      e.printStackTrace();
      Actions.failedTest();
    }
    return driver;
  }

  /*
   * 
   * Send execution restults
   * 
   * Requires:
   * Mobile executions array
   * 
   */
  public static void sendExecutionResults(JSONArray mobileExecutionsArray, String OS) {
    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);
      JSONObject mobileExecution = new JSONObject();
      mobileExecution.put("tests", mobileExecutionsArray);
      mobileExecution.put("userId", prop.getProperty("CONSULTING_USER_ID"));
      mobileExecution.put("os", OS);
      if (OS == "ANDROID") {
        mobileExecution.put("device", prop.getProperty("ANDROID_DEVICE"));
        mobileExecution.put("osVersion", prop.getProperty("ANDROID_VERSION"));
      } else {
        mobileExecution.put("device", prop.getProperty("IOS_DEVICE"));
        mobileExecution.put("osVersion", prop.getProperty("IOS_VERSION"));
      }
      mobileExecution.put("type", prop.getProperty("EXECUTION_TYPE"));

      String jsonString = mobileExecution.toString();
      System.out.println("String Json");
      System.out.println(jsonString);

      /*
       * For local running
       */

      // PostRequest.sendPostWithBody(jsonString);

      /*
       * For Poduction development
       */

      if (prop.getProperty("SEND_RESULTS").length() == 4) { // If it is true, for some reason it does not take "true" as
                                                            // a value but it does as the lenght
        String authToken = Auth0TokenRequest.sendRequest();
        PostMobileExecution.sendPOST(jsonString, authToken);
        System.out.println("Mobile Executions sent succesfully");
      }

    } catch (Exception e) {
      System.out.println("There was an error sending the Mobile Executions");
      e.printStackTrace();
    }
  }

  public static void addMobileExecution(JSONArray mobileExecutionArray, String testName, Boolean result, String OS,
      Integer executionStatus) {
    try (InputStream input = new FileInputStream("src/test/java/resources/config.properties")) {

      Properties prop = new Properties();
      prop.load(input);
      String id = BS_GetBuildID.sendGet(prop.getProperty("BS_USER_NAME"), prop.getProperty("BS_ACCESS_KEY"),
          "Consulting - " + prop.getProperty("CLIENT_NAME"));
      String videoUrl = BS_GetVideoSession.sendGet(prop.getProperty("BS_USER_NAME"), prop.getProperty("BS_ACCESS_KEY"),
          id);
      JSONObject mobileExecution = new JSONObject();
      mobileExecution.put("result", result);
      mobileExecution.put("testName", testName);
      mobileExecution.put("video", videoUrl);
      mobileExecution.put("userstatus", executionStatus);
      mobileExecutionArray.put(mobileExecution);
      System.out.println("Execution added to array");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
