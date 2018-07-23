package com.webmonitor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.webmonitor.controller","com.webmonitor.restcontroller"})
@SpringBootApplication
public class WebMonitorApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebMonitorApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebMonitorApplication.class);
	}
}
