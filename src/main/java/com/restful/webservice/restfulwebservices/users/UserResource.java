package com.restful.webservice.restfulwebservices.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservice.restfulwebservices.DTO.UsersDTO;

@RestController
public class UserResource {

	@Autowired
	UserDao userDao;
	
	@GetMapping(path ="/Users")
	public List<User> getAll(){
		return userDao.findAll();
	}
	 
	
	
	@GetMapping(path ="/Users/{id}")
	public User getAll(@PathVariable int id){
		return userDao.findOne(id);
	}
	
	@PostMapping(path = "/usercreate")
	public void createUser(@RequestBody User user) {
		System.out.println(user+"*****************");
		userDao.save(user);
	}
	
}
