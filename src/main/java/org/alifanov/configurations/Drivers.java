package org.alifanov.configurations;

import static org.alifanov.configurations.ChromeBrowserConfig.getChromeOptions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lombok.Getter;
import lombok.Setter;

public final class Drivers {

	@Getter @Setter public static List<WebDriver> webBrowserInstanses = new ArrayList<WebDriver>();

	@Getter @Setter public WebDriver webBrowser;

	public Drivers(String browserType) {
		switch (browserType) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./src/main/resourses/org/alifanov/drivers/chromedriver.exe");
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
