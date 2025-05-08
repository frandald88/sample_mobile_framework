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
import page_interfaces.AddTicket;
import utils.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.MobileElement;
import java.util.List;
import java.util.ArrayList;

public class AddTicketPageIOS implements AddTicket {

  /*
   * 
   * EXAMPLE IOS PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  IOSDriver driver;

  // DECLARE CONSTRUCTOR
  public AddTicketPageIOS(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (IOSDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='addcash']")
  private IOSElement addCashButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Select Payment Method']")
  private IOSElement selectPaymentMethod;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Token or Debit Ticket']")
  private IOSElement addTokenOrDebit;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Ticket Number']")
  private IOSElement ticketNumberTxtField;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Expiration Date']")
  private IOSElement expDateTxtField;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Security Code']")
  private IOSElement securityCodeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Postal Code']")
  private IOSElement postalCodeInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add Ticket']")
  private IOSElement addTicketButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Default Payment Method']")
  private IOSElement defaultPaymentAdded;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[not(contains(@name, '$')) and string-length(@name) = 4]")
  private IOSElement ticketInUse;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Change') and @value='Change']")
  private IOSElement changeDefault;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Change') and @value='Change']")
  private IOSElement changeButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name, 'Edit') and @name='Edit'])[2]")
  private IOSElement editSavedPaymentMethod;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Delete')]")
  private IOSElement confirmDelete;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
  private IOSElement doneEditing;

  @iOSXCUITFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
  private IOSElement backButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
  private IOSElement backButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
  private IOSElement doneAddingTicketNumber;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Cancel'])[2]")
  private IOSElement cancelAddingTicketNumber;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
  private IOSElement cancelSelectingPaymentMethod;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
  private IOSElement ccNextButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Ticket not accepted']")
  private IOSElement ticketNotAcceptedMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please review your information and try again.']")
  private IOSElement reviewInformationError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
  private IOSElement okButtonAtError;

  

  

  @Override
  public void checkIfTicketAvailableAndAdd() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  boolean isPresent = Actions.isElementPresent(driver, defaultPaymentAdded);

  if (isPresent) {
        Actions.clickElementIOS(driver, backButton);
    } else {
    Actions.clickElementIOS(driver, addCashButton);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);   
    String tokenTicketNumbers = "6514828282823178";
    String lastFourDigits = tokenTicketNumbers.substring(tokenTicketNumbers.length() - 4);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
    Actions.clickElementIOS(driver, addTicketButton); 
    }
  }

  @Override
  public void checkAndAddAdditonalTicket() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  boolean isPresentInDefault = Actions.isElementPresent(driver, defaultPaymentAdded);
  String defaultTicket = ticketInUse.getText();
  String tokenTicketNumbers = "6514828282823178";
  String lastFourDigits = tokenTicketNumbers.substring(tokenTicketNumbers.length() - 4);

  if (isPresentInDefault) {
    System.out.println("There is a ticket present");
        if (defaultTicket.equals(lastFourDigits)) {
          System.out.println("8210 Ticket is present and selected");
          Actions.sleep(3000);
          Actions.clickElementIOS(driver, changeDefault);
          Actions.clickElementIOS(driver, editSavedPaymentMethod);
          String deleteTicketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits + "') and @visible='true']";
          IOSElement deleteTicketInUse = (IOSElement) driver.findElement(By.xpath(deleteTicketInUseXpath));
          Actions.clickElementIOS(driver, deleteTicketInUse);
          Actions.sleep(3000);
          Actions.tapElement(confirmDelete);
          Actions.sleep(3000);
          Actions.clickElementIOS(driver, doneEditing);
          Actions.clickElementIOS(driver, addTokenOrDebit);
          Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
          Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
          Actions.sendKeysIOS(driver, securityCodeInput, "654");
          Actions.sendKeysIOS(driver, postalCodeInput, "02459");
          Actions.clickElementIOS(driver, addTicketButton); 
          
            
        }
        else if (!defaultTicket.equals(lastFourDigits)){
          System.out.println("8210 ticket is available but not selected");
            Actions.clickElementIOS(driver, changeDefault);
            boolean isPresentInSaved = Actions.isElementPresent(driver, defaultPaymentAdded);
            if(defaultTicket.equals(lastFourDigits)){
             String selectSavedTicketXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits + "') and @visible='true']";
             IOSElement selectSavedTicket = (IOSElement) driver.findElement(By.xpath(selectSavedTicketXpath));
              Actions.clickElementIOS(driver, selectSavedTicket);

            }else {
          System.out.println("8210 Ticket is not present and needs to be added");
          Actions.clickElementIOS(driver, addTokenOrDebit);
          Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
          Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
          Actions.sendKeysIOS(driver, securityCodeInput, "654");
          Actions.sendKeysIOS(driver, postalCodeInput, "02459");
          Actions.clickElementIOS(driver, addTicketButton); 

            }

        }
        Actions.clickElementIOS(driver, backButton2);
    } else if (!isPresentInDefault){
    System.out.println("There is no ticket present");
    Actions.clickElementIOS(driver, addCashButton);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);   
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
    Actions.clickElementIOS(driver, addTicketButton); 
    }
  }

  @Override
  public void tokenTicketLessNumbers() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "5200";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.clickElementIOS(driver, doneAddingTicketNumber);
    if (!Actions.isElementPresent(driver, addTicketButton)){
      System.out.println("Ticket with less than 16 numbers wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.clickElementIOS(driver, doneAddingTicketNumber);
    if (!Actions.isElementPresent(driver, addTicketButton)){
      System.out.println("Ticket with less than 16 numbers wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }

   @Override
  public void tokenTicketInvalidExpDate() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "6514828282823178";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/20");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
        if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "13/29");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "00/30");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/20");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
   if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "13/29");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "00/30");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid exp date wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }

     @Override
  public void tokenTicketInvalidCCV() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "6514828282823178";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "1");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
        if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid CCV wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "1");
    Actions.sendKeysIOS(driver, postalCodeInput, "02459");
        if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid CCV wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }
  @Override
  public void tokenTicketInvalidNumbers() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "1234123412341234";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.clickElementIOS(driver, doneAddingTicketNumber);
    Actions.clickElementIOS(driver, ccNextButton);
    Assert.assertEquals("Ticket not accepted", ticketNotAcceptedMsg.getText());
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid number wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.clickElementIOS(driver, doneAddingTicketNumber);
    Actions.clickElementIOS(driver, ccNextButton);
    Assert.assertEquals("Ticket not accepted", ticketNotAcceptedMsg.getText());
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Ticket with invalid number wont enable add ticket button");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }

   @Override
  public void tokenTicketInvalidZipCode() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "6514828282823178";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "!#$%&");
    Actions.clickElementIOS(driver, addTicketButton);
    Actions.sleep(2000);
    Assert.assertEquals("Please review your information and try again.", reviewInformationError.getText());
    Actions.clickElementIOS(driver, okButtonAtError);
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    Actions.sendKeysIOS(driver, postalCodeInput, "!#$%&");
    Actions.clickElementIOS(driver, addTicketButton);
    Actions.sleep(2000);
    Assert.assertEquals("Please review your information and try again.", reviewInformationError.getText());
    Actions.clickElementIOS(driver, okButtonAtError);
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }

     @Override
  public void tokenTicketButtonSaveDisabled() throws InterruptedException {
  Actions.clickElementIOS(driver, addCashButton);
  String tokenTicketNumbers = "6514828282823178";
  if (Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("default payment is present adding another ticket");
    Actions.clickElementIOS(driver, changeDefault);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber); 
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  } else if(!Actions.isElementPresent(driver, defaultPaymentAdded)){
    System.out.println("No default payment is present adding ticket");
    Actions.clickElementIOS(driver, selectPaymentMethod);
    Actions.clickElementIOS(driver, addTokenOrDebit);
    Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers);
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.sendKeysIOS(driver, securityCodeInput, "654");
    if (Actions.iOSButtonNotEnabled(driver, addTicketButton)){
      System.out.println("Add ticket button not enabled yet");
    }
    Actions.clickElementIOS(driver, cancelAddingTicketNumber);
    Actions.clickElementIOS(driver, cancelSelectingPaymentMethod);
    Actions.clickElementIOS(driver, backButton2);
  }
  
  }

@Override
public void switchSavedTickets() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);
    boolean isPresentInDefault = Actions.isElementPresent(driver, defaultPaymentAdded);
    String defaultTicket = ticketInUse.getText();
    String tokenTicketNumbers1 = "6514828282823178";
    String lastFourDigits = tokenTicketNumbers1.substring(tokenTicketNumbers1.length() - 4);
    String tokenTicketNumbers2 = "4012888888881881";
    String lastFourDigits2 = tokenTicketNumbers2.substring(tokenTicketNumbers2.length() - 4);

    if (!isPresentInDefault) {
        System.out.println("There is no ticket present");
        Actions.sleep(3000);
        Actions.clickElementIOS(driver, selectPaymentMethod);
        Actions.clickElementIOS(driver, addTokenOrDebit);
        Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers1);
        Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
        Actions.sendKeysIOS(driver, securityCodeInput, "654");
        Actions.sendKeysIOS(driver, postalCodeInput, "02459");
        Actions.clickElementIOS(driver, addTicketButton);
        Actions.sleep(3000);
        Actions.clickElementIOS(driver, changeDefault);
        Actions.clickElementIOS(driver, addTokenOrDebit);
        Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers2);
        Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
        Actions.sendKeysIOS(driver, securityCodeInput, "654");
        Actions.sendKeysIOS(driver, postalCodeInput, "02459");
        Actions.clickElementIOS(driver, addTicketButton);
        Actions.sleep(3000);

        if (defaultTicket.equals(lastFourDigits)) {
            String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits2 + "') and @visible='true']";
            Actions.clickElementIOS(driver, changeDefault);
            Actions.sleep(3000);
            IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
            Actions.clickElementIOS(driver, element);
        } else {
            String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits + "') and @visible='true']";
            Actions.clickElementIOS(driver, changeDefault);
            Actions.sleep(3000);
            IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
            Actions.clickElementIOS(driver, element);
        }
        Actions.clickElementIOS(driver, backButton2);
    } else if (isPresentInDefault){
        System.out.println("There is a ticket present");
        if (defaultTicket.equals(lastFourDigits)) {
            Actions.clickElementIOS(driver, changeDefault);
            Actions.sleep(3000);
            IOSElement cell = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]"));
            List<MobileElement> mobileElements = cell.findElements(By.xpath(".//XCUIElementTypeButton"));
            List<IOSElement> buttons = new ArrayList<>();
            for (MobileElement mobileElement : mobileElements) {
               buttons.add((IOSElement) mobileElement);
              }

            if (buttons.size() > 1) {
            for (IOSElement button : buttons) {
            String buttonName = button.getAttribute("name");
            if (buttonName.contains(lastFourDigits) || buttonName.contains(lastFourDigits2)) {
            System.out.println("Ticket found: " + buttonName);
            Actions.clickElementIOS(driver, button);  // Correctly typed call
            break;  // Break after clicking the correct button
              }
            } 
            Actions.clickElementIOS(driver, backButton2);
            }else {
              Actions.clickElementIOS(driver, addTokenOrDebit);
            Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers2);
            Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
            Actions.sendKeysIOS(driver, securityCodeInput, "654");
            Actions.sendKeysIOS(driver, postalCodeInput, "02459");
            Actions.clickElementIOS(driver, addTicketButton);
            Actions.sleep(3000);

            }
            

            /*if (defaultTicket.equals(lastFourDigits)) {
                String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits2 + "') and @visible='true']";
                Actions.clickElementIOS(driver, changeDefault);
                Actions.sleep(3000);
                IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
                Actions.clickElementIOS(driver, element);
            } else {
                String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits + "') and @visible='true']";
                Actions.clickElementIOS(driver, changeDefault);
                Actions.sleep(3000);
                IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
                Actions.clickElementIOS(driver, element);*/
            //Actions.clickElementIOS(driver, backButton2);
            }
         else {
            Actions.clickElementIOS(driver, changeDefault);
            Actions.sleep(3000);
            IOSElement cell = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]"));
            List<MobileElement> mobileElements = cell.findElements(By.xpath(".//XCUIElementTypeButton"));
            List<IOSElement> buttons = new ArrayList<>();
            for (MobileElement mobileElement : mobileElements) {
               buttons.add((IOSElement) mobileElement);
              }

            if (buttons.size() > 1) {
            for (IOSElement button : buttons) {
            String buttonName = button.getAttribute("name");
            if (buttonName.contains(lastFourDigits) || buttonName.contains(lastFourDigits)) {
            System.out.println("Ticket found: " + buttonName);
            Actions.clickElementIOS(driver, button);  // Correctly typed call
            break;  // Break after clicking the correct button
              }
            } 
            Actions.clickElementIOS(driver, backButton2);
            } else {
              Actions.clickElementIOS(driver, addTokenOrDebit);
            Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers1);
            Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
            Actions.sendKeysIOS(driver, securityCodeInput, "654");
            Actions.sendKeysIOS(driver, postalCodeInput, "02459");
            Actions.clickElementIOS(driver, addTicketButton);
            Actions.sleep(3000);
            Actions.clickElementIOS(driver, changeDefault);
            Actions.clickElementIOS(driver, addTokenOrDebit);
            Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers2);
            Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
            Actions.sendKeysIOS(driver, securityCodeInput, "654");
            Actions.sendKeysIOS(driver, postalCodeInput, "02459");
            Actions.clickElementIOS(driver, addTicketButton);
            Actions.sleep(3000);

            }
            /*Actions.clickElementIOS(driver, addTokenOrDebit);
            Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers1);
            Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
            Actions.sendKeysIOS(driver, securityCodeInput, "654");
            Actions.sendKeysIOS(driver, postalCodeInput, "02459");
            Actions.clickElementIOS(driver, addTicketButton);
            Actions.sleep(3000);
            Actions.clickElementIOS(driver, changeDefault);
            Actions.clickElementIOS(driver, addTokenOrDebit);
            Actions.sendKeysIOS(driver, ticketNumberTxtField, tokenTicketNumbers2);
            Actions.sendKeysIOS(driver, expDateTxtField, "10/25");
            Actions.sendKeysIOS(driver, securityCodeInput, "654");
            Actions.sendKeysIOS(driver, postalCodeInput, "02459");
            Actions.clickElementIOS(driver, addTicketButton);
            Actions.sleep(3000);

            if (defaultTicket.equals(lastFourDigits)) {
                String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits2 + "') and @visible='true']";
                Actions.clickElementIOS(driver, changeDefault);
                Actions.sleep(3000);
                IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
                Actions.clickElementIOS(driver, element);
            } else {
                String ticketInUseXpath = "//XCUIElementTypeButton[contains(@name, '" + lastFourDigits + "') and @visible='true']";
                Actions.clickElementIOS(driver, changeDefault);
                Actions.sleep(3000);
                IOSElement element = (IOSElement) driver.findElement(By.xpath(ticketInUseXpath));
                Actions.clickElementIOS(driver, element);
            }*/
        }
        
    }
    
  }
}