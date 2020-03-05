package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports", "pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports"},
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@Smoke"
)
public class CukesRunner {

}
