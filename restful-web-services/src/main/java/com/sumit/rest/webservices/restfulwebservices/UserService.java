package com.sumit.rest.webservices.restfulwebservices;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sumit.rest.webservices.restfulwebservices.model.UserModel;

@Service
public class UserService {

	public static List<UserModel> users = new ArrayList<>();
	public static List<Integer> ids = new ArrayList<>();
	static int id=-1;
	static {
		users.add(new UserModel(1,"Ram", new Date()));
		ids.add(++id);
		
		
	}
	
	public List<UserModel> getUser(){
		return users;
	}
	
	public UserModel saveUser(UserModel userModel) {
		userModel.setId(++id);
		users.add(userModel);
		ids.add(id);
		return userModel;
	}
	
	public UserModel getUser(Integer id) {
		if(ids.contains(id)) {
			return users.get(id);
		}
		return null;
	}
	
	
	
	
}
