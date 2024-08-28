package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups = { "Sanity", "Master" })
	public void verifyLoginCredentials() {
		logger.info("***** TC_001_LoginTest Started *****");
		logger.debug("This is a log debug log message...");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			logger.info("Clicked on MyAccount link on the same page.. ");
			hp.clickOnLogin();
			logger.info("Clicked on Login Link under MyAccount..");

			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.enterEmail(p.getProperty("email"));
			lp.enterPassword(p.getProperty("password"));
			lp.clickOnLoginBtn();
			logger.info("Clicked on Login Button...");

			MyAccountPage maccPage = new MyAccountPage(driver);
			boolean targetPage = maccPage.isMyAccountPageExists();
			Assert.assertEquals(targetPage, true, "Login Failed");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_002_LoginTest ****");

	}

}
