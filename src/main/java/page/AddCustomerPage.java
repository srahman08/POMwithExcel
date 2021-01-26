package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage{

	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement CUSTOMER_TAB;
	@FindBy(how = How.XPATH, using = "//a[@href='https://techfios.com/billing/?ng=contacts/add/']") WebElement ADD_CUSTOMER;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement ENTER_CUSTOMER_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement SELECT_COMPANY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'Techfios')]") WebElement COMPANY_NAME_SELECT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement ENTER_EMAILADDRESS;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement ENTER_PHONENUMBER;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ENTER_STREET_ADDRESS;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement ENTER_CITY;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement ENTER_STATE;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement ENTER_ZIPCODE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]") WebElement COUNTRY_FIELD_LOCATOR;

	
	@FindBy(how = How.XPATH, using = "//select[@id='group']") WebElement GROUPNAME_TAB;
	
	
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement SELECT_SAVE_BUTTON;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a") WebElement AUTO_LOGIN_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_FIELD_LOCATOR;
	
	public void clickOnCustomerField() {
		CUSTOMER_TAB.click();
	}
	public void clickAddCustomerField() {
		waitForElement(driver, 3, ADD_CUSTOMER);
		ADD_CUSTOMER.click();
		}
	public void insertUserName(String userName) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(ENTER_CUSTOMER_NAME));
		int genNum = randomGenerator(9999);
		ENTER_CUSTOMER_NAME.sendKeys(userName + genNum);
	}
	public void insertCompanyName(String companyName) {
		
		selectDropDown(SELECT_COMPANY_DROPDOWN, companyName);
	}
	
	public void insertEmailAddress(String emailAddress) {
		int genNum = randomGenerator(9999);
		ENTER_EMAILADDRESS.sendKeys(genNum+emailAddress);
	}
	public void insertPhoneNumber(String phoneNumber) {
		int genNum = randomGenerator(9999);

		ENTER_PHONENUMBER.sendKeys(phoneNumber+ genNum);
	}
	public void insertStreetAddress(String streetAddress) {
		int genNum = randomGenerator(9999);

		ENTER_STREET_ADDRESS.sendKeys(genNum + " "+streetAddress);
	}
	public void insertCity(String cityName) {
		ENTER_CITY.sendKeys(cityName);
	}
	
	public void insertState(String stateName) {
		ENTER_STATE.sendKeys(stateName);
	}
	public void insertZip(String zipCode) {
		ENTER_ZIPCODE.sendKeys(zipCode);
	}
	public void enterCountryName(String countryName) {
		selectDropDown(COUNTRY_FIELD_LOCATOR, countryName);
	}
	
public void selectGroupName(String groupName) {
		
		selectDropDown(GROUPNAME_TAB, groupName);
	}
	
	public void clickToSave() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(SELECT_SAVE_BUTTON));
		SELECT_SAVE_BUTTON.click();
	}

	public void clickOnListCustomerButton() {
		waitForElement(driver, 10, AUTO_LOGIN_BUTTON_LOCATOR);
		LIST_CUSTOMER_FIELD_LOCATOR.click();
	}
	
	public void clickOnList() {
		waitForElement(driver, 3, LIST_CUSTOMER_FIELD_LOCATOR);

		LIST_CUSTOMER_FIELD_LOCATOR.click();
		
	}
	
	
}
