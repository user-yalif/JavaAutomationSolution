package org.alifanov.configurations;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserConfig {

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		options.addArguments("--window-size=500,730");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-plugins");
		options.addArguments("--no-sandbox");

//		chromePrefs.put("profile.default_content_setting_values.cookies", 2);
//		chromePrefs.put("profile.block_third_party_cookies", true);
		chromePrefs.put("profile.default_content_setting_values.notifications", 2);
		chromePrefs.put("profile.default_content_settings.popups", 2);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("credentials_enable_service", false);

		options.setExperimentalOption("prefs", chromePrefs);

		return options;
	}
}
