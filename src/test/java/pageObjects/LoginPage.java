package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// 1.) Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// 2.) Locators
	@FindBy(xpath = "//*[@name='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//*[@value='Login']")
	WebElement btnLogin;

	// 3.) Action Methods
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickOnLoginBtn() {
		btnLogin.click();
	}

}
