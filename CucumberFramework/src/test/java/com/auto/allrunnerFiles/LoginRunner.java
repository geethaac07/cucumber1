package com.auto.allrunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/loginFeatures.feature"},
		glue = {"com.auto.alldefinitionFiles"},
		dryRun = false
		)
public class LoginRunner extends AbstractTestNGCucumberTests{

}
