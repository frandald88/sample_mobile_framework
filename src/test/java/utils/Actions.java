package utils;

import static org.junit.Assert.fail;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.http.nio.reactor.IOSession;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.Date;
import java.util.HashMap;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import io.appium.java_client.touch.WaitOptions;
import java.time.Duration;

public class Actions {

  /*
   * 
   * REUSABLE FUNCTIONS
   * 
   */

  /*** Constant variables used in the functinons ***/

  static Integer WAIT_SECONDS = 30; // SPECIFY THE MAX TIME THAT THE ELEMEMT WILL BE SEARCHED FOR
  public static int MAX_SLEEP_MS = 10000; // SPECIFY THE MAX OF SECCONDS THAT CAN BE SLEPT (10 SECONDS SO FAR);

  // Fail assert that inticades a test has failed
  public static void failedTest() {
    fail("This test failed");
  }

  // End test IOS
  public static void endTest(AppiumDriver driver) throws InterruptedException {
    driver.closeApp();
    driver.quit();
  }

  // Sleep (milisseconds) function
  public static void sleep(int sleepms) throws InterruptedException {
    if (sleepms > 0 && sleepms < MAX_SLEEP_MS) {
      Thread.sleep(sleepms);
    }
  }

  // Take a screenshot
  public static void takeScreenshot(AppiumDriver driver) {
    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    try {
      FileUtils.copyFile(file, new File(fileName + "screenshot.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Log a message
  public static void logging(String msg) throws InterruptedException {
    System.out.println(msg);
  }

  // Click element IOS
  public static void clickElementIOS(IOSDriver driver, IOSElement element) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    System.out.println("Clicked element " + element);
  }

  // Click element IOS
  public static boolean isElementDisplayedByXpath(IOSDriver driver, String xpath) throws InterruptedException {
    System.out.println("Element " + xpath + "is displayed! ");
    return driver.findElement(By.xpath(xpath)).isDisplayed();
  }

  // Clear Keys IOS
  public static void clearKeysIOS(IOSDriver driver, IOSElement element)
      throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    wait.until(ExpectedConditions.visibilityOf(element)).clear();
    System.out.println("Keys sent to element " + element);
  }

  // Send Keys IOS
  public static void sendKeysIOS(IOSDriver driver, IOSElement element, String keys) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys + "\n");
    System.out.println("Keys sent to element " + element);
  }

  // Send Keys to dropdown IOS
  public static void sendKeysDropdownIOS(IOSDriver driver, IOSElement element, String keys)
      throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    System.out.println("Keys sent to element " + element);
  }

  // Click element Android
  public static void clickElementAndroid(AndroidDriver driver, AndroidElement element) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    System.out.println("Clicked element " + element);
  }

  // Send Keys Android
  public static void sendKeysAndroid(AndroidDriver driver, AndroidElement element, String keys)
      throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    driver.hideKeyboard();
    System.out.println("Keys sent to element " + element);
  }

    public static void sendKeysDropdownAndroid(AndroidDriver driver, AndroidElement element, String keys)
      throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keys);
    System.out.println("Keys sent to element " + element);
  }

  // Clear Keys Android
  public static void clearKeysAndroid(AndroidDriver driver, AndroidElement element)
      throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    wait.until(ExpectedConditions.visibilityOf(element)).clear();
    driver.hideKeyboard();
    System.out.println("Keys sent to element " + element);
  }

  // Scroll to element IOS
  public static void scrollToElementIOS(IOSDriver driver, IOSElement mobileUrlInput) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap scrollObject = new HashMap<>();
    scrollObject.put("predicateString", "value == '" + mobileUrlInput + "'");
    scrollObject.put("direction", "down");
    js.executeScript("mobile: scroll", scrollObject);
    Actions.sleep(1500);
  }

  // Scroll to element Android
  public static void scrollToElementAndroid(AndroidDriver driver, String elementStringValue)
      throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap scrollObject = new HashMap<>();
    scrollObject.put("predicateString", "value == '" + elementStringValue + "'");
    scrollObject.put("direction", "down");
    js.executeScript("mobile: scroll", scrollObject);
    Actions.sleep(2000);
  }

  // Scroll and click to element ios
  public static void scrollAndClickElementIOS(IOSDriver driver, String elementStringValue, IOSElement element)
      throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap scrollObject = new HashMap<>();
    scrollObject.put("predicateString", "value == '" + elementStringValue + "'");
    scrollObject.put("direction", "down");
    js.executeScript("mobile: scroll", scrollObject);
    Actions.sleep(1500);
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
    System.out.println("Scrolled and clicked element " + element);
  }

  // click coordinates on element Android
  public static void clickOnCoordinatesAndroid(AndroidDriver driver, Integer x, Integer y)
      throws InterruptedException {
    TouchAction action = new TouchAction(driver);
    action.press(PointOption.point(x, y)).release().perform();
    System.out.println("Clicked on coordinates x:" + x + " y:" + y);
  }

  // click coordinates on element Android
  public static void clickOnCoordinatesIOS(IOSDriver driver, Integer x, Integer y)
      throws InterruptedException {
    Actions.sleep(2000);
    TouchAction action = new TouchAction(driver);
    action.press(PointOption.point(x, y)).release().perform();
    System.out.println("Clicked on coordinates x:" + x + " y:" + y);
  }

  // Scroll and click to element Android
  public static void scrollAndClickElementAndroid(AndroidDriver driver, String elementStringValue,
      AndroidElement element) throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap scrollObject = new HashMap<>();
    scrollObject.put("predicateString", "value == '" + elementStringValue + "'");
    scrollObject.put("direction", "down");
    js.executeScript("mobile: scroll", scrollObject);
    Actions.sleep(1500);
    WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);
    wait.until(ExpectedConditions.visibilityOf(element)).click();
  }

  public static void scrollDownAndroid(AndroidDriver driver) throws InterruptedException {
    try {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.7);  // Start scrolling at 70% height
        int endY = (int) (size.height * 0.3);    // End scrolling at 30% height
        int startX = size.width / 2;             // Horizontal center

        new TouchAction<>(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))  // Adjust wait time
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();
        
        System.out.println("Scroll performed successfully.");
        Actions.sleep(3000);  // Increased sleep time to allow UI to render
    } catch (Exception e) {
        System.err.println("Scroll action failed: " + e.getMessage());
    }
}

  // click coordinates on element Android
  public static Boolean COMPANYgreaterThanLabelIOS(IOSDriver driver, IOSElement element, Integer number)
      throws InterruptedException {
    String num = element.getAttribute("label").substring(2, 5);
    Double counter = Double.parseDouble(num);
    if (counter <= number) {
      return true;
    } else {
      return false;
    }
  }

   // assert a button is not enabled android
  public static void assertAndroidButtonNotEnabled(AndroidDriver driver, AndroidElement element)
      throws InterruptedException {
    assertFalse("The button is not be enabled", element.isEnabled());
  }

