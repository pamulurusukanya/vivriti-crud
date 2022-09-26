package com.example.vivriti.service;

import java.util.List;

import com.example.vivriti.entity.User;

public interface UserService {
	
	User saveUser (User user);
	
	List<User> getAll();
	
	User getById (Integer uid);
	
	User update (User user ,Integer uid);
	
	void deleteById(Integer uid);
	

}
