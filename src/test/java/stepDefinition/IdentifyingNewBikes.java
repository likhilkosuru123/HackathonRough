package stepDefinition;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObject.login;
import pageObject.BasePage;
import pageObject.upcomingBikesPage;
import pageObject.usedCars;

public class IdentifyingNewBikes {

	public WebDriver driver; 
	Logger logger;
	BasePage nb;
	upcomingBikesPage ubp;
	usedCars uc;
	login lg;
	@Given("the user navigates to zigwheels home page")
	public void the_user_navigates_to_zigwheels_home_page() {
		driver = Hooks.driver;
		driver.get("https://www.zigwheels.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	@When("the user hover on the new Bikes")
	public void the_user_hover_on_the_new_bikes() {
		nb = new BasePage(driver);
		nb.newBikesHover();
	}

	@When("click on upcoming bikes")
	public void click_on_upcoming_bikes() throws InterruptedException {
		nb.upcomingBikesClick();
	}

	@Then("select manufacturur and click on read more")
	public void select_manufacturur_and_click_on_read_more() {
		ubp = new upcomingBikesPage(driver);
		ubp.selectManufacturer();
		ubp.readMore();
	}

	@Then("get all the details of upcoming bikes below four lakhs")
	public void get_all_the_details_of_upcoming_bikes_below_four_lakhs(){
		
		ubp.upcomingBikesList();
	}

	

	



}
