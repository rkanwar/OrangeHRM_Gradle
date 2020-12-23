import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suacelab_File_Upload_Demo {

	public static final String USERNAME = "rohitsingh.kanwar";
    public static final String ACCESS_KEY = "d4a172c9-67d7-47a4-9375-881c2add3d60";
    //public static final String URL = "https://" + "abhikdixit" + ":" + "d246025c-7be6-497f-9206-2db3dd761350" + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	@Test
	public void FileUpload_UsingSikuli() throws Exception {
		//WebDriverManager.chromedriver().setup();
		String filepath = System.getProperty("user.dir");
		String spath=filepath+"\\Sikuli_Objects\\";
		//String inputFilePath = "D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\Sikuli_Scripts\\";
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(spath+"FileTextBox.PNG");
		Pattern openButton = new Pattern(spath+"OpenButtonNew.png");

DesiredCapabilities sauceOptions = new DesiredCapabilities();
    	
    	//EdgeOptions browserOptions = new EdgeOptions();
    	ChromeOptions browserOptions = new ChromeOptions();
    	//SafariOptions browserOptions = new SafariOptions();
    	//FirefoxOptions browserOptions = new FirefoxOptions();
    	//browserOptions.setExperimentalOption("w3c", true);
    	browserOptions.setCapability("platformName", "macOS 10.13");
    	//browserOptions.setCapability("platformName", "Windows 10");
    	//browserOptions.setCapability("platformName", "Windows 7");
    	browserOptions.setCapability("browserVersion", "latest");
    	browserOptions.setCapability("sauce:options", sauceOptions);
   	
        WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), browserOptions);
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		driver.manage().window().maximize();
		driver.get("https://gofile.io/uploadFiles");
		
		Thread.sleep(2000);
		// Click on Browse button and handle windows pop up using Sikuli
		driver.findElement(By.xpath("//button[@id='dropZoneBtnSelect']")).click();
		s.wait(fileInputTextBox, 20);
		s.type(fileInputTextBox,spath+"Fuel_Bill.jpg");
		s.click(openButton);

		// Close the browser	
		//driver.close();

	}
}
