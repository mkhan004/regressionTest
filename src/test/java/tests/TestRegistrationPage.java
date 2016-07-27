package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegistrationPage extends TestBase {
	
	@BeforeClass
	public void classSetUp() {
		menuBar.registerLink.click();
	}
	
	@Test
	public void testRegistrationWithValidData() {
		registrationPage.firstNameField.clear();
		registrationPage.firstNameField.sendKeys("Ruhul");
		
		registrationPage.lastNameField.clear();
		registrationPage.lastNameField.sendKeys("Amin");
		
		registrationPage.selectDropdownListElementByValue(registrationPage.genderDropdownList, "Male");
		
		registrationPage.dateOfBirth.clear();
		registrationPage.dateOfBirth.sendKeys("1980-05-10");
		
		registrationPage.phoneNumberField.clear();
		registrationPage.phoneNumberField.sendKeys("347-251-3210");
		
		registrationPage.selectDropdownListElementByValue(registrationPage.userTypeDropdownList, "Jobseeker");
		
		registrationPage.emailField.clear();
		registrationPage.emailField.sendKeys("ruhulny10@gmail.com");
		
		registrationPage.passwordField.clear();
		registrationPage.passwordField.sendKeys("12345678");
		
		registrationPage.confirmPasswordField.clear();
		registrationPage.confirmPasswordField.sendKeys("12345678");
		
		if(!registrationPage.privacyCheckbox.isSelected()){
			registrationPage.privacyCheckbox.click();
		}
		
		if(!registrationPage.subscribeCheckbox.isSelected()){
			registrationPage.subscribeCheckbox.click();
		}
		
		registrationPage.submitButton.click();
		
		
		
	}
	
	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchPageLink.click();
	}

}
