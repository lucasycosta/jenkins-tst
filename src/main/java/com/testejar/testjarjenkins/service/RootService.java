package com.testejar.testjarjenkins.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Counted;

@Service
public class RootService {

	@Counted(value = "test_service")
	public String hello() {
		String texto = "HELOOOOOOOOOOOOOOOOOOOOO";
		return texto;
	}
}
