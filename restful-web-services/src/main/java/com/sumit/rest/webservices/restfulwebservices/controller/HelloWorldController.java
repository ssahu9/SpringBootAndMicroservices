package com.sumit.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path="/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(path="/hello-locale")
	public String helloLocale(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good", null, locale);
	}
}
