package com.impetus.springboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.impetus.springboot.pojo.Greeting;

//@RestController = @Controller + @ResponseBody
@RestController
public class GreetingController {

	Logger LOG = LoggerFactory.getLogger(GreetingController.class);

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public String index() {
		LOG.info("GreetingController.index() - Greetings from Spring Boot!");
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public Greeting greeting(@PathVariable String name) {
		LOG.info("GreetingController.greeting() : " + name);
		return new Greeting(counter.incrementAndGet(), name);
	}

}
