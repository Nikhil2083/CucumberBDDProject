package TestRunner;

import io.cucumber.testng.CucumberOptions;
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
		/*
		 * plugin = { "pretty", "html:target/CucumberReports/test1 report.html", //
		 * "json:target/CucumberReports/test report.json", //
		 * "junit:target/CucumberReports/test report.xml" }
		 */
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunnerDFTest extends AbstractTestNGCucumberTests {

}
