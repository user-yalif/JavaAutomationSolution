package org.alifanov.test_cases;

import org.alifanov.configurations.Drivers;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class UIBaseTest {

	private Drivers driver;
	public WebDriver getDriver() {
		return driver.webBrowser;
	}
	private String browserType = "Chrome";
	private String testEnvUrl = "https://www.olx.ua/transport/legkovye-avtomobili/dnepr/q-" + 
			"%D0%BB%D0%B5%D0%B3%D0%BA%D0%BE%D0%B2%D1%8B%D0%B5-" + 
			"%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D0%B8/";

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
