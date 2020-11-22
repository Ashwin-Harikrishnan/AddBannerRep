package objectRepository;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddBannerPage {
	static WebDriver driver;
	
	

	// For navigation to required page
	@FindBy(id = "email")
	public static WebElement emailField;
	@FindBy(id = "password")
	public static WebElement passwordField;
	@FindBy(id = "login-form-submit")
	public static WebElement loginButton;
	@FindBy(xpath = "//i[@class = 'fa fa-chevron-down']")
	public static WebElement dashBoardDropDown;
	@FindBy(linkText = "Academy Admin")
	public static WebElement AcademyAdminButton;
	@FindBy(id = "nav-icon2")
	public static WebElement dashboardButton;
	@FindBy(linkText = "Add Banner")
	public static WebElement addBannerButton;

	// Add Banner page
	@FindBy(xpath = "//input[@formcontrolname='title_en']")
	public WebElement englishTitle;
	@FindBy(xpath = "//input[@formcontrolname='title_ar']")
	public WebElement arabicTitle;
	@FindBy(id = "fileInputField1")
	public WebElement englishImageButton;
	@FindBy(id = "fileInputField2")
	public WebElement arabicImageButton;
	@FindBy(xpath = "//p-multiselect[@formcontrolname = 'country_id']")
	public static WebElement selectCountry;
	@FindBy(xpath = "//input[@class = 'ui-inputtext ui-widget ui-state-default ui-corner-all']")
	public static WebElement selectCountrySearch;
	@FindBy(xpath = "//div[@class = 'ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	public static WebElement selectCountryCheckbox;
	@FindBy(xpath = "//p-multiselect[@formcontrolname = 'grade_id']")
	public static WebElement selectGrade;
	@FindBy(xpath = "//input[@class = 'ui-inputtext ui-widget ui-state-default ui-corner-all']")
	public static WebElement selectGradeSearch;
	@FindBy(xpath = "//div[@class = 'ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	public static WebElement selectGradeCheckbox;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::input[1]")
	public static WebElement startCalendar;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::input[2]")
	public static WebElement endCalendar;
	@FindBy(xpath = "//input[@formcontrolname = 'target_url']")
	public static WebElement targetUrl;
	@FindBy(xpath = "//label[contains(text(),'Select Country')]//following::p-multiselect[3]")
	public static WebElement selectLanguage;
	@FindBy(xpath = "//input[@class = 'ui-inputtext ui-widget ui-state-default ui-corner-all']")
	public static WebElement selectLanguageSearch;
	@FindBy(xpath = "//div[@class = 'ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
	public static WebElement selectLanguageCheckbox;
	@FindBy(xpath = "//select[@formcontrolname = 'status']")
	public static WebElement selectStatus;
	@FindBy(id = "type")
	public static WebElement paidUserCheckbox;
	@FindBy(xpath = "//button[@class = 'btn btn-primary']")
	public static WebElement buttonSave;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public static WebElement buttonCancel;
	@FindBy(xpath = "//label[contains(text(),'Ad Image for English')]//following::div[1]")
	public static WebElement imagePreview;
	@FindBy(xpath = "//h5[contains(text(),'Banner')]//following::i[1]")
	public static WebElement detailsButton;
	@FindBy(xpath = "//div[contains(text(),'Common ads added successfully')]")
	public WebElement notificationSuccess;
	
	public String successMessage = notificationSuccess.getText();
	public String expectedMessage = "Common ads added successfully";
	

	// CALENDAR
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[1]")
	public WebElement startDate;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[2]")
	public WebElement startMonthBack;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[3]")
	public WebElement startMonthMid;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[4]")
	public WebElement startMonthNext;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[5]")
	public WebElement startToday;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[6]")
	public WebElement startYearBack;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[7]")
	public WebElement startYearMid;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::button[8]")
	public WebElement startYearNext;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]//following::tbody[2]")
	public WebElement dates;
	@FindBy(xpath = "//td[@class = 'daycell currmonth tablesingleday ng-star-inserted']")
	public WebElement reqDate;
	

	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[1]")
	public WebElement endDate;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[2]")
	public WebElement endMonthBack;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[3]")
	public WebElement endMonthMid;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[4]")
	public WebElement endMonthNext;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[5]")
	public WebElement endToday;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[6]")
	public WebElement endYearBack;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[7]")
	public WebElement endYearMid;
	@FindBy(xpath = "//label[contains(text(),'End Date')]//following::button[8]")
	public WebElement endYearNext;
	
	//VERIFICATION
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[1]")
	public WebElement verifyEngTitle;	
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[2]")
	public WebElement verifyAraTitle;	
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[3]")
	public WebElement verifyCountry;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[4]")
	public WebElement verifyGrade;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[5]")
	public WebElement verifyStartDate;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[6]")
	public WebElement verifyEndDate;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[7]")
	public WebElement verifyURL;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[8]")
	public WebElement verifyLanguage;
	@FindBy(xpath = "//h5[contains(text(),'View Banner')]//following::span[9]")
	public WebElement verifyStatus;
	
	//LOGOUT
	@FindBy(xpath="//i[@class = 'fas fa-sign-out-alt logout']")public static WebElement logout;
	@FindBy(xpath="//span[contains(text(),'Yes')]")public static WebElement logoutConfirm;
	@FindBy(xpath="//a[contains(text(),'Logout')]")public static WebElement finalLogout;
	
	
	
	
	// LOGIN METHOD
	public void login() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		emailField.sendKeys("automationnew@mailinator.com");
		passwordField.sendKeys("Strongpassword1");
		loginButton.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			
	}
	
	public void navigation() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(dashBoardDropDown));
			dashBoardDropDown.click();

			sleep(2000);
			AcademyAdminButton.click();

			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			// sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(dashboardButton));
			sleep(2000);

			dashboardButton.click();
			wait.until(ExpectedConditions.visibilityOf(addBannerButton));
			addBannerButton.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	}
	
	

	// MAIN TEST METHOD
	public void addBanner(String engTitle, String araTitle, String engImg, String araImg, String country, String grade, String sDate, String eDate, String url, String language, String status, boolean checkBox) {
		
		//System.out.println("THE GENERATED NAME IS:    "+eTitle +" , "+ aTitle);
	try {	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(englishTitle));
		englishTitle.sendKeys(engTitle);
		arabicTitle.sendKeys(araTitle);
		
		englishImageButton.sendKeys(engImg);
		arabicImageButton.sendKeys(araImg);
		uploadWait(imagePreview);
		sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(selectCountry));
			
		String[] sCountry = country.split(",");
		int num = sCountry.length;
		System.out.println("Size is: "+num);
		sleep(1000);
		selectCountry.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectCountrySearch));
		
		for(int i =0;i<=num-1;i++)
		{
			System.out.println(i);
			String choice = sCountry[i]; // UAE, Turkey , Oman
			System.out.println("The value required is: "+sCountry[i]);
		
			selectCountrySearch.sendKeys(choice);
			sleep(1000);
			countryNameText(choice).click();
			sleep(1000);
			selectCountrySearch.clear();
		}
		
		
		selectGrade.click();
		sleep(500);
		selectGradeSearch.sendKeys(grade);
		selectGradeCheckbox.click();
		
		sleep(1000);
		startCalendar.sendKeys(sDate);
		sleep(1000);
		endCalendar.sendKeys(eDate);
				
		targetUrl.sendKeys(url);
		
		selectLanguage.click();
		sleep(500);
		selectLanguageSearch.sendKeys(language);
		selectLanguageCheckbox.click();
		
		selectStatus.sendKeys(status);
		
		System.out.println("THE VALUE IS: " + checkBox);
		
	
				
		if(checkBox)
		{
			paidUserCheckbox.click();
		}
		else
		{
			System.out.println("User has not checked the checkbox");
		}
		
		//buttonSave.click();
		
		
		System.out.println("THE MESSAGE IS: " + successMessage);
		
		Assert.assertTrue(successMessage.contains(expectedMessage),
				"Actual success message does not contain the expected message.\n Actual Message: " + successMessage
						+ "\n Expected Message: " + expectedMessage);
		sleep(2000);
		
		System.out.println("This is filler for git");
		//wait.until(ExpectedConditions.elementToBeClickable(detailsButton));
		//detailsButton.click();
		sleep(4000);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		}
	
	}
		
	public static WebElement countryNameText(String countryText)
	{
	    WebElement cCheckBox =  driver.findElement(By.xpath("//label[contains(text(),'"+countryText+"')]//parent::li"));
	    return cCheckBox;
	}
	

	public static void uploadWait(WebElement element) {

		for (int i = 1; i < 5; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 20);

			System.out.println("upload");
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}
	
	public void logout() {
		try {
		logout.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(logoutConfirm));
		logoutConfirm.click();
		sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(dashBoardDropDown));
		dashBoardDropDown.click();
		sleep(500);
		finalLogout.click();
		sleep(1000);
		driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
	}
	

	public AddBannerPage(WebDriver driver) {
		AddBannerPage.driver = driver;
		PageFactory.initElements(AddBannerPage.driver, this);
	}

	private static void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
