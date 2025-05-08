package android.pages;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.asm.Advice.Return;
import page_interfaces.Login;
import page_interfaces.Spot;
import utils.Actions;
import java.util.List;
import io.appium.java_client.MobileElement;

public class SpotPageAndroid implements Spot {

  /*
   * 
   * EXAMPLE ANDROID PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  static AndroidDriver driver;

  // DECLARE CONSTRUCTOR
  public SpotPageAndroid(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (AndroidDriver) driver;
  }
  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText")
  private AndroidElement spotsInput;

  @AndroidFindBy(xpath = "//*[@text='Continue']")
  private AndroidElement continueButton;

  @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
  private AndroidElement continueTwoButton;

  @AndroidFindBy(xpath = "//*[@text='RECENT']")
  private AndroidElement recentButton;

  @AndroidFindBy(xpath = "//*[@text='PROXIMATE']")
  private AndroidElement proximateButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ImageView")
  private AndroidElement searchIconButton;

  @AndroidFindBy(xpath = "//*[@text='Consulting Automation Cafe']")
  private AndroidElement consultingSpotButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
  private AndroidElement firstSpotButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
  private AndroidElement viewAllArtirsButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
  private AndroidElement viewAllButtonTracks; //Tracks hot here

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Album Cover\"])[1]")
  private AndroidElement viewAllFirstTrack;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
  private AndroidElement viewAllFromSearchButton;

  @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_view_all'])[1]")
  private AndroidElement viewAllAlbumsButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
  private AndroidElement firstArtistButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup")
  private AndroidElement tracklistFirstTrack;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
  private AndroidElement firstTrackNameButton;

  @AndroidFindBy(xpath = "//*[@text='Add to My Tracks']")
  private AndroidElement addToMyTracksButton;

  @AndroidFindBy(xpath = "//*[@text='My Music']")
  private AndroidElement myMusicButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[1]")
  private AndroidElement myMusicFirstTrackButton;

  @AndroidFindBy(xpath = "//*[@text='Remove from My Tracks']")
  private AndroidElement removeFromMyTracksButton;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/tv_add_tracklist']")
  private AndroidElement addToTracklistButton;

  @AndroidFindBy(xpath = "//*[@text='New Tracklist']")
  private AndroidElement newTracklistButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
  private AndroidElement tracklistInput;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")                          
  private AndroidElement tracklistInput2;

  @AndroidFindBy(xpath = "//*[@text='SAVE']")
  private AndroidElement saveButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement firstTracklistButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]")
  private AndroidElement firstTracklistButton2;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement secondTracklistButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
  //@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
  private AndroidElement firstTrackFirstAlbum;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
  private AndroidElement firstTrackFirstAlbum2;

  @AndroidFindBy(xpath = "//*[@text='MY TRACKLISTS']")
  private AndroidElement myTracklistsButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement myTracklistButton;

  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/iv_sort']")
  private AndroidElement editButton;

  @AndroidFindBy(xpath = "//*[@text='Delete']")
  private AndroidElement deleteButton;

  @AndroidFindBy(xpath = "//*[@text='DELETE']")
  private AndroidElement deleteTwoButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText")
  private AndroidElement spotInput;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout[2]")
  private AndroidElement firstSpotSearchButton;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Favorite'])[1]")
  private AndroidElement heartOffButton;

  @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Favorite\"]")
  private AndroidElement heartOnButton;

  @AndroidFindBy(xpath = "//*[@text='FAVORITES']")
  private AndroidElement favoritesButton;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
  private AndroidElement backButton;

  @AndroidFindBy(xpath = "//*[@text='Not Now']")
  private AndroidElement notNowButton;

  @AndroidFindBy(xpath = "//*[@text='Tracks Hot Here']")
  private AndroidElement tracksHotHereLabel;

  @AndroidFindBy(xpath = "//*[@text='Search for music']")
  private AndroidElement mediaSearchInput;

  @AndroidFindBy(xpath = "//*[@text='Enter Sandman']")
  private AndroidElement foundTrack;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[2]")
  private AndroidElement foundTrackFistInList;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[3]")
  private AndroidElement foundTrackSecondInList;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[4]")
  private AndroidElement foundTrackThirdInList;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[5]")
  private AndroidElement foundTrackFourthInList;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[6]")
  private AndroidElement foundTrackFifthInList;

  @AndroidFindBy(xpath = "//*[@text='Play Track']")
  private AndroidElement playTrackButton;

  @AndroidFindBy(xpath = "//*[@text='Play Track with Priority']")
  private AndroidElement playTrackPriorityButton;

  @AndroidFindBy(xpath = "//*[@text='Please Add Cash']")
  private AndroidElement addCashLabel;

  @AndroidFindBy(xpath = "//*[@text='CANCEL']")
  private AndroidElement cancelButton;

  @AndroidFindBy(xpath = "//*[@text='CONFIRM']")
  private AndroidElement confirmButton;

  @AndroidFindBy(xpath = "//*[@text='OK']")
  private AndroidElement okButton;

  @AndroidFindBy(xpath = "//*[@text='View Play Queue']")
  private AndroidElement viewPlayQueue;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[2]")
  private AndroidElement firstTrackQueued;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[3]")
  private AndroidElement secondTrackQueued;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[4]")
  private AndroidElement thirdTrackQueued;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.company.COMPANYSmartBar:id/main_container\"])[5]")
  private AndroidElement fourthTrackQueued;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
  private AndroidElement firstArtistSection;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
  private AndroidElement artistTitle;

  @AndroidFindBy(xpath = "//*[@text='Add Cash']")
  private AndroidElement addCashButton;

  @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Add Cash'])[1]")
  private AndroidElement addCashButtonTwo;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='$6']")
  private AndroidElement sixTokensRadioButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='$24']")
  private AndroidElement twentyfourTokensRadioButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='$12']")
  private AndroidElement twelveTokensRadioButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Switch")
  private AndroidElement autoReloadSwitch;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transaction Successful!']")
  private AndroidElement addCashConfirmation;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Return to music selection']")
  private AndroidElement returnToMusicButton;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Media Image\"])[1]")
  private AndroidElement anyTrackButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
  private AndroidElement tokens;

  @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"All Music\"]/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement allMusicTab;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
  private AndroidElement neverButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView")
  private AndroidElement myTrackListButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]")
  private AndroidElement myTrackListButton2;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
  private AndroidElement myTrackSortByArtist;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
  private AndroidElement myTrackSortByTrack;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
  private AndroidElement myTrackSortByDate;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
  private AndroidElement myTrackSortByPopularity;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")
  private AndroidElement tracklistSortByArtirst;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
  private AndroidElement tracklistSortByTrack;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")
  private AndroidElement tracklistSortByTrackOrder;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView")
  private AndroidElement tracklistSortByPopularity;

  @AndroidFindBy(xpath = "//*[@text='Tap here for multi-track selection']")
  private AndroidElement myTracksMultiTrackSelection;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Select\"])[3]")
  private AndroidElement myTracksMultiTrackSelection2ndTrack;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Select\"])[2]")
  private AndroidElement myTracksMultiTrackSelection1stTrack;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
  private AndroidElement myTracksPlaySelectedTracks;

  @AndroidFindBy(xpath = "//*[@text='Play Tracks with Priority']")
  private AndroidElement myTracksPlayTracksWPriority;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
  private AndroidElement myTracksSelectAllTracks;

  @AndroidFindBy(xpath = "//*[@text='Please select at least one track']")
  private AndroidElement myTracksPlaySelectedTracksError;

  @AndroidFindBy(xpath = "//*[@text='Rename']")
  private AndroidElement tracklistRename;

  //@AndroidFindBy(xpath = "//*[@text='/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText']")
  @AndroidFindBy(xpath = "//*[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text']")
  private AndroidElement tracklistRenameInput;

  @AndroidFindBy(xpath = "//*[@text='Add a spot to your list of \"Favorites\" by tapping once on its heart icon. Tap it again to remove it.']")
  private AndroidElement noFavoriteSpots;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
  private AndroidElement spotHomeName;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")
  private AndroidElement viewMoreButton;

  @AndroidFindBy(xpath = "Add tracks to this tracklist by touching the \"All Music\" tab and then tapping on available tracks.")
  private AndroidElement emptyTracklistLabel;

  @AndroidFindBy(xpath = "//*[@text='Select your current spot.']")
  private AndroidElement selectYourCurrentSpotLabel;

  @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Now Playing']")
  private AndroidElement nowPlayingMenu;
  
  @AndroidFindBy(xpath = "//*[@text='View This Artist']")
  private AndroidElement nowPlayingViewThisArtist;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
  private AndroidElement viewThisArtist;

  @AndroidFindBy(xpath = "//*[@text='Retry']")
  private AndroidElement retryButton;

  @AndroidFindBy(xpath = "//*[@text='Edit Track Order']")
  private AndroidElement editTrackOrder;

  @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"DELETE\"]")
  private AndroidElement editTrackOrderMenuDelete;

  @AndroidFindBy(xpath = "//*[@text='REMOVE']")
  private AndroidElement editTrackOrderMenuRemove;

  @AndroidFindBy(xpath = "//*[@text='SAVE']")
  private AndroidElement editTrackOrderMenuSave;

  @AndroidFindBy(xpath = "//*[@text='Login Required']")
  private AndroidElement loginRequiredLabel;

  @AndroidFindBy(xpath = "//*[@text='ALBUMS']")
  private AndroidElement albumsTab;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout")
  private AndroidElement firstAlbumListed;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Album Cover\"])[1]")
  private AndroidElement firstAlbumListed2;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
  private AndroidElement firstAlbumTrackListed;

  @AndroidFindBy(xpath = "//*[@text='Got an statement? Log in']")
  private AndroidElement alreadyStatementButton;

  @AndroidFindBy(xpath = "//*[@text='Sorry, no results were found. Only artists and tracks approved for play at this spot or during this hour will appear in search results.']")
  private AndroidElement noTracknoArtistFound;

  @AndroidFindBy(xpath = "//*[@text='Change']")
  private AndroidElement changePaymentMethod;

  @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Supported payment methods']/android.widget.RelativeLayout[2]")
  private AndroidElement addTokenTicket;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[1]")
  private AndroidElement nameOnTokenTicket;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[2]")
  private AndroidElement tokenTicketNumber;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[3]")
  private AndroidElement tokenTicketExpiration;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[4]")
  private AndroidElement tokenTicketCvc;

  @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='com.company.COMPANYSmartBar:id/company_edit_text'])[5]")
  private AndroidElement tokenTicketPostalCode;

  @AndroidFindBy(xpath = "//*[@resource-id=\"com.company.COMPANYSmartBar:id/button_save\"]")
  private AndroidElement saveTokenTicketButton; 

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
  private AndroidElement cTicketInfoErrorMsg;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
  private AndroidElement cTicketErrorOkButton;

  @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.company.COMPANYSmartBar:id/switch_save_cc']")
  private AndroidElement saveForFutureSwitch;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/tv_add_cash_payment_method']")
  private AndroidElement cTicketInUseMsg;

  @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.company.COMPANYSmartBar:id/rv_custom']")
  private AndroidElement cTicketsSavedTable;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/header_action']")
  private AndroidElement editSavedTickets;

  @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='DELETE'])[1]")
  private AndroidElement deleteSavedTicket;

  @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.company.COMPANYSmartBar:id/rv_custom']")
  private AndroidElement deleteSavedTicketsTable;

  @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='com.company.COMPANYSmartBar:id/ll_base_item'])[2]")
  private AndroidElement secondTokenTicketAvailable;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='The moneybag limit is $50.00, you cannot add cash at this time.']")
  private AndroidElement MoneyBagLimitErrorMsg;

  @AndroidFindBy(xpath = "//android.widget.Button")
  private AndroidElement MoneyBagLimitErrorOkButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/toolbar_subTitle']")
  private AndroidElement currentTokenBalance;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.company.COMPANYSmartBar:id/navigation_bar_item_large_label_view']")
  private AndroidElement addCashMenuButton;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/button_add_cash']")
  private AndroidElement addTokenCashButton;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message']")
  private AndroidElement tracklistTooLongError;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
  private AndroidElement longTracklistErrorOk;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.company.COMPANYSmartBar:id/button_save']")
  private AndroidElement saveTracklist;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text='No thanks, just add cash']")
  private AndroidElement saveTimeMsg;

  int rateCounter=0;

  @Override
  public void homePageUI() throws InterruptedException {
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, tracksHotHereLabel);
  }


  @Override
  public void homePageTabsUI() throws InterruptedException {
    Assert.assertEquals("All Music", allMusicTab.getText());
    Assert.assertEquals("My Music", myMusicButton.getText());
    Assert.assertEquals("Add Cash", addCashButton.getText());
  }


  //@Override
  public void searchFirstTrackOnFirstSpot() throws InterruptedException {
    /*
     * These comments are for QA if needed with consulting jukebox
     * 
     */
    // Actions.sendKeysAndroid(driver, spotsInput, "Consultingtest");
    // Actions.sleep(2000);
    // Actions.clickOnCoordinatesAndroid(driver, 292, 645);
    // Actions.clickElementAndroid(driver, spotsInput);
    // Actions.clickOnCoordinatesAndroid(driver, 1001, 2156); // Click on done
    // keyboard
    // Actions.sleep(2000);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, viewAllArtirsButton);
    Actions.clickElementAndroid(driver, firstArtistButton);
    Actions.clickElementAndroid(driver, firstTrackNameButton);
  }

  
  @Override
  public void addTrack(String type) throws InterruptedException {
    //searchFirstTrackOnFirstSpot();
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    Actions.clickElementAndroid(driver, viewAllArtirsButton);
    Actions.clickElementAndroid(driver, firstArtistButton);
    Actions.clickElementAndroid(driver, firstTrackNameButton);
    
    if (type == "myTracks") {
      Actions.clickElementAndroid(driver, addToMyTracksButton);
      Actions.clickOnCoordinatesAndroid(driver, 517, 396); // Click outside the box
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
      Actions.clickElementAndroid(driver, removeFromMyTracksButton);
      Actions.sleep(2000);
    } else if (type == "tracklist") {
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, addToTracklistButton);
      Actions.clickElementAndroid(driver, newTracklistButton);
      Actions.sendKeysAndroid(driver, tracklistInput, "MyTracklist");
      Actions.clickElementAndroid(driver, saveButton);
      Actions.clickElementAndroid(driver, firstTracklistButton);
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      Actions.clickElementAndroid(driver, myTracklistButton);
      Actions.clickElementAndroid(driver, editButton);
      Actions.clickElementAndroid(driver, deleteButton);
      Actions.clickElementAndroid(driver, deleteTwoButton);
      Actions.sleep(2000);
    }
  }


  @Override
  public void addToTracklistFromTracklist() throws InterruptedException {
      //Actions.sleep(2000);
      Actions.clickElementAndroid(driver, viewAllArtirsButton);
      Actions.clickElementAndroid(driver, firstArtistButton);
      Actions.clickElementAndroid(driver, firstTrackNameButton);
      Actions.clickElementAndroid(driver, addToTracklistButton);
      Actions.clickElementAndroid(driver, newTracklistButton);
      Actions.sendKeysAndroid(driver, tracklistInput, "MyTracklist2");
      Actions.clickElementAndroid(driver, saveButton);
      Actions.clickElementAndroid(driver, secondTracklistButton);
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTrackListButton2);
      Actions.clickElementAndroid(driver, tracklistFirstTrack);
      Actions.clickElementAndroid(driver, addToTracklistButton);
      Actions.clickElementAndroid(driver, firstTracklistButton2);
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTrackListButton);
      //Actions.clickElementAndroid(driver, tracklistFirstTrack);
      Actions.clickElementAndroid(driver, editButton);
      Actions.clickElementAndroid(driver, editTrackOrder);
      Actions.clickElementAndroid(driver, editTrackOrderMenuDelete);
      Actions.clickElementAndroid(driver, editTrackOrderMenuRemove);
      Actions.clickElementAndroid(driver, editTrackOrderMenuSave);
      Actions.clickElementAndroid(driver, continueTwoButton);
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      Actions.clickElementAndroid(driver, myTrackListButton2);
      Actions.clickElementAndroid(driver, editButton);
      Actions.clickElementAndroid(driver, deleteButton);
      Actions.clickElementAndroid(driver, deleteTwoButton);
      Actions.sleep(2000);
  }


  @Override
  public void createTracklist() throws InterruptedException {
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      Actions.clickElementAndroid(driver, newTracklistButton);
      Actions.sendKeysAndroid(driver, tracklistInput2, "MyTracklist");
      Actions.clickElementAndroid(driver, saveButton);
      Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void emptyTracklist() throws InterruptedException {
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      Actions.clickElementAndroid(driver, myTracklistButton);
      Assert.assertEquals("Add tracks to this tracklist by touching the \u201cAll Music\u201d tab and then tapping on available tracks.", emptyTracklistLabel.getText());
      Actions.clickElementAndroid(driver, allMusicTab);
      Actions.clickElementAndroid(driver, allMusicTab);
    }

  @Override
  public void deleteAllTracklist() throws InterruptedException {
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      while (Actions.isElementPresent(driver, myTracklistButton)){
        Actions.clickElementAndroid(driver, myTracklistButton);
      Actions.clickElementAndroid(driver, editButton);
      Actions.clickElementAndroid(driver, deleteButton);
      Actions.clickElementAndroid(driver, deleteTwoButton);
      }
      
      Actions.clickElementAndroid(driver, allMusicTab);
      Actions.sleep(2000);
    }


  @Override
  public void deleteTracklist() throws InterruptedException {
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myTracklistsButton);
      Actions.clickElementAndroid(driver, myTrackListButton);
      Actions.clickElementAndroid(driver, editButton);
      Actions.clickElementAndroid(driver, deleteButton);
      Actions.clickElementAndroid(driver, deleteTwoButton);
      Actions.clickElementAndroid(driver, allMusicTab);
      Actions.sleep(2000);
    }


    @Override
  public void removeFirstMyTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
    Actions.clickElementAndroid(driver, removeFromMyTracksButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }
        @Override
  public void removeAllMyTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    while (Actions.isElementPresent(driver, myMusicFirstTrackButton)) {
        Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
        Actions.clickElementAndroid(driver, removeFromMyTracksButton);
        Actions.sleep(2000);
    }
    
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);

    }


    @Override
  public void myTracksSortByArtist() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, myTrackSortByArtist);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByTrack() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, myTrackSortByTrack);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByPopularity() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, myTrackSortByPopularity);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksSortByDate() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, myTrackSortByPopularity);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackSelection() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Actions.clickElementAndroid(driver, myTracksPlayTracksWPriority);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackAllTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Actions.clickElementAndroid(driver, myTracksPlayTracksWPriority);
    Actions.clickElementAndroid(driver, okButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackDeselectAllTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Actions.sleep(1000);
    Assert.assertEquals("Please select at least one track", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myTracksMultiTrackSelectionNumbered() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection2ndTrack);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("1 selected"));
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection1stTrack);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("2 selected"));
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Assert.assertTrue(myTracksPlaySelectedTracks.getText().contains("3 selected"));
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    }

    @Override
  public void tracklistSortByArtist() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, tracklistSortByArtirst);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistSortByTrack() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, tracklistSortByTrack);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistSortByPopularity() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, tracklistSortByPopularity);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistSortByTrackOrder() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, tracklistSortByTrackOrder);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void myMusicRenameTracklist() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, tracklistRename);
    Actions.sendKeysAndroid(driver, tracklistRenameInput, "Renamed");
    Actions.clickElementAndroid(driver, saveButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackSelection() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Actions.clickElementAndroid(driver, myTracksPlayTracksWPriority);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackDeselection() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection1stTrack);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection2ndTrack);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection1stTrack);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Assert.assertEquals("Please select at least one track", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementAndroid(driver, okButton);
    if (Actions.isElementPresent(driver, backButton))
    {Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
     }else{
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, allMusicTab);
      }

    }


    @Override
  public void tracklistMultiTrackAllTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Actions.clickElementAndroid(driver, myTracksPlayTracksWPriority);
    Actions.clickElementAndroid(driver, okButton);
    //Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


    @Override
  public void tracklistMultiTrackDeselectAllTracks() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, myTracksMultiTrackSelection);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, myTracksSelectAllTracks);
    Actions.clickElementAndroid(driver, myTracksPlaySelectedTracks);
    Assert.assertEquals("Please select at least one track", myTracksPlaySelectedTracksError.getText());
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    }


  @Override
  public void searchTrack(String track, String location) throws InterruptedException {
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Assert.assertEquals("Enter Sandman", foundTrack.getText());
  }


  @Override
  public void searchTrackAsGuest(String track) throws InterruptedException {
    //Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Assert.assertEquals("Enter Sandman", foundTrack.getText());
  }
  

  @Override
  public void playTrackPriorityNoTokens(String track) throws InterruptedException {
    //Actions.sleep(2000);
    //Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackPriorityButton);
    Assert.assertEquals("Please Add Cash", addCashLabel.getText());
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, cancelButton);
  }


  @Override
  public void playTrackPriorityTokens(String track) throws InterruptedException {
    Actions.sleep(5000);
    //Actions.clickElementAndroid(driver, recentButton);
    //Actions.clickElementAndroid(driver, proximateButton);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackPriorityButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, okButton);
  }

  @Override
  public void playTrack(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.sleep(2000);
  }


  @Override
  public void playTrackAsGuest(String track) throws InterruptedException {
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void playTrackAsGuestFromArtists_Album(String track) throws InterruptedException {
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, firstArtistSection);
    Actions.clickElementAndroid(driver, albumsTab);
    Actions.clickElementAndroid(driver, firstAlbumListed);
    Actions.clickElementAndroid(driver, firstAlbumTrackListed);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestFromArtists_Tracks(String track) throws InterruptedException {
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, viewAllButtonTracks);
    Actions.clickElementAndroid(driver, viewAllFirstTrack);
    //Actions.clickElementAndroid(driver, albumsTab);
    //Actions.clickElementAndroid(driver, firstAlbumListed);
    //Actions.clickElementAndroid(driver, firstAlbumTrackListed);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestFromAlbum_Track(String track) throws InterruptedException {
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.swipeOnCoordinates(driver, 837, 1788, 589, 692);
    Actions.swipeOnCoordinates(driver, 837, 1788, 589, 692);
    Actions.swipeOnCoordinates(driver, 837, 1788, 589, 692);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, viewAllFromSearchButton);
    Actions.clickElementAndroid(driver, viewAllFirstTrack);
    Actions.clickElementAndroid(driver, firstTrackFirstAlbum);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotTrack() throws InterruptedException {
    Actions.clickElementAndroid(driver, viewAllAlbumsButton);
    Actions.clickElementAndroid(driver, viewAllFirstTrack);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotArtists() throws InterruptedException {
    Actions.clickElementAndroid(driver, viewAllArtirsButton);
    Actions.clickElementAndroid(driver, viewAllFirstTrack);
    Actions.clickElementAndroid(driver, firstTrackFirstAlbum2);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void playTrackAsGuestHotArtistsAlbum_Track() throws InterruptedException {
    Actions.clickElementAndroid(driver, viewAllArtirsButton);
    Actions.clickElementAndroid(driver, firstAlbumListed2);
    Actions.clickElementAndroid(driver, albumsTab);
    Actions.clickElementAndroid(driver, firstAlbumListed2);
    Actions.clickElementAndroid(driver, firstTrackFirstAlbum);
    Assert.assertEquals("Login Required", loginRequiredLabel.getText());
    Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void guestNotAccessToMyMusic() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Assert.assertEquals("Got an statement? Log in", alreadyStatementButton.getText());
    //Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void guestNotAccessToAddCash() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);
    Assert.assertEquals("Got an statement? Log in", alreadyStatementButton.getText());
    //Actions.clickElementAndroid(driver, notNowButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void searchNonExistingArtistWSpecialCharacters(String artist) throws InterruptedException {
    Actions.sendKeysAndroid(driver, mediaSearchInput, artist);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Assert.assertEquals("Sorry, no results were found. Only artists and tracks approved for play at this spot or during this hour will appear in search results.", noTracknoArtistFound.getText());
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    
  }


  // @Override
  // public void playSameTrack(String track) throws InterruptedException {
  //   Actions.sendKeysAndroid(driver, mediaSearchInput, track);
  //   ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
  //   Actions.sleep(2000);
  //   Actions.clickElementAndroid(driver, foundTrackFistInList);
  //   Actions.clickElementAndroid(driver, playTrackButton);
  //   Actions.clickElementAndroid(driver, confirmButton);
  //   Actions.sleep(2000);
  //   Actions.clickElementAndroid(driver, okButton);
  //   //Actions.clickElementAndroid(driver, backButton);
  //   //Actions.clickElementAndroid(driver, backButton);
  // }


  @Override
  public void playTrackFromSpotHomeScreen(String track) throws InterruptedException {
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void Add3TracksToMyTracks(String track) throws InterruptedException {
    Actions.sleep(1000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, addToMyTracksButton);
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, foundTrackSecondInList);
    Actions.clickElementAndroid(driver, addToMyTracksButton);
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, foundTrackThirdInList);
    Actions.clickElementAndroid(driver, addToMyTracksButton);
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    //Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void Add3TracksToTracklist(String track) throws InterruptedException {
    Actions.sleep(1000);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, addToTracklistButton);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput, "MyTracklist");
    Actions.clickElementAndroid(driver, saveButton);
    Actions.clickElementAndroid(driver, firstTracklistButton);
    //Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, foundTrackSecondInList);
    Actions.clickElementAndroid(driver, addToTracklistButton);
    Actions.clickElementAndroid(driver, firstTracklistButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackThirdInList);
    Actions.clickElementAndroid(driver, addToTracklistButton);
    Actions.clickElementAndroid(driver, firstTracklistButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void play2Tracks(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, foundTrackSecondInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, viewPlayQueue);
    Actions.sleep(10000);
    Actions.clickElementAndroid(driver, firstTrackQueued);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
    //Actions.clickElementAndroid(driver, secondTrackQueued);
    //((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
  }


  @Override
  public void play5Tracks(String track) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, track);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, foundTrackFistInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, foundTrackSecondInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, foundTrackThirdInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, foundTrackFourthInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, neverButton);
    Actions.clickElementAndroid(driver, foundTrackFifthInList);
    Actions.clickElementAndroid(driver, playTrackButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, backButton);
    Actions.clickElementAndroid(driver, viewPlayQueue);
    Actions.sleep(10000);
    Actions.clickElementAndroid(driver, firstTrackQueued);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, secondTrackQueued);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, thirdTrackQueued);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
    Actions.clickElementAndroid(driver, fourthTrackQueued);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
    //Actions.clickElementAndroid(driver, secondTrackQueued);
    //((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ESCAPE));
  }


  @Override
  public void viewArtist(String artirst) throws InterruptedException {
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.sendKeysAndroid(driver, mediaSearchInput, artirst);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, firstArtistSection);
    Assert.assertEquals("Rihanna", artistTitle.getText());
  }


  @Override
  public void removeTrack() throws InterruptedException {
      Actions.sendKeysAndroid(driver, spotsInput, "Consulting");
      ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
      searchFirstTrackOnFirstSpot();
      Actions.clickElementAndroid(driver, addToMyTracksButton);
      Actions.clickOnCoordinatesAndroid(driver, 517, 396); // Click outside the box
      Actions.clickElementAndroid(driver, myMusicButton);
      Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
      Actions.clickElementAndroid(driver, removeFromMyTracksButton);
  }

  @Override
  public void favoriteSpot(Boolean logged) throws InterruptedException {
    if (logged) {
      Actions.sleep(5000);
      //Actions.clickElementAndroid(driver, recentButton);
      //Actions.clickElementAndroid(driver, proximateButton);
      //Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
      //Actions.clickElementAndroid(driver, spotInput);
      //Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
      Actions.clickElementAndroid(driver, heartOffButton);
      Actions.clickElementAndroid(driver, favoritesButton);
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, heartOnButton);
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, neverButton);
      Actions.sleep(2000);
    } else {
      Actions.sleep(5000);
      //Actions.clickElementAndroid(driver, backButton);
      //Actions.clickElementAndroid(driver, recentButton);
      //Actions.clickElementAndroid(driver, proximateButton);
      //Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
      //Actions.clickElementAndroid(driver, spotInput);
      //Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
      Actions.clickElementAndroid(driver, heartOffButton);
      Actions.clickElementAndroid(driver, notNowButton);
      Actions.sleep(2000);
    }
  }


  @Override
  public void favoriteSpotListedinHome() throws InterruptedException {
    if(heartOnButton.getAttribute("resource-id").equals("com.company.COMPANYSmartBar:id/iv_location_details_favorite_no"))
    {Actions.clickElementAndroid(driver, heartOnButton);}
    Actions.sleep(1000);
      Actions.clickElementAndroid(driver, firstSpotButton);
      Actions.sleep(2000);
      //Actions.clickElementAndroid(driver, continueButton);
      //Actions.clickElementAndroid(driver, favoritesButton);
      Actions.sleep(2000);
      Assert.assertEquals("Consulting Automation Cafe", spotHomeName.getText());
      Actions.clickElementAndroid(driver, spotHomeName);
      Actions.clickElementAndroid(driver, viewMoreButton);
    if(heartOffButton.getAttribute("resource-id").equals("com.company.COMPANYSmartBar:id/iv_location_details_favorite_yes"))
    {Actions.clickElementAndroid(driver, heartOffButton);
    }
      Actions.sleep(2000);
      Actions.clickElementAndroid(driver, neverButton);
  }


  @Override
  public void spotsDropDownList() throws InterruptedException {
      Actions.clickElementAndroid(driver, spotHomeName);
      Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
      //((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
      driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
  }


  @Override
  public void noFavorites() throws InterruptedException {
      Actions.clickElementAndroid(driver, favoritesButton);
      Assert.assertEquals("Add a spot to your list of \"Favorites\" by tapping once on its heart icon. Tap it again to remove it.", noFavoriteSpots.getText());
    }


  @Override
  public void addCashTokenTicketSixDollars() throws InterruptedException {
    Actions.sleep(2000);
     boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    String tokensText = currentTokenBalance.getText();
    System.out.println("Original text: " + tokensText);
    String dollarPart = tokensText.substring(tokensText.indexOf("$") + 1, tokensText.indexOf("."));
    int tokensInBalance = Integer.parseInt(dollarPart);
    System.out.println(tokensInBalance);

     if (tokensInBalance < 43) {
    Actions.clickElementAndroid(driver, sixTokensRadioButton);
    Actions.clickElementAndroid(driver, addCashButton);
    Actions.sleep(4000);
    Assert.assertEquals("Transaction Successful!", addCashConfirmation.getText());
    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
    {Actions.clickElementAndroid(driver, retryButton);
     System.out.println("Appered and clicked!");}
    boolean saveTimeMessage = Actions.isElementPresent(driver, saveTimeMsg);
    if (saveTimeMessage)
    {Actions.clickElementAndroid(driver, saveTimeMsg);
    }
        Actions.sleep(2000);
     Actions.sleep(3000);
     Actions.clickElementAndroid(driver, returnToMusicButton);
     } else{

      Actions.clickElementAndroid(driver, allMusicTab);

     }
     

  }


  @Override
  public void addCashTokenTicket24Dollars() throws InterruptedException {
    Actions.sleep(2000);
     boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    String tokensText = currentTokenBalance.getText();
    System.out.println("Original text: " + tokensText);
    String dollarPart = tokensText.substring(tokensText.indexOf("$") + 1, tokensText.indexOf("."));
    int tokensInBalance = Integer.parseInt(dollarPart);
    System.out.println(tokensInBalance);
     if (tokensInBalance < 25) {
    Actions.clickElementAndroid(driver, twentyfourTokensRadioButton);
    Actions.clickElementAndroid(driver, addCashButton);
    Actions.sleep(5000);
    Assert.assertEquals("Transaction Successful!", addCashConfirmation.getText());
    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
    {Actions.clickElementAndroid(driver, retryButton);
     System.out.println("Appered and clicked!");}
    boolean saveTimeMessage = Actions.isElementPresent(driver, saveTimeMsg);
    if (saveTimeMessage)
    {Actions.clickElementAndroid(driver, saveTimeMsg);
    }
     Actions.sleep(3000);
     Actions.clickElementAndroid(driver, returnToMusicButton);
     } else{

      Actions.clickElementAndroid(driver, allMusicTab);

     }
     
  }


  @Override
  public void addCashTokenTicket12Dollars() throws InterruptedException {
    Actions.sleep(2000);
     boolean errorIsPresent = Actions.isElementPresent(driver, notNowButton);
    if (errorIsPresent)
    {Actions.clickElementAndroid(driver, notNowButton);
     System.out.println("Appered and clicked!");
     }
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}

    Actions.sleep(2000);
    String tokensText = currentTokenBalance.getText();
    System.out.println("Original text: " + tokensText);
    String dollarPart = tokensText.substring(tokensText.indexOf("$") + 1, tokensText.indexOf("."));
    int tokensInBalance = Integer.parseInt(dollarPart);
    System.out.println(tokensInBalance);

     if (tokensInBalance < 37) {
    Actions.clickElementAndroid(driver, twelveTokensRadioButton);
    Actions.clickElementAndroid(driver, addCashButton);
    Actions.sleep(4000);
    Assert.assertEquals("Transaction Successful!", addCashConfirmation.getText());
    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
    {Actions.clickElementAndroid(driver, retryButton);
     System.out.println("Appered and clicked!");}
    boolean saveTimeMessage = Actions.isElementPresent(driver, saveTimeMsg);
    if (saveTimeMessage)
    {Actions.clickElementAndroid(driver, saveTimeMsg);
    }
     Actions.sleep(3000);
     Actions.clickElementAndroid(driver, returnToMusicButton);
     } else{

      Actions.clickElementAndroid(driver, allMusicTab);

     }
     
  }


  @Override
  public void addTokens(Boolean recharge) throws InterruptedException {
    Actions.sleep(5000);
    Actions.clickElementAndroid(driver, recentButton);
    Actions.clickElementAndroid(driver, proximateButton);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    Actions.clickElementAndroid(driver, spotInput);
    Actions.sleep(2000);
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    /*
     * Fails here, the app brakes
     */
  }


  @Override
  public void autoReload(Boolean toggle) throws InterruptedException {
    Actions.sleep(2000);
    Actions.sendKeysAndroid(driver, spotInput, "Consultingtest");
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
    
    if(autoReloadSwitch.getAttribute("checked").equals("true"))
       {Actions.clickElementAndroid(driver, autoReloadSwitch);}//to turn it OFF

    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, autoReloadSwitch);//to turn it ON
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, continueTwoButton);
    Actions.clickElementAndroid(driver, returnToMusicButton);
  }


  @Override
  public void tokensCleanUp() throws InterruptedException {
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, anyTrackButton);
    Actions.clickElementAndroid(driver, playTrackPriorityButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
  }


  @Override
  public void tokensCleanUpRateDialog() throws InterruptedException {
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, anyTrackButton);
    Actions.clickElementAndroid(driver, playTrackPriorityButton);
    Actions.clickElementAndroid(driver, confirmButton);
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, okButton);
    Actions.clickElementAndroid(driver, neverButton);
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
  }


  @Override
  public void NowPlayingAddTracktoTracklist() throws InterruptedException {
    Actions.clickElementAndroid(driver, nowPlayingMenu);
    Actions.clickElementAndroid(driver, addToTracklistButton);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput, "MyTracklist");
    Actions.clickElementAndroid(driver, saveButton);
    Actions.clickElementAndroid(driver, firstTracklistButton);
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, myTracklistButton);
    Actions.clickElementAndroid(driver, editButton);
    Actions.clickElementAndroid(driver, deleteButton);
    Actions.clickElementAndroid(driver, deleteTwoButton);
    Actions.sleep(2000);
  }


  @Override
  public void NowPlayingAddTracktoMyMusic() throws InterruptedException {
    Actions.clickElementAndroid(driver, nowPlayingMenu);
    Actions.clickElementAndroid(driver, addToMyTracksButton);
    Actions.clickOnCoordinatesAndroid(driver, 517, 396); // Click outside the box
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myMusicFirstTrackButton);
    Actions.clickElementAndroid(driver, removeFromMyTracksButton);
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void NowPlayingViewThisArtist() throws InterruptedException {
    Actions.sleep(2000);
    Actions.clickElementAndroid(driver, nowPlayingMenu);
    Actions.clickElementAndroid(driver, nowPlayingViewThisArtist);
    String artistName = viewThisArtist.getText();
    if (artistName.contains("Bjork") || artistName.contains("Sid Vicious") || artistName.contains("Jordan Rakei")|| artistName.contains("Devendra Banhart")) {
        System.out.println("Artist name is one of the expected values: " + artistName);
    } else {
        throw new AssertionError("Artist name did not match any expected values. Found: " + artistName);
    }
    //Assert.assertEquals("Bjork", viewThisArtist.getText());
    Actions.clickElementAndroid(driver, allMusicTab);
  }


  @Override
  public void allMusicSelectSpot() throws InterruptedException {
    Actions.clickElementAndroid(driver, allMusicTab);
    Actions.clickElementAndroid(driver, spotHomeName);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
  }


  @Override
  public void myMusicSelectSpot() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, spotHomeName);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
  }


  @Override
  public void myMusicTracklistSelectSpot() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, spotHomeName);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
  }


  @Override
  public void addCashSelectSpot() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
        
    Actions.clickElementAndroid(driver, spotHomeName);
    Assert.assertEquals("Select your current spot.", selectYourCurrentSpotLabel.getText());
    driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
  }

     @Override
  public void addCashInvalidCvc() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
        
    Actions.clickElementAndroid(driver, changePaymentMethod);
    Actions.clickElementAndroid(driver, addTokenTicket);
    Actions.sendKeysAndroid(driver, tokenTicketNumber, "6514828282823178");
    Actions.sendKeysAndroid(driver, tokenTicketExpiration, "10/25");
    Actions.sendKeysAndroid(driver, tokenTicketCvc, "1");
    Actions.sendKeysAndroid(driver, tokenTicketPostalCode, "02459");
    Actions.clickElementAndroid(driver, saveTokenTicketButton);
    Assert.assertEquals("Your CVC must be between 3 and 4 characters", cTicketInfoErrorMsg.getText());
    Actions.clickElementAndroid(driver, cTicketErrorOkButton);
    Actions.clickElementAndroid(driver, cancelButton);
    Actions.clickElementAndroid(driver, backButton);
  }

   @Override
  public void addCashSaveforFutureButton() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
        
    Actions.clickElementAndroid(driver, changePaymentMethod);
    Actions.clickElementAndroid(driver, addTokenTicket);
    Actions.sendKeysAndroid(driver, nameOnTokenTicket, "moeconsultingTest");
    String tokenTicketNumbers = "6514828282823178";
    Actions.sendKeysAndroid(driver, tokenTicketNumber, tokenTicketNumbers);
    String lastFourDigits = tokenTicketNumbers.substring(tokenTicketNumbers.length() - 4);
    Actions.sendKeysAndroid(driver, tokenTicketExpiration, "10/25");
    Actions.sendKeysAndroid(driver, tokenTicketCvc, "654");
    Actions.sendKeysAndroid(driver, tokenTicketPostalCode, "02459");
    Actions.clickElementAndroid(driver, saveForFutureSwitch);
    Actions.clickElementAndroid(driver, saveTokenTicketButton);
    String displayedLastFourDigits = cTicketInUseMsg.getText();
    assertTrue(displayedLastFourDigits.contains(lastFourDigits));
    Actions.clickElementAndroid(driver, changePaymentMethod);
    List<MobileElement> savedTicketsElements = cTicketsSavedTable.findElements(By.className("android.widget.TextView"));

    boolean found = false;
    for (MobileElement ticket : savedTicketsElements) {
    if (ticket.getText().contains(lastFourDigits)) {
        found = true;
        break;
        }
     }

    assertTrue("The last four digits were found in the saved tickets elements.", !found);
    Actions.clickElementAndroid(driver, backButton);
  }


  @Override
  public void addCashExceedBalance() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}

    String tokensText = currentTokenBalance.getText();
    System.out.println("Original text: " + tokensText);
    String dollarPart = tokensText.substring(tokensText.indexOf("$") + 1, tokensText.indexOf("."));
    int tokensInBalance = Integer.parseInt(dollarPart);
    System.out.println(tokensInBalance);

    if (tokensInBalance < 26) {
    System.out.println("Tokens are 26 or less: " + tokensInBalance);
    

    for (int i = 0; i < 3; i++) {
        System.out.println("Executing loop iteration " + (i + 1));
        Actions.clickElementAndroid(driver, twentyfourTokensRadioButton);
        Actions.clickElementAndroid(driver, addCashButton);
        Actions.sleep(6000);
        boolean saveTimeMessage = Actions.isElementPresent(driver, saveTimeMsg);
        if (saveTimeMessage)
        {Actions.clickElementAndroid(driver, saveTimeMsg);
        }
        Actions.sleep(2000);
        Actions.clickElementAndroid(driver, returnToMusicButton);
        Actions.clickElementAndroid(driver, addCashButton);

        tokensText = currentTokenBalance.getText(); 
        dollarPart = tokensText.substring(tokensText.indexOf("$") + 1, tokensText.indexOf("."));
        tokensInBalance = Integer.parseInt(dollarPart);
        System.out.println(tokensInBalance);


        if (tokensInBalance >= 27) {
            System.out.println("Tokens are now 27 or more: " + tokensInBalance);
            Actions.clickElementAndroid(driver, twentyfourTokensRadioButton);
            Actions.clickElementAndroid(driver, addCashButton);
            Assert.assertEquals("The moneybag limit is $50.00, you cannot add cash at this time.", MoneyBagLimitErrorMsg.getText());
            Actions.clickElementAndroid(driver, MoneyBagLimitErrorOkButton);
            break;
            }
        }
    } else {
      System.out.println("Tokens are 27 or more: " + tokensInBalance);
      Actions.clickElementAndroid(driver, twentyfourTokensRadioButton);
      Actions.clickElementAndroid(driver, addCashButton);
      Assert.assertEquals("The moneybag limit is $50.00, you cannot add cash at this time.", MoneyBagLimitErrorMsg.getText());
      Actions.clickElementAndroid(driver, MoneyBagLimitErrorOkButton);
      }   

  }

    @Override
  public void addCashButtonReloadCheck() throws InterruptedException {
    Actions.clickElementAndroid(driver, addCashButton);

    if (driver.findElements(By.xpath("//*[@text='Retry']")).size() > 0)
       {Actions.clickElementAndroid(driver, retryButton);
        System.out.println("Appered and clicked!");}
    boolean isPresent = Actions.isElementPresent(driver, addCashButton);
    if (!isPresent){
      System.out.println("Add cash button is not present");
    }
  }

      @Override
  public void tracklistNameError() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput2, "testtracklisttesttracklisttesttracklisttesttracklist123");
    Actions.clickElementAndroid(driver, saveTracklist);
    Assert.assertEquals("The tracklist name is too long, please try again.", tracklistTooLongError.getText());
    Actions.clickElementAndroid(driver, longTracklistErrorOk);
    Actions.clickElementAndroid(driver,cancelButton);

  }

        @Override
  public void tracklistwithSpecialCharacter() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput2, "test!@$%^&*()");
    Actions.clickElementAndroid(driver, saveTracklist);
  }

          @Override
  public void successfulTracklist() throws InterruptedException {
    Actions.clickElementAndroid(driver, myMusicButton);
    Actions.clickElementAndroid(driver, myTracklistsButton);
    Actions.clickElementAndroid(driver, newTracklistButton);
    Actions.sendKeysAndroid(driver, tracklistInput2, "ConsultingTracklist");
    Actions.clickElementAndroid(driver, saveTracklist);
  }

  @Override
  public void backToHomeSpot() throws InterruptedException {
    Actions.clickElementAndroid(driver, spotHomeName);
    Actions.clickElementAndroid(driver, viewMoreButton);

 }
}