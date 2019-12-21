package org.alifanov.utility;

import static org.alifanov.utility.PropertiesHelper.properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private final int explicitTimeOut = Integer.parseInt(properties.getProperty("wait.explicit.timeout"));
	private final int implicitTimeOut = Integer.parseInt(properties.getProperty("wait.implicit.timeout"));

	public Waits(WebDriver driver) {
		this.webDriver = driver;

		this.webDriver.manage().timeouts().implicitlyWait(this.implicitTimeOut, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(this.webDriver, this.explicitTimeOut);
	}

	public boolean disappearenceOf(By locator) {

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					input.findElement(locator);
					return false;
				} catch (NoSuchElementException e) {
					return true;
				}
			}
		};

		return wait.until(condition);
	}

	public boolean appearenceOf(By locator) {

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				try {
					input.findElement(locator);
					return true;
				} catch (NoSuchElementException e) {
					return false;
				}
			}
		};

		return wait.until(condition);
	}
}
