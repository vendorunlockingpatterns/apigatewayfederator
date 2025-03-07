package org.vendorunlockingpatterns.apigatewayfederator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgfLoggerFactory {

	private AgfLoggerFactory() {
		// No instances for this class
	}

	public static AgfLogger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}

	public static AgfLogger getLogger(String name) {
		Logger logger = LoggerFactory.getLogger(name);
		return new AgfLogger(logger);
	}

}
