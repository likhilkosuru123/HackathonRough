package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage  {
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	
	@FindBy(linkText="New Bikes") 
	WebElement new_Bikes_Hover;
	
	@FindBy(xpath="//*[text()='Upcoming Bikes']") 
	WebElement upcoming_Bikes;
	
	
	public void newBikesHover() {
		 Actions act=new Actions(driver);
		act.moveToElement(new_Bikes_Hover).build().perform();
	}
	public void upcomingBikesClick() throws InterruptedException {
		Thread.sleep(2000);
		upcoming_Bikes.click();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
