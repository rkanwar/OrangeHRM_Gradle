import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class mobileBrowserDemo {
	WebDriver driver;
  @Test
  public void SignOn() {
	  
	  Dimension d = new Dimension(640, 960);
      driver.manage().window().maximize();
      driver.manage().window().setSize(d);
		
		

  }
  @BeforeTest
  public void LaunchBrowser() {
		//String absolutePath=System.getProperty("user.dir");
		//String filepath=absolutePath+"\\chromedriver.exe";
		
		//System.setProperty("webdriver.chrome.driver",filepath);
		
        //ChromeOptions iPhoneOption = new ChromeOptions();
	    WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.borrowlenses.com/");
        

  }

  @AfterTest
  public void CloseBrowser() {
	//	driver.quit();
  }

}
