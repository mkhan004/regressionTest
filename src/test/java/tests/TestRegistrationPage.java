package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
		int rand = registrationPage.getRandomNumber(1000000, 100);
		String email = "ruhulny"+ rand +"@gmail.com";
		System.out.println(email);
		registrationPage.emailField.sendKeys(email);
		
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
		
		boolean condition = registrationPage.getCurrentUrl().contains("/profile.php");
		
		Assert.assertTrue(condition);
		
		// TODO logout
		// TODO click register link to come back registration page
	}
	
	@Test
	public void testRegistrationWithEmptyRequiredFields(){
		menuBar.registerLink.click();
		registrationPage.submitButton.click();
		
		List<WebElement> errorList = registrationPage.errorWebElementList;
		
		Assert.assertEquals(errorList.get(0).getText(), "* FirstName can not be empty.");
		Assert.assertEquals(errorList.get(1).getText(), "* LastName can not be empty.");
		Assert.assertEquals(errorList.get(2).getText(), "* Gender can not be empty.");
		Assert.assertEquals(errorList.get(3).getText(), "* DateOfBirth can not be empty.");
		Assert.assertEquals(errorList.get(4).getText(), "* PhoneNo can not be empty.");
		Assert.assertEquals(errorList.get(5).getText(), "* UserType can not be empty.");
		Assert.assertEquals(errorList.get(6).getText(), "* Email can not be empty.");
		Assert.assertEquals(errorList.get(7).getText(), "* Password can not be empty.");
		Assert.assertEquals(errorList.get(8).getText(), "* ConfirmPassword can not be empty.");
		Assert.assertEquals(errorList.get(9).getText(), "* Captcha can not be empty.");
		
		boolean condition = registrationPage.getCurrentUrl().contains("/register.php");
		Assert.assertTrue(condition);
	}
	
	@AfterClass
	public void classTearDown() {
		menuBar.jobSearchPageLink.click();
	}

}
