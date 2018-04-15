package com.netapp.ads.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContext {

	private static ApplicationContext ctx;

	public static void setApplicationContext(ApplicationContext applicationContext) {

		ctx = applicationContext;

	}

	public static ApplicationContext getApplicationContext() {

		return ctx;

	}
}