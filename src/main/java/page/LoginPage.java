package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
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
}
