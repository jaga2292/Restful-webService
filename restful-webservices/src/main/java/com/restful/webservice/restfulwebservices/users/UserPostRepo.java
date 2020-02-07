package com.restful.webservice.restfulwebservices.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepo extends JpaRepository<Post, Integer> {

	
}
