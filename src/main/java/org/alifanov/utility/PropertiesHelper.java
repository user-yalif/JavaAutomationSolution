package org.alifanov.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
	public static Properties properties = PropertyLoader.loadProperties();

	private static class PropertyLoader {
		
		public static Properties loadProperties() {
			Properties prop = new Properties();

			try (InputStream input = new FileInputStream("./properties/configs.properties")) {

				prop.load(input);

			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return prop;
		}
	}
}
