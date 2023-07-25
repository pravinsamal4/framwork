package PolicyBazzarPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class homepage {
		//variable
	
	@FindBy(xpath = "//a[@class=\"sign-in\"]") private WebElement signINButton;
	@FindBy(xpath = "(//input[@type=\"number\"])[2]")private WebElement mobileNum;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement signInPass;
	@FindBy(xpath = "//input[@name=\"password\"]")private WebElement password;
	@FindBy(xpath = "//a[@id=\"login-in-with-password\"]")private WebElement signIn;
	@FindBy(xpath = "//div[text()='My Account']")private WebElement myaccount;
	@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myprofile;
	
	
	
	//Constructor
	
	public homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	
	public void homepageclickonsignbutton() {
		signINButton.click();
		Reporter.log("clicking on HomePageSignIn Button", true);
	}
	
	public void enterNumber(String mob) {
		mobileNum.sendKeys(mob);
		Reporter.log("entering MobNum", true);
	}
	
	public void clickonpassword() {
		signInPass.click();
		Reporter.log("clicking on Sign in password button", true);
	}
	
	public void enterpassword(String pass) {
		password.sendKeys(pass);
		Reporter.log("entering password", true);
	}
	
	public void clickOnSignIn() {
		signIn.click(); 
		Reporter.log("clicking on sign in button", true);
	}
	
	public void clickmyAccount() {
		myaccount.click();
		Reporter.log("clicking my account", true);
	}
	public void clickmyprofile() {
		myprofile.click();
		Reporter.log("clicking on myprofile", true);
	}
	
	}
 