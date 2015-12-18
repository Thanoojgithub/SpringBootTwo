package com.impetus.springboot.app;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @SpringBootApplication is a convenience annotation that adds all of the
 *                        following:
 * 
 ** @Configuration tags the class as a source of bean definitions for the
 *                application context.
 ** @EnableAutoConfiguration tells Spring Boot to start adding beans based on
 *                          classpath settings, other beans, and various
 *                          property settings. Normally you would
 *                          add @EnableWebMvc for a Spring MVC app, but Spring
 *                          Boot adds it automatically when it sees
 *                          spring-webmvc on the classpath. This flags the
 *                          application as a web application and activates key
 *                          behaviors such as setting up a DispatcherServlet.
 ** @ComponentScan tells Spring to look for other components, configurations, and
 *                services in the hello package, allowing it to find the
 *                GreetingController. The main() method - uses Spring Boot’s
 *                SpringApplication.run() method to launch an application. Did
 *                you notice that there wasn’t a single line of XML? No web.xml
 *                file either. This web application is 100% pure Java and you
 *                didn’t have to deal with configuring any plumbing or
 *                infrastructure.
 *
 */

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = "com.impetus.springboot")
public class Application {

	static Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		LOG.info("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = run.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}
