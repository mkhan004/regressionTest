package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver{

	public String getTitle(){
		return driver.getTitle();
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public String selectDropdownListElementByValue(WebElement locator, String value) {
		Select sl = new Select(locator);
		sl.selectByValue(value);
		return sl.getFirstSelectedOption().getText();
	}
}
