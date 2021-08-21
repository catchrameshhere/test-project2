package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {
	private WebDriver driver;
	
	public void setupBrowser(String browser, String url) {
		String currDir = System.getProperty("user.dir");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", currDir + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("valid browser is not provided, hence quitting the automation run");
			System.exit(0);
		}
		
		if(url!="")
			driver.get(url);
		else
			driver.get("about:blank");
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
