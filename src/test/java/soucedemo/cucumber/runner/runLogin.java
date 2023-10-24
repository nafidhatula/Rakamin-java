package soucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/java/soucedemo/cucumber/features",
        glue = "soucedemo/cucumber/stepDef",
        plugin = ("html:target/HTML_report.html"),
        tags = "@TDD"
)

public class runLogin {
}