package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {

    public static void main(String[] args) {

        AppiumDriver<MobileElement> driver = null;

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "ZY2245MJ5J"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("appPackage", "com.android.vending");
        caps.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
        caps.setCapability("noReset", "true");

        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
//Added 5 seconds wait so that the app loads completely before starting with element identification
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Find Google Play element using ID property and click on it
        driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();

        //Find 'Google Play Store' element and set the value Google
        driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys("Google");

        //Press Enter key from Keyboard using any of the below methods
        //((AndroidDriver<MobileElement>) driver).pressKey(66);
        //OR
        //The below code might now work for you, as some keyboards use Search button instead of ENTER. Hence,
        // there are chances that the below line would fail on specific devices
        driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys(Keys.ENTER);


        }

 }