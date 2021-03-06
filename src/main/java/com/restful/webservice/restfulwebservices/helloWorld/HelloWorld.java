package com.restful.webservice.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world bean");
	}
	@GetMapping(path = "/hello-world-bean/pathvaribale/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean( String.format("Hello world bean, %s",name));
	}
}
