package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class RegistrationPage extends PageBase {

	@FindBy( name = "submit" )
	public WebElement submitButton;
	
	@FindBy( xpath = "//*[@id='body_content']/center" )
	public WebElement errorMessage;
}
