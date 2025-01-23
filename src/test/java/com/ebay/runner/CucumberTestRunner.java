



package com.ebay.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;





@RunWith(Cucumber.class)  
@CucumberOptions(features = "src/test/resources/features", glue = "com.ebay.stepdefinitions", tags="@login",plugin = {"pretty"})
public class CucumberTestRunner {
	

}
	
	
	
