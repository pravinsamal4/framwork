package PolicyBazzarPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class profilepage {
	@FindBy(xpath = "//div[@class=\"textCapitalize sc-ckVGcZ kWpXlQ\"]")private WebElement username;
	@FindBy(xpath = "//div[@title=\"Logout\"]")private WebElement logout;
	
	public profilepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

//	public void validateusername() {
//		String actualUN=username.getText();
//		String expUN="Rajashri Kadam";
//		if(expUN.equals(actualUN)) {
//			System.out.println("actual is matched with expected ");
//		}
//		else {
//			System.out.println("not ma6ched");
//		}
//		
//	}
	
	public String getActualUserName() {
		Reporter.log("getting actual username", true);
		String actualusername=username.getText();
		return actualusername;
		
	}
	public void clickonlogout() {
		Reporter.log("clicking on logout buutton", true);
		logout.click();
	}

}
