package org.alifanov.utility;

import org.openqa.selenium.WebElement;

public class Action {
	public Action() {
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public String getTextOf(WebElement element) {
		return element.getText().trim();
	}

	public void clear(WebElement element) {
		element.clear();
	}
	
	public void sendKeysTo(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void submitOf(WebElement element) {
		element.submit();
	}
}
