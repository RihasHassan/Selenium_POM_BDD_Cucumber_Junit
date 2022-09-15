package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class) 
@CucumberOptions(features="./src/main/java/FeaturesFiles",
glue={"StepDefinitions"},

dryRun=false,
monochrome = true,


plugin = { "pretty", "html:target/reports"}


		
		
		
		
		)


public class TestRunner {
	
	

}
