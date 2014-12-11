package com.udcode.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

	private static Map<String, TeamService> serviceContainer = new HashMap<String, TeamService>();

	public static TeamService getService(final String serviceName) {
		return serviceContainer.get(serviceName);
	}

}
