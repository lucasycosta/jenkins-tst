package com.testejar.testjarjenkins.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@SuppressWarnings("serial")
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario implements Serializable{
	
	@Id
	@Column(name="id_usuario")
	private Long id;

	@Column(name="nome")
	private String nome;
}
