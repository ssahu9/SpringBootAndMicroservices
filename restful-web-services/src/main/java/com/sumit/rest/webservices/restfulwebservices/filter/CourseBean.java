package com.sumit.rest.webservices.restfulwebservices.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//Static filtering way 1
//@JsonIgnoreProperties(value = {"field1","field2"})  

//Dynamic filter
@JsonFilter("CourseBeanFilter")
public class CourseBean {

	private String field1;
	private String field2;
//	@JsonIgnore
//	Static filtering way 2
	private String field3;
	
}
