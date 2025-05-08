package android.pages;

import org.aspectj.weaver.ast.Not;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import page_interfaces.Login;
import utils.Actions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class LoginPageAndroid implements Login {

  /*
   * 
   * EXAMPLE ANDROID PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  AndroidDriver driver;

  // DECLARE CONSTRUCTOR
  public LoginPageAndroid(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (AndroidDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @AndroidFindBy(xpath = "//*[@text='']")
  private AndroidElement testButton;

  @AndroidFindBy(xpath = "//*[@text='Find Proximate Jukeboxes']")
  private AndroidElement findNearestButton;

  @AndroidFindBy(xpath = "//*[@text='Only this time']")
  private AndroidElement onlyThisTimeButton;

  @AndroidFindBy(xpath = "//*[@text='While using the app']")
  private AndroidElement whileAllowButton;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/btn_clear_cash']")
  private AndroidElement setMoneyBagBalanceButton;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_deny_button\"]")
  private AndroidElement dontAllowButton;

  @AndroidFindBy(xpath = "//*[@text='Continue']")
  private AndroidElement continueButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
  private AndroidElement statementPageButton;

  @AndroidFindBy(xpath = "//*[@text='Got an statement? Log in']")
  private AndroidElement alreadyStatementButton;

  @AndroidFindBy(xpath = "//*[@text='Email or username']")
  private AndroidElement loginEmailInput;

  @AndroidFindBy(xpath = "//*[@text='Password']")
  private AndroidElement loginPasswordInput;

  @AndroidFindBy(xpath = "//*[@text='Log In']")
  private AndroidElement loginButton;

  @AndroidFindBy(xpath = "//*[@text='Sign Up']")
  private AndroidElement signUpButton;

  @AndroidFindBy(xpath = "//*[@text='OK']")
  private AndroidElement okButton;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
  private AndroidElement backButton;

  @AndroidFindBy(xpath = "//*[@text='Mobile Server Url']")
  private AndroidElement urlInput;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[4]")
  private AndroidElement leftButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[5]")
  private AndroidElement rightButton;

  @AndroidFindBy(xpath = "//*[@text='Create a free statement']")
  private AndroidElement createStatementButton;

  @AndroidFindBy(xpath = "//*[@text='COMPANY Music statement passwords must be 4 to 20 characters in length.']")
  private AndroidElement invalidPasswordLabel;

  @AndroidFindBy(xpath = "//*[@text='The username/email and password you have entered do not match.']")
  private AndroidElement invalidLoginPswMsg;

  @AndroidFindBy(xpath = "//*[@text='Not Now']")
  private AndroidElement notNowButton;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/btn_cancel']")
  private AndroidElement notLoginNowButton;

  @AndroidFindBy(xpath = "//*[@text='Forgot Password?']")
  private AndroidElement forgotPswButton;

  @AndroidFindBy(xpath = "//*[@text='SEND']")
  private AndroidElement sendButton;

  @AndroidFindBy(xpath = "//*[@text='Email Sent']")
  private AndroidElement emailSentLabel;

  @AndroidFindBy(xpath = "//*[@text='Email or username can not be blank']")
  private AndroidElement emailBlank;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.company.COMPANYSmartBar:id/custom_list_info_text_view\"]")
  private AndroidElement noLocationLabel;

  @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.company.COMPANYSmartBar:id/ll_base_item\"])[1]")
  private AndroidElement anyLocation;

  @AndroidFindBy(xpath = "//*[@text='Invalid Entry']")
  private AndroidElement invalidEntry;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
  private AndroidElement iconShowPassword;

  @AndroidFindBy(xpath = "//*[@text='Retry']")
  private AndroidElement retryButton;

  @AndroidFindBy(xpath = "//*[@text='Hide In App Message']")
  private AndroidElement hideInAppMessagesToogle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText")
  private AndroidElement spotInput;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/balance_amount']")
  private AndroidElement setMoneyBagBalanceInput;


  //android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']

  /*
   * DECLARE FUNCTINOS
   */

  public void skipIntro(String type) throws InterruptedException {
    if (type == "Allow once") {
      Actions.clickElementAndroid(driver, findNearestButton);
      Actions.clickElementAndroid(driver, onlyThisTimeButton);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(1000);
      if (Actions.isElementPresent(driver, continueButton)){
        Actions.clickElementAndroid(driver, continueButton);
      }
      Actions.sleep(1000);

      if (Actions.isElementPresent(driver, continueButton)){
        Actions.clickElementAndroid(driver, continueButton);
      }
      
      Actions.sleep(6000);

      // if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
      //  {Actions.clickElementAndroid(driver, retryButton);
      //   System.out.println("Appered and clicked!");}
      //   else
      //  {Assert.assertNotEquals("Sorry, we weren't able to access your location. To utilize this feature, please be sure you have a network connection and that this app's Location services are enabled in your device settings.", anyLocation.getText());}

      
    } else if (type == "Allow while") {
      Actions.clickElementAndroid(driver, findNearestButton);
      Actions.clickElementAndroid(driver, whileAllowButton);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(6000);

      // if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
      //  {Actions.clickElementAndroid(driver, retryButton);
      //   System.out.println("Appered and clicked!");}
      //   else
      //  {Assert.assertNotEquals("Sorry, we weren't able to access your location. To utilize this feature, please be sure you have a network connection and that this app's Location services are enabled in your device settings.", anyLocation.getText());}

      
    } else if (type == "Not allow") {
      Actions.clickElementAndroid(driver, findNearestButton);
      Actions.clickElementAndroid(driver, dontAllowButton);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(1000);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sleep(6000);
      Assert.assertEquals("Sorry, we weren't able to access your location. To utilize this feature, please be sure you have a network connection and that this app's Location services are enabled in your device settings.", noLocationLabel.getText());

      
    }
  }

  @Override
  public void setQAEnv() throws InterruptedException {
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      //Actions.clickElementAndroid(driver, hideInAppMessagesToogle);
      Actions.sendKeysAndroid(driver, urlInput, "qa");
      Actions.clickElementAndroid(driver, okButton);
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, backButton);
      Actions.clickElementAndroid(driver, backButton);
      Actions.sleep(2000);
  }

  @Override
  public void login(Boolean qa, String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    if (qa) {
      boolean errorIsPresent = Actions.isElementPresent(driver, notLoginNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      Actions.clickElementAndroid(driver, leftButton);
      Actions.clickElementAndroid(driver, rightButton);
      //Actions.clickElementAndroid(driver, hideInAppMessagesToogle);
      Actions.sendKeysAndroid(driver, urlInput, "qa");
      Actions.clickElementAndroid(driver, okButton);
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, backButton);
      Actions.clickElementAndroid(driver, backButton);
      Actions.sleep(3000);
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.sendKeysAndroid(driver, loginEmailInput, email);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sendKeysAndroid(driver, loginPasswordInput, password);
      Actions.clickElementAndroid(driver, loginButton);
      if (password=="Muk" || email=="test@email.com") {
        Assert.assertEquals("The username/email and password you have entered do not match.", invalidLoginPswMsg.getText());}
      Actions.sleep(2000);
    } else {
      boolean errorIsPresent = Actions.isElementPresent(driver, notLoginNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.sendKeysAndroid(driver, loginEmailInput, email);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sendKeysAndroid(driver, loginPasswordInput, password);
      Actions.clickElementAndroid(driver, loginButton);
      Actions.sleep(2000);
    }
  }

  @Override
  public void loginAgain(String email, String password) throws InterruptedException {
      boolean errorIsPresent = Actions.isElementPresent(driver, notLoginNowButton);
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, notNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.sendKeysAndroid(driver, loginEmailInput, email);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sendKeysAndroid(driver, loginPasswordInput, password);
      Actions.clickElementAndroid(driver, loginButton);
      Actions.sleep(2000);
    }

    @Override
  public void loginAgainFail(String email, String password) throws InterruptedException {
      boolean errorIsPresent = Actions.isElementPresent(driver, notLoginNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, notNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.sendKeysAndroid(driver, loginEmailInput, email);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.sendKeysAndroid(driver, loginPasswordInput, password);
      Actions.clickElementAndroid(driver, loginButton);
      Assert.assertEquals("The username/email and password you have entered do not match.", invalidLoginPswMsg.getText());
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, okButton);
      Actions.clickElementAndroid(driver, backButton);
      Actions.clickElementAndroid(driver, backButton);
      Actions.sleep(2000);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
      Actions.clickElementAndroid(driver, notNowButton);
      Actions.clickElementAndroid(driver, backButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      }
    }

    @Override
  public void forgotPassword(String email) throws InterruptedException {
      Actions.clickElementAndroid(driver, statementPageButton);
      Actions.clickElementAndroid(driver, alreadyStatementButton);
      Actions.sendKeysAndroid(driver, loginEmailInput, email);
      Actions.clickElementAndroid(driver, continueButton);
      Actions.clickElementAndroid(driver, forgotPswButton);
      Actions.clickElementAndroid(driver, sendButton);
      Assert.assertEquals("Email Sent", emailSentLabel.getText());
      Actions.clickElementAndroid(driver, okButton);
      Actions.sleep(2000);
    }
  

  @Override
  public void createStatement(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.clickElementAndroid(driver, alreadyStatementButton);
    Actions.clickElementAndroid(driver, leftButton);
    Actions.clickElementAndroid(driver, rightButton);
    Actions.clickElementAndroid(driver, leftButton);
    Actions.clickElementAndroid(driver, rightButton);
    Actions.clickElementAndroid(driver, leftButton);
    Actions.clickElementAndroid(driver, rightButton);
    //Actions.clickElementAndroid(driver, hideInAppMessagesToogle);
    Actions.sendKeysAndroid(driver, urlInput, "qa");
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, createStatementButton);
    Actions.sendKeysAndroid(driver, loginEmailInput, email);
    Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, loginPasswordInput, password);
    Actions.clickElementAndroid(driver, signUpButton);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(2000);
  }


  @Override
  public void createStatementInvalidPsw(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    setQAEnv();
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.clickElementAndroid(driver, createStatementButton);
    Actions.sendKeysAndroid(driver, loginEmailInput, email);
    Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, loginPasswordInput, password);
    Actions.clickElementAndroid(driver, signUpButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, invalidPasswordLabel);
    Actions.sleep(2000);
  }


  @Override
  public void loginBlank(String email) throws InterruptedException {
    skipIntro("Allow once");
    setQAEnv();
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.clickElementAndroid(driver, createStatementButton);
    Actions.sendKeysAndroid(driver, loginEmailInput, email);
    Actions.clickElementAndroid(driver, continueButton);
    Assert.assertEquals("Email or username can not be blank", emailBlank.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(2000);
  }


  @Override
  public void loginSpaces(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    //setQAEnv();
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.clickElementAndroid(driver, createStatementButton);
    Actions.sendKeysAndroid(driver, loginEmailInput, email);
    Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, loginPasswordInput, password);
    Actions.clickElementAndroid(driver, signUpButton);
    Assert.assertEquals("Invalid Entry", invalidEntry.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(2000);
  }


  @Override
  public void revealPassword(String email, String password) throws InterruptedException {
    skipIntro("Allow once");
    //setQAEnv();
    Actions.clickElementAndroid(driver, statementPageButton);
    Actions.clickElementAndroid(driver, createStatementButton);
    Actions.sendKeysAndroid(driver, loginEmailInput, email);
    Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, loginPasswordInput, password);
    Actions.clickElementAndroid(driver, iconShowPassword);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, iconShowPassword);
    Actions.sleep(2000);
  }
    @Override
  public void setMoneyBagBalance() throws InterruptedException{
        if (Actions.isElementPresent(driver, spotInput)){
    Actions.sendKeysAndroid(driver, spotInput, "companysecret1");
    Actions.sleep(2000);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sendKeysDropdownAndroid(driver, setMoneyBagBalanceInput, "23");
    ((AndroidDriver) driver).hideKeyboard();
    Actions.clickElementAndroid(driver, setMoneyBagBalanceButton);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Actions.clearKeysAndroid(driver, spotInput);
    Actions.sleep(2000);
    }
  }

}
