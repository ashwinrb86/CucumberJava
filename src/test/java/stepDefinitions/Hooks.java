package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	

	
TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		
	}
	
	
	@After
	public void AfterScenario() {
		
		testContextSetup.driver.quit();
		
	}
	
	

	@AfterStep
	public void TakeScreenshot(Scenario scenario) throws IOException {
		
		
		if (scenario.isFailed())
		{
			TakesScreenshot screenshot = (TakesScreenshot) testContextSetup.driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			
			scenario.attach(FileUtils.readFileToByteArray(sourceFile), "image/png", "image");
			
		}
		
	}
	
	
	

}
