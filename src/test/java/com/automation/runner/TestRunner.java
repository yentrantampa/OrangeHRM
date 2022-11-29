package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test//resources//features",
        glue = "com.automation.stepdef",
        tags = "",
        dryRun = false,
        plugin = {"pretty","html:target/report/cucumber-html-report.html", "json:target/report/cucumber.json"}
)
public class TestRunner {

}
