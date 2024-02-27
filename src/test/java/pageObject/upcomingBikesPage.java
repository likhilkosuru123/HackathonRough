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
	
	@FindBy(xpath="//tr[@class='ml-15 ']") 
	List<WebElement> upcoming_Bikes_List;
	
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
	
	public void upcomingBikesList() {
		
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
