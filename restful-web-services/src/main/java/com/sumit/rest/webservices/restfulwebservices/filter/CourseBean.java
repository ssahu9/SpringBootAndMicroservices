package com.sumit.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//@JsonIgnoreProperties(value = {"field1","field2"})
public class CourseBean {

	private String field1;
	private String field2;
	@JsonIgnore
	private String field3;
	
}
