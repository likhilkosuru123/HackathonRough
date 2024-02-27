package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login extends BasePage{
	
	public login(WebDriver driver) {
		super(driver);		
	}
	
	
	@FindBy(xpath="//div[@id='forum_login_wrap_lg']")
	WebElement login_Or_Sign_Up;
	
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement google_Login;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement input;
	
	@FindBy(xpath="//*[@class='VfPpkd-vQzf8d'][text()='Next']")
	WebElement next;
	
	@FindBy(id="ca")
	WebElement captcha;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement error_Message;
	
	public void loginSignUp() {
		login_Or_Sign_Up.click();
	}
	public void google() {
		google_Login.click();
	}
	public void email(String email) throws InterruptedException {
		input.sendKeys(email);
		next.click();
		if(captcha.isDisplayed()){
			Thread.sleep(10000);
		}
	}
	public String errorMessage() {
		return error_Message.getText();
	}
	
	
	
	

}
