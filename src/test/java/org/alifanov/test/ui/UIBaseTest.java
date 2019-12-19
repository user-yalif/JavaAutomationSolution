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
		return driver.getWebBrowser();
	}

	private String browserType = properties.getProperty("browser.type");
	private String testEnvUrl = properties.getProperty("test.env.url");
	private Logger log = LogHelper.getLogger(UIBaseTest.class);

	public UIBaseTest() {
	}

	private void LoadBrowser() {
		this.log.info(String.format("%s browser loading", this.browserType));
		this.driver = new Drivers(this.browserType);
		this.log.info(String.format("Go to page: %s", testEnvUrl));
		this.driver.getWebBrowser().get(testEnvUrl);
	}

	@Before
	public void launchBrowser() {
		this.LoadBrowser();
	}

	@After
	public void closeAllTestResourses() {
		for (WebDriver webDriverInstance : Drivers.webBrowserInstanses) {
			webDriverInstance.quit();
			log.info(String.format("%s Driver: Quit", this.browserType));
		}

		Drivers.webBrowserInstanses.clear();
	}
}
