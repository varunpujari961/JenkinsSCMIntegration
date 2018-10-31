package TestSuites;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPage extends TestInit {

	// ************************************************************************************************************************************

	// *************************************************************************************************************************************
	@Test(description = "Launching Zee5 Application and Playing Video from Tv Shows")
	public void LaunchingZee5ApplicationAndPlayingVideoFromTvShows_TC_609() throws InterruptedException, IOException, AWTException {
		utils.launchApp(prop.getProperty("ApplicationURL"), driver);
		commonScenarios.ClickShows(driver);
		//commonScenarios.NextCarousel(driver);
		//Thread.sleep(6000);
		commonScenarios.WatchButtonTvShows(driver);
		Assert.assertTrue(validations.ValidatePreviousEpisode_Display(driver));
		Assert.assertTrue(validations.ValidateLatestEpisode_Display(driver));
		driver.navigate().back();
		Thread.sleep(5000);
		
	
		
	}

	// ************************************************************************************************************************************

	// *************************************************************************************************************************************

}