// assert a button is not enabled IOS
    public static void assertIOSButtonNotEnabled(IOSDriver driver, IOSElement element)
      throws InterruptedException {
    assertFalse("The button is not be enabled", element.isEnabled());
  }

  // counter = dolares
  // number = parametro
  // click coordinates on element Android
  public static Boolean COMPANYgreaterThanTextAndroid(AndroidDriver driver, AndroidElement element, Integer number)
      throws InterruptedException {
    String num = element.getAttribute("text").substring(16, 20);
    Double counter = Double.parseDouble(num);
    System.out.println("Tokens : " + num);
    if (counter <= number) {
      return true;
    } else {
      return false;
    }
  }

  public static void point(int i, int j) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'point'");
  }

  // click coordinates on element
  public static void swipeOnCoordinates(IOSDriver driver, Integer x1, Integer y1, Integer x2, Integer y2)
      throws InterruptedException {
    Thread.sleep(2000);
    TouchAction action = new TouchAction(driver);
    action.longPress(PointOption.point(x1, y1))
        .moveTo(PointOption.point(x2, y2))
        .release()
        .perform();
    Thread.sleep(1000);
  }

  public static void swipeOnCoordinates(AndroidDriver driver, Integer x1, Integer y1, Integer x2, Integer y2)
      throws InterruptedException {
    Thread.sleep(2000);
    TouchAction action = new TouchAction(driver);
    action.longPress(PointOption.point(x1, y1))
        .moveTo(PointOption.point(x2, y2))
        .release()
        .perform();
    Thread.sleep(1000);
  }

    public static Boolean isElementPresent(AndroidDriver<AndroidElement> driver, AndroidElement element) {
        try {
            // Try to interact with the element to see if it exists
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

        public static Boolean isElementPresent(IOSDriver<IOSElement> driver, IOSElement element) {
        try {
            // Try to interact with the element to see if it exists
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

        public static void tapElement(IOSElement element) {
        IOSDriver driver = (IOSDriver) element.getWrappedDriver();
        new TouchAction<>(driver)
            .tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
            .perform();
    }

    public static boolean iOSButtonNotEnabled(IOSDriver<IOSElement> driver, IOSElement button) {
    // Logic to check if the button is enabled
    boolean isEnabled = button.isEnabled();
    if (!isEnabled) {
        System.out.println("Button is not enabled.");
    }
    return !isEnabled;
}


}
