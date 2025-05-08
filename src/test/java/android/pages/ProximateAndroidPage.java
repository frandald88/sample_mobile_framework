package android.pages;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.asm.Advice.Enter;
import page_interfaces.Proximate;
import utils.Actions;

public class ProximateAndroidPage implements Proximate {

  /*
   * 
   * EXAMPLE ANDROID PAGE
   * 
   */

  // DECLARE DRIVER (Obligatory)
  AndroidDriver driver;

  // DECLARE CONSTRUCTOR
  public ProximateAndroidPage(AppiumDriver driver) {
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    this.driver = (AndroidDriver) driver;
  }

  /*
   * DECLARE MOBILE ELEMENTS (Obligatory)
   */

  //@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText")
  //private AndroidElement spotsInput;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.company.COMPANYSmartBar:id/et_search_spot_name\"]")
  private AndroidElement spotsInput;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ImageView")
  private AndroidElement searchIconButton;

  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
  private AndroidElement backButton;

  @AndroidFindBy(xpath = "//*[@text='Consulting Automation Cafe']")
  private AndroidElement searchConsulting;

  @AndroidFindBy(xpath = "//*[@text='Sorry, no results were found using the search criteria. Please try editing the fields above.']")
  private AndroidElement searchConsultingEmpty;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
  private AndroidElement firstSpotButton;

  @AndroidFindBy(xpath = "//*[@text='Continue']")
  private AndroidElement continueButton;

  @AndroidFindBy(xpath = "//*[@text='RECENT']")
  private AndroidElement recentButton;

  @AndroidFindBy(xpath = "//*[@text='PROXIMATE']")
  private AndroidElement proximateButton;

  @AndroidFindBy(xpath = "//*[@text='FAVORITES']")
  private AndroidElement favoritesButton;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText")
  private AndroidElement allSpotsSearchBar;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText")
  private AndroidElement currentLocationSearchBar;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout[2]/android.widget.TextView[2]")
  private AndroidElement zipCode;

  @AndroidFindBy(xpath = "//*[@text='Sorry, no results were found using the search criteria. Please try editing the fields above.']")
  private AndroidElement spotNotFound;

  @AndroidFindBy(xpath = "//*[@text='Log in to have your recently visited spots stored for faster selection.']")
  private AndroidElement recentSignInLabel;

  @AndroidFindBy(xpath = "//*[@text='Log in to mark your preferred spots as \u201cFavorites\u201d for faster selection.']")
  private AndroidElement favoritesSignInLabel;


  @Override
  public void searchLocation(Boolean qa, String location) throws InterruptedException {
  if (qa) { 
    Actions.sendKeysAndroid(driver, spotsInput, location);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(3000);
    Assert.assertEquals("Consulting Automation Cafe", searchConsulting.getText());
  }  else {
    //Actions.sendKeysAndroid(driver, spotsInput, location);
    Actions.sendKeysAndroid(driver, spotsInput, "Consulting");
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", searchConsultingEmpty.getText());
    }
  }


  @Override
  public void searchLocationWCharacters() throws InterruptedException {
    Actions.sendKeysAndroid(driver, spotsInput, "####");
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", searchConsultingEmpty.getText());
  }


  @Override
  public void searchLocationbyZipcode() throws InterruptedException {
    Actions.sendKeysAndroid(driver, currentLocationSearchBar, "49344");
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.sleep(3000);
    Assert.assertTrue(zipCode.getText().contains("49344"));
    //Assert.assertEquals("Consulting Automation Cafe", searchConsulting.getText());
  }


  @Override
  public void selectTestLocation(String location) throws InterruptedException {
    Actions.sleep(1000);
    Actions.sendKeysAndroid(driver, spotsInput, location);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.sleep(3000);
    Actions.clickElementAndroid(driver, firstSpotButton);
    //Actions.clickElementAndroid(driver, continueButton);
    }


    @Override
  public void searchInvalidSpotCurrentLocation(String location) throws InterruptedException {
    Actions.sendKeysAndroid(driver, currentLocationSearchBar, location);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", spotNotFound.getText());
    }


    @Override
  public void searchInvalidSpotAllSpots(String location) throws InterruptedException {
    Actions.sendKeysAndroid(driver, spotsInput, location);
    ((PressesKey)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    Actions.clickOnCoordinatesAndroid(driver, 983, 2163);
    Actions.sleep(3000);
    Assert.assertEquals("Sorry, no results were found using the search criteria. Please try editing the fields above.", spotNotFound.getText());
    }


    @Override
  public void recentSpots() throws InterruptedException {
    Actions.clickElementAndroid(driver, recentButton);
    Assert.assertEquals("Consulting Automation Cafe", searchConsulting.getText());
    }


    @Override
  public void recentTabasGuest() throws InterruptedException {
    Actions.clickElementAndroid(driver, recentButton);
    Assert.assertEquals("Log in to have your recently visited spots stored for faster selection.", recentSignInLabel.getText());
    }


    @Override
  public void favoritesTabasGuest() throws InterruptedException {
    Actions.clickElementAndroid(driver, favoritesButton);
    Assert.assertEquals("Log in to mark your preferred spots as \u201cFavorites\u201d for faster selection.", favoritesSignInLabel.getText());
    }
}