package com.Stars.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stars.app.entidades.Perfil;
import com.Stars.app.repository.PerfilRepository;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	// Obtener todos los perfiles
    @GetMapping
    public ResponseEntity<List<Perfil>> getAllPerfil() {
        List<Perfil> perfil = perfilRepository.findAll();
        return ResponseEntity.ok(perfil);
    }
    
 // Obtener un perfil por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable String id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo perfil
    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilRepository.save(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPerfil);
    }

    // Actualizar un perfil existente
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable String id, @RequestBody Perfil perfil) {
        if (!perfilRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        perfil.setId(id);
        Perfil perfilActualizado = perfilRepository.save(perfil);
        return ResponseEntity.ok(perfilActualizado);
    }

    // Eliminar un perfil por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable String id) {
        if (!perfilRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        perfilRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
