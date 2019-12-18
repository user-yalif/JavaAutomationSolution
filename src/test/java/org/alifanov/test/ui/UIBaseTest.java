package org.alifanov.test.ui;

import org.alifanov.configurations.Drivers;
import org.alifanov.utility.LogHelper;
import org.apache.log4j.Logger;
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
	private Logger log = LogHelper.getLogger(UIBaseTest.class);

	public UIBaseTest() {
	}

	@Before
	public void launchBrowser() {
		this.LoadBrowser();
	}

	private void LoadBrowser() {
		this.log.info("Loading browser");
		this.driver = new Drivers(this.browserType);
		this.driver.webBrowser.get(testEnvUrl);
	}

	@After
	public void closeAllTestResourses() {
		for (WebDriver webDriverInstance : Drivers.webBrowserInstanses) {
			webDriverInstance.quit();
			log.info("Driver: Quit");
		}

		Drivers.webBrowserInstanses.clear();
	}

}
