package TestRunner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", 
				glue = "StepDefinition", 
				tags = "@test",
				dryRun = false,  
				monochrome = true,
						publish = true,
		/*  
		 * plugin = { "pretty", "html:target/CucumberReports/test1 report.html", // 
		 * "json:target/CucumberReports/test report.json", //
		 * "junit:target/CucumberReports/test report.xml" }
		 */
		plugin = { "pretty",
		        // ✅ Extent Report Adapter
		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        // Optional default Cucumber reports
		        "html:target/CucumberReports/HTMLReport.html",
		        "json:target/CucumberReports/JSONReport.json",
		        "junit:target/CucumberReports/XMLReport.xml"}
						 
		)    

public class TestRunnerDFTest extends AbstractTestNGCucumberTests {
	  @Override
	    @DataProvider(parallel = false)   
	  public Object[][] scenarios() {
	        return super.scenarios();
}  
	  }
