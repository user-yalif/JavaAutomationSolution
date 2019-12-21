package org.alifanov.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
	
	private final static String pathToProperties = "./properties/configs.properties";
	
	public static Properties properties = PropertyLoader.loadProperties();

	private static class PropertyLoader {	
		
		public static Properties loadProperties() {
			Properties properties = new Properties();

			try (InputStream input = new FileInputStream(pathToProperties)){

				properties.load(input);

			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return properties;
		}
	}
}
