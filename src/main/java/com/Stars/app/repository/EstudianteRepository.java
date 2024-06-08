package com.Stars.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Stars.app.entidades.Estudiante;




public interface EstudianteRepository extends MongoRepository<Estudiante, String>{

	Estudiante findByNumeroDocumentoAndNumeroRegistro(String numeroDocumento, String numeroRegistro);
	Estudiante findByNumeroDocumento(String numeroDocumento);
	
}
