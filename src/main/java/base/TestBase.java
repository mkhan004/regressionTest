package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import pages.JobSearchPage;
import pages.MenuBar;
import pages.RegistrationPage;
import pages.SigninPage;


@Listeners(listener.TestListener.class)
public class TestBase extends Driver {

	String browserType = getBrowserType();
	String appUrl = getEnvProperty("appUrl");
	
	protected static JobSearchPage jobSearchPage;
	protected static SigninPage signinPage;
	protected static MenuBar menuBar;
	protected static RegistrationPage registrationPage;
	
	@BeforeTest
	public void setUp(){
		try{
			setDriver(browserType, appUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		signinPage = PageFactory.initElements(driver, SigninPage.class);
		menuBar = PageFactory.initElements(driver, MenuBar.class);
		registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

	}
	
	@AfterTest
	public void tearDown(){
		getDriver().quit();
	}
}
