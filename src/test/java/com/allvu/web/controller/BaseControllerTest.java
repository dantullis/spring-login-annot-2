/**
 * 
 */
package com.allvu.web.controller;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dan tullis
 *
 */
public class BaseControllerTest {
	
	BaseController bc = new BaseController();

	/**
	 * Run exactly once before any tests in this class
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Run exactly once after any tests in this class
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Run before each method execution
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Run after each method execution
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.allvu.web.controller.BaseController#welcomePage()}.
	 */
	@Test
	public void testWelcomePage() {
		Assert.assertEquals(bc.welcomePage().getViewName(), "index");
	}

	/**
	 * Test method for {@link com.allvu.web.controller.BaseController#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		Assert.assertEquals(bc.login("error", "logout").getViewName(), "login");		
	}
	
	
	/**
	 * Test method for {@link com.allvu.web.controller.BaseController#adminPage()}.
	 */
	@Test
	public void testAdminPage() {
		Assert.assertEquals(bc.adminPage().getViewName(), "admin");
	}	
}
