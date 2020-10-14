package com.sumit.rest.webservices.restfulwebservices.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserModel {
	
	private Integer id;
	private String name;
	private Date dob;

}
