package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.*;


public class Hooks {
	public static WebDriver driver;
	
	
	@BeforeAll
public static void before_all() {
	
	switch("chrome") {
	case "chrome":driver = new ChromeDriver();break;
	case "edge" : driver= new EdgeDriver();break;
	case "firefox": driver = new FirefoxDriver();break;
	default: System.out.println("No valid browser");
						return;
	}
	driver.manage().deleteAllCookies();
	driver.get("https://www.zigwheels.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
	@AfterAll
	public static void after_all() {
		driver.quit();
	}
	
	
	
}
