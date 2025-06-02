package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import runner.Test_Runner;

public class Hooks {
		
	@Before
	public void setup()
	{
		Browser_Helper.initializeDriver(Test_Runner.browser);
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException
	{
		if (scenario.isFailed() == true)
		  {
			TakesScreenshot takesScreenshot = (TakesScreenshot) Browser_Helper.getDriver();
			File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String screenshotName = scenario.getName().replace(" ", "_") + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
		
			File screenshotRelativeDirectory = new File("Screenshots");
			String screenshotAbsoluteDirectoryPath = screenshotRelativeDirectory.getAbsolutePath();
			File screenshotDirectory = new File(screenshotAbsoluteDirectoryPath);
			
			if(!screenshotDirectory.exists())
			{
				screenshotDirectory.mkdir();
			}
						
			Path screenshotFullPath = Paths.get(screenshotAbsoluteDirectoryPath, screenshotName);
			File destScreenshot = new File(screenshotFullPath.toString());
			Files.copy(screenshot, destScreenshot);
		  }
	}
	
	@After
	public void teardown()
	{
		Browser_Helper.quitDriver();
	}
}