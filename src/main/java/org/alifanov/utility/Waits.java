package org.alifanov.utility;

import static org.alifanov.utility.PropertiesHelper.properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private int explicitTimeOut = Integer.parseInt(properties.getProperty("wait.explicit.timeout"));
	private int implicitTimeOut = Integer.parseInt(properties.getProperty("wait.implicit.timeout"));

	public Waits(WebDriver driver) {
		this.webDriver = driver;

		this.webDriver.manage().timeouts().implicitlyWait(this.implicitTimeOut, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(this.webDriver, explicitTimeOut);
	}

	public void waitPresenceOf(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
