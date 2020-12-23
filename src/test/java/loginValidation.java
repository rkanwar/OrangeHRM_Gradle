import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginValidation extends Orange_HRM_TestData  {
	ChromeDriver driver;

	@BeforeTest
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "LoginExcelData")
	public void Login(String Uname, String Pwd) {
		Boolean boolDisplayed = false;
		driver.findElementByName("txtUsername").clear();
		driver.findElementByName("txtUsername").sendKeys(Uname);
		System.out.println(Uname);
		driver.findElementByName("txtPassword").sendKeys(Pwd);
		System.out.println(Pwd);
		driver.findElementById("btnLogin").click();
		try
		{
		
		boolDisplayed = driver.findElement(By.linkText("Dashboard")).isDisplayed();
		System.out.println(boolDisplayed);
		if (boolDisplayed)
		{
		System.out.println("Successfull Login");
		String strCurrDashboardLabel = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		//Assert.assertEquals(Expectedmessage, strCurrDashboardLabel);
		//Logout
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).isDisplayed();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("Submit")).isDisplayed();
		}
		else {
		System.out.println("Unsuccessfull Login");
		String strInvalidLoginMessage = driver.findElement(By.id("spanMessage")).getText();
		//Assert.assertEquals(Expectedmessage, strInvalidLoginMessage);
		}

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}

		
		//driver.findElementById("welcome").click();
		//driver.findElement(By.xpath("//*[text()='Logout']"));
	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}
}
