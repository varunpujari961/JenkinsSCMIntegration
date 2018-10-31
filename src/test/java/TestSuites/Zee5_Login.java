package TestSuites;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

public class Zee5_Login extends TestInit {

	// ************************************************************************************************************************************

	// *************************************************************************************************************************************
	@Test(description = "Launching Zee5 Application")
	public void FirstTimeLogin_TC_1001() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		Thread.sleep(7000);
		commonScenarios.ClickShows(driver);
		Thread.sleep(7000);
		
		/*commonScenarios.loginOpenAP(driver, prop.getProperty("UIOrganizationFirstTimeUserName"),
				prop.getProperty("UIOrganizationFirstTimePassword"));*/
		
	}

	// ************************************************************************************************************************************

	// *************************************************************************************************************************************
}