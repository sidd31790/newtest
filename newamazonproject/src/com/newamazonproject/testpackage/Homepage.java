package com.newamazonproject.testpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Homepage {
	public AndroidDriver driver;
	
	@FindBy(xpath="//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']")
	public WebElement tabelement;
	
	@FindBy(xpath="//*[@text='Shop by Department']")
	public WebElement shopelement;
	
	@FindBy(xpath="//*[@text='Electronics']")
	public WebElement subelement;
	
	public Homepage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Tapping Main menu 
	public void tabclick() {
		tabelement.click();
	}
	// Tapping Shop by Department
	public void shopclick() {
		shopelement.click();
	}
	// Tapping Electronics within Shop by Department
	public void subclick() {
		subelement.click();
	}
	
}
