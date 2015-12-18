package com.impetus.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	static Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

	/**
	 * @param name
	 *            - @PathParam value
	 * @param model
	 *            - page scoped variable for UI page
	 * @return String - JSP page to be rendered
	 */
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name, Model model) {
		LOG.info("HelloWorldController.hello() : " + name);
		// model is like a page scope
		model.addAttribute("name", name);
		return "greeting";
	}


}
