package stepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.login;
import pageObject.upcomingBikesPage;
import pageObject.usedCars;
import utilities.ExcelUtility;

public class usedCarss {
	upcomingBikesPage ubp;
	public static List<String> finalUsedCars;
	usedCars uc;
	login lg;
	@When("the user hovers on used cars")
	public void the_user_hovers_on_used_cars() {
		
		ubp = new upcomingBikesPage(Hooks.driver);
		ubp.usedCarsHover();
	}

	@When("clicked on chennai")
	public void clicked_on_chennai() {
		ubp.chennaiCars();
	}

	@Then("get the popular models of the cars")
	public void get_the_popular_models_of_the_cars() {
		uc = new usedCars(Hooks.driver);
		finalUsedCars =new ArrayList<String>();
		finalUsedCars.add("Popular Models");
		finalUsedCars.addAll(uc.popularModels());
	}
	
}

