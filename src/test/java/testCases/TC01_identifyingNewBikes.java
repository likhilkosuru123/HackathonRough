package testCases;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.*;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC01_identifyingNewBikes extends BaseClass {
//	public WebDriver driver;
	List<WebElement> totalBikesList;
	List<WebElement> totalBikesCost;
	List<WebElement> totalBikesMonth;
	
	public static List<String> filteredBikesList = new ArrayList<String>();
	
	public static List<String> fileteredBikesCost = new ArrayList<String>();
	public static List<String> filteredBikesMonth = new ArrayList<String>();
	public static List<Integer>index;
	BasePage nb;
	upcomingBikesPage ubp;
	usedCars uc;
	
	
	
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
	public void manufacturer() throws InterruptedException {
		
		ubp.selectManufacturer();
		
		ubp.readMore();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-400)");
		totalBikesList = ubp.upcomingBikesList();
		totalBikesCost = ubp.upcomingBikesPrice();
		totalBikesMonth = ubp.upcomingBikesMonths();
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
