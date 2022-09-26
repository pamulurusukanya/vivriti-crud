package com.example.vivriti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vivriti.entity.User;
import com.example.vivriti.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

	}

	@GetMapping("/getAll")
	public List<User> findAll() {
		return userService.getAll();

	}

	@GetMapping("{uid}")
	public ResponseEntity<User> findById(@PathVariable("uid") int uid) {
		return new ResponseEntity<User>(userService.getById(uid), HttpStatus.OK);

	}

	@PutMapping("{uid}")
	public ResponseEntity<User> update(@PathVariable("uid") int uid, @RequestBody User user) {
		return new ResponseEntity<User>(userService.update(user, uid), HttpStatus.OK);

	}

	@DeleteMapping("{uid}")
	public ResponseEntity<String> delete(@PathVariable("uid") int uid){
		userService.deleteById(uid);
		return new ResponseEntity<String> ("User Deleted successfully" ,HttpStatus.OK);
	}
	

}
