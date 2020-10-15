package com.sumit.rest.webservices.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String desc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserModel  userModel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", desc=" + desc + ", userModel=" + userModel + "]";
	}
	
	
}
