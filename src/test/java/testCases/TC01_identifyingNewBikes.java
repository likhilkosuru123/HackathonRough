package testCases;



import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.*;
import testBase.BaseClass;

public class TC01_identifyingNewBikes extends BaseClass {
//	public WebDriver driver;
	
	BasePage nb;
	upcomingBikesPage ubp;
	usedCars uc;
	login lg;
	
	
	@Test(priority=1)
	public void upcomingBikesInIndia() throws InterruptedException {
		logger.info("******Starting the execution*****");
		
		nb = new BasePage(driver);
		nb.newBikesHover();
		logger.info("Hovered on new bikes");
		nb.upcomingBikesClick();
		logger.info("Clicked on upcoming bikes");
		ubp = new upcomingBikesPage(driver);
		System.out.println("method 1 passed");
		Assert.assertEquals(ubp.titleOfNewBikes(), "Upcoming Bikes");
		
	}
	@Test(priority=2)
	public void manufacturur() {
		
		ubp.selectManufacturer();
		ubp.readMore();
		ubp.upcomingBikesList();
		System.out.println("method 2 passed");
		
	}
	@Test(priority=3)
	public void usedCars() {
		ubp.usedCarsHover();
		ubp.chennaiCars();
		uc = new usedCars(driver);
		System.out.println("method 3 passed");
		System.out.println(uc.titleOfUsedCars());
		Assert.assertEquals(uc.titleOfUsedCars(), "Used Cars in Chennai");
	}
	@Test(priority=4)
	public void modelNames() {
		uc.popularModels();
		uc.returnToHomePage();
		System.out.println("method 4 passed");
		
		
	}
	@Test(priority=5)
	public void googleLogin() throws InterruptedException {
		lg=new login(driver);
		lg.loginSignUp();
		lg.google();
		Set<String> winodws = driver.getWindowHandles();
		for(String s:winodws) {
			if(s.equals(driver.getWindowHandle())) {
				
			}else {
					driver.switchTo().window(s);
			}
		}
		lg.email("abc@gmail.com");
		System.out.println(lg.errorMessage());
		System.out.println("method 5 passed");
		
	}
}
