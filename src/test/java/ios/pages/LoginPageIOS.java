package ios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import page_interfaces.Login;
import utils.Actions;


import org.openqa.selenium.Dimension;
import io.appium.java_client.TouchAction;

public class LoginPageIOS implements Login {

  /*
   * 
   * EXAMPLE IOS PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  IOSDriver driver;

  // DECLARE CONSTRUCTOR
  public LoginPageIOS(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (IOSDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @iOSXCUITFindBy(xpath = "//*[@name='']")
  private IOSElement testButton;

  //@iOSXCUITFindBy(xpath = "//*[@name='Find Proximate Jukeboxes']")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Find Proximate Jukeboxes\"]")
  private IOSElement findProximateButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Allow Once']")
  private IOSElement allowOnceButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Allow While Using App']")
  private IOSElement allowWhileButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")
  private IOSElement dontAllowButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Continue']")
  private IOSElement continueButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Continue\"])[2]")
  private IOSElement continueTwoButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Continue\"])[3]")
  private IOSElement continueThreeButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Allow']")
  private IOSElement allowButton;

  @iOSXCUITFindBy(xpath = "//*[@name='statement']")
  private IOSElement statementButton;

  @iOSXCUITFindBy(xpath = "//*[@name='l']")
  private IOSElement leftButton;

  @iOSXCUITFindBy(xpath = "//*[@name='r']")
  private IOSElement rightButton;

  @iOSXCUITFindBy(xpath = "//*[@name='serverUrlTxtFld']")
  private IOSElement mobileUrlInput;

  @iOSXCUITFindBy(xpath = "//*[@name='Set URL']")
  private IOSElement setUrlButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Set']")
  private IOSElement confirmSetButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Got an statement? Log in']")
  private IOSElement alreadyStatementButton;

  @iOSXCUITFindBy(xpath = "//*[@name='usernameTxtFld']")
  private IOSElement statementEmailInput;

  @iOSXCUITFindBy(xpath = "//*[@name='passwordTxtFld']")
  private IOSElement statementPswInput;

  @iOSXCUITFindBy(xpath = "//*[@name='Log In']")
  private IOSElement loginButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Sign Up']")
  private IOSElement signUpButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Create a free statement']")
  private IOSElement createStatementButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Sign Out']")
  private IOSElement signOutButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Cancel']")
  private IOSElement cancelButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
  private IOSElement cancelButton2;

  @iOSXCUITFindBy(xpath = "//*[@name='COMPANY Music statement passwords must be 4 to 20 characters in length.']")
  private IOSElement invalidPasswordLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='The username/email and password you have entered do not match.']")
  private IOSElement invalidLoginPswMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Forgot password?\"]")
  private IOSElement forgotPswButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Send\"]")
  private IOSElement sendButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email Sent\"]")
  private IOSElement emailSentLabel;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")
  private IOSElement okButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
  private IOSElement okButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email or username can not be blank\"]")
  private IOSElement emailBlank;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"Empty list\"]")
  private IOSElement noLocationLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
  private IOSElement anyLocation;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Set\"]")
  private IOSElement setButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Oops\"]")
  private IOSElement invalidEntry;

  //@iOSXCUITFindBy(xpath = "XCUIElementTypeTable[@name=\"Empty list\"]")
  //private IOSElement emptyList;
  
  @iOSXCUITFindBy(xpath = "//*[@name='Back']")
  private IOSElement backButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Retry']")
  private IOSElement retryButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Hide In App Messages\"]")
  private IOSElement hideInAppMessagesToogle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Set Moneybag']")
  private IOSElement setMoneyBagBalanceButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Set moneybag balance']")
  private IOSElement setMoneyBagBalanceInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
  private IOSElement doneButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Force Onboarding:\"]")
  private IOSElement forceOnboardingLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")
  private IOSElement validationError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Not Now']")
  private IOSElement notNowButton;

  @iOSXCUITFindBy(xpath = "//*[@name='spotTxtFld']")
  private IOSElement spotInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"proximateLocationsTableManager\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
  private IOSElement firstSpotButton;

  
  /*
   * DECLARE FUNCTINOS
   */


