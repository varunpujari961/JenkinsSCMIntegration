package CommonMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectsRepository.*;
import Utilities.*;


public class CommonScenarios {
	Utilities util = new Utilities();
	DriverActions actions = new DriverActions();

	@SuppressWarnings("static-access")
	public void ClickShows(WebDriver driver)
			throws InterruptedException, AWTException {
		LandingPageObjects landingPageObjects = new LandingPageObjects(driver);
		waitTillElementPresent(driver, LandingPageObjects.btn_Shows);
		LandingPageObjects.btn_Shows.click();
		waitTillElementPresent(driver, landingPageObjects.btn_Shows);
		//waitTillElementPresent(driver, landingPageObjects.btn_ZeeLogin);
	}
		
	    public void WatchButtonTvShows(WebDriver driver)
		throws InterruptedException, AWTException {
	    new LandingPageObjects(driver);
	    waitTillElementPresent(driver, LandingPageObjects.btn_tvwatch);
	    LandingPageObjects.btn_tvwatch.click();
	    Thread.sleep(12000);
	    }
	    
	    public void NextCarousel(WebDriver driver)
	    throws InterruptedException, AWTException {
	    new LandingPageObjects(driver);
	    //waitTillElementPresent(driver, LandingPageObjects.btn_tvwatch);
	    LandingPageObjects.btn_NextCarousel.click();
	    //Thread.sleep(12000);
		
			
		
		
		/*landingPageObjects.txt_EmailAddress.sendKeys(UserName);
		landingPageObjects.txt_Password.sendKeys(Password);
		landingPageObjects.btn_SignIn.click();*/
		Thread.sleep(5000);
	}
	
