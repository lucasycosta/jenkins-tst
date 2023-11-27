package com.testejar.testjarjenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/home")
public class RootController {

	
	@GetMapping
	public String hello() {
		return "Hello Worlddddd!";
	}

}
