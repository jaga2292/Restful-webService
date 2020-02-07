package com.restful.webservice.restfulwebservices.users;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	//User findByidBithDate(Integer id,Date birthDate);
}
