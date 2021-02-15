package test;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	ExcelReader excelread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = excelread.getCellData("LoginInfo", "UserName", 2);
	String password = excelread.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserLogin() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = new PageFactory().initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		loginPage.tearDown();
		
	}
	
	
	
}
