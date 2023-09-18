package com.petSmile.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/IngresoDeAgenda.feature", glue="com.petSmile.StepDefinition3")
public class Runner3 {
	


}
