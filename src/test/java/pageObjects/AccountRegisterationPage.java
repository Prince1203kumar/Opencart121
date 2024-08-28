package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {

	// 1.) Constructor
	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
	}

	// 2.) Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	@FindBy(xpath = "//input[@value='0']")
	WebElement radioSubscribe;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkboxAgree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement msgConfirmation;

	// 3.) Action methods
	public void setFirstName(String first) {
		txtFirstname.sendKeys(first);
	}

	public void setLastName(String last) {
		txtLastname.sendKeys(last);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void setConfirmPassword(String cnfmPass) {
		txtConfirmPassword.sendKeys(cnfmPass);
	}

	public void clickOnRadioSubscribe() {
		radioSubscribe.click();
	}

	public void clickOnchkboxAgree() {
		chkboxAgree.click();
	}

	public void clickOnContinueBtn() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
