package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://en-gb.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement RegisterButton = driver.findElement(By.xpath("//*[text()='Create New Account']")); ////*[contains(text(),'New Account')]  ////*[starts-with(text(),'Create')]


		
		RegisterButton.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement EmailConfig = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		WebElement NewPassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		WebElement Day = driver.findElement(By.xpath("//*[@id='day']"));
		WebElement Month = driver.findElement(By.xpath("//*[@id='month']"));
		WebElement Year = driver.findElement(By.xpath("//*[@id='year']"));
		WebElement Gender = driver.findElement(By.xpath("//label[text()='Male']")); ////*[@type='radio' and @value='2']
		
		
		FirstName.sendKeys("Rajendra");
		LastName.sendKeys("Jat");
		Email.sendKeys("jatrj18@gmail.com");
		EmailConfig.sendKeys("jatrj18@gmail.com");
		NewPassword.sendKeys("R@jendr@7");

		Select DayDropDown = new Select(Day);
		DayDropDown.selectByVisibleText("22");
		
		Select MonthDropDown = new Select(Month);
		MonthDropDown.selectByVisibleText("Dec");
		//MonthDropDown.selectByValue("12");
		//MonthDropDown.selectByIndex(12);
		
		Select YearDropDown = new Select(Year);
		YearDropDown.selectByVisibleText("1998");
		
		Gender.click();
	}

}
