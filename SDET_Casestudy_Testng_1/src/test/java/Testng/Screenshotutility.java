package Testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutility {
	public void captureScreenshot(WebDriver driver , String tName) throws IOException {


		TakesScreenshot ts = (TakesScreenshot) driver;


		File src = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/screenshots/" +tName+".png");
		FileUtils.copyFile(src, Target);
	


}

}
