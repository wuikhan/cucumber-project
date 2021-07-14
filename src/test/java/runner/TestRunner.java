package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="step",
		monochrome=true,
		dryRun = false,
		plugin= {
				"pretty",
				"json:target/cucumber-json/cucumber.json",
				"html:target/cucumber-html/"
		}
		)
public class TestRunner {
	

}
