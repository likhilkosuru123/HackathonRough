package stepDefinition;

import java.util.Set;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.login;
import pageObject.upcomingBikesPage;
import pageObject.usedCars;

public class logins {
	upcomingBikesPage ubp;
	usedCars uc;
	login lg;
	@When("the user clicks on zigwheels logo")
	public void the_user_clicks_on_zigwheels_logo() {
		System.out.println("yo");
		uc = new usedCars(Hooks.driver);
		uc.returnToHomePage();
	}

	@When("the user clicks on login")
	public void the_user_clicks_on_login() {
		lg=new login(Hooks.driver);
		lg.loginSignUp();
	}

	@When("the user clicks on google")
	public void the_user_clicks_on_google() {
		lg.google();
	}

	@Then("enter the wrong email and gets the error message")
	public void enter_the_wrong_email_and_gets_the_error_message() throws InterruptedException {
		Set<String> winodws = Hooks.driver.getWindowHandles();
		for(String s:winodws) {
			if(s.equals(Hooks.driver.getWindowHandle())) {
				
			}else {
					Hooks.driver.switchTo().window(s);
			}
		}
		lg.email("abc@gmail.com");
		System.out.println(lg.errorMessage());
	}
}
