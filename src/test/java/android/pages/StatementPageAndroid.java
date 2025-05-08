package android.pages;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import page_interfaces.Statement;
import utils.Actions;

public class StatementPageAndroid implements Statement {

  /*
   * 
   * EXAMPLE ANDROID PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  AndroidDriver driver;

  // DECLARE CONSTRUCTOR
  public StatementPageAndroid(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (AndroidDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @AndroidFindBy(xpath = "//*[@text='OK']")
  private AndroidElement okButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
  private AndroidElement statementButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[2]")
  private AndroidElement statementButtonTwo;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_text' and @text='Settings']")
  private AndroidElement settingsButton;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
  private AndroidElement backButton;

  @AndroidFindBy(xpath = "//*[@text='Sign Out']")
  private AndroidElement signOutButton;

  @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
  private AndroidElement continueButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Switch")
  private AndroidElement confirmPurcheaseToggle;
  
  @AndroidFindBy(xpath = "//*[@text='Transaction History']")
  private AndroidElement transactionHistory;

  @AndroidFindBy(xpath = "//*[@text='$6.00 added to statement']")
  private AndroidElement transaction6Dollar;

  @AndroidFindBy(xpath = "//*[@text='$24.00 added to statement']")
  private AndroidElement transaction24Dollar;

  @AndroidFindBy(xpath = "//*[@text='$12.00 added to statement']")
  private AndroidElement transaction12Dollar;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_text' and @text='Manage Statement']")
  private AndroidElement manageStatement;

  @AndroidFindBy(xpath = "//*[@text='User Profile']")
  private AndroidElement userProfile;

  @AndroidFindBy(xpath = "//*[@text='Password']")
  private AndroidElement password;

  @AndroidFindBy(xpath = "//*[@text='Delete Statement']")
  private AndroidElement deleteStatement;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[1]")
  private AndroidElement editEmail;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/button_save']")
  private AndroidElement saveButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
  private AndroidElement confirmEditMail;

  @AndroidFindBy(xpath = "//*[@text='E-mail Updated']")
  ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView
  private AndroidElement emailUpdatedConfirmation;

  @AndroidFindBy(xpath = "//*[@text='CANCEL']")
  private AndroidElement cancelButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText")
  private AndroidElement editUsername;

  @AndroidFindBy(xpath = "//*[@text='Password']")
  private AndroidElement passwordMenu;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText")
  private AndroidElement currentPassword;
  
  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText")
  private AndroidElement newPassword;

  @AndroidFindBy(xpath = "//*[@text='Confirm Changes']")
  private AndroidElement confirmNewPassword;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
  private AndroidElement confirmButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Switch")
  private AndroidElement showPasswordToogle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement invalidEntry;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[4]")
  private AndroidElement transactionTrack;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/iv_more']")
  private AndroidElement transactionTrackMenu;

  @AndroidFindBy(xpath = "//*[@text='Play Track with Priority']")
  private AndroidElement transactionTrackMenuPlayTrackWPriority;

  @AndroidFindBy(xpath = "//*[@text='Play Track']")
  private AndroidElement transactionTrackMenuPlayTrack;

  @AndroidFindBy(xpath = "//*[@text='Add to My Tracks']")
  private AndroidElement transactionTrackMenuAddtoMyTracks;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/tv_add_tracklist']")
  private AndroidElement transactionTrackMenuAddtoaTracklist;

  @AndroidFindBy(xpath = "//*[@text='My Music']")
  private AndroidElement myMusicTab;

  @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"All Music\"]/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement allMusicTab;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]")
  private AndroidElement myMusicFirstTrackButton;

  @AndroidFindBy(xpath = "//*[@text='Remove from My Tracks']")
  private AndroidElement removeFromMyTracksButton;

  @AndroidFindBy(xpath = "//*[@text='New Tracklist']")
  private AndroidElement newTracklistButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
  private AndroidElement tracklistInput;

  @AndroidFindBy(xpath = "//*[@text='SAVE']")
  private AndroidElement saveButton2;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement transactionHistoryFirstTracklist;

  @AndroidFindBy(xpath = "//*[@text='CONFIRM']")
  private AndroidElement confirmButton2;

  @AndroidFindBy(xpath = "//*[@text='Status: Playing']")
  private AndroidElement transactionHistoryPlayingTrackStatusPlaying;

  @AndroidFindBy(xpath = "//*[@text='Status: Played']")
  private AndroidElement transactionHistoryPlayingTrackStatusPlayed;

  @AndroidFindBy(xpath = "//*[@text='Status: Queued']")
  private AndroidElement transactionHistoryPlayingTrackStatusQueued;

  @AndroidFindBy(xpath = "//*[@text='Refer A Friend']")
  private AndroidElement referAFriendButton;
  
  @AndroidFindBy(xpath = "//*[@text='Refer Friends & Earn Tokens']")
  private AndroidElement referAFriendLabel;

  @AndroidFindBy(xpath = "//*[@text='Share With Friends']")
  private AndroidElement referAFriendShareLink;

  @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"qr code\"]")
  private AndroidElement qrCode;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View")
  private AndroidElement referAFriendNewTabButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView")
  private AndroidElement referAFriendPendingTabButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View")
  private AndroidElement referAFriendSuccessfulTabButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_text' and contains(@text, 'Help (v')]")
  private AndroidElement helpMenu;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement helpTitle;

  @AndroidFindBy(xpath = "//*[@text='Terms of Service']")
  private AndroidElement termsOfServiceMenu;

  @AndroidFindBy(xpath = "//*[@text='Terms of Service']")
  private AndroidElement termsOfServiceTitle;

  @AndroidFindBy(xpath = "//*[@text='Privacy Policy']")
  private AndroidElement privacyPolicyMenu;

  @AndroidFindBy(xpath = "//*[@text='Privacy Policy']")
  private AndroidElement privacyPolicyTitle;

  @AndroidFindBy(xpath = "//*[@text='Settings']")
  private AndroidElement settingMenuTitle;
  
  @AndroidFindBy(xpath = "//*[@text='Dark Mode']")
  private AndroidElement darkModeLabel;

  @AndroidFindBy(xpath = "//*[@text='Confirm Purchases']")
  private AndroidElement confirmPurchaseLabel;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
  private AndroidElement autoReloadFailureLabel;

  @AndroidFindBy(xpath = "//*[@text='Available Cash/Tokens']")
  private AndroidElement availableCashTokensLabel;

  @AndroidFindBy(xpath = "//*[@text='Location Welcome']")
  private AndroidElement locationWelcomeLabel;

  @AndroidFindBy(xpath = "//*[@text='Purchase Recash']")
  private AndroidElement purchaseRefoundLabel;

  @AndroidFindBy(xpath = "//*[@text='Refer-A-Friend Referred']")
  private AndroidElement referAFriendReferredLabel;

  @AndroidFindBy(xpath = "//*[@text='Refer-A-Friend Referrer']")
  private AndroidElement referAFriendReferrerLabel;

  @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='com.company.COMPANYSmartBar:id/switch_view'])[1]")
  private AndroidElement darkModeToggle;

  @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='com.company.COMPANYSmartBar:id/switch_view'])[2]")
  private AndroidElement confirmPurchaseToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.Switch")
  private AndroidElement autoReloadFailureToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.Switch")
  private AndroidElement availableCashTokensToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Switch")
  private AndroidElement locationWelcomeToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Switch")
  private AndroidElement purchaseRefoundToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.Switch")
  private AndroidElement referAFriendReferredToggle;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.Switch")
  private AndroidElement referAFriendReferrerToggle;

  @AndroidFindBy(xpath = "//*[@text='Log in and play music on a proximate COMPANY jukebox. Add tokens and make selections without even leaving your seat.']")
  private AndroidElement loginMessageLabel;

  @AndroidFindBy(xpath = "//*[@text='Redeem Promo Code']")
  private AndroidElement redeemPromoCodeMenu;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/tv_redeem_promo_wrong_location']")
  private AndroidElement redeemPromoCodeTapHereLink;

  @AndroidFindBy(xpath = "//*[@text='Choose a spot']")
  private AndroidElement chooseASpotLabel;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text']")
  private AndroidElement redeemPromoCodeEnterCodeInput;

  @AndroidFindBy(xpath = "//*[@text='Submit']")
  private AndroidElement redeemPromoCodeSubmit;

  @AndroidFindBy(xpath = "//*[@text='Sorry, this promotion is invalid']")
  private AndroidElement redeemPromoCodeInvalidPromotionError;

  @AndroidFindBy(xpath = "//*[@text='Code can not be blank']")
  private AndroidElement redeemPromoCodeEmptyPromotionError;

  @AndroidFindBy(xpath = "//*[@text='OK']")
  private AndroidElement redeemPromoCodeOkButton;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/tv_redeem_promo_location_text']")
  private AndroidElement redeemPromoCodeSpot;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_text' and @text='Auto Reload']")
  private AndroidElement autoReload;

  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[4]/android.view.View[1]")
  private AndroidElement autoReloadSwitch;

  @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.view.View[1]")
  private AndroidElement autoReloadSwitch2;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/alertTitle']")
  private AndroidElement logAlert;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
  private AndroidElement cancelLogAlert;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/btn_cancel']")
  private AndroidElement notLoginNowButton;

  @Override
  public void logout() throws InterruptedException {
    Actions.sleep(2000);
    //Actions.clickElementAndroid(driver, statementButton);
    Actions.clickOnCoordinatesAndroid(driver, 1006, 222); //Click on Statement for everybody
    boolean errorIsPresent = Actions.isElementPresent(driver, notLoginNowButton);
      if (errorIsPresent)
      {Actions.clickElementAndroid(driver, notLoginNowButton);
      System.out.println("Appered and clicked!");
      Actions.sleep(1000);
      Actions.clickElementAndroid(driver, backButton);
      }else{
        Actions.clickElementAndroid(driver, signOutButton);
        Actions.clickElementAndroid(driver, continueButton);
        Actions.sleep(3000);
      }

  }

  @Override
  public void darkMode() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, darkModeToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, darkModeToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuConfirmPurchaseToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, confirmPurchaseToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, confirmPurchaseToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuPurchaseRecashToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, purchaseRefoundToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, purchaseRefoundToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuAutoReloadFailureToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, autoReloadFailureToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, autoReloadFailureToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuAvailableCashTokensToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, availableCashTokensToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, availableCashTokensToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuLocationWelcomeToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, locationWelcomeToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, locationWelcomeToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferrerToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, referAFriendReferrerToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, referAFriendReferrerToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferredToggle() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, referAFriendReferredToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, referAFriendReferredToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void help() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, helpMenu);
    String helpTitleText = helpTitle.getText();
    //Assert.assertEquals("Help (v4.15.0.8944)", helpTitle.getText());
    Assert.assertTrue("Help title text does not contain the expected prefix.", helpTitleText.startsWith("Help (v4"));
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void termsOfService() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, termsOfServiceMenu);
    Assert.assertEquals("Terms of Service", termsOfServiceTitle.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void privacyPolicy() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, privacyPolicyMenu);
    Assert.assertEquals("Privacy Policy", privacyPolicyTitle.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriend() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    Assert.assertEquals("Refer Friends & Earn Tokens", referAFriendLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenu() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Settings", settingMenuTitle.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuDarkMode() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Dark Mode", darkModeLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuConfirmPurchase() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Confirm Purchases", confirmPurchaseLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuPurchaseRecash() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Purchase Recash", purchaseRefoundLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuLocationWelcome() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Location Welcome", locationWelcomeLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuAvailableCashTokens() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Available Cash/Tokens", availableCashTokensLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuAutoReloadFailure() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Auto-Reload Failure", autoReloadFailureLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferrer() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Refer-A-Friend Referrer", referAFriendReferrerLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferred() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Assert.assertEquals("Refer-A-Friend Referred", referAFriendReferredLabel.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriendShareLink() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    Assert.assertEquals("Share With Friends", referAFriendShareLink.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriendQRCodeGenerated() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    qrCode.isDisplayed();
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriendNewTab() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    Actions.clickElementAndroid(driver, referAFriendNewTabButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriendPendingTab() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    Actions.clickElementAndroid(driver, referAFriendPendingTabButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void referAFriendSuccessfulTab() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, referAFriendButton);
    Actions.clickElementAndroid(driver, referAFriendSuccessfulTabButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void confirmPurchaseON() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, confirmPurcheaseToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, confirmPurcheaseToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddCashSixDollars() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$6.00 added to statement", transaction6Dollar.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddCash24Dollars() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$24.00 added to statement", transaction24Dollar.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddCash12Dollars() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$12.00 added to statement", transaction12Dollar.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddTrack() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Enter Sandman", transactionTrack.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddTrackMenu() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    Assert.assertEquals("Play Track with Priority", transactionTrackMenuPlayTrackWPriority.getText());
    Assert.assertEquals("Play Track", transactionTrackMenuPlayTrack.getText());
    Assert.assertEquals("Add to My Tracks", transactionTrackMenuAddtoMyTracks.getText());
    Actions.clickElementAndroid(driver, transactionTrackMenuAddtoaTracklist);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryAddTracktoMyTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    Actions.sleep(3000);
    Assert.assertEquals("Add to My Tracks", transactionTrackMenuAddtoMyTracks.getText());
    Actions.clickElementAndroid(driver, transactionTrackMenuAddtoMyTracks);
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, myMusicTab);
    Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
    Actions.clickElementAndroid(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void transactionHistoryRemoveTracktoMyTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    Actions.clickElementAndroid(driver, transactionTrackMenuAddtoMyTracks);
    Actions.sleep(2000);
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, myMusicTab);
    Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
    Assert.assertEquals("Remove from My Tracks", removeFromMyTracksButton.getText());
    Actions.clickElementAndroid(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void transactionHistoryAddTracktoMyTracklist() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuAddtoaTracklist);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput, "MyTracklist");
    Actions.clickElementAndroid(driver, saveButton2);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryAddTracktoExistingTracklist() throws InterruptedException {
    //Create tracklist before running this module
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuAddtoaTracklist);
    Actions.clickElementAndroid(driver, transactionHistoryFirstTracklist);
    //Actions.clickElementAndroid(driver, saveButton2);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackPriority() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuPlayTrackWPriority);
    Actions.clickElementAndroid(driver, confirmButton2);
    Actions.sleep(6000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackPriorityCancel() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuPlayTrackWPriority);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackCancel() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuPlayTrack);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrack() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementAndroid(driver, transactionTrackMenuPlayTrack);
    Actions.clickElementAndroid(driver, confirmButton2);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayingTrackStatusPlaying() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Status: Playing", transactionHistoryPlayingTrackStatusPlaying.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


@Override
public void transactionHistoryPlayingTrackStatusPlayed() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);

    boolean statusFound = false;
    int maxScrolls = 5;
    int scrollCount = 0;

    while (!statusFound && scrollCount < maxScrolls) {
      try {
        
        String statusText = transactionHistoryPlayingTrackStatusPlayed.getText();
        System.out.println("Status text found: " + statusText);
        Assert.assertEquals("Status: Played", statusText);
        statusFound = true;  
          } catch (Exception e) {
        
        System.out.println("Status not found, scrolling down. Attempt: " + (scrollCount + 1));
        scrollCount++;
        
        
        Actions.scrollDownAndroid(driver);
        Actions.sleep(3000);  
        }
    }

    
      if (!statusFound) {
        throw new AssertionError("Status: Played not found after " + maxScrolls + " scroll attempts.");
      }

      Actions.clickElementAndroid(driver, backButton);
      Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayingTrackStatusQueued() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Status: Queued", transactionHistoryPlayingTrackStatusQueued.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void ManageStatement() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Assert.assertEquals("User Profile", userProfile.getText());
    Assert.assertEquals("Password", password.getText());
    Assert.assertEquals("Delete Statement", deleteStatement.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void updateEmail(String password) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, userProfile);
    Actions.clearKeysAndroid(driver, editEmail);
    Actions.sendKeysAndroid(driver, editEmail, "newmailAndroid@mail.com");
    Actions.clickElementAndroid(driver, saveButton);
    confirmEditMail.sendKeys(password);
    //Actions.sendKeysAndroid(driver, confirmEditMail, password);
    //confirmation dialog is closed before pressing OK button
    Actions.clickElementAndroid(driver, okButton);
    Assert.assertEquals("E-mail Updated", emailUpdatedConfirmation.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void updateEmailCancel(String password) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, userProfile);
    Actions.clearKeysAndroid(driver, editEmail);
    Actions.sendKeysAndroid(driver, editEmail, "newmailAndroid@mail.com");
    Actions.clickElementAndroid(driver, saveButton);
    Actions.sendKeysAndroid(driver, confirmEditMail, password);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void restoreEmail(String password) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, userProfile);
    Actions.clearKeysAndroid(driver, editEmail);
    Actions.sendKeysAndroid(driver, editEmail, "consulting-Android@consultingteam.tester.com");
    Actions.clickElementAndroid(driver, saveButton);
    confirmEditMail.sendKeys(password);
    //Actions.sendKeysAndroid(driver, confirmEditMail, password);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Assert.assertEquals("E-mail Updated", emailUpdatedConfirmation.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void changeUsername(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, userProfile);
    Actions.clearKeysAndroid(driver, editUsername);
    Actions.sendKeysAndroid(driver, editUsername, username);
    Actions.clickElementAndroid(driver, saveButton);
    confirmEditMail.sendKeys(password);
    //Actions.sendKeysAndroid(driver, confirmEditMail, password);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Assert.assertEquals("E-mail Updated", emailUpdatedConfirmation.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void changePassword(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "newPassword");
    Actions.clickElementAndroid(driver, saveButton);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(1000);
    boolean errorIsPresent = Actions.isElementPresent(driver, logAlert);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, cancelLogAlert);
     System.out.println("Appered and clicked!");
     } else {
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
     }
  }


  @Override
  public void restorePassword(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "Consulting1234!");
    Actions.clickElementAndroid(driver, saveButton);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(1000);
    boolean errorIsPresent = Actions.isElementPresent(driver, logAlert);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, cancelLogAlert);
     System.out.println("Appered and clicked!");
     } else {
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
     }
  }


  @Override
  public void changePasswordCancel(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "newPassword");
    Actions.clickElementAndroid(driver, saveButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void changePasswordShowPassword(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "newPassword");
    Actions.clickElementAndroid(driver, showPasswordToogle);
    //Actions.clickElementAndroid(driver, saveButton);
    //Actions.sleep(1000);
    //Actions.clickElementAndroid(driver, cancelButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, showPasswordToogle);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void changePasswordBlank() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.clickElementAndroid(driver, saveButton);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(1000);
    Assert.assertEquals("Invalid Entry", invalidEntry.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }

  @Override
  public void changePasswordMore20(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "newPasswordExceedLenght");
    Actions.clickElementAndroid(driver, saveButton);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, confirmButton);
    boolean errorIsPresent = Actions.isElementPresent(driver, logAlert);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, cancelLogAlert);
     System.out.println("Appered and clicked!");
     } else {
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
     }
  }
  

  @Override
  public void changePassword20(String password, String username) throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, manageStatement);
    Actions.clickElementAndroid(driver, passwordMenu);
    Actions.sendKeysAndroid(driver, currentPassword, password);
    Actions.sendKeysAndroid(driver, newPassword, "newPasswordMaxLenght");
    Actions.clickElementAndroid(driver, saveButton);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(1000);
    boolean errorIsPresent = Actions.isElementPresent(driver, logAlert);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, cancelLogAlert);
     System.out.println("Appered and clicked!");
     } else {
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
     }
  }


  @Override
  public void myStatementasGuest() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Assert.assertEquals("Log in and play music on a proximate COMPANY jukebox. Add tokens and make selections without even leaving your seat.", loginMessageLabel.getText());
    }


    @Override
  public void redeemTapHere() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, redeemPromoCodeMenu);
    Actions.clickElementAndroid(driver, redeemPromoCodeTapHereLink);
    Assert.assertEquals("Choose a spot", chooseASpotLabel.getText());
    }


    @Override
  public void redeemInvalidPromotion() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, redeemPromoCodeMenu);
    Actions.sendKeysAndroid(driver, redeemPromoCodeEnterCodeInput, "invalid");
    Actions.clickElementAndroid(driver, redeemPromoCodeSubmit);
    Assert.assertEquals("Sorry, this promotion is invalid", redeemPromoCodeInvalidPromotionError.getText());
    Actions.clickElementAndroid(driver, redeemPromoCodeOkButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    }


    @Override
  public void redeemEmptyPromotion() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, redeemPromoCodeMenu);
    //Actions.sendKeysAndroid(driver, redeemPromoCodeEnterCodeInput, "invalid");
    Actions.clickElementAndroid(driver, redeemPromoCodeSubmit);
    Assert.assertEquals("Code can not be blank", redeemPromoCodeEmptyPromotionError.getText());
    Actions.clickElementAndroid(driver, redeemPromoCodeOkButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    }


    @Override
  public void redeemPub() throws InterruptedException {
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, redeemPromoCodeMenu);
    Assert.assertTrue(redeemPromoCodeSpot.getText().contains("Consulting Automation Cafe"));
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    }

    @Override
    public void swtchOffAutoReload() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, autoReload);

    if (Actions.isElementPresent(driver, autoReloadSwitch2)){
    if(autoReloadSwitch2.getAttribute("checked").equals("true"))
    {Actions.clickElementAndroid(driver, autoReloadSwitch2);}//to turn it OFF
    }
    else{
    if(autoReloadSwitch.getAttribute("checked").equals("true"))
    {Actions.clickElementAndroid(driver, autoReloadSwitch);}//to turn it OFF
    }
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    }

    @Override
    public void swtchOnAutoReload() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButtonTwo);
    Actions.clickElementAndroid(driver, autoReload);
    if (Actions.isElementPresent(driver, autoReloadSwitch2)){
    if(autoReloadSwitch2.getAttribute("checked").equals("false"))
    {Actions.clickElementAndroid(driver, autoReloadSwitch2);}//to turn it OFF
    }
    else{
    if(autoReloadSwitch.getAttribute("checked").equals("false"))
    {Actions.clickElementAndroid(driver, autoReloadSwitch);}//to turn it OFF
    }
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    }

}
