package com.allvu.web.config.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.allvu.web.config.security.SecurityConfig;

/**
 * Configuration: Indicates to "Spring framework" that this class
 * 		can be used as a source of bean definitions.
 * EnableWebMvc: Imports the Spring MVC configuration
 * ComponentScan: Directs "Spring framework" to scan the base 
 * 		packages for controllers, dispatchers, resolvers, ... 
 * @author dan tullis
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.allvu.web.*" })
@Import({ SecurityConfig.class })
public class ApplicationConfig {

	@Bean
	/**
	 * Sets the view resolver to use JSP pages/views
	 * @return
	 */
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
}