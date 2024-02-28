package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.upcomingBikesPage;
import pageObject.usedCars;
import stepDefinition.Hooks;
import testBase.BaseClass;

public class TC02_usedCars extends BaseClass{
	upcomingBikesPage ubp;
	usedCars uc;
	public static List<String> finalUsedCars = new ArrayList<String>();

	
	@Test(priority=3)
	public void usedCars() throws InterruptedException {
		ubp = new upcomingBikesPage(driver);
		Thread.sleep(1000);
		ubp.usedCarsHover();
		Thread.sleep(1000);
		ubp.chennaiCars();
	}
	@Test(priority=4)
	public void modelNames() throws InterruptedException {
		uc = new usedCars(BaseClass.driver);
		finalUsedCars.add("Popular Models");
		
		finalUsedCars.addAll(uc.popularModels());
		Thread.sleep(2000);
		
		
		
		uc.returnToHomePage();
		System.out.println("method 4 passed");
		
		
	}
}
