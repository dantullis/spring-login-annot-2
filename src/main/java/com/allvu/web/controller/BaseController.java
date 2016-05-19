package com.allvu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Allows for implementation classes to be auto detected through classpath scanning
 * and setting the mapping path
 *  
 * @author dan tullis
 *
 */
@Controller
public class BaseController {

	/**
	 * Controller for root page that happens to be named "index.jsp".
	 * 
	 * DispatcherServlet supports GET, HEAD, POST, PUT, PATCH and DELETE only
	 * @return
	 */
	@RequestMapping(value = { "/","index"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("pageTitle", "Spring Security Annotated");
		model.addObject("pageHeading2", "Spring Security Annotated.");
		model.setViewName("index");
		return model;
	}

	/**
	 * Controller for restricted area(via SecurityConfig.java) that happens to route to "admin.jsp".
	 * @return
	 */
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("pageTitle", "Spring Security Annotated - Restricted Page");
		model.addObject("pageHeading2", "Spring Security Annotated - Restricted Page");
		model.setViewName("admin");

		return model;
	}

	/**
	 * Controller for login page and logout page.
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("pageTitle", "Spring Security Annotated - Custom Login Form");
		model.addObject("pageHeading2", "Spring Security Annotated - Custom Login Form");
		model.setViewName("login");

		return model;
	}
}