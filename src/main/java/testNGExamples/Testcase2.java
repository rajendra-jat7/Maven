package testNGExamples;

import org.testng.annotations.Test;

public class Testcase2 extends BaseClass {
	
	@Test
	public void LoanTest2() {
		
		System.out.println("Inside Loan_Test2");
	}
	
	@Test(groups= {"Sanity"})
	public void InsuranceTest() {
		
		System.out.println("Inside Insurance_Test");
	}

}
