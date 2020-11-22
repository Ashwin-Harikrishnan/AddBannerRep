package me.darsini.mainTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestData.TestDataBanner;
import TestData.WriteExcel;
import objectRepository.AddBannerPage;

public class AddBannerTest {

	static TestDataBanner TestDataObj;
	static ExcelDataImport excelDataObj;
	static WriteExcel writeObj;
	baseClass baseObj = new baseClass();

	static String[] testData;
	static ExtentTest test;
	static ExtentReports report;
	// public static WebDriver driver;
	AddBannerPage object;
	String verification = "";

	/*
	 * @BeforeSuite public void driverSetup() {
	 * System.setProperty("webdriver.chrome.driver",
	 * "E:\\Random Crap\\Studies\\STC\\chromedriver_win32\\chromedriver.exe");
	 * driver = new ChromeDriver(); String URL =
	 * "https://admin-uat.darisni.me/auth/login"; driver.get(URL);
	 * 
	 * // maximize browser window driver.manage().window().maximize(); }
	 */

	@BeforeClass
	public void initialize() {

		try {
			baseObj.driverSetup();
			String URL = "https://admin-uat.darisni.me/auth/login";
			baseObj.driver.get(URL);

			// maximize browser window
			baseObj.driver.manage().window().maximize();

			object = new AddBannerPage(baseObj.driver);
			TestDataObj = new TestDataBanner();
			excelDataObj = new ExcelDataImport();
			excelDataObj.readExcel("Sheet2");

			// writeObj = new WriteExcel();
			// writeObj.writeExcel("Sheet2");
			TestDataObj.setFakerData();

			report = new ExtentReports(System.getProperty("E:\\Random Crap\\Studies\\STC\\WorkDocs\\TestReports")
					+ "ExtentReportResults.html");
			test = report.startTest("ExtentDemo");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void mainTest() {

		object.login();
		testData = TestDataObj.getSignInData();
		object.navigation();
		object.addBanner(testData[0], testData[1], testData[2], testData[3], testData[4], testData[5], testData[6],
				testData[7], testData[8], testData[9], testData[10], Boolean.parseBoolean(testData[13]));

		if (object.expectedMessage == object.successMessage) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}

		object.logout();

	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
