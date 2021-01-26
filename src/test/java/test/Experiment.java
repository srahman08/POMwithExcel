package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.BasePage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class Experiment extends BasePage{

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

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		
		addCustomerPage.clickOnCustomerField();
		addCustomerPage.clickOnList();

		
		
		addCustomerPage.clickOnListCustomerButton();
		

	}

}
