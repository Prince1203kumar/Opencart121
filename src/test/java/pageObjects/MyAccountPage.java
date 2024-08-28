package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// 1.) Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// 2.) Locators
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement linkLogout;

	// 3.) Action Methods
	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		linkLogout.click();
	}

}
