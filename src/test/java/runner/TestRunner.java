package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = {
		"com.stepDefination" }, monochrome = true, plugin = { "pretty", 
				"html:target/htmlReports/htmlReport.html",
				"json:target/jsonReports/jsonReport.json",
				"junit:target/junitReports/junitReport.xml" }
//tags = "@SmokeTest", "@RegressionTest", "@HotFixTest"
		//,tags = "@SmokeTest"
)

public class TestRunner {

	@AfterClass
	public static void generateExtendReport() {
		System.out.println("printing after tags....");
	}

}
