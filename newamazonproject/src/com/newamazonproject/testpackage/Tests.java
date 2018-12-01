package com.newamazonproject.testpackage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		AndroidDriver driver;
		// Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723\"");
		URL u = new URL("http://0.0.0.0:4723/wd/hub");
		Thread.sleep(5000);
		
		// Provide device details
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "6bfbeeb9");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		dc.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		
		// Launch App
		while (1>0) {
			try { 
				driver = new AndroidDriver(u,dc);
				break;
			} catch (Exception e) {
			}
		}
		Thread.sleep(1000);
		
		TouchAction action = new TouchAction(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Create object of Signinpage class
		Signinpage sign = new Signinpage(driver);
		sign.signclick();
		Thread.sleep(1000);
		
		// Create object of Homepage class
		Homepage home = new Homepage(driver);
		home.tabclick();
		Thread.sleep(1000);
		home.shopclick();
		Thread.sleep(1000);
		home.subclick();
		Thread.sleep(5000);
		
		// Create object of Itempage class
		Itempage page = new Itempage(driver, wait, action);
		page.kindletap();
		Thread.sleep(5000);
		
		// Create object of Kindlepage class
		Kindlepage kindle = new Kindlepage(driver, wait, action);
		kindle.kindletap();
		Thread.sleep(3000);
		if (kindle.countelement.isDisplayed()){
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
	}
}
