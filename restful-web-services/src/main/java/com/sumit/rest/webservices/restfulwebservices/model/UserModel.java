package com.sumit.rest.webservices.restfulwebservices.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@ApiModel(description="All about USer Model")
@Entity
public class UserModel {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	@ApiModelProperty(notes="Date should be in the past")
	private Date dob;
	@OneToMany(mappedBy = "userModel")
	private List<Post> posts;
	public UserModel(Integer id, String name,
			Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	

}
