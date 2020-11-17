package me.darsini.mainTest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import me.darsini.mainTest.ExcelDataImport;
import TestData.TestDataBanner;
import TestData.WriteExcel;
import objectRepository.AddBannerPage;


public class AddBannerTest {
	
	static TestDataBanner TestDataObj;
	static ExcelDataImport excelDataObj;
	static WriteExcel writeObj;
	
	static String[] testData;
	public static WebDriver driver;
	AddBannerPage object;
	String verification = "";
	
	@BeforeSuite
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Random Crap\\Studies\\STC\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String URL = "https://admin-uat.darisni.me/auth/login";
		driver.get(URL);

		// maximize browser window
		driver.manage().window().maximize();
		}
	
	@BeforeClass
	public void initialize() {

		try {
			object = new AddBannerPage(driver);
			TestDataObj = new TestDataBanner();
			excelDataObj = new ExcelDataImport();
			excelDataObj.readExcel("Sheet2");
			
			//writeObj = new WriteExcel();
			//writeObj.writeExcel("Sheet2");
			TestDataObj.setFakerData();
			
			} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
@Test
public void mainTest() {
	
	
	object.login();
	testData = TestDataObj.getSignInData();
	object.navigation();
	object.addBanner(testData[0], testData[1], testData[2], testData[3], testData[4], testData[5], testData[6], testData[7], testData[8], testData[9], testData[10],testData[13]);
	
	
	
	
	//VERIFICATION
	ArrayList<String> expectedArray = new ArrayList<String>();
	for(int i=0;i<=12;i++)
	{
		expectedArray.add(testData[i]);
	}
	
	/*expectedArray.add(testData[0]);
	expectedArray.add(testData[1]);
	expectedArray.add(testData[4]);
	expectedArray.add(testData[5]);
	expectedArray.add(testData[6]);
	expectedArray.add(testData[7]);
	expectedArray.add(testData[8]);
	expectedArray.add(testData[9]);
	expectedArray.add(testData[10]);*/
	
	System.out.println(expectedArray);
	
	ArrayList<String> actualArray = new ArrayList<String>();
	
	verification = object.verifyEngTitle.getText();
	actualArray.add(verification);
	verification = object.verifyAraTitle.getText();
	actualArray.add(verification);
	verification = object.verifyCountry.getText().replaceAll(" ","");
	actualArray.add(verification);
	verification = object.verifyGrade.getText();
	actualArray.add(verification);
	verification = object.verifyStartDate.getText();
	actualArray.add(verification);
	verification = object.verifyEndDate.getText();
	actualArray.add(verification);
	verification = object.verifyURL.getText();
	actualArray.add(verification);
	verification = object.verifyLanguage.getText();
	actualArray.add(verification);
	verification = object.verifyStatus.getText();
	actualArray.add(verification);
	
	System.out.println(actualArray);
	
	Assert.assertEquals(actualArray, expectedArray);
	
	//System.out.println("THE GENERATED NAMES ARE AS FOLLOWS: " +TestDataObj.eTitle +" AND "+ TestDataObj.aTitle);

	
	
	object.logout();
	
	
}

}
