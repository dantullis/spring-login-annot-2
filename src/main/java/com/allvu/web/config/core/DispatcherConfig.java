package com.allvu.web.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Register a DispatcherServlet configured with annotated classes, e.g. Spring's @Configuration classes. 
 * @author dan tullis
 *
 */
public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Specify @Configuration and/or @Component classes to be provided to the root application context.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfig.class };
	}

	/**
	 * Specify @Configuration and/or @Component classes to be provided to the dispatcher servlet application context.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * Specify the servlet mapping(s) for the DispatcherServlet, e.g. '/', '/app', etc.
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}