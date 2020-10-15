package com.sumit.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilerController {

	@GetMapping(path="/filter")
	public MappingJacksonValue getC(){
		CourseBean c = new CourseBean("a","s","d");
		SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterExceptFilter(new HashSet<>(Arrays.asList("field1","field2")));
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("CourseBeanFilter", filter);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(c);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
		 
	}
	
	
	@GetMapping(path="/filter-list")
	public MappingJacksonValue getCList(){
		List<CourseBean> c  = Arrays.asList( new CourseBean("a","s","d"), new CourseBean("q","w","r"));
 		SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterExceptFilter(new HashSet<>(Arrays.asList("field3")));
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("CourseBeanFilter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(c);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
		 
	}
}
