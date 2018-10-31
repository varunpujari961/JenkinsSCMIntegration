package ObjectsRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {
	WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//*[@id='name3']")
	public WebElement btn_ZeeLogin;
	
	@FindBy(xpath = "//*[contains(@class,'name1')]")
	public static WebElement btn_Shows;
	
	@FindBy(xpath = "//*[contains(@class,'thumbnail-image')]")
	public static WebElement btn_tvwatch;
	
	@FindBy(xpath = "//*[contains(@class,'prevEpisode')]")
	public WebElement lbl_PreviousEpisode;
	
	@FindBy(xpath = "//*[@id='body']/app-root/div[2]/app-common-landing-screen/div[1]/app-carousel/div/div/div/img[2]")
	public static WebElement btn_NextCarousel;
	
	@FindBy(xpath = "//*[contains(@class,'titleoneepisode ng-star-inserted')]")
	public WebElement lbl_LatestEpisode;
	
	
	
	
	
	
	
}