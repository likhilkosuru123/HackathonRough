package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class upcomingBikesPage extends  BasePage {

	public  upcomingBikesPage (WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//select[@id='makeId']") 
	WebElement honda_Select;
	
	@FindBy(xpath="//span[contains(text(),'...Read More')]") 
	WebElement read_More;
	
	@FindBy(className="bc-cl")
	public WebElement title;
	
	@FindBy(xpath="//tr[@class='ml-15 ']/td[1]") 
	List<WebElement> upcoming_Bikes_List;
	
	@FindBy(xpath="//tr[@class='ml-15 ']/td[2]") 
	List<WebElement> upcoming_Bikes_Cost;
	
	@FindBy(xpath="//tr[@class='ml-15 ']/td[3]") 
	List<WebElement> upcoming_Bikes_Months;
	
	
	@FindBy(xpath="//a[@class='c-p'][normalize-space()='Used Cars']")
	WebElement used_Cars_Hover;
	
	@FindBy(xpath="//span[contains(text(),'Chennai')][1]")
	WebElement chennai;
	
	
	public void selectManufacturer() {
		Select s = new Select(honda_Select);
		s.selectByValue("53");
	}
	public void readMore() {
		read_More.click();
	}
	
	public List<WebElement> upcomingBikesList() {
		return upcoming_Bikes_List;
	}
	public List<WebElement> upcomingBikesPrice() {
		return upcoming_Bikes_Cost;
	}
	public List<WebElement> upcomingBikesMonths() {
		return upcoming_Bikes_Months;
	}
	
	public String titleOfNewBikes() {
		return title.getText();
	}
	public void usedCarsHover() {
		Actions act=new Actions(driver);
		act.moveToElement(used_Cars_Hover).build().perform();
	}
	
	public void usedCarsHover(WebDriver driver) {
		super.driver=driver;
		Actions act=new Actions(driver);
		act.moveToElement(used_Cars_Hover).build().perform();
	}
	public void chennaiCars() {
		chennai.click();
	}
	
	

}
