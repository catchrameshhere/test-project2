package test;

import org.testng.annotations.Test;

import utils.Common;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Base {
	Common common;
	//	String browser = "chrome";
	String url = "https://en-gb.facebook.com";
	static WebDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser) {
		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
	}

	@AfterTest
	public void afterTest() {
		//quitting the browser
		common.quitBrowser();
	}

}
