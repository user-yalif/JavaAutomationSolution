package org.alifanov.test.ui;

import org.alifanov.configurations.Drivers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static org.alifanov.utility.PropertiesHelper.properties;

public class UIBaseTest {

	private Drivers driver;
	public WebDriver getDriver() {
		return driver.webBrowser;
	}
	private String browserType = properties.getProperty("browser.type");
	private String testEnvUrl = properties.getProperty("test.env.url");

	public UIBaseTest() {
	}

	@Before
	public void launchBrowser() {
		this.LoadBrowser();
	}

	private void LoadBrowser() {
		this.driver = new Drivers(this.browserType);
		this.driver.webBrowser.get(testEnvUrl);
	}

	@After
	public void closeAllTestResourses() {
		for (WebDriver webDriverInstance : Drivers.webBrowserInstanses) {
			webDriverInstance.close();
		}

		Drivers.webBrowserInstanses.clear();
	}

	
}
