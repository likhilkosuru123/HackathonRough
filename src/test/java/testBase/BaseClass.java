package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver; 
	public Logger logger;
	Properties p;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void setup(String browser, String url) throws IOException {
		
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p= new Properties();
		p.load(file);
		
		logger =LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase()) {
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
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
