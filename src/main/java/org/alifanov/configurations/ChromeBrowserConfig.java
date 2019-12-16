package org.alifanov.configurations;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserConfig {

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		options.addArguments("--window-size=500,600");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");

		chromePrefs.put("profile.default_content_settings.popups", false);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);

		options.setExperimentalOption("prefs", chromePrefs);

		return options;
	}

}
