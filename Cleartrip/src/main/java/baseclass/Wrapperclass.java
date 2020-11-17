package baseclass;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Wrapperclass {

protected static WebDriver driver;

	
	public void launch(String url) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\845050\\eclipse-maven\\Cleartrip\\src\\main\\resources\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		 driver= new ChromeDriver(options);
		 driver.get(url);
		 driver.manage().window().maximize();
		 
		
	}
	
}
