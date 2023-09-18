package com.petSmile.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue="StepDefinition")
public class Runner {
	


}
