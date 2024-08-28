package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegisterationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verifyAccountRegisteration() throws InterruptedException {
		String confrmMessage = "";
		logger.info("***** Starting TC_001_AccountRegisterationTest *****");
		logger.debug("This is a log debug log message...");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			logger.info("Clicked on MyAccount Link...");
			hp.clickOnRegister();
			logger.info("Clicked on Register Link...");

			AccountRegisterationPage rp = new AccountRegisterationPage(driver);
			logger.info("Providing Customer details...");
			rp.setFirstName(getRandomStringLiterals().toUpperCase());
			rp.setLastName(getRandomStringLiterals().toUpperCase());
			rp.setEmail((getRandomStringLiterals() + "@gmail.com"));
			rp.setTelephone(getRandomNumericLiterals());
			String password = getRandomAlphaNumericLiterals();
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.clickOnRadioSubscribe();
			rp.clickOnchkboxAgree();
			rp.clickOnContinueBtn();
			// Thread.sleep(5000);
			logger.info("Validating expected message...");
			confrmMessage = rp.getConfirmationMsg();
			logger.info("Test Case Passed...");
			Assert.assertEquals(confrmMessage, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test failed : " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("---------------Finished TC_001_AccountRegisterationTest-------------------------");
		}

	}
}
