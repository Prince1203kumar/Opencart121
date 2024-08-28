package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verify_loginDDT(String email, String pwd, String expResult) {
		logger.info("***** Started TC_003_LoginDDT ******");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			logger.info("Clicked on MyAccount link on the same page.. ");
			hp.clickOnLogin();
			logger.info("Clicked on Login Link under MyAccount..");

			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.enterEmail(email);
			lp.enterPassword(pwd);
			lp.clickOnLoginBtn();
			logger.info("Clicked on Login Button...");

			MyAccountPage maccPage = new MyAccountPage(driver);
			boolean targetPage = maccPage.isMyAccountPageExists();

			if (expResult.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					maccPage.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
			if (expResult.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					maccPage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		} finally {
			logger.info("---------------Finished TC_003_LoginDDT -------------------");
		}
	}
}
