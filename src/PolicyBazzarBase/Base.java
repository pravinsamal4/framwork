package PolicyBazzarBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import PolicyBazzarUtility.Utility;

public class Base {
protected  WebDriver driver;   //protected bex bydefault it is default access modifier will not go in other package if we make procected it will acces it bez it is sub class 
	public void launchBrowser() throws InterruptedException {
		
		driver=new ChromeDriver();
		Reporter.log("launching browser of ", true);
		driver.get("https://www.policybazaar.com/");
	    Utility.waitTime(1000);
		driver.manage().window().maximize();
	}
	public void closeBrowser() throws InterruptedException {
		driver.quit();
	    Utility.waitTime(1000);

	}
	
}
