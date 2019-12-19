package org.alifanov.configurations;

import static org.alifanov.configurations.ChromeBrowserConfig.getChromeOptions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.Getter;

public final class Drivers {

	public static List<WebDriver> webBrowserInstanses = new ArrayList<WebDriver>();

	private String pathToDriver = System.getProperty("user.dir") + "/./drivers/chromedriver.exe";
	@Getter private WebDriver webBrowser;

	public Drivers(String browserType) {
		switch (browserType) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", pathToDriver);
			this.webBrowser = new ChromeDriver(getChromeOptions());
			break;
		case "FireFox":
			break;
		case "Opera":
			break;
		default:
			break;
		}

		webBrowserInstanses.add(webBrowser);
	}
}
