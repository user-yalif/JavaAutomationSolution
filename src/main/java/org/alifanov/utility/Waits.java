package org.alifanov.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private static int explicitTimeOut = 30;
	
	public Waits(WebDriver driver) {
		this.webDriver = driver;
		this.wait = new WebDriverWait(this.webDriver, explicitTimeOut);
	}
}
