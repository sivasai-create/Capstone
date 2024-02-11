package Testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Saucedemo3 extends Screenshotutility {
	WebDriver driver;
	
	

	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeMethod
	public void navigateUrl() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

	@Test
	@Parameters({ "username", "password" })
	public void validcredinals(String username, String password) throws InterruptedException, IOException {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		captureScreenshot(driver, "validcredinals");
	
		Assert.assertNotEquals(url, "https://www.saucedemo.com/");
	}
		

	@Test
	@Parameters({ "invaliduser", "invalidpassword" })
	public void invalidcredinals(String invaliduser, String invalidpassword) throws InterruptedException, IOException {
		driver.findElement(By.id("user-name")).sendKeys(invaliduser);
		driver.findElement(By.id("password")).sendKeys(invalidpassword);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();
		captureScreenshot(driver, "invalidcredinals");
	
		Assert.assertNotEquals(url, "https://www.saucedemo.com/");


	}
}
