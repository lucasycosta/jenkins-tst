package com.testejar.testjarjenkins.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testejar.testjarjenkins.domain.Usuario;
import com.testejar.testjarjenkins.repository.UsuarioRepository;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Timed(value = "usuario.timed")
	@Counted(value = "usuario.counted")
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Counted(value = "usuarioBuscar.counted")
	public List<Usuario> buscar(){
		return usuarioRepository.findAll();
	}
}
