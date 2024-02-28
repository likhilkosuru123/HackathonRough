package stepDefinition;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.login;
import pageObject.upcomingBikesPage;
import pageObject.usedCars;
import utilities.ExcelUtility;

public class logins {
	upcomingBikesPage ubp;
	usedCars uc;
	login lg;
	@When("the user clicks on zigwheels logo")
	public void the_user_clicks_on_zigwheels_logo() {
		
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
	@Then("send data to the excel")
	public void send_data_to_the_excel() throws IOException {
		FileOutputStream fp=new FileOutputStream(System.getProperty("user.dir")+"\\output\\output.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("New Bike Details");		
		int row=0;
		for(int i=0;i<IdentifyingNewBikes.filteredBikesList.size();i++) {
				XSSFRow rows=sheet.createRow(row);			
				rows.createCell(0).setCellValue(IdentifyingNewBikes.filteredBikesList.get(i));
				rows.createCell(1).setCellValue(IdentifyingNewBikes.fileteredBikesCost.get(i));
				rows.createCell(2).setCellValue(IdentifyingNewBikes.filteredBikesMonth.get(i));
				row+=1;

		}
		XSSFSheet sheet2=wb.createSheet("Popular Used Cars");
		for(int i=0;i<usedCarss.finalUsedCars.size();i++) {
				XSSFRow rows=sheet2.createRow(i);			
				rows.createCell(0).setCellValue(usedCarss.finalUsedCars.get(i));				
		}

		wb.write(fp);
		wb.close();
		fp.close();
	
	}
}