  public void skipIntro(String type) throws InterruptedException {
    Actions.clickElementIOS(driver, findProximateButton);
    if (type == "Allow once") {
      Actions.clickElementIOS(driver, allowOnceButton);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, continueTwoButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, allowButton);
      Actions.clickElementIOS(driver, continueThreeButton);
      Actions.sleep(1000);
       boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
      if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.sleep(1000);

      //Actions.clickElementIOS(driver, allowOnceButton); //sometimes you need to remove it

      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      if (driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Retry\"]")).size() > 0)
       {Actions.clickElementIOS(driver, retryButton);
        System.out.println("Appered and clicked!");}
        else
       {Assert.assertNotEquals("Sorry, we weren't able to access your location. To utilize this feature, please be sure you have a network connection and that this app's Location services are enabled in your device settings.", anyLocation.getText());}
              
    } else if (type == "Allow while") {
      Actions.clickElementIOS(driver, allowWhileButton);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, continueTwoButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, allowButton);
      Actions.clickElementIOS(driver, continueThreeButton);
      Actions.sleep(6000);
      boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
           if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.sleep(1000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
      Actions.sleep(1000);

      if (driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Retry\"]")).size() > 0)
       {Actions.clickElementIOS(driver, retryButton);
        System.out.println("Appered and clicked!");}
        else
       {Assert.assertNotEquals("Sorry, we weren't able to access your location. To utilize this feature, please be sure you have a network connection and that this app's Location services are enabled in your device settings.", anyLocation.getText());}

    } else if (type == "Not allow") {
      Actions.clickElementIOS(driver, dontAllowButton);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, continueTwoButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, allowButton);
      Actions.clickElementIOS(driver, continueThreeButton);
      Actions.sleep(6000);
      boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
      if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
      System.out.println("Appered and clicked!");
      }
       
       if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {
        {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
       }

       if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
      System.out.println("Appered and clicked!");
      }

      Assert.assertEquals("Empty list", noLocationLabel.getText());
    }
  }
  

  @Override
  public void setQAEnv() throws InterruptedException {
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);

      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);
      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);
      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);
      
      //Actions.sendKeysIOS(driver, mobileUrlInput, "qa");
      //Actions.clickElementIOS(driver, doneButton);

      Actions.clickElementIOS(driver, hideInAppMessagesToogle);
      //Actions.sendKeysIOS(driver, setMoneyBagBalanceInput, "5");
      //Actions.clickElementIOS(driver, setMoneyBagBalanceButton);
      //Actions.clickElementIOS(driver, doneButton);
      //Actions.swipeOnCoordinates(driver, 170, 113, 160, 678);
      Actions.sendKeysIOS(driver, mobileUrlInput, "qa");
      Actions.clickElementIOS(driver, setUrlButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, setButton);
      Actions.sleep(1000);
      driver.launchApp();
      
      Actions.sleep(5000);

      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Allow Once']")).size() > 0)
       {Actions.clickElementIOS(driver, allowOnceButton);
        System.out.println("Appered and clicked!");}
      
      //Actions.clickElementIOS(driver, allowOnceButton); //sometimes you need to remove it
      
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

        //Actions.clickElementIOS(driver, allowOnceButton); //sometimes you need to remove it
  }

  @Override
  public void login(Boolean qa, String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    if (qa) {
     boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);

      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);
      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);
      Actions.clickElementIOS(driver, leftButton);
      Actions.clickElementIOS(driver, rightButton);

      Actions.clickElementIOS(driver, hideInAppMessagesToogle);
      //Actions.sendKeysIOS(driver, setMoneyBagBalanceInput, "5");
      //Actions.clickElementIOS(driver, setMoneyBagBalanceButton);
      //Actions.clickElementIOS(driver, doneButton);
      //Actions.swipeOnCoordinates(driver, 170, 113, 160, 678);
      Actions.sendKeysIOS(driver, mobileUrlInput, "qa");
      Actions.clickElementIOS(driver, setUrlButton);
      Actions.clickElementIOS(driver, setButton);
      Actions.sleep(1000);
      driver.launchApp();

      Actions.sleep(5000);
      Actions.clickElementIOS(driver, allowOnceButton);
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.sleep(2000);
      // Actions.clickElementIOS(driver, cancelButton);
      Actions.clickElementIOS(driver, statementButton);
      
      //Actions.clickElementIOS(driver, allowOnceButton);
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.clickElementIOS(driver, alreadyStatementButton);
      Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
      Actions.clickElementIOS(driver, loginButton);
        if (password=="Muk" || email=="test@email.com") {
          Assert.assertEquals("The username/email and password you have entered do not match.", invalidLoginPswMsg.getText());}
      Actions.sleep(3000);

    } else {
    boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);

      //Actions.clickElementIOS(driver, allowOnceButton);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.clickElementIOS(driver, alreadyStatementButton);
      Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
      Actions.clickElementIOS(driver, loginButton);
      Actions.sleep(2000);
    }
  }

  @Override
  public void setMoneyBagBalance() throws InterruptedException{
        if (Actions.isElementPresent(driver, spotInput)){
    Actions.sendKeysIOS(driver, spotInput, "companysecret1");
    Actions.sleep(2000);
    Actions.sendKeysIOS(driver, setMoneyBagBalanceInput, "25");
    Actions.clickElementIOS(driver, setMoneyBagBalanceButton);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, doneButton);
    Actions.clickElementIOS(driver, backButton);
    //Actions.swipeOnCoordinates(driver, 170, 113, 160, 678);
    }
  }

  @Override
  public void loginAgain(String email, String password) throws InterruptedException {
      boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
      if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
       System.out.println("Appered and clicked!");
      }
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, cancelButton);
      Actions.clickElementIOS(driver, alreadyStatementButton);
      Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
      Actions.clickElementIOS(driver, loginButton);
      Actions.sleep(2000);
    }

    @Override
  public void loginAgainFail(String email, String password) throws InterruptedException {
      boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
      if (errorIsPresent)
      {Actions.clickElementIOS(driver, notNowButton);
       System.out.println("Appered and clicked!");
      }
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);
      Actions.clickElementIOS(driver, cancelButton);
      Actions.clickElementIOS(driver, alreadyStatementButton);
      Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
      Actions.clickElementIOS(driver, continueButton);
      Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
      Actions.clickElementIOS(driver, loginButton);
      Assert.assertEquals("The username/email and password you have entered do not match.", invalidLoginPswMsg.getText());
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, okButton);
      Actions.clickElementIOS(driver, backButton);
      Actions.clickElementIOS(driver, backButton);
      Actions.clickElementIOS(driver, cancelButton);
      Actions.clickElementIOS(driver, backButton);
    }

    @Override
  public void forgotPassword(String email) throws InterruptedException {
      Actions.clickElementIOS(driver, statementButton);
      Actions.sleep(1000);

      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

      Actions.clickElementIOS(driver, alreadyStatementButton);
      Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
      Actions.clickElementIOS(driver, continueButton);
      Actions.clickElementIOS(driver, forgotPswButton);
      //Actions.clickElementIOS(driver, sendButton);
      //Assert.assertEquals("Email Sent", emailSentLabel.getText());
      //Actions.clickElementIOS(driver, okButton);
      Actions.sleep(2000);
    }
  
 

  @Override
  public void createStatement(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);

    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    //Actions.clickElementIOS(driver, createStatementButton);
    Actions.clickElementIOS(driver, leftButton);
    Actions.clickElementIOS(driver, rightButton);
    Actions.clickElementIOS(driver, leftButton);
    Actions.clickElementIOS(driver, rightButton);
    Actions.clickElementIOS(driver, leftButton);
    Actions.clickElementIOS(driver, rightButton);
    //Actions.sendKeysIOS(driver, mobileUrlInput, "qa");
    //Actions.clickElementIOS(driver, doneButton);

    Actions.clickElementIOS(driver, hideInAppMessagesToogle);
    //Actions.sendKeysIOS(driver, setMoneyBagBalanceInput, "5");
    //Actions.clickElementIOS(driver, setMoneyBagBalanceButton);
    //Actions.clickElementIOS(driver, doneButton);
    //Actions.swipeOnCoordinates(driver, 170, 113, 160, 678);
    Actions.sendKeysIOS(driver, mobileUrlInput, "qa");
    Actions.clickElementIOS(driver, setUrlButton);
    Actions.clickElementIOS(driver, setButton);
    Actions.sleep(1000);
    driver.launchApp();
    
    Actions.sleep(5000);
      Actions.clickElementIOS(driver, allowOnceButton);
      Actions.sleep(2000);
      if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
        
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);
    
    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    Actions.clickElementIOS(driver, createStatementButton);
    Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
    Actions.clickElementIOS(driver, continueButton);
    Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
    Actions.clickElementIOS(driver, signUpButton);
    Actions.sleep(2000);
  }


  @Override
  public void createStatementInvalidPsw(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    setQAEnv();
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);

    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    Actions.clickElementIOS(driver, createStatementButton);
    Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
    Actions.clickElementIOS(driver, continueButton);
    Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
    Actions.clickElementIOS(driver, signUpButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, invalidPasswordLabel);
    Actions.sleep(2000);
  }


  @Override
  public void loginBlank(String email) throws InterruptedException {
    skipIntro("Allow once");
    setQAEnv();
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);

    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    Actions.clickElementIOS(driver, createStatementButton);
    Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
    Actions.clickElementIOS(driver, continueButton);
    Assert.assertEquals("The username/email and password you have entered do not match.", emailBlank.getText());
    Actions.sleep(2000);
  }


  @Override
  public void loginSpaces(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    //setQAEnv();
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);

    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    Actions.clickElementIOS(driver, createStatementButton);
    Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
    Actions.clickElementIOS(driver, continueButton);
    Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
    Actions.clickElementIOS(driver, signUpButton);
    Actions.sleep(5000);
    Assert.assertEquals("Oops", invalidEntry.getText());
    Actions.sleep(2000);
  }


  @Override
  public void revealPassword(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    //setQAEnv();
    Actions.clickElementIOS(driver, statementButton);
    Actions.sleep(1000);

    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    Actions.clickElementIOS(driver, createStatementButton);
    Actions.sendKeysDropdownIOS(driver, statementEmailInput, email);
    Actions.clickElementIOS(driver, continueButton);
    Actions.sleep(2000);
    Actions.sendKeysDropdownIOS(driver, statementPswInput, password);
    //Actions.clickElementIOS(driver, signUpButton);
    //Assert.assertEquals("Oops", invalidEntry.getText());
    //Actions.sleep(2000);
  }
}