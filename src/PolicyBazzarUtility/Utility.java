package PolicyBazzarUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.Reporter;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;


public class Utility 
{
	
	
	//We Write Static method so we can call easly
	//ScreenShot
	//scrollIntoView
	//wait
	//Read form Excel
	//readDataForPropertyFile
	
	public static void takeScreenshot(WebDriver driver,String name) throws IOException 
	{
		
		Reporter.log("Taking ScreenShot", true);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random=RandomString.make(4);   //to save multiple screenshot

		File destination=new File("D:\\practice_selenium\\june_practice\\screenshot\\"+name+random+".png");
		FileHandler.copy(src, destination);
		Reporter.log("taken ScreenShot and saved at location"+destination,true);
		
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		Reporter.log("Scroll Into View", true);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	public static String readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException 
	{
		 FileInputStream myFile=new FileInputStream("D:\\practice_selenium\\policyBazar.xlsx");
		 String value=WorkbookFactory.create(myFile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			Reporter.log("reading data from excel" +row+ "cell num "+cell, true);

		 return value;
		
	}
	public static void waitTime(int waitTimeSec) throws InterruptedException
	{
		Thread.sleep(waitTimeSec);
		Reporter.log("waiting for"+waitTimeSec+"milliSec", true );
	}

}
