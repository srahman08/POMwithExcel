package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") WebElement SIGNIN_FIELD;
	
		public void insertUserName(String userName) {
		
		USERNAME_FIELD.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
		
	}
	public void clickOnSignInButton() {
		SIGNIN_FIELD.click();
		
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement Dashboard_Header_Element;

//	public void validateDashboardHeader() {
//		waitForElement(driver, 3, Dashboard_Header_Element);
//		Assert.assertEquals(Dashboard_Header_Element.getText(), "Dashboard", "DashboardHeader not found!!" );
//	}
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement CUSTOMER_TAB;

	public void tearDown() {
		waitForElement(driver, 3, Dashboard_Header_Element);

		driver.close();
		driver.quit();
	}
}
