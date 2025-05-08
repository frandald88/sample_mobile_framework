package ios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import page_interfaces.Proximate;
import utils.Actions;

public class ProximatePageIOS implements Proximate {

  /*
   * 
   * EXAMPLE IOS PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  IOSDriver driver;

  // DECLARE CONSTRUCTOR
  public ProximatePageIOS(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (IOSDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"spotTxtFld\"]")
    private IOSElement spotsInput;

  @iOSXCUITFindBy(xpath = "//*[@name='Search']")
  private IOSElement searchButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
  private IOSElement backButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Consulting Automation Cafe']")
  private IOSElement searchConsulting;

  @iOSXCUITFindBy(xpath = "//*[@name='Sorry, no results were found using the search criteria. Please try editing the fields above.']")
  private IOSElement searchConsultingEmpty;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"proximateLocationsTableManager\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
  private IOSElement firstSpotSearchButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Recent\"]")
  private IOSElement recentButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Proximate\"]")
  private IOSElement proximateButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Favorites\"]")
  private IOSElement favoritesButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"locationTxtFld\"]")
  private IOSElement allSpotsSearchBar;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Shelbyville, MI 49344\"])[1]")
  private IOSElement zipCode;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Sorry, no results were found using the search criteria. Please try editing the fields above.\"]")
  private IOSElement spotNotFound;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
  private IOSElement cancelButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign in to have your recently visited spots stored for faster selection.\"]")
  private IOSElement recentSignInLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign in to mark your preferred spots as \u201cFavorites\u201d for faster selection.\"]")
  private IOSElement favoritesSignInLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Not Now']")
  private IOSElement notNowButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")
  private IOSElement validationError;

  
  @Override
  public void searchLocation(Boolean qa, String location) throws InterruptedException {
  if (qa) {
    Actions.sendKeysIOS(driver, spotsInput, location);
      //Actions.clickElementIOS(driver, searchButton);
      Actions.sleep(3000);
      //Actions.clickElementIOS(driver, searchConsulting);
      Assert.assertEquals("Consulting Automation Cafe", searchConsulting.getText());
  }  else {
    Actions.sendKeysIOS(driver, spotsInput, location);
      Actions.sleep(3000);
      Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", searchConsultingEmpty.getText());
    }
  }


  @Override
  public void searchLocationWCharacters() throws InterruptedException {
      Actions.sendKeysIOS(driver, spotsInput, "####");
      Actions.sleep(3000);
      Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", searchConsultingEmpty.getText());
  }
  

  @Override
  public void searchLocationbyZipcode() throws InterruptedException {
    Actions.sendKeysIOS(driver, allSpotsSearchBar, "49344");
    //Actions.clickElementIOS(driver, searchButton);
    Actions.sleep(3000);
    Assert.assertTrue(zipCode.getText().contains("49344"));
  }

  
  @Override
  public void selectTestLocation(String location) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotsInput, location);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
  }


  @Override
  public void searchInvalidSpotCurrentLocation(String location) throws InterruptedException {
    Actions.sendKeysIOS(driver, allSpotsSearchBar, location);
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", spotNotFound.getText());
  }


  @Override
  public void searchInvalidSpotAllSpots(String location) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotsInput, location);
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", spotNotFound.getText());
  }


  @Override
  public void recentSpots() throws InterruptedException {
    Actions.clickElementIOS(driver, recentButton);
    Assert.assertEquals("Consulting Automation Cafe", searchConsulting.getText());
  }


  @Override
  public void recentTabasGuest() throws InterruptedException {
    Actions.clickElementIOS(driver, recentButton);
    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
    
    Assert.assertEquals("Sign in to have your recently visited spots stored for faster selection.", recentSignInLabel.getText());
  }


    @Override
  public void favoritesTabasGuest() throws InterruptedException {
    Actions.clickElementIOS(driver, favoritesButton);
    if (driver.findElements(By.xpath("//*[@name='Cancel']")).size() > 0)
       {Actions.clickElementIOS(driver, cancelButton);
        System.out.println("Appered and clicked!");}
    
    Assert.assertEquals("Sign in to mark your preferred spots as \u201cFavorites\u201d for faster selection.", favoritesSignInLabel.getText());
  }
}