package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement CUSTOMER_TAB;
	@FindBy(how = How.XPATH, using = "//a[@href='https://techfios.com/billing/?ng=contacts/add/']")
	WebElement ADD_CUSTOMER;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement ENTER_CUSTOMER_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement SELECT_COMPANY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'Techfios')]")
	WebElement COMPANY_NAME_SELECT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement ENTER_EMAILADDRESS;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement ENTER_PHONENUMBER;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ENTER_STREET_ADDRESS;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement ENTER_CITY;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement ENTER_STATE;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ENTER_ZIPCODE;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_FIELD_LOCATOR;

	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	WebElement GROUPNAME_TAB;

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SELECT_SAVE_BUTTON;

	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a")
	WebElement AUTO_LOGIN_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement CLICK_OK_BUTTON;

	public void clickOnCustomerField() {
		CUSTOMER_TAB.click();
	}

	public void clickAddCustomerField() {
		waitForElement(driver, 3, ADD_CUSTOMER);
		ADD_CUSTOMER.click();
	}

	String enteredNameInTheField;

	public void insertUserName(String userName) {
//		WebDriverWait wait = new WebDriverWait(driver, 3);
		// wait.until(ExpectedConditions.visibilityOf(ENTER_CUSTOMER_NAME));
//		ENTER_CUSTOMER_NAME.sendKeys(userName + genNum);

		waitForElement(driver, 3, ENTER_CUSTOMER_NAME);
		int genNum = randomGenerator(9999);
		enteredNameInTheField = userName + genNum;
		ENTER_CUSTOMER_NAME.sendKeys(enteredNameInTheField);
	}

	public void insertCompanyName(String companyName) {

		selectDropDown(SELECT_COMPANY_DROPDOWN, companyName);
	}

	public void insertEmailAddress(String emailAddress) {
		int genNum = randomGenerator(9999);
		ENTER_EMAILADDRESS.sendKeys(genNum + emailAddress);
	}

	public void insertPhoneNumber(String phoneNumber) {
		int genNum = randomGenerator(9999);

		ENTER_PHONENUMBER.sendKeys(phoneNumber + genNum);
	}

	public void insertStreetAddress(String streetAddress) {
		int genNum = randomGenerator(9999);

		ENTER_STREET_ADDRESS.sendKeys(genNum + " " + streetAddress);
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

	public void verifyEnteredName() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();

			if (name.contains(enteredNameInTheField)) {
				System.out.println("entered name exist");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();

				// driver.switchTo().alert().accept();
			}
		}
	}

	public void clickToDelete() {
////	waitForElement(driver, 3, CLICK_OK_BUTTON);
//		Alert altAlert = driver.switchTo().alert();
//		altAlert.dismiss();
////		
		CLICK_OK_BUTTON.click();

	}

}
