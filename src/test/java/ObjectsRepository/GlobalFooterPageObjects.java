package ObjectsRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalFooterPageObjects {

	WebDriver driver;

	public GlobalFooterPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "/html/body/openap-root/openap-global-footer/footer/div/div/a/img")
	public WebElement lbl_GlobalFooterLogo;

	@FindBy(xpath = "//a[@href='http://www.openap.tv/terms']")
	public WebElement lnk_Terms;

	@FindBy(xpath = "//a[@href='http://www.openap.tv/privacy/']")
	public WebElement lnk_Privacy;

	@FindBy(xpath = "//a[@href='http://www.openap.tv/ad-choices/']")
	public WebElement lnk_AdChoices;

	@FindBy(xpath = "//a[@href='https://twitter.com/OpenApTV/']")
	public WebElement lnk_Twitter;

	@FindBy(xpath = "//a[@href='https://www.facebook.com/OpenAPTV/']")
	public WebElement lnk_Facebook;

	@FindBy(xpath = "//a[@href='http://www.openap.tv']")
	public WebElement lnk_Home;

}
