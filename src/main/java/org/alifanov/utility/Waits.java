package org.alifanov.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.alifanov.utility.PropertiesHelper.properties;

public class Waits {
	private WebDriver webDriver;
	private WebDriverWait wait;
	private int explicitTimeOut = Integer.parseInt(properties.getProperty("wait.explicit.timeout"));
	private int implicitTimeOut = Integer.parseInt(properties.getProperty("wait.implicit.timeout"));
	
	public Waits(WebDriver driver) {
		this.webDriver = driver;
		this.wait = new WebDriverWait(this.webDriver, explicitTimeOut);
	}
	
	public void waitThread(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
