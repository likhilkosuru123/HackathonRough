package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class usedCars extends BasePage{

	public usedCars(WebDriver driver) {
		super(driver);	
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="usedcarttlID")
	WebElement titleOfUsedCars;
	@FindBy(xpath="//*[@class='gsc_thin_scroll']/ul/li/label")
	List<WebElement> popular_Models;
	
	@FindBy(xpath="//*[@id='Header']/div/div[1]/div[1]/a/img")
	WebElement zig_Wheels;
	
	public String titleOfUsedCars() {
		return titleOfUsedCars.getText();
	}
	
	public List<String> popularModels() {
		List<String> p_m = new ArrayList<String>();
		int length=popular_Models.size();
		for(int i=0; i<length;i++) {
			
			p_m.add(popular_Models.get(i).getText());
		}
		
		
		
		return p_m;
		
	}
	public void returnToHomePage() {
		zig_Wheels.click();		
	}

}
