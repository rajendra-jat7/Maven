package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		
		WebElement Username = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement Remember = driver.findElement(By.className("rememberMe"));
		
		
		Username.sendKeys("jatrj18@gmail.com");
		Password.sendKeys("R@jendr@");
		Remember.click();
		LoginBtn.click();
		
		WebElement LoginError = driver.findElement(By.id("msg_box"));
		
		String ActError = LoginError.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		if(ActError.equals(ExpError)) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links" + Links.size());
		
        List<WebElement> Input = driver.findElements(By.tagName("input"));
		
		System.out.println("Total Input" + Input.size());
		
		driver.quit();
		
	}

}
