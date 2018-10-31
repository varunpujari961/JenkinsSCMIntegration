package Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CommonMethods.CommonScenarios;
import ObjectsRepository.*;
import Utilities.EnumString;
import Utilities.Utilities;

public class Valildations {

	public String validateLoginUser(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.lbl_LogedinUserName.getText();
	}
	
	public Boolean ValidatePreviousEpisode_Display(WebDriver driver) {
		LandingPageObjects viewSizePage = new LandingPageObjects(driver);
		return viewSizePage.lbl_PreviousEpisode.isDisplayed();
	}
	
	public Boolean ValidateLatestEpisode_Display(WebDriver driver) {
		LandingPageObjects viewSizePage = new LandingPageObjects(driver);
		return viewSizePage.lbl_LatestEpisode.isDisplayed();
	}
	
	
}

	/*public String validateInvalidLoginUser(WebDriver driver) {
		LandingPageObjects landingPage = new LandingPageObjects(driver);
		return landingPage.msg_invalidLogin.getText();
	}

	public boolean validateDataSourceGroupList(WebDriver driver, String dataSourceGroup) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		boolean dataSource = false;
		switch (dataSourceGroup) {
		case "COMSCORE":
			dataSource = createsegment.list_Comscore.isEnabled();
			break;
		case "TAG":
			dataSource = createsegment.list_ComscoreTag.isEnabled();
			break;
		case "Nielsen_MRI":
			dataSource = createsegment.list_Nielsen_MRI.isEnabled();
			break;
		case "Nielsen_NCS":
			dataSource = createsegment.list_Nielsen_NCS.isEnabled();
			break;	
		case "Nielsen_NBI":
			dataSource = createsegment.list_Nielsen_NBI.isEnabled();
			break;	
		case "NIELSEN_FUSION":
			dataSource = createsegment.list_NIELSEN_FUSION.isEnabled();
			break;
		}
		return dataSource;
	}
	
	public String validateQueryParameterComparator(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.ddl_SegmenentOperator.get(0).getText().trim();	
	}	
	
	public String validateQueryParameterBoolen(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.ddl_SegmentDropdown.get(1).getText().trim();
	}	

	public String validateStartAgain(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		CommonScenarios commonscenario = new CommonScenarios();
		commonscenario.waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createSegment.ddl_SelectSource));
		return createSegment.ddl_SelectSource.getText();
	}

	public String getSearchSegmentResult(WebDriver driver, EnumString Type) {
		String Result = "";
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		switch (Type) {
		case Name:
			Result = createSegment.text_SearchSegmentResult_Name.getText();
			break;
		case ID:
			Result = createSegment.text_SearchSegmentResult_ID.getText();
			break;
		case Email:
			Result = createSegment.text_SearchSegmentResult_Email.getText();
			break;
		case Tag:
			Result = createSegment.text_SearchSegmentView_Tag.getAttribute("ng-reflect-text");
		default:
			break;
		}
		return Result;
	}

	public String[] GetSegmentDetailsfromURL(WebDriver driver) throws InterruptedException {
		Thread.sleep(6000);
		String[] b = driver.getCurrentUrl().split("/");
		int g = b.length;
		return new String[] { b[g - 1], b[g - 2] };
	}

	public String validateOpenAPTV(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public Boolean validateSaveDrafttwithOutManditoryFields(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		CommonScenarios commonscenario = new CommonScenarios();
		commonscenario.waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(homePage.btn_AddSegment));
		homePage.btn_AddSegment.click();
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		commonscenario.waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_SaveDraft));
		return createsegment.btn_SaveDraft.isEnabled();
	}

	public Boolean validateViewSizetwithOutManditoryFields(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		CommonScenarios commonscenario = new CommonScenarios();
		commonscenario.waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(homePage.btn_AddSegment));
		homePage.btn_AddSegment.click();
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		commonscenario.waitTillElementPresent(driver).until(ExpectedConditions.visibilityOf(createsegment.btn_ViewSize));
		return createsegment.btn_ViewSize.isEnabled();
	}

	public String validateSearchPostResults(WebDriver driver, EnumString Type) {
		String PostInfo = "";
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		switch (Type) {
		case PostID:
			PostInfo = myPosts.lbl_PostIDfromPostTable.getText();
			break;
		case PostName:
			PostInfo = myPosts.lbl_PostNamefromPostTable.getText();
			break;
		case SegmentID:
			PostInfo = myPosts.lbl_SegmentIDfromPostTable.getText();
		default:
			break;
		}
		return PostInfo;
	}

	public Boolean validateViewPost(WebDriver driver) {
		Boolean b;
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		if (myPosts.btn_PDF.isEnabled() && myPosts.btn_CSV.isEnabled()) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public String validateErrorMsgForShareSegment(WebDriver driver) throws InterruptedException {
		CommonScenarios commonScenarios = new CommonScenarios();
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		Thread.sleep(3000);
		commonScenarios.waitTillElementPresent(driver, createsegment.txt_ErrorMsgForShareSegment);
		return createsegment.txt_ErrorMsgForShareSegment.getText();

	}

	public String validateErrorMsgForDuplicateTags(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.txt_DuplicateTag.getText();
	}

	public String ValidateSegmentName(WebDriver driver) throws InterruptedException {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.txt_SegmentNameVadliation.getText();
	}

	public String vaidateErrorMessgaeforRunPost(WebDriver driver) {
		MyPostsPageObjects myPost = new MyPostsPageObjects(driver);
		return myPost.msg_ErrorMsg.getText();
	}

	public Boolean validateMyPosts(WebDriver driver) {
		Boolean b;
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		if (myPosts.btn_ViewPost.isEnabled() && myPosts.btn_PDF.isEnabled() && myPosts.btn_CSV.isEnabled()) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public String ValidatePostName(WebDriver driver) {
		MyPostsPageObjects myPosts = new MyPostsPageObjects(driver);
		return myPosts.txt_RunPost_PostName.getText();
	}

	public Boolean ViewTags_Viewer(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		List<WebElement> ff = createSegment.tags.findElements(By.tagName("openap-tag-input-item"));
		Boolean b;
		if (ff.size() > 0) {
			b = true;
		} else {
			b = false;
		}
		return b;
	}

	public String validateErrorMsgForShareSegment_WithoutUsers(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.txt_ErrorMsgForShareSegment_WithoutUsers.getText();
	}

	public Boolean ValidateLockandShare(WebDriver driver) {
		ViewSizePageObjects viewSizePage = new ViewSizePageObjects(driver);
		CommonScenarios commonscenario = new CommonScenarios();
		commonscenario.waitTillElementPresent(driver,viewSizePage.btn_LockAndShareSegment);
		return viewSizePage.btn_LockAndShareSegment.isEnabled();
	}

	public Boolean ValidateLockandShare_Display(WebDriver driver) {
		ViewSizePageObjects viewSizePage = new ViewSizePageObjects(driver);
		return viewSizePage.btn_LockAndShareSegment.isDisplayed();
	}
	
	public Boolean validateStartDownload_Enabled(WebDriver driver) {
		ViewSizePageObjects viewSizePage = new ViewSizePageObjects(driver);
		return viewSizePage.btn_StartDownload.isEnabled();
	}

	public Boolean validateStartDownload_Display(WebDriver driver) {
		ViewSizePageObjects viewSizePage = new ViewSizePageObjects(driver);
		return viewSizePage.btn_StartDownload.isDisplayed();
	}

	public Boolean validateSaveDraftDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_SaveDraft.isDisplayed();
	}

	public Boolean validateSaveDraftEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_SaveDraft.isEnabled();
	}

	public Boolean ValidateViewSize_Display(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_ViewSize.isDisplayed();
	}

	public Boolean ValidateViewSize_Enable(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_ViewSize.isEnabled();
	}

	public Boolean ValidateSegmentName_EditPage(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.txt_NameYourSegment.isDisplayed();
	}

	public Boolean validateDataSourceCheckBoxAMRLDDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_AMRLD.isDisplayed();
	}

	public Boolean validateDataSourceCheckBoxAMRLDEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_AMRLD.isEnabled();
	}

	public Boolean validateDataSourceCheckBoxNBIDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NBI.isDisplayed();
	}

	public Boolean validateDataSourceCheckBoxNBIEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NBI.isEnabled();
	}

	public Boolean validateDataSourceCheckBoxMRIDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_MRI.isDisplayed();
	}

	public Boolean validateDataSourceCheckBoxMRIEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_MRI.isEnabled();
	}

	public Boolean validateDataSourceCheckBoxNCSRLDDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NCSRLD.isDisplayed();
	}

	public Boolean validateDataSourceCheckBoxNCSRLDEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NCSRLD.isEnabled();
	}

	public Boolean validateChooseFilePIDDisplayed(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_ChooseFile.isDisplayed();
	}

	public Boolean validateChooseFilePIDEnabled(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.btn_ChooseFile.isEnabled();
	}

	public String Validate_ErroMessage_PID_Upload(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.ErrorMessage_PID.getText();
	}

	public Boolean ValidateSegmentDownload_Enable(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_DownloadSegment.isEnabled();
	}

	public Boolean ValidateSegmentDownload_Display(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_DownloadSegment.isDisplayed();
	}

	public Boolean ValidateRunPost_Display(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_RunPostInd.isDisplayed();
	}

	public Boolean ValidateRunPost_Enable(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_RunPostInd.isEnabled();
	}

	public Boolean validateEditSegNameEnabled(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_EditLockedSegmentName.isEnabled();
	}

	public Boolean validateEditSegNameDisplayed(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_EditLockedSegmentName.isDisplayed();
	}

	public Boolean validateEditSegDescEnabled(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_EditLockedSegmentDescription.isEnabled();
	}

	public Boolean validateEditSegDescDisplayed(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_EditLockedSegmentDescription.isDisplayed();
	}

	public Boolean ValidateUpdateSize_Enable(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_UpdateSize.isEnabled();
	}

	public Boolean ValidateUpdateSize_Display(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_UpdateSize.isDisplayed();
	}

	public Boolean validateSegNameDisplayed(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.seg_name.isDisplayed();
	}

	public Boolean ValidateShareSegNameChckBox_Display(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.chkbx_ShareSegmentName.isDisplayed();
	}

	public Boolean ValidateShareSegNameChckBox_Enable(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.chkbx_ShareSegmentName.isEnabled();
	}

	public Boolean ValidateRelinquish_Display(WebDriver driver) {
		Utilities util = new Utilities();		
		util.scroll(driver, "DOWN");
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_RelinquishOwner.isDisplayed();
	}

	public Boolean ValidateRelinquish_Enable(WebDriver driver) {
		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
		return viewSize.btn_RelinquishOwner.isEnabled();
	}

	public Boolean validateRefreshEnabled(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Refresh.isEnabled();
	}

	public Boolean validateRefreshDisplayed(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Refresh.isDisplayed();
	}
	
	public Boolean validateCloneButtonDisplayed(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Clone.isDisplayed();
	}
	
	public Boolean validateCloneButtonEnabled(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Clone.isEnabled();
	}
	
	public WebElement validateRefreshButtonFromSegmentDetailPage(WebDriver driver) {
		WebElement e = null;
		List<WebElement> ref = driver.findElements(By.xpath("//div[@class = 'button-container']//a"));
		for (WebElement f : ref) {
			if (f.getAttribute("class").equals("btn btn-primary btn-refresh-segment")) {
				e = f;
				break;
			}
		}
		return e;
	}

//	public WebElement validateRefreshButtonInSegmentDetailPageEnabled(WebDriver driver) {
//		WebElement buttonContainer = null;
//		buttonContainer = driver.findElement(By.xpath("//div[@class = 'button-container//following::input[1]']"));
//		if (buttonContainer.getAttribute("class").equals("btn btn-primary btn-refresh-segment")) {
//			return buttonContainer;
//		}
//		return buttonContainer;
//	}
//
//	public Boolean validateRefreshButtonInSegmentDetailPageDisplayed(WebDriver driver) {
//		WebElement buttonContainer = driver
//				.findElement(By.xpath("//div[@class = 'button-container//following::input[1]']"));
//		return buttonContainer.getAttribute("class").equals("btn btn-primary btn-refresh-segment");
//	}
	
	public Boolean validateAddSegmentButton_Display(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_AddSegment.isDisplayed();
	}

	public Boolean validateAddSegmentButton_Enable(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_AddSegment.isEnabled();
	}

	public Boolean ValidateSearchSegment_Display(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.txt_searchTextBox.isDisplayed();
	}

	public Boolean ValidateSearchSegment_Enable(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.txt_searchTextBox.isEnabled();
	}

	public Boolean ValidateRefreshSegment_Display(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.btn_RefreshSegment.isDisplayed();
	}
	
	public WebElement validateSegmentButton(WebDriver driver, String button) {
		WebElement f = null;
		HomePageObjects homePage = new HomePageObjects(driver);
		for (WebElement dd : homePage.btn_segmentButton) {
			if (dd.getText().equalsIgnoreCase(button)) {
				f = dd;
				break;
			}
		}
		return f;
	}

	public Boolean ValidateRefreshSegment_Enable(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.btn_RefreshSegment.isEnabled();
	}

//	public Boolean ValidateRefreshButtonInPIDUploadPopUp_Enable(WebDriver driver) {
//		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
//		return viewSize.btn_RefreshSegmntPopUp.isEnabled();
//	}

//	public Boolean ValidateRefreshButtonInPIDUploadPopUp_Display(WebDriver driver) {
//		ViewSizePageObjects viewSize = new ViewSizePageObjects(driver);
//		return viewSize.btn_RefreshSegmntPopUp.isDisplayed();
//	}

//	public Boolean ValidateSegmentName_Enabled(WebDriver driver) {
//		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
//		return createsegment.txt_NameYourSegment.isEnabled();
//	}

	public Boolean ValidateDataSourceCheckBox_Display_chkbox_NBI(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NBI.isDisplayed();
	}

	public Boolean ValidateDataSourceCheckBox_Enable_chkbox_NBI(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NBI.isEnabled();
	}

	public Boolean ValidateDataSourceCheckBox_Display_chkbox_MRI(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_MRI.isDisplayed();
	}

	public Boolean ValidateDataSourceCheckBox_Enable_chkbox_MRI(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_MRI.isEnabled();
	}

	public Boolean ValidateDataSourceCheckBox_Display_chkbox_NSCRLD(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NCSRLD.isDisplayed();
	}

	public Boolean ValidateDataSourceCheckBox_Enable_chkbox_NSCRLD(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.chkbox_NCSRLD.isEnabled();
	}

	public Boolean validateDataSourceDropDownEnable(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.ddl_SelectSource.isEnabled();
	}

	public Boolean ValidateDataSourceCheckBox_Enable_chkbox_comscore(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.list_Comscore.isEnabled();
	}

	public Boolean ValidateDataSourceCheckBox_Display_chkbox_comscore(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.list_Comscore.isDisplayed();
	}

	public boolean validateStartAgain_Display(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.lnk_StartAgain.isDisplayed();
	}

	public boolean validateStartAgain_Enable(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.lnk_StartAgain.isEnabled();
	}
	public boolean validateViewButtonisEnabled(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_View.isEnabled();
	}
	public boolean validateViewButtonisDisplayed(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_View.isDisplayed();
	}
	
	public boolean ValidateSaveDraft_Display(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.btn_SaveDraft.isDisplayed();
	}
	
	public boolean ValidateSaveDraft_Enabled(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.btn_SaveDraft.isEnabled();
	}
	
	public String ValidateQueryParameter_Integer(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.txt_QueryParameter_Integer.getText();
	}
	
	public String validateTextacrossMultipleDropdowns(WebDriver driver, int index)
	{
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.list_ddl1_QueryParameter.get(index).getText();
	}
	
	public boolean validateEditButtonIsDisplayed(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Edit.isDisplayed();
	}
	
	public boolean validateShareButtonIsDisplayed(WebDriver driver) {
		HomePageObjects homePage = new HomePageObjects(driver);
		return homePage.btn_Share.isDisplayed();
	}
	
	public String getDataSourceGroupName(WebDriver driver) {
		ViewSizePageObjects viewSizePage = new ViewSizePageObjects(driver);
		return viewSizePage.dataSourcrGroupName.getText().trim();
	}
	
	public String validate_ErroMessage_DataSource_InCompatible(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.nielsenFusion_DataSource_InCompatible.getText();
	}
	
	public boolean validateSegmentNameisEditable(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		if(createsegment.text_name_refresh_editable.getCssValue("cursor").contains("not-allowed"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean validateNielsenFusionIsEditable(WebDriver driver) {
		CreateSegmentPage createsegment = new CreateSegmentPage(driver);
		return createsegment.nielsenFusion_Refresh.isDisplayed();
	}
	
	public boolean verifyStartDownloadText(WebDriver driver, String text) {
		boolean f = false;
		ViewSizePageObjects viewsize = new ViewSizePageObjects(driver);
		if (viewsize.btn_DownloadSegment.getText().contains(text)) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}
	
	public boolean verifyWhetherElementisPresent(WebDriver driver, List<WebElement> element) {
		boolean f = false;
		if (element.size() != 0) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}

	public boolean verifyPrivateDescriptionHeaderIsPresentforLockedSegment(WebDriver driver) {
		boolean f = false;
		ViewSizePageObjects viewSizeObject = new ViewSizePageObjects(driver);
		if (viewSizeObject.header_Description.getText().contains("PRIVATE DESCRIPTION")) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}

	public boolean verifyPrivateDescriptionHeaderIsPresentforDrftedSegment(WebDriver driver) {
		boolean f = false;
		ViewSizePageObjects viewSizeObject = new ViewSizePageObjects(driver);
		if (viewSizeObject.header_Description_draftedSegment.getAttribute("placeholder")
				.contains("Private description")) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}

	public boolean verifyTextisPresent(WebDriver driver, WebElement element, String text) {
		boolean f = false;
		if (element.getText().trim().contains(text)) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}
	
	public String getTextforCoulumnHeadersInPIDInfo(WebDriver driver) {
		CreateSegmentPage createSegment = new CreateSegmentPage(driver);
		return createSegment.text_columns_import_pid.getText();
	}
	
	public String getPostIDfromSegmentDetailsPage(WebDriver driver) {
		ViewSizePageObjects viewSizeObject = new ViewSizePageObjects(driver);
		return viewSizeObject.span_PostID.getText().trim();
	}
}*/