package org.alifanov.utility;

import org.openqa.selenium.WebElement;

public class Action {
	public Action() {
	}

	public void ClickOn(WebElement element) {
		element.click();
	}

	public String getTextOf(WebElement element) {
		return element.getText().trim();
	}

	public void SendKeysTo(WebElement element, String text) {
		element.sendKeys(text);
	}
}
