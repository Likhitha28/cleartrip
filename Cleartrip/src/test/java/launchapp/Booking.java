package launchapp;

import java.io.File;
import java.io.IOException;
///import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;

//import baseclass.Wrapperclass;
import data.Exceldata;

public class Booking {

	
	
     
     public void Tickets() throws InterruptedException, IOException {
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\845050\\eclipse-maven\\Cleartrip\\src\\main\\resources\\Driver\\chromedriver.exe");

 		ChromeOptions options = new ChromeOptions();
 		options.addArguments("--disable-notifications");
 		
 		WebDriver driver= new ChromeDriver(options);
 		 driver.get("https://www.cleartrip.com/");
 		 driver.manage().window().maximize();
    	 //select round trip
    	WebElement element0  = driver.findElement(By.xpath("//*[@id=\'RoundTrip\']"));
    	element0.click(); 
     	
    	 //From location
     	WebElement element = driver.findElement(By.xpath("//*[@id=\'FromTag\']"));
     	element.click();
     	element.sendKeys(Exceldata.getCellValue("Sheet1",0,0));
     	element.sendKeys(Keys.DOWN);
     	element.sendKeys(Keys.ENTER);
     	Thread.sleep(2000);
     	
     	//To location 
     	WebElement element1 = driver.findElement(By.xpath("//*[@id=\'ToTag\']"));
     	element1.click();
     	element1.sendKeys(Exceldata.getCellValue("Sheet1",0,1));
     	element1.sendKeys(Keys.DOWN);
     	element1.sendKeys(Keys.ENTER);
     	Thread.sleep(2000);
     	
     	//departure date
     	driver.findElement(By.xpath("//*[@id=\'DepartDate\']")).click();
     	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[5]/td[5]/a")).click();
     	Thread.sleep(2000);
     	
     	//Return date
     	driver.findElement(By.xpath("//*[@id=\'ReturnDate\']")).click();
     	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[5]/td[6]/a")).click();
     	Thread.sleep(2000);
     	
     	//selecting Adults
     	driver.findElement(By.xpath("//*[@id=\'Adults\']")).click();
     	driver.findElement(By.xpath("//*[@id=\'Adults\']//*[text()='2']")).click();
     	Thread.sleep(2000);
     	
     	//searching for flights
     	driver.findElement(By.xpath("//*[@id=\'SearchBtn\']")).click();
     	Thread.sleep(2000);
     	 
     	//Taking Screenshot of flight list
     	File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     	FileUtils.copyFile(file, new File("C:\\Users\\845050\\eclipse-maven\\Cleartrip\\src\\main\\resources\\Screenshot\\Trip.PNG"));
     	
     	//Closing app
     	driver.quit();
      }
     
     
}
