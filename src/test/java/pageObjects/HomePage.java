package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// 1.) Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// 2.) Locators
	@FindBy(xpath = "//li[@class='dropdown']//span[text()='My Account']")
	WebElement myAccountLink;

	@FindBy(xpath = "//li[@class='dropdown open']//a[text()='Register']")
	WebElement registerLink;

	@FindBy(xpath = "//li[@class='dropdown open']//a[text()='Login']")
	WebElement loginLink;

	// 3.) Action Methods
	public void clickOnMyAccount() {
		myAccountLink.click();
	}

	public void clickOnRegister() {
		registerLink.click();
	}

	public void clickOnLogin() {
		loginLink.click();
	}

}
