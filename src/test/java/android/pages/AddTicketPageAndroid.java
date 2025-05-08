package android.pages;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import page_interfaces.AddTicket;
import utils.Actions;

public class AddTicketPageAndroid implements AddTicket {

  /*
   * 
   * EXAMPLE ANDROID PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  AndroidDriver driver;

  // DECLARE CONSTRUCTOR
  public AddTicketPageAndroid(AppiumDriver driver) {
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

  @AndroidFindBy(xpath = "//*[@text='Settings']")
  private AndroidElement settingsButton;

  @AndroidFindBy(xpath = "//*[@text='Sign Out']")
  private AndroidElement signOutButton;

  @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
  private AndroidElement continueButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Switch")
  private AndroidElement darkModeToggle;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Back']")
  private AndroidElement backButton;

  @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Supported payment methods']/android.widget.RelativeLayout[2]")
  private AndroidElement addTokenTicket;

   @AndroidFindBy(xpath = "//*[@text='Add Cash']")
  private AndroidElement addCashButton;

  @AndroidFindBy(xpath = "//*[@text='Retry']")
  private AndroidElement retryButton;

  @AndroidFindBy(xpath = "//*[@text='Change']")
  private AndroidElement changePaymentMethod;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/bt_ticket_form_ticket_number']")
  private AndroidElement tokenTicketNumber;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/bt_button']")
  private AndroidElement nextButtonCC;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/bt_ticket_form_expiration']")
  private AndroidElement tokenTicketExpiration;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/bt_ticket_form_cvv']")
  private AndroidElement tokenTicketCvc;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/bt_ticket_form_postal_code']")
  private AndroidElement tokenTicketPostalCode;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/bt_button']")
  private AndroidElement saveTokenTicketButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/textinput_error']")
  private AndroidElement cvcErrorMsg;

  @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"All Music\"]/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement allMusicTab;

  @Override
  public void checkIfTicketAvailableAndAdd() throws InterruptedException {
    Actions.sleep(2000);
    //Actions.clickElementAndroid(driver, statementButton);
    Actions.clickOnCoordinatesAndroid(driver, 1006, 222); //Click on Statement for everybody
    Actions.clickElementAndroid(driver, signOutButton);
    Actions.clickElementAndroid(driver, continueButton);
    Actions.sleep(3000);
  }

  @Override
  public void checkAndAddAdditonalTicket() throws InterruptedException {
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
  public void tokenTicketLessNumbers() throws InterruptedException {
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
  public void tokenTicketInvalidExpDate() throws InterruptedException {
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
  public void tokenTicketInvalidCCV() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
        
    Actions.clickElementAndroid(driver, changePaymentMethod);
    Actions.clickElementAndroid(driver, addTokenTicket);
    Actions.sendKeysAndroid(driver, tokenTicketNumber, "6514828282823178");
     Actions.clickElementAndroid(driver, nextButtonCC);
     Actions.sendKeysAndroid(driver, tokenTicketExpiration, "10/25");
    Actions.sendKeysAndroid(driver, tokenTicketCvc, "1");
    Actions.sendKeysAndroid(driver, tokenTicketPostalCode, "02459");
    Actions.clickElementAndroid(driver, saveTokenTicketButton);
    Assert.assertEquals("CVC is invalid", cvcErrorMsg.getText());
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickOnCoordinatesAndroid(driver, 540, 992);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }

        @Override
  public void tokenTicketInvalidNumbers() throws InterruptedException {
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
  public void tokenTicketInvalidZipCode() throws InterruptedException {
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
     public void tokenTicketButtonSaveDisabled() throws InterruptedException {
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
     public void switchSavedTickets() throws InterruptedException {
    Actions.clickElementAndroid(driver, statementButton);
    Actions.clickElementAndroid(driver, settingsButton);
    Actions.clickElementAndroid(driver, darkModeToggle);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, darkModeToggle);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, backButton);
  }
}
