package com.restful.webservice.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.restful.webservice.restfulwebservices.users.*;
@RestController
public class UserJPAResource {

	@Autowired
	UserDao userDao;
	
	@GetMapping(path ="/Users")
	public List<User> getAll(){
		return userDao.findAll();
	}
	 
	
	
	@GetMapping(path ="/Users/{id}")
	public User getAll(@PathVariable int id){
		User check = userDao.findOne(id);
		if(check == null)
			throw new UserNotFoundExpcetion("/{id}"+id) ;
		return check;
	}
	
	@PostMapping(path = "/usercreate")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {		
		User saveUri = userDao.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(saveUri.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	//This is getting deleted by Array Index need to be deleted in Given 
	@DeleteMapping(path ="/Users/{id}")
	public void deleteById(@PathVariable int id){
		User delete = userDao.deleteById(id);
		if(delete == null)
			throw new UserNotFoundExpcetion("/{id}"+id) ;		
	}
	
}
