package PolicyBazzarTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PolicyBazzarBase.Base;
import PolicyBazzarPOM.homepage;
import PolicyBazzarPOM.profilepage;
import PolicyBazzarUtility.Utility;

@Listeners(PolicyBazzarBase.Listener.class)
public class PB_TC_4567_validateUserName extends Base {
 
	homepage home;	//declaration of object only
	profilepage profile;
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		launchBrowser();  //we are calling method in method so no need of object(method is calling itself)method recursion. object is needed in main meyhod 
	home =new homepage(driver);  //initialization pf object
	profile =new profilepage(driver);
	Utility.waitTime(1000);
	}@BeforeMethod
	public void logIntoPolicyBazzar() throws InterruptedException, EncryptedDocumentException, IOException {
		home.homepageclickonsignbutton();
		Utility.waitTime(1000);
		home.enterNumber(Utility.readDataFromExcel(0, 0));
		Utility.waitTime(1000);
		home.clickonpassword();
		Utility.waitTime(1000);
		home.enterpassword(Utility.readDataFromExcel(0, 1));
		Utility.waitTime(1000);
		home.clickOnSignIn();
		Utility.waitTime(2000);
		home.clickmyAccount();
		Utility.waitTime(1000);
		home.clickmyprofile();
		Utility.waitTime(1000);
		
		//there will be multiple tab we need to change selenium focus with getwindow handles
		Set<String>allID =driver.getWindowHandles();
		ArrayList<String> al=new ArrayList<>(allID);
		String mainpage = al.get(0);
		String childpage=al.get(1);
		driver.switchTo().window(childpage);
		Utility.waitTime(1000);Utility.waitTime(1000);
	}
	
	
	@Test
  public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	String expUN= Utility.readDataFromExcel(0, 2);
	String actualUN=  profile.getActualUserName();
	Assert.assertEquals(actualUN, expUN,"actual userName and Expected is not matching");
	
	Thread.sleep(2000);
	Utility.takeScreenshot(driver, "TC_4567"+actualUN);
  }
	@AfterMethod
	public void logOutfromPolivybazzar() throws InterruptedException
	{
		Utility.waitTime(5000);
		profile.clickonlogout();
	}
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		closeBrowser();
		Utility.waitTime(1000);
	}
}

