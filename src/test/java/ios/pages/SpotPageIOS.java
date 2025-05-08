package ios.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import page_interfaces.Spot;
import utils.Actions;
import static org.junit.Assert.assertTrue;
import java.util.List;
import io.appium.java_client.MobileElement;

public class SpotPageIOS implements Spot {

  /*
   * 
   * EXAMPLE IOS PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  IOSDriver driver;

  // DECLARE CONSTRUCTOR
  public SpotPageIOS(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (IOSDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @iOSXCUITFindBy(xpath = "//*[@name='']")
  private IOSElement testButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
  private IOSElement okButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
  private IOSElement okButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
  private IOSElement confirmButton;

  @iOSXCUITFindBy(xpath = "//*[@name='spotTxtFld']")
  private IOSElement spotInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='mediaSearch']")
  private IOSElement mediaSearchInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"proximateLocationsTableManager\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
  private IOSElement firstSpotButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[2]")
  private IOSElement viewAllArtirsButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement firstArtistButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement firstTrackNameButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Add to My Tracks']")
  private IOSElement addToMyTracksButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Remove from My Tracks']")
  private IOSElement removeFromMyTracksButton;

  @iOSXCUITFindBy(xpath = "//*[@label='My Music']")
  private IOSElement myMusicButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"line1\"]")
  private IOSElement myMusicFirstTrackButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"proximateLocationsTableManager\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
  private IOSElement firstSpotSearchButton;

  @iOSXCUITFindBy(xpath = "//*[contains(@name,'Add to a Tracklist')]")
  private IOSElement addToTracklistButton;

  @iOSXCUITFindBy(xpath = "//*[@name='New Tracklist']")
  private IOSElement newTracklistButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Tracklist Name']")
  private IOSElement tracklistInput;

  @iOSXCUITFindBy(xpath = "//*[@name='My Tracklists']")
  private IOSElement myTracklistTabButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'MyTracklist') and contains(@name, '0 tracks')][1]")
  private IOSElement myTracklistButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[3]")
  private IOSElement myTracklistButton2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"sort-btn\"]")
  private IOSElement editButton;

  @iOSXCUITFindBy(xpath = "//*[@name='deleteLbl']")
  private IOSElement deleteButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Continue']")
  private IOSElement continueButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
  private IOSElement continueButtonTwo;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement firstSearchResultButton;

  //@iOSXCUITFindBy(xpath = "//*[@name='Continue']")
  //private IOSElement firstArtistTrackButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Later\"]")
  private IOSElement laterButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Play Track with Priority']")
  private IOSElement playTrackPriorityButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Play Track']")
  private IOSElement playTrackButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[6]")
  private IOSElement firstSearchTrackButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='line1'])[1]")
  private IOSElement firstSearchTrackAsGuestButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[7]")
  private IOSElement secondSearchTrackButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[8]")
  private IOSElement thirdSearchTrackButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement viewAllFirstTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[2]")
  private IOSElement viewAllSecondTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[3]")
  private IOSElement viewAllThirdTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[4]")
  private IOSElement viewAllFourthTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[5]")
  private IOSElement viewAllFifthTrack;

  //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[8]")
  //private IOSElement thirdSearchTrackButton;

  //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[9]")
  //private IOSElement fourthSearchTrackButton;

  //@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[10]")
  //private IOSElement fifthSearchTrackButton;

  @iOSXCUITFindBy(xpath = "//*[@name='spotTxtFld']")
  private IOSElement spotsInput;

  @iOSXCUITFindBy(xpath = "//*[@name='Search']")
  private IOSElement searchButton;

  @iOSXCUITFindBy(xpath = "//*[@name='favoriteLocationBtn']")
  private IOSElement favoriteLocationBtn;
  
  @iOSXCUITFindBy(xpath = "//*[@name='Favorites']")
  private IOSElement favoritesButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"heart-on\"])[3]")
  private IOSElement favoritesTabHearOff;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
  //XCUIElementTypeButton[@name="Back"]
  private IOSElement backButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Payment Method']")
  private IOSElement paymentMethodButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Add New Token Ticket']")
  private IOSElement newCcButton;

  @iOSXCUITFindBy(xpath = "//*[@name='nameTxtFld']")
  private IOSElement ticketNameInput;

  @iOSXCUITFindBy(xpath = "//*[@name='ticketNumberTxtFld']")
  private IOSElement ticketNumberInput;

  @iOSXCUITFindBy(xpath = "//*[@name='expirationTxtFld']")
  private IOSElement ticketExpDateInput;

  @iOSXCUITFindBy(xpath = "//*[@name='cvcTxtFld']")
  private IOSElement ticketCCVInput;

  @iOSXCUITFindBy(xpath = "//*[@name='zipTxtFld']")
  private IOSElement ticketPostalCodeInput;

  @iOSXCUITFindBy(xpath = "//*[@name='Add']")
  private IOSElement addButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='addcash']")
  private IOSElement addCashButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPANYAddCashViewController\"]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeSwitch")
  private IOSElement reloadCashToggle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Return to music selection']")
  private IOSElement returnToMusicButton;

  @iOSXCUITFindBy(xpath = "//*[@name='Tracks Hot Here']")
  private IOSElement tracksHotHereLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confirm\"]")
  private IOSElement confirmButton2;

  @iOSXCUITFindBy(xpath = "//*[@name='Cancel']")
  private IOSElement cancelButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Cancel\"])[2]")
  private IOSElement cancelButton2;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Cancel\"])[2]")
  private IOSElement cancelButton3;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cancelBtn\"]") 
  private IOSElement cancelButton4;

  @iOSXCUITFindBy(xpath = "//*[@name='Cancel']")
  private IOSElement cancelButton5;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View Play Queue\"]")
  private IOSElement viewPlayQueue;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[2]")
  private IOSElement firstTrackQueued;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[3]")
  private IOSElement secondTrackQueued;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[4]")
  private IOSElement thirdTrackQueued;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[5]")
  private IOSElement fourthTrackQueued;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement firstArtistSection;
  
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rihanna\"]")
  private IOSElement artistTitle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"cashLbl\"]")
  private IOSElement tokens;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='$6']")
  private IOSElement sixTokensRadioButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='$24']")
  private IOSElement twentyfourTokensRadioButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='$12']")
  private IOSElement twelveTokensRadioButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add Cash']")
  private IOSElement addCashButtonTwo;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
  private IOSElement confirmButtonTwo;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaction Successful!']")
  private IOSElement addCashConfirmation;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"playmusic\"]")
  private IOSElement allMusicTab;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[1]")
  private IOSElement viewAllButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[2]")
  private IOSElement viewAllButtonTracks;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement anyTrackButton;

  @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeButton")
  private IOSElement neverButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Artist\"]")
  private IOSElement myTrackSortByArtist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Track Title\"]")
  private IOSElement myTrackSortByTrack;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Date Added\"]")
  private IOSElement myTrackSortByDate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Popularity\"]")
  private IOSElement myTrackSortByPopularity;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Artist\"]")
  private IOSElement tracklistSortByArtirst;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Track Title\"]")
  private IOSElement tracklistSortByTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sorted by Track Order\"])[2]")
  private IOSElement tracklistSortByTrackOrder;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorted by Popularity\"]")
  private IOSElement tracklistSortByPopularity;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='artistListView']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
  private IOSElement firstTracklistButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='playerTracklistTrackList']/XCUIElementTypeCell[2]")
  private IOSElement firstTracklistViewButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"multiSelectBtn\"]")
  private IOSElement myTracksMultiTrackSelection;  

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[2]")
  private IOSElement myTracksMultiTrackSelection2ndTrack;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement myTracksMultiTrackSelection1stTrack;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"playSelectedBtn\"]")
  private IOSElement myTracksPlaySelectedTracks;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Play Tracks with Priority\"]")
  private IOSElement myTracksPlayTracksWPriority;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"selectAllBtn\"]")
  private IOSElement myTracksSelectAllTracks;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please select at least one track.\"]")
  private IOSElement myTracksPlaySelectedTracksError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"renameLbl\"]")
  private IOSElement tracklistRename;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"tracklistTitleTxt\"]")
  private IOSElement tracklistRenameInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"saveBtn\"]")
  private IOSElement saveButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add a spot to your list of \u201cFavorites\u201d by tapping once on its heart icon. Tap it again to remove it.\"]")
  private IOSElement noFavoriteSpots;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"switchLocationBtn\"]")
  private IOSElement spotHomeName;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View More ...\"]")
  private IOSElement viewMoreButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"Empty list\"]/XCUIElementTypeTextView")
  private IOSElement emptyTracklistLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select your current spot.\"]")
  private IOSElement selectYourCurrentSpotLabel;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"locationActionsTable\"]/XCUIElementTypeCell[2]")
  private IOSElement spotDropDownListCurrentSpot;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='More']")
  private IOSElement nowPlayingMenu;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='View This Artist']")
  private IOSElement nowPlayingViewThisArtist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bjork']")
  private IOSElement viewThisArtist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View More ...\"]")
  private IOSElement viewMoewButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"arcade\"]")
  private IOSElement arcadeTab;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log In Required\"]")
  private IOSElement loginRequiredLabel;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[3]")
  private IOSElement viewAllAlbumsButton;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"line1\"])[1]")
  private IOSElement firstTrackFirstAlbum;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[1]")
  private IOSElement tracksHotHere;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View All\"])[2]")
  private IOSElement artistsHotHere;

  @iOSXCUITFindBy(xpath = "//*[@name='Got an statement? Log in']")
  private IOSElement alreadyStatementButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"Sorry, no results were found.  Please try another search.\"]")
  private IOSElement noTracknoArtistFound;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='paymentMethodBtn']")
  private IOSElement addCashPaymentMethodButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add New Token Ticket']")
  private IOSElement addCashAddTokenTicket;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='nameTxtFld']")
  private IOSElement addCashNameOnTokenTicket;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='ticketNumberTxtFld']")
  private IOSElement addCashTokenTicketNumber;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='expirationTxtFld']")
  private IOSElement addCashTokenTicketExpiration;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='cvcTxtFld']")
  private IOSElement addCashTokenTicketCvc;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='zipTxtFld']")
  private IOSElement addCashTokenTicketPostalCode;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='addBtn']")
  private IOSElement addCashAddButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
  private IOSElement okButton3;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name='tokenTicketBtn'])[2]")
  private IOSElement secondTokenTicket;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTable")
  private IOSElement tokenTicketTable;

  @iOSXCUITFindBy(xpath = " //XCUIElementTypeStaticText[@name='Your CVC must be between 2 and 4 characters.']")
  private IOSElement cvcErrorMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='The expiration date you have entered is not valid']")
  private IOSElement expDateErrorMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your Token Ticket Number must be between 13 and 16 characters.']")
  private IOSElement cticketLessNumbersErrorMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Save for Future Use']")
  private IOSElement saveForFutureSwitch;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='tokenTicketInfoLbl']")
  private IOSElement cTicketInUseMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTable")
  private IOSElement cTicketsSavedTable;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name='tokenTicketBtn'])[2]")
  private IOSElement secondTokenTicketAvailable;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Tokens:') and contains(@name, '| $') and contains(@name, '(USD)')]")
  private IOSElement currentTokenBalance;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=' The moneybag limit is $50.00, you cannot add cash at this time. ']")
  private IOSElement MoneyBagLimitErrorMsg;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value='0']")
  private IOSElement autoreloadSwitcher;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='addcash']")
  private IOSElement addCashMenuButton;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='No thanks, just add cash' and @visible='true']")
  private IOSElement autoReloadOptionalPopUp;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Default Payment Method']")
  private IOSElement defaultPaymentAdded;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='The tracklist title is too long! ']")
  private IOSElement tracklistTooLongError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
  private IOSElement cancelCreateTracklist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='saveBtn']")
  private IOSElement saveTracklist;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]")
  private IOSElement validationError;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Not Now']")
  private IOSElement notNowButton;


  int rateCounter=0;
  String autoreloadSwitch="1";
  String autoreloadSwitch12="1";
  String autoreloadSwitch24="1";
  

  @Override
  public void homePageUI() throws InterruptedException {
    Actions.clickElementIOS(driver, firstSpotButton);
    //Actions.clickElementIOS(driver, continueButton);
    Actions.clickElementIOS(driver, tracksHotHereLabel);
   // Actions.sleep(2000);
  }


  @Override
  public void homePageTabsUI() throws InterruptedException {
    Actions.sleep(2000);
    Assert.assertEquals("1", allMusicTab.getText());
    Assert.assertEquals("My Music", myMusicButton.getText());
    Assert.assertEquals("Add Cash", addCashButton.getText());
    //Assert.assertEquals("arcade", arcadeTab.getText());
  }


  @Override
  public void addTrack(String type) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotsInput, "Consulting");
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSpotButton);
    Actions.sleep(2000);
    // if (Actions.isElementDisplayedByXpath(driver,
    // "//XCUIElementTypeButton[@name=\"Later\"]")){
    // Actions.clickElementIOS(driver, laterButton);
    // }
    // else{
    // System.out.println("Continue");
    // }
    Actions.clickElementIOS(driver, viewAllArtirsButton);
    Actions.clickElementIOS(driver, firstArtistButton);
    Actions.clickElementIOS(driver, firstTrackNameButton);
    if (type == "myTracks") {
      Actions.clickElementIOS(driver, addToMyTracksButton);
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myMusicFirstTrackButton);
      Actions.clickElementIOS(driver, removeFromMyTracksButton);
    }
    if (type == "tracklist") {
      Actions.clickElementIOS(driver, addToTracklistButton);
      Actions.clickElementIOS(driver, newTracklistButton);
      Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist");
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistTabButton);
      Actions.clickElementIOS(driver, myTracklistButton2);
      Actions.clickElementIOS(driver, editButton);
      Actions.clickElementIOS(driver, deleteButton);
      Actions.clickElementIOS(driver, continueButtonTwo);
    }
    Actions.sleep(2000);
  }


  @Override
  public void addToTracklistFromTracklist() throws InterruptedException {
      Actions.sendKeysIOS(driver, spotsInput, "Consulting");
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, firstSpotButton);
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, viewAllArtirsButton);
      Actions.clickElementIOS(driver, firstArtistButton);
      Actions.clickElementIOS(driver, firstTrackNameButton);
      Actions.clickElementIOS(driver, addToTracklistButton);
      Actions.clickElementIOS(driver, newTracklistButton);
      Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist2");
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistButton2);
      Actions.clickElementIOS(driver, editButton);


      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistTabButton);
      Actions.clickElementIOS(driver, myTracklistButton);
      Actions.clickElementIOS(driver, editButton);
      Actions.clickElementIOS(driver, deleteButton);
      Actions.clickElementIOS(driver, continueButtonTwo);
      Actions.sleep(2000);
  }


  @Override
  public void createTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist");
    //Actions.clickElementIOS(driver, saveButton);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void emptyTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, myTracklistButton); 
    Actions.sleep(2000); 
    Assert.assertEquals("Add tracks to this tracklist by touching the \u201cAll Music\u201d tab and then tapping on available tracks.", emptyTracklistLabel.getText());
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


  @Override
  public void deleteTracklist() throws InterruptedException {
    Actions.sleep(2000);
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistTabButton);
      boolean tracklistpresent = Actions.isElementPresent(driver, myTracklistButton);
      if(tracklistpresent){
         Actions.clickElementIOS(driver, myTracklistButton);
      }else{
        Actions.tapElement(firstTracklistViewButton);
      }
      Actions.clickElementIOS(driver, editButton);
      Actions.clickElementIOS(driver, deleteButton);
      Actions.clickElementIOS(driver, continueButtonTwo);
      Actions.sleep(2000);
    }

      @Override
  public void deleteAllTracklist() throws InterruptedException {
    Actions.sleep(2000);
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistTabButton);
      while (Actions.isElementPresent(driver, firstTracklistViewButton)){
      Actions.tapElement(firstTracklistViewButton);
      Actions.clickElementIOS(driver, editButton);
      Actions.clickElementIOS(driver, deleteButton);
      Actions.clickElementIOS(driver, continueButtonTwo);
      Actions.sleep(2000);
      }
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void removeFirstMyTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myMusicFirstTrackButton);
    Actions.clickElementIOS(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }
    
    @Override
    public void removeAllMyTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);

    while (Actions.isElementPresent(driver, myMusicFirstTrackButton)){
      Actions.clickElementIOS(driver, myMusicFirstTrackButton);
      Actions.clickElementIOS(driver, removeFromMyTracksButton);
      Actions.sleep(2000);
    }
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByArtist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, myTrackSortByArtist);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByTrack() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, myTrackSortByTrack);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByDate() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, myTrackSortByTrack);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByPopularity() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, myTrackSortByPopularity);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackSelection() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(2000);
    for (int attempts = 0; attempts < 3; attempts++) {
    try {
        Actions.clickElementIOS(driver, myTracksMultiTrackSelection2ndTrack);
        break; // Success, exit the loop
    } catch (StaleElementReferenceException e) {
        System.out.println("Attempting to recover from StaleElementReferenceException ...");
        if (attempts == 2) throw e; // Rethrow the exception on the last attempt
        }
    }
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.clickElementIOS(driver, myTracksPlayTracksWPriority);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackAllTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.clickElementIOS(driver, myTracksPlayTracksWPriority);
    Actions.clickElementIOS(driver, okButton2);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackDeselectAllTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.sleep(2000);
    Assert.assertEquals("Please select at least one track.", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackSelectionNumbered() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.sleep(1000);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("1 tracks"));
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection1stTrack);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("2 tracks"));
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("3 tracks"));
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void tracklistSortByArtist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.tapElement(firstTracklistViewButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, tracklistSortByArtirst);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void tracklistSortByTrack() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.tapElement(firstTracklistViewButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, editButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, tracklistSortByTrack);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void tracklistSortByPopularity() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.tapElement(firstTracklistViewButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, tracklistSortByPopularity);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void tracklistSortByTrackOrder() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.sleep(1000);
    Actions.tapElement(firstTracklistViewButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, editButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, tracklistSortByTrackOrder);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void myMusicRenameTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.tapElement(firstTracklistViewButton);
    Actions.clickElementIOS(driver, editButton);
    Actions.clickElementIOS(driver, tracklistRename);
    Actions.sendKeysIOS(driver, tracklistRenameInput, "Renamed");
    //Actions.clickElementIOS(driver, saveButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void tracklistMultiTrackSelection() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.sleep(1000);
    Actions.tapElement(firstTracklistViewButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.clickElementIOS(driver, myTracksPlayTracksWPriority);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackDeselection() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.sleep(1000);
    Actions.tapElement(firstTracklistViewButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection1stTrack);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.sleep(2000);
    Assert.assertEquals("Please select at least one track.", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackAllTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.sleep(1000);
    Actions.tapElement(firstTracklistViewButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.clickElementIOS(driver, myTracksPlayTracksWPriority);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackDeselectAllTracks() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.tapElement(firstTracklistViewButton);
    Actions.clickElementIOS(driver, myTracksMultiTrackSelection);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, myTracksSelectAllTracks);
    Actions.clickElementIOS(driver, myTracksPlaySelectedTracks);
    Actions.sleep(2000);
    Assert.assertEquals("Please select at least one track.", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    }


  @Override
  public void searchTrack(String track, String location) throws InterruptedException {
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Assert.assertEquals("Enter Sandman", firstSearchTrackButton.getText());
    Actions.sleep(3000);
  }


  @Override
  public void searchTrackAsGuest(String track) throws InterruptedException {
    //Actions.clickElementIOS(driver, firstSpotSearchButton);
    //Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.sleep(2000);
    Assert.assertEquals("Enter Sandman", firstSearchTrackButton.getText());
    Actions.sleep(3000);
  }

  @Override
  public void playTrackPriorityNoTokens(String track) throws InterruptedException {
    //Actions.sleep(2000);
    //Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    //Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackPriorityButton);
    Actions.clickElementIOS(driver, cancelButton2);
    Actions.clickElementIOS(driver, cancelButton3);
    //if (tokens) {
    //  Actions.clickElementIOS(driver, confirmButton);
    //  Actions.sleep(2000);
    //  // Actions.clickOnCoordinatesIOS(driver, 256, 455);//Click on continue popup
    //  Actions.clickElementIOS(driver, okButton);
    //  Actions.sleep(2000);
    //  // Actions.clickOnCoordinatesIOS(driver, 194, 556); //Click on Done popup
    //  Actions.sleep(2000);
    //} else {
    //  Actions.sleep(3000);
    //}
  }

  @Override
  public void playTrackPriorityTokens(String track) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackPriorityButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, okButton2);
  }


  @Override
  public void playTrack(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    //Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
  }


  @Override
  public void playTrackAsGuest(String track) throws InterruptedException {
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstSearchTrackAsGuestButton);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton3);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestFromArtists_Album(String track) throws InterruptedException {
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstArtistSection);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestFromArtists_Tracks(String track) throws InterruptedException {
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, viewAllButtonTracks);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestFromAlbum_Track(String track) throws InterruptedException {
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.swipeOnCoordinates(driver, 170, 489, 183, 192);
    Actions.swipeOnCoordinates(driver, 170, 489, 183, 192);
    Actions.swipeOnCoordinates(driver, 170, 489, 183, 192);
    Actions.clickElementIOS(driver, viewAllAlbumsButton);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.clickElementIOS(driver, firstTrackFirstAlbum);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotTrack() throws InterruptedException {
    Actions.clickElementIOS(driver, tracksHotHere);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotArtists() throws InterruptedException {
    Actions.clickElementIOS(driver, artistsHotHere);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.clickElementIOS(driver, firstTrackFirstAlbum);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotArtistsAlbum_Track() throws InterruptedException {
    Actions.clickElementIOS(driver, artistsHotHere);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.clickElementIOS(driver, firstTrackFirstAlbum);
    Actions.sleep(2000);
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void guestNotAccessToMyMusic() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.sleep(2000);
    Assert.assertEquals("Got an statement? Log in", alreadyStatementButton.getText());    
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void guestNotAccessToAddCash() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);
    Actions.sleep(2000);
    Assert.assertEquals("Got an statement? Log in", alreadyStatementButton.getText());    
    Assert.assertEquals("Log In Required", loginRequiredLabel.getText());    
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void searchNonExistingArtistWSpecialCharacters(String artist) throws InterruptedException {
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, artist);
    Actions.sleep(2000);
    Assert.assertEquals("Sorry, no results were found.  Please try another search.", noTracknoArtistFound.getText());    
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  // @Override
  // public void playSameTrack(String track) throws InterruptedException {
  //   Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
  //   Actions.clearKeysIOS(driver, mediaSearchInput);
  //   Actions.sendKeysIOS(driver, mediaSearchInput, track);
  //   Actions.clickElementIOS(driver, firstSearchTrackButton);
  //   Actions.clickElementIOS(driver, playTrackButton);
  //   Actions.clickElementIOS(driver, confirmButton2);
  //   Actions.clickElementIOS(driver, okButton2);
  //   //Actions.clickElementIOS(driver, backButton);
  //   //Actions.clickElementIOS(driver, backButton);
  // }


  @Override
  public void playTrackFromSpotHomeScreen(String track) throws InterruptedException {
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesIOS(driver, 46, 219); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void Add3TracksToMyTracks(String track) throws InterruptedException {
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, addToMyTracksButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, secondSearchTrackButton);
    Actions.clickElementIOS(driver, addToMyTracksButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, thirdSearchTrackButton);
    Actions.clickElementIOS(driver, addToMyTracksButton);
    Actions.sleep(1000);
    Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void Add3TracksToTracklist(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, addToTracklistButton);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist");    
    Actions.clickElementIOS(driver, secondSearchTrackButton);
    Actions.clickElementIOS(driver, addToTracklistButton);
    Actions.tapElement(firstTracklistButton);    
    Actions.clickElementIOS(driver, thirdSearchTrackButton);
    Actions.clickElementIOS(driver, addToTracklistButton);
    Actions.tapElement(firstTracklistButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void play2Tracks(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, secondSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, viewPlayQueue);
    Actions.clickElementIOS(driver, firstTrackQueued);
    Actions.clickElementIOS(driver, cancelButton4);
    //Actions.clickElementIOS(driver, secondTrackQueued);
    //Actions.clickElementIOS(driver, cancelButton4);
  }


  @Override
  public void play5Tracks(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, track);
    Actions.clickElementIOS(driver, viewAllButtonTracks);
    Actions.clickElementIOS(driver, viewAllFirstTrack);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, viewAllSecondTrack);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, viewAllThirdTrack);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, viewAllFourthTrack);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, neverButton);
    Actions.clickElementIOS(driver, viewAllFifthTrack);
    Actions.clickElementIOS(driver, playTrackButton);
    Actions.clickElementIOS(driver, confirmButton2);
    Actions.clickElementIOS(driver, okButton2);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    //Actions.clickElementIOS(driver, backButton);
    //Actions.clickElementIOS(driver, backButton);
    Actions.clickElementIOS(driver, viewPlayQueue);
    Actions.clickElementIOS(driver, firstTrackQueued);
    Actions.clickElementIOS(driver, cancelButton4);
    Actions.clickElementIOS(driver, secondTrackQueued);
    Actions.clickElementIOS(driver, cancelButton4);
    Actions.clickElementIOS(driver, thirdTrackQueued);
    Actions.clickElementIOS(driver, cancelButton4);
    Actions.clickElementIOS(driver, fourthTrackQueued);
    Actions.clickElementIOS(driver, cancelButton4);
  }


  @Override
  public void viewArtist(String artirst) throws InterruptedException {
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, artirst);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstArtistSection);
    Actions.sleep(2000);
    Assert.assertEquals("Rihanna", artistTitle.getText()); 
  }
  

@Override
  public void removeTrack() throws InterruptedException {
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, viewAllArtirsButton);
    Actions.clickElementIOS(driver, firstArtistButton);
    Actions.clickElementIOS(driver, firstTrackNameButton);
    Actions.clickElementIOS(driver, addToMyTracksButton);
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myMusicFirstTrackButton);
    Actions.clickElementIOS(driver, removeFromMyTracksButton);
    }


  @Override
  public void favoriteSpot(Boolean logged) throws InterruptedException {
    if (logged) {
      //Actions.sendKeysIOS(driver, spotInput, spot);
      Actions.clickElementIOS(driver, favoriteLocationBtn);
      //Actions.clickElementIOS(driver, favoritesButton);
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, favoriteLocationBtn);
      Actions.clickElementIOS(driver, continueButtonTwo);
      Actions.sleep(2000);
    } else {
      //Actions.clickElementIOS(driver, backButton);
      //Actions.sendKeysIOS(driver, spotInput, spot);
      Actions.clickElementIOS(driver, favoriteLocationBtn);
      //Actions.clickElementIOS(driver, cancelButton);
      Actions.sleep(2000);
    }
  }


  @Override
  public void favoriteSpotListedinHome() throws InterruptedException {
      Actions.clickElementIOS(driver, favoriteLocationBtn);
      Actions.clickElementIOS(driver, firstSpotSearchButton);
      Actions.sleep(2000);
      Assert.assertTrue(spotHomeName.getText().contains("Consulting Automation Cafe"));
      Actions.clickElementIOS(driver, spotHomeName);
      Actions.clickElementIOS(driver, viewMoreButton);
      Actions.sleep(1000);
      Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, favoriteLocationBtn);
      Actions.clickElementIOS(driver, continueButtonTwo);
  }


  @Override
  public void spotsDropDownList() throws InterruptedException {
      Actions.clickElementIOS(driver, spotHomeName);
      Actions.sleep(2000);
      Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
      Actions.sleep(2000);
      //Actions.clickOnCoordinatesIOS(driver, 350,130);
      Actions.clickElementIOS(driver, spotDropDownListCurrentSpot);
  }


  @Override
  public void noFavorites() throws InterruptedException {
      Actions.clickElementIOS(driver, favoritesButton);
      Actions.sleep(2000);
      Assert.assertEquals("Add a spot to your list of \u201cFavorites\u201d by tapping once on its heart icon. Tap it again to remove it.", noFavoriteSpots.getText());
      //Assert.assertTrue(noFavoriteSpots.getText().contains("Add a spot to your list"));
    }


  @Override
  public void addCashTokenTicketSixDollars() throws InterruptedException {
    Actions.sleep(2000);

    if (Actions.isElementPresent(driver, spotInput)){
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    }

    boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    Actions.clickElementIOS(driver, addCashMenuButton);
    String tokensText = currentTokenBalance.getText();
    String numericPart = tokensText.replaceAll("[^0-9.]", "");
    String integerPart = numericPart.contains(".") ? numericPart.substring(0, numericPart.indexOf(".")) : numericPart;
    String lastTwoDigits = integerPart.length() >= 2 ? integerPart.substring(integerPart.length() - 2) : integerPart;
    int tokensInBalance = Integer.parseInt(lastTwoDigits);
    System.out.println(tokensInBalance);

     if (tokensInBalance < 43) {
      Actions.clickElementIOS(driver, sixTokensRadioButton);
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, addCashButtonTwo);
      if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
        {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
        System.out.println("Appered and clicked!");
        Actions.sleep(3000);
        }
        Actions.sleep(3000);
        Actions.clickElementIOS(driver, returnToMusicButton);

     }else{
     Actions.clickElementIOS(driver, allMusicTab);
     }
  }


  @Override
  public void addCashTokenTicket24Dollars() throws InterruptedException {
    Actions.sleep(2000);
    if (Actions.isElementPresent(driver, spotInput)){
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    }

    boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    Actions.clickElementIOS(driver, addCashMenuButton);
    String tokensText = currentTokenBalance.getText();
    String numericPart = tokensText.replaceAll("[^0-9.]", "");
    String integerPart = numericPart.contains(".") ? numericPart.substring(0, numericPart.indexOf(".")) : numericPart;
    String lastTwoDigits = integerPart.length() >= 2 ? integerPart.substring(integerPart.length() - 2) : integerPart;
    int tokensInBalance = Integer.parseInt(lastTwoDigits);
    System.out.println(tokensInBalance);

     if (tokensInBalance < 25) {
      Actions.clickElementIOS(driver, twentyfourTokensRadioButton);
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, addCashButtonTwo);
      if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
        {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
        System.out.println("Appered and clicked!");
        Actions.sleep(3000);
        }
        Actions.sleep(3000);
        Actions.clickElementIOS(driver, returnToMusicButton);

     }else{
     Actions.clickElementIOS(driver, allMusicTab);
     }
  }


  @Override
  public void addCashTokenTicket12Dollars() throws InterruptedException {
    Actions.sleep(2000);
    if (Actions.isElementPresent(driver, spotInput)){
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    }

    boolean errorIsPresent = Actions.isElementPresent(driver, validationError);
    if (errorIsPresent)
    {Actions.clickElementIOS(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    Actions.clickElementIOS(driver, addCashMenuButton);
    String tokensText = currentTokenBalance.getText();
    String numericPart = tokensText.replaceAll("[^0-9.]", "");
    String integerPart = numericPart.contains(".") ? numericPart.substring(0, numericPart.indexOf(".")) : numericPart;
    String lastTwoDigits = integerPart.length() >= 2 ? integerPart.substring(integerPart.length() - 2) : integerPart;
    int tokensInBalance = Integer.parseInt(lastTwoDigits);
    System.out.println(tokensInBalance);

     if (tokensInBalance < 37) {
      Actions.clickElementIOS(driver, twelveTokensRadioButton);
      Actions.sleep(2000);
      Actions.clickElementIOS(driver, addCashButtonTwo);
      if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
        {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
        System.out.println("Appered and clicked!");
        Actions.sleep(3000);
        }
        Actions.sleep(3000);
        Actions.clickElementIOS(driver, returnToMusicButton);
     }else{
     Actions.clickElementIOS(driver, allMusicTab);
     }
  }


  @Override
  public void addTokens(Boolean recharge) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(5000);
    Actions.clickOnCoordinatesIOS(driver, 74, 195); // Click on input
    Actions.sendKeysIOS(driver, mediaSearchInput, "Viva la vida");
    Actions.clickElementIOS(driver, firstSearchTrackButton);
    Actions.clickElementIOS(driver, playTrackPriorityButton);
    Actions.clickElementIOS(driver, paymentMethodButton);
    Actions.clickElementIOS(driver, newCcButton);
    Actions.sendKeysIOS(driver, ticketNameInput, "Juan Ramos");
    Actions.sendKeysIOS(driver, ticketNumberInput, "4242424242424242");
    Actions.sendKeysIOS(driver, ticketExpDateInput, "1026");
    Actions.sendKeysIOS(driver, ticketCCVInput, "123");
    Actions.sendKeysIOS(driver, ticketPostalCodeInput, "56756");
    Actions.clickElementIOS(driver, addButton);
    if (recharge) {
      Actions.clickElementIOS(driver, confirmButton);
      Actions.clickElementIOS(driver, okButton);
      Actions.sleep(2000);
    } else {
      Actions.sleep(3000);
    }
  }

  @Override
  public void autoReload(Boolean toggle) throws InterruptedException {
    Actions.sendKeysIOS(driver, spotInput, "Consultingtest");
    Actions.clickElementIOS(driver, firstSpotSearchButton);
    Actions.sleep(3000);
    Actions.clickElementIOS(driver, addCashButton);

    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, addCashButton);

    autoreloadSwitch=reloadCashToggle.getText();
    System.out.println("autoreload Switch value = " + autoreloadSwitch);
    if (autoreloadSwitch.equals("1"))
       {Actions.clickElementIOS(driver, reloadCashToggle);}//to turn it OFF

    //Actions.clickElementIOS(driver, reloadCashToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, reloadCashToggle);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, continueButtonTwo);
    Actions.clickElementIOS(driver, returnToMusicButton);
  }


  @Override
  public void tokensCleanUp() throws InterruptedException {
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, viewAllButton);
    Actions.clickElementIOS(driver, anyTrackButton);
    Actions.clickElementIOS(driver, playTrackPriorityButton);
    Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, addCashButton);

    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, addCashButton);
  }

  @Override
  public void tokensCleanUpRateDialog() throws InterruptedException {
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, viewAllButton);
    Actions.clickElementIOS(driver, anyTrackButton);
    Actions.clickElementIOS(driver, playTrackPriorityButton);
    Actions.clickElementIOS(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, neverButton);
    Actions.clickElementIOS(driver, addCashButton);

    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, addCashButton);
  }


  @Override
  public void NowPlayingAddTracktoTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, nowPlayingMenu);
    Actions.clickElementIOS(driver, addToTracklistButton);
      Actions.clickElementIOS(driver, newTracklistButton);
      Actions.sendKeysIOS(driver, tracklistInput, "MyTracklist");
      Actions.clickElementIOS(driver, myMusicButton);
      Actions.clickElementIOS(driver, myTracklistTabButton);
      Actions.tapElement(firstTracklistViewButton);
      Actions.clickElementIOS(driver, editButton);
      Actions.clickElementIOS(driver, deleteButton);
      Actions.clickElementIOS(driver, continueButtonTwo);
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void NowPlayingAddTracktoMyMusic() throws InterruptedException {
    Actions.clickElementIOS(driver, nowPlayingMenu);
    Actions.clickElementIOS(driver, addToMyTracksButton);
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myMusicFirstTrackButton);
    Actions.clickElementIOS(driver, removeFromMyTracksButton);
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void NowPlayingViewThisArtist() throws InterruptedException {
    Actions.clickElementIOS(driver, nowPlayingMenu);
    Actions.clickElementIOS(driver, nowPlayingViewThisArtist);
    Actions.sleep(2000);
    Assert.assertEquals("Bjork", viewThisArtist.getText());
    Actions.clickElementIOS(driver, allMusicTab);
  }


  @Override
  public void allMusicSelectSpot() throws InterruptedException {
    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, spotHomeName);
    Actions.sleep(2000);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    Actions.clickElementIOS(driver, viewMoewButton);
    Actions.sleep(2000);
    //Actions.clickElementIOS(driver, spotDropDownListCurrentSpot);
  }


  @Override
  public void myMusicSelectSpot() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, spotHomeName);
    Actions.sleep(2000);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    Actions.clickElementIOS(driver, viewMoewButton);
    Actions.sleep(2000);
    //Actions.clickElementIOS(driver, spotDropDownListCurrentSpot);
  }


  @Override
  public void myMusicTracklistSelectSpot() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, spotHomeName);
    Actions.sleep(2000);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    Actions.clickElementIOS(driver, viewMoewButton);
    Actions.sleep(2000);
    //Actions.clickElementIOS(driver, spotDropDownListCurrentSpot);
  }


  @Override
  public void addCashSelectSpot() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);

    Actions.clickElementIOS(driver, allMusicTab);
    Actions.clickElementIOS(driver, spotHomeName);
    Actions.sleep(2000);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    Actions.clickElementIOS(driver, viewMoewButton);
    Actions.sleep(2000);
    //Actions.clickElementIOS(driver, spotDropDownListCurrentSpot);
  }

    @Override
  public void addCashInvalidCvc() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);
    Actions.clickElementIOS(driver, addCashPaymentMethodButton);
    Actions.clickElementIOS(driver, addCashAddTokenTicket);
    Actions.sendKeysIOS(driver, addCashNameOnTokenTicket, "moeconsultingTest");
    Actions.sendKeysIOS(driver, addCashTokenTicketNumber, "6514828282823178");
    Actions.sendKeysIOS(driver, addCashTokenTicketExpiration, "1025");
    Actions.sendKeysIOS(driver, addCashTokenTicketCvc, "1");
    Actions.sendKeysIOS(driver,addCashTokenTicketPostalCode, "02459");
        if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size() > 0)
       {Actions.clickElementIOS(driver, okButton3);
        System.out.println("Appered and clicked!");}
    Actions.clickElementIOS(driver, addCashAddButton);
    Assert.assertEquals("Your CVC must be between 2 and 4 characters.", cvcErrorMsg.getText());
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver, cancelButton);
    Actions.clickElementIOS(driver, backButton);
  }

  	@Override
  public void addCashSaveforFutureButton() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);
    Actions.clickElementIOS(driver, addCashPaymentMethodButton);
    Actions.clickElementIOS(driver, addCashAddTokenTicket);
    Actions.clickElementIOS(driver, saveForFutureSwitch);
    Actions.sendKeysIOS(driver, addCashNameOnTokenTicket, "moeconsultingTest");
    String tokenTicketNumbers = "6514828282823178";
    Actions.sendKeysIOS(driver, addCashTokenTicketNumber, tokenTicketNumbers);
    String lastFourDigits = tokenTicketNumbers.substring(tokenTicketNumbers.length() - 4);
    Actions.sendKeysIOS(driver, addCashTokenTicketExpiration, "1025");
    Actions.sendKeysIOS(driver, addCashTokenTicketCvc, "654");
    Actions.sendKeysIOS(driver,addCashTokenTicketPostalCode, "02459");
    if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size() > 0)
       {Actions.clickElementIOS(driver, okButton3);
        System.out.println("Appered and clicked!");}
    String displayedLastFourDigits = cTicketInUseMsg.getText();
    assertTrue(displayedLastFourDigits.contains(lastFourDigits));
    Actions.clickElementIOS(driver, addCashPaymentMethodButton);
    List<MobileElement> savedTicketsElements = cTicketsSavedTable.findElements(MobileBy.iOSClassChain("**/XCUIElementTypeTable"));

