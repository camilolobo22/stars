package com.Stars.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Stars.app.entidades.Calificacion;
import com.Stars.app.entidades.Estudiante;




public interface CalificacionRepository extends MongoRepository<Calificacion, String>{
	Calificacion findByEstudiante(Estudiante estudiante);
}
