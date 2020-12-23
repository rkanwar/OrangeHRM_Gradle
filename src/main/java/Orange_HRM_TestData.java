import java.io.IOException;
import java.util.IllegalFormatException;

import org.testng.annotations.DataProvider;

public class Orange_HRM_TestData {
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
	// Multidimensional Object
	// 3X3 or 4X3 or 4X5
	return new Object[][] {

	{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Admin", "admin123" },
	{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "dixit5", "admin123" },
	{ "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "kumar", "admin123" }
	};

	}
	
	@DataProvider(name = "LoginScenario")
	public Object[][] getDataforLoginDifferentScenarios() {
	return new Object[][] {
	{ "admin", "", "Password cannot be empty"},
	{ "", "admin123", "Username cannot be empty" },
	{ "AdminWrong", "admin123", "Invalid credentials" },
	{ "admin", "admin", "Invalid credentials" },
	{ "admin", "admin1234", "Dashboard" } };

	}

	@DataProvider(name = "LoginExcelData")
	public Object[][] Authentication() throws Exception{
		readDataFromExcel excel = new readDataFromExcel();
		//String RelativePath = System.getProperty("user.dir");
		//Object[][] testObjArray = excel.getExcelData("C:\\Users\\adixit\\git\\abhikdixit-Maven_Selenium_WebDriver_4\\Maven_Selenium_WebDriver_4\\OrangeHRM_TestData.xlsx","SignIn");
		Object[][] testObjArray = excel.getExcelData("C:\\Users\\rkp0436\\Desktop\\OrangeHRM_TestData.xlsx","SignIn");
		System.out.println(testObjArray);
		return testObjArray;
}
}