	public void waitTillElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
	
/*
	public void logOut(WebDriver driver) {
		HomePageObjects HomePageObjects = new HomePageObjects(driver);
		HomePageObjects.btn_Logout.click();
	}



	public void selectDataSourceGroup(WebDriver driver, String segmentName, String DataSource,
			String... ComScoreTagID) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		waitTillElementPresent(driver, homePage.btn_AddSegment);
		homePage.btn_AddSegment.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver, createsegment.txt_NameYourSegment);
		createsegment.txt_NameYourSegment.sendKeys(segmentName);
		waitTillElementPresent(driver, createsegment.ddl_SelectSource);
		createsegment.ddl_SelectSource.click();
		Thread.sleep(1000);
		switch (DataSource) {
		case "COMSCORE":
			actions.driverClick(driver, createsegment.list_Comscore);
//			createsegment.list_Comscore.click();
			break;
		case "TAG":
			actions.driverClick(driver, createsegment.list_ComscoreTag);
//			createsegment.list_ComscoreTag.click();
			createsegment.txt_ComscoreTag.sendKeys(ComScoreTagID);	
			break;
		case "Nielsen_MRI":
			actions.driverClick(driver, createsegment.list_Nielsen_MRI);
//			createsegment.list_Nielsen_MRI.click();
			break;
		case "Nielsen_NCS":
			actions.driverClick(driver, createsegment.list_Nielsen_NCS);
//			createsegment.list_Nielsen_NCS.click();
			break;
		case "Nielsen_NBI":
			actions.driverClick(driver, createsegment.list_Nielsen_NBI);
//			createsegment.list_Nielsen_NBI.click();
			break;
		case "NIELSEN_FUSION":
			actions.driverClick(driver, createsegment.list_NIELSEN_FUSION);
//			createsegment.list_NIELSEN_FUSION.click();
			break;			
		}
	}
		
	
	public void viewDataSourceGroupList(WebDriver driver, String segmentName) {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_AddSegment.click();
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		createsegment.txt_NameYourSegment.sendKeys(segmentName);
		createsegment.ddl_SelectSource.click();
	}

	public void searchAndSelectSegmentParameter(WebDriver driver, String SearchText) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.txt_SearchforParameters));
		createsegment.txt_SearchforParameters.sendKeys(SearchText);
//		util.scroll(driver, 60);
		Thread.sleep(2000);
		createsegment.selectParameter(driver);
	}

	public void StartAgain(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.lnk_StartAgain));
		createsegment.lnk_StartAgain.click();
	}
	
	public void addParameter(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_AddParamaeter));
		createsegment.btn_AddParamaeter.click();
	}

	public void AddParameter_MultipleQuery_Search(WebDriver driver, String SearchText2) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		//util.scroll(driver, "DOWN");
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_AddParamaeter));
		actions.driverClick(driver, createsegment.btn_AddParamaeter);
//		createsegment.btn_AddParamaeter.click();
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.txt_SearchforParameters));
		createsegment.txt_SearchforParameters.sendKeys(SearchText2);
		Thread.sleep(2000);
		createsegment.selectParameter(driver);
	}

	public void AddParameter_AddDuplicate(WebDriver driver) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
//		util.scroll(driver, "UP");
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_AddDuplicateSegment));
		actions.driverClick(driver, createsegment.btn_AddDuplicateSegment);
		//createsegment.btn_AddDuplicateSegment.click();
	}

	public void Update_QueryParameter_Comparator(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
//		util.scroll(driver, -100);
//		createsegment.ddl_SegmenentOperator.get(0).click();
//		util.scroll(driver, 40);
//		createsegment.ddl_NotEquals.click();
		actions.driverClick(driver, createsegment.ddl_SegmenentOperator.get(0));
		actions.driverClick(driver, createsegment.ddl_NotEquals);
	}

	public void Update_QueryParameter_Boolen(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
//		createsegment.ddl_SegmentDropdown.get(1).click();
//		createsegment.ddl_BooleanFalse.click();
		actions.driverClick(driver, createsegment.ddl_SegmentDropdown.get(1));
		actions.driverClick(driver, createsegment.ddl_BooleanFalse);
	}

	public void Update_QueryParameter_Variable(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		createsegment.ddl_SegmenentOperator.get(2).click();
		createsegment.ddl_LogicalOR.click();
	}

	public void Update_QueryParameter(WebDriver driver, String SearchText) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_EditSegment));
		createsegment.btn_EditSegment.click();
		createsegment.txt_SearchforParamterToConfigure.sendKeys(SearchText);
		createsegment.selectParameter(driver);
	}

	public void UpdateQueryParameter_NotCondition(WebDriver driver) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", createsegment.icon_Not);
	}

	public void saveDraft(WebDriver driver) throws InterruptedException {
//		util.scroll(driver, "DOWN");
//		util.scroll(driver, "DOWN");
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_SaveDraft));
		actions.driverClick(driver, createsegment.btn_SaveDraft);
//		createsegment.btn_SaveDraft.click();
		Thread.sleep(5000);
	}

	public void ViewSegmentSize(WebDriver driver) throws InterruptedException {
//		util.scroll(driver, "DOWN");
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_ViewSize));
		actions.driverClick(driver, createsegment.btn_ViewSize);
//		createsegment.btn_ViewSize.click();
		Thread.sleep(5000);
	}

	public void searchSegment(WebDriver driver, String SearchText) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		HomePageObjects homePage = new HomePageObjects(driver);
		LandingPageObjects landingPageObjects1 = new LandingPageObjects(driver);
		homePage.lnk_MyPosts.click();
		homePage.lnk_MySegments.click();
		waitTillElementPresent(driver, landingPageObjects1.first_SegmentName);
		createsegment.txt_SegmentSearchbox.clear();
		createsegment.txt_SegmentSearchbox.sendKeys(SearchText);
		Thread.sleep(10000);
	}
	
	public void searchSegmentMethod(WebDriver driver, String SearchText) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		LandingPageObjects landingPageObjects1 = new LandingPageObjects(driver);
		waitTillElementPresent(driver, landingPageObjects1.first_SegmentName); 
		createsegment.txt_SegmentSearchbox.clear();
		createsegment.txt_SegmentSearchbox.sendKeys(SearchText);
		Thread.sleep(2000);
	}

	public void GlobalFooterPrivacy(WebDriver driver) throws InterruptedException {
		driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		globalfooter.lnk_Privacy.click();
		Thread.sleep(5000);
	}

	public void GlobalFooterAdChoices(WebDriver driver) throws InterruptedException {
		driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		globalfooter.lnk_AdChoices.click();
		Thread.sleep(5000);
	}

	public void GlobalFooterOpenAPLogo(WebDriver driver) throws InterruptedException {
		driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		globalfooter.lbl_GlobalFooterLogo.click();
		Thread.sleep(5000);
	}

	public void GlobalFooterTerms(WebDriver driver) throws InterruptedException {
		driver.switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		globalfooter.lnk_Terms.click();
		Thread.sleep(5000);
	}

	public void GlobalFooterTwitter(WebDriver driver) throws InterruptedException {
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		Thread.sleep(3000);
		globalfooter.lnk_Twitter.click();
		util.switchwindow(driver, "twitter");
	}

	public void GlobalFooterFacebook(WebDriver driver) throws InterruptedException {
		GlobalFooterPageObjects globalfooter = new GlobalFooterPageObjects(driver);
		Thread.sleep(3000);
		globalfooter.lnk_Facebook.click();
		util.switchwindow(driver, "facebook");
	}

		public void SelectEntityLogo(WebDriver driver, EnumString Entity, String... scrollreq) throws InterruptedException {
//		util.scroll(driver, "DOWN");
		Thread.sleep(3000);
//		if (scrollreq.length == 0) {
//			util.scroll(driver, "DOWN");
//			util.scroll(driver, "DOWN");
//			util.scroll(driver, "DOWN");
//		}		
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		switch (Entity) {
		case FOX:
			actions.driverClick(driver, viewSize.img_FOX);
//			viewSize.img_FOX.click();
			break;
		case Turner:
			actions.driverClick(driver, viewSize.img_Turner);
//			viewSize.img_Turner.click();
			break;
		case Viacom:
			actions.driverClick(driver, viewSize.img_Viacom);
//			viewSize.img_Viacom.click();
			break;
		default:
			break;
		}
	}

	public void AddUserorEntity(WebDriver driver, String User, String... Rights) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
//		 util.scroll(driver, 400);
		waitTillElementPresent(driver, viewSize.txt_AddEmailIDforSharing);
		actions.driverSendKeys(driver, viewSize.txt_AddEmailIDforSharing, User);	
		viewSize.txt_AddEmailIDforSharing.sendKeys(Keys.ENTER);
//		viewSize.txt_AddEmailIDforSharing.sendKeys(User, Keys.ENTER);
		 Thread.sleep(2000);
		if (Rights.length != 0) {
			viewSize.lnk_AddOwner.click();
		}
	}

	public void LockAndShareSegment(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
//        util.scroll(driver, 800);
//      waitTillElementPresent(driver).until(ExpectedConditions.elementToBeClickable(viewSize.btn_UpdateSize));
      actions.driverMoveToElement(driver, viewSize.btn_LockAndShareSegment);
		Thread.sleep(2000);
        boolean f = true;
        while (f) {         
            Thread.sleep(2000);
            if (viewSize.btn_LockAndShareSegment.getText().trim().equalsIgnoreCase("LOCK AND SHARE SEGMENT")) {
                viewSize.btn_LockAndShareSegment.click();
                f = true;
            }  else if(!viewSize.btn_LockAndShareSegment.getText().trim().equalsIgnoreCase("LOCK AND SHARE SEGMENT")) {
                f = false;  
                break;
            }
        }   
	}

	public void viewPost(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_MyPosts.click();
		Thread.sleep(2000);
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		myPosts.btn_ViewPost.click();
	}

	public void searchPost(WebDriver driver, String searchText) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(homePage.lnk_MyPosts));
		homePage.lnk_MyPosts.click();
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(myPosts.txt_Search));
		myPosts.txt_Search.sendKeys(searchText);
		Thread.sleep(2000);
	}

	public void RunPostfromSegment(WebDriver driver, String postName, String filePath,String browser,String...segmentDetail) throws InterruptedException, IOException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_SharedWithMe.click();
		Thread.sleep(3000);
		homePage.btn_RunPost.click();
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public void RunPost(WebDriver driver, String postName, String filePath, String browser, String...segmentDetail)
			throws InterruptedException, IOException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_MyPosts.click();
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		myPosts.btn_RunAPost.click();
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public void RelinquishOwner(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewsize = new ViewSizePageObjects(driver);
//		util.scroll(driver, 600);
//		viewsize.btn_RelinquishOwner.click();
		actions.driverClick(driver, viewsize.btn_RelinquishOwner);
		Thread.sleep(3000);
		waitTillElementPresent(driver, viewsize.btn_RelinquishYes);
		actions.driverClick(driver, viewsize.btn_RelinquishYes);
	}

	public void AllSegments(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_AllSegments.click();
		Thread.sleep(3000);
	}

	public void OwnedByMe(WebDriver driver) throws InterruptedException {
		LandingPageObjects landingPageObjects = new LandingPageObjects(driver);
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_OwnedByMe.click();
		waitTillElementPresent(driver, landingPageObjects.first_SegmentName);
	}

	public void SharedWithMe(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_SharedWithMe.click();
		Thread.sleep(3000);
	}

	public void updateDraftSegmentName(WebDriver driver, String UpdateSegmentName) throws InterruptedException {
		Thread.sleep(4000);
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		createsegment.txt_NameYourSegment.clear();
		createsegment.txt_NameYourSegment.sendKeys(UpdateSegmentName);
//		createsegment.btn_SaveDraft.click();
	}

	public void UpdateDraftSegmentDataSource(WebDriver driver, String DataSource, String  ComScoreTagID) throws InterruptedException {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		createsegment.ddl_SelectSource.click();
		Thread.sleep(2000);
//		util.scroll(driver, "DOWN");
		if (DataSource.equalsIgnoreCase("COMSCORE")) {
//			createsegment.list_Comscore.click();
			actions.driverClick(driver, createsegment.list_Comscore);
		} else if (DataSource.equalsIgnoreCase("TAG")) {
//			createsegment.list_ComscoreTag.click();
			actions.driverClick(driver, createsegment.list_ComscoreTag);
			createsegment.txt_ComscoreTag.sendKeys(ComScoreTagID);
		}
		createsegment.btn_SaveDraft.click();
	}

	public void editSegment(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_Edit.click();
		Thread.sleep(3000);
	}

	public void UpdateSegmentDescription(WebDriver driver, String SegmentDescription) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.txt_SegmentDescription.clear();
		viewSize.txt_SegmentDescription.sendKeys(SegmentDescription);
	}

	public void AddTags(WebDriver driver, String SegmentTag) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.txt_AddTags.sendKeys(SegmentTag, Keys.ENTER);
		// Thread.sleep(3000);
	}

	public void RemoveTag(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.close_Tag.click();
	}

	public void ViewSegment(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_View.click();
		Thread.sleep(3000);
	}

	public void ShareSegment(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_Share.click();
		Thread.sleep(3000);
	}

	public void DownloadSegment(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.btn_DownloadSegment.click();
		// Thread.sleep(5000);
	}

	public void UpdateLockedSegmentName(WebDriver driver, String SegmentName) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.btn_EditLockedSegmentName.click();
		Actions EditSegmentName = new Actions(driver);
		EditSegmentName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)).build().perform();
		EditSegmentName.sendKeys(SegmentName, Keys.TAB).build().perform();
	}

	public void UpdateLockedSegmentDescription(WebDriver driver, String SegmentDescription)
			throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.btn_EditLockedSegmentDescription.click();
		viewSize.txt_EditLockedSegmentDescription.clear();
		viewSize.txt_EditLockedSegmentDescription.sendKeys(SegmentDescription, Keys.TAB);
	}

	public void UpdateSize(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		Thread.sleep(2000);
//		util.scroll(driver, "DOWN");
//		util.scroll(driver, "DOWN");
//		util.scroll(driver, "DOWN");
//		util.scroll(driver, "DOWN");
//		viewSize.btn_UpdateSize.click();
		actions.driverClick(driver, viewSize.btn_UpdateSize);
		Thread.sleep(5000);
	}
	
	public void startdownload(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.btn_StartDownload.click();
		Thread.sleep(5000);
	}

	public void myPosts(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_MyPosts.click();
		Thread.sleep(2000);
	}

	public void DownLoadPostfromIndividualPost(WebDriver driver, String Type) {
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		if (Type.equalsIgnoreCase("CSV")) {
			myPosts.btn_CSV.click();
		} else if (Type.equalsIgnoreCase("PDF")) {
			myPosts.btn_PDF.click();
		}
	}

	public void DownLoadPostfromMyPost(WebDriver driver, String Type) {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.lnk_MyPosts.click();
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		if (Type.equalsIgnoreCase("CSV")) {
			myPosts.btn_CSV.click();
		} else if (Type.equalsIgnoreCase("PDF")) {
			myPosts.btn_PDF.click();
		}
	}

	public void RunPostfromIndividualSegment(WebDriver driver, String postName, String filePath, String browser,String...segmentDetail)
			throws InterruptedException, IOException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		viewSize.lnk_Posts.click();
		//util.scroll(driver, "DOWN");
//		util.scroll(driver, "UP");
//		viewSize.btn_RunPostInd.click();
		actions.driverClick(driver, viewSize.btn_RunPostInd);
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public void RunPostfromSegmentLibraryAsViewer(WebDriver driver, String postName, String filePath,String browser,String...segmentDetail)
			throws InterruptedException, IOException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_RunPost.click();
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}
	
	public void fillAndUploadAsRunLogFile(WebDriver driver, String postName, String filePath, String browser,
			String... segmentDetail) throws IOException, InterruptedException {
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		myPosts.txt_PostName.sendKeys(postName);
		if (segmentDetail.length > 0) {
			myPosts.txt_SegmentID.sendKeys(segmentDetail);
		}
//		util.SelectItems(myPosts.ddl_PostRatings, EnumString.VisibleText, "C3");
		myPosts.ddl_PostRatings.sendKeys("C3");
		if (browser.equalsIgnoreCase("Safari")) {
			myPosts.btn_ChooseFile.click();
			util.uploadFileInMAC(filePath);
		} else if (browser.equalsIgnoreCase("Chrome")) {
			myPosts.asRunLogFileContainer.sendKeys(filePath);
//			Runtime.getRuntime().exec(filePath);
		}
		waitTillElementPresent(driver).until(ExpectedConditions.elementToBeClickable(myPosts.btn_RunPost));
		actions.driverClick(driver, myPosts.btn_RunPost);
//		myPosts.btn_RunPost.click();
		Thread.sleep(5000);
	}

	public void RunPostfromSegmentLibrary(WebDriver driver, String postName, String filePath,String browser,String...segmentDetail)
			throws InterruptedException, IOException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_RunPost.click();
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public String VerifySegmentName(WebDriver driver) {
		ViewSizePageObjects seg_name = new ViewSizePageObjects(driver);
		return seg_name.seg_name.getText();
	}

	public String VerifyLastUpdate(WebDriver driver) {
		ViewSizePageObjects last_updated = new ViewSizePageObjects(driver);
		String text = last_updated.last_updated.getText();
		return text;
	}

	public String Date() {
		// getting current date and time using Date class
		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		Date dateobj = new Date();
		String sysdate = df.format(dateobj);
		return sysdate;
	}

	public void RunPostFromShareSegment(WebDriver driver, String postName, String filePath,String browser,String...segmentDetail)
			throws InterruptedException, IOException {
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		waitTillElementPresent(driver, myPosts.btn_RunAPost);
//		util.scroll(driver, 800);
//		myPosts.btn_RunAPost.click();
		actions.driverClick(driver, myPosts.btn_RunAPost);
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public void RunPostfromIndividualSegmentAsViewer(WebDriver driver, String postName, String filePath,String browser,String...segmentDetail)
			throws InterruptedException, IOException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_RunPost.click();
		fillAndUploadAsRunLogFile(driver, postName, filePath, browser, segmentDetail);
	}

	public void uploadPID(WebDriver driver, String filePath, String browser) throws InterruptedException, IOException {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		Thread.sleep(5000);
		if (browser.equalsIgnoreCase("Safari")) {
			createSegment.btn_ChooseFile.click();
			util.uploadFileInMAC(filePath);
		} else if (browser.equalsIgnoreCase("Chrome")) {
			createSegment.pidContainer.sendKeys(filePath);
//			Runtime.getRuntime().exec(filePath);
		}
		Thread.sleep(10000);
	}

	public void cancel(WebDriver driver) throws InterruptedException {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		createSegment.btn_Cancel.click();
		Thread.sleep(5000);
	}

	public void removePID(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
//		util.scroll(driver, "DOWN");
//		createSegment.btn_RemovePID.click();
		actions.driverClick(driver, createSegment.btn_RemovePID);
	}

//	public void closePIDPopup(WebDriver driver) {
//		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
//		createSegment.btn_Remove_PID_Popup.click();
//	}

	public void refresh(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_Refresh.click();
	}

	public void refreshFromSegmentDetailPage(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
//		util.scroll(driver, 600);
		Thread.sleep(2000);
//		viewSize.btn_RefreshSegmntDetail.click();
		actions.driverClick(driver, viewSize.btn_RefreshSegmntDetail);
		Thread.sleep(5000);
	}

	public void AddSegment(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_AddSegment.click();
		Thread.sleep(4000);	
	}

	public void refreshSegment(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
//		util.scroll(driver, "DOWN");
//		createSegment.btn_RefreshSegment.click();
		actions.driverClick(driver, createSegment.btn_RefreshSegment);
	}	
	
	public void clonebutton(WebDriver driver) throws InterruptedException {
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.btn_Clone.click();
		Thread.sleep(3000);
	}
	

	
	public WebDriverWait waitTillElementPresent(WebDriver driver) {
		return new WebDriverWait(driver, 240);		
	
	}
	
	public void selectParameterUsingBrowseAll_Comscore(WebDriver driver, String catagory) throws InterruptedException {
//		util.scroll(driver, "DOWN");
		WebElement tn = driver.findElement(By.xpath("//div[@class = 'tree']//tree-node"));;
		actions.driverMoveToElement(driver, tn);
		List<WebElement> treenodes = driver.findElements(By.xpath("//div[@class = 'tree']//tree-node"));
		int pos = 0;
		for (int i = 0; i < treenodes.size(); i++) {
			if (driver
					.findElement(By.xpath("//div[@class = 'tree']//tree-node[" + (i + 1)
							+ "]//div[@class ='tree-node-level-1 tree-node tree-node-collapsed']//tree-node-wrapper//div[@class = 'node-wrapper']//div[@class='node-content-wrapper']"))
					.getText().trim().equalsIgnoreCase(catagory)) {
				pos = i + 1;
				actions.driverClick(driver, driver.findElement(By.xpath("//div[@class = 'tree']//tree-node[" + pos
						+ "]//span[@class = 'toggle-children-wrapper toggle-children-wrapper-collapsed']//span[@class = 'toggle-children']")));
				driver.findElement(By.xpath("//div[@class = 'tree']//tree-node[" + pos
						+ "]//span[@class = 'toggle-children-wrapper toggle-children-wrapper-collapsed']//span[@class = 'toggle-children']"))
						.click();
				break;
			}
		}
		// util.scroll(driver, "DOWN");
		Boolean sd = true;
		String treenode = "//div[@class = 'tree']//tree-node[" + pos + "]";
		String expander = "//div//tree-node-wrapper//div[@class = 'node-wrapper']//tree-node-expander//span";
		String children = "//tree-node-children//div[@class = 'tree-children']//tree-node-collection//tree-node[1]";
		String title = "//div//tree-node-wrapper//div[@class = 'node-wrapper']//div[@class='node-content-wrapper']";
		String ss = treenode + children + expander;
		String dd = treenode + children + title;
		while (sd) {
			if (driver.findElement(By.xpath(ss)).getAttribute("class")
					.equalsIgnoreCase("toggle-children-wrapper toggle-children-wrapper-collapsed")) {
				actions.driverClick(driver, driver.findElement(By.xpath(ss)));
//				driver.findElement(By.xpath(ss)).click();
				ss = ss.replace(expander, "") + children + expander;
				// ss = ss + children + expander;
				dd = dd.replace(title, "") + children + title;
			} else {
				actions.driverClick(driver, driver.findElement(By.xpath(dd)));
//				driver.findElement(By.xpath(dd)).click();
				sd = false;
				Thread.sleep(5000);
			}
		}
	}
	
}*/