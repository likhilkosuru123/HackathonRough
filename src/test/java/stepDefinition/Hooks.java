package stepDefinition;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.*;
import testBase.BaseClass;


public class Hooks {
	public static WebDriver driver;
	public static Properties p;
	
	@BeforeAll
public static void before_all() throws IOException {
	
	FileReader file = new FileReader(".//src/test/resources/config.properties");
	p = new Properties();
	p.load(file);
	switch(p.getProperty("browser")) {
	case "chrome":driver = new ChromeDriver();break;
	case "edge" : driver= new EdgeDriver();break;
	case "firefox": driver = new FirefoxDriver();break;
	default: System.out.println("No valid browser");
						return;
	}
	driver.manage().deleteAllCookies();
	driver.get(p.getProperty("appUrl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
	@AfterStep
	public static void screenshot(Scenario scenario ) {
		TakesScreenshot ts=(TakesScreenshot) driver;
    	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
    	scenario.attach(screenshot, "image/png",scenario.getName());
		
	}
	@AfterAll
	public static void after_all() {
		driver.quit();
	}
	
	
	
}
