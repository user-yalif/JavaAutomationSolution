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

		// To disable the pop-up for Password save

		chromePrefs.put("profile.default_content_settings.popups", false);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);

//            if (!downloadPath.isEmpty() || downloadPath == null)
//            {
//            	chromePrefs.put("download.default_directory", downloadPath);
//            }

		options.setExperimentalOption("prefs", chromePrefs);

		return options;
	}

}
