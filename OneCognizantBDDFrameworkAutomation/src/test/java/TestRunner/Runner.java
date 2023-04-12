package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="FeatureFile",
		glue= {"StepDefinition","CommonStepDef"},
		dryRun=false,
		monochrome=true,
		plugin= {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				//"html:cucumber_report/WebReport"
				},
		tags=  "@TruTime or @ApplyLeave or @cognizantLearn",
		publish = true //we can share the web report
		)

public class Runner {

	

}
