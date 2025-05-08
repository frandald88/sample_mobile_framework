import java.util.Random;

import org.json.JSONArray;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import android.pages.StatementPageAndroid;
import android.pages.LoginPageAndroid;
import android.pages.ProximateAndroidPage;
import android.pages.SpotPageAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import ios.pages.StatementPageIOS;
import ios.pages.LoginPageIOS;
import ios.pages.ProximatePageIOS;
import ios.pages.SpotPageIOS;
import ios.pages.AddTicketPageIOS;
import page_interfaces.Statement;
import page_interfaces.AddTicket;
import utils.Actions;
import utils.Utils;

/*
 *  TESTS CLASS
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCasesIOS {

  /*
   * Constants used on the functions
   */

  static Random rand = new Random();
  public static final String IOS = "IOS";
  public static final String ANDROID = "ANDROID";
  public static String executionOS = IOS;
  public static String statementEmail = "consulting-iOS@consultingteam.tester.com";
  public static String statementPws = "Consulting1234!";
  public static String statementEmailNOCash = "consulting-nocash-IOS@consultingteam.tester.com";
  public static String statementPwsNOCash = "Consulting1234!";
  public static String statementEmailSpaces = "  consulting-iOS@consultingteam.tester.com";
  public static String statementPwsSpaces = "  Consulting1234!";
  //public static String emptyStatementEmail = "consulting-2@consultingteam.tester.com";
  public static String statementInvalidEmail = "test@email.com";
  public static String statementBlankEmail = "";
  public static String statementInvalidPws = "Muk";
  public static int random1 = rand.nextInt(10000);
  public static int random2 = rand.nextInt(10000);
  public static String randomString1 = Integer.toString(random1);
  public static String randomString2 = Integer.toString(random2);
  public static String randomStatementEmail = randomString1 + "consulting" + randomString2 + "@consultingteam.tester.com";
  public static String newPassword = "newPassword";
  public static String newPasswordMore20 = "newPasswordExceedLen";
  public static String newPassword20 = "newPasswordMaxLenght";

  public static int randNumber = rand.nextInt(10000);
  public static int randNumber2 = rand.nextInt(10000);
  public static String randUserName = "Consulting"+Integer.toString(randNumber);
  public static String randUserName2 = "Consulting"+Integer.toString(randNumber2);

  public static String statementEditEmail = "consulting-iOS_pass@consultingteam.tester.com";
  public static String statementEditPws = "Consulting1234!";

  // Array that will contain all the executons later to be sent as feedback
  static JSONArray mobileExecutionsArray = new JSONArray();

  /*
   * FUNCTION THAT HELPS DETERMINE WHICH DRIVER TO USE DEPENDING ON THE
   * "executionOS" FLAG
   */
  public IOSDriver getDriver(String testName) throws InterruptedException {
    IOSDriver driver = null;
    try {
      driver = Utils.getBrowserStackIOSDriver(testName);
    } catch (Exception e) {
      Actions.logging("There was an error getting the driver for OS ");
    }
    return driver;
  }

  /*
   * 
   * GENERATE EXECUTION NUMBER AND SEND RESULTS AFTER TEST SUITE RAN
   */

  @AfterClass
  public static void sendMobileExecutions() {
    System.out.println("Sending Mobile Executino Results");
    Utils.sendExecutionResults(mobileExecutionsArray, executionOS);
  }

  /*
   *
   * TEST SUITE
   *
   */

  /*
   * Login With QA server
   */
  @Test()
  public void TC001_Starting_Find_Proximate_Juckeboxes() throws InterruptedException {
    String testName = "TC001 - Starting_Find Proximate Juckeboxes";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Starting_Find Proximate Juckeboxes_Allow access to device
   */

  @Test()
  public void TC002_Starting_Find_Proximate_Juckeboxes_Allow_Access_while() throws InterruptedException {
    String testName = "TC002 - Starting_Find Proximate Juckeboxes_Allow access while in app to device";
    IOSDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Starting_Find Proximate Juckeboxes_Allow access to device_Only this time
   */

  @Test()
  public void TC003_Starting_Find_Proximate_Juckeboxes_Allow_Access_Only_This_Time() throws InterruptedException {
    String testName = "TC003 - Starting_Find Proximate Juckeboxes_Allow access to device_Only this time";
    IOSDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Starting_Find Proximate Juckeboxes_Allow access to dont this time
   */

   @Test()
   public void TC004_Starting_Find_Proximate_Juckeboxes_Dont_Allow_Access() throws InterruptedException {
     String testName = "TC004 -  Starting_Find Proximate Juckeboxes_Allow access to device_Don't allow";
     IOSDriver driver = getDriver(testName);

     try {
       // Declare the driver (obligatory)

       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Not allow");
      
       /*
        * End test
        */

       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                       // needed
       Actions.failedTest();
     }
   }

  /*
   * Starting_Find Proximate Juckeboxes_Find Curren Location
   */
  @Test()
  public void TC005_Starting_Find_Proximate_Juckeboxes_Find_Current_Location() throws InterruptedException {
    String testName = "TC005 - Starting_Find Proximate Juckeboxes_Find Current Location";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      //loginPage.login(false, statementEmail, statementPws);
      loginPage.skipIntro("Allow once");
      //proximatePage.searchLocation(false, "Consulting"); //enable on builds with access to prod spots only
      loginPage.setQAEnv();
      //proximatePage.selectTestLocation("Consulting");
      proximatePage.searchLocation(true, "Consulting");
      //statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * SignUp_Create a Free Statement with emai
   */
  @Test()
  public void TC006_SignUp_Create_a_Free_Statement_with_email() throws InterruptedException {
    String testName = "TC006 - SignUp_Create a Free Statement with email";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.createStatement(randomStatementEmail, statementPws);
      //statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * SignUp_Create a Free Statement with email with an invalid short password
   */
  @Test()
  public void TC009_SignUp_Create_a_Free_Statement_with_email_wrong_password() throws InterruptedException {
    String testName = "TC009 - SignUp_Create a Free Statement with email wrong password";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      //StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.createStatementInvalidPsw(randomStatementEmail, statementInvalidPws);
      
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to perform a Valid login with email and password
   */
  @Test()
  public void TC010_Login_Valid_Login() throws InterruptedException {
    String testName = "TC010 - Login_Valid Login";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate the system displays the correct message when we perform a login with a wrong email
   */
  @Test()
  public void TC011_Login_Invalid_Login_with_wrong_email() throws InterruptedException {
    String testName = "TC011 - Login_Invalid Login with wrong email";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
            /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementInvalidEmail, statementPws);
      

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate the system displays the correct message when we perform a login with a wrong Password
   */
  @Test()
  public void TC012_Login_Invalid_Login_with_wrong_password() throws InterruptedException {
    String testName = "TC012 - Login_Invalid Login with wrong password";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
            /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementInvalidPws);
      

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to login again with a previous statement saved.
   */
  @Test()
  public void TC013_Login_Login_Again() throws InterruptedException {
    String testName = "TC013 - Login_Login Again";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
            /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.logout();
      loginPage.loginAgain(statementEmail, statementPws);

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate the system allows to recover the password when the user fotgot it
   */
  @Test()
  public void TC014_Login_Forgot_Password() throws InterruptedException {
    String testName = "TC014 - Login_Forgot Password";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
            /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      loginPage.forgotPassword(statementEmail);
      
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate the system displays the correct message when we perform a login with a wrong Password
   */
  @Test()
  public void TC015_Login_Signout() throws InterruptedException {
    String testName = "TC015 - Login_Signout";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
            /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.logout();
      

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  
  /*
   * Validate the system allows to search a Spot a as a Guest user
   */
  @Test()
  public void TC016_Home_Find_Proximate_Jukeboxes_Search_a_Spot_Guest() throws InterruptedException {
    String testName = "TC016 - Home_Find Proximate Jukeboxes_Search a Spot Guest";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      //StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      loginPage.setQAEnv();
      proximatePage.searchLocation(true, "Consulting");
      
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Home_Find Proximate Juckeboxes_Search a Spot
   */
  @Test()
  public void TC017_Home_Find_Proximate_Juckeboxes_Search_a_Spot() throws InterruptedException {
    String testName = "TC017 - Home_Find Proximate Juckeboxes_Search a Spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocation(true, "Consulting");
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Home_Find Proximate Jukeboxes_Add Spot to favorites with login
   */
  @Test()
  public void TC018_Home_Find_Proximate_Jukeboxes_Add_Spot_to_favorites_with_login() throws InterruptedException {
    String testName = "TC018 - Home_Find Proximate Jukeboxes_Add Spot to favorites with login";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocation(true, "Consulting");
      spotPage.favoriteSpot(true);
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Home_Find Proximate Jukeboxes_Add Spot to favorites without login
   */
  @Test()
  public void TC019_Home_Find_Proximate_Jukeboxes_Add_Spot_to_favorites_without_login() throws InterruptedException {
    String testName = "TC019 - Home_Find Proximate Jukeboxes_Add Spot to favorites without login";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      loginPage.setQAEnv();
      proximatePage.searchLocation(true, "Consulting");
      spotPage.favoriteSpot(false);

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate when you select a Spot you can see three different sections: Tracks Hot here, Artists Hot Here, Featured Tracklist
   */
  @Test()
  public void TC020_All_Music_Home_Page_sections() throws InterruptedException {
    String testName = "TC020 - All Music_Home Page sections";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      loginPage.setQAEnv();
      proximatePage.searchLocation(true, "Consulting");
      spotPage.homePageUI();
      //statementPage.logout();
      //spotPage.playTrack("Viva la vida", false);
      //

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate when you select a Spot you can see three different sections: Tracks Hot here, Artists Hot Here, Featured Tracklist
   */
  @Test()
  public void TC021_All_Music_Search_for_Music() throws InterruptedException {
    String testName = "TC021 - All Music_Search for Music";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow once");
      loginPage.setQAEnv();
      proximatePage.searchLocation(true, "Consulting");
      spotPage.searchTrack("Enter Sandman", "Consulting");

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * All Music_Search for Music_Play Track with Priority (No cash)
   */
  @Test()
  public void TC022_All_Music_Search_for_Music_Play_Track_with_Priority_No_cash() throws InterruptedException {
    String testName = "TC022 - All Music_Search for Music_Play Track with Priority (No cash)";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmailNOCash, statementPwsNOCash);
      proximatePage.selectTestLocation("Consulting");
      spotPage.playTrackPriorityNoTokens("Enter Sandman");
      statementPage.logout();

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * All Music_Search for Music_Play Track with Priority (With cash)
   */
  @Test()
  public void TC023_All_Music_Search_for_Music_Play_Track_with_Priority_With_Cash() throws InterruptedException {
    String testName = "TC023 - All Music_Search for Music_Play Track with Priority (With cash)";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrackPriorityTokens("Enter Sandman");
      statementPage.logout();

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Validate the system allows to play tracks.
   */
  @Test()
  public void TC024_All_Music_Search_for_Music_Play_Track() throws InterruptedException {
    String testName = "TC024 - All Music_Search for Music_Play Track";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.logout();

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to play track and add it to the queues.
   */
  @Test()
  public void TC025_All_Music_Search_for_Music_Add_track_to_Queue() throws InterruptedException {
    String testName = "TC025 - All Music_Search for Music_Add track to Queue";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.play2Tracks("Enter Sandman");
      statementPage.logout();

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to click on the 'View this artist' when selecting a track and the Tracks and Albums for that artis are displayed
   */
  @Test()
  public void TC026_All_Music_Search_for_Music_View_this_Artist() throws InterruptedException {
    String testName = "TC026 - All Music_Search for Music_View this Artist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocation(true, "Consulting");
      spotPage.viewArtist("rihanna");
      statementPage.logout();

      /*
       * 
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * All Music_Search for Music_Add to My Tracks
   */
  @Test()
  public void TC027_All_Music_Search_for_Music_Add_to_My_Tracks() throws InterruptedException {
    String testName = "TC027 - All Music_Search for Music_Add to My Tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.addTrack("myTracks");
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * All Music_Search for Music_Add to Tracklist
   */
  @Test()
  public void TC028_All_Music_Search_for_Music_Add_to_Tracklist() throws InterruptedException {
    String testName = "TC028 - All Music_Search for Music_Add to Tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.addTrack("tracklist");
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to remove a track from the 'My Tracks' list. Validate the track is removed.
   */
  @Test()
  public void TC029_MyMusic_My_Tracks_Remove_a_Track() throws InterruptedException {
    String testName = "TC029 - MyMusic_My Tracks_Remove a Track";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.removeTrack();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to add Cash using a token Ticket
   */
  @Test()
  public void TC031_AddCash_Add_Cash_with_Token_Ticket() throws InterruptedException {
    String testName = "TC031 - AddCash_Add Cash with Token Ticket";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicketSixDollars();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * AddCash_Auto-Reload turned ON
   */
  @Test()
  public void TC033_AddCash_Auto_Reload_turned_ON() throws InterruptedException {
    String testName = "TC033 - AddCash_Auto-Reload turned ON";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      statementPage.swtchOnAutoReload();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }

  /*
   * Settings_Preferences_Dark Mode_Enable Dark Mode
   */
  @Test()
  public void TC034_Settings_Preferences_Dark_Mode_Enable_Dark_Mode() throws InterruptedException {
    String testName = "TC034 - Settings_Preferences_Dark Mode_Enable Dark Mode";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.darkMode();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


   /*
   * Validate the system allows to turn on the confirmation for Purchase. Add steps to validate it was turned on correctly.";
   */
  @Test()
  public void TC035_Settings_Preferences_Confirm_Purchase_ON() throws InterruptedException {
    String testName = "TC035 - Settings_Preferences_Confirm Purchase ON";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      //SpotPageIOS spotPage = new SpotPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.confirmPurchaseON();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History is updated after add new Cash. Validate the Tokens are updated.
   */
  @Test()
  public void TC036_Transaction_History_Update_after_add_Cash() throws InterruptedException {
    String testName = "TC036 - Transaction History_Update after add Cash";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicketSixDollars();
      statementPage.transactionHistoryUpdateAddCashSixDollars();
      statementPage.logout();
      
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  // /*
  //  * Validate user cannot login using Blanks as Username & Password
  //  */
  // @Test()
  // public void TC037_Login_Use_Blank_Login() throws InterruptedException {
  //   String testName = "TC037 - Login_Use Blank Login";
  //   AppiumDriver driver = getDriver(testName);

  //   try {
  //     // Declare the driver (obligatory)

  //     /*
  //      * Declare the pages that are being used
  //      */
  //     LoginPageIOS loginPage = new LoginPageIOS(driver);
  //     StatementPageIOS statementPage = new StatementPageIOS(driver);
  //     /*
  //      * Use the functions of set page to run the test
  //      */
  //     loginPage.loginBlank(statementBlankEmail);
      

  //     /*
  //      * End test
  //      */

  //     Actions.endTest(driver);
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
  //   } catch (Exception e) {
  //     /*
  //      * If something happens print error and fail test
  //      */
  //     e.printStackTrace();
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
  //                                                                                       // needed
  //     Actions.failedTest();
  //   }
  // }



  /*
   * Validate that the application does not let the user log in using spaces as Username & Password
   */
  @Test()
  public void TC038_Login_Login_using_spaces() throws InterruptedException {
    String testName = "TC038 - Login_Login using spaces";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      //StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.loginSpaces(statementEmailSpaces, statementPwsSpaces);
      

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate that the application does not let the user log in using spaces as Username & Password
   */
  @Test()
  public void TC039_Login_Use_password_reveal_button() throws InterruptedException {
    String testName = "TC039 - Login_Use password reveal button";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      //StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.revealPassword(statementEmail, statementPws);
      

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  // /*
  //  * Validate user can see statement details inside ‘User Profile’
  //  */
  // @Test()
  // public void TC042_My_Statement_Manage_Statement_User_Profile() throws InterruptedException {
  //   String testName = "TC042 - My_Statement_Manage_Statement_User Profile";
  //   AppiumDriver driver = getDriver(testName);

  //   try {
  //     // Declare the driver (obligatory)

  //     /*
  //      * Declare the pages that are being used
  //      */
  //     LoginPageIOS loginPage = new LoginPageIOS(driver);
  //     StatementPageIOS statementPage = new StatementPageIOS(driver);
  //     /*
  //      * Use the functions of set page to run the test
  //      */
  //     loginPage.login(false, statementEmail, statementPws);
  //     statementPage.ManageStatement();
  //     /*
  //      * End test
  //      */

  //     Actions.endTest(driver);
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
  //   } catch (Exception e) {
  //     /*
  //      * If something happens print error and fail test
  //      */
  //     e.printStackTrace();
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
  //                                                                                       // needed
  //     Actions.failedTest();
  //   }
  // }


  /*
   * Validate user can change email registered to login the application successfully
   */
  @Test()
  public void TC043_My_Statement_Manage_Statement_User_Profile_Save_Button() throws InterruptedException {
    String testName = "TC043 - My_Statement_Manage_Statement_User Profile_Save Button";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.updateEmail(statementPws);
      statementPage.logout();
      loginPage.loginAgainFail(statementEmail, statementPws);
      loginPage.loginAgain("newmailIOS@mail.com", statementPws);
      statementPage.restoreEmail(statementPws);
      statementPage.logout();
      loginPage.loginAgain(statementEmail, statementPws);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can cancel changes done to username
   */
  @Test()
  public void TC044_My_Statement_Manage_Statement_User_Profile_Cancel_Button() throws InterruptedException {
    String testName = "TC044 - My_Statement_Manage_Statement_User Profile_Cancel Button";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.updateEmailCancel(statementPws);
      statementPage.logout();
      loginPage.loginAgain(statementEmail, statementPws);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can change user name successfully
   */
  @Test()
  public void TC045_My_Statement_Manage_Statement_User_Profile_Change_Username() throws InterruptedException {
    String testName = "TC045 - My_Statement_Manage_Statement_User Profile_Change Username";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.changeUsername(statementPws, randUserName);
      statementPage.logout();
      
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can login using new username created
   */
  @Test()
  public void TC046_My_Statement_Manage_Statement_User_Profile_Login_using_new_username() throws InterruptedException {
    String testName = "TC046 - My_Statement_Manage_Statement_User Profile_Login using new username";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.changeUsername(statementPws, randUserName2);
      statementPage.logout();
      loginPage.loginAgain(randUserName2, statementPws);
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can cancel any changes done to password
   */
  @Test()
  public void TC047_My_Statement_Manage_Statement_Password_Cancel_Button() throws InterruptedException {
    String testName = "TC047 - My_Statement_Manage_Statement_Password_Cancel Button";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.changePasswordCancel(statementPws, statementEmail);
      statementPage.logout();
      loginPage.loginAgain(statementEmail, statementPws);
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can see the password captures while using option to display password
   */
  @Test()
  public void TC048_My_Statement_Manage_Statement_Password_Show_password_while_typing() throws InterruptedException {
    String testName = "TC048 - My_Statement_Manage_Statement_Password_Show password while typing";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.changePasswordShowPassword(statementPws, statementEmail);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can change password successfully
   */
  @Test()
  public void TC049_My_Statement_Manage_Statement_Password_Change_Password() throws InterruptedException {
    String testName = "TC049 - My_Statement_Manage_Statement_Password_Change Password";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEditEmail, statementEditPws);
      statementPage.changePassword(statementEditPws, statementEditEmail);
      statementPage.logout();
      loginPage.loginAgainFail(statementEditEmail, statementEditPws);
      loginPage.loginAgain(statementEditEmail, newPassword);
      statementPage.restorePassword(newPassword, statementEditEmail);
      statementPage.logout();
      loginPage.loginAgain(statementEditEmail, statementEditPws);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can change password successfully
   */
  @Test()
  public void TC050_My_Statement_Manage_Statement_Password_Login_with_Changed_Password() throws InterruptedException {
    String testName = "TC050 - Validate user can change & used new password to login";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEditEmail, statementEditPws);
      statementPage.changePassword(statementEditPws, statementEditEmail);
      statementPage.logout();
      loginPage.loginAgain(statementEditEmail, newPassword);
      statementPage.restorePassword(newPassword, statementEditEmail);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user cannot change password while using blanks as current & new pasword
   */
  @Test()
  public void TC051_My_Statement_Manage_Statement_Password_Change_Password_using_blanks() throws InterruptedException {
    String testName = "TC051 - My_Statement_Manage_Statement_Password_Change Password using blanks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEditEmail, statementEditPws);
      statementPage.changePasswordBlank();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate password length should be not more than 20 characters
   */
  @Test()
  public void TC052_My_Statement_Manage_Statement_Password_Password_length() throws InterruptedException {
    String testName = "TC052 - My_Statement_Manage_Statement_Password_Password length";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.changePasswordMore20(statementEditPws, statementEditEmail);
      statementPage.logout();
      loginPage.loginAgainFail(statementEditEmail, newPasswordMore20);
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can login to application using a max length password
   */
  @Test()
  public void TC053_My_Statement_Manage_Statement_Password_Login_using_max_length_password() throws InterruptedException {
    String testName = "TC053 - My_Statement_Manage_Statement_Password_Login using max length password";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEditEmail, statementEditPws);
      statementPage.changePassword20(statementEditPws, statementEditEmail);
      statementPage.logout();
      loginPage.loginAgain(statementEditEmail, newPassword20);
      statementPage.restorePassword(newPassword20, statementEditEmail);
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History is updated after add new Cash. Validate the Tokens are updated. Validate that track can be seen in transaction history
   */
  @Test()
  public void TC054_Transaction_History_Update_after_add_Cash_and_Tracks() throws InterruptedException {
    String testName = "TC054 - Transaction History_Update after add Cash & Tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicketSixDollars();
      statementPage.transactionHistoryUpdateAddCashSixDollars();
      spotPage.playTrackFromSpotHomeScreen("Enter Sandman");
      statementPage.transactionHistoryUpdateAddTrack();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History details are displayed after clicking the 3 dots icon
   */
  @Test()
  public void TC055_Transaction_History_Transactions_details() throws InterruptedException {
    String testName = "TC055 - Transaction History_Transactions details";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicketSixDollars();
      statementPage.transactionHistoryUpdateAddCashSixDollars();
      spotPage.playTrackFromSpotHomeScreen("Enter Sandman");
      statementPage.transactionHistoryUpdateAddTrackMenu();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate a track can be added to My Tracks from transaction History details are displayed after clicking the 3 dots icon
   */
  @Test()
  public void TC056_Transaction_History_Add_a_track_to_MyTracks() throws InterruptedException {
    String testName = "TC056 - Transaction History_Add a track to My Tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.transactionHistoryAddTracktoMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate a track can be added & removed from the My Tracks menu from transaction History details are displayed after clicking the 3 dots icon
   */
  @Test()
  public void TC057_Transaction_History_Remove_a_track_from_My_Tracks() throws InterruptedException {
    String testName = "TC057 - Transaction History_Remove a track from My Tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.transactionHistoryRemoveTracktoMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate a track can be added to tracklist from transaction History details are displayed after clicking the 3 dots icon
   */
  @Test()
  public void TC058_Transaction_History_Add_a_track_to_tracklist() throws InterruptedException {
    String testName = "TC058 - Transaction History_Add a track to tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      loginPage.setMoneyBagBalance();
      spotPage.playTrack("Enter Sandman");
      spotPage.createTracklist();
      statementPage.transactionHistoryAddTracktoExistingTracklist();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate a track can be added to a newly created tracklist from transaction History details 
   */
  @Test()
  public void TC059_Transaction_History_Create_a_tracklist_and_Add_a_track_to_tracklist() throws InterruptedException {
    String testName = "TC059 - Transaction History_Create a tracklist & Add a track to tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.transactionHistoryAddTracktoMyTracklist();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History can play a track with priority
   */
  @Test()
  public void TC060_My_Statement_Transaction_History_Play_track_with_priority() throws InterruptedException {
    String testName = "TC060 - My Statement_Transaction History_Play track with priority";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrackPriorityTokens("Enter Sandman");
      statementPage.transactionHistoryPlayTrackPriority();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History can play a track
   */
  @Test()
  public void TC061_My_Statement_Transaction_History_Play_track() throws InterruptedException {
    String testName = "TC061 - My Statement_Transaction History_Play track";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.transactionHistoryPlayTrack();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History can cancel a play a track with priority
   */
  @Test()
  public void TC062_My_Statement_Transaction_History_Cancel_Play_track_with_priority() throws InterruptedException {
    String testName = "TC062 - My Statement_Transaction History_Cancel Play track with priority";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrackPriorityTokens("Enter Sandman");
      statementPage.transactionHistoryPlayTrackPriorityCancel();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History can cancel playing a track
   */
  @Test()
  public void TC063_My_Statement_Transaction_History_Cancel_Play_track() throws InterruptedException {
    String testName = "TC063 - My Statement_Transaction History_Cancel Play track";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("Enter Sandman");
      statementPage.transactionHistoryPlayTrackCancel();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History when adding a track & playing it its status should say Playing
   */
  @Test()
  public void TC064_My_Statement_Transaction_History_Track_status_playing() throws InterruptedException {
    String testName = "TC064 - My Statement_Transaction History_Track status playing";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrackPriorityTokens("Enter Sandman");
      statementPage.transactionHistoryPlayingTrackStatusPlaying();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History when adding a track & playing it its status should say Played
   */
  @Test()
  public void TC065_My_Statement_Transaction_History_Track_status_played() throws InterruptedException {
    String testName = "TC065 - My Statement_Transaction History_Track status played";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      //spotPage.playTrackPriorityTokens("Enter Sandman");
      statementPage.transactionHistoryPlayingTrackStatusPlayed();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the transaction History when adding multiple tracks & playing them their status should say Queued
   */
  @Test()
  public void TC066_My_Statement_Transaction_History_Track_status_queued() throws InterruptedException {
    String testName = "TC066 - My Statement_Transaction History_Track status queued";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      //proximatePage.selectTestLocation("Consulting");
      spotPage.playTrack("Enter Sandman");
      spotPage.playTrackFromSpotHomeScreen("Enter Sandman");
      statementPage.transactionHistoryPlayingTrackStatusQueued();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracks by artist 
   */
  @Test()
  public void TC067_MyMusic_MyTracks_Validate_sorted_by_Artist() throws InterruptedException {
    String testName = "TC067 - MyMusic_MyTracks_Validate sorted by Artist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToMyTracks("Enter Sandman");
      spotPage.myTracksSortByArtist();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracks by title
   */
  @Test()
  public void TC068_MyMusic_MyTracks_Validate_sorted_by_Track_title() throws InterruptedException {
    String testName = "TC068 - MyMusic_MyTracks_Validate sorted by Track title";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToMyTracks("Rihanna");
      spotPage.myTracksSortByTrack();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracks by popularity
   */
  @Test()
  public void TC069_MyMusic_MyTracks_Validate_sorted_by_Popularity() throws InterruptedException {
    String testName = "TC069 - MyMusic_MyTracks_Validate sorted by Popularity";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToMyTracks("Enter Sandman");
      spotPage.myTracksSortByPopularity();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts by selections multiple tracks
   */
  @Test()
  public void TC070_MyMusic_MyTracks_Validate_sort_by_multitrack_selection() throws InterruptedException {
    String testName = "TC070 - MyMusic_MyTracks_Validate sort by multi-track selection";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      loginPage.setMoneyBagBalance();
      proximatePage.selectTestLocation("Consulting");
      spotPage.removeAllMyTracks();
      spotPage.Add3TracksToMyTracks("Bjork");
      spotPage.myTracksMultiTrackSelection();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts by selections all tracks
   */
  @Test()
  public void TC071_MyMusic_MyTracks_Validate_sort_by_multitrack_selection_all_tracks() throws InterruptedException {
    String testName = "TC071 - MyMusic_MyTracks_Validate sort by multi-track selection (all tracks)";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.removeAllMyTracks();
      spotPage.Add3TracksToMyTracks("Bjork");
      spotPage.myTracksMultiTrackAllTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts by selections all tracks
   */
  @Test()
  public void TC072_MyMusic_MyTracks_Validate_user_can_deselect_all_tracks_using_the_Select_All_Tracks_radio_button() throws InterruptedException {
    String testName = "TC072 - MyMusic_MyTracks_Validate user can deselect all tracks using the Select All Tracks radio button";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.removeAllMyTracks();
      spotPage.Add3TracksToMyTracks("Bjork");
      spotPage.myTracksMultiTrackDeselectAllTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system selecting multiple tracks show the right count
   */
  @Test()
  public void TC073_MyMusic_MyTracks_Validate_number_of_tracks_when_using_multiple_tracks_selection() throws InterruptedException {
    String testName = "TC073 - MyMusic_MyTracks_Validate number of tracks when using multiple-tracks selection";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.removeAllMyTracks();
      spotPage.Add3TracksToMyTracks("Bjork");
      spotPage.myTracksMultiTrackSelectionNumbered();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracks by added date
   */
  @Test()
  public void TC074_MyMusic_MyTracks_Validate_sorted_by_added_date() throws InterruptedException {
    String testName = "TC074 - MyMusic_MyTracks_Validate sorted by added date";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToMyTracks("Enter Sandman");
      spotPage.myTracksSortByDate();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      spotPage.removeFirstMyTracks();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracks by added date
   */
  @Test()
  public void TC075_Validate_the_system_sorts_tracklist_tracks_by_artist() throws InterruptedException {
    String testName = "TC075 - Validate the system sorts tracklist tracks by artist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.deleteAllTracklist();
      spotPage.Add3TracksToTracklist("Enter Sandman");
      spotPage.tracklistSortByArtist();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracklist tracks by title
   */
  @Test()
  public void TC076_MyMusic_MyTracklists_sort_by_track_title() throws InterruptedException {
    String testName = "TC076 - MyMusic_MyTracklists_sort by track title";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistSortByTrack();
      spotPage.deleteAllTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracklist tracks by popularity
   */
  @Test()
  public void TC077_MyMusic_MyTracklists_sort_by_track_popularity() throws InterruptedException {
    String testName = "TC077 - MyMusic_MyTracklists_sort by track popularity";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistSortByPopularity();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows renaming the tracklist
   */
  @Test()
  public void TC078_MyMusic_MyTracklists_rename_tracklist() throws InterruptedException {
    String testName = "TC078 - MyMusic_MyTracklists_rename tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.myMusicRenameTracklist();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracklist using multi-track
   */
  @Test()
  public void TC080_MyMusic_MyTracklists_sort_using_Multitrack_selection() throws InterruptedException {
    String testName = "TC080 - MyMusic_MyTracklists_sort using Multi-track selection";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      loginPage.setMoneyBagBalance();
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistMultiTrackSelection();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracklist using multi-track
   */
  @Test()
  public void TC081_MyMusic_MyTracklists_deselect_tracks_using_Multitrack_selection() throws InterruptedException {
    String testName = "TC081 - MyMusic_MyTracklists_deselect tracks using Multi-track selection";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistMultiTrackDeselection();
      spotPage.deleteAllTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the My Tracklist content when a new tracklist is empty
   */
  @Test()
  public void TC082_MyMusic_MyTracklists_empty_new_tracklist_screen() throws InterruptedException {
    String testName = "TC082 - MyMusic_MyTracklists_empty tracklist screen";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.createTracklist();

      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to see recently used spots
   */
  @Test()
  public void TC083_Home_Find_Proximate_Jukeboxes_Recent_spots() throws InterruptedException {
    String testName = "TC083 - Home_Find Proximate Jukeboxes_Recent spots";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.recentSpots();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to remove a Spot from favorites. User should be logged in
   */
  @Test()
  public void TC084_Home_Find_Proximate_Jukeboxes_Remove_a_Spot_from_favorites() throws InterruptedException {
    String testName = "TC084 - Home_Find Proximate Jukeboxes_Remove a Spot from favorites";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocation(true, "Consulting");
      spotPage.favoriteSpot(true);
      spotPage.noFavorites();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to search a Spot a using location field
   */
  @Test()
  public void TC085_Home_Find_Proximate_Jukeboxes_Search_a_Spot_using_location() throws InterruptedException {
    String testName = "TC085 - Home_Find Proximate Jukeboxes_Search a Spot using location";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocationbyZipcode();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to search a Spot a using location field
   */
  @Test()
  public void TC086_Home_Find_Proximate_Jukeboxes_Search_a_Spot_using_special_characters() throws InterruptedException {
    String testName = "TC086 - Home_Find Proximate Jukeboxes_Search a Spot using special characters";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      proximatePage.searchLocationWCharacters();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system shows the spot in home screen
   */
  @Test()
  public void TC087_Home_Find_Proximate_Jukeboxes_Verify_spot_is_listed_in_home() throws InterruptedException {
    String testName = "TC087 - Home_Find Proximate Jukeboxes_Verify spot is listed in home";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.searchLocation(true, "Consulting");
      spotPage.favoriteSpotListedinHome();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the spot dropdown from the home screen page
   */
  @Test()
  public void TC088_Home_Find_Proximate_Jukeboxes_Verify_spots_dropdown_in_home_screen() throws InterruptedException {
    String testName = "TC088 - Home_Find Proximate Jukeboxes_Verify spot's dropdown in home screen";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.spotsDropDownList();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system can add Cash for $24
   */
  @Test()
  public void TC089_AddCash_Auto_Add_24_dollars() throws InterruptedException {
    String testName = "TC089 - AddCash_Auto-Add $24 dollars";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicket24Dollars();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system can add Cash for $12
   */
  @Test()
  public void TC090_AddCash_Auto_Add_12_dollars() throws InterruptedException {
    String testName = "TC090 - AddCash_Auto-Add $12 dollars";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.swtchOffAutoReload();
      spotPage.addCashTokenTicket12Dollars();
      //statementPage.transactionHistoryUpdateAddCash12Dollars();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  // /*
  //  * Validate the system automatically add Cash when user turns on Auto-Reload option.
  //  */
  // @Test()
  // public void TC091_AddCash_Auto_Reload_turned_feature() throws InterruptedException {
  //   String testName = "TC091 - AddCash_Auto-Reload turned feature";
  //   AppiumDriver driver = getDriver(testName);

  //   try {
  //     // Declare the driver (obligatory)

  //     /*
  //      * Declare the pages that are being used
  //      twelve*/
  //     LoginPageIOS loginPage = new LoginPageIOS(driver);
  //     StatementPageIOS statementPage = new StatementPageIOS(driver);
  //     SpotPageIOS spotPage = new SpotPageIOS(driver);
  //     ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
  //     /*
  //      * Use the functions of set page to run the test
  //      */
  //     loginPage.login(true, statementEmail, statementPws);
  //     spotPage.addCashTokenTicket12Dollars();
  //     statementPage.transactionHistoryUpdateAddCash12Dollars();
  //     statementPage.logout();
  //     /*
  //      * End test
  //      */

  //     Actions.endTest(driver);
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
  //   } catch (Exception e) {
  //     /*
  //      * If something happens print error and fail test
  //      */
  //     e.printStackTrace();
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
  //                                                                                       // needed
  //     Actions.failedTest();
  //   }
  // }


  /*
   * Validate user can access Refer a friend from My Statement menu
   */
  @Test()
  public void TC092_MyStatement_Refer_a_friend() throws InterruptedException {
    String testName = "TC092 - MyStatement_Refer a friend";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.referAFriend();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access Refer a friend from My Statement menu
   */
  @Test()
  public void TC094_MyStatement_Refer_a_friend_share_link() throws InterruptedException {
    String testName = "TC094 - MyStatement_Refer a friend share link";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.referAFriendShareLink();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access the Help menu from my Statement
   */
  @Test()
  public void TC095_My_Statement_Help_menu() throws InterruptedException {
    String testName = "TC095 - My_Statement_Help menu";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.help();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access the Terms of Service menu from my Statement
   */
  @Test()
  public void TC096_My_Statement_Terms_of_Service_Menu() throws InterruptedException {
    String testName = "TC096 - My_Statement_Terms of Service Menu";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.termsOfService();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access the Privacy Policy menu from my Statement
   */
  @Test()
  public void TC097_My_Statement_Privacy_Policy_Menu() throws InterruptedException {
    String testName = "TC097 - My_Statement_Privacy Policy Menu";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.privacyPolicy();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access the Settings menu from my Statement
   */
  @Test()
  public void TC098_My_Statement_Settings_menu() throws InterruptedException {
    String testName = "TC098 - My_Statement_Settings menu";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenu();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to add multiple tracks to queue and the same can be seen in My Music page
   */
  @Test()
  public void TC099_All_Music_Add_Music_to_queue() throws InterruptedException {
    String testName = "TC099 - All Music_Add Music to queue";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.play5Tracks("my way");
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to add playing track to tracklist
   */
  @Test()
  public void TC100_All_Music_Add_playing_track_to_tracklist() throws InterruptedException {
    String testName = "TC100 - All Music_Add playing track to tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("my way");
      spotPage.NowPlayingAddTracktoTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to add playing track to tracklist
   */
  @Test()
  public void TC113_MyMusic_MyTracklists_move_track_from_tracklist() throws InterruptedException {
    String testName = "TC113 - MyMusic_MyTracklists_move track from tracklist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      //spotPage.createTracklist();
      //spotPage.addToTracklistFromTracklist();
      //spotPage.deleteTracklist();
      statementPage.logout();

      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system sorts tracklist tracks by track order
   */
  @Test()
  public void TC115_MyMusic_MyTracklists_sort_by_track_order() throws InterruptedException {
    String testName = "TC115 - MyMusic_MyTracklists_sort by track order";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistSortByTrackOrder();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can select all tracks using the Select All Tracks radio button
   */
  @Test()
  public void TC116_MyMusic_MyTracklist_Select_and_play_all_tracks() throws InterruptedException {
    String testName = "TC116 - MyMusic_MyTracklist_Select and play all tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);

      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      loginPage.setMoneyBagBalance();
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Metallica");
      spotPage.tracklistMultiTrackAllTracks();
      spotPage.deleteAllTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can deselect and cannot play all tracks using the Select All Tracks radio button
   */
  @Test()
  public void TC117_MyMusic_MyTracklist_Deselect_and_play_all_tracks() throws InterruptedException {
    String testName = "TC117 - MyMusic_MyTracklist_Deselect and play all tracks";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.Add3TracksToTracklist("Bjork");
      spotPage.tracklistMultiTrackDeselectAllTracks();
      spotPage.deleteTracklist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access Refer a friend QR code from My Statement menu
   */
  @Test()
  public void TC118_MyStatement_Refer_a_friend_QR_code_generated() throws InterruptedException {
    String testName = "TC118 - MyStatement_Refer a friend_QR code generated";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.referAFriendQRCodeGenerated();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Refer a Friend screen is opened with New tab selected as default.
   */
  @Test()
  public void TC119_MyStatement_Refer_a_friend_New_Tab() throws InterruptedException {
    String testName = "TC119 - MyStatement_Refer a friend_New Tab";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.referAFriendNewTab();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access Refer a friend \ Pending tab
   */
  @Test()
  public void TC120_MyStatement_Refer_a_friend_Pending_Tab() throws InterruptedException {
    String testName = "TC120 - MyStatement_Refer a friend_Pending Tab";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.referAFriendPendingTab();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access Refer a friend \ Successful tab
   */
  @Test()
  public void TC121_MyStatement_Refer_a_friend_Successful_Tab() throws InterruptedException {
    String testName = "TC121 - MyStatement_Refer a friend_Successful Tab";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      statementPage.referAFriendSuccessfulTab();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Dark Mode label option is displayed in My Statement menu.
   */
  @Test()
  public void TC122_MyStatement_Settings_menu_Dark_Mode_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC122 - MyStatement_Settings menu_Dark Mode Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuDarkMode();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Confirm Purchase label option is displayed in My Statement menu.
   */
  @Test()
  public void TC123_MyStatement_Settings_menu_Confirm_Purchase_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC123 - MyStatement_Settings menu_Confirm Purchase Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuConfirmPurchase();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Auto Reload Failure label option is displayed in My Statement menu.
   */
  @Test()
  public void TC124_MyStatement_Settings_menu_Auto_Reload_Failure_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC124 - MyStatement_Settings menu_Auto Reload Failure Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      //statementPage.settingsMenuAutoReloadFailure();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Available Cash Tokens label option is displayed in My Statement menu.
   */
  @Test()
  public void TC125_MyStatement_Settings_menu_Available_Cash_Tokens_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC125 - MyStatement_Settings menu_Available Cash Tokens Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuAvailableCashTokens();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Location Welcome label option is displayed in My Statement menu.
   */
  @Test()
  public void TC126_MyStatement_Settings_menu_Location_Welcome_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC126 - MyStatement_Settings menu_Location Welcome Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuLocationWelcome();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Purchase Refound Label label option is displayed in My Statement menu.
   */
  @Test()
  public void TC127_MyStatement_Settings_menu_Purchase_Refound_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC127 - MyStatement_Settings menu_Purchase Refound Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuPurchaseRecash();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Refer A Friend Referred label option is displayed in My Statement menu.
   */
  @Test()
  public void TC128_MyStatement_Settings_menu_Refer_A_Friend_Referred_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC128 - MyStatement_Settings menu_Refer A Friend Referred Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuReferAFriendReferred();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Confirm Purchase switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC129_MyStatement_Settings_menu_Refer_A_Friend_Referrer_Label_Option_Displayed() throws InterruptedException {
    String testName = "TC129 - MyStatement_Settings menu_Refer A Friend Referrer Label Option Displayed";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuReferAFriendReferrer();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate user can access to the Artist music from Now Playing menu
   */
  @Test()
  public void TC130_All_Music_Playing_track_View_this_artist() throws InterruptedException {
    String testName = "TC130 - All Music_Playing track_View this artist";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("bjork hyperballad");
      spotPage.NowPlayingViewThisArtist();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


   /*
   * Validate Confirm Purchase switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC131_MyStatement_Settings_menu_Confirm_Purchase_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC131 - Validate Confirm Purchase switch in My Statement menu can be turned ON and OFF.";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuConfirmPurchaseToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Auto Reload Failure switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC132_MyStatement_Settings_menu_Auto_Reload_Failure_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC132 - MyStatement_Settings menu_Auto Reload Failure Switch ON/OFF";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      //statementPage.settingsMenuAutoReloadFailureToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Available Cash Tokens  switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC133_MyStatement_Settings_menu_Available_Cash_Tokens_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC133 - MyStatement_Settings menu_Auto Reload Failure Switch ON/OFF";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuAvailableCashTokensToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Location Welcome switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC134_MyStatement_Settings_menu_Location_Welcome_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC134 - MyStatement_Settings menu_Location Welcome Switch ON/OFF";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuLocationWelcomeToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Purchase Refound switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC135_MyStatement_Settings_menu_Purchase_Refound_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC135 - MyStatement_Settings menu_Purchase Refound Switch ON/OFF";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuPurchaseRecashToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Refer A Friend Referred switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC136_Validate_Refer_A_Friend_Referred_switch_in_My_Statement_menu_can_be_turned_ON_OFF() throws InterruptedException {
    String testName = "TC136 - Validate Refer A Friend Referred switch in My Statement menu can be turned ON and OFF.";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuReferAFriendReferredToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate Refer A Friend Referrer  switch in My Statement menu can be turned ON and OFF.
   */
  @Test()
  public void TC137_MyStatement_Settings_menu_Refer_A_Friend_Referrer_Switch_ON_OFF() throws InterruptedException {
    String testName = "TC137 - MyStatement_Settings menu_Refer A Friend Referrer Switch ON/OFF";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(false, statementEmail, statementPws);
      statementPage.settingsMenuReferAFriendReferrerToggle();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate the system allows to add playing track to tracklist My Music
   */
  @Test()
  public void TC138_All_Music_Add_playing_track_to_My_Music() throws InterruptedException {
    String testName = "TC138 - All Music_Add playing track to My Music";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      spotPage.playTrack("my way");
      spotPage.NowPlayingAddTracktoMyMusic();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate 'Select your current Spot' menu can be accessed from 'All Music' screen.
   */
  @Test()
  public void TC139_All_Music_Select_your_current_Spot() throws InterruptedException {
    String testName = "TC139 - All Music_Select your current Spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.allMusicSelectSpot();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate 'Select your current Spot' menu can be accessed from 'My Music' screen.
   */
  @Test()
  public void TC140_My_Music_Select_your_current_Spot() throws InterruptedException {
    String testName = "TC140 - My Music_Select your current Spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.myMusicSelectSpot();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate 'Select your current Spot' menu can be accessed from 'Add Cash' screen.
   */
  @Test()
  public void TC141_Add_Cash_Select_your_current_Spot() throws InterruptedException {
    String testName = "TC141 - Add Cash_Select your current Spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.addCashSelectSpot();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Validate 'Select your current Spot' menu can be accessed from 'My Music\Tracklist' screen.
   */
  @Test()
  public void TC142_My_Music_Tracklist_Select_your_current_Spot() throws InterruptedException {
    String testName = "TC142 - My Music_Tracklist_Select your current Spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.myMusicTracklistSelectSpot();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Search an invalid Spot using "current location" field
   */
  @Test()
  public void TC143_Home_Find_Proximate_Jukeboxes_Search_an_invalid_Spot_using_current_location_field() throws InterruptedException {
    String testName = "TC143 - Home_Find Proximate Jukeboxes_Search an invalid Spot using current location field";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      proximatePage.searchInvalidSpotCurrentLocation("***");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Search an invalid Spot using "All spots" field
   */
  @Test()
  public void TC144_Home_Find_Proximate_Jukeboxes_Search_an_invalid_Spot_using_All_spots_field() throws InterruptedException {
    String testName = "TC144 - Home_Find Proximate Jukeboxes_Search an invalid Spot using All spots field";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      loginPage.setQAEnv();
      proximatePage.searchInvalidSpotAllSpots("matamoros");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * verify guest is able to visit online spot
   */
  @Test()
  public void TC146_Home_Find_Proximate_Jukeboxes_verify_guest_is_able_to_visit_online_spot() throws InterruptedException {
    String testName = "TC146 - Home_Find Proximate Jukeboxes_verify guest is able to visit online spot";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.login(true, statementEmail, statementPws);
      proximatePage.selectTestLocation("Consulting");
      spotPage.homePageTabsUI();
      statementPage.logout();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Visit "Recent" tab as Guest
   */
  @Test()
  public void TC147_Home_Find_Recent_Jukeboxes_Visit_Recent_tab_as_Guest() throws InterruptedException {
    String testName = "TC147 - Home_Find Recent Jukeboxes_Visit Recent tab as Guest";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      proximatePage.recentTabasGuest();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Visit "Favorites" tab as Guest
   */
  @Test()
  public void TC148_Home_Find_Favorites_Jukeboxes_Visit_Favorites_tab_as_Guest() throws InterruptedException {
    String testName = "TC148 - Home_Find Favorites Jukeboxes_Visit Favorites tab as Guest";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      proximatePage.favoritesTabasGuest();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Visit "My statement" panel as Guest
   */
  @Test()
  public void TC149_Home_My_Statement_Visit_My_statement_panel_as_Guest() throws InterruptedException {
    String testName = "TC149 - Home_My Statement_Visit My statement panel as Guest";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      statementPage.myStatementasGuest();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * verify Guest is able to search Artist/tracks/albums
   */
  @Test()
  public void TC150_All_Music_Guest_Verify_Guest_is_able_to_search_Artist_tracks_albums() throws InterruptedException {
    String testName = "TC150 - All Music_Guest_Verify Guest is able to search Artist/tracks/albums";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      loginPage.setQAEnv();
      proximatePage.selectTestLocation("Consulting");
      spotPage.searchTrackAsGuest("Enter Sandman");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Verify Guest is NOT able to listen track from search results Artist home page - Tracks main list
   */
  @Test()
  public void TC151_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_search_results_Artist_home_page_Tracks_main_list() throws InterruptedException {
    String testName = "TC151 - All Music_Guest_Verify Guest is NOT able to listen track from search results Artist home page - Tracks main list";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      loginPage.setQAEnv();
      proximatePage.selectTestLocation("Consulting");
      spotPage.playTrackAsGuest("hyperballad");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


  /*
   * Verify Guest is NOT able to listen track from search results Artist home page - Album tracks list
   */
  // @Test()
  // public void TC152_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_search_results_Artist_home_page_Album_tracks_list() throws InterruptedException {
  //   String testName = "TC152 - All Music_Guest_Verify Guest is NOT able to listen track from search results Artist home page - Album tracks list";
  //   AppiumDriver driver = getDriver(testName);

  //   try {
  //     // Declare the driver (obligatory)

  //     /*
  //      * Declare the pages that are being used
  //      twelve*/
  //     LoginPageIOS loginPage = new LoginPageIOS(driver);
  //     StatementPageIOS statementPage = new StatementPageIOS(driver);
  //     SpotPageIOS spotPage = new SpotPageIOS(driver);
  //     ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
  //     /*
  //      * Use the functions of set page to run the test
  //      */
  //     loginPage.skipIntro("Allow while");
  //     loginPage.setQAEnv();
  //     proximatePage.selectTestLocation("Consulting");
  //     spotPage.playTrackAsGuestFromArtists_Album("Metallica");
  //     /*
  //      * End test
  //      */

  //     Actions.endTest(driver);
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
  //   } catch (Exception e) {
  //     /*
  //      * If something happens print error and fail test
  //      */
  //     e.printStackTrace();
  //     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
  //                                                                                       // needed
  //     Actions.failedTest();
  //   }
  // }


   /*
   * Verify Guest is NOT able to listen track from search results - Tracks section
   */
  @Test()
  public void TC153_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_search_results_Tracks_section() throws InterruptedException {
    String testName = "TC153 - All Music_Guest_Verify Guest is NOT able to listen track from search results - Tracks section";
    AppiumDriver driver = getDriver(testName);

   try {
     // Declare the driver (obligatory)

     /*
      * Declare the pages that are being used
      */
     LoginPageIOS loginPage = new LoginPageIOS(driver);
     StatementPageIOS statementPage = new StatementPageIOS(driver);
     SpotPageIOS spotPage = new SpotPageIOS(driver);
     ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
     /*
      * Use the functions of set page to run the test
      */
     loginPage.skipIntro("Allow while");
     loginPage.setQAEnv();
     proximatePage.selectTestLocation("Consulting");
     spotPage.playTrackAsGuestFromArtists_Tracks("Metallica");
     /*
      * End test
      */

     Actions.endTest(driver);
     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
   } catch (Exception e) {
     /*
      * If something happens print error and fail test
      */
     e.printStackTrace();
     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                         // needed
     Actions.failedTest();
  }
 }


   /*
   * Verify Guest is NOT able to listen track from search results - Albums section
   */
  @Test()
  public void TC154_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_search_results_Tracks_section() throws InterruptedException {
    String testName = "TC154 - All Music_Guest_Verify Guest is NOT able to listen track from search results - Albums section";
    AppiumDriver driver = getDriver(testName);

   try {
     // Declare the driver (obligatory)

     /*
      * Declare the pages that are being used
      */
     LoginPageIOS loginPage = new LoginPageIOS(driver);
     StatementPageIOS statementPage = new StatementPageIOS(driver);
     SpotPageIOS spotPage = new SpotPageIOS(driver);
     ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
     /*
      * Use the functions of set page to run the test
      */
     loginPage.skipIntro("Allow while");
     loginPage.setQAEnv();
     proximatePage.selectTestLocation("Consulting");
     spotPage.playTrackAsGuestFromAlbum_Track("Metallica");
     /*
      * End test
      */

     Actions.endTest(driver);
     Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
   } catch (Exception e) {
     /*
      * If something happens print error and fail test
      */
     e.printStackTrace();
     Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                         // needed
     Actions.failedTest();
  }
 }


   /*
    * Verify Guest is NOT able to listen track from Tracks Hot Here section
    */
   @Test()
   public void TC155_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_Tracks_Hot_Here_section() throws InterruptedException {
     String testName = "TC155 - All Music_Guest_Verify Guest is NOT able to listen track from Tracks Hot Here section";
     AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       */
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      loginPage.setQAEnv();
      proximatePage.selectTestLocation("Consulting");
      spotPage.playTrackAsGuestHotTrack();
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
      Actions.failedTest();
   }
  }


  /*
    * Verify Guest is NOT able to listen track from Artist Hot Here section - Tracks main list
    */
    @Test()
    public void TC156_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_Artists_Hot_Here_section_Tracks_main_list() throws InterruptedException {
      String testName = "TC156 - All Music_Guest_Verify Guest is NOT able to listen track from Artists Hot Here section - Tracks main list";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Allow while");
       loginPage.setQAEnv();
       proximatePage.selectTestLocation("Consulting");
       spotPage.playTrackAsGuestHotArtists();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify Guest is NOT able to listen track from Artist Hot Here section - Album tracks list
    */
    @Test()
    public void TC157_All_Music_Guest_Verify_Guest_is_NOT_able_to_listen_track_from_Artist_Hot_Here_section_Album_tracks_list() throws InterruptedException {
      String testName = "TC157_All Music_Guest_Verify Guest is NOT able to listen track from Artist Hot Here section - Album tracks list";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Allow while");
       loginPage.setQAEnv();
       proximatePage.selectTestLocation("Consulting");
       spotPage.playTrackAsGuestHotArtists();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify Guests is not able to access My Music tab
    */
    @Test()
    public void TC160_My_Music_Guest_Verify_Guests_is_not_able_to_access_My_Music_tab() throws InterruptedException {
      String testName = "TC160_My Music_Guest_Verify Guests is not able to access My Music tab";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Allow while");
       loginPage.setQAEnv();
       proximatePage.selectTestLocation("Consulting");
       spotPage.guestNotAccessToMyMusic();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify Guests is not able to access Add Cash tab
    */
    @Test()
    public void TC161_My_Music_Guest_Verify_Guests_is_not_able_to_access_Add_Cash_tab() throws InterruptedException {
      String testName = "TC161_My Music_Guest_Verify Guests is not able to access Add Cash tab";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Allow while");
       loginPage.setQAEnv();
       proximatePage.selectTestLocation("Consulting");
       spotPage.guestNotAccessToAddCash();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
   * Verify error message when user search a Spot using special characters in "All Spots" field
   */
  @Test()
  public void TC163_Home_Find_Proximate_Jukeboxes_Search_a_Spot_using_special_characters_in_All_Spots_field() throws InterruptedException {
    String testName = "TC163 - Home_Find Proximate Jukeboxes_Search a Spot using special characters in All Spots field";
    AppiumDriver driver = getDriver(testName);

    try {
      // Declare the driver (obligatory)

      /*
       * Declare the pages that are being used
       twelve*/
      LoginPageIOS loginPage = new LoginPageIOS(driver);
      StatementPageIOS statementPage = new StatementPageIOS(driver);
      SpotPageIOS spotPage = new SpotPageIOS(driver);
      ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
      /*
       * Use the functions of set page to run the test
       */
      loginPage.skipIntro("Allow while");
      loginPage.setQAEnv();
      proximatePage.searchInvalidSpotAllSpots("!\"#$%&");
      /*
       * End test
       */

      Actions.endTest(driver);
      Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
    } catch (Exception e) {
      /*
       * If something happens print error and fail test
       */
      e.printStackTrace();
      Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                        // needed
      Actions.failedTest();
    }
  }


   /*
    * Verify error message for Search non existing artist (special characters) - &/()&/()
    */
    @Test()
    public void TC164_All_Music_Search_non_existing_artist_special_characters() throws InterruptedException {
      String testName = "TC164_All Music_Search non existing artist (special characters) - &/()&/()";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.skipIntro("Allow while");
       loginPage.setQAEnv();
       proximatePage.selectTestLocation("Consulting");
       spotPage.searchNonExistingArtistWSpecialCharacters("&/()&/()");
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }

         /*
   *User is able to create tracklist with long name
   */
  @Test()
    public void TC187_MyMusic_My_Tracklist_Verify_user_is_able_to_create_new_tracklist() throws InterruptedException {
      String testName = "TC187_MyMusic_Verify user is able to create New Tracklist";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        spotPage.successfulTracklist();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

      /*
   *User is able to create tracklist with long name
   */
  @Test()
    public void TC188_MyMusic_My_Tracklist_Verify_user_is_able_to_create_tracklist_using_special_characters() throws InterruptedException {
      String testName = "TC188_MyMusic_Verify user is able to create Tracklist using special characters";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        spotPage.tracklistwithSpecialCharacter();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

   /*
   *User is able to create tracklist with long name
   */
  @Test()
    public void TC189_MyMusic_My_Tracklist_Verify_error_message_when_user_try_to_create_tracklist_with_long_name() throws InterruptedException {
      String testName = "TC189_MyMusic_My Tracklists_Verify Error message when user try to create Tracklist with long name (more than 40 chars)";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        spotPage.tracklistNameError();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }


               /*
    * Verify user is not able to exceed $50 in balance
    */
       @Test()
    public void TC190_AddCash_Verify_user_is_not_able_to_exceed_50_in_balance() throws InterruptedException {
      String testName = "TC190_AddCash_Verify user is not able to exceed $50 in balance";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        statementPage.swtchOffAutoReload();
        spotPage.addCashExceedBalance();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

                   /*
    * Verify user is not able to exceed $50 in balance
    */
       @Test()
    public void TC191_AddCash_Verify_add_cash_button_is_not_appearing_when_auto_reload_is_enabled() throws InterruptedException {
      String testName = "TC191_AddCash_Verify Add cash button is not appearing when auto-reload is enabled";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        statementPage.swtchOnAutoReload();
        spotPage.addCashButtonReloadCheck();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

            /*
    * Verify error message when trying to use invalid expiration date
    */
       @Test()
    public void TC192_AddCash_Verify_error_message_when_user_is_trying_to_use_less_than_16_numbers_to_register_ticket() throws InterruptedException {
      String testName = "TC192_AddCash_Verify error message when user is trying to use less than 16 numbers to register ticket";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketLessNumbers();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

   
         /*
    * Verify error message when trying to use invalid expiration date
    */
       @Test()
    public void TC193_AddCash_Verify_error_message_when_user_is_trying_to_use_invalid_expiration_date() throws InterruptedException {
      String testName = "TC193_AddCash_Verify error message when user is trying to use invalid expiration date";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketInvalidExpDate();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

         /*
    * Verify error message when trying to use invalid cvc
    */
    @Test()
    public void TC194_AddCash_Verify_error_message_when_user_is_trying_to_use_invalid_cvc() throws InterruptedException {
      String testName = "TC194_AddCash_Verify error message when user is trying to use invalid CVC";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketInvalidCCV();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }
      /*
    * Verify error message when trying to use invalid token ticket number
    */
    @Test()
    public void TC195_AddCash_Verify_error_message_when_user_is_trying_to_use_invalid_token_ticket_number() throws InterruptedException {
      String testName = "TC195_AddCash_Verify error message when user is trying to use invalid token ticket number";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketInvalidNumbers();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }
      /*
    * Verify error message when trying to use invalid zip code
    */
    @Test()
    public void TC196_AddCash_Verify_error_message_when_user_is_trying_to_use_invalid_zip_code() throws InterruptedException {
      String testName = "TC196_AddCash_Verify error message when user is trying to use invalid ZIP code";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketInvalidZipCode();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

    /*
    * Verify user is able to add ticket disabling option to Save for future use
    */
    @Test()
    public void TC197_AddCash_Verify_user_is_able_to_add_ticket_disabling_option_to_Save_for_future_use() throws InterruptedException {
      String testName = "TC197_AddCash_Verify user is able to add ticket disabling option to Save for future use";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        //spotPage.addCashSaveforFutureButton();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

    /*
    * Verify error save button is not enabled unitil all fields are populated
    */
    @Test()
    public void TC198_AddCash_Verify_SAVE_button_is_not_enabled_until_all_fields_are_populated_when_adding_ticket() throws InterruptedException {
      String testName = "TC198_AddCash_Verify SAVE button is not enabled until all fields are populated when adding ticket";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        addticketPage.tokenTicketButtonSaveDisabled();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

        /*
    * Verify user is able to add ticket disabling option to Save for future use
    */
    @Test()
    public void TC199_AddCash_Verify_user_is_able_to_switch_saved_tickets() throws InterruptedException {
      String testName = "TC199_AddCash_Verify user is able to switch saved tickets";
      AppiumDriver driver = getDriver(testName);
 
      try {
        // Declare the driver (obligatory)
 
        /*
         * Declare the pages that are being used
         */
        LoginPageIOS loginPage = new LoginPageIOS(driver);
        StatementPageIOS statementPage = new StatementPageIOS(driver);
        AddTicketPageIOS addticketPage = new AddTicketPageIOS(driver);
        SpotPageIOS spotPage = new SpotPageIOS(driver);
        ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
 
        /*
         * Use the functions of set page to run the test
         */
        loginPage.login(true, "consulting-1@consultingteam.tester.com", statementPws);
        proximatePage.selectTestLocation("Consulting");
        statementPage.swtchOffAutoReload();
        addticketPage.switchSavedTickets();
        statementPage.logout();
       
        /*
         * End test
         */
 
        Actions.endTest(driver);
        Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
      } catch (Exception e) {
        /*
         * If something happens print error and fail test
         */
        e.printStackTrace();
        Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                          // needed
        Actions.failedTest();
      }
    }

   /*
    * Verify error message when user submits invalid code
    */
    @Test()
    public void TC202_ReedemPromoCode_Verify_error_message_when_user_submits_invalid_code() throws InterruptedException {
      String testName = "TC202_ReedemPromoCode_Verify error message when user submits invalid code";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.login(true, statementEmail, statementPws);
       proximatePage.selectTestLocation("Consulting");
       statementPage.redeemInvalidPromotion();
       statementPage.logout();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify 'tap here' link
    */
    @Test()
    public void TC203_ReedemPromoCode_Verify_tap_here_link() throws InterruptedException {
      String testName = "TC203_ReedemPromoCode_Verify 'tap here' link";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.login(true, statementEmail, statementPws);
       proximatePage.selectTestLocation("Consulting");
       statementPage.redeemTapHere();
       statementPage.logout();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify error message when user submits empty code
    */
    @Test()
    public void TC204_ReedemPromoCode_Verify_error_message_when_user_submits_empty_code() throws InterruptedException {
      String testName = "TC204_ReedemPromoCode_Verify error message when user submits empty code";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.login(true, statementEmail, statementPws);
       proximatePage.selectTestLocation("Consulting");
       statementPage.redeemEmptyPromotion();
       statementPage.logout();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }


   /*
    * Verify the redeem promo code screen points to the correct cafe.
    */
    @Test()
    public void TC205_ReedemPromoCode_The_code_entered_will_be_redeemed_at_points_the_correct_pub() throws InterruptedException {
      String testName = "TC205_ReedemPromoCode_The code entered will be redeemed at points the correct cafe";
      AppiumDriver driver = getDriver(testName);
 
     try {
       // Declare the driver (obligatory)
 
       /*
        * Declare the pages that are being used
        */
       LoginPageIOS loginPage = new LoginPageIOS(driver);
       StatementPageIOS statementPage = new StatementPageIOS(driver);
       SpotPageIOS spotPage = new SpotPageIOS(driver);
       ProximatePageIOS proximatePage = new ProximatePageIOS(driver);
       /*
        * Use the functions of set page to run the test
        */
       loginPage.login(true, statementEmail, statementPws);
       proximatePage.selectTestLocation("Consulting");
       statementPage.redeemPub();
       statementPage.logout();
       /*
        * End test
        */
 
       Actions.endTest(driver);
       Utils.addMobileExecution(mobileExecutionsArray, testName, true, executionOS, 0); // Execution status 0 = Passed
     } catch (Exception e) {
       /*
        * If something happens print error and fail test
        */
       e.printStackTrace();
       Utils.addMobileExecution(mobileExecutionsArray, testName, false, executionOS, 2); // Executino status 2 = Review
                                                                                           // needed
       Actions.failedTest();
    }
   }

}
