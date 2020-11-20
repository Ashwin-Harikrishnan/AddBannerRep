package me.darsini.mainTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class baseClass {
	public WebDriver driver;
	
	
	public void driverSetup() {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\Random Crap\\Studies\\STC\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}
}
