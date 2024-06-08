package com.Stars.app.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.Stars.app.entidades.Curso;

public interface CursoRepository extends MongoRepository<Curso, String> {
}
