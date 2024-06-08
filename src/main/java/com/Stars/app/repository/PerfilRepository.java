package com.Stars.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Stars.app.entidades.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String>{
	Perfil findByNombreUsuario(String nombreUsuario);
}