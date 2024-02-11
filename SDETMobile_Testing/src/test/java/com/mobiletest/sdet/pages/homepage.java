package com.mobiletest.sdet.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class homepage {
	AndroidDriver driver;
	By customerName=By.id("com.androidsample.generalstore:id/nameField");
	By nationName=By.xpath("//android.widget.TextView[@text='India']");
	By gender =By.id("com.androidsample.generalstore:id/radioFemale");
	By SelectLoginButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
	public homepage(AndroidDriver driver) {
		this.driver = driver;
	}
	 public void selectOptionByValue() throws InterruptedException {
		 driver.findElement(By.id("android:id/text1")).click();
		 
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		 Thread.sleep(3000);
		 driver.findElement(gender).click();
	    }
	public void addCustomer(String cunName) {
		driver.findElement(customerName).sendKeys(cunName);
		
	}
	public void selectNation(String natNAme) {
		driver.findElement(nationName).sendKeys(natNAme);
	}
	 
	  public void selectGender() {
		  driver.findElement(gender).click();
	  }
	  public void selectButton() throws InterruptedException, MalformedURLException {
		  driver.findElement(SelectLoginButton).click();
		  Thread.sleep(3000);
		  driver.pressKey(new KeyEvent(AndroidKey.HOME));
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	  }
	  
	
	

}
