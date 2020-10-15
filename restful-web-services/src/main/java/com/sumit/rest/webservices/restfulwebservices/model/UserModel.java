package com.sumit.rest.webservices.restfulwebservices.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description="All about USer Model")
public class UserModel {
	
	private Integer id;
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	@ApiModelProperty(notes="Date should be in the past")
	private Date dob;

}
