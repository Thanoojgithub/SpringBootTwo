package com.impetus.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *Customized BasicErrorController
 * basically 2 cases :
 * 1. MVC controller
 * 2. REST API
 * 
 * we can override methods in both cases, with our user understandable message to UI
 * 
 */
public class CustomBasicErrorController extends BasicErrorController {
	
	static Logger LOG = LoggerFactory.getLogger(CustomBasicErrorController.class);

	public CustomBasicErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
		super(errorAttributes, errorProperties);
	}

	@RequestMapping("/error")
	public String error() {
		LOG.info("CustomBasicErrorController.error() - Something is wrong, please check the logs.");
		return "error";
	}

}
