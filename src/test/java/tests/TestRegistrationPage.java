package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegistrationPage extends TestBase {
	
	@BeforeClass
	public void classSetUp(){
		menuBar.registerLink.click();
	}

	@Test
	public void testRegistrationWithEmptyFields(){
		
		registrationPage.submitButton.click();
		
		Assert.assertEquals(registrationPage.errorMessage.getText(), "Ops! There is Some Error!!");
	}
}
