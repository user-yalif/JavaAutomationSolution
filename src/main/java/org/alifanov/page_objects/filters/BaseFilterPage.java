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
	private final By crossSignLocator = By.xpath("//span[@class='icon abs clear mini']");
	private final By dropdownLocator = By.xpath("//ul[contains(@class, 'small suggestinput') and @style='display: block;']");
	private final By pageLoader = By.xpath("//div[@class='pageloader' and contains(@style, 'none')]//div[contains(@style, 'width: 0px')]");
	
	private WebElement crossIconOf(WebElement element) {
		return element.findElement(crossSignLocator);
	}
	
	protected WebElement dropdownLocatorOf(WebElement element) {
		return element.findElement(dropdownLocator);
	}
	// end Locators

	protected void inputPrice(WebElement element, String price) {
		action.sendKeysTo(element, price);
	}

	protected String getTextFieldValue(WebElement textField) {
		return action.getTextOf(textField);
	}

	protected void clickOnCrossIconOf(WebElement textField) {
		action.clickOn(crossIconOf(textField));
	}

	public void inputTextField(WebElement textFieldInput, String text) {
		action.sendKeysTo(textFieldInput, text);
	}
	
	public void waitForPageLoaded() {
		wait.appearenceOf(pageLoader);
	}
}
