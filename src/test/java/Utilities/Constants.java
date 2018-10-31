package Utilities;

public class Constants {
	public static final String ErrorMsg_InvalidLogin = "This is not a valid user/password combination";
	public static final String ErrorMsg_APIUserLogin = "";
	
	public static final String OpenAPTVURL = "http://www.openap.tv/";
	public static final String OpenAPTVTerms = "http://www.openap.tv/terms/";
	public static final String OpenAPTVPrivacy = "http://www.openap.tv/privacy/";
	public static final String OpenAPTVAdChoices = "http://www.openap.tv/ad-choices/";
	public static final String OpenAPTVTwitter = "https://twitter.com/OpenApTV/";
	public static final String OpenAPTVFacebook = "https://www.facebook.com/OpenAPTV/";
	public static final String ErrorMsg_ShareWithSameUser = "This user is already shared with.";
	public static final String ErrorMsg_ShareWithOtherOrganization="You do not have permissions to share with that user.";
	public static final String ErrorMsg_InvalidEmailID="Please enter a valid email, or one that has not already been added"; 
	public static final String ErrorMsg_NotAssociatedEmailID="User not found";
	public static final String ErrorMsg_ShareWithPublisher= "You are unable to share with a PUBLISHER user. If you would like to share with this user, please select the PUBLISHER.";
	public static final String ErrorMsg_AddDuplicateTag="This tag already exists";
	
	public static final String UploadAsRunLogGreaterThan10MB = "Uploaded AsRunLog is greater than 10MB.";
	public static final String UploadBlankAsRunLog = "The uploaded file must has at least one more row besides the headers.";
	public static final String UploadAsRunLogNotCorrectFormat = "File is not in correct format.";
	public static final String UploadAsRunLogNotCSVFormat = "File must be in CSV or GZ format.";
	public static final String UploadAsRunLogwithinvalidNWID = "Invalid network Id in row 23.";
	public static final String UploadAsRunLogwithInvalidSpotDateTime = "Invalid spot date/time in row 2.";
	public static final String UploadAsRunLogwithFutureSpotDateTime = "Invalid spot date/time in row 2.";
	public static final String UploadAsRunLogSpotlenghtOutofRange = "Invalid spot length in row 2.";
	public static final String ErrorMsg_ShareWithoutUser= "Segment cannot be shared and locked without adding users or organizations to share.";
	public static final String UploadAsRunLogwithInvalidDataRights = "Datarights validations failed.";
	

	public static final String ErrorMessage_PIDList_NotCSV = "File must be in CSV or GZ Format.";
    public static final String ErrorMessage_PIDList_MoreThan10MB = "Uploaded PID file is greater than 10MB.";
    public static final String ErrorMessage_PIDList_500KRows = "File is greater than 10 MB.";//"File has too many rows.";

    public static final String ErrorMessage_PIDList_Over500KRows = "File has too many rows.";

    public static final String ErrorMessage_PIDList_WrongFormat_MoreColumns = "File is not in correct format.";

    public static final String ErrorMessage_PIDList_Empty = "File is blank.";

    public static final String ErrorMessage_PIDList_WrongFormat_ShuffleColumns = "File is not in correct format."; //"The header effective_date is not correct."; 
    public static final String ErrorMessage_PIDList_WrongFormat_HouseHoldasNonInteger = "Invalid or missing household number in row 2.";
    public static final String ErrorMessage_PIDList_WrongFormat_HouseHoldas999999999 = "Invalid or missing household number in row 2.";
    public static final String ErrorMessage_PIDList_WrongFormat_PersonIDasNonInteger = "Invalid or missing person ID in row 2.";
    public static final String ErrorMessage_PIDList_WrongFormat_PersonIDlessthen99 = "Invalid or missing person ID in row 2.";
    public static final String ErrorMessage_PIDList_WrongFormat_InvalidDate = "Invalid or missing Effective Date in row 2.";
    public static final String ErrorMessage_PIDList_FutureDate="Invalid or missing Effective Date in row 2.";
    public static final String ErrorMessage_PIDList_MissingColumnValues="Invalid or missing person ID in row 2.";
    public static final String ErrorMessage_PIDList_WrongFormat_LessColumns="File is not in correct format, missing column(s) in row 1.";
    public static final String ErrorMessage_PIDList_AddedMoreData_BeforeDates="An error occurred while trying to refresh this segment. Please try again.";
    public static final String ErrorMessage_PIDList_WrongFormat_PersonIDGreaterthen99 ="Invalid or missing person ID in row 3.";
  
    public static final String NielsenFusionSegmentStatus = "In Progress";
    
    public static final String ErrorMessage_DataSource_InCompatible = "Some of the datasources you have chosen are incompatible. Please review and try again.";

    public static final String Nielsen_PID_Info_column_headers = "It has three column headers: hh_num, person_id, and effective_date";
}