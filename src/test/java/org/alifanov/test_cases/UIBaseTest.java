package org.alifanov.test_cases;

import org.alifanov.configurations.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import lombok.Getter;
import lombok.Setter;

public class UIBaseTest {

	public @Getter @Setter Drivers driver;
	protected String browserType = "Chrome";
	protected String testEnvUrl = "https://www.olx.ua/transport/legkovye-avtomobili/dnepr/q-" + 
			"%D0%BB%D0%B5%D0%B3%D0%BA%D0%BE%D0%B2%D1%8B%D0%B5-" + 
			"%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D0%B8/";

	public UIBaseTest() {

	}

	@BeforeClass
	public void launchBrowser() {
		this.LoadBrowser();
	}

	private void LoadBrowser() {
		this.driver = new Drivers(this.browserType);
		this.driver.webBrowser.get(testEnvUrl);
	}

	@AfterClass
	public void closeAllTestResourses() {
		for (WebDriver webDriverInstance : Drivers.webBrowserInstanses) {
			webDriverInstance.close();
		}

		Drivers.webBrowserInstanses.clear();
	}
}