    boolean found = false;
    for (MobileElement ticket : savedTicketsElements) {
    if (ticket.getText().contains(lastFourDigits)) {
        found = true;
        break;
      }
    }

    assertTrue("The last four digits were found in the saved tickets elements.", !found);
    Actions.clickElementIOS(driver, backButton);
  }

   @Override
   public void addCashExceedBalance() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashMenuButton);
    String tokensText = currentTokenBalance.getText();
    String numericPart = tokensText.replaceAll("[^0-9.]", "");
    String integerPart = numericPart.contains(".") ? numericPart.substring(0, numericPart.indexOf(".")) : numericPart;
    String lastTwoDigits = integerPart.length() >= 2 ? integerPart.substring(integerPart.length() - 2) : integerPart;
    int tokensInBalance = Integer.parseInt(lastTwoDigits);
    if (driver.findElements(By.xpath("//XCUIElementTypeButton[@name='OK']")).size() > 0)
    {Actions.clickElementIOS(driver, okButton3);
     System.out.println("Appered and clicked!");}
  if (tokensInBalance < 27) {
    System.out.println("Tokens are less than 50: " + tokensInBalance);


    for (int i = 0; i < 3; i++) {
      System.out.println("Executing loop iteration " + (i + 1));
      Actions.sleep(6000);
        Actions.clickElementIOS(driver, twentyfourTokensRadioButton);
        Actions.clickElementIOS(driver, addCashButtonTwo);
        Actions.sleep(6000);
        if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
        {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
        System.out.println("Appered and clicked!");
        Actions.sleep(3000);
        }
        Assert.assertEquals("Transaction Successful!", addCashConfirmation.getText());//declare
        Actions.clickElementIOS(driver, returnToMusicButton);
        Actions.clickElementIOS(driver, addCashMenuButton);

          tokensText = currentTokenBalance.getText();
          numericPart = tokensText.replaceAll("[^0-9.]", "");
          integerPart = numericPart.contains(".") ? numericPart.substring(0, numericPart.indexOf(".")) : numericPart;
          lastTwoDigits = integerPart.length() >= 2 ? integerPart.substring(integerPart.length() - 2) : integerPart;
          tokensInBalance = Integer.parseInt(lastTwoDigits);
          System.out.println("Tokens are now: " + tokensInBalance);

        if (tokensInBalance >= 27) {
            System.out.println("Tokens are now 50 or more: " + tokensInBalance);
            Actions.clickElementIOS(driver, twentyfourTokensRadioButton);
            Actions.clickElementIOS(driver, addCashButtonTwo);
            if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
            {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
            System.out.println("Appered and clicked!");
            Actions.sleep(3000);
            }
            Assert.assertEquals(" The moneybag limit is $50.00, you cannot add cash at this time. ", MoneyBagLimitErrorMsg.getText());
            Actions.clickElementIOS(driver, okButton);
            break;
            }
        }
    } else {

       System.out.println("Tokens are 50 or more: " + tokensInBalance);
            Actions.clickElementIOS(driver, twentyfourTokensRadioButton);
            Actions.clickElementIOS(driver, addCashButtonTwo);
            boolean autoReloadPopUpPresent = Actions.isElementPresent(driver, autoReloadOptionalPopUp);
            if (Actions.isElementPresent(driver, autoReloadOptionalPopUp))
            {Actions.clickElementIOS(driver, autoReloadOptionalPopUp);
            System.out.println("Appered and clicked!");
            Actions.sleep(3000);
            }
            Assert.assertEquals(" The moneybag limit is $50.00, you cannot add cash at this time. ", MoneyBagLimitErrorMsg.getText());
            Actions.clickElementIOS(driver, okButton);
       }
       Actions.clickElementIOS(driver, backButton);
      }

      @Override
    public void addCashButtonReloadCheck() throws InterruptedException {
    Actions.clickElementIOS(driver, addCashButton);
    boolean isPresentInDefault = Actions.isElementPresent(driver, addCashButtonTwo);
    Assert.assertFalse(isPresentInDefault);
    System.out.println("Add cash button is not present");
    Actions.clickElementIOS(driver, backButton);
  }
  @Override
   public void tracklistNameError() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "testtracklisttesttracklisttesttracklisttesttracklist123");
    Assert.assertEquals("The tracklist title is too long! ", tracklistTooLongError.getText());
    Actions.clickElementIOS(driver, okButton);
    Actions.clickElementIOS(driver,cancelCreateTracklist);
    }

      @Override
   public void tracklistwithSpecialCharacter() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "test!@$%^&*()");
    }

          @Override
   public void successfulTracklist() throws InterruptedException {
    Actions.clickElementIOS(driver, myMusicButton);
    Actions.clickElementIOS(driver, myTracklistTabButton);
    Actions.clickElementIOS(driver, newTracklistButton);
    Actions.sendKeysIOS(driver, tracklistInput, "ConsultingTracklist");
    }

              @Override
   public void backToHomeSpot() throws InterruptedException {
      Actions.clickElementIOS(driver, spotHomeName);
      Actions.clickElementIOS(driver, viewMoreButton);
    }


}