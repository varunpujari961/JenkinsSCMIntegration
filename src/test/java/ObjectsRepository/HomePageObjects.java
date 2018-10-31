package ObjectsRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@FindBy(xpath = "//span[@class='user-button']")
	public WebElement lbl_LogedinUserName;

	@FindBy(xpath = "//button[text()='Logout']")
	public WebElement btn_Logout;

	@FindBy(xpath = "//button[text()='+ Add Segment']")
	public WebElement btn_AddSegment;

	@FindBy(xpath = "//a[text()='MY POSTS']")
	public WebElement lnk_MyPosts;

	@FindBy(xpath = "//a[text()='Shared With Me']")
	public WebElement lnk_SharedWithMe;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-run-post right my-segment-run-post btn-post-hover']")
	public WebElement btn_RunPost;

	@FindBy(xpath = "//a[text()='All Segments']")
	public WebElement lnk_AllSegments;

	@FindBy(xpath = "//a[text()='Owned By Me']")
	public WebElement lnk_OwnedByMe;

	@FindBy(xpath = "//input[@class='searchTextBox']")
	public WebElement txt_searchTextBox;

	@FindBy(xpath = "//a[text()='Edit']")
	public WebElement btn_Edit;

	@FindBy(xpath = "//a[text()='Share']")
	public WebElement btn_Share;
	
	@FindBy(xpath = "//a[text()='View']")
	public WebElement btn_View;
	
	@FindBy(xpath = "//a[@class='btn btn-primary segment-button'][text()='Refresh']")
	public WebElement btn_Refresh;
	
	@FindBy(xpath = "//table[@class='table table-responsive segment-table']//tr[1]//div//a")
	public List<WebElement> btn_segmentButton;
	
	@FindBy(xpath = "//*[@class = 'duplicate icon-duplicate']")
	public WebElement btn_Clone;
	
	@FindBy(xpath = "//span[@class='segment-info']")
	public List<WebElement> list_searchResults; 	
	
	@FindBy(xpath = "//*[@class = 'duplicate icon-duplicate']")
	public List<WebElement> list_btn_Clone;
	
	@FindBy(xpath = "//a[text()='MY SEGMENTS']")
	public WebElement lnk_MySegments;
	
}
