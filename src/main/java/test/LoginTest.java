package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testNGExamples.TestNGListner;

@Listeners(TestNGListner.class)

public class LoginTest {
	
	WebDriver driver;
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;

	@BeforeMethod	
	public void Setup() throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		
		sheet = wbook.getSheet("data");
	}
	
	@Test
	@Parameters({"username","password"})
	public void Testcase1(String username, String password) {
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		WebElement Username = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement Remember = driver.findElement(By.className("rememberMe"));
		
		
		String excelUsername = sheet.getRow(0).getCell(0).getStringCellValue();
		String excelPassword = sheet.getRow(0).getCell(1).getStringCellValue();
		
		
		Username.sendKeys(excelUsername);
		Password.sendKeys(excelPassword);
		Remember.click();
		LoginBtn.click();
		
		/*WebElement LoginError = driver.findElement(By.id("msg_box"));
		
		String ActError = LoginError.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError, ExpError);
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links:-" + Links.size());
		
        List<WebElement> Input = driver.findElements(By.tagName("input"));
		
		System.out.println("Total Input:-" + Input.size());*/
	}
	
	@AfterMethod
	public void CleanUp() {
		driver.quit();
		
	}

}
