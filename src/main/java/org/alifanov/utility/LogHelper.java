package org.alifanov.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogHelper {

	public static <T> Logger getLogger(Class<T> c) {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/properties/logs.properties");
		return Logger.getLogger(c);
	}
}
