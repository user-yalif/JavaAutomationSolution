package org.alifanov.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
	private WebDriver webDriver;
	
	public Action(WebDriver driver) {
		this.webDriver = driver;
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
	
	public void pressEnter() {
		new Actions(this.webDriver).sendKeys(Keys.ENTER).perform();
	}
	
	public boolean isChecked(WebElement element) {
		return element.isSelected();
	}
}
