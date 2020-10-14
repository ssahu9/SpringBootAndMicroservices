package com.sumit.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
	public String helloLocale() {
		return messageSource.getMessage("good", null, LocaleContextHolder.getLocale());
	}
}
