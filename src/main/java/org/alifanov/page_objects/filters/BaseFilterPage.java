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
	private By suggestInputDropdownLocator = By.xpath("//ul[contains(@class, 'small suggestinput')]");
	
	private WebElement crossIconOf(WebElement element) {
		return element.findElement(crossSignLocator);
	}
	
	protected WebElement suggestInputDropdownLocatorOf(WebElement element) {
		return element.findElement(suggestInputDropdownLocator);
	}
	// end Locators

	protected void inputPrice(WebElement element, String price) {
		super.action.sendKeysTo(element, price);
	}

	protected String getTextFieldValue(WebElement element) {
		return super.action.getTextOf(element);
	}

	protected void clickOnCrossIconOf(WebElement textField) {
		super.action.clickOn(crossIconOf(textField));
	}

	public void inputTextField(WebElement element, String text) {
		super.action.sendKeysTo(element, text);
	}
}
