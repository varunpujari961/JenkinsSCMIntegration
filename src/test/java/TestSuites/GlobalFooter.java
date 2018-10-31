package TestSuites;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.Constants;

public class GlobalFooter extends TestInit {

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	/*@Test(description = "Validating Global Footer OpenAP Logo By Orgaization User")
	public void GlobalFooter_TC_1001() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVURL);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Terms By Orgaization User")
	public void GlobalFooter_TC_1002() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterTerms(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVTerms);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Privacy By Orgaization User")
	public void GlobalFooter_TC_1003() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterPrivacy(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVPrivacy);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer AdChoices By Orgaization User")
	public void GlobalFooter_TC_1004() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterAdChoices(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVAdChoices);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Twitter By Orgaization User")
	public void GlobalFooter_TC_1005() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		commonScenarios.GlobalFooterTwitter(driver);
		Thread.sleep(10000);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVTwitter);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Facebook By Orgaization User")
	public void GlobalFooter_TC_1006() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationUserName"),
				prop.getProperty("UIOrganizationPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		commonScenarios.GlobalFooterFacebook(driver);
		Thread.sleep(10000);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVFacebook);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer OpenAP Logo By Publisher User")
	public void GlobalFooter_TC_1007() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVURL);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Terms By Publisher User")
	public void GlobalFooter_TC_1008() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterTerms(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVTerms);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Privacy By Publisher User")
	public void GlobalFooter_TC_1009() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterPrivacy(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVPrivacy);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer AdChoices By Publisher User")
	public void GlobalFooter_TC_1010() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterAdChoices(driver);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVAdChoices);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Twitter By Publisher User")
	public void GlobalFooter_TC_1011() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		commonScenarios.GlobalFooterTwitter(driver);
		Thread.sleep(10000);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVTwitter);
	}

	// ************************************************************************************************************************************

	// ************************************************************************************************************************************
	@Test(description = "Validating Global Footer Facebook By Publisher User")
	public void GlobalFooter_TC_1012() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.loginOpenAP(driver, prop.getProperty("UIPublisherUserName"),
				prop.getProperty("UIPublisherPassword"));
		commonScenarios.GlobalFooterOpenAPLogo(driver);
		commonScenarios.GlobalFooterFacebook(driver);
		Thread.sleep(10000);
		Assert.assertEquals(validations.validateOpenAPTV(driver), Constants.OpenAPTVFacebook);
	}
}
*/
}