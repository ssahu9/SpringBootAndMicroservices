package com.sumit.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilerController {

	@GetMapping(path="/filter")
	public List<CourseBean> getC(){
		return (Arrays.asList(new CourseBean("a","s","d"),new CourseBean("q","w","e")));
	}
	
}
