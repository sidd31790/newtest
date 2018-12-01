package com.newamazonproject.testpackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Kindlepage {
	public AndroidDriver driver;
	public WebDriverWait wait;
	public TouchAction action;
	
	@FindBy(xpath="//*[@text='Qty:']")
	public WebElement countelement;
	
	public Kindlepage(AndroidDriver driver,WebDriverWait wait,TouchAction action) {
		this.driver=driver;
		this.wait=wait;
		this.action=action;
		PageFactory.initElements(driver, this);
	}
	
	public void kindletap() throws Exception {
		while (2>1) {
			int w = driver.manage().window().getSize().getWidth();
			int h = driver.manage().window().getSize().getHeight();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Swipe from bottom to top
			int x = w/2; 
			int y = (int) (h*0.9);
			int temp = (int) (h*0.7);
			while (2>1){
				try {
					countelement.click();
					break;
				} catch(Exception ex){
					action.press(x, y).waitAction(Duration.ofMillis(2000)).moveTo(x, temp).release().perform();
				}
			}
		break;
		}
	}
}
