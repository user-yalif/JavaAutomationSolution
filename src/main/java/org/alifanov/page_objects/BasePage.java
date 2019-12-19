package org.alifanov.page_objects;

import java.util.List;

import org.alifanov.utility.Action;
import org.alifanov.utility.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lombok.Getter;

public class BasePage {
	private @Getter WebDriver webDriver;
	protected Action action;
	protected Waits wait;

	public BasePage(WebDriver driver) {
		this.webDriver = driver;
		this.action = new Action();
		this.wait = new Waits(this.webDriver);
	}

	protected WebElement getElement(By locator) {
		return this.webDriver.findElement(locator);
	}

	protected List<WebElement> getElements(By locator) {
		return this.webDriver.findElements(locator);
	}
}
