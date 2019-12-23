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
	protected Logger baseTestLog = LogHelper.getLogger(UIBaseTest.class);
	protected Logger testLogger;
	
	public UIBaseTest() {
	}

	private void LoadBrowser() {
		baseTestLog.info(String.format("%s browser loading", browserType));
		driver = new Drivers(browserType);
		baseTestLog.info(String.format("Go to page: %s", testEnvUrl));
		driver.getWebBrowser().get(testEnvUrl);
	}

	@Before
	public void launchBrowser() {
		LoadBrowser();
	}

	@After
	public void closeAllTestResourses() {
		for (WebDriver webDriverInstance : Drivers.webBrowserInstanses) {
			webDriverInstance.quit();
			baseTestLog.info(String.format("%s Driver: Quit", browserType));
		}

		Drivers.webBrowserInstanses.clear();
	}
}
