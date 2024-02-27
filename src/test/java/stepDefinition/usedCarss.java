package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.login;
import pageObject.upcomingBikesPage;
import pageObject.usedCars;

public class usedCarss {
	upcomingBikesPage ubp;
	usedCars uc;
	login lg;
	@When("the user hovers on used cars")
	public void the_user_hovers_on_used_cars() {
		System.out.print("yo");
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
		uc.popularModels();
}
}
