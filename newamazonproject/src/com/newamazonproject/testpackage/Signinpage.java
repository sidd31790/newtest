package com.newamazonproject.testpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Signinpage {
	public AndroidDriver driver;
	
	@FindBy(xpath="//*[@text='Skip sign in']")
	public WebElement Signelement;
	
	public Signinpage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Proceed to sign in (skipped signin for test basis)
	public void signclick() {
		Signelement.click();
	}
}
