package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeaturesFile/bikes.feature"},
		
		glue="stepDefinition",
		plugin= {"pretty", "html:reports/myreport.html", 
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
public class testRun {

}
