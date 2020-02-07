package com.restful.webservice.restfulwebservices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.webservice.restfulwebservices.DTO.UsersDTO;

@RestController
@RequestMapping("/jpa")
public class UserResource {

	@Autowired
	UserDao userDao;

	@Autowired
	UserRepo userRepo;
	@Autowired
	UserPostRepo userPostRepo;

	@GetMapping(path = "/Users")
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@GetMapping(path = "/Users/{id}")
	public Optional<User> getAll(@PathVariable int id) {
		Optional<User> check = userRepo.findById(id);
		if (!check.isPresent())
			throw new UserNotFoundExpcetion("/{id}" + id);
		return check;
	}

	@PostMapping(path = "/usercreate")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user) {
		User saveUri = userRepo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(saveUri.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	// This is getting deleted by Array Index need to be deleted in Given
	@DeleteMapping(path = "/Users/{id}")
	public void deleteById(@PathVariable int id) {
		userRepo.deleteById(id);

	}

	@GetMapping(path = "/Users/{id}/post")
	public List<Post> retrieveAllUsers(@PathVariable int id){
		Optional<User> userCheck =  userRepo.findById(id);
		if(!userCheck.isPresent()) {
			throw new UserNotFoundExpcetion("/{id}"+id);
		}
		System.out.println("=============>"+userCheck.get().getPosts());
		return userCheck.get().getPosts();
	}
}
