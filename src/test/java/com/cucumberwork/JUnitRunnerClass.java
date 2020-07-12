package com.cucumberwork;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/com.testcase/features",
		glue="stepDefinition"
		)
public class JUnitRunnerClass
{
	
}
