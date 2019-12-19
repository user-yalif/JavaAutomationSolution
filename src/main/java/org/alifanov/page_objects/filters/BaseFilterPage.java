package org.alifanov.page_objects.filters;

import org.alifanov.page_objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseFilterPage extends BasePage {
	public BaseFilterPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	private By crossSignLocator = By.xpath("//span[@class='icon abs clear mini']");
	// end Locators
	
	protected void inputPrice(WebElement element, String price) {
		super.action.sendKeysTo(element, price);
	}
	
	protected String getTextFieldValue(WebElement element) {
		return super.action.getTextOf(element);
	}
	
	protected void clickOnCrossIcon(WebElement textField) {
		var cross = textField.findElement(crossSignLocator);
		super.action.clickOn(cross);
	}

	public void inputTextField(WebElement element, String text) {
		super.action.sendKeysTo(element, text);
	}
}
