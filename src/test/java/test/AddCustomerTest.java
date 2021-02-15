package test;

import org.apache.commons.exec.DaemonExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	ExcelReader excelread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = excelread.getCellData("LoginInfo", "UserName", 2);
	String password = excelread.getCellData("LoginInfo", "Password", 2);
	
	String fullName = excelread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = excelread.getCellData("AddContactInfo", "CompanyName", 2);
	String emailAddress = excelread.getCellData("AddContactInfo", "Email", 2);
	String phoneNumber = excelread.getCellData("AddContactInfo", "Phone", 2);
	String address = excelread.getCellData("AddContactInfo", "Address", 2);
	String city = excelread.getCellData("AddContactInfo", "City", 2);
	String country = excelread.getCellData("AddContactInfo", "Country", 2);
	String state = excelread.getCellData("AddContactInfo", "State", 2);
	String zipCode = excelread.getCellData("AddContactInfo", "Zip", 2);
	
	
	@Test
	public void addUserAndCreateProfile() {
	
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashBoardPage dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		dashboardPage.validateDashboardHeader();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickOnCustomerField();
		addCustomerPage.clickAddCustomerField();
		
		addCustomerPage.insertUserName(fullName);
		addCustomerPage.insertCompanyName(companyName);
		addCustomerPage.insertEmailAddress(emailAddress);
		addCustomerPage.insertPhoneNumber(phoneNumber);
		addCustomerPage.insertStreetAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zipCode);
		addCustomerPage.enterCountryName(country);
		addCustomerPage.selectGroupName("AUG 2020");
		addCustomerPage.clickToSave();
		addCustomerPage.clickOnListCustomerButton();
		addCustomerPage.verifyEnteredName();
		//addCustomerPage.clickToDelete();
		
	}
	
	
	
	

}
