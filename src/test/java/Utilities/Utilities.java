package Utilities;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import ObjectsRepository.HomePageObjects;
import ObjectsRepository.LandingPageObjects;

public class Utilities {
	String Browser;	
	String ResultsFolderPath;
	String ExecutionDetailsExcelPath;
	WebDriver driver;
	ITestResult result;

	public Properties getConfigProperties(String env) throws IOException {
		String TestDataPath = "";
		switch (env) {
		case "DevEnv_MAC":
			TestDataPath = "TestData/DevEnv_MAC.properties";
			break;
		case "DevEnv_Windows":
			TestDataPath = "TestData/DevEnv_Windows.properties";
			break;
		case "QAEnv_MAC":
			TestDataPath = "TestData/QAEnv_MAC.properties";
			break;
		case "QAEnv_Windows":
			TestDataPath = "TestData/QAEnv_Windows.properties";
			break;
		case "SandboxEnv_MAC":
			TestDataPath = "TestData/SandboxEnv_MAC.properties";
			break;
		case "SandboxEnv_Windows":
			TestDataPath = "TestData/SandboxEnv_Windows.properties";
			break;
		case "UATEnv_MAC":
			TestDataPath = "TestData/UATEnv_MAC.properties";
			break;
		case "UATEnv_Windows":
			TestDataPath = "TestData/UATEnv_Windows.properties";
			break;
		}

		Properties p = new Properties();
		File file = new File(TestDataPath);
		InputStream stream;
		try {
			stream = new FileInputStream(file);
			p.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}
	

	public void launchApp(String ApplicationURL, WebDriver driver) throws InterruptedException {
//		driver.manage().deleteAllCookies();		
		driver.get(ApplicationURL);	
		Thread.sleep(10000);
		LandingPageObjects landingPageObjects = new LandingPageObjects(driver);
		waitTillElementPresent(driver, landingPageObjects.btn_ZeeLogin);
	}
	

	public void waitTillElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public String SegmentName() {
		return "UIAT" + new SimpleDateFormat("MMddHHmmss").format(new Date());
	}
	
	public String PostName() {
		return "UIATP" + new SimpleDateFormat("MMddHHmmss").format(new Date());
	}

	public void BasicAuthenticate() throws InterruptedException, AWTException {
		Robot rb = new Robot();
		StringSelection username = new StringSelection("openap");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// press tab to move to password field
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		// Enter password in password field
		StringSelection pwd = new StringSelection("nuG5goqq4mXMsdwGgU");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// press enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	

	public void SelectItems(WebElement Element, EnumString Method, String item) {
		Select select = new Select(Element);
		switch (Method) {
		case Index:
			select.selectByIndex(Integer.parseInt(item));
			break;
		case VisibleText:
			select.selectByVisibleText(item);
		default:
			break;
		}
	}
	

	public void CaptureScreenShot() throws IOException, InterruptedException, HeadlessException {
		String path = this.ResultsFolderPath + "\\" + Browser + "_" + result.getName() + ".png";
		Thread.sleep(3000);			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
	}
	

	public void SaveResults(WebDriver driver, ITestResult result, String Browser)
			throws IOException, InterruptedException, ParseException {
		this.driver = driver;
		this.result = result;
		this.Browser = Browser;
		CreateResultsFolder();
		CreateExecutionDetailsExcel();
		FillStatus();
	}
	

	public void CreateResultsFolder() throws IOException, InterruptedException, ParseException {
		ResultsFolderPath = "C:\\AutomationResults on_" + new SimpleDateFormat("yyyyMMdd").format(new Date());		
		File file = new File(ResultsFolderPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	

	public void CreateExecutionDetailsExcel() throws IOException, ParseException, InterruptedException {
		ExecutionDetailsExcelPath = ResultsFolderPath + "/Automation_Execution_Summary.xls";
		File file = new File(ExecutionDetailsExcelPath);
		if (!file.exists()) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Execution Status");
			HSSFRow rowhead = sheet.createRow((short) 0);
			HSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBottomBorderColor(HSSFColor.BLACK.index);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setRightBorderColor(HSSFColor.BLACK.index);
			HSSFFont font = workbook.createFont();			
			font.setColor((short)HSSFColor.BLACK.index);
			font.setBold(true);				
			style.setFont(font);			
			rowhead.createCell(0).setCellValue("Feature");	
			rowhead.createCell(1).setCellValue("TestCase ID");			
			rowhead.createCell(2).setCellValue("Description of the Test");
			rowhead.createCell(3).setCellValue("Execution Status");
			rowhead.createCell(4).setCellValue("Error Details");
			rowhead.createCell(5).setCellValue("Execution Time");
			rowhead.createCell(6).setCellValue("Browser Type");
			for (int i = 0; i <= 6; i++) {
				sheet.autoSizeColumn(i);
				rowhead.getCell(i).setCellStyle(style);
			}
			rowhead.setHeight((short)350);
			FileOutputStream fileOut = new FileOutputStream(ExecutionDetailsExcelPath, false);
			workbook.write(fileOut);
			workbook.close();
			fileOut.close();
		}
	}
	

	public void FillStatus() throws IOException, ParseException, InterruptedException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(result.getEndMillis());
		String EndTime = simpleDateFormat.format(calendar.getTime());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTimeInMillis(result.getStartMillis());
		String StartTime = simpleDateFormat.format(calendar1.getTime());

		Date d = simpleDateFormat.parse(EndTime);
		Date d2 = simpleDateFormat.parse(StartTime);
		FileInputStream fsIP = new FileInputStream(new File(ExecutionDetailsExcelPath));
		HSSFWorkbook wb = new HSSFWorkbook(fsIP);
		HSSFCellStyle style = wb.createCellStyle();				
		HSSFFont font = wb.createFont();			
		font.setColor((short)HSSFColor.BLACK.index);
		font.setBold(true);				
		style.setFont(font);
		HSSFSheet worksheet = wb.getSheetAt(0);		
		HSSFRow sheetrow = worksheet.createRow(worksheet.getLastRowNum() + 1);
		sheetrow.createCell(0).setCellValue(result.getInstanceName().replace("TestSuites.", ""));
		sheetrow.createCell(1).setCellValue(result.getName());
		if (result.getStatus() == 1) {
			sheetrow.createCell(3).setCellValue("SUCCESS");
			style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			sheetrow.getCell(3).setCellStyle(style);
			sheetrow.createCell(4).setCellValue("NA");
		} else {
			sheetrow.createCell(3).setCellValue("FAIL");
			style.setFillForegroundColor(HSSFColor.RED.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			sheetrow.getCell(3).setCellStyle(style);
			sheetrow.createCell(4).setCellValue(result.getThrowable().toString());		
			CaptureScreenShot();
		}
		sheetrow.createCell(5).setCellValue(d.getTime() - d2.getTime());
		sheetrow.createCell(6).setCellValue(Browser);
		sheetrow.createCell(2).setCellValue(result.getMethod().getDescription());
		worksheet.autoSizeColumn(0);
//		worksheet.autoSizeColumn(1);worksheet.autoSizeColumn(0);worksheet.autoSizeColumn(2);
////		for (int i = 0; i <= 5; i++) {
////			worksheet.autoSizeColumn(i);
//		}
		fsIP.close();
		FileOutputStream outFile = new FileOutputStream(new File(ExecutionDetailsExcelPath));
		wb.write(outFile);
		wb.close();
		outFile.close();
	}
	
	public String getVoucher() throws IOException {
		String voucher = "";
		String filename = "resources/testData/VoucherDetails.xls";
		FileInputStream fs = new FileInputStream(filename);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet worksheet = wb.getSheetAt(0);
		for (int i = 1; i <= worksheet.getLastRowNum(); i++) {
			if (worksheet.getRow(i).getCell(1).toString().contains("YES")) {
				voucher = worksheet.getRow(i).getCell(0).toString();
				worksheet.getRow(i).getCell(1).setCellValue("NO");
				break;
			}
		}
		FileOutputStream out1 = new FileOutputStream(filename, false);
		wb.write(out1);
		wb.close();
		fs.close();
		return voucher;
	}
	

	public String generateString(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}	
	

	public void switchwindow(WebDriver driver, String windowTitle) {
		Set<String> winHandleBefore = driver.getWindowHandles();
		for (String winHandle : winHandleBefore) {
			if (driver.switchTo().window(winHandle).getTitle().contains(windowTitle)) {
				break;
			}
		}
	}
	
	public void uploadFileInMAC(String filePath) throws IOException {
		String appleScript = "tell app \"System Events\"\n" + 
								"keystroke \"G\" using {command down,shift down}\n" + 
								"delay 2\n" + 
								"keystroke \"" + filePath + "\"\n" + 
								"delay 2\n" + 
								"keystroke return\n" + 
								"delay 1\n"
								+ "keystroke return\n" + "end tell";

		String[] args = { "osascript", "-e", appleScript };
		Runtime.getRuntime().exec(args);
	}
	
	public void scroll(WebDriver driver, String direction) {
		if (direction.equalsIgnoreCase("UP")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");
		} else if (direction.equalsIgnoreCase("DOWN")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		}else if (direction.equalsIgnoreCase("RIGHT")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(100,0)", "");
		}else if (direction.equalsIgnoreCase("LEFT")) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(-100,0)", "");
		}
	}
	
	public void scroll(WebDriver driver, int pixel) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"+String.valueOf(pixel)+")", "");
	}

}