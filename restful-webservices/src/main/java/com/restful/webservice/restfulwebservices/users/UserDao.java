package com.restful.webservice.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<>();

	private static int count = 3;

	static {
		users.add(new User(1, "jack", new Date()));
		users.add(new User(2, "jack", new Date()));
		users.add(new User(3, "jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {		
		if(user.getId() == null ) {
			user.setId(++count);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User use:users ) {
			if(use.getId() == id) {
				return use;
			}
		}
		return null;
	}
	
	//This is getting deleted by Array Index need to be deleted in Given Id
	public User deleteById(int id) {
		for(User use:users ) {
			if(use.getId() == id) {
				User rem = users.remove(id);
				return rem;
			}
		}
		return null;
	}	
	
}
