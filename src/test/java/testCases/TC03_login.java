package testCases;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import pageObject.login;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC03_login extends BaseClass {
	login lg;
	
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
	@Test(priority=6)
	public void output() throws IOException {
		ExcelUtility.excelOutput(TC01_identifyingNewBikes.filteredBikesList,TC01_identifyingNewBikes.fileteredBikesCost, TC01_identifyingNewBikes.filteredBikesMonth,  TC02_usedCars.finalUsedCars);

	}
}
