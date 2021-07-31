package testNGExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 extends BaseClass{
	
	@Test
	public void LoanTest() {
		
		System.out.println("Inside Loan_Test");
	}
	
	@Test(dependsOnMethods="LoanTest")
    public void LoanTest1() {
		
		System.out.println("Inside Loan_Test1");
	}
	
	@Test(dependsOnMethods="LoanTest1")
	public void CreditCardTest() {
		
		System.out.println("Inside Credit_Card_Test");
	}
	

}
