package com.testejar.testjarjenkins.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testejar.testjarjenkins.domain.Usuario;
import com.testejar.testjarjenkins.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Usuario cadastrar(@RequestBody @Valid Usuario usuario) {
		System.out.println("usuario");
		return usuarioService.cadastrar(usuario);
	}
	
	@GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> buscar(){
		return usuarioService.buscar();
	}
}
