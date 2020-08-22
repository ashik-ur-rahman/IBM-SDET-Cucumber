package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/Features",
		glue = {"stepDefinitions"},
		tags = {"@SuiteCRM"},
		strict= true,
		plugin = {"html: testReports"}
		)

public class ActivitiesRunner {

}
