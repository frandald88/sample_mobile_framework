package ios.pages;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import page_interfaces.Statement;
import utils.Actions;

public class StatementPageIOS implements Statement {

  /*
   * 
   * EXAMPLE IOS PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  IOSDriver driver;

  // DECLARE CONSTRUCTOR
  public StatementPageIOS(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (IOSDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @iOSXCUITFindBy(xpath = "//*[@name='Settings']")
  private IOSElement settingsButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
  private IOSElement backButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"_TtGC7SwiftUI19UIHosting\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
  private IOSElement backButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton")
  private IOSElement backButton3;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Back'])[2]")
  private IOSElement backButtonWorkaround;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"statement\"]")
  private IOSElement statementButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Sign Out']")
  private IOSElement signOutButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
  private IOSElement continueButton;  
  
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"purchase.confirmationSwitch\"]")
  private IOSElement confirmPurcheaseToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"statement\"]")
  private IOSElement statementButtonTwo;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Transaction History\"]")
  private IOSElement transactionHistory;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"$6.00\"])[1]")
  private IOSElement transaction6Dollar;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"$24.00\"])[1]")
  private IOSElement transaction24Dollar;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"$12.00\"])[1]")
  private IOSElement transaction12Dollar;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Enter Sandman\"])[1]")
  private IOSElement transactionTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More\"])[1]")
  private IOSElement transactionTrackMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manage Statement\"]")
  private IOSElement manageStatement;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User Profile\"]")
  private IOSElement userProfile;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Password\"]")
  private IOSElement password;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Delete Statement\"]")
  private IOSElement deleteStatement;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"emailTxt\"]")
  private IOSElement editEmail;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
  private IOSElement saveButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"saveBtn\"]")
  private IOSElement saveButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"passwordTxtFld\"]")
  private IOSElement confirmEditMail;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email Updated\"]")
  private IOSElement emailUpdatedConfirmation;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
  private IOSElement cancelButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Cancel\"])[2]")
  private IOSElement cancelButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
  private IOSElement cancelButton3;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Cancel\"])[2]")
  private IOSElement cancelButton4;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
  private IOSElement doneButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ok\"]")
  private IOSElement okButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
  private IOSElement okButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"usernameTxt\"]")
  private IOSElement editUsername;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Password\"]")
  private IOSElement passwordMenu;

  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"currentPasswordTxt\"]")
  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"currentPasswordTxt\"]")
  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"currentPasswordTxt\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPANYChangePasswordViewController\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]")
  
  private IOSElement currentPassword;

  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"newPasswordTxt\"]")
  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"newPasswordTxt\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPANYChangePasswordViewController\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]")
  private IOSElement newPassword;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPANYChangePasswordViewController\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSwitch")
  private IOSElement showPasswordToogle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm Changes\"]")
  private IOSElement confirmNewPassword;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
  private IOSElement confirmButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your New Password must be between 4 and 20 characters.\"]")
  private IOSElement invalidPassword;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Play Track with Priority\"]")
  private IOSElement transactionTrackMenuPlayTrackWPriority;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Play Track\"]")
  private IOSElement transactionTrackMenuPlayTrack;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add to My Tracks\"]")
  private IOSElement transactionTrackMenuAddtoMyTracks;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add to a Tracklist ...\"]")
  private IOSElement transactionTrackMenuAddtoaTracklist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"playmusic\"]")
  private IOSElement allMusicTab;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"tracklists\"]")
  private IOSElement myMusicTab;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"line1\"]")
  private IOSElement myMusicFirstTrackButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Remove from My Tracks']")
  private IOSElement removeFromMyTracksButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"New Tracklist\"]")
  private IOSElement newTracklistButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tracklist Name\"]")
  private IOSElement tracklistInput;

  //@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"line1\"])[2]")
  //MyTracklist
  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[2]")                      
  private IOSElement transactionHistoryFirstTracklist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm\"]")
  private IOSElement confirmButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
  private IOSElement okButton3;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Status: Playing\"]")
  private IOSElement transactionHistoryPlayingTrackStatusPlaying;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Status: Played\"])[1]")
  private IOSElement transactionHistoryPlayingTrackStatusPlayed;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Status: Queued\"])[1]")
  private IOSElement transactionHistoryPlayingTrackStatusQueued;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refer a Friend\"]")
  private IOSElement referAFriendButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refer Friends & Earn Tokens\"]")
  private IOSElement referAFriendLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Share\"]")
  private IOSElement referAFriendShareLink;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[contains(@name, 'COMPANY')]//XCUIElementTypeScrollView//XCUIElementTypeImage[2]")
  private IOSElement qrCode;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='New']")
  private IOSElement referAFriendNewTabButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pending']")
  private IOSElement referAFriendPendingTabButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Successful']")
  private IOSElement referAFriendSuccessfulTabButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Help (v.')]")
  private IOSElement helpMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '1.0.')]")
  private IOSElement helpAppVersion;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms of Service\"]")
  private IOSElement termsOfServiceMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '1.0.')]")
  private IOSElement termsOfServiceVersion;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Policy\"]")
  private IOSElement privacyPolicyMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '1.0.')]")
  private IOSElement privacyPolicyVersion;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Settings. \"]")
  private IOSElement settingMenuTitle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dark Mode\"]")
  private IOSElement darkModeLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm Purchase\"]")
  private IOSElement confirmPurchaseLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Auto-Reload Failure\"]")
  private IOSElement autoReloadFailureLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Available Cash/Tokens\"]")
  private IOSElement availableCashTokensLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location Welcome\"]")
  private IOSElement locationWelcomeLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Purchase Recash\"]")
  private IOSElement purchaseRefoundLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refer-A-Friend Referred\"]")
  private IOSElement referAFriendReferredLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refer-A-Friend Referrer\"]")
  private IOSElement referAFriendReferrerLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"themeSwitch\"]")
  private IOSElement darkModeToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='purchase.confirmationSwitch']")
  private IOSElement confirmPurchaseToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='player.autoReload.failedSwitch']")
  private IOSElement autoReloadFailureToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"player.location.moneybag.balanceSwitch\"]")
  private IOSElement availableCashTokensToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"player.location.welcomeSwitch\"]")
  private IOSElement locationWelcomeToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"player.purchase.recashSwitch\"]")
  private IOSElement purchaseRefoundToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='player.friendreferral.award.referredSwitch']")
  private IOSElement referAFriendReferredToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='player.friendreferral.award.referrerSwitch']")
  private IOSElement referAFriendReferrerToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign in now to start playing your favorite tunes at spots with music powered by COMPANY Entertainment.\"]")
  private IOSElement loginMessageLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Redeem Promo Code\"]")
  private IOSElement redeemPromoCodeMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='tap here']")
  private IOSElement redeemPromoCodeTapHereLink;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Promo Code\"]")
  private IOSElement redeemPromoCodeEnterCodeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Submit\"]")
  private IOSElement redeemPromoCodeSubmit;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorry, the promotion you are trying to redeem is no longer valid.\"]")
  private IOSElement redeemPromoCodeInvalidPromotionError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorry, the promotion you are trying to redeem is no longer valid.\"]")
  private IOSElement redeemPromoCodeEmptyPromotionError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
  private IOSElement redeemPromoCodeOkButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"navSubtitle\"]")
  private IOSElement chooseASpotLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Consulting Automation Cafe\"]")
  private IOSElement redeemPromoCodeSpot;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Auto Reload']")
  private IOSElement autoReload;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch[@value='1' or @value='0'])[2]")
  private IOSElement autoreloadSwitcher;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name, '$') and contains(@name, '.') and contains(@name, '(USD)')]")
  private IOSElement currentTokenBalance;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='$24']")
  private IOSElement twentyfourTokensRadioButton;


  @Override
  public void logout() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, signOutButton);
    Actions.clickElementIOS(driver, continueButton);
    Actions.sleep(3000);
  }

  @Override
  public void darkMode() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, darkModeToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, darkModeToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuConfirmPurchaseToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, confirmPurchaseToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, confirmPurchaseToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuPurchaseRecashToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, purchaseRefoundToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, purchaseRefoundToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuAutoReloadFailureToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, autoReloadFailureToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, autoReloadFailureToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuAvailableCashTokensToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, availableCashTokensToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, availableCashTokensToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuLocationWelcomeToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, locationWelcomeToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, locationWelcomeToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferrerToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, referAFriendReferrerToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, referAFriendReferrerToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferredToggle() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, referAFriendReferredToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, referAFriendReferredToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void help() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, helpMenu);
    Actions.sleep(2500);
    Assert.assertEquals(".0.80", helpAppVersion.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void termsOfService() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, termsOfServiceMenu);
    Actions.sleep(2500);
    Assert.assertEquals(".0.80", termsOfServiceVersion.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void privacyPolicy() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, privacyPolicyMenu);
    Actions.sleep(1000);
    Assert.assertEquals(".0.80", privacyPolicyVersion.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriend() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    Assert.assertEquals("Refer Friends & Earn Tokens", referAFriendLabel.getText());
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenu() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Settings. ", settingMenuTitle.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuDarkMode() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Dark Mode", darkModeLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuConfirmPurchase() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Confirm Purchase", confirmPurchaseLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuPurchaseRecash() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Purchase Recash", purchaseRefoundLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuAutoReloadFailure() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Auto-Reload Failure", autoReloadFailureLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuAvailableCashTokens() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Available Cash/Tokens", availableCashTokensLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuLocationWelcome() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Location Welcome", locationWelcomeLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferrer() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Refer-A-Friend Referrer", referAFriendReferrerLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void settingsMenuReferAFriendReferred() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Assert.assertEquals("Refer-A-Friend Referred", referAFriendReferredLabel.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriendShareLink() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    Assert.assertEquals("Share", referAFriendShareLink.getText());
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriendQRCodeGenerated() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    //Actions.clickElementIOS(driver, qrCode);
    //Assert.assertTrue(qrCode.isDisplayed());
    qrCode.isDisplayed();
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriendNewTab() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    Actions.clickElementIOS(driver, referAFriendNewTabButton);
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriendPendingTab() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    Actions.clickElementIOS(driver, referAFriendPendingTabButton);
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void referAFriendSuccessfulTab() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, referAFriendButton);
    Actions.clickElementIOS(driver, referAFriendSuccessfulTabButton);
    Actions.clickElementIOS(driver, backButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void confirmPurchaseON() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, settingsButton);
    Actions.clickElementIOS(driver, confirmPurcheaseToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, confirmPurcheaseToggle);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddCashSixDollars() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$6.00", transaction6Dollar.getText());
    boolean backButtonDouble = Actions.isElementPresent(driver, backButtonWorkaround);
      if(backButtonDouble){
         Actions.clickElementIOS(driver, backButtonWorkaround);
         Actions.clickElementIOS(driver, backButtonWorkaround);
      }else{
        Actions.clickElementIOS(driver, backButton);
         Actions.clickElementIOS(driver, backButton);
      }
    
  }


  @Override
  public void transactionHistoryUpdateAddCash24Dollars() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$24.00", transaction24Dollar.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddCash12Dollars() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("$12.00", transaction12Dollar.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryUpdateAddTrack() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Enter Sandman", transactionTrack.getText());
    boolean backButtonDouble = Actions.isElementPresent(driver, backButtonWorkaround);
      if(backButtonDouble){
         Actions.clickElementIOS(driver, backButtonWorkaround);
         Actions.clickElementIOS(driver, backButtonWorkaround);
      }else{
        Actions.clickElementIOS(driver, backButton);
         Actions.clickElementIOS(driver, backButton);
      }
  }


  @Override
  public void transactionHistoryUpdateAddTrackMenu() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Assert.assertEquals("Enter Sandman", transactionTrack.getText());
    Assert.assertEquals("Play Track with Priority", transactionTrackMenuPlayTrackWPriority.getText());
    Assert.assertEquals("Play Track", transactionTrackMenuPlayTrack.getText());
    Assert.assertEquals("Add to My Tracks", transactionTrackMenuAddtoMyTracks.getText());
    Assert.assertEquals("Add to a Tracklist ...", transactionTrackMenuAddtoaTracklist.getText());
    Actions.clickElementIOS(driver, cancelButton);
    Actions.sleep(1000);
    boolean backButtonDouble = Actions.isElementPresent(driver, backButtonWorkaround);
      if(backButtonDouble){
         Actions.clickElementIOS(driver, backButtonWorkaround);
         Actions.clickElementIOS(driver, backButtonWorkaround);
      }else{
        Actions.clickElementIOS(driver, backButton);
         Actions.clickElementIOS(driver, backButton);
      }
  }


  @Override
  public void transactionHistoryAddTracktoMyTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Assert.assertEquals("Add to My Tracks", transactionTrackMenuAddtoMyTracks.getText());
    Actions.clickElementIOS(driver, transactionTrackMenuAddtoMyTracks);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, myMusicTab);
    Actions.clickElementIOS(driver, myMusicFirstTrackButton);
    Actions.clickElementIOS(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
  }


  @Override
  public void transactionHistoryRemoveTracktoMyTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    Actions.clickElementIOS(driver, transactionTrackMenuAddtoMyTracks);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, myMusicTab);
    Actions.clickElementIOS(driver, myMusicFirstTrackButton);
    Assert.assertEquals("Remove from My Tracks", removeFromMyTracksButton.getText());
    Actions.clickElementIOS(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
  }


  @Override
  public void transactionHistoryAddTracktoMyTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuAddtoaTracklist);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist");
    //Actions.clickElementIOS(driver, saveButton2);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryAddTracktoExistingTracklist() throws InterruptedException {
    //Create tracklist before running this module
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuAddtoaTracklist);
    Actions.clickElementIOS(driver, transactionHistoryFirstTracklist);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackPriority() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuPlayTrackWPriority);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton3);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackPriorityCancel() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuPlayTrackWPriority);
    Actions.clickElementIOS(driver, cancelButton4);
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrackCancel() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuPlayTrack);
    Actions.clickElementIOS(driver, cancelButton4);
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayTrack() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, transactionTrackMenu);
    //Actions.sleep(2000);
    Actions.clickElementIOS(driver, transactionTrackMenuPlayTrack);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton3);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayingTrackStatusPlaying() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Status: Playing", transactionHistoryPlayingTrackStatusPlaying.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayingTrackStatusPlayed() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Status: Played", transactionHistoryPlayingTrackStatusPlayed.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void transactionHistoryPlayingTrackStatusQueued() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, transactionHistory);
    Actions.sleep(3000);
    Assert.assertEquals("Status: Queued", transactionHistoryPlayingTrackStatusQueued.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void ManageStatement() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Assert.assertEquals("User Profile", userProfile.getText());
    Assert.assertEquals("Password", password.getText());
    Assert.assertEquals("Delete Statement", deleteStatement.getText());
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void updateEmail(String password) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, userProfile);
    Actions.clearKeysIOS(driver, editEmail);
    Actions.sendKeysDropdownIOS(driver, editEmail, "newmailIOS@mail.com");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sendKeysDropdownIOS(driver, confirmEditMail, password);
    Actions.clickElementIOS(driver, doneButton);
    Actions.sleep(1000);
    Assert.assertEquals("Email Updated", emailUpdatedConfirmation.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void updateEmailCancel(String password) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, userProfile);
    Actions.clearKeysIOS(driver, editEmail);
    Actions.sendKeysDropdownIOS(driver, editEmail, "newmailIOS@mail.com");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sendKeysDropdownIOS(driver, confirmEditMail, password);
    Actions.clickElementIOS(driver, cancelButton2);
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void restoreEmail(String password) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, userProfile);
    Actions.clearKeysIOS(driver, editEmail);
    Actions.sendKeysDropdownIOS(driver, editEmail, "consulting-iOS@consultingteam.tester.com");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sendKeysDropdownIOS(driver, confirmEditMail, password);
    Actions.clickElementIOS(driver, doneButton);
    Actions.sleep(1000);
    Assert.assertEquals("Email Updated", emailUpdatedConfirmation.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changeUsername(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, userProfile);
    Actions.clearKeysIOS(driver, editUsername);
    Actions.sendKeysDropdownIOS(driver, editUsername, username);
    Actions.clickElementIOS(driver, saveButton);
    Actions.sendKeysDropdownIOS(driver, confirmEditMail, password);
    Actions.clickElementIOS(driver, doneButton);
    Actions.sleep(1000);
    Assert.assertEquals("Email Updated", emailUpdatedConfirmation.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePassword(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "newPassword");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void restorePassword(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "Consulting1234!");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePasswordCancel(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "newPassword");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, cancelButton2);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePasswordShowPassword(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "newPassword");
    Actions.clickElementIOS(driver, showPasswordToogle);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, showPasswordToogle);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePasswordBlank() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePasswordMore20(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.clickElementIOS(driver, showPasswordToogle);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "newPasswordExceedLenght");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Assert.assertEquals("Your New Password must be between 4 and 20 characters.", invalidPassword.getText());    
    //Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, okButton2);
    //Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void changePassword20(String password, String username) throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    Actions.clickElementIOS(driver, manageStatement);
    Actions.clickElementIOS(driver, passwordMenu);
    Actions.sendKeysDropdownIOS(driver, currentPassword, password);
    Actions.sendKeysDropdownIOS(driver, newPassword, "newPasswordMaxLenght");
    Actions.clickElementIOS(driver, saveButton);
    Actions.sleep(1000);
    Assert.assertEquals("Confirm Changes", confirmNewPassword.getText());
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void myStatementasGuest() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButton);
    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
    
    Assert.assertEquals("Sign in now to start playing your favorite tunes at spots with music powered by COMPANY Entertainment.", loginMessageLabel.getText());
  }


  @Override
  public void redeemTapHere() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, redeemPromoCodeMenu);
    Actions.clickElementIOS(driver, redeemPromoCodeTapHereLink);
    Actions.sleep(2000);
    Assert.assertEquals("Choose a spot", chooseASpotLabel.getText());
  }


  @Override
  public void redeemInvalidPromotion() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, redeemPromoCodeMenu);
    Actions.sendKeysDropdownIOS(driver, redeemPromoCodeEnterCodeInput, "invalid");
    Actions.clickElementIOS(driver, redeemPromoCodeSubmit);
    Assert.assertEquals("Sorry, the promotion you are trying to redeem is no longer valid.", redeemPromoCodeInvalidPromotionError.getText());
    Actions.clickElementIOS(driver, redeemPromoCodeOkButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void redeemEmptyPromotion() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, redeemPromoCodeMenu);
    Actions.clickElementIOS(driver, redeemPromoCodeSubmit);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void redeemPub() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, redeemPromoCodeMenu);
    Assert.assertEquals("Consulting Automation Cafe", redeemPromoCodeSpot.getText());
    //Actions.clickElementIOS(driver, redeemPromoCodeSubmit);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
  }

    @Override
    public void swtchOffAutoReload() throws InterruptedException {
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, autoReload);
    Actions.sleep(3000);
    if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size() > 0)
    {Actions.clickElementIOS(driver, okButton3);
    System.out.println("Appered and clicked!");}
		if(autoreloadSwitcher.getAttribute("value").equals("1"))
    {Actions.clickElementIOS(driver, autoreloadSwitcher);}//to turn it OFF
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, backButton3);
    Actions.clickElementIOS(driver, backButton);
   }

    @Override
    public void swtchOnAutoReload() throws InterruptedException {
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, statementButtonTwo);
    Actions.clickElementIOS(driver, autoReload);
    Actions.sleep(3000);
    if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size() > 0)
    {Actions.clickElementIOS(driver, okButton3);
    System.out.println("Appered and clicked!");}
		if(autoreloadSwitcher.getAttribute("value").equals("0"))
    {Actions.clickElementIOS(driver, autoreloadSwitcher);}//to turn it On
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, backButton3);
    Actions.clickElementIOS(driver, backButton);
   }
}