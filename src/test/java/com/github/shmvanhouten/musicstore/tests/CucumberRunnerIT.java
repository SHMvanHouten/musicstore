package com.github.shmvanhouten.musicstore.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = {"src/features"},
        plugin = {
                "html:target/testreport",
                "json:target/cucumber.json",
                "junit:target/cucumber-results.xml"},
        tags = {"~@workInProgress", "~@additionalBusinessScenario"},
        strict = true,
        monochrome = true)
@RunWith(Cucumber.class)
public class CucumberRunnerIT {

}
