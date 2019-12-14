package com.alifanov.configurations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.alifanov.enums.BrowserTypes;
import static com.alifanov.configurations.ChromeBrowserConfig.getChromeOptions;

import lombok.Getter;
import lombok.Setter;

public class Drivers {
	@Getter @Setter
	public static List<WebDriver> webBrowserInstanses = new ArrayList<WebDriver>();
	
	public final class WebDrivers
    {
		public @Getter @Setter WebDriver webBrowser;
	
        public WebDrivers(BrowserTypes browserType, String downloadPath)
        {
            switch (browserType)
            {
                case Chrome:
                	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                    this.webBrowser = new ChromeDriver(getChromeOptions(downloadPath));
                    break;
                case FireFox:
                	break;
                case Opera:
                	break;
                default:
                    break;
            }

            webBrowserInstanses.add(webBrowser);
        }
    }
}
