package Mobile.SDETMobile_Testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
 public AndroidDriver driver;

	@BeforeClass
	public void AppiumApplication() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");

		caps.setCapability("deviceName", "SivaMobile");

		caps.setCapability("appPackage",
				"C:\\Users\\Siva\\eclipse-workspace\\SDET_Capstone\\SDETMobile_Testing\\SDETMobile_Testing\\Resources\\General-Store.apk");																												// na
		caps.setCapability("appActivity", ".MainActivity"); // Replace with your app's main activity
		caps.setCapability("automationName", "UiAutomator2");

		try {

			// Initialize the driver

			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("BharatMobile");
			options.setApp(
					"C:\\Users\\Siva\\eclipse-workspace\\SDET_Capstone\\SDETMobile_Testing\\SDETMobile_Testing\\Resources\\General-Store.apk");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			Thread.sleep(3000);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
