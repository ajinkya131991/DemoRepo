package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/selenium scripts/CucumberToolsQA/src/main/resources/Resources/ToolsQA.feature",
		glue= {"StepDefinitions"}
		)
public class TestRunner 
{
	
}
