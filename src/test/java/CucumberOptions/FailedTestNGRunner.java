package CucumberOptions;

	
	
	

	import org.testng.annotations.DataProvider;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features="@target/failed_scenarios.txt",glue="stepDefinitions",monochrome=true, tags="@AddQuantity", 
	plugin= {
			"html:target/cucumber.html",
			"json:target/cucumber.json"
			,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			,"rerun:target/aailedscenarios"
			})

	public class FailedTestNGRunner extends AbstractTestNGCucumberTests {
		
		
		// Parallel execution
		
		@Override
		@DataProvider(parallel=true)
		
		public Object[][] scenarios(){
			
			return  super.scenarios();

		}
		
		


}
