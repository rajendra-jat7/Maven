package testNGExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	@BeforeGroups("Sanity")
	public void beforeGroup() {
		
		System.out.println("Inside Before_Group");
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Inside Before_Test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Inside Before_Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("Inside After_Method");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("Inside After_Test");
	}

}
