package stepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	List<WebElement> totalBikesList;
	List<WebElement> totalBikesCost;
	List<WebElement> totalBikesMonth;
	
	public static List<String> filteredBikesList;
	public static List<String> fileteredBikesCost;
	public static List<String> filteredBikesMonth;
	public static List<Integer>index;
	
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
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		ubp.readMore();
	}

	@Then("get all the details of upcoming bikes below four lakhs")
	public void get_all_the_details_of_upcoming_bikes_below_four_lakhs(){
		
		totalBikesList = ubp.upcomingBikesList();
		totalBikesCost = ubp.upcomingBikesPrice();
		totalBikesMonth = ubp.upcomingBikesMonths();
		filteredBikesList=new ArrayList<String>();
		fileteredBikesCost=new ArrayList<String>();
		filteredBikesMonth=new ArrayList<String>();
		index=new ArrayList<Integer>();
		int size=totalBikesCost.size();
		
		for(int i=0; i<size;i++)
		{
			String value= totalBikesCost.get(i).getText().replaceAll("[^0-9]","");
			
			if(Integer.parseInt(value)*1000<400000 && (!totalBikesCost.get(i).getText().contains("crore")))
			{
				
		        index.add(i);
			}
			else if(!totalBikesCost.get(i).getText().contains("Lakh")) {
				index.add(i);
			}
			
		}
		filteredBikesList.add("Upcoming Bikes Model");
		fileteredBikesCost.add("Expected Price");
		filteredBikesMonth.add("Expected Launch Date");
		for(Integer i:index) {
			
				String bikes = totalBikesList.get(i).getText();
				filteredBikesList.add(bikes);
				
				String cost = totalBikesCost.get(i).getText();
				fileteredBikesCost.add(cost);
				
				String month = totalBikesMonth.get(i).getText();
				filteredBikesMonth.add(month);
		}
	}

	

	



}
