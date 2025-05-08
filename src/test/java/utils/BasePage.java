package utils;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// Base page that will be used in all pages
public class BasePage{
  protected AndroidDriver driver;
  protected IOSDriver driverIOS;

  public BasePage(AndroidDriver driver){
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }
  public BasePage(IOSDriver driver){
    this.driverIOS = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

